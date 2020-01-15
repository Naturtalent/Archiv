package it.naturtalent.archiv.ui.action;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.Shell;

import it.naturtalent.archiv.ui.dialogs.ArchivExportDialog;
import it.naturtalent.e4.project.expimp.ExpImportData;

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

	public void doExport(String exportPath, ExpImportData[] selectedData)
	{
		System.out.println(exportPath+"  |   "+selectedData);
	}
	
}
