package it.naturtalent.archiv.ui.action;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.Messages;
import it.naturtalent.archiv.ui.dialogs.SelectRegisterDialog;
import it.naturtalent.archiv.ui.parts.ArchivView;
import it.naturtalent.e4.project.INtProjectProperty;
import it.naturtalent.e4.project.INtProjectPropertyFactoryRepository;
import it.naturtalent.e4.project.IResourceNavigator;
import it.naturtalent.e4.project.NtProjektPropertyUtils;
import it.naturtalent.e4.project.model.project.NtProject;
import it.naturtalent.e4.project.ui.Activator;
import it.naturtalent.e4.project.ui.parts.emf.NtProjectView;

/**
 * Aktion zur Erzeugung und Aufruf eines Dialogs mit dem ein bestimmtes Register selektiert werden kann. 
 * Dialog wird im ArchivView-Context erzeugt und hat somit die Moeglichkeit vom SelectionService zu profitieren.
 * Nachteil: ArchivView muss offensichtlich aktiviert werden damit der Context abgegriffen werden kann.
 *  
 * @author dieter
 *
 */
public class SelectRegisterActionOLD extends Action
{
	private @Inject INtProjectPropertyFactoryRepository ntProjektDataFactoryRepository;
	
	@Override
	public void run()
	{		
		
		/*
		IProject iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(${projectName});
			
		List<INtProjectProperty>projectProperties  = NtProjektPropertyUtils.getProjectProperties(
				ntProjektDataFactoryRepository, iProject);
			*/	
		
		MApplication application = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();
		EPartService partService = application.getContext().get(EPartService.class);
		
		MPart projectViewPart = partService.findPart(NtProjectView.NTPROJECT_VIEW_ID);
		NtProjectView ntProjectView = (NtProjectView) projectViewPart.getObject();
		NtProject selectedProject = (NtProject) ntProjectView.getSelectedNtProject();
		if (selectedProject != null)
		{
			MPart part = partService.findPart(ArchivView.ARCHIVVIEW_ID);
			partService.activate(part);
			IEclipseContext context = part.getContext();

			if (context != null)
			{
				// ein bereits dem Projekt zugeordnetes Register wird dem Dialog uebergeben
				Register assignedRegister = ArchivUtils.findIProjectRegister(selectedProject.getId());

				// SelectRegisterDialog erzeugen
				SelectRegisterDialog selectRegisterDialog = ContextInjectionFactory
						.make(SelectRegisterDialog.class, context);
				
				// dem Dialog das bereits zugeordnete Register uebergeben
				if(assignedRegister != null)
					selectRegisterDialog.setRegister(assignedRegister);

				// momentan aktivierten Context sichern und dann Dialog oeffnen
				IEclipseContext activeWindowContext = application.getContext().getActiveChild();
				if (selectRegisterDialog.open() == SelectRegisterDialog.OK)
				{
					Register selectedRegister = selectRegisterDialog.getRegister();	
					if((selectedRegister != null) && (!EcoreUtil.equals(assignedRegister, selectedRegister)))
					{
						// das zugeordnete und das selektierte Register unterscheiden sich
						if(StringUtils.isNotEmpty(selectedRegister.getProjectID()))
						{
							// dem selektierten Register ist ebenfalls bereits ein Projekt zugeordnet
							Register existRegister = ArchivUtils.findIProjectRegister(selectedRegister.getProjectID());
							if (!MessageDialog.openConfirm(
									Display.getDefault().getActiveShell(),
									Messages.SelectRegisterAction_RegisterTitle,
									Messages.bind(Messages.SelectRegisterAction_RegisterMessage, existRegister.getLabel())))
							{
								// Abbruch, die alte Zuordnung im selektierten Register beibehalten								
								selectedRegister = null;
							}
							else
							{
								// im 'alten' zugeordneten Register die ProjektID loeschen
								assignedRegister.setProjectID(null);
							}
						}
						
						if(selectedRegister != null)
						{
							// ProjektID in selektierten Register eintragen
							selectedRegister.setProjectID(selectedProject.getId());							
							ArchivUtils.getArchivProject().saveContents();
						}
					}
					
					/*
					// ist das selektierte Register noch frei
					Register selectedRegister = selectRegisterDialog.getRegister();	
					if((StringUtils.isNotEmpty(selectedRegister.getProjectID()) && 
						(!StringUtils.equals(selectedRegister.getProjectID(), projectRegister.getProjectID()))))
					{
						// das selektierte Register hat bereits eine ProjectID die nicht identisch ist
						// mit dem ProjektID
						Register existRegister = ArchivUtils.findIProjectRegister(selectedRegister.getProjectID());
						if (MessageDialog.openConfirm(
								Display.getDefault().getActiveShell(),
								Messages.SelectRegisterAction_RegisterTitle,
								Messages.bind(Messages.SelectRegisterAction_RegisterMessage, existRegister.getLabel())))
						{
							// die alte Zuordnung nicht aufheben
							//das selektierte Register kann nicht benutzt werden
							selectedRegister = null;
						}							
					}
					
					// 
					if((selectedRegister != null) && (!EcoreUtil.equals(projectRegister, selectedRegister)))
					{
						// ProjektID in Register eintragen
						selectedRegister.setProjectID(selectedProject.getId());
						
						ArchivUtils.getArchivProject().saveContents();
					}
					*/
					
					
				}

				// den aufrufenden Part 'NtProjectView.NTPROJECT_VIEW_ID' reaktivieren
				activeWindowContext.activate();
				MPart currentActivePart = partService.findPart(NtProjectView.NTPROJECT_VIEW_ID);
				partService.activate(currentActivePart);
			}
		}

	}
	

}
