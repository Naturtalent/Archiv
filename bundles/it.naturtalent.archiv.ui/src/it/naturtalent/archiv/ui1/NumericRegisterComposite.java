package it.naturtalent.archiv.ui1;

import org.apache.commons.lang3.ArrayUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import archive.Ordner;
import archive.Register;

public class NumericRegisterComposite extends Composite
{
	private Text textNumber;
	
	private short orgNumber;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NumericRegisterComposite(Composite parent, int style)
	{
		super(parent, style);
		setLayout(new GridLayout(4, false));
		
		Label lblRegisterNumber = new Label(this, SWT.NONE);
		lblRegisterNumber.setText("Registernummer");
		
		textNumber = new Text(this, SWT.BORDER);
		new Label(this, SWT.NONE);
		
		Spinner spinner = new Spinner(this, SWT.BORDER);

	}
	
	public static short autoRegisterNumber(Ordner ordner, short start)
	{
		start = (start <= 0) ? 1 : start;
		
		short [] numbers = getArchivNumbers(ordner);
		if(ArrayUtils.isNotEmpty(numbers))
		{
			for(short i = start;i < 100;i++)
			{
				if(!ArrayUtils.contains(numbers, i))
					return i;
			}
		}
		
		return 1;
	}
	
	/**
	 * Alle im Ordner verwendeten Nummern auflisten.
	 * 
	 * @param archivData
	 * @return
	 */
	private static short [] getArchivNumbers(Ordner ordner)
	{
		short [] numArray = null;
		
		EList<Register>registers = ordner.getRegisters();
		if((registers != null) && (!registers.isEmpty()))
		{
			for(Register register : registers)
			{
				short num = register.getNumericData();				
				if(num > 0)
					numArray = ArrayUtils.add(numArray, num);
			}
			//Arrays.sort(numArray);
		}

		return numArray;
	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}
		
	
	public short getNumericValue()
	{
		short number;
		
		try
		{
			number = new Short(textNumber.getText()).shortValue();
		} catch (NumberFormatException e)
		{			
			number = orgNumber;
		}
				
		return number;		
	}
	
	public void setNumericValue(Ordner ordner, short numericValue)
	{
		if(numericValue <= 0)	
			numericValue = autoRegisterNumber(ordner, (short) 0);
		
		orgNumber = numericValue;
		String numStg = String.format("%02d", numericValue);		
		textNumber.setText(numStg);
	}

}
