package it.naturtalent.archiv.ui.action;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.ui.ArchivProjectProperty;
import it.naturtalent.archiv.ui.ProjectPropertyWizardPage;
import it.naturtalent.e4.project.ui.Activator;
import it.naturtalent.e4.project.ui.parts.emf.NtProjectView;

public class SelectRegisterAction1 extends Action
{

	private ArchivProjectProperty archivProjectProperty;
	
	private String iProjectID;
	
	public class ArchivProjectPropertyWizard extends Wizard
	{
		@Override
		public void addPages()
		{			
			archivProjectProperty = new ArchivProjectProperty();
			ProjectPropertyWizardPage projectPropertyWizardPage = (ProjectPropertyWizardPage) archivProjectProperty
					.createWizardPage();
			projectPropertyWizardPage.setArchivProjectProperty(archivProjectProperty);
			
			iProjectID = projectPropertyWizardPage.getiProjectID();
			archivProjectProperty.setNtProjectID(iProjectID);
			
			addPage(projectPropertyWizardPage);
		}

		@Override
		public boolean performFinish()
		{
			// TODO Auto-generated method stub
			return true;
		}
	}

	@Override
	public void run()
	{
		WizardDialog dialog = new WizardDialog(
				Display.getDefault().getActiveShell(),
				new ArchivProjectPropertyWizard());
		
		if(dialog.open() == WizardDialog.OK)
		{
			archivProjectProperty.commit();

			// ProjectView aktualisieren
			EObject eObject = Activator.findNtProject(iProjectID);
			MApplication currentApplication = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();
			IEventBroker eventBroker = currentApplication.getContext().get(IEventBroker.class);
			eventBroker.post(NtProjectView.UPDATE_PROJECTVIEW_REQUEST, eObject);
		}
	}

}
