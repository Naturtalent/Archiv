 
package it.naturtalent.archiv.ui.action;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.parts.ArchivView;

import java.util.List;

import org.eclipse.e4.core.di.annotations.CanExecute;

public class SaveAction
{
	@Execute
	public void execute(EModelService modelService, MPart part)
	{
		ArchivUtils.getArchivProject().saveContents();
		
		// ToolbarStatus triggern  
		List<MToolItem> items = modelService.findElements(part, ArchivView.SAVE_TOOLBAR_ID, MToolItem.class,null, EModelService.IN_PART);
		MToolItem item = items.get(0);
		item.setEnabled(false);
		
		items = modelService.findElements(part, ArchivView.UNDO_TOOLBAR_ID, MToolItem.class,null, EModelService.IN_PART);
		item = items.get(0);
		item.setEnabled(false);					
	}

	@CanExecute
	public boolean canExecute()
	{
		return ArchivUtils.getArchivProject().hasDirtyContents();
	}

}