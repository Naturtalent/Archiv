package it.naturtalent.archiv.ui.parts1;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import archive.Archiv;
import archive.Ordner;
import archive.Register;
import archive.RegisterType;
import it.naturtalent.archiv.ui1.ArchivUtils;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import location.Adresse;

public class ArchivViewLabelProvider extends LabelProvider implements IFontProvider		
{
	private FontRegistry fontRegistry = new FontRegistry();
	
	private Ordner selectedOrdner = null;
	
	private Register selectedRegister = null;
	
	//private RegisterType registerType = RegisterType.NUMERIC_TYPE;
	
	@Override
	public Image getImage(Object element)
	{
		if (element instanceof Archiv)
			return Icon.ICON_PROJECT_OPEN.getImage(IconSize._16x16_DefaultIconSize);
		
		if (element instanceof Ordner)
			return Icon.ICON_FOLDER.getImage(IconSize._16x16_DefaultIconSize);
		
		if (element instanceof Register)
			return Icon.ICON_FILE.getImage(IconSize._16x16_DefaultIconSize);
			
		return super.getImage(element);
	}

	@Override
	public String getText(Object element)
	{
		if (element instanceof Ordner)
		{
			Ordner ordner = (Ordner) element;
			//registerType = ordner.getRegisterType();
			return ordner.getLabel();
		}

		if (element instanceof Register)
		{
			Register register = (Register) element;	
			Ordner ordner = (Ordner) register.eContainer();			
			RegisterType registerType = ordner.getRegisterType();
			
			switch (registerType.getValue())
				{
					case RegisterType.NUMERIC_TYPE_VALUE:
													
						String num = ((register.getNumericData() == 0) ? "??" : String.format("%02d", register.getNumericData()));
						num = num+" - "+register.getLabel();
						return num;
						
					case RegisterType.LETTER_TYPE_VALUE:	
						
						String alpha = register.getAlphaData();
						alpha = StringUtils.isNotEmpty(alpha) ? alpha : "?";						
						return alpha + " - "+register.getLabel();

					default:
						//System.out.println("Blankregister");
						break;
				}
		
			return register.getLabel();
		}

		if (element instanceof Archiv)
		{			
			Archiv archiv = (Archiv) element;
			return archiv.getName();
		}

		if (element instanceof Adresse)
		{			
			return "Adresse";
		}


		return super.getText(element);
	}

	@Override
	public Font getFont(Object element)
	{
		if((element.equals(selectedOrdner)) || (element.equals(selectedRegister)))
		{			
			return fontRegistry.getBold(Display.getCurrent()
					.getSystemFont().getFontData()[0].getName());
		}
		
		return null;
	}

	public void setSelectedOrdner(Ordner selectedOrdner)
	{
		this.selectedOrdner = selectedOrdner;
	}

	public void setSelectedRegister(Register selectedRegister)
	{
		this.selectedRegister = selectedRegister;
	}
	
	

}
