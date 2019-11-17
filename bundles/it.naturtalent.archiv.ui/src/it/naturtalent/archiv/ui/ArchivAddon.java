package it.naturtalent.archiv.ui;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import it.naturtalent.application.IShowViewAdapterRepository;
import it.naturtalent.archiv.ui.importClassic.ArchivClassicImportAdapter;
import it.naturtalent.e4.project.IExportAdapterRepository;
import it.naturtalent.e4.project.IImportAdapterRepository;
import it.naturtalent.e4.project.INewActionAdapterRepository;
import it.naturtalent.e4.project.INtProjectPropertyFactory;
import it.naturtalent.e4.project.INtProjectPropertyFactoryRepository;

public class ArchivAddon
{	
	//@Optional @Inject IArchivFactory archivFactory;
	//@Inject @Optional private IEventBroker eventBroker;
	@Optional @Inject INewActionAdapterRepository newWizardRepository;
	@Inject @Optional IImportAdapterRepository importAdapterRepository;
	@Inject @Optional IExportAdapterRepository exportAdapterRepository;
	@Inject @Optional IEclipseContext context;
	@Inject @Optional IShowViewAdapterRepository showViewAdapterRepository;
	@Inject @Optional ESelectionService selectionService;
	
	// das zentrale ProjectPropertyRepository
	private @Inject
	static INtProjectPropertyFactoryRepository ntProjektDataFactoryRepository;

	/*
	@Inject
	@Optional
	private ESelectionService selectionService;
	*/
	
	@PostConstruct
	public void init(IEclipseContext context)
	{		
		// Projektdataadapter mit ArchivModel
		/*
		ArchivDataProjectAdapter archivDataAdapter = ContextInjectionFactory.make(ArchivDataProjectAdapter.class, context);
		ProjectDataAdapterRegistry.addAdapter(archivDataAdapter);
		*/
		
		//IEclipseContext context = E4Workbench.getServiceContext();
		INtProjectPropertyFactoryRepository ntProjektDataFactoryRepository = context.get(INtProjectPropertyFactoryRepository.class);
		List<INtProjectPropertyFactory>ntPropertyFactories = ntProjektDataFactoryRepository.getAllProjektDataFactories();
		ntPropertyFactories.add(new ArchivProjectPropertyFactory());

			
		if(newWizardRepository != null)
			newWizardRepository.addNewActionAdapter(new NewArchivWizardAdapter());
		
		if(exportAdapterRepository != null)
			exportAdapterRepository.addExportAdapter(new ExportArchivAdapter());
		
		if(importAdapterRepository != null)
		{
			importAdapterRepository.addImportAdapter(new ImportArchivAdapter());
			
			// Import Classicformat 
			importAdapterRepository.addImportAdapter(new ArchivClassicImportAdapter());
		}
		
		if(showViewAdapterRepository != null)
		{
			showViewAdapterRepository.addShowViewAdapter(new ShowArchivViewAdapter());
			
		}
		
		/*
		if(ntProjektDataFactoryRepository != null)
		{
			List<INtProjectPropertyFactory>ntDataFactories = ntProjektDataFactoryRepository.getAllProjektDataFactories();
			ntDataFactories.add(new ArchivNtProjectPropertyFactory());
		}
		*/
	}

	public static  INtProjectPropertyFactoryRepository getNtProjektDataFactoryRepository()
	{
		return ntProjektDataFactoryRepository;
	}
	
	
	
}
