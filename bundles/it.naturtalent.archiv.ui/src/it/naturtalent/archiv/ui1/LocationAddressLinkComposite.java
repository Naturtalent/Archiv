package it.naturtalent.archiv.ui1;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;

import it.naturtalent.archiv.ui.dialogs1.DefaultEObjectDialog;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;


public class LocationAddressLinkComposite extends Composite
{
	private final FormToolkit toolkit = new FormToolkit(Display.getDefault());

	private ImageHyperlink hyperlink;
	private Button btnAdd;
	private Button btnDelete;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public LocationAddressLinkComposite(final Composite parent, int style)
	{
		super(parent, style);
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
		
		Composite composite = toolkit.createComposite(this, SWT.NONE);
		composite.setBackground(parent.getBackground());
		GridLayout gl_composite = new GridLayout(3, false);		
		gl_composite.marginHeight = 0;
		composite.setLayout(gl_composite);
		GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_composite.heightHint = 25;
		composite.setLayoutData(gd_composite);
		toolkit.paintBordersFor(composite);
		
		hyperlink = toolkit.createImageHyperlink(composite, SWT.NONE);
		toolkit.paintBordersFor(hyperlink);
		hyperlink.setBackground(parent.getBackground());
		hyperlink.setText("Adresse");
		
		btnAdd = new Button(composite, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// eine neues Adressobjekt erzeugen
				EClass newMEType = (EClass) ArchivPackage.eINSTANCE.getAdresse();
				EPackage ePackage = newMEType.getEPackage();
				EObject eObject = ePackage.getEFactoryInstance().create(newMEType);
				
				/*
				DefaultEObjectDialog dialog = new DefaultEObjectDialog(parent.getShell(), eObject);
				dialog.create();
				dialog.setTitle("Archivstandort");
				dialog.setMessage("Standort über eine Adresse definieren");
				if(dialog.open() == DefaultEObjectDialog.OK)
					((Archiv)eObject).setAdresse((Adresse)eObject);
					*/
			}
		});
		toolkit.adapt(btnAdd, true, true);
		btnAdd.setImage(Icon.COMMAND_ADD.getImage(IconSize._16x16_DefaultIconSize));
		
		btnDelete = toolkit.createButton(composite, "", SWT.NONE);
		btnDelete.setImage(Icon.COMMAND_DELETE.getImage(IconSize._16x16_DefaultIconSize));
	}
	
	

	public ImageHyperlink getHyperlink()
	{
		return hyperlink;
	}

	


	public Button getBtnAdd()
	{
		return btnAdd;
	}



	public Button getBtnDelete()
	{
		return btnDelete;
	}



	@Override
	protected void checkSubclass()
	{
		// Disable the check that prevents subclassing of SWT components
	}

}
