package it.naturtalent.archiv.ui.importClassic;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;

import it.naturtalent.archiv.ui.ArchivProjectPropertyFactory;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.Messages;
import it.naturtalent.archiv.ui.Utils;
import it.naturtalent.e4.project.INtProjectPropertyFactory;
import it.naturtalent.e4.project.INtProjectPropertyFactoryRepository;
import it.naturtalent.e4.project.NtProjektPropertyUtils;
import it.naturtalent.e4.project.expimp.ExpImportData;
import it.naturtalent.e4.project.expimp.dialogs.AbstractImportDialog;
import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.model.archiv.RegisterType;




/**
 * Import LoginDaten, die noch im alten Format gespeichert wurden.
 * 
 * @author dieter
 *
 */
public class ArchivImportDialog extends AbstractImportDialog
{

	public static final String ARCHIV_PLUGIN_ID = "it.naturtalent.archiv.ui";
	
	private static final String ARCHIVCLASSIC_IMORTPATH_SETTING_KEY = "importclassicarchivpathsetting"; //$NON-NLS-N$ 
	
	@XmlRootElement(name="ArchivData")
	public static class JAXBLoginModel
	{
		public List<ArchivData>archivData;
	}

	//private @Inject @Optional ILoginDataFactory iLoginDataFactory;
	
	private @Inject @Optional ESelectionService selectionService;
	
	private @Inject @Optional INtProjectPropertyFactoryRepository ntProjektDataFactoryRepository;
	
	public ArchivImportDialog()
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void init()
	{		
		importSettingKey = ARCHIVCLASSIC_IMORTPATH_SETTING_KEY;		
		super.init();
	}

	public ArchivImportDialog(Shell parentShell)
	{
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void postConstruct(IEventBroker eventBroker)
	{
		this.eventBroker = eventBroker;
	}

	@Override
	public void readImportSource()
	{
		File sourceFile = new File(importPath);
		if(sourceFile.exists())
		{
			FileInputStream fis = null;
			try
			{
				fis = new FileInputStream(sourceFile);
				JAXBLoginModel jaxbModel = JAXB.unmarshal(fis, JAXBLoginModel.class);
				if(jaxbModel != null)
				{
					List<ExpImportData>lexpimpdata = new ArrayList<ExpImportData>();
					for(ArchivData archivData : jaxbModel.archivData)
					{
						ExpImportData expimpdata = new ExpImportData();
						expimpdata.setLabel(archivData.getLabel());
						expimpdata.setData(archivData);	
						lexpimpdata.add(expimpdata);
					}
					setModelData(lexpimpdata);
				}
				
			} catch (Exception e)
			{				
				MultiStatus info = new MultiStatus(ARCHIV_PLUGIN_ID, 1, Messages.bind(Messages.ArchivImportDialog_ImportError, importPath), null);
				info.add(new Status(IStatus.INFO, ARCHIV_PLUGIN_ID, 1, e.getMessage(), null));
				ErrorDialog.openError(getShell(), Messages.ArchivImportDialog_ImportError, null, info);
			}finally
			{
				try
				{
					fis.close();
				} catch (Exception e)
				{
				}
			}			
		}
	}

	@Override
	public void doImport()
	{		
		boolean imported = false;
		
		//ein Archiv fuer die importierten Objekte anlegen
		EClass archivClass = ArchivPackage.eINSTANCE.getArchiv();
		Archiv archiv = (Archiv) EcoreUtil.create(archivClass);
		archiv.setName("ImportArchiv");		
		EList<Ordner>ordners = archiv.getOrdner();
		
		// alle ArchivDaten (== Ordner) abarbeiten
		for(ExpImportData expImpData : selectedData)
		{
			Object obj = expImpData.getData();
			if (obj instanceof ArchivData)
			{
				ArchivData archivData = (ArchivData) obj;
				
				// einen Ordner mit Registertyp 'NUMERIC_TYPE' erzeugen
				EClass ordnerClass = ArchivPackage.eINSTANCE.getOrdner();
				Ordner ordner = (Ordner) EcoreUtil.create(ordnerClass);				
				ordner.setLabel(archivData.getLabel());
				ordner.setRegisterType(RegisterType.NUMERIC_TYPE);
				
				// die definierten ArchivItems (== Register) abarbeiten
				EList<Register>registers = ordner.getRegisters();
				for(ArchivItem item : archivData.getItems())
				{
					// Einzelregister erzeugen und Label uebernehmen 
					EClass registerClass = ArchivPackage.eINSTANCE.getRegister();
					Register register = (Register) EcoreUtil.create(registerClass);
					
					// fuerende Nummer aus dem Label entfernen und im Register eintragen
					String label = item.getLabel();
					String number = Utils.parseNumberToken(label);
					if(StringUtils.isNotEmpty(number))
					{
						String shortString = StringUtils.remove(number, '-');
						register.setNumericData(new Short(shortString).shortValue());
						label = StringUtils.substring(label, number.length());
					}
					register.setLabel(label);
					
					// NtProjectID ueberpruefen (existiert ein Bezug zu einem Projekt)
					String projectID = item.getProjekt();
					if (StringUtils.isNotEmpty(projectID))
					{
						IProject iProject = ResourcesPlugin.getWorkspace()
								.getRoot().getProject(projectID);
						if (iProject.exists())
						{
							// Archiv PropertyFactory im IProject-Datenbreich
							// speichern
							List<INtProjectPropertyFactory> ntProjectPropertiesFactories = NtProjektPropertyUtils
									.getProjectPropertyFactories(
											ntProjektDataFactoryRepository,iProject);
							ntProjectPropertiesFactories
									.add(new ArchivProjectPropertyFactory());
							NtProjektPropertyUtils.saveProjectPropertyFactories(
									projectID, ntProjectPropertiesFactories);
						}
					}
					
					register.setProjectID(item.getProjekt());
					registers.add(register);
				}
				
				ordners.add(ordner);				
			}			
		}
		
		// Das neue Archiv mit den Importdaten zum Modell hinzufuegen
		ArchivUtils.getArchive().getArchiv().add(archiv);
		ArchivUtils.getArchivProject().saveContents();
	}

	@Override
	public void removeExistedObjects(List<EObject> importObjects)
	{
		// TODO Auto-generated method stub
		
	}

}
