package it.naturtalent.archiv.ui;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.ui.action.SelectRegisterAction;
import it.naturtalent.archiv.ui.parts.ArchivView;
import it.naturtalent.e4.project.INtProject;
import it.naturtalent.e4.project.INtProjectProperty;
import it.naturtalent.e4.project.ui.emf.NtProjectPropertyFactory;
import it.naturtalent.e4.project.ui.emf.ProjectModelEventKey;
import it.naturtalent.e4.project.ui.navigator.ResourceNavigator;

/**
 * ArchivProjectProperty Adapter
 * 
 * @author dieter
 *
 */
public class ArchivProjectProperty implements INtProjectProperty
{
	// ID des Projekts, auf das sich die Eigenschaft bezieht
	protected String ntProjectID;
	
	// das ueber durch 'ntProjectID' definierte Register (ProjectPropertyData)
	private Register register;
	
	// die durch 'createWizardPage()' erzeugte WizardPage
	private ProjectPropertyWizardPage archivWizardPage;
	
	// dieses Register wurde im WizardPage fuer die Projektkopplung ausgewaehlt
	private Register selectedRegister = null;

	/* 
	 * Ueber die ProjectID wird das zugeordnete Register in den Adapter geladen.
	 * 
	 * (non-Javadoc)
	 * @see it.naturtalent.e4.project.INtProjectProperty#setNtProjectID(java.lang.String)
	 */
	@Override
	public void setNtProjectID(String ntProjectID)
	{
		this.ntProjectID = ntProjectID;		
		register = ArchivUtils.findIProjectRegister(ntProjectID);
	}

	@Override
	public String getNtProjectID()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getNtPropertyData()
	{		
		return register;
	}

	/* 
	 * 
	 * (non-Javadoc)
	 * @see it.naturtalent.e4.project.INtProjectProperty#setNtPropertyData(java.lang.Object)
	 */
	@Override
	public void setNtPropertyData(Object eObject)
	{
		register = null;
		if (eObject instanceof Register)
			register = (Register) eObject;
	}

