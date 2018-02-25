package it.naturtalent.archiv.ui;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.ui.action.SelectRegisterAction;
import it.naturtalent.archiv.ui.action.SelectRegisterAction1;
import it.naturtalent.e4.project.INtProject;
import it.naturtalent.e4.project.INtProjectProperty;
import it.naturtalent.e4.project.NtProject;

public class ArchivProjectProperty implements INtProjectProperty
{
	// ID des Projekts, auf das sich die Eigenschaft bezieht
	protected String ntProjectID;
		
	private Register register;
	
	private ProjectPropertyWizardPage archivWizardPage;
	
	/*
	public ArchivProjectProperty()
	{
		MApplication currentApplication = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();
		IEventBroker eventBroker = currentApplication.getContext().get(IEventBroker.class);
		eventBroker.subscribe(ArchivUtils.REGISTER_SELECTION_EVENT, new EventHandler()
		{			
			@Override
			public void handleEvent(Event event)
			{
				register = (Register) event.getProperty(IEventBroker.DATA);
				System.out.println(register);
				
			}
		});
	}
	*/

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
			// wurde mit dem Wizard  ein ZielRegister selektiert
			Register selectedRegister = archivWizardPage.getSelectedRegister();
			if(selectedRegister != null)
			{
				// ist dem selektierten Register bereits ein Projekt zugeordnet
				String selectedProjectID = selectedRegister.getProjectID();
				
				if(StringUtils.isEmpty(selectedProjectID))
				{
					// Normalfall: es wurde ein 'freies' Register ausgewaehlt
					
					// 'ntProjectID' wird eintragen
					selectedRegister.setProjectID(ntProjectID);
					
					// Name des Project als Label im Register eintragen
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
										
					// ist Project noch ein einem anderen Register eingetragen, dann dort loeschen
					Register checkRegister = ArchivUtils.findIProjectRegister(ntProjectID);
					if(checkRegister != null)
					{
						checkRegister.setProjectID(null);
						checkRegister.setLabel(null);
					}					
				}
				else
				{
					// im selektierten Register ist bereits eine ProjectID eingetragen 
					if (!StringUtils.equals(selectedProjectID, ntProjectID))
					{
						// Abfrage ueberschreiben erlaubt 
						if(confirmChangeAssignmentDialog(selectedProjectID))
						{
							// die bestehende Zuordnung ueberschreiben
							selectedRegister.setProjectID(ntProjectID);
							
							// Name des Project als Label im Register eintragen
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
	 * return 'true' - bestehende Zuordnung ueberschreiben
	 */
	private boolean confirmChangeAssignmentDialog(String projectID)
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
		// TODO Auto-generated method stub

	}

	@Override
	public Action createAction()
	{
		// TODO Auto-generated method stub
		return new SelectRegisterAction1();
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
	 * Abhaengig vom RegisterTyp wird die aktulle Registerinformation zuruckgegeben
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
	
}
