package it.naturtalent.archiv.ui1;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TreeAdapter;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.widgets.Composite;

import archive.Ordner;
import archive.Register;
import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.actions1.AddOrdnerAction;
import it.naturtalent.archiv.ui.actions1.DeleteArchivAction;
import it.naturtalent.archiv.ui.actions1.EditOrdnerAction;
import it.naturtalent.archiv.ui.actions1.InsertOrdnerAction;
import it.naturtalent.archiv.ui.parts1.ArchivViewContentProvider;
import it.naturtalent.archiv.ui.parts1.ArchivViewLabelProvider;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.emf.model.actions.DefaultModelActionDistributor;
import it.naturtalent.emf.model.parts.DefaultMasterComposite;


/**
 * WizardPage fuer die Bearbeitung der einem Ordner zugeordneten Register.
 *  
 * @author dieter
 *
 */
public class ArchivProjectPropertyWizardPage extends WizardPage
{

	// ProjectProperty das diese Page erzeugt hat
	private ArchivProjectProperty archivProjectProperty;
	
	public @Inject EPartService partService;
	
	public static final String INSERTORDNER_ACTION_ID = "insertOrdnerAction";
	
	private Ordner ordner = null;
	private Register register = null;
	private TreeViewer masterViewer;
	
	private RegisterTypeSorter registerTypeSorter = new RegisterTypeSorter();
	
	private Map<String, DefaultModelAction> modelActions;
	
	private ArchivViewLabelProvider archivViewLabelProvider = new ArchivViewLabelProvider();
	
	//private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	
	/**
	 * Create the wizard.
	 */
	@Inject
	public ArchivProjectPropertyWizardPage()
	{
		super("archivWizardPage"); //$NON-NLS-1$
		setTitle(Messages.WizardRegisterDialog_Title);	
	}
	
	
	
	/**
	 * Dieses Register wird vom Wizard hinzugefuegt oder bearbeitet. (ADD oder EDIT Mode)
	 * 
	 * @param register
	 */
	public void setRegister(Register register)
	{
		this.register = register;
		setMessage(Messages.bind(Messages.WizardRegisterDialog_Message,register.getLabel()));
	}
	
