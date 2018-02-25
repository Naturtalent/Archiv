package it.naturtalent.archiv.ui1;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.ecp.view.internal.table.swt.MessageKeys;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.renderer.NoPropertyDescriptorFoundExeption;
import org.eclipse.emf.ecp.view.spi.renderer.NoRendererFoundException;
import org.eclipse.emf.ecp.view.spi.table.model.VTableControl;
import org.eclipse.emf.ecp.view.spi.table.swt.TableControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.util.swt.ImageRegistryService;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.databinding.emf.EMFFormsDatabindingEMF;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.localization.LocalizationServiceHelper;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.util.Policy;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.actions1.AddRegisterAction;
import it.naturtalent.archiv.ui.actions1.DeleteArchivAction;
import it.naturtalent.archiv.ui.actions1.EditRegisterAction;
import it.naturtalent.archiv.ui.dialogs1.RegisterDialog;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;

public class RegisterTableControlRenderer extends TableControlSWTRenderer
{
	private static final String TOOLTIP_REGISTER = "neues Register";
	
	private Composite titleComposite;
	private Button editButton;
	
	private IEventBroker eventBroker = Activator.getEventBroker();
	private EventHandler archivViewHandler = new EventHandler()
	{		
		@Override
		public void handleEvent(Event event)
		{	
				/*
				if (StringUtils.equals(event.getTopic(),
						DefaultMasterComposite.MASTER_VIEWEVENT_MASTERSELECTION))
				{
					getTableViewer().setSelection(
							new StructuredSelection(eventData[0]));
				}
				*/

		}
	};
	
	@Inject
	public RegisterTableControlRenderer(VTableControl vElement,
			ViewModelContext viewContext, ReportService reportService,
			EMFFormsDatabinding emfFormsDatabinding,
			EMFFormsLabelProvider emfFormsLabelProvider,
			VTViewTemplateProvider vtViewTemplateProvider,
			ImageRegistryService imageRegistryService,
			EMFFormsEditSupport emfFormsEditSupport)
	{
		super(vElement, viewContext, reportService, (EMFFormsDatabindingEMF) emfFormsDatabinding,
				emfFormsLabelProvider, vtViewTemplateProvider, imageRegistryService,
				emfFormsEditSupport);
		
		eventBroker.subscribe(ModelEventKey.PREFIX_MODELEVENT+"*",archivViewHandler);
	}
	
	@Override
	protected void viewerSelectionChanged(SelectionChangedEvent event)
	{
		if (event.getSelection().isEmpty()) 
		{
			if (editButton != null)
				editButton.setEnabled(false);
		}
		else
		{
			if (editButton != null)
				editButton.setEnabled(true);
		}
		super.viewerSelectionChanged(event);
	}



