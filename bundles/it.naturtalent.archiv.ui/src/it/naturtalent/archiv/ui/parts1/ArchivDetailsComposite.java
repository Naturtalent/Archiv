package it.naturtalent.archiv.ui.parts1;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.spi.ui.ECPReferenceServiceImpl;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.DefaultReferenceService;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.model.VViewModelProperties;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Composite;

import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.actions1.SaveAction;
import it.naturtalent.archiv.ui.actions1.UndoModelAction;
import it.naturtalent.archiv.ui.dialogs1.OrdnerDialog;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.emf.model.actions.DefaultModelActionDistributor;
import it.naturtalent.emf.model.parts.DefaultDetailsComposite;
import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;


/**
 * ArchivDetailsComposite zur Darstellung der Details (von Ordner, Register Archive)
 * 
 * @author A682055
 *
 */
public class ArchivDetailsComposite extends DefaultDetailsComposite
{

	private EditingDomain domain;
	
	public ArchivDetailsComposite(Composite parent, int style)
	{
		super(parent, style);		
	}
	
	@Override
	protected void createDetailsObject(EObject eObject) 
	{	
		ViewModelContext vmc;
		
		// Toolbar Aktionen definieren
		Map<String, DefaultModelAction> modelActions = new HashMap<String, DefaultModelAction>();
		modelActions.put(DefaultModelActionDistributor.UNDO_ACTION_ID, new UndoModelAction(null));
		modelActions.put(DefaultModelActionDistributor.SAVE_ACTION_ID, new SaveAction(null));
		createActionToolbar(modelActions);
		
		// 'eObject' an die Aktionen uebergeben
		getActionDistributor().setSelectedObject(eObject);

		
		if (eObject instanceof Ordner)
		{
			setMessage("Ordner");
			
			// filtert ViewModel 'Ordner.view' (Ordner incl. Registers)
			VViewModelProperties properties = VViewFactory.eINSTANCE.createViewModelLoadingProperties();
			properties.addNonInheritableProperty(OrdnerDialog.ARCHIV_PROJECTID_FILTERKEY, OrdnerDialog.ARCHIV_PROJECTID_FILTERVALUE);			
			VView view = ViewProviderHelper.getView(eObject, properties);		
			vmc = ViewModelContextFactory.INSTANCE
					.createViewModelContext(view, eObject, new ECPReferenceServiceImpl());			
		}
		else
		{
			setMessage("");
			if (eObject instanceof Register)
				setMessage("Register");
			
			if (eObject instanceof Archiv)
				setMessage("Archiv");

			
			vmc = ViewModelContextFactory.INSTANCE
				.createViewModelContext(ViewProviderHelper.getView(eObject, null),
						eObject, new DefaultReferenceService());		
		}
		
		try
		{
			ECPSWTViewRenderer.INSTANCE.render(container, vmc);
		} catch (ECPRendererException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		domain = AdapterFactoryEditingDomain.getEditingDomainFor(eObject);
		Object parentObject = domain.getParent(eObject);
		if(parentObject instanceof Ordner)
		{
			// Parent = Ordner also Registerdetails
			//title = Messages.ArchivDetailsComposite_TitleRegister;
			//createRegisterDetailsComposite(container, (Ordner) parentObject, (Register)eObject);
		}
		
		// Toolbar-Status aktualisieren (Undo, Save, ...)
		//updateDetailsWidgets();
		Activator.getEventBroker().send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, eObject);
	}
}