	/*
	@PostConstruct
	public void postConstruct(MApplication application)
	{
		IEclipseContext context =Activator.getApplicationContext();
		EModelService service = context.get(EModelService.class);
		
		MPart part = (MPart) service.find(ArchivMasterDetailsView.Id, application);
		ArchivMasterDetailsView archivView = (ArchivMasterDetailsView) part.getObject();
		if(archivView != null)
			archivView.persist();
	}
	*/
	
	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent)
	{		
		// eine modifizierte MasterComposite zeigt die Ordner und zugeordnete Register an 
		DefaultMasterComposite masterComposite = new DefaultMasterComposite(parent, SWT.NONE);		
		masterViewer = masterComposite.getMasterViewer();
		masterViewer.setContentProvider(new ArchivViewContentProvider());
		masterViewer.setLabelProvider(archivViewLabelProvider);
		archivViewLabelProvider.setSelectedRegister(register);
		masterViewer.setInput(Activator.getECPProject());
		masterViewer.setSorter(registerTypeSorter);		
		setControl(masterComposite.getSctnMaster());
		
		masterViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{			
			@Override
			public void selectionChanged(SelectionChangedEvent event)
			{
				StructuredSelection selection = (StructuredSelection) masterViewer.getSelection(); 
				Object selObject = selection.getFirstElement();
				if (selObject instanceof Ordner)
				{
					Ordner ordner = (Ordner) selObject;
					archivViewLabelProvider.setSelectedOrdner(ordner);
					masterViewer.collapseAll();
					
					//insertRegister(ordner, register);
					ArchivUtils.autoAddRegister(ordner, register);
					
					masterViewer.setExpandedState(ordner, true);
					
					masterViewer.refresh();
				}
				// TODO Auto-generated method stub
				
			}
		});
		
		// Standardaktionen Toolbaraktionen
		modelActions = new HashMap<String, DefaultModelAction>();				
		modelActions.put(DefaultModelActionDistributor.ADD_ACTION_ID, new AddOrdnerAction(masterViewer));		
		//modelActions.put(DefaultModelActionDistributor.EDIT_ACTION_ID, new WizardRegisterAction(masterViewer));
		modelActions.put(DefaultModelActionDistributor.EDIT_ACTION_ID, new EditOrdnerAction(masterViewer));
		//modelActions.put(DefaultModelActionDistributor.EDIT_ACTION_ID, new EditRegisterAction(masterViewer));
		modelActions.put(DefaultModelActionDistributor.DELETE_ACTION_ID, new DeleteArchivAction(masterViewer));
		
		final InsertOrdnerAction insertAction = new InsertOrdnerAction(masterViewer, register);
		modelActions.put(INSERTORDNER_ACTION_ID, insertAction);
		
		masterComposite.createActionToolbar(modelActions);
		
		// Events
		//Map<String,String>actionKeyMap = masterComposite.getViewEventKeyMap();
		//actionKeyMap.put(ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEORDNER, ModelEventKeys.DEFAULT_VIEWEVENT_UPDATEMASTER);
		//actionKeyMap.put(ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEREGISTER, DefaultDetailsComposite.DEFAULT_VIEWEVENT_UPDATEDETAIL);
		
		
		
		// DoubleClickListener austauschen
		IDoubleClickListener doubleClickListener = new IDoubleClickListener()
		{			
			@Override
			public void doubleClick(DoubleClickEvent event)
			{
				// Editaktion
				DefaultModelAction action = modelActions.get(DefaultModelActionDistributor.EDIT_ACTION_ID);
				action.run();
				
				/*
				StructuredSelection selection = (StructuredSelection) masterViewer.getSelection();
				Object selObject =  selection.getFirstElement();				
				if (selObject instanceof Ordner)
				{
					DefaultModelAction action = modelActions.get(DefaultModelActionDistributor.EDIT_ACTION_ID);
					action.run();
				}
				*/
								
				/*
				if (selObject instanceof Ordner)
				{
					Ordner ordner = (Ordner) selObject;
					Ordner oldParentOrdner = (Ordner) register.eContainer();
					if(oldParentOrdner == ordner)
					{
						Action wizardRegisterAction = modelActions.get(DefaultModelActionDistributor.EDIT_ACTION_ID);
						wizardRegisterAction.run();		
						return;
					}
										
					// Register in den selektierten Ordner einfuegen 
					if(ArchivUtils.autoAddRegister(ordner, register))
					{		
						((TreeViewer)masterViewer).expandToLevel(ordner, 1);
						masterViewer.reveal(register);
						masterViewer.setSelection(new StructuredSelection(register), true);
					}
					return;
				}
				*/
				
				/*
				if (selObject instanceof Register)
				{					
					Action wizardRegisterAction = modelActions.get(DefaultModelActionDistributor.EDIT_ACTION_ID);
					wizardRegisterAction.run();
				}
				*/
				
			}
		};
		masterComposite.setDefaultDoubleClickListener(doubleClickListener);
		
		// TreeExpand Listener
		((TreeViewer) masterViewer).getTree().addTreeListener(new TreeAdapter()
		{			
			@Override
			public void treeExpanded(TreeEvent e)
			{
				// Sortierfunktion an Registertye anpassen
				StructuredSelection selection = (StructuredSelection) masterViewer.getSelection();
				Object selObject =  selection.getFirstElement();
				if(selObject instanceof Ordner)
					registerTypeSorter.setOrdner((Ordner) selObject);
			}
		});
		
		// im Wizard EDIT-Mode wird das zubearbeitende Register selektiert
		// (nur wichtig beim erstmaligen Aufruf)
		if(register != null)
		{
			Ordner ordner = (Ordner) register.eContainer();
			if(ordner != null)
			{				
				((TreeViewer)masterViewer).expandToLevel(ordner, 1);
				masterViewer.reveal(register);
				masterViewer.setSelection(new StructuredSelection(register));
			}
		}
		
	}
	
	/**
	 * Rueckgabe des im Page selektierten EObjects.
	 * 
	 * @return
	 */
	public EObject getSelectedEObject()
	{
		IStructuredSelection selection = (IStructuredSelection) masterViewer.getSelection();
		Object selObj = selection.getFirstElement();
		if(selObj instanceof EObject)
			return (EObject) selObj;
				
		return null;
	}



	public ArchivProjectProperty getArchivProjectProperty()
	{
		return archivProjectProperty;
	}



	public void setArchivProjectProperty(
			ArchivProjectProperty archivProjectProperty)
	{
		this.archivProjectProperty = archivProjectProperty;
	}
	
	

}
