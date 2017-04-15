package it.naturtalent.archiv.ui.actions1;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

import archive.Ordner;
import archive.Register;
import it.naturtalent.archiv.ui.dialogs1.RegisterDialog;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

public class EditRegisterAction extends DefaultModelAction
{

	public EditRegisterAction(StructuredViewer viewer)
	{
		super(viewer);
		setImageDescriptor(Icon.COMMAND_EDIT.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setEnabled(false);
	}

	@Override
	public void run()
	{
		StructuredSelection selection = (StructuredSelection) viewer.getSelection();
		Object selObject = selection.getFirstElement();		
		if (selObject	instanceof Register)
		{			
			Register register = (Register) selObject;			
			Ordner parentObject = (Ordner) register.eContainer();
			
			//RegisterDialog dialog = new RegisterDialog(Display.getDefault().getActiveShell(), eObject);
			RegisterDialog dialog = new RegisterDialog(
					Display.getDefault().getActiveShell(), parentObject, register);
			
			dialog.open();
			
			/*
			if(dialog.open() == RegisterDialog.OK) 
					eventBroker.send(ModelEventKeys.VIEWEVENT_UNDOMASTER, eObject);
					*/
			
			/*
			else 
			{
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(register);				
				if(domain != null)			
					while(domain.getCommandStack().canUndo())
						domain.getCommandStack().undo();
			}
			*/
		}		
	}
	
	

}
