package it.naturtalent.archiv.ui.action;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.ui.dialogs.JournalArchivExportDialog;
import it.naturtalent.archiv.ui.dialogs.JournalArchivExportOperation;
import it.naturtalent.e4.project.expimp.ExpImportData;


/**
 * Diese Aktion wird wom Adapter 'JournalArchivExportAdapter' definiert und in 
 * it.naturtalent.e4.project.expimp.dialogs.Export Dialog via ContextInjectionFactory.make() instanziiert.
 * 
 * Die Action ruft den Dialog 'JournalArchivExportDialog' auf
 * mit dem die zu exportierenden Archive ausgeaehlt werden koennen. 
 * 
 * 'context' wird durch die Instanziierung in ContextInjectionFactory.make() in 
 * it.naturtalent.e4.project.expimp.dialogs.ExportDialog gesetzt.
 * 
 * @author dieter
 *
 */
public class JournalArchivExportAction extends Action
{	
	@Inject
	@Optional
	private IEclipseContext context;
	
	//private static final String ARCHIV_TABLENAME = "Archive";

	@Override
	public void run()
	{
		// mit den Dialog 'JournalArchivExportDialog' Zielfile und Exportprojekte definieren 
		JournalArchivExportDialog exportDialog = ContextInjectionFactory.make(JournalArchivExportDialog.class, context);
		if(exportDialog.open() == JournalArchivExportDialog.OK)
		{						
			String exportDirPath = exportDialog.getExportPath();
			if(StringUtils.isNotEmpty(exportDirPath))
			{
				File exportDir = new File(exportDirPath);
				if((exportDir.exists()) && (exportDir.isDirectory()))
				{					
					try
					{
						doExport(exportDir, exportDialog.getSelectedData());						
					} catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}				
			}
		}
	}

	// den Export mit einer running Operation durchfuhren
	private void doExport(File destFile, ExpImportData[] archives) throws Exception
	{
		// Progressdialog erzeugen und starten 
		JournalArchivExportOperation exportOperation = new JournalArchivExportOperation(destFile, archives);
		
		try
		{
			// Export ausfuehren
			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getDefault().getActiveShell());			
			dialog.setCancelable(true);
			dialog.run(true, true, exportOperation);
			
		} catch (InvocationTargetException e)
		{
			// Error
			Throwable realException = e.getTargetException();
			String message = realException.getMessage();
			message = StringUtils.isNotEmpty(message) ? message : "interner Fehler";
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Export Fehler", message);			
			return;
			
		} catch (InterruptedException e)
		{
			// Abbruch
			MessageDialog.openError(Display.getDefault().getActiveShell(), "Export Abbruch", "die Aktion wurde abgebrochen");
			return;
		}
	}
}
