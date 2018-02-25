package it.naturtalent.archiv.ui1;

import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlSWTControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import it.naturtalent.archiv.model.archiv.Ordner;




/**
 * Renderer fuer das Attribut 'Archiv' im Ordner.
 * 
 * @author dieter
 *
 */
public class ArchivLinkRenderer extends SimpleControlSWTControlSWTRenderer

{
	@Inject
	public ArchivLinkRenderer(VControl vElement,
			ViewModelContext viewContext, ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding,
			EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider)
	{
		super(vElement, viewContext, reportService, emfFormsDatabinding,
				emfFormsLabelProvider, vtViewTemplateProvider);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Binding[] createBindings(Control control)
			throws DatabindingFailedException
	{

		return null;
	}

	@Override
	protected Control createSWTControl(Composite parent)
			throws DatabindingFailedException
	{
		// Composite des Renderers
		ArchivLinkRendererComposite archivLinkComposite = new ArchivLinkRendererComposite(parent, SWT.NONE, this);
				
		// Parentordner an Composite uebergeben
		ViewModelContext vmc = getViewModelContext();
		Object obj = vmc.getDomainModel();
		if(obj instanceof Ordner)
			archivLinkComposite.setOrdner((Ordner)obj);
		
		return archivLinkComposite;
	}

	@Override
	protected String getUnsetText()
	{	
		return "undefiniert";
	}
	



}
