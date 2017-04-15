package it.naturtalent.archiv.ui.actions1;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;

import it.naturtalent.emf.model.Activator;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.emf.model.actions.DefaultModelActionDistributor;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

public class UndoModelAction extends DefaultModelAction
{
	private static EditingDomain domain;
	
	public UndoModelAction(StructuredViewer viewer)
	{
		super(viewer);	
		setImageDescriptor(Icon.COMMAND_UNDO.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setToolTipText("undo");		
	}

	@Override
	public void seteObject(EObject eObject)
	{		
		super.seteObject(eObject);
		domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
	}

	@Override
	public void run()
	{
		if (domain != null)
		{
			Command command = domain.getCommandStack().getUndoCommand();			
			Class cmdClass = command.getClass();
			
			String s1 = cmdClass.getName();
			String s2 = AddOrdnerAction.class.getName();
			
			if(StringUtils.equals(cmdClass.getName(), AddOrdnerAction.class.getName()))
			{
				System.out.println("Add Ordner");
			}
			
			// undo 
			domain.getCommandStack().undo();
			
			Activator.getEventBroker().send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, geteObject());
			
			/*
			setEnabled(domain.getCommandStack().canUndo());
			
			DefaultModelActionDistributor distributor =  getActionDestributor();
			distributor.setEnable(DefaultModelActionDistributor.SAVE_ACTION_ID, domain.getCommandStack().canUndo());
			*/
			
			
			
		}
	}
	
	

}
