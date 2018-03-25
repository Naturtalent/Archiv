package it.naturtalent.archiv.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EventObject;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.internal.client.model.changeTracking.commands.EMFStoreBasicCommandStack;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;

import it.naturtalent.archiv.model.archiv.Archive;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.e4.project.INtProject;
import it.naturtalent.e4.project.model.project.NtProject;
import it.naturtalent.e4.project.ui.Activator;
import it.naturtalent.e4.project.ui.emf.ProjectModelEventKey;
import it.naturtalent.e4.project.ui.navigator.ResourceNavigator;

public class ProjectPropertyWizardPage extends WizardPage
{
	/*
	 * Listener ueberwacht Aenderungen am Archiv
	 */
	private class ArchivCommandStackListener implements CommandStackListener
	{
		@Override
		public void commandStackChanged(EventObject event)
		{
			EMFStoreBasicCommandStack commandStack = (EMFStoreBasicCommandStack) event.getSource();
			Command command = commandStack.getMostRecentCommand();
			if(command instanceof SetCommand)				
			{
				// Aenderugen im Modell
				EStructuralFeature eStructuralFeature = ((SetCommand) command).getFeature();					
				if(StringUtils.equals(eStructuralFeature.getName(), ArchivUtils.FEATURE_REGISTERTYPE))
				{
					// RegisterTyp geaendert -> Refresh MasterTree (Ordner)
					List<Object> result = new ArrayList<Object>();
					result.addAll(command.getResult());
					eventBroker.post(ArchivUtils.REFRESH_MASTER_REQUEST, result.get(0));
					
					// Ordner selektieren
					eventBroker.post(ArchivUtils.SELECT_ORDNER_REQUEST, result.get(0));					
				}
			}

			if(command instanceof AddCommand)				
			{
				// neues Register
				AddCommand addCommand = (AddCommand) command;
				Collection<?>createResults = addCommand.getResult();
				Object createObj = createResults.iterator().next();
				if(createObj instanceof Register)
				//if(StringUtils.equals(addCommand.getText(), "Register"))
				{
					//Register aus dem Command extrahieren 
					Collection<?> collection = addCommand.getResult();						
					Object [] obj = collection.toArray();
					Register register = (Register) obj[0];
					
					// abhaengig vom Registertyp automatisch ein Wert vorbelegen
					Ordner ordner = (Ordner) register.eContainer();
					switch (ordner.getRegisterType())
					{
						case NUMERIC_TYPE:
							register.setNumericData(ArchivUtils.autoRegisterNumber(ordner,(short) 1));
							break;

						case LETTER_TYPE:
							register.setAlphaData(ArchivUtils.autoRegisterAlpha(ordner,"A"));
							break;
					}
					eventBroker.post(ArchivUtils.SELECT_REGISTER_REQUEST, register);
				}						
			}
			
			if(command instanceof CreateChildCommand)				
			{
				CreateChildCommand createCommand = (CreateChildCommand) command;					
				if(StringUtils.equals(createCommand.getText(), "Register"))
				{
					//Register aus dem Command extrahieren 
					Collection<?> collection = createCommand.getResult();						
					Object [] obj = collection.toArray();
					Register register = (Register) obj[0];
					
					// abhaengig vom Registertyp automatisch ein Wert vorbelegen
					Ordner ordner = (Ordner) register.eContainer();
					if (ordner != null)
					{
						switch (ordner.getRegisterType())
						{
							case NUMERIC_TYPE:
								register.setNumericData(ArchivUtils.autoRegisterNumber(ordner,(short) 1));
								break;

							case LETTER_TYPE:
								register.setAlphaData(ArchivUtils.autoRegisterAlpha(ordner,"A"));
								break;
						}
					}
					eventBroker.post(ArchivUtils.SELECT_REGISTER_REQUEST, register);
				}					
			}			

			
		}
	}
	private ArchivCommandStackListener archivCommandStackListener = new ArchivCommandStackListener();

	private Text projectNameText;
	
	private ArchivProjectProperty archivProjectProperty;
	
	private IEventBroker eventBroker;
	
	// das mit dem Wizard selektiertes Register
	//private Register withPageSelectedRegister;
	
