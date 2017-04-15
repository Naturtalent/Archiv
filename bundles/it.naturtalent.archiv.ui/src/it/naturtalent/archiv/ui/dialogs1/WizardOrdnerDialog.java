package it.naturtalent.archiv.ui.dialogs1;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import archive.Ordner;

/**
 * Ordnerdialog benutzt ViewModel 'OrdnerDefault.view' (nur Ordner ohne Register)
 * @author dieter
 *
 */
public class WizardOrdnerDialog extends TitleAreaDialog
{
	private EObject eObject;
		
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public WizardOrdnerDialog(Shell parentShell, EObject eObject)
	{
		super(parentShell);
		this.eObject = eObject;		
	}
	

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		setTitle("Wizard Ordner Dialog");				
		Composite area = null;
		try
		{
			area = (Composite) super.createDialogArea(parent);
			Composite container = new Composite(area, SWT.NONE);
			container.setLayout(new GridLayout(1, false));
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
			ECPSWTViewRenderer.INSTANCE.render(container, eObject);
						
		} catch (ECPRendererException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(518, 281);
	}
	
}
