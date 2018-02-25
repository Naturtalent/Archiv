package it.naturtalent.archiv.ui.dialogs1;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.spi.ui.ECPReferenceServiceImpl;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.model.VViewModelProperties;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Ordnerdialog benutzt ViewModel 'OrdnerDefault.view' (Ordner mit Register)
 * @author dieter
 *
 */
public class OrdnerDialog extends TitleAreaDialog
{
	// filtert ViewModel 'Ordner.view' (Ordner incl. Registers)
	public static final String ARCHIV_PROJECTID_FILTERKEY = "it.naturtalent.archiv.viewmodel.filter1";
	public static final String ARCHIV_PROJECTID_FILTERVALUE = "it.naturtalent.archiv.viewmodel.filter1";
	
	private EObject eObject;
	
	//private Ordner ordner;
		
	//private Map<String, Object>attributeMap;
	
	//private Log log = LogFactory.getLog(this.getClass());
	
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public OrdnerDialog(Shell parentShell, EObject eObject)
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
		setTitle("Ordner Dialog");				
		Composite area = null;
		try
		{
			area = (Composite) super.createDialogArea(parent);
			Composite container = new Composite(area, SWT.NONE);
			container.setLayout(new GridLayout(1, false));
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
						
			VViewModelProperties properties = VViewFactory.eINSTANCE.createViewModelLoadingProperties();
			properties.addNonInheritableProperty(ARCHIV_PROJECTID_FILTERKEY, ARCHIV_PROJECTID_FILTERVALUE);			
			VView view = ViewProviderHelper.getView(eObject, properties);			
			
			ViewModelContext vmc = ViewModelContextFactory.INSTANCE
					.createViewModelContext(view, eObject, new ECPReferenceServiceImpl());
						
			ECPSWTViewRenderer.INSTANCE.render(container, vmc);
						
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
		return new Point(518, 472);
	}
	
	@Override
	protected void okPressed()
	{

		super.okPressed();
	}

}
