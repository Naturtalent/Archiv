package it.naturtalent.archiv.ui.dialogs1;

import java.util.HashMap;
import java.util.Map;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import archive.Ordner;
import archive.Register;
import archive.RegisterType;
import it.naturtalent.archiv.ui1.ArchivUtils;
import it.naturtalent.archiv.ui1.LetterRegisterComposite;
import it.naturtalent.archiv.ui1.Messages;
import it.naturtalent.archiv.ui1.NumericRegisterComposite;
import it.naturtalent.emf.model.Activator;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;

/**
 * Registerdialog modifiziert fuer die Wizardeingabe. 
 * Eingabe reduziert auf die Registerbeschriftung und in Abhaengigkeit des Registertypes die jeweilige
 * Typedaten.
 * 
 * @author dieter
 *
 */
public class WizardRegisterDialog extends TitleAreaDialog
{
	// Viewmodel-Filterdefinitionen fuer die modifizierte Registereingabe 
	public static final String SHORT_REGISTERVIEW_FILTERKEY = "it.naturtalent.archiv.viewmodel.shortRegister"; //$NON-NLS-1$
	public static final String SHORT_REGISTERVIEW_FILTERVALUE = "it.naturtalent.archiv.viewmodel.shortRegister"; //$NON-NLS-1$

	private Register register;
	private Ordner ordner;
		
	private NumericRegisterComposite numericRegisterComposite;
	private LetterRegisterComposite letterRegisterComposite;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public WizardRegisterDialog(Shell parentShell, Register register)
	{
		super(parentShell);
		this.ordner = (Ordner) register.eContainer();
		this.register = register;				
	}
	

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		setMessage(Messages.WizardRegisterDialog_Message);
		setTitle(Messages.bind(Messages.WizardRegisterDialog_Title,register.getLabel()));				
		Composite area = null;
		try
		{
			area = (Composite) super.createDialogArea(parent);
			Composite container = new Composite(area, SWT.NONE);
			container.setLayout(new GridLayout(1, false));
			container.setLayoutData(new GridData(GridData.FILL_BOTH));
			
			// Viewmodel fuer modifizierte Registereingabe ueber Filter ermitteln
			VViewModelProperties properties = VViewFactory.eINSTANCE.createViewModelLoadingProperties();
			properties.addNonInheritableProperty(SHORT_REGISTERVIEW_FILTERKEY, SHORT_REGISTERVIEW_FILTERVALUE);			
			VView view = ViewProviderHelper.getView(register, properties);			
						
			ViewModelContext vmc = ViewModelContextFactory.INSTANCE
					.createViewModelContext(view, register);
			
			Composite composite = new Composite(container, SWT.NONE);
			composite.setLayout(new GridLayout(1, false));
			composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			
			ECPSWTViewRenderer.INSTANCE.render(composite, vmc);
			
			/*
			// ein vom Registertyp abhaengiges Eingabefeld hinzufuegen 
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
	
	@Override
	protected void okPressed()
	{

		if (ordner != null)
		{				
			if(ordner.getRegisterType() == RegisterType.NUMERIC_TYPE)		
				register.setNumericData(numericRegisterComposite.getNumericValue());
			else			
				if(ordner.getRegisterType() == RegisterType.LETTER_TYPE)		
					register.setAlphaData(letterRegisterComposite.getAlphaValue());

			Activator.getEventBroker().send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, register);
		}
		
		super.okPressed();
	}

	
}
