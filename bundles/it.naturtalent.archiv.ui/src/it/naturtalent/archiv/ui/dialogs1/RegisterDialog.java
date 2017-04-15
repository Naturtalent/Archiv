package it.naturtalent.archiv.ui.dialogs1;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.spi.ui.ECPReferenceServiceImpl;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import archive.Ordner;
import archive.Register;
import archive.RegisterType;
import it.naturtalent.archiv.ui1.ArchivUtils;
import it.naturtalent.archiv.ui1.LetterRegisterComposite;
import it.naturtalent.archiv.ui1.NumericRegisterComposite;
import it.naturtalent.emf.model.Activator;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;

public class RegisterDialog extends TitleAreaDialog
{
	private Ordner ordner;
	private Register register;
	
	private String title;
	private String message;
	
	private static final String NUMERICDATA_NAME = "numericData"; //$NON-NLS-N$
	private static final String ALPHADATA_NAME = "alphaData"; //$NON-NLS-N$
	//private NumericRegisterComposite numericRegisterComposite;
	private LetterRegisterComposite letterRegisterComposite;
			
	//private Log log = LogFactory.getLog(this.getClass());
	
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public RegisterDialog(Shell parentShell, Register register)
	{
		super(parentShell);
		this.register = register;			
		ordner = (Ordner) register.eContainer();
	}

	public RegisterDialog(Shell parentShell, Ordner ordner, Register register)
	{
		super(parentShell);
		this.ordner = ordner;
		this.register = register;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		super.setTitle(StringUtils.isNotEmpty(title) ? title : "Register");
		super.setMessage(StringUtils.isNotEmpty(message) ? message : "ein Register definieren");
		
		Composite area = null;
		try
		{
			area = (Composite) super.createDialogArea(parent);
			Composite container = new Composite(area, SWT.NONE);
			container.setLayout(new GridLayout(2, false));
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
			
			VView view = ViewProviderHelper.getView(register, null);
			ViewModelContext vmc = ViewModelContextFactory.INSTANCE
					.createViewModelContext(view, register, new ECPReferenceServiceImpl());
			
			Composite composite = new Composite(container, SWT.NONE);
			composite.setLayout(new GridLayout(1, false));
			composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			
			ECPSWTViewRenderer.INSTANCE.render(composite, vmc);
			
			/*
			
			if (ordner != null)
			{	 
				new Label(composite, SWT.NONE);
				if(ordner.getRegisterType() == RegisterType.NUMERIC_TYPE)	
				{
					// Registertype: Numerictype
					numericRegisterComposite = new NumericRegisterComposite(composite, SWT.NONE);
					numericRegisterComposite.setNumericValue(ordner, register.getNumericData());
				}
				else
				{
					if(ordner.getRegisterType() == RegisterType.LETTER_TYPE)	
					{
						// Registertype: Lettertype
						letterRegisterComposite = new LetterRegisterComposite(composite, SWT.NONE);
						letterRegisterComposite.setAlphaValue(ordner, register);
					}					
				}
			}
			*/

						
		} catch (ECPRendererException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		return area;
	}
	


	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setMessage(String message)
	{
		this.message = message;
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
		return new Point(518, 293);
	}

	@Override
	protected void cancelPressed()
	{
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(register);		
		domain.getCommandStack().undo();
		Activator.getEventBroker().send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, register);
		super.cancelPressed();
	}

	@Override
	protected void okPressed()
	{
		Activator.getEventBroker().send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, register);
		super.okPressed();
	}
	
	
	
	
	/*
	@Override
	protected void okPressed()
	{
		if (ordner != null)
		{				
			EStructuralFeature feature = null;
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(register);			
			Object value = SetCommand.UNSET_VALUE;						
			
			if(ordner.getRegisterType() == RegisterType.NUMERIC_TYPE)
			{
				EList<EStructuralFeature> features = register.eClass().getEStructuralFeatures();
				for(EStructuralFeature checkFeature : features)
				{
					if(StringUtils.equals(checkFeature.getName(), NUMERICDATA_NAME))
					{
						feature = checkFeature;
						break;
					}
				}
				value = numericRegisterComposite.getNumericValue();
				
			}
			else
			{
				if(ordner.getRegisterType() == RegisterType.LETTER_TYPE)	
				{
					EList<EStructuralFeature> features = register.eClass().getEStructuralFeatures();
					for(EStructuralFeature checkFeature : features)
					{
						if(StringUtils.equals(checkFeature.getName(), ALPHADATA_NAME))
						{
							feature = checkFeature;
							break;
						}
					}
					value = letterRegisterComposite.getAlphaValue();
				}				
			}			
			
			if(feature != null)
			{
				Command command = SetCommand.create(domain, register, feature, value);
				if (command.canExecute())
				{
					domain.getCommandStack().execute(command);
					Activator.getEventBroker().send(ModelEventKeys.VIEWEVENT_UNDOMASTER, register);
				}
			}
		}
		
		super.okPressed();
	}
	*/
}
