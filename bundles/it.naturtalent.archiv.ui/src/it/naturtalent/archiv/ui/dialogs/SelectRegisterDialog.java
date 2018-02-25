package it.naturtalent.archiv.ui.dialogs;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

import it.naturtalent.archiv.model.archiv.Archive;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.ui.ArchivUtils;

public class SelectRegisterDialog extends TitleAreaDialog
{
	private Button okButton;
	
	private Register register;

	private IEventBroker eventBroker;
	
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 * @wbp.parser.constructor
	 */
	public SelectRegisterDialog()
	{
		this(Display.getDefault().getActiveShell());
	}

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public SelectRegisterDialog(Shell parentShell)
	{
		super(parentShell);
	}
	
	@PostConstruct
	public void postConstruct(final IEventBroker eventBroker)
	{
		this.eventBroker = eventBroker;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		setMessage("dem Projekt ein Register zuordnen");
		setTitle("Register");
		Composite container = new Composite(parent, SWT.NULL);		
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Archive archive = ArchivUtils.getArchive();
		if(archive != null)
		{
			try
			{				
				ECPSWTViewRenderer.INSTANCE.render(container, archive);			
			}
			catch (ECPRendererException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Register im Viewer selektieren 
			container.addControlListener(new ControlAdapter()
			{			
				@Override
				public void controlResized(ControlEvent e)
				{
					if(register != null)
						eventBroker.post(ArchivUtils.SELECT_REGISTER_REQUEST, register);				
				}
			});
		}

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,true);
		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}
	
	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(650, 800);
	}
	

	
	@Inject
	public void handleSelection(
			@Named(IServiceConstants.ACTIVE_SELECTION) @Optional Object selectedItem)			
	{
		if (selectedItem instanceof Register)
		{			
			if(okButton != null)	
			{
				register = (Register) selectedItem;
				if(!okButton.isDisposed())
					okButton.setEnabled(true);
			}
			return;
		}		
					
		if(okButton != null)
		{
			if(!okButton.isDisposed())
				okButton.setEnabled(false);
		}
	}

	
	public void setRegister(Register register)
	{
		this.register = register;
		eventBroker.post(ArchivUtils.SELECT_REGISTER_REQUEST, register);
	}

	public Register getRegister()
	{
		return register;
	}
	
	/*
	 * TreeViewer wurde generiert im ArchivDetailRenderer(vom Renderer)
	 */
	/*
	@Inject
	@Optional
	public void handleEvent(@UIEventTopic(ArchivUtils.ARCHIV_TREEVIEWER_EVENT) TreeViewer treeViewer)
	{
		this.treeViewer = treeViewer;
		if(register != null)
		{
			treeViewer.setSelection(new StructuredSelection(register));
		}
	}
	*/
	
	
}
