package it.naturtalent.archiv.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.graphics.Image;


import it.naturtalent.e4.project.IExportAdapter;

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
		//return SWTResourceManager.getImage(this.getClass(), "/icons/full/elcl16/pin_view.gif"); //$NON-NLS-1$;
		return null;
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
		//return new ExportArchivAction();
		return null;
	}

}
