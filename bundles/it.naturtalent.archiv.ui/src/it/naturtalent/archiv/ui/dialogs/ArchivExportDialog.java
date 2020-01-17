package it.naturtalent.archiv.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.widgets.Shell;

import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.Archive;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.e4.project.expimp.ExpImportData;
import it.naturtalent.e4.project.expimp.dialogs.AbstractExportDialog;
import it.naturtalent.e4.project.expimp.dialogs.AbstractExportDialog2;
import it.naturtalent.e4.project.expimp.dialogs.ExportDestinationComposite;

public class ArchivExportDialog extends AbstractExportDialog
{
	
	private static final String ARCHIVEXPORTPATH_SETTING_KEY = "exportarchivpathsetting"; //$NON-NLS-N$

	public ArchivExportDialog()
	{
		super(shell);
		exportSettingKey = ARCHIVEXPORTPATH_SETTING_KEY;
	}
	
	@Inject
	@Optional
	public void handleModelChangedEvent(@UIEventTopic(ExportDestinationComposite.EXPORTDESTINATION_EVENT) String exportPath)
	{
		this.exportPath = exportPath;		
	}
	
	@PostConstruct
	public void postConstruct(@ Named (IServiceConstants.ACTIVE_SHELL) @ Optional Shell shell)
	{
		this.shell = shell;
	}
	
	/*
	 * Initialisiert Viewer mit den zuexportierenten Daten.
	 * 
	 * (non-Javadoc)
	 * @see it.naturtalent.e4.project.expimp.dialogs.AbstractExportDialog#init()
	 */
	@Override
	protected void init()
	{			
		super.init(); // Exportpath aus Settings uebernehmen
		List<ExpImportData>lexpimpdata = new ArrayList<ExpImportData>();
		Archive archives = ArchivUtils.getArchive();
		EList<Archiv>archive = archives.getArchiv();
		for(Archiv archiv : archive)
		{
			ExpImportData expimpdata = new ExpImportData();
			expimpdata.setLabel(archiv.getName());
			expimpdata.setData(archiv);
			lexpimpdata.add(expimpdata);
		}
		setModelData(lexpimpdata);
	}
	


}
