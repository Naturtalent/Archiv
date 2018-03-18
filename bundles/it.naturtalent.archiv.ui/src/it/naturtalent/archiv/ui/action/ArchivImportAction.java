package it.naturtalent.archiv.ui.action;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.action.Action;

import it.naturtalent.archiv.ui.dialogs.ArchivImportDialog;


public class ArchivImportAction extends Action
{

	@Inject
	@Optional
	private IEclipseContext context;

	@Override
	public void run()
	{	
		ArchivImportDialog importDialog = ContextInjectionFactory
				.make(ArchivImportDialog.class, context);
		importDialog.open();		
	}
}
