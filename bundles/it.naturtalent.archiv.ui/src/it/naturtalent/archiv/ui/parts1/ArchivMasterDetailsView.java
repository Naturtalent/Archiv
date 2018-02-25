package it.naturtalent.archiv.ui.parts1;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.IPartListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.TreeAdapter;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.widgets.Composite;

import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.actions1.DeleteArchivAction;
import it.naturtalent.archiv.ui.actions1.EditOrdnerAction;
import it.naturtalent.archiv.ui.actions1.NewArchivAction;
import it.naturtalent.archiv.ui1.RegisterTypeSorter;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.emf.model.actions.DefaultModelActionDistributor;
import it.naturtalent.emf.model.parts.DefaultMasterDetailsModelView;
import it.naturtalent.archiv.model.archiv.Ordner;

/**
 * Archiv MasterDetailsView
 * 
 * @author A682055
 *
 */
public class ArchivMasterDetailsView extends DefaultMasterDetailsModelView
{

	public final static String Id = "it.naturtalent.archiv.ui.part.archivMasterDetails";
	
	
		
	/*
	private EventHandler archivViewHandler = new EventHandler()
	{		
		@Override
		public void handleEvent(Event event)
		{		
			EditingDomain domain;
			
			Object obj = event.getProperty(IEventBroker.DATA);
			if(obj instanceof ECPProject)
			{
				ECPProject ecpProject = (ECPProject)obj;
				domain = ecpProject.getEditingDomain();
			}
			else
				domain  = AdapterFactoryEditingDomain.getEditingDomainFor((EObject)obj);
							
			switch (event.getTopic())
				{
					case ModelEventKeys.VIEWEVENT_UNDOMASTER:	
						
						//System.out.println("ArchivMasterDetailsView - set dirtyable: "+Activator.getECPProject().hasDirtyContents());
						//dirtyable.setDirty(Activator.getECPProject().hasDirtyContents());
						
						
						dirtyable.setDirty(domain.getCommandStack().canUndo());
						break;

					default:
						break;
				}
		}
	};
	*/
	
	private IPartListener partListener = new IPartListener()
	{		
		@Override
		public void partVisible(MPart part)
		{
			// TODO Auto-generated method stub			
		}
		
		@Override
		public void partHidden(MPart part)
		{
			// TODO Auto-generated method stub			
		}
		
		@Override
		public void partDeactivated(MPart part)
		{
			if(StringUtils.equals(part.getElementId(),Id))
			{
				service.savePart(part, true);
				dirtyable.setDirty(false);
				System.out.println("ArchivMasterDetailsView - Part deaktivate");
			}
		}
		
		@Override
		public void partBroughtToTop(MPart part)
		{
			// TODO Auto-generated method stub			
		}
		
		@Override
		public void partActivated(MPart part)
		{
			// TODO Auto-generated method stub			
		}
	};
	
	private RegisterTypeSorter registerTypeSorter = new RegisterTypeSorter();
	
	@PostConstruct
	protected void postConstruct(Composite parent, @Optional EPartService service)
	{	
		// DefaultView erzeugen (Master- und DetailsComposites einbinden)
		super.postConstruct(parent);
		
		viewID = Id;

		ecpProject = ArchivUtils.getArchivProject();
		final StructuredViewer masterViewer = getMasterViewer();
		
		// Aktionen (Toolbar)
		Map<String, DefaultModelAction> modelActions = new HashMap<String, DefaultModelAction>();
		modelActions.put(DefaultModelActionDistributor.ADD_ACTION_ID, new NewArchivAction(masterViewer));
		modelActions.put(DefaultModelActionDistributor.EDIT_ACTION_ID, new EditOrdnerAction(masterViewer));
		modelActions.put(DefaultModelActionDistributor.DELETE_ACTION_ID, new DeleteArchivAction(masterViewer));
		createActionToolbar(modelActions);
		
		// Event
		/*
		Map<String,String>eventKeyMap = masterComposite.getViewEventKeyMap();
		 
		eventKeyMap.put(ArchivViewEvent.ARCHIV_VIEWEVENT_ADDORDNER, DefaultMasterComposite.DEFAULT_VIEWEVENT_ADDMASTER);
		eventKeyMap.put(ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEORDNER, DefaultMasterComposite.DEFAULT_VIEWEVENT_UPDATEMASTER);
		eventKeyMap.put(ArchivViewEvent.ARCHIV_VIEWEVENT_REMOVEORDNER, DefaultMasterComposite.DEFAULT_VIEWEVENT_DELETEMASTER);

		
		eventKeyMap.put(ArchivViewEvent.ARCHIV_VIEWEVENT_ADDREGISTER, DefaultDetailsComposite.DEFAULT_VIEWEVENT_ADDDETAIL);
		eventKeyMap.put(ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEREGISTER, DefaultDetailsComposite.DEFAULT_VIEWEVENT_UPDATEDETAIL);
		eventKeyMap.put(ArchivViewEvent.ARCHIV_VIEWEVENT_REMOVEREGISTER, DefaultDetailsComposite.DEFAULT_VIEWEVENT_REMOVERDETAIL);
		*/
		
		//subscribeEventHandler(ArchivViewEvent.ARCHIV_VIEWEVENT+"*");
		
		//StructuredViewer viewer = getMasterViewer();
		masterViewer.setContentProvider(new ArchivViewContentProvider());
		masterViewer.setLabelProvider(new ArchivViewLabelProvider());
		
		((TreeViewer) masterViewer).getTree().addTreeListener(new TreeAdapter()
		{			
			@Override
			public void treeExpanded(TreeEvent e)
			{
				StructuredSelection selection = (StructuredSelection) masterViewer.getSelection();
				Object selObject =  selection.getFirstElement();
				if(selObject instanceof Ordner)
					registerTypeSorter.setOrdner((Ordner) selObject);
			}
		});
		
		masterViewer.setInput(ArchivUtils.getArchivProject());
		masterViewer.setSorter(registerTypeSorter);	
		
		setService(service);
		
		//System.out.println("ArchivMasterDetailsView - Dirtyable: "+ dirtyable);
				
	//	Activator.getEventBroker().subscribe(ModelEventKeys.MASTER_VIEWEVENT+"*", archivViewHandler);
		
		//this.service = service;
		//service.addPartListener(partListener);		
	}
	
	
	@Persist
	public void persist()
	{
		dirtyable.setDirty(false);
		detailsComposite.getActionDistributor().run(DefaultModelActionDistributor.SAVE_ACTION_ID);		
		System.out.println("Persit Archiv");
	}
	
	/*
	@PreDestroy
	public void preDestroy()
	{
		 Activator.getEventBroker().unsubscribe(archivViewHandler);
	}
	*/
	
	/* Eine fuer das Archiv modifizierte DetailsComposite einfuegen
	 * (non-Javadoc)
	 * @see it.naturtalent.emf.model.parts.DefaultMasterDetailsModelView#createDetailsComposite(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createDetailsComposite(Composite parent)
	{
		detailsComposite = new ArchivDetailsComposite(parent, SWT.NONE);
		detailsComposite.setTitle("Archivdetails");
	}

}
