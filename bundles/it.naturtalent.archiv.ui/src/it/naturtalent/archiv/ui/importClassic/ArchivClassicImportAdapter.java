package it.naturtalent.archiv.ui.importClassic;

import it.naturtalent.e4.project.IImportAdapter;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.graphics.Image;



public class ArchivClassicImportAdapter implements IImportAdapter
{

	@Override
	public String getLabel()
	{		
		return "Archivdaten (Classic)";
	}

	@Override
	public Image getImage()
	{		
		return Icon.ICON_LOCK.getImage(IconSize._16x16_DefaultIconSize);		
	}

	@Override
	public String getContext()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Action getImportAction()
	{		
		return new ArchivImportAction();
	}

	@Override
	public String getMessage()
	{
		return "Arcivdaten importieren (Classic)";
	}

}
