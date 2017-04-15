package it.naturtalent.archiv.ui.actions1;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

import archive.Ordner;
import archive.Register;
import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui1.ArchivViewEvent;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import location.Adresse;

public class DeleteArchivAction extends DefaultModelAction
{

	public DeleteArchivAction(StructuredViewer viewer)
	{
		super(viewer);
		setImageDescriptor(Icon.COMMAND_DELETE.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setEnabled(false);
	}

	@Override
	public void run()
	{
		if (eObject	instanceof Ordner)
		{
			Ordner ordner = (Ordner) eObject;
			if(MessageDialog.openQuestion(Display.getDefault().getActiveShell(), "Ordner Löschen", ordner.getLabel()+ " löschen ?"))
			{				
				ECPProject ecpProject = Activator.getECPProject();
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(ecpProject);
				Command delCommand = DeleteCommand.create(domain, ordner);
				if(delCommand.canExecute())
				{
					List<Object> delObjects = new ArrayList<Object>();
					delObjects.add(eObject);
					ecpProject.deleteElements(delObjects);

					domain.getCommandStack().execute(delCommand);
					Activator.getEventBroker().send(ModelEventKey.DEFAULT_DELETE_MODELEVENT, eObject);
				}			
			}
			return;
		}
		
		if (eObject	instanceof Register)
		{
			Register register = (Register) eObject;			
			if(MessageDialog.openQuestion(Display.getDefault().getActiveShell(), "Register Löschen", register.getLabel()+ " löschen ?"))
			{
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
				Ordner ordner = (Ordner) domain.getParent(register);
				Command delCommand = DeleteCommand.create(domain, register);
				if(delCommand.canExecute())
				{					
					domain.getCommandStack().execute(delCommand);					
					eventBroker.send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, ordner);					
				}
			}
			return;
		}
		
		if (eObject	instanceof Adresse)
		{
			 EList<Object>elements = Activator.getECPProject().getContents();
			 elements.remove(eObject);
			 ECPHandlerHelper.saveProject(Activator.getECPProject());
			 Object [] data = new Object[]{eObject, null};					
			 Activator.getEventBroker().post(ArchivViewEvent.ARCHIV_VIEWEVENT_REMOVEORDNER, data);
		}		
		
	}
	
	

}
