package it.naturtalent.archiv.ui1;

import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlSWTControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

import archive.Archiv;
import location.Adresse;
import location.LocationPackage;


public class LocationAddressLinkRenderer extends SimpleControlSWTControlSWTRenderer

{
	
	private final FormToolkit toolkit = new FormToolkit(Display.getDefault());

	@Inject
	public LocationAddressLinkRenderer(VControl vElement,
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
		LocationAddressLinkComposite linkAdressComposite = new LocationAddressLinkComposite(parent, SWT.NONE);
		ImageHyperlink hyperlink = linkAdressComposite.getHyperlink();
		Button buttonAdd = linkAdressComposite.getBtnAdd();
		Button buttonDelete = linkAdressComposite.getBtnDelete();
				
		// Parentordner an Composite uebergeben
		Archiv archiv = null;
		ViewModelContext vmc = getViewModelContext();
		Object obj = vmc.getDomainModel();
		if (obj instanceof Archiv)
			archiv = (Archiv) obj;
		System.out.println(archiv);
		
		Object modelValue = getModelValue().getValue();
		if(modelValue == null)
		{
			hyperlink.setText(getUnsetText());
			hyperlink.setEnabled(false);
			buttonAdd.setEnabled(true);
			buttonDelete.setEnabled(false);
		}
		else
		{
			
		}
		
		System.out.println("Adresse: "+modelValue);
		
		/*
		IObservableValue modelValue = getModelValue();
		EStructuralFeature eStructuralFeature = (EStructuralFeature) modelValue.getValueType();
		if(eStructuralFeature instanceof EReferenceImpl)
		{
			EReferenceImpl reference = (EReferenceImpl) eStructuralFeature;
			if(LocationPackage.eINSTANCE.getAdresse().equals(reference.getEReferenceType()))
			{
				
				System.out.println("Adresse");
			}
		}
		*/
		
		
		return linkAdressComposite;
	}

	@Override
	protected String getUnsetText()
	{
		return "undefiniert";
	}



}
