package it.naturtalent.archiv.ui.renderer;

import javax.inject.Inject;

import org.eclipse.core.databinding.observable.IObserving;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.internal.control.multireference.MultiReferenceSWTRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.util.swt.ImageRegistryService;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Listener;

/**
 * Renderer modifiziert den MultiReferenceSWTRenderer der zuegordneten Register.
 * 
 * - AddExistingButton ausblenden
 * - Workaround im AddNewButton Fehler
 * 
 * @author dieter
 *
 */
public class OrdnerRenderer extends MultiReferenceSWTRenderer
{
	private EStructuralFeature structuralFeature;
	private EObject container;
	
	@Inject
	public OrdnerRenderer(VControl vElement, ViewModelContext viewContext,
			ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding,
			EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider,
			ImageRegistryService imageRegistryService)
	{
		super(vElement, viewContext, reportService, emfFormsDatabinding,
				emfFormsLabelProvider, vtViewTemplateProvider, imageRegistryService);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean showAddExistingButton()
	{
		return false;
	}
	
	/*
	 * sichert die Parameter fuer die Funktion 'createAddNewButton()'
	 */
	@Override
	protected Composite createButtonComposite(Composite parent)
			throws DatabindingFailedException
	{
		final IObservableValue observableValue = getEMFFormsDatabinding()
				.getObservableValue(getVElement().getDomainModelReference(), getViewModelContext().getDomainModel());
			container = (EObject) ((IObserving) observableValue).getObserved();
			structuralFeature = (EStructuralFeature) observableValue.getValueType();	
		return super.createButtonComposite(parent);
	}

	/*
	 * Die Originalfunktion fuehrt zu einem Fehler in 'updateButtons()' (Renderer disposed):
	 * Die Ursache ist momentan unklar, des Workaround durch Ueberschreiben.
	 */
	@Override
	protected Button createAddNewButton(Composite parent,
			final EStructuralFeature structuralFeature)
	{
		Button btnAddNew = super.createAddNewButton(parent, structuralFeature);
		// TODO Auto-generated method stub
		
		Listener[] selectionListeners = btnAddNew.getListeners(SWT.Selection);
		btnAddNew.removeListener(SWT.Selection, selectionListeners[0]);
		
		btnAddNew.addSelectionListener(new SelectionAdapter() 
		{
			/**
			 * {@inheritDoc}
			 *
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				handleAddNew(getTableViewer(), container, structuralFeature);
				//updateButtons();
			}

		});
		
		return btnAddNew;
	}


	
	

}
