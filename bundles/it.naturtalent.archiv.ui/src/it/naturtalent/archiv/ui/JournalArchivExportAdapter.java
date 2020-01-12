package it.naturtalent.archiv.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.graphics.Image;

import it.naturtalent.archiv.ui.action.JournalArchivExportAction;
import it.naturtalent.e4.project.IExportAdapter;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

/**
 * Adapter zum Einbinden der Exportaktion.
 * 
 * @author dieter
 *
 */
public class JournalArchivExportAdapter implements IExportAdapter
{
	@Override
	public String getLabel()
	{		
		return "Archive";
	}

	@Override
	public Image getImage()
	{
		return Icon.ICON_ARCHIV.getImage(IconSize._16x16_DefaultIconSize);		
	}

	@Override
	public String getCategory()
	{		
		return "Journal";
	}

	@Override
	public String getMessage()
	{		
		return "Archivdaten in Tabelle exportieren";
	}

	/*
	 * Instanziirung an dieser Stelle nicht erforderlich, Rueckgabe der Klasse wuerde genuegen.
	 */
	@Override
	public Action getExportAction()
	{				
		return new JournalArchivExportAction();
	}
	

}
