package it.naturtalent.archiv.ui.dialogs;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * Dialog zur Vorbereitung des Exports der relevanten Archivdaten in eine Tabelle. 
 *   
 * @author dieter
 *
 */
public class JournalArchivExportDialog extends ArchivExportDialog
{

	// DialogSettings Journal - Zielverzeichnis und (Project/Workingset - Settings)
	private static final String ARCHIVEXPORTPATH_SETTING_KEY = "journalexportarchivpathsetting"; //$NON-NLS-N$	

	/**
	 * 
	 */
	public JournalArchivExportDialog()
	{
		super();	
		exportSettingKey = ARCHIVEXPORTPATH_SETTING_KEY;
	}
	
	@Override
	protected Control createDialogArea(Composite parent)
	{
		Control control = super.createDialogArea(parent);		
		setMessage("die Inhalte der ausgewählten Archive in SpreedSheat-Tabellen im Exportverzeichnis speichern");
		return control;
	}
	
	@Override
	protected void init()
	{
		// Dateieingabefeld ausblenden - es soll nur ein Verzeichnis ausgewaehlt werden
		exportDestinationComposite.disposeFileWidget();
		super.init();
	}

}
