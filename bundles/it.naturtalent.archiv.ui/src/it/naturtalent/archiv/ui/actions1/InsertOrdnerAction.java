package it.naturtalent.archiv.ui.actions1;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;

import it.naturtalent.archiv.ui1.ArchivUtils;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;

/**
 * Aktion fuegt einem Ordner ein Register hinzu.
 * 
 * @author dieter
 *
 */
public class InsertOrdnerAction extends DefaultModelAction
{

	// das einzufuegende Register	
	private Register register;
	
	public InsertOrdnerAction(StructuredViewer viewer, Register register)
	{
		super(viewer);
		setImageDescriptor(Icon.ICON_PULL.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setToolTipText("Register in selektierten Ordner einfügen");
		setEnabled(false);
		this.register = register;
	}

	@Override
	public void run()
	{		
		StructuredSelection selection = (StructuredSelection) viewer.getSelection();
		Object selObject = selection.getFirstElement();
		if (selObject instanceof Ordner)
		{
			// dem selektierten Ordner wird ein neues Register 'register'
			// hinzugefuegt
			if (ArchivUtils.autoAddRegister((Ordner) selObject, register))
			{
				((TreeViewer) viewer).expandToLevel((Ordner) selObject, 1);
				viewer.reveal(register);
				viewer.setSelection(new StructuredSelection(register), true);
			}
		}
	}
	
}
