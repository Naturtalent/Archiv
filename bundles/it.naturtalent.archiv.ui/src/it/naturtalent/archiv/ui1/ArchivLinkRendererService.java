package it.naturtalent.archiv.ui1;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emf.ecp.view.spi.table.model.VTableControl;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedReport;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;
import org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService;

import archive.ArchivePackage;
import location.LocationPackage;

public class ArchivLinkRendererService implements EMFFormsDIRendererService<VControl>
{
	
	private EMFFormsDatabinding databindingService;
	private ReportService reportService;
	
	
	protected void setEMFFormsDatabinding(
			EMFFormsDatabinding databindingService)
	{
		this.databindingService = databindingService;
	}
	
	@Override
	public double isApplicable(VElement vElement,
			ViewModelContext viewModelContext)
	{
		
		if (!VControl.class.isInstance(vElement))
		{
			return NOT_APPLICABLE;
		}
		final VControl control = (VControl) vElement;
		IValueProperty valueProperty;
		try
		{
			valueProperty = databindingService.getValueProperty(
					control.getDomainModelReference(),
					viewModelContext.getDomainModel());
		} catch (final DatabindingFailedException ex)
		{
			reportService.report(new DatabindingFailedReport(ex));
			return NOT_APPLICABLE;
		}
		final EStructuralFeature eStructuralFeature = EStructuralFeature.class
				.cast(valueProperty.getValueType());
		
		if(eStructuralFeature instanceof EReferenceImpl)
		{
			EReferenceImpl reference = (EReferenceImpl) eStructuralFeature;
			if(ArchivePackage.eINSTANCE.getArchiv().equals(reference.getEReferenceType()))
				return 10;
		}
		
		return NOT_APPLICABLE;
	}


	@Override
	public Class<? extends AbstractSWTRenderer<VControl>> getRendererClass()
	{						
		return ArchivLinkRenderer.class;
	}
	
}