	@Override
	public Object getPropertyContainer()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object init()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 
	 * Die ProjectID 'ntProjectID' wird in dem mit der Wizard selektierten Register eingetragen.
	 *   
	 * (non-Javadoc)
	 * @see it.naturtalent.e4.project.INtProjectProperty#commit()
	 */
	@Override
	public void commit()
	{
		if((StringUtils.isNotEmpty(ntProjectID)) && (archivWizardPage != null))
		{
			// ist Project 'ntProjectID' noch ein einem anderen Register eingetragen, dann dort loeschen
			Register checkRegister = ArchivUtils.findIProjectRegister(ntProjectID);
			if(checkRegister != null)
			{
				// alte Kopplung loesen
				checkRegister.setProjectID(null);
				checkRegister.setLabel(null);
			}					

			// wurde mit dem Wizard ein ZielRegister selektiert			
			if(selectedRegister != null)
			{
				// ist das selektierte Register bereits gekoppelt
				String selectedProjectID = selectedRegister.getProjectID();				
				if(StringUtils.isEmpty(selectedProjectID))
				{
					// Normalfall: es wurde ein 'freies' Register ausgewaehlt
					
					// Projekt-ID 'ntProjectID' wird eintragen (die eigentliche Kopplung)
					selectedRegister.setProjectID(ntProjectID);
					
					// Projekt-Name als Label im Register eintragen
					IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(ntProjectID);
					if(iProject.exists())
					{
						try
						{
							// bei gekoppelten Registern wird der Projektname uebernommen
							String name = iProject.getPersistentProperty(INtProject.projectNameQualifiedName);
							selectedRegister.setLabel(name);
							
						} catch (CoreException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					};								
				}
				else
				{
					// das selektierte Register ist bereits gekoppelt 
					if (!StringUtils.equals(selectedProjectID, ntProjectID))
					{
						// Abfrage 'bestehende Kopplung loesen ?' erlauben 
						if(confirmChangeLinkageDialog(selectedProjectID))
						{
							// die bestehende Kopplung ersetzen
							selectedRegister.setProjectID(ntProjectID);
							
							// Projektname als Label im Register eintragen
							IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(ntProjectID);
							if(iProject.exists())
							{
								try
								{
									// bei gekoppelten Registern wird der Projektname uebernommen
									String name = iProject.getPersistentProperty(INtProject.projectNameQualifiedName);
									selectedRegister.setLabel(name);
									
								} catch (CoreException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							};
						}
					}
				}
			}			
		}
		
	
		ECPHandlerHelper.saveProject(ArchivUtils.getArchivProject());
		
		// WizardPage wird ungueltig
		if(archivWizardPage != null)
			archivWizardPage.setArchivProjectProperty(null);			
		archivWizardPage = null;
	}

	
	
	
	public void commitOLD()
	{
		if((StringUtils.isNotEmpty(ntProjectID)) && (archivWizardPage != null))
		{
			// ist Project 'ntProjectID' noch ein einem anderen Register eingetragen, dann dort loeschen
			Register checkRegister = ArchivUtils.findIProjectRegister(ntProjectID);
			if(checkRegister != null)
			{
				checkRegister.setProjectID(null);
				checkRegister.setLabel(null);
			}					

			// wurde mit dem Wizard ein ZielRegister selektiert			
			if(selectedRegister != null)
			{
				// ist das selektierte Register bereits gekoppelt
				String selectedProjectID = selectedRegister.getProjectID();				
				if(StringUtils.isEmpty(selectedProjectID))
				{
					// Normalfall: es wurde ein 'freies' Register ausgewaehlt
					
					// Projekt-ID 'ntProjectID' wird eintragen (die eigentliche Kopplung)
					selectedRegister.setProjectID(ntProjectID);
					
					// Projekt-Name als Label im Register eintragen
					IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(ntProjectID);
					if(iProject.exists())
					{
						try
						{
							String name = iProject.getPersistentProperty(INtProject.projectNameQualifiedName);
							selectedRegister.setLabel(name);
							
						} catch (CoreException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					};								
				}
				else
				{
					// das selektierte Register ist bereits gekoppelt 
					if (!StringUtils.equals(selectedProjectID, ntProjectID))
					{
						// Abfrage 'bestehende Kopplung loesen ?' erlauben 
						if(confirmChangeLinkageDialog(selectedProjectID))
						{
							// die bestehende Kopplung ersetzen
							selectedRegister.setProjectID(ntProjectID);
							
							// Projektname als Label im Register eintragen
							IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(ntProjectID);
							if(iProject.exists())
							{
								try
								{
									String name = iProject.getPersistentProperty(INtProject.projectNameQualifiedName);
									selectedRegister.setLabel(name);
									
								} catch (CoreException e)
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							};
						}
					}
				}
			}			
		}
		
	
		ECPHandlerHelper.saveProject(ArchivUtils.getArchivProject());
		
		// WizardPage wird ungueltig
		if(archivWizardPage != null)
			archivWizardPage.setArchivProjectProperty(null);			
		archivWizardPage = null;
	}


	/*
	 * return 'true' - bestehende Projektzuordnung ueberschreiben
	 */
	private boolean confirmChangeLinkageDialog(String projectID)
	{
		IProject iProject  = ResourcesPlugin.getWorkspace().getRoot().getProject(projectID);
		if(!iProject.exists())
			return true;
		
		String projectName = "undefined Project"; //$NON-NLS-N$
		try
		{
			projectName = iProject.getPersistentProperty(INtProject.projectNameQualifiedName);
		} catch (CoreException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  MessageDialog.openConfirm(
				Display.getDefault().getActiveShell(),
				Messages.SelectRegisterAction_RegisterTitle,
				Messages.bind(Messages.SelectRegisterAction_RegisterMessage, projectName));
	}

	@Override
	public IWizardPage createWizardPage()
	{
		IEclipseContext context = E4Workbench.getServiceContext();
		archivWizardPage  = ContextInjectionFactory.make(ProjectPropertyWizardPage.class, context);	
		archivWizardPage.setArchivProjectProperty(this);
		return archivWizardPage;
	}

	/* Alle Aenderungen rueckaengig machen und keinen 'DirtyContent' zuruecklassen
	 * (non-Javadoc)
	 * @see it.naturtalent.e4.project.INtProjectProperty#undo()
	 */
	@Override
	public void undo()
	{
		EditingDomain domain = AdapterFactoryEditingDomain
				.getEditingDomainFor(ArchivUtils.getArchivProject());
		while(domain.getCommandStack().canUndo())
			domain.getCommandStack().undo();
		ECPHandlerHelper.saveProject(ArchivUtils.getArchivProject());
		
		// WizardPage wird ungueltig
		if(archivWizardPage != null)
			archivWizardPage.setArchivProjectProperty(null);			
		archivWizardPage = null;

	}

	@Override
	public void delete()
	{		
	}

	@Override
	public Action createAction()
	{
		// TODO Auto-generated method stub
		return new SelectRegisterAction();
	}

	@Override
	public String getLabel()
	{				
		return "Archiv";
	}

	@Override
	public String toString()
	{				
		return getLabel()+"  :  "+getRegisterInfo();
	}
	
	/**
	 * Abhaengig vom RegisterTyp wird die aktuelle Registerinformation zuruckgegeben
	 * 
	 * @return
	 */
	private static final String UNDEFINED_REGISTERINFO = "";
	private String getRegisterInfo()
	{
		String stgRegister = "";
		String info = UNDEFINED_REGISTERINFO;
		if(register != null)
		{
			Ordner ordner = (Ordner) register.eContainer();
			info = "Ordner " + ordner.getLabel()+" : "+"Register ";
			switch (ordner.getRegisterType())
			{
				case NUMERIC_TYPE:
					NumberFormat numberFormatter = new DecimalFormat("##00");
					stgRegister = numberFormatter.format(register.getNumericData());
					break;
					
				case LETTER_TYPE:
					stgRegister = register.getAlphaData();
					break;
					
				case STRING_TYPE:
					stgRegister = register.getLabel();
					break;
									
				default:
					break;
			}
		}
		
		return info + stgRegister;
	}
	
	public Register getSelectedRegister()
	{
		return selectedRegister;
	}

	public void setSelectedRegister(Register selectedRegister)
	{
		this.selectedRegister = selectedRegister;
	}

	@Override
	public String getPropertyFactoryName()
	{		
		// Factoryname = diese Klasse + Extension 'Factory'
		return this.getClass().getName()
				+ NtProjectPropertyFactory.PROJECTPROPERTYFACTORY_EXTENSION;
	}

	@Override
	public void exportProperty()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void importProperty()
	{
		// TODO Auto-generated method stub
		
	}
	

	
}
