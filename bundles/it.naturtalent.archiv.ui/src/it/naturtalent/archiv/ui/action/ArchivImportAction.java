package it.naturtalent.archiv.ui.action;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Archive;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.dialogs.ArchivImportDialog;
import it.naturtalent.e4.project.expimp.ExpImportData;
import it.naturtalent.e4.project.ui.parts.emf.NtProjectView;
import it.naturtalent.office.model.address.Kontakt;


public class ArchivImportAction extends Action
{

	@Inject
	@Optional
	private IEclipseContext context;
	
	@Inject @Optional protected IEventBroker eventBroker;

	@Override
	public void run()
	{	
		ArchivImportDialog importDialog = ContextInjectionFactory
				.make(ArchivImportDialog.class, context);
		
		if(importDialog.open() == ArchivImportDialog.OK)
		{
			doImport(importDialog.getSelectedData());
		}
	}
	
	
	/* 
	 * Die selektierten Archive werden importiert.
	 * 
	 * (non-Javadoc)
	 * @see it.naturtalent.e4.project.expimp.dialogs.AbstractImportDialog#doImport()
	 */
	public void doImport(ExpImportData [] selectedData)
	{
		// Containerelement
		Archive archive = ArchivUtils.getArchive();
		
		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(Display.getDefault().getActiveShell());				
		progressDialog.open();
		try
		{
			progressDialog.run(true, true, new IRunnableWithProgress()
			{
				@Override
				public void run(IProgressMonitor monitor)throws InvocationTargetException,InterruptedException
				{
					monitor.beginTask("Archive werden eingelesen",IProgressMonitor.UNKNOWN);
							
					for(ExpImportData expimpdata : selectedData)
					{
						Object obj = expimpdata.getData();
						if (obj instanceof Kontakt)
						{
							Kontakt kontakt = (Kontakt) obj;
							kontakteList.add(kontakt);
							monitor.worked(1);
						}
					}
					
					monitor.done();
				}
			});
		}
		catch(Exception e)
		{
			
		}

		progressDialog.close();	

		
		
	}	
	
	/*
	public void doImport(ExpImportData [] selectedData)
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
		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(Display.getDefault().getActiveShell());				
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
		//eventBroker.post(ArchivUtils.SELECT_ARCHIV_REQUEST, allImportOrdner.get(0));		
		//eventBroker.post(NtProjectView.UPDATE_PROJECTVIEW_REQUEST, allImportOrdner.get(0));

	}
	*/
	

}
