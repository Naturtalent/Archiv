package it.naturtalent.archiv.ui1;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import archive.Ordner;
import archive.Register;

public class LetterRegisterComposite extends Composite
{
	private Text textAlpha;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public LetterRegisterComposite(Composite parent, int style)
	{
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Label lblRegisterAlpha = new Label(this, SWT.NONE);
		lblRegisterAlpha.setText("Registerbuchstabe");
		
		textAlpha = new Text(this, SWT.BORDER | SWT.RIGHT);
		GridData gd_textAlpha = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_textAlpha.widthHint = 20;
		textAlpha.setLayoutData(gd_textAlpha);
				
		textAlpha.addFocusListener(new FocusListener()
		{			
			@Override
			public void focusLost(FocusEvent e)
			{
				EStructuralFeature feature = null;
				//EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(register);			
				Object value = SetCommand.UNSET_VALUE;						

				
			}
			
			@Override
			public void focusGained(FocusEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});

	}
	
	public static String autoRegisterAlpha(Ordner ordner, String letter)
	{
		letter = (StringUtils.isEmpty(letter)) ? "A" : letter;
		
		String [] alphaArray = getArchivLetters(ordner);
		if(ArrayUtils.isNotEmpty(alphaArray))
		{
			for(char c = 'A';c < 'Z';c++)
			{				
				if(!ArrayUtils.contains(alphaArray, String.valueOf(c)))
					return String.valueOf(c);
			}
		}
		
		return "A";
	}
	
	/**
	 * Alle im Ordner verwendeten Buchstaben auflisten.
	 * 
	 * @param archivData
	 * @return
	 */
	public static String [] getArchivLetters(Ordner ordner)
	{
		String [] alphaArray = null;
		
		EList<Register>registers = ordner.getRegisters();
		if((registers != null) && (!registers.isEmpty()))
		{
			for(Register register : registers)
			{
				String alpha = register.getAlphaData();				
				if(StringUtils.isNotEmpty(alpha))
					alphaArray = ArrayUtils.add(alphaArray, alpha);
			}
		}

		return alphaArray;
	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}
		
	
	public String getAlphaValue()
	{
		return textAlpha.getText();
	}

	public void setAlphaValue(Ordner ordner, Register register)
	{
		String letter = null;
		
		if(register != null)
			letter = register.getAlphaData();
		
		if(StringUtils.isEmpty(letter))	
			letter = autoRegisterAlpha(ordner, null);
				
		textAlpha.setText(letter);
	}
	
	private Binding createBinding(Ordner ordner, Register register)
	{
		DataBindingContext dataBindingContext = new EMFDataBindingContext();
		EMFFormsDatabinding databindingService = E4Workbench.getServiceContext().get(EMFFormsDatabinding.class);
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(ordner);		
		
		final IObservableValue value = SWTObservables.observeText(textAlpha, SWT.FocusOut);
		
		//IObservableValue modelValue  = databindingService.getObservableValue(ref, ordner);
		
		//final Binding binding = dataBindingContext.bindValue(value, modelValue, null, null);
		
		return null;
	}
	

	/*
	public void setAlphaValue(Ordner ordner, String letter)
	{
		if(StringUtils.isEmpty(letter))	
			letter = autoRegisterAlpha(ordner, null);
		
		orgAlpha = letter;			
		textAlpha.setText(letter);
	}
	*/
	
	/*
	private void setDatabinding()
	{
		EMFFormsDatabinding databinding;
		DataBindingContext dataBindingContext;
		
		VDomainModelReference dmr = vControl.getDomainModelReference();
		
		final IObservableValue value = SWTObservables.observeText(textAlpha, SWT.FocusOut);
		IObservableValue modelValue=databinding.getObservableValue(dmr,viewModelContext.getDomainModel());
		
		final Binding binding = dataBindingContext.bindValue(value, modelValue, null, null);
	}
	*/

}
