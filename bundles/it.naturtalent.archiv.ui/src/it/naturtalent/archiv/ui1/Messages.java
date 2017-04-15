package it.naturtalent.archiv.ui1;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
	private static final String BUNDLE_NAME = "it.naturtalent.archiv.ui1.messages"; //$NON-NLS-1$

	public static String ArchivUtils_AddRegisterLabel;

	public static String ArchivUtils_NewRegisterLabel;

	public static String ArchivUtils_QuestionInsertRegistger;

	public static String WizardRegisterDialog_Message;

	public static String WizardRegisterDialog_Title;

	static
	{
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages()
	{
	}
}
