package it.naturtalent.archiv.ui;

import it.naturtalent.archiv.ui1.ArchivNtProjectPropertyFactory;
import it.naturtalent.application.IShowViewAdapterRepository;
import it.naturtalent.e4.project.IExportAdapterRepository;
import it.naturtalent.e4.project.IImportAdapterRepository;
import it.naturtalent.e4.project.INewActionAdapterRepository;
import it.naturtalent.e4.project.INtProjectPropertyFactory;
import it.naturtalent.e4.project.INtProjectPropertyFactoryRepository;
import it.naturtalent.e4.project.ProjectDataAdapterRegistry;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

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
	private @Inject INtProjectPropertyFactoryRepository ntProjektDataFactoryRepository;

	/*
	@Inject
	@Optional
	private ESelectionService selectionService;
	*/
	
	@PostConstruct
	public void init()
	{		
		// Projektdataadapter mit ArchivModel
		/*
		ArchivDataProjectAdapter archivDataAdapter = ContextInjectionFactory.make(ArchivDataProjectAdapter.class, context);
		ProjectDataAdapterRegistry.addAdapter(archivDataAdapter);
		*/
			
		if(newWizardRepository != null)
			newWizardRepository.addNewActionAdapter(new NewArchivWizardAdapter());
		
		if(exportAdapterRepository != null)
			exportAdapterRepository.addExportAdapter(new ExportArchivAdapter());
		
		if(importAdapterRepository != null)
			importAdapterRepository.addImportAdapter(new ImportArchivAdapter());
		
		if(showViewAdapterRepository != null)
		{
			showViewAdapterRepository.addShowViewAdapter(new ShowArchivViewAdapter());
			showViewAdapterRepository.addShowViewAdapter(new it.naturtalent.archiv.ui1.ShowArchivViewAdapter());
		}
		
		if(ntProjektDataFactoryRepository != null)
		{
			List<INtProjectPropertyFactory>ntDataFactories = ntProjektDataFactoryRepository.getAllProjektDataFactories();
			ntDataFactories.add(new ArchivNtProjectPropertyFactory(E4Workbench.getServiceContext()));
		}
	}
	
}
