package it.naturtalent.archiv.ui.dialogs;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class JournalArchivFinishDialog extends Dialog
{
	private Text textPathInfo;
	private Button btnDocumentOpen;
	
	private String destPath;
	
	private boolean isOpenFlag;

	/**
	 * Create the dialog.
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public JournalArchivFinishDialog(Shell parentShell)
	{
		super(parentShell);
	}
	

	public JournalArchivFinishDialog(Shell parentShell, String destPath)
	{
		super(parentShell);
		this.destPath = destPath;
	}


	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout gridLayout = (GridLayout) container.getLayout();
		gridLayout.numColumns = 2;
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label lblInfo = new Label(container, SWT.NONE);
		lblInfo.setText("die Archivdaten wurden gespeichert in:");
		new Label(container, SWT.NONE);
		
		textPathInfo = new Text(container, SWT.BORDER);
		textPathInfo.setEditable(false);
		textPathInfo.setEnabled(false);
		textPathInfo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		if(StringUtils.isNotEmpty(destPath))
			textPathInfo.setText(destPath);
		
		btnDocumentOpen = new Button(container, SWT.CHECK);
		btnDocumentOpen.setText("mit Libreoffice öffnen");

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,true);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(450, 300);
	}


	@Override
	protected void okPressed()
	{
		isOpenFlag = btnDocumentOpen.getSelection();
		super.okPressed();
	}


	public boolean isOpenFlag()
	{
		return isOpenFlag;
	}
	
	

}
