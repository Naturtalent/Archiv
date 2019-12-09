package it.naturtalent.archiv.ui;

import org.eclipse.swt.graphics.Image;

import it.naturtalent.application.IShowViewAdapter;
import it.naturtalent.archiv.ui.parts.ArchivView;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

public class ShowArchivViewAdapter implements IShowViewAdapter
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
	public String partID()
	{		
		return ArchivView.ARCHIVVIEW_ID;
	}

}
