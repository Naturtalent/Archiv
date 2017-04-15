 
package it.naturtalent.archiv.ui.parts1;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import archive.Ordner;
import archive.Register;
import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.actions1.AddOrdnerAction;
import it.naturtalent.archiv.ui.actions1.DeleteArchivAction;
import it.naturtalent.archiv.ui.actions1.EditOrdnerAction;
import it.naturtalent.archiv.ui1.ArchivViewEvent;
import it.naturtalent.archiv.ui1.RegisterTypeSorter;
import it.naturtalent.emf.model.actions.DefaultModelActionDistributor;
import org.eclipse.swt.events.TreeAdapter;
import org.eclipse.swt.events.TreeEvent;


public class ArchivView
{
	
	public static final String ARCHIV_VIEW_ID = "it.naturtalent.archiv.ui.part.archivview"; //$NON-NLS-1$
	
	private TreeViewer treeViewer;
	
	private RegisterTypeSorter registerTypeSorter = new RegisterTypeSorter();
	
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	private Composite composite;

	private DefaultModelActionDistributor actionDestributor;
	
	private IEventBroker eventBroker;
	private EventHandler archivViewHandler = new EventHandler()
	{		
		@Override
		public void handleEvent(Event event)
		{					
			Object [] eventData = (Object []) event.getProperty(IEventBroker.DATA);
			if (StringUtils.equals(event.getTopic(),ArchivViewEvent.ARCHIV_VIEWEVENT_ADDORDNER))
			{
				treeViewer.refresh(treeViewer.getInput());		
				treeViewer.setSelection(new StructuredSelection(eventData[0]));
				treeViewer.reveal(eventData[0]);
				return;
			}

			if (StringUtils.equals(event.getTopic(),ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEORDNER))
			{
				treeViewer.refresh(eventData[0]);				
				return;
			}
			
			if (StringUtils.equals(event.getTopic(),ArchivViewEvent.ARCHIV_VIEWEVENT_REMOVEORDNER))
			{
				treeViewer.refresh(treeViewer.getInput());
				treeViewer.setSelection(new StructuredSelection());
				return;
			}

			
			if (StringUtils.equals(event.getTopic(),ArchivViewEvent.ARCHIV_VIEWEVENT_ADDREGISTER))
			{				
				treeViewer.refresh(eventData[0]);
				treeViewer.setSelection(new StructuredSelection(eventData[1]));
				return;
			}

			if (StringUtils.equals(event.getTopic(),ArchivViewEvent.ARCHIV_VIEWEVENT_REMOVEREGISTER))
			{				
				treeViewer.refresh(eventData[0]);
				treeViewer.setSelection(new StructuredSelection(eventData[0]));
				return;
			}
			
			if (StringUtils.equals(event.getTopic(),ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEREGISTER))
			{
				Object [] dataArray = (Object []) event.getProperty(IEventBroker.DATA);
				treeViewer.update(dataArray[1],null);
				return;
			}


		}
	};
	
	@Inject
	public ArchivView()
	{

	}

	@PostConstruct
	public void postConstruct(Composite parent)
	{
		parent.setLayout(new GridLayout(1, false));
		
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);
		
		Section sectionComposite = formToolkit.createSection(composite, Section.TITLE_BAR);
		sectionComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(sectionComposite);
		sectionComposite.setText("Archiv");
		
		Composite compositeClient = formToolkit.createComposite(sectionComposite, SWT.NONE);
		formToolkit.paintBordersFor(compositeClient);
		sectionComposite.setClient(compositeClient);
		compositeClient.setLayout(new GridLayout(1, false));
		
		treeViewer = new TreeViewer(compositeClient, SWT.BORDER  | SWT.FULL_SELECTION);
		Tree tree = treeViewer.getTree();
		tree.addTreeListener(new TreeAdapter()
		{
			@Override
			public void treeExpanded(TreeEvent e)
			{
				StructuredSelection selection = (StructuredSelection) treeViewer.getSelection();
				Object selObject =  selection.getFirstElement();
				
				if(selObject instanceof Ordner)
					registerTypeSorter.setOrdner((Ordner) selObject);
			}
		});
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			public void selectionChanged(SelectionChangedEvent event)
			{
				StructuredSelection selection = (StructuredSelection) treeViewer.getSelection();
				Object selObject =  selection.getFirstElement();
				if ((selObject instanceof Ordner) || (selObject instanceof Register))
				{
					actionDestributor.setSelectedObject((EObject) selObject);					
					return;
				}
				else
				{
					actionDestributor.setEnable(DefaultModelActionDistributor.DELETE_ACTION_ID, false);
					actionDestributor.setEnable(DefaultModelActionDistributor.EDIT_ACTION_ID, false);
				}				
			}
		});
	

		treeViewer.addDoubleClickListener(new IDoubleClickListener()
		{
			public void doubleClick(DoubleClickEvent event)
			{
				actionDestributor.run(DefaultModelActionDistributor.EDIT_ACTION_ID);
			}
		});
		
		actionDestributor = new DefaultModelActionDistributor(sectionComposite);		
		actionDestributor.addAction(DefaultModelActionDistributor.ADD_ACTION_ID, new AddOrdnerAction(treeViewer));
		actionDestributor.addAction(DefaultModelActionDistributor.EDIT_ACTION_ID, new EditOrdnerAction(treeViewer));
		actionDestributor.addAction(DefaultModelActionDistributor.DELETE_ACTION_ID, new DeleteArchivAction(treeViewer));
		sectionComposite.setTextClient(actionDestributor.createActionToolbar());
		
		treeViewer.setContentProvider(new ArchivViewContentProvider());
		treeViewer.setLabelProvider(new ArchivViewLabelProvider());
		treeViewer.setSorter(registerTypeSorter);		
		
		treeViewer.setInput(Activator.getECPProject());
		
		eventBroker = Activator.getEventBroker();
		eventBroker.subscribe(ArchivViewEvent.ARCHIV_VIEWEVENT+"*", archivViewHandler);
	}	

	@PreDestroy
	protected void preDestroy()
	{
		formToolkit.dispose();	
		eventBroker.unsubscribe(archivViewHandler);
	}

	public Composite getComposite()
	{
		return composite;
	}
	
	

}