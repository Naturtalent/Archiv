package it.naturtalent.archiv.ui.dialogs1;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;

import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;

public class NewArchivDialog extends TitleAreaDialog
{
	private Table table;
	
	private TableViewer tableViewer;
	
	private String selectedElement;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public NewArchivDialog(Shell parentShell)
	{
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent)
	{
		setMessage("einzufügendes Element auswählen");
		setTitle("Hinzufügen");
		setTitleImage(Icon.WIZBAN_NEW.getImage(IconSize._75x66_TitleDialogIconSize));
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		tableViewer = new TableViewer(container, SWT.BORDER | SWT.FULL_SELECTION);
		tableViewer.addSelectionChangedListener(new ISelectionChangedListener()
		{
			public void selectionChanged(SelectionChangedEvent event)
			{
				IStructuredSelection selection = tableViewer.getStructuredSelection();
				Object selObj = (String) selection.getFirstElement();
				if (selObj instanceof String)
					selectedElement = (String) selection.getFirstElement();						
			}
		});
		table = tableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tableViewer.setContentProvider(new ArrayContentProvider());

		return area;
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
		return new Point(450, 300);
	}

	public void setElements(String[] elements)
	{
		tableViewer.setInput(elements);
		if(selectedElement != null)
			tableViewer.setSelection(new StructuredSelection(selectedElement));
	}

	public String getSelectedElement()
	{
		return selectedElement;
	}

	public void setSelectedElement(String selectedElement)
	{ 
		this.selectedElement = selectedElement;	
	}


}
