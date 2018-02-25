package it.naturtalent.archiv.ui.actions1;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.ui.dialogs1.NewArchivDialog;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;

/**
 * Diese Aktion ermoeglicht ueber einen Selektionsdialog die Auswahl welcher Elementtyp hinzugefuegt werden soll.
 * 
 * @author dieter
 *
 */
public class NewArchivAction extends DefaultModelAction
{
	
	private final static String REGISTER_ACTION_KEY = "Register";
	private final static String ORDNER_ACTION_KEY = "Ordner";
	
	private Map<String, DefaultModelAction>actionMap = new HashMap<String, DefaultModelAction>();
		
	public NewArchivAction(StructuredViewer viewer)
	{
		super(viewer);
		setImageDescriptor(Icon.COMMAND_ADD.getImageDescriptor(IconSize._16x16_DefaultIconSize));
		this.viewer = viewer;
	}

	@Override
	public void run()
	{
		NewArchivDialog dialog = new NewArchivDialog(Display.getDefault().getActiveShell());
		dialog.create();
		
		//actionMap.put("Archiv", new AddOrdnerAction(viewer));
		
		DefaultModelAction newOrdner = new AddOrdnerAction(viewer);
		actionMap.put(ORDNER_ACTION_KEY, new AddOrdnerAction(viewer));
				
		DefaultModelAction newRegister = new AddRegisterAction(viewer);
		actionMap.put(REGISTER_ACTION_KEY, newRegister);
		
		StructuredSelection selection = (StructuredSelection) viewer.getSelection();
		Object selObj = selection.getFirstElement();
		if(selObj instanceof Register)	
		{
			newRegister.seteObject(((Register)selObj).eContainer());
			dialog.setSelectedElement(REGISTER_ACTION_KEY);
		}

		if(selObj instanceof Ordner)		
			newRegister.seteObject((EObject) selObj);			

		
		dialog.setElements(actionMap.keySet().toArray(new String[0]));
		if(dialog.open() == NewArchivDialog.OK)
		{
			String key = dialog.getSelectedElement();
			DefaultModelAction action = actionMap.get(key);
			action.run();				
		}
	}
	
	

}
