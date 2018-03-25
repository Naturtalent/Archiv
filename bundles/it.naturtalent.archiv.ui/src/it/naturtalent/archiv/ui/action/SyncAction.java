 
package it.naturtalent.archiv.ui.action;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;

import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.ui.parts.ArchivView;
import it.naturtalent.e4.project.IResourceNavigator;
import it.naturtalent.e4.project.model.project.NtProject;
import it.naturtalent.e4.project.ui.Activator;
import it.naturtalent.e4.project.ui.navigator.ResourceNavigator;
import it.naturtalent.e4.project.ui.parts.emf.NtProjectView;

public class SyncAction
{
	
	@Inject @Optional private IEventBroker eventBroker;	
	@Inject @Optional public EPartService partService;
	@Inject @Optional public EModelService modelService;
	
	private IProject iProject;
	
	@Execute
	public void execute()
	{
		if(iProject != null)
		{
			// ResourceNavigator suchen und Projekt selektiern
			StructuredSelection selection = new StructuredSelection(iProject);	
			
			// 'iProject' im ResourceNavigator selektieren
			ResourceNavigator navigator = (ResourceNavigator) Activator.findNavigator();
			navigator.setSelection(iProject);
			
			// 'NtProject' im NtView aktualisieren
			/*
			MApplication currentApplication = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();			
			MPart part = partService.findPart(NtProjectView.NTPROJECT_VIEW_ID);
			NtProjectView projectView = (NtProjectView) part.getObject();			
			NtProject ntProject = Activator.findNtProject(iProject.getName());
			projectView.showDetails(ntProject);
			*/
		}
	}

	/*
	 * 'canExecute' - kann nicht genutzt werden, da diese Funktion zeitlich vor 'handleSelection'
	 * aufgerufen wird 
	 */
	
	@Inject
	public void handleSelection(
			@Named(IServiceConstants.ACTIVE_SELECTION) @Optional Register register)
	{	
		// Toolbarstatus Sync updaten
		MPart mPart = partService.findPart(ArchivView.ARCHIVVIEW_ID);
		
		// sync - Toolbar
		List<MToolItem> items = modelService.findElements(mPart,
				ArchivView.SYNC_TOOLBAR_ID, MToolItem.class, null,
				EModelService.IN_PART);
		MToolItem item = items.get(0);
		item.setEnabled(false);

		if (register instanceof Register)	
		{
			String projectID = register.getProjectID();
			if(StringUtils.isNotEmpty(projectID))
			{
				iProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectID);				
				iProject = (iProject.exists()) ? iProject : null;				
				item.setEnabled(iProject != null);
			}
		}
	}

		
}