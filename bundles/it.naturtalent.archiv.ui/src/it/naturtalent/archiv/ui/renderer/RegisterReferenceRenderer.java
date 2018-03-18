package it.naturtalent.archiv.ui.renderer;

import javax.inject.Inject;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecp.view.internal.control.multireference.MultiReferenceSWTRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.renderer.NoPropertyDescriptorFoundExeption;
import org.eclipse.emf.ecp.view.spi.renderer.NoRendererFoundException;
import org.eclipse.emf.ecp.view.spi.util.swt.ImageRegistryService;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import it.naturtalent.archiv.ui.ArchivUtils;

/**
 * Modifizierter Renderer 
 * 
 * - informiert ueber die selektierten Register im DetailsView
 * 
 * @author dieter
 *
 */
public class RegisterReferenceRenderer extends MultiReferenceSWTRenderer
{
	
	private ESelectionService eSelectionService;	
	private IEventBroker eventBroker;

	
	@Inject
	public RegisterReferenceRenderer(VControl vElement,
			ViewModelContext viewContext, ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding,
			EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider,
			ImageRegistryService imageRegistryService)
	{
		super(vElement, viewContext, reportService, emfFormsDatabinding,
				emfFormsLabelProvider, vtViewTemplateProvider, imageRegistryService);
		
		MApplication currentApplication = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();
		eSelectionService = currentApplication.getContext().get(ESelectionService.class);
		eventBroker = currentApplication.getContext().get(IEventBroker.class);
	}

	@Override
	protected Control renderMultiReferenceControl(SWTGridCell cell,
			Composite parent)
			throws NoRendererFoundException, NoPropertyDescriptorFoundExeption
	{
		Control control = super.renderMultiReferenceControl(cell, parent);
		
		TableViewer tableViewer = getTableViewer();
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{			
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				// die Selektionen im SelectionService veroeffentlichen
				Object tableSelected = ((IStructuredSelection) event.getSelection()).getFirstElement();	
				eSelectionService.setSelection(tableSelected);	
				eventBroker.post(ArchivUtils.ARCHIVE_SELECTION_EVENT, tableSelected);
			}
		});
		
		return control;
	}
	
	

}
