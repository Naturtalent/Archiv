package it.naturtalent.archiv.ui1;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.util.ECPUtil;
import org.eclipse.emf.ecp.core.util.observer.ECPProjectContentTouchedObserver;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;

import archive.Register;
import archive.impl.ArchivePackageImpl;
import it.naturtalent.emf.model.Activator;
import it.naturtalent.emf.model.DefaultProjectIDRenderer;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;

public class RegisterProjectIDRenderer extends DefaultProjectIDRenderer implements ECPProjectContentTouchedObserver
{
	private Register register;
	
	@Inject
	public RegisterProjectIDRenderer(VControl vElement,
			ViewModelContext viewContext, ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding,
			EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider,
			EMFFormsEditSupport emfFormsEditSupport)
	{
		super(vElement, viewContext, reportService, emfFormsDatabinding,
				emfFormsLabelProvider, vtViewTemplateProvider, emfFormsEditSupport);
		
		register = (Register) getViewModelContext().getDomainModel();
		selectedID = register.getProjectID(); 
		
		propertyFactoryName = ArchivNtProjectPropertyFactory.class.getName();
		
		// Observer anmelden (meldet Aenderungen am Modell)
		ECPUtil.getECPObserverBus().register(this);
	}
	
	

	@Override
	protected void updateElement()
	{
		EAttribute eAttribute = ArchivePackageImpl.eINSTANCE.getRegister_ProjectID();
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(register);
		Command setCommand = SetCommand.create(domain, register, eAttribute,selectedID);
		if (setCommand.canExecute())
			domain.getCommandStack().execute(setCommand);
		Activator.getEventBroker().send(ModelEventKey.DEFAULT_UNDO_MODELEVENT,register);
	}

	
	@Override
	public void contentTouched(ECPProject project, Collection<Object> objects,boolean structural)
	{
		Object[] objectsArray = objects.toArray(new Object[objects.size()]);
		for (final Object obj : objectsArray)
		{
			if (obj.equals(register))
			{	
				// Aenderung in den Details (im DetailsView aktualisieren)
				Activator.getEventBroker().post(ModelEventKey.DEFAULT_SHOWDETAILS_MODELEVENT,register);
				return;
			}
		}

	}
	

	/*
	@Override
	protected void dispose()
	{
		ECPUtil.getECPObserverBus().unregister(this);
	}
	*/
	

	/*
	@Override
	protected Control createSWTControl(Composite parent)
	{
		Register register = (Register) getViewModelContext().getDomainModel();
		register.setProjectID("12344321");
		
		Control control = super.createSWTControl(parent);
		
		
		
		return control;
	}
	*/

	
	

}
