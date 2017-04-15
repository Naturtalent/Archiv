package it.naturtalent.archiv.ui1;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.internal.edit.ECPControlHelper;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

import archive.Archiv;
import archive.ArchiveFactory;
import archive.Ordner;
import archive.impl.ArchivePackageImpl;
import it.naturtalent.archiv.ui.dialogs1.ArchivLinkDialog;
import it.naturtalent.archiv.ui.dialogs1.OrdnerDialog;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

/**
 * Vom ArchivLinkRenderer benutztes Layout zur Darstellung des einem Ordner zugeordneten Archivs.
 * Der Zielordner wird vom Renderer uebergeben.
 * 
 * @author dieter
 *
 */
public class ArchivLinkRendererComposite extends Composite
{
	private final FormToolkit toolkit = new FormToolkit(Display.getDefault());
	
	private ArchivLinkRenderer archivLinkRenderer;
	
	private ImageHyperlink hyperlink;
	private Button buttonDelete;
	private Button buttonAdd;
	
	// das Archiv diese Ordners wird betrachtet 
	private Ordner ordner;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ArchivLinkRendererComposite(final Composite parent, int style, ArchivLinkRenderer archivLinkRenderer)
	{
		super(parent, style);
		
		this.archivLinkRenderer = archivLinkRenderer;
		
		addDisposeListener(new DisposeListener()
		{
			public void widgetDisposed(DisposeEvent e)
			{
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);
		
		setBackground(parent.getBackground());
		
		final Composite composite = toolkit.createComposite(this, SWT.NONE);
		composite.setBackground(parent.getBackground());
		GridLayout gl_composite = new GridLayout(3, false);		
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite.heightHint = 25;
		composite.setLayoutData(gd_composite);
		toolkit.paintBordersFor(composite);
		
		hyperlink = toolkit.createImageHyperlink(composite, SWT.NONE);
		hyperlink.addHyperlinkListener(new HyperlinkAdapter() 
		{
			@Override
			public void linkActivated(HyperlinkEvent e)
			{
				// das gelinkte Archiv oeffnen
				OrdnerDialog dialog = new OrdnerDialog(parent.getShell(), ordner.getArchiv());
				dialog.open();
				
			}			
		});
		toolkit.paintBordersFor(hyperlink);
		hyperlink.setBackground(parent.getBackground());
		//hyperlink.setText("Archiv");
		
		// ADD - Link zu einem Archiv hinzufuegen
		buttonAdd = new Button(composite, SWT.NONE);
		buttonAdd.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{				
				ArchivLinkDialog linkDialog = new ArchivLinkDialog(composite.getShell());				
				if(linkDialog.open() == ArchivLinkDialog.OK)
				{					
					EReference eReference = ArchivePackageImpl.eINSTANCE.getOrdner_Archiv();
					EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(ordner);
					Archiv archiv = linkDialog.getSelectedArchiv();
					Command setCommand = SetCommand.create(domain, ordner, eReference, archiv);
					if(setCommand.canExecute())
						domain.getCommandStack().execute(setCommand);
					updateWidgets();
				}
			}
		});
		toolkit.adapt(buttonAdd, true, true);
		buttonAdd.setImage(Icon.ICON_LINK_ADD.getImage(IconSize._16x16_DefaultIconSize));
		
		// DELETE - einen bestehenden Link entfernen
		buttonDelete = toolkit.createButton(composite, "", SWT.NONE);
		buttonDelete.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{				
				EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(ordner);
				Archiv archiv = ordner.getArchiv();
				Command delCommand = DeleteCommand.create(domain, archiv);
				if(delCommand.canExecute())
					domain.getCommandStack().execute(delCommand);
				
				updateWidgets();
			}
		});
		buttonDelete.setImage(Icon.ICON_LINK_DELETE.getImage(IconSize._16x16_DefaultIconSize));
	}

	/*
	 * Status der Widgets aktualisieren
	 */
	private void updateWidgets()
	{
		if ((ordner != null) && (!hyperlink.isDisposed()))
		{
			Archiv archiv = ordner.getArchiv();
			if (archiv == null)
			{		
				// kein Archiv zugeordnet
				hyperlink.setText(archivLinkRenderer.getUnsetText());
				hyperlink.setEnabled(false);
				buttonAdd.setEnabled(true);
				buttonDelete.setEnabled(false);
			}
			else
			{
				// kein Archiv zugeordnet
				hyperlink.setText(archiv.getName());
				hyperlink.setEnabled(true);
				buttonAdd.setEnabled(false);
				buttonDelete.setEnabled(true);
			}
		}
	}

	/**
	 * Zielordner uebergeben
	 * @param ordner
	 */
	public void setOrdner(Ordner ordner)
	{
		this.ordner = ordner;
		updateWidgets();
	}

	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}


	

}
