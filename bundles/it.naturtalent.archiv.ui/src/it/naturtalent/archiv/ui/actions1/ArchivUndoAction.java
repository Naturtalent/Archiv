package it.naturtalent.archiv.ui.actions1;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;

import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

public class ArchivUndoAction extends DefaultModelAction
{

	private static Map<EObject,EditingDomain> domainEObjectMap = new HashMap<EObject, EditingDomain>();
	private static EObject domainObject;
	
	public ArchivUndoAction(StructuredViewer viewer)
	{
		super(viewer);
		setImageDescriptor(Icon.COMMAND_UNDO.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setToolTipText("undo");		
	}
	
	//@Override
	public void run()
	{
		if (domainObject != null)
		{
			EditingDomain domain = domainEObjectMap.get(domainObject);
			domain.getCommandStack().undo();
		}
	}
	
	public static void setEObject(EObject eObject)
	{
		domainObject = eObject;
	}
	

	public static EditingDomain addDomainObject (EObject eObject)
	{
		domainObject = eObject;
		if(!domainEObjectMap.containsKey(eObject))
			domainEObjectMap.put(eObject, AdapterFactoryEditingDomain.getEditingDomainFor(eObject));
		return domainEObjectMap.get(eObject);
	}
	
	public static boolean canUndo (EObject eObject)
	{
		if(eObject != null)
		{
			EditingDomain domain = domainEObjectMap.get(eObject);
			if(domain != null)
				return domain.getCommandStack().canUndo();
		}
		
		return false;
	}

}
