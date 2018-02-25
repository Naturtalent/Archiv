package it.naturtalent.archiv.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
	private static final String BUNDLE_NAME = "it.naturtalent.archiv.ui.messages"; //$NON-NLS-1$

	public static String ArchivImportDialog_ImportError;

	public static String ArchivDetailsComposite_TitleArchivDetails;

	public static String ArchivDetailsComposite_TitleOrdner;

	public static String ArchivDetailsComposite_TitleRegister;

	public static String ArchivProjectPropertyWizardPage_ArchivWizardMessage;

	public static String ArchivProjectPropertyWizardPage_ArchivWizardTitle;

	public static String DeleteArchivAction_ContactLabel;
	public static String DeleteArchivAction_MessageDelete;
	public static String DeleteArchivAction_ToolTip;

	public static String ExportArchivDialog_ExportError;	
	public static String ExportArchivDialog_ExportLabel;

	public static String ImportArchivDialog_ImportError;	
	public static String ImportArchivDialog_ImportLabel;
	
	public static String ExportArchivAction_ExportLabel;
	public static String ExportArchivAction_Qverwrite;
	public static String ArchivProjectPropertyWizardPage2_sctnNewSection_text;
	
	public static String SelectRegisterAction_RegisterMessage;
	public static String SelectRegisterAction_InfoRegisterMessage;

	public static String SelectRegisterAction_RegisterTitle;

	static
	{
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages()
	{
	}
}
