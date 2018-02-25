package it.naturtalent.archiv.ui;

import it.naturtalent.e4.project.INtProjectProperty;
import it.naturtalent.e4.project.INtProjectPropertyFactory;

public class ArchivProjectPropertyFactory implements INtProjectPropertyFactory
{

	public final static String ARCHIVPROJECTPROPERTYLABEL = "ArchivProjectProperties";
		
	
	@Override
	public INtProjectProperty createNtProjektData()
	{		
		return new ArchivProjectProperty();
	}

	@Override
	public String getLabel()
	{		
		return ARCHIVPROJECTPROPERTYLABEL;
	}

	@Override
	public String getParentContainerName()
	{		
		return ArchivUtils.ARCHIVPROJECTNAME;
	}

}
