package it.naturtalent.archiv.ui1;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;

import it.naturtalent.e4.project.INtProjectProperty;
import it.naturtalent.e4.project.INtProjectPropertyFactory;
import it.naturtalent.e4.project.ui.NtProjectEventKeys;

public class ArchivNtProjectPropertyFactory implements INtProjectPropertyFactory
{

	private IEclipseContext context;
			
	private final static String ARCHIVPROJECTPROPERTYLABEL = "Archiv";
	
	@Inject
	public ArchivNtProjectPropertyFactory(IEclipseContext context)
	{
		super();
		this.context = context;		
	}

	@Override
	public INtProjectProperty createNtProjektData()
	{
		if(context != null)
		{
			ArchivProjectProperty projectData = ContextInjectionFactory.make(ArchivProjectProperty.class, context);	
			return (INtProjectProperty) projectData;
		}
					
		return null;
	}

	@Override
	public String getLabel()
	{		
		return ARCHIVPROJECTPROPERTYLABEL;
	}

}
