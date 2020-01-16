package it.naturtalent.archiv.ui.action;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;

import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Archive;
import it.naturtalent.archiv.ui.dialogs.ArchivExportDialog;
import it.naturtalent.e4.project.expimp.ExpImportData;
import it.naturtalent.e4.project.ui.emf.ExpImpUtils;

public class ArchivExportAction extends Action
{
	@Inject
	@Optional
	private IEclipseContext context;
	
	private Shell shell;
	
	@PostConstruct
	private void postConstruct(@Named(IServiceConstants.ACTIVE_SHELL) @Optional Shell shell)
	{
		this.shell = shell;
	}


	@Override
	public void run()
	{
		ArchivExportDialog exportDialog = ContextInjectionFactory.make(ArchivExportDialog.class, context);
		if(exportDialog.open() == ArchivExportDialog.OK)
		{
			String exportPath = exportDialog.getExportPath();
			ExpImportData[] selectedData = exportDialog.getSelectedData();
			if(StringUtils.isNotEmpty(exportPath) && ArrayUtils.isNotEmpty(selectedData))
				doExport(exportPath, selectedData);
		}
		super.run();	
	}

	
	/*
	 * Die ausgewaehlten Einzelarchive werden in einem neuerstellten Container 'Archive' eingetragen und
	 * dieser wird dann in einer Datei gespeichert.
	 */
	public void doExport(String exportPath, ExpImportData[] selectedData)
	{
		// Container Archive erstellen
		EClass loginClass = ArchivPackage.eINSTANCE.getArchive();
		Archive archive = (Archive) EcoreUtil.create(loginClass);
		archive.setName(FilenameUtils.getBaseName(exportPath));
		
		// die selektierten Einzelarchive im Container sammeln
		for(ExpImportData expImport : selectedData)
		{
			Object obj = expImport.getData();
			if (obj instanceof Archiv)
			{				
				Archiv archiv = (Archiv) obj;
				archive.getArchiv().add(EcoreUtil.copy(archiv));
			}			
		}
		
		// Container mit den Archiven in einer Datai speichern
		ExpImpUtils.saveEObjectToResource(archive, exportPath);	
	}
	
}
