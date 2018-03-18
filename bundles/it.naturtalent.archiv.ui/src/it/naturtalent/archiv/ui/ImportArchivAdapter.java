package it.naturtalent.archiv.ui;

import it.naturtalent.archiv.ui.action.ArchivImportAction;
import it.naturtalent.e4.project.IImportAdapter;

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
		//return SWTResourceManager.getImage(this.getClass(), "/icons/full/elcl16/pin_view.gif"); //$NON-NLS-1$;
		return null;
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