	// das vom Navigator selektierte Projekt
	private String iProjectID;
	
	
	
	
	/**
	 * Create the wizard.
	 */
	public ProjectPropertyWizardPage()
	{
		super("wizardPage");
		setTitle("Register");
		setDescription("dem Projekt ein Register zuordnen");
		
		// ID des momentan im Navigator selektierten Projects ermitteln 
		MApplication currentApplication = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();
		EPartService partService = currentApplication.getContext().get(EPartService.class);
		MPart part = partService.findPart(ResourceNavigator.RESOURCE_NAVIGATOR_ID);							
		ESelectionService selectionService = part.getContext().get(ESelectionService.class);
		Object selObject = selectionService.getSelection();
		if((selObject != null) && (selObject instanceof IResource))
			iProjectID = ((IProject)((IResource)selObject).getProject()).getName();
		
		// ArchivCommandStackListenr aktivieren
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(Activator.getECPProject());
		EMFStoreBasicCommandStack commandStack = (EMFStoreBasicCommandStack) domain.getCommandStack();
		domain.getCommandStack().addCommandStackListener(archivCommandStackListener);

	}
	
	@PostConstruct
	public void postConstruct(IEventBroker eventBroker)
	{
		this.eventBroker = eventBroker;
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent)
	{
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Archive archive = ArchivUtils.getArchive();
		if(archive != null)
		{
			try
			{
				ECPSWTViewRenderer.INSTANCE.render(container, archive);
				eventBroker.post(ArchivUtils.SELECT_REGISTER_REQUEST, archivProjectProperty.getNtPropertyData());
			}
			catch (ECPRendererException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void dispose()
	{
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(Activator.getECPProject());
		EMFStoreBasicCommandStack commandStack = (EMFStoreBasicCommandStack) domain.getCommandStack();
		domain.getCommandStack().removeCommandStackListener(archivCommandStackListener);

		super.dispose();
	}

	/*
	public Register getSelectedRegister()
	{
		return selectedRegister;
	}
	*/

	public void setArchivProjectProperty(ArchivProjectProperty archivProjectProperty)
	{
		this.archivProjectProperty = archivProjectProperty;
	}
	
	/*
	@Inject
	@Optional
	public void handleModelChangedEvent(@UIEventTopic(ArchivUtils.REGISTER_SELECTION_EVENT) Register register)
	{
		// verhindert, dass 'handleModelChangedEvent' auf eine nicht mehr aktuelle WizardPage angewendet wird 
		if (archivProjectProperty != null)
		{
			this.selectedRegister = register;

			if (register != null)
			{
				String selectedProjectID = register.getProjectID();
				if (!StringUtils.equals(iProjectID, selectedProjectID))
					informChangeAssignmentDialog(selectedProjectID);
			}
		}
	}
	*/
	
	@Inject
	@Optional
	public void handleModelChangedEvent(@UIEventTopic(ArchivUtils.ARCHIVE_SELECTION_EVENT) Object selectedArchivEntry)
	{
		// verhindert, dass 'handleModelChangedEvent' auf eine nicht mehr aktuelle WizardPage angewendet wird 
		if (archivProjectProperty != null)
		{			
			archivProjectProperty.setSelectedRegister(null);
						
			if (selectedArchivEntry instanceof Register)
			{
				// ein Register wurde ausgewaehlt
				Register register = (Register) selectedArchivEntry;			
				archivProjectProperty.setSelectedRegister(register);
			}
		}
	}

	/*
	@Inject
	@Optional
	public void handleProjectModelChangedEvent(
			@UIEventTopic(ProjectModelEventKey.PROJECT_MODIFY_MODELEVENT) NtProject ntObject)
	{
		System.out.println("ProjectName"+ntObject.getName());
	}
	*/
	
	/*
	 * Info falls das selektierte Register bereits einem Project zugeordnet ist.
	 * 
	 */
	private void informChangeAssignmentDialog(String projectID)
	{
		if (StringUtils.isNotEmpty(projectID))
		{
			IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectID);
			if (iProject.exists())
			{
				String projectName = "undefined Project"; // $NON-NLS-N$
				try
				{
					projectName = iProject.getPersistentProperty(
							INtProject.projectNameQualifiedName);
				} catch (CoreException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				MessageDialog.openInformation(
						Display.getDefault().getActiveShell(),
						Messages.SelectRegisterAction_RegisterTitle,
						Messages.bind(
								Messages.SelectRegisterAction_InfoRegisterMessage,
								projectName));
			}
		}
	}

	

	public String getiProjectID()
	{
		return iProjectID;
	}

	@Override
	public void setVisible(boolean visible)
	{
		super.setVisible(visible);
		
		if(visible)
		{
		
		}
		else
		{
			
		}
	}
	
	/**
	 * Ermöglicht den Zugriff auf das Eingabefeld des Projektnamens im NtProjektWizard.
	 * 
	 * @param text
	 */
	@Inject
	@Optional
	public void handleModelChangedEvent(@UIEventTopic(ProjectModelEventKey.PROJECTNAME_WIZARDTEXTFIELD) Text text)
	{
		projectNameText = text;
	}


}
