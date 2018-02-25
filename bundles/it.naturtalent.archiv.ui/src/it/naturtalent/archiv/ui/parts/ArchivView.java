
package it.naturtalent.archiv.ui.parts;

import java.util.Collection;
import java.util.EventObject;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.menu.MToolItem;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.core.ECPProjectManager;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CreateChildCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.internal.client.model.changeTracking.commands.EMFStoreBasicCommandStack;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;

import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.Archive;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.PartListenerAdapter;
import it.naturtalent.archiv.ui.action.SaveAction;
import it.naturtalent.e4.project.ui.Activator;



public class ArchivView
{
	
	@Inject @Optional public ECPProjectManager ecpProjectManager;
	@Inject @Optional public ESelectionService eSelectionService;
	
	@Inject @Optional public EModelService modelService;
	@Inject @Optional public EPartService partService;

	
	public final static String ARCHIVVIEW_ID = "it.naturtalent.archiv.ui.part.archive";
	
	private final static String FEATURE_REGISTERTYPE = "registerType";
	
	public static final String SAVE_TOOLBAR_ID = "it.naturtalent.archiv.ui.directtoolitem.speichern";
	public static final String UNDO_TOOLBAR_ID = "it.naturtalent.archiv.ui.directtoolitem.undo";

	
	// vom Renderer erzeugter Master-TreeViewer
	private TreeViewer treeViewer;
	
	private Ordner ordner;
	
	
	/*
	 * CommandStackListener ueberwacht Aenderungen am Archiv
	 */
	private class ArchivCommandStackListener implements CommandStackListener
	{
		@Override
		public void commandStackChanged(EventObject event)
		{
			EMFStoreBasicCommandStack commandStack = (EMFStoreBasicCommandStack) event.getSource();
			Command command = commandStack.getMostRecentCommand();	
							
			if(command instanceof SetCommand)				
			{
				// Register wurde geandert
				EStructuralFeature eStructuralFeature = ((SetCommand) command).getFeature();					
				if(StringUtils.equals(eStructuralFeature.getName(), FEATURE_REGISTERTYPE))
				{
					// der RegisterTyp des Ordners wurde geandert - Ordner durch Selektion updaten
					treeViewer.refresh();
					treeViewer.setSelection(new StructuredSelection(ordner));
				}
				
				// Toolbarstatus updaten
				MPart mPart = partService.findPart(ARCHIVVIEW_ID);
				List<MToolItem> items = modelService.findElements(mPart, SAVE_TOOLBAR_ID, MToolItem.class,null, EModelService.IN_PART);
				MToolItem item = items.get(0);
				item.setEnabled(true);
				
				items = modelService.findElements(mPart, UNDO_TOOLBAR_ID, MToolItem.class,null, EModelService.IN_PART);
				item = items.get(0);
				item.setEnabled(true);					
			}
			
			if(command instanceof AddCommand)				
			{
				// neues Register
				AddCommand addCommand = (AddCommand) command;
				Collection<?>createResults = addCommand.getResult();
				Object createObj = createResults.iterator().next();
				if(createObj instanceof Register)			
				{
					//Register aus dem Command extrahieren 
					Collection<?> collection = addCommand.getResult();						
					Object [] obj = collection.toArray();
					Register register = (Register) obj[0];
					
					// abhaengig vom Registertyp automatisch ein Wert vorbelegen
					Ordner ordner = (Ordner) register.eContainer();
					switch (ordner.getRegisterType())
					{
						case NUMERIC_TYPE:
							register.setNumericData(ArchivUtils.autoRegisterNumber(ordner,(short) 1));
							break;

						case LETTER_TYPE:
							register.setAlphaData(ArchivUtils.autoRegisterAlpha(ordner,"A"));
							break;
					}
				}						
			}				
											
			if(command instanceof CreateChildCommand)				
			{
				CreateChildCommand createCommand = (CreateChildCommand) command;					
				if(StringUtils.equals(createCommand.getText(), "Register"))
				{
					//Register aus dem Command extrahieren 
					Collection<?> collection = createCommand.getResult();						
					Object [] obj = collection.toArray();
					Register register = (Register) obj[0];
					
					// abhaengig vom Registertyp automatisch ein Wert vorbelegen
					if (ordner != null)
					{
						switch (ordner.getRegisterType())
						{
							case NUMERIC_TYPE:
								register.setNumericData(ArchivUtils.autoRegisterNumber(ordner,(short) 1));
								break;

							case LETTER_TYPE:
								register.setAlphaData(ArchivUtils.autoRegisterAlpha(ordner,"A"));
								break;
						}
					}
				}					
			}
		}
	}
	private ArchivCommandStackListener archivCommandStackListener = new ArchivCommandStackListener();
	
	
	// Focus lost Listener
	private PartListenerAdapter partListenerAdapter = new PartListenerAdapter()
			{
				@Override
				public void partDeactivated(MPart part)
				{
					// bei Focusverlust Aenderungen festschreiben
					SaveAction saveAction = new SaveAction();
					if(saveAction.canExecute())
						saveAction.execute(modelService, part);
				}		
			};
	
	@PostConstruct
	public void postConstruct(Composite parent, IEventBroker eventBroker,
			final EPartService partService, final EModelService modelService)
	{
		Archive archive = ArchivUtils.getArchive();
		if(archive != null)
		{
			try
			{
				ECPSWTViewRenderer.INSTANCE.render(parent, archive);
			}
			catch (ECPRendererException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		// Listener meldet Aenderungen im Archiv
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(Activator.getECPProject());
		EMFStoreBasicCommandStack commandStack = (EMFStoreBasicCommandStack) domain.getCommandStack();
		domain.getCommandStack().addCommandStackListener(archivCommandStackListener);
		
		// Focus Listener einbinden
		partListenerAdapter.setModelService(modelService);
		partService.addPartListener(partListenerAdapter);
		
	}
	
	/**
	 * vor dem Eliminieren noch erledigen
	 * 
	 * @param modelService
	 * @param part
	 */
	@PreDestroy
	public void preDestroy(EModelService modelService, MPart part, EPartService partService)
	{
		// anstehende Modellaenderungen festschreiben
		new SaveAction().execute(modelService, part);
		
		// CommandStackListener entfernen
		EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(Activator.getECPProject());
		EMFStoreBasicCommandStack commandStack = (EMFStoreBasicCommandStack) domain.getCommandStack();
		domain.getCommandStack().removeCommandStackListener(archivCommandStackListener);
		
		// PartListener entfernen
		partService.removePartListener(partListenerAdapter);
	}
	
	
	@Inject
	public void handleSelection(
			@Named(IServiceConstants.ACTIVE_SELECTION) @Optional Object object,
			EModelService modelService, MPart part)
	{
		if ((object instanceof Archive) || (object instanceof Archiv) || (object instanceof Ordner))
				new SaveAction().execute(modelService, part);
	}

	@Inject
	public void handleSelection(@Named(IServiceConstants.ACTIVE_SELECTION) @Optional Ordner ordner)
	{
		this.ordner = ordner;		
	}
	

}