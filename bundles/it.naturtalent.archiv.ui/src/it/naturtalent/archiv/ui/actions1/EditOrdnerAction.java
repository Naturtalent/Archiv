
package it.naturtalent.archiv.ui.actions1;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

import archive.Ordner;
import archive.Register;
import it.naturtalent.archiv.ui.dialogs1.OrdnerDialog;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

public class EditOrdnerAction extends DefaultModelAction
{

	public EditOrdnerAction(StructuredViewer viewer)
	{
		super(viewer);
		setImageDescriptor(Icon.COMMAND_EDIT.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setEnabled(false);
	}

	@Override
	public void run()
	{		
		if (eObject	instanceof Register)	
		{
			eObject = ((Register) eObject).eContainer();
						
			EditRegisterAction editRegisterAction = new EditRegisterAction(viewer);
			editRegisterAction.run();
			return;
			
		}
		else
			if (eObject	instanceof Ordner)
				eObject = (Ordner) eObject;
		
		if(eObject != null)
		{
			// mit dem 
			OrdnerDialog dialog = new OrdnerDialog(Display.getDefault().getActiveShell(), eObject);
			if (dialog.open() == Dialog.OK)
			{					
				//ECPHandlerHelper.saveProject(ecpProject);
				eventBroker.send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, eObject);
			}
			else
			{				
				undo();
			}			
		}		
	}

}
