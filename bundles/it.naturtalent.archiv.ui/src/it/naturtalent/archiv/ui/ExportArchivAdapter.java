package it.naturtalent.archiv.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.graphics.Image;

import it.naturtalent.archiv.ui.action.ArchivExportAction;
import it.naturtalent.e4.project.IExportAdapter;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

public class ExportArchivAdapter implements IExportAdapter
{

	@Override
	public String getLabel()
	{		
		return "Archiv";
	}

	@Override
	public Image getImage()
	{
		return Icon.ICON_ARCHIV.getImage(IconSize._16x16_DefaultIconSize);		
	}

	@Override
	public String getCategory()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage()
	{		
		return "Archivdaten exportieren";
	}

	@Override
	public Action getExportAction()
	{				
		return new ArchivExportAction();
	}

}
