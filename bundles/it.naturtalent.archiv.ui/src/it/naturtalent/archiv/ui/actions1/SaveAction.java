package it.naturtalent.archiv.ui.actions1;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.jface.viewers.StructuredViewer;

import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

public class SaveAction extends DefaultModelAction
{

	public SaveAction(StructuredViewer viewer)
	{
		super(viewer);
		setImageDescriptor(Icon.COMMAND_SAVE.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		setToolTipText("speichern");
	}
	
	//@Override
	public void run()
	{		
		ECPHandlerHelper.saveProject(ArchivUtils.getArchivProject());

		EObject eObject = geteObject();
		if(eObject != null)
			Activator.getEventBroker().send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, eObject);
	}

}
