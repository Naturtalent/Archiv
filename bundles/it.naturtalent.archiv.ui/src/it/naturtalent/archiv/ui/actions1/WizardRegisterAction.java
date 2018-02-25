package it.naturtalent.archiv.ui.actions1;

import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;


import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.dialogs1.WizardOrdnerDialog;
import it.naturtalent.archiv.ui.dialogs1.WizardRegisterDialog;
import it.naturtalent.archiv.ui1.ArchivViewEvent;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;

public class WizardRegisterAction extends DefaultModelAction
{

	// in diesen Ordner wird ein neues Register eingefuegt
	//private Ordner targetOrdner;
	private Register register;
	
	public WizardRegisterAction(StructuredViewer viewer)
	{
		super(viewer);
		setImageDescriptor(Icon.COMMAND_EDIT.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setEnabled(false);
	}
	

	@Override
	public void run()
	{		
		ECPProject ecpProject = ArchivUtils.getArchivProject();
					
		if (eObject	instanceof Register)
		{
			eObject = (Register) eObject;

			// editieren mit dem Wizarddialog
			WizardRegisterDialog dialog = new WizardRegisterDialog(
					Display.getDefault().getActiveShell(), (Register)eObject);
			if (dialog.open() == Dialog.OK)
			{
				ECPHandlerHelper.saveProject(ecpProject);

				// Broker informiert
				Ordner ordner = (Ordner) ((Register) eObject).eContainer();
				Object[] data = new Object[]{ ordner, null };
				Activator.getEventBroker().post(
						ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEORDNER, data);
				
				/*
				Object[] data = new Object[]{ eObject, null };
				Activator.getEventBroker().post(
						ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEREGISTER, data);
						*/
			}
			else
			{
				undo();
			}
		}
			
		if (eObject instanceof Ordner)
		{
			eObject = (Ordner) eObject;

			// mit dem
			WizardOrdnerDialog dialog = new WizardOrdnerDialog(
					Display.getDefault().getActiveShell(), eObject);
			if (dialog.open() == Dialog.OK)
			{
				ECPHandlerHelper.saveProject(ecpProject);

				// Broker informiert
				Object[] data = new Object[]
					{ eObject, null };
				Activator.getEventBroker().post(
						ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEORDNER, data);
			}
			else
			{
				undo();
			}
		}
		
	}

}
