package it.naturtalent.archiv.ui;

import it.naturtalent.archiv.ui.action.ArchivImportAction;
import it.naturtalent.e4.project.IImportAdapter;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.graphics.Image;

/**
 * Mit diesem Adapter wird die Import-Funktionalitaet in der Application angemeldet
 * 
 * @author dieter
 *
 */
public class ImportArchivAdapter implements IImportAdapter
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
	public String getContext()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessage()
	{
		return "Archivdaten importieren";
	}

	@Override
	public Action getImportAction()
	{		
		return new ArchivImportAction();
	}

}
