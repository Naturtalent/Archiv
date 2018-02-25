package it.naturtalent.archiv.ui.renderer;

import javax.inject.Inject;

import org.eclipse.emf.ecp.view.internal.core.swt.renderer.NumberControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.locale.EMFFormsLocaleProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.localization.EMFFormsLocalizationService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.RegisterType;

public class NumericRegisterRenderer extends NumberControlSWTRenderer
{
	@Inject
	public NumericRegisterRenderer(VControl vElement,
			ViewModelContext viewContext, ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding,
			EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider,
			EMFFormsEditSupport emfFormsEditSupport,
			EMFFormsLocalizationService localizationService,
			EMFFormsLocaleProvider localeProvider)
	{
		super(vElement, viewContext, reportService, emfFormsDatabinding,
				emfFormsLabelProvider, vtViewTemplateProvider, emfFormsEditSupport,
				localizationService, localeProvider);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected Control createSWTControl(Composite parent)
	{
		Composite composite = (Composite) super.createSWTControl(parent);
		
		// Text-Control Size begrenzen
		final Text text = (Text) composite.getChildren()[0];
		text.setTextLimit(2);
		
		// unsichtbar, wenn Parentordner einen anderen Registerype benutzt
		ViewModelContext vmc = getViewModelContext();
		Object parentObj = vmc.getDomainModel().eContainer();
		if(parentObj instanceof Ordner)
		{
			Ordner ordner = (Ordner) parentObj;			
			getVElement().setVisible(ordner.getRegisterType() == RegisterType.NUMERIC_TYPE);
		}
				
		return composite;
	}

	@Override
	protected int getDefaultAlignment()
	{		
		return SWT.LEFT;
	}
}