	@Override
	protected Control renderControl(SWTGridCell gridCell, final Composite parent)
			throws NoRendererFoundException, NoPropertyDescriptorFoundExeption
	{
		Control control = super.renderControl(gridCell, parent);
		
		// DeleteButton
		Button deleteButton = getRemoveButton();
		
		// vorh. Selectionlistener entfernen 
		Listener [] deleteListeners = deleteButton.getListeners(SWT.Selection);
		deleteButton.removeListener(SWT.Selection, deleteListeners[0]);
		
		deleteButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// mit der 'DeleteArchivAction()' ein neues Register aus dem Ordner entfernen
				TableViewer tableViewer = (TableViewer)getTableViewer();
				StructuredSelection selection = (StructuredSelection) getTableViewer().getSelection();
				Object selObject = selection.getFirstElement();
				if (selObject instanceof Register)
				{
					Register register = (Register) selObject;
					DeleteArchivAction deleteAction =  new DeleteArchivAction(tableViewer);	
					deleteAction.seteObject(register);					
					deleteAction.run();
				}
			}
		});
		
		// AddButton 
		Button addButton = getAddButton();
		
		// vorh. Selectionlistener entfernen 
		Listener [] listeners = addButton.getListeners(SWT.Selection);
		addButton.removeListener(SWT.Selection, listeners[0]);
		
		// neuen SelectionListener einfuegen
		addButton.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{	
				// mit der 'AddRegisterAction()' ein neues Register dem Ordner hinzufuegen
				TableViewer tableViewer = (TableViewer)getTableViewer();
				AddRegisterAction addAction =  new AddRegisterAction(tableViewer);		
				addAction.seteObject((Ordner) getViewModelContext().getDomainModel());
				addAction.run();				
			}			
		});
		
		
		TableColumn[] columns = ((TableViewer)getTableViewer()).getTable().getColumns();
		for(TableColumn column : columns)
		{			
			String s = LocalizationServiceHelper.getString(getClass(),
					MessageKeys.TableControl_ValidationStatusColumn);
			if(StringUtils.equals(s, column.getText()))
			{
				column.setText("V");
				column.setWidth(10);
				break;
			}			
		}
		
		// Celleditorsupport abschalten
		TableViewerColumn[]tableViewerColumns = getTableViewerColumns((TableViewer)getTableViewer());
		for(TableViewerColumn tableViewerColumn : tableViewerColumns)	
			tableViewerColumn.setEditingSupport(null);
	
		// ToolTips der Buttons 'add' und 'remove' hinzufuegen
		getAddButton().setToolTipText(TOOLTIP_REGISTER);
		//getAddButton().setToolTipText(Messages.TaskTableControlRenderer_ToolTipNewTask);
		//getRemoveButton().setToolTipText(Messages.TaskTableControlRenderer_ToolTipRemove);
		
		// 'edit' - Button hinzufuegen
		getTitleComposite(parent);
		if(titleComposite != null)
		{
			GridLayoutFactory.fillDefaults().numColumns(4).equalWidth(false).applyTo(titleComposite);
			editButton = new Button(titleComposite, SWT.None);
			editButton.setImage(Icon.COMMAND_EDIT.getImage(IconSize._16x16_DefaultIconSize));
			//editButton.setToolTipText(Messages.TaskTableControlRenderer_ToolTipEditTask);
			editButton.setEnabled(false);
			
			editButton.addSelectionListener(new SelectionAdapter() 
			{
				@Override
				public void widgetSelected(SelectionEvent e) 
				{			
					EditRegisterAction editRegisterAction = new EditRegisterAction(getTableViewer());
					editRegisterAction.run();
				}
			});
			
			
			TableViewer tableViewer = (TableViewer)getTableViewer();
			tableViewer.addDoubleClickListener(new IDoubleClickListener()
			{
				@Override
				public void doubleClick(DoubleClickEvent event)
				{
					EditRegisterAction editRegisterAction = new EditRegisterAction(getTableViewer());
					editRegisterAction.run();
				}
			});

			
		}

		return control;
	}

	private void doEdit(Shell shell)
	{
		StructuredSelection selection = (StructuredSelection) getTableViewer().getSelection();
		Object selObject = selection.getFirstElement();
		
		if (selObject	instanceof Register)
		{
			ECPProject ecpProject = ArchivUtils.getArchivProject();
			Register register = (Register) selObject;			
			Ordner parentObject = (Ordner) register.eContainer();
			
			//RegisterDialog dialog = new RegisterDialog(Display.getDefault().getActiveShell(), eObject);
			RegisterDialog dialog = new RegisterDialog(
					Display.getDefault().getActiveShell(), parentObject, register);
			if (dialog.open() == RegisterDialog.OK)
			{									
				ECPHandlerHelper.saveProject(ecpProject);
				
				// Broker informiert
				Object [] data = new Object[]{parentObject, register};
				Activator.getEventBroker().post(ArchivViewEvent.ARCHIV_VIEWEVENT_UPDATEREGISTER, data);				
			}
			else
			{
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(register);				
				domain.getCommandStack().undo();
			}
		}
	}

	/*
	@Override
	protected void dispose()
	{
		//eventBroker.unsubscribe(archivViewHandler);
		super.dispose();
	}
	*/

	// Composite der Buttons ermitteln
	private Composite getTitleComposite(Composite parent)
	{
		Control[]controls =  parent.getChildren();
		for(Control checkControl : controls)
		{
			if (checkControl instanceof Button)
			{						
				Button btn = (Button) checkControl;				
				if(StringUtils.equals(btn.getToolTipText(),TOOLTIP_REGISTER))
				{
					titleComposite = parent;	
					break;
				}
			}
						
			if (checkControl instanceof Composite)
			{				
				getTitleComposite((Composite) checkControl);
			}			
		}
		
		return null;
	}


	
	@Override
	protected Image getImage(String path)
	{		
		if(StringUtils.contains(path, "add")) //$NON-NLS-1$
			return Icon.COMMAND_ADD.getImage(IconSize._16x16_DefaultIconSize);
		else
			if(StringUtils.contains(path, "delete")) //$NON-NLS-1$
				return Icon.COMMAND_DELETE.getImage(IconSize._16x16_DefaultIconSize);
		
		return null;
	}
	
	private TableViewerColumn[] getTableViewerColumns(TableViewer tableViewer)
	{
		TableColumn[] columns = tableViewer.getTable().getColumns();
		TableViewerColumn[] viewerColumns = new TableViewerColumn[columns.length];
		for (int i = 0; i < columns.length; i++)
		{
			TableColumn tableColumn = columns[i];
			viewerColumns[i] = (TableViewerColumn) tableColumn
					.getData(Policy.JFACE + ".columnViewer"); //$NON-NLS-1$
		}
		return viewerColumns;
	}

	/*
	@Override
	protected void applyEnable()
	{
		Button button = getAddButton();
		if((button != null) && (!button.isDisposed()))			
			super.applyEnable();
	}
	*/
	
	

}
