package it.naturtalent.archiv.ui.dialogs;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;

import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.ui.ArchivProjectProperty;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.e4.project.INtProjectPropertyFactory;
import it.naturtalent.e4.project.INtProjectPropertyFactoryRepository;
import it.naturtalent.e4.project.NtProjektPropertyUtils;
import it.naturtalent.e4.project.expimp.ExpImportData;
import it.naturtalent.e4.project.expimp.dialogs.AbstractImportDialog;
import it.naturtalent.e4.project.model.project.NtProject;
import it.naturtalent.e4.project.ui.navigator.ResourceNavigator;
import it.naturtalent.e4.project.ui.parts.emf.NtProjectView;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;


public class ArchivImportDialog extends AbstractImportDialog
{
	private static final String ARCHIVIMORTPATH_SETTING_KEY = "importarchivpathsetting"; //$NON-NLS-N$

	@Inject private INtProjectPropertyFactoryRepository ntProjektDataFactoryRepository;
	@Inject @Optional public IEventBroker eventBroker;
	
	private Archiv importArchiv;
	
	
	// Labelprovider mit der Moeglichkeit zum 'eingrauen' der Ordner 
	/*
	private class TableLabelProvider extends LabelProvider 
	{
		public Image getColumnImage(Object element, int columnIndex)
		{
			return Icon.ICON_PROJECT.getImage(IconSize._16x16_DefaultIconSize);
		}

		public String getText(Object element)
		{
			if(element instanceof ExpImportData)
			{		
				if(checkBoxTableViewer.getGrayed(element))
				{
					Display display = getShell().getDisplay();					
					Color gray = display.getSystemColor(SWT.COLOR_GRAY);					
					TableItem tableItem = (TableItem) checkBoxTableViewer.testFindItem(element);
					tableItem.setForeground(gray);
				}
				
				return ((ExpImportData)element).getLabel();
			}
			
			return element.toString();
		}
	}
	*/

	
	
	@Override
	protected void init()
	{		
		importSettingKey = ARCHIVIMORTPATH_SETTING_KEY;		
		super.init();
	}

	
	
	@Override
	protected Control createDialogArea(Composite parent)
	{
		// TODO Auto-generated method stub
		Control control = super.createDialogArea(parent);
		checkBoxTableViewer.setLabelProvider(new GrayedTableLabelProvider());		
		
		// Ordner mit gekoppelten Registern 'eingrauen'
		disableOrdnerWithAssignedRegisters(lexpimpdata);

		checkBoxTableViewer.refresh();
		return control;
	}



	/* 
	 * Wird im Zuge der Initialisierung aufgerufen (einlesen Resource des SettingImportPfad)
	 * oder nach der Auswahl der Quelldatei im Dialog.
	 * 
	 * (non-Javadoc)
	 * @see it.naturtalent.e4.project.expimp.dialogs.AbstractImportDialog#readImportSource()
	 */
	@Override
	public void readImportSource()
	{
		URI fileURI = URI.createFileURI(importPath);		
		ResourceSet resourceSet = new ResourceSetImpl();

		Resource resource = resourceSet.getResource(fileURI, true);
		EList<EObject>eObjects = resource.getContents();
		
		importArchiv = (Archiv) eObjects.get(0);
		setTitle("Archiv: "+importArchiv.getName());
		
		// alle Ordner des selektierten Archivs einlesen
		lexpimpdata = new ArrayList<ExpImportData>();
		EList<Ordner>ordners = importArchiv.getOrdner();
		for(Ordner ordner : ordners)
		{			 
			ExpImportData expimpdata = new ExpImportData();
			expimpdata.setLabel(ordner.getLabel());
			expimpdata.setData(ordner);
			lexpimpdata.add(expimpdata);
		}
		
		// Ordner mit gekoppelten Registern 'eingrauen'
		//disableOrdnerWithAssignedRegisters(lexpimpdata);
		setModelData(lexpimpdata);		
	}
	
	/*
	 * Alle Import-Ordner disablen (ausgrauen) die mindestens ein Register haben, dass mit einem
	 * Projekt gekoppelt ist dieses Projekt aber bereits durch ein existierendendes 
	 * Register gekoppelt ist. 
	 */
	private void disableOrdnerWithAssignedRegisters(List<ExpImportData>lexpimpdata)
	{
		for(ExpImportData lexpimp : lexpimpdata)
		{
			Ordner ordner = (Ordner) lexpimp.getData();
			for(Register register : ordner.getRegisters())
			{
				String iProjectID = register.getProjectID();
				if(StringUtils.isNotEmpty(iProjectID))
				{
					// gekoppeltes Projekt
					IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(iProjectID);
					if(iProject.exists())
					{						
						if(ArchivUtils.findIProjectRegister(iProject.getName()) != null)
							checkBoxTableViewer.setGrayed(lexpimp, true);
						break;						
					}
				}				
			}
		}
	}

	/* 
	 * Die selektierten Ordner werden importiert.
	 * 
	 * (non-Javadoc)
	 * @see it.naturtalent.e4.project.expimp.dialogs.AbstractImportDialog#doImport()
	 */
	@Override
	public void doImport()
	{
		// die selektierten Ordner in einer Liste zusammenfassen
		final List<Ordner>allImportOrdner = new ArrayList<Ordner>();
		for(ExpImportData expimpdata : selectedData)
		{
			Object obj = expimpdata.getData();
			if (obj instanceof Ordner)
				allImportOrdner.add((Ordner)obj);		
		}
		
		// Importdaten ueber einen ProgressDialog einlesen
		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(
				Display.getDefault().getActiveShell());				
		progressDialog.open();
		try
		{
			progressDialog.run(true, true, new IRunnableWithProgress()
			{
				@Override
				public void run(IProgressMonitor monitor)throws InvocationTargetException,InterruptedException
				{
					monitor.beginTask("Archivdaten werden eingelesen",IProgressMonitor.UNKNOWN);
							
					// Archiv hinzufuegen
					EClass archivClass = ArchivPackage.eINSTANCE.getArchiv();
					Archiv archiv = (Archiv)EcoreUtil.create(archivClass);					
					EList<Archiv>archive = ArchivUtils.getArchive().getArchiv();					
										
					// die selektierten Ordner hinzufuegen
					archiv.getOrdner().addAll(allImportOrdner);
					archive.add(archiv);
					
					monitor.done();
				}
			});
		}
		catch(Exception e)
		{
			
		}

		progressDialog.close();	
		eventBroker.post(ArchivUtils.REFRESH_MASTER_REQUEST, null);
		eventBroker.post(ArchivUtils.SELECT_ARCHIV_REQUEST, allImportOrdner.get(0));		
		eventBroker.post(NtProjectView.UPDATE_PROJECTVIEW_REQUEST, allImportOrdner.get(0));

	}
	
	// Name des ArchivPropertyFactory
	private String ArchivPropertyFactoryName = ArchivProjectProperty.class.getName()
			+ INtProjectPropertyFactory.PROJECTPROPERTYFACTORY_EXTENSION;
	
	@Override
	public void removeExistedObjects(List<EObject> importObjects)
	{
		// TODO Auto-generated method stub
	}
	
	
}
