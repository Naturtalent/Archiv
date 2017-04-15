package it.naturtalent.archiv.ui;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.internal.events.EventBroker;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import it.naturtalent.emf.model.EMFModelUtils;


public class Activator implements BundleActivator
{

	public static final String PLUGIN_ID = "it.naturtalent.archiv.ui";
	
	private static BundleContext context;
	
	// Name des ECP Projekts indem alle Archive gespeichert werden
	public final static String ARCHIVPROJECTNAME = "Archiv";
	
	// Projekt, in dem alle Archive abgelegt sind
	private static ECPProject archivProject = null;

	static BundleContext getContext()
	{
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception
	{
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception
	{
		Activator.context = null;
	}
	
	public static  ECPProject getECPProject()
	{
		if(archivProject == null)
		{
			archivProject = ECPUtil.getECPProjectManager().getProject(Activator.ARCHIVPROJECTNAME);			
			if(archivProject == null)
			{
				// Projekt 'ARCHIVPROJECT' erzeugen
				archivProject = new EMFModelUtils().createProject(ARCHIVPROJECTNAME);
			}
			
			// provoziert die Addition 'ECPModelContextAdapter' zum root Notifiers des Providers
			ECPUtil.getECPProjectManager().getProjects();
		}
		return archivProject;
	}
	
	public static IEventBroker getEventBroker()
	{
		final MApplication currentApplication = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();
		return currentApplication.getContext().get(EventBroker.class);		
	}

	public static IEclipseContext getApplicationContext()
	{
		final MApplication currentApplication = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();
		return currentApplication.getContext();		
	}

	
}
