package it.naturtalent.archiv.ui1;

import it.naturtalent.archiv.ui.ArchivProjectProperty;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.e4.project.INtProjectProperty;
import it.naturtalent.e4.project.INtProjectPropertyFactory;

/**
 * Die Classic-Variante 'ArchivNtProjectPropertyFactoryORG' wurde modifiziert und entspricht 
 * der aktuellen Variante in 'it.naturtalent.archiv.ui'.
 * 
 * @author dieter
 *
 */
public class ArchivNtProjectPropertyFactory implements INtProjectPropertyFactory
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
