package it.naturtalent.archiv.ui.dialogs1;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emfforms.spi.localization.LocalizationServiceHelper;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui1.ArchivMessageKeys;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;
import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;

/**
 * Ein Archiv auswaehlen und/oder bearbeiten.
 * 
 * @author dieter
 *
 */
public class ArchivLinkDialog extends TitleAreaDialog
{
	
	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider
	{
		public Image getColumnImage(Object element, int columnIndex)
		{
			return null;
		}

		public String getColumnText(Object element, int columnIndex)
		{
			if(element instanceof Archiv)
				return(((Archiv)element).getName());
				
			return element.toString();
		}
	}
		
	private static class ContentProvider implements IStructuredContentProvider
	{
		private Set<Archiv> archivSet;
		
		public Object[] getElements(Object inputElement)
		{
			return archivSet.toArray(new Archiv[archivSet.size()]);			
		}

		public void dispose()
		{
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
		{
			if(newInput instanceof Set)
				archivSet = (Set<Archiv>) newInput;
		}
	}

	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text txtSearch;
	private TableViewer tableViewer;
	private Table table;
	private Archiv selectedArchiv;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ArchivLinkDialog(Shell parentShell)
	{
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(final Composite parent)
	{
		setMessage("ein Archive auswählen");
		setTitle("Archiv");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Section sctnNewSection = formToolkit.createSection(container, Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText(LocalizationServiceHelper.getString(getClass(), ArchivMessageKeys.ArchivLinkDialog_ArchivSectionLabel));
		
		Composite composite = new Composite(sctnNewSection, SWT.NONE);
		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);
		sctnNewSection.setTextClient(composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		// add - neues Archiv hinzufuegen
		Button btnAddArchiv = formToolkit.createButton(composite, "", SWT.NONE);
		btnAddArchiv.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				// eine neues Archiv erzeugen				
				EClass newMEType = ArchivPackage.eINSTANCE.getArchiv();
				EPackage ePackage = newMEType.getEPackage();
				Archiv newArchiv = (Archiv) ePackage.getEFactoryInstance().create(newMEType);

				// neues Archiv editieren
				DefaultEObjectDialog dialog = new DefaultEObjectDialog(parent.getShell(), newArchiv);
				dialog.create();
				dialog.setTitle("Archiv");
				dialog.setMessage("eine neues Archiv definieren");
				if(dialog.open() == DefaultEObjectDialog.OK)
				{
					// das neue Archiv im Projekt speichern und speichern
					ECPProject project = ArchivUtils.getArchivProject();
					project.getContents().add(newArchiv);
					ECPHandlerHelper.saveProject(project);
					
					tableViewer.add(newArchiv);
				}
			}
		});
		btnAddArchiv.setImage(Icon.COMMAND_ADD.getImage(IconSize._16x16_DefaultIconSize));
		btnAddArchiv.setToolTipText("ein neues Archiv hinzufüegen");
		
		txtSearch = formToolkit.createText(container, "New Text", SWT.NONE);
		txtSearch.setText("");
		txtSearch.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			public void selectionChanged(SelectionChangedEvent event)
			{
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				Object selObject = selection.getFirstElement();
				if (selObject instanceof Archiv)
					selectedArchiv = (Archiv) selObject;						
			}
		});
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(table);
		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setContentProvider(new ContentProvider());
		new Label(container, SWT.NONE);
		
		initViewer();

		return area;
	}
	
	private void initViewer()
	{
		Set<Archiv> archivSet = new HashSet<Archiv>();
		ECPProject archivProject = ArchivUtils.getArchivProject();
		EList<Object> archivObjects = archivProject.getContents();
		for(Object archivObject : archivObjects)
		{
			if (archivObject instanceof Archiv)
				archivSet.add((Archiv)archivObject);
		}
		
		tableViewer.setInput(archivSet);		
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize()
	{
		return new Point(450, 494);
	}

	public Archiv getSelectedArchiv()
	{
		return selectedArchiv;
	}


	

}
