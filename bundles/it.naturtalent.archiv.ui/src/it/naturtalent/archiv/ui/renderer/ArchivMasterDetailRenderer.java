package it.naturtalent.archiv.ui.renderer;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.internal.workbench.E4Workbench;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.ecp.view.internal.swt.ContextMenuViewModelService;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.renderer.NoPropertyDescriptorFoundExeption;
import org.eclipse.emf.ecp.view.spi.renderer.NoRendererFoundException;
import org.eclipse.emf.ecp.view.spi.treemasterdetail.ui.swt.TreeMasterDetailSWTRenderer;
import org.eclipse.emf.ecp.view.treemasterdetail.model.VTreeMasterDetail;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.ui.ArchivUtils;


/**
 * ArchivMasterDetailRenderer informiert ueber die Selektionen im MasterTreeViewer
 * 
 * Einbindung eines Sorters.
 *  
 * @author dieter *
 */
public class ArchivMasterDetailRenderer  extends TreeMasterDetailSWTRenderer
{
	private ESelectionService eSelectionService;
	
	private IEventBroker eventBroker;
	
	private TreeViewer treeViewer;
	
	@Inject
	public ArchivMasterDetailRenderer(VTreeMasterDetail vElement,
			ViewModelContext viewContext, ReportService reportService)
	{		
		super(vElement, viewContext, reportService);
		
		MApplication currentApplication = E4Workbench.getServiceContext().get(IWorkbench.class).getApplication();
		eSelectionService = currentApplication.getContext().get(ESelectionService.class);
		eventBroker = currentApplication.getContext().get(IEventBroker.class);
	}
	
	/*
	 * Die Methode wird ueberschrieben, damit ein Zugriff auf den TreeViewer moeglich ist.
	 * Der TreeViewer wird als event (key: DesignsView.DESIGN_TREEVIEWER_EVENT) gepostet.
	 * Gleichzeitig wird ein TreeMasterViewSelectionListener (s.o.) in den Viewer eingebunden.
	 * 
	 * @see org.eclipse.emf.ecp.view.spi.treemasterdetail.ui.swt.TreeMasterDetailSWTRenderer#createMasterTree(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected TreeViewer createMasterTree(Composite masterPanel)
	{
		treeViewer = super.createMasterTree(masterPanel);
		
		// Sortierer
		treeViewer.setComparator(new ViewerComparator());
		
		// Selektion im TreeViewer via SelectionService verbreiten
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{			
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				// die Selektionen im SelectionService veroeffentlichen
				Object treeSelected = ((IStructuredSelection) event.getSelection()).getFirstElement();	
				eSelectionService.setSelection(treeSelected);	
				eventBroker.post(ArchivUtils.ARCHIVE_SELECTION_EVENT, treeSelected);
			}
		});
		
		return treeViewer;
	}


	/**
	 * Das uebergebene Register im MasterView selektieren.
	 * 
	 * @param register
	 */
	@Inject
	@Optional
	public void handleSelectArchivEvent(@UIEventTopic(ArchivUtils.SELECT_ARCHIV_REQUEST) Archiv archiv)
	{
		if (archiv != null)
		{
			if (!treeViewer.getTree().isDisposed())
				treeViewer.setSelection(new StructuredSelection(archiv));
		}
	}
	
	/**
	 * Das uebergebene Register im MasterView selektieren.
	 * 
	 * @param register
	 */
	@Inject
	@Optional
	public void handleModelChangedEvent(@UIEventTopic(ArchivUtils.SELECT_REGISTER_REQUEST) Register register)
	{
		if (register != null)
		{
			if (!treeViewer.getTree().isDisposed())
				treeViewer.setSelection(new StructuredSelection(register),true);
		}
	}
	
	/**
	 * RefreshMasterTree
	 * 
	 * 
	 * @param register
	 */
	@Inject
	@Optional
	public void handleRefreshRequest(@UIEventTopic(ArchivUtils.REFRESH_MASTER_REQUEST) Object object)
	{
		if (!treeViewer.getTree().isDisposed())
		{
			if(object == null)
				treeViewer.refresh();
			else
				treeViewer.refresh(object);
		}
	}

	/**
	 * RefreshMasterTree
	 * 
	 * 
	 * @param register
	 */
	@Inject
	@Optional
	public void handleSelectOrdnerRequest(@UIEventTopic(ArchivUtils.SELECT_ORDNER_REQUEST) Ordner ordner)
	{
		if (!treeViewer.getTree().isDisposed())
		{
			treeViewer.setSelection(new StructuredSelection(ordner));
		}
	}


	@Override
	protected Control renderControl(SWTGridCell cell, Composite parent)
			throws NoRendererFoundException, NoPropertyDescriptorFoundExeption
	{
		/* The tree's composites */
		final Composite form = createMasterDetailForm(parent);

		createHeader(form);

		final SashForm sash = createSash(form);

		final Composite masterPanel = createMasterPanel(sash);

		createRightPanelContent(sash);

		sash.setWeights(new int[] { 2, 2 });

		createMasterTree(masterPanel);

		if (hasContextMenu()) {
			registerControlAsContextMenuReceiver();
		}
		form.layout(true);
		return form;

		
	}
	
	private void registerControlAsContextMenuReceiver() {
		if (!getViewModelContext().hasService(ContextMenuViewModelService.class)) {
			return;
		}
		final ContextMenuViewModelService service = getViewModelContext().getService(
			ContextMenuViewModelService.class);

		if (service != null) {
			service.setParentControl(treeViewer.getTree());
			service.registerContextMenu();
		}
	}
	
	
}
