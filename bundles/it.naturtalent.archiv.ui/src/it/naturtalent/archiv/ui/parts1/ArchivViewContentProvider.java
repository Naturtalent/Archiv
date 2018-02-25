package it.naturtalent.archiv.ui.parts1;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.TreeItem;

import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;




public class ArchivViewContentProvider implements ITreeContentProvider
{

	private StructuredViewer treeViewer;
	
	private Object[] archivContent;
	
	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
	{
		this.treeViewer = (StructuredViewer) viewer;
		
		if(newInput instanceof ECPProject)
		{
			ECPProject project = (ECPProject) newInput;
			EList<Object>objects = project.getContents();
			archivContent = objects.toArray(new Object[objects.size()]);			
		}
	}

	@Override
	public Object[] getElements(Object inputElement)
	{
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement)
	{
		if(parentElement instanceof ECPProject)
		{
			return archivContent;
			/*
			ECPProject project = (ECPProject) parentElement;
			EList<Object>objects = project.getContents();			
			return objects.toArray(new Object[objects.size()]);
			*/
		}
	
		if(parentElement instanceof Ordner)
		{
			Ordner ordner = (Ordner) parentElement;
			EList<Register>registers = ordner.getRegisters();
			return registers.toArray(new Object[registers.size()]);
		}

		
		return new Object[0];
	}

	@Override
	public Object getParent(Object element)
	{
		
		if(element instanceof Register)
		{
			TreeItem treeItem = (TreeItem)treeViewer.testFindItem(element);
			if(treeItem != null)
				return treeItem.getParentItem().getData();
		}
		
		return null;
	}

	@Override
	public boolean hasChildren(Object element)
	{
		return getChildren(element).length > 0;
	}

}
