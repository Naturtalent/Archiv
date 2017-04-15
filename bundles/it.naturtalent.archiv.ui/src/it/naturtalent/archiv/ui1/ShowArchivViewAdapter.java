package it.naturtalent.archiv.ui1;

import org.eclipse.swt.graphics.Image;

import it.naturtalent.application.IShowViewAdapter;
import it.naturtalent.archiv.ui.parts1.ArchivMasterDetailsView;
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
		return Icon.ICON_FOLDER.getImage(IconSize._16x16_DefaultIconSize);	
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
		return ArchivMasterDetailsView.Id;
	}

}
