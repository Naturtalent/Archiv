package it.naturtalent.archiv.ui.dialogs1;

import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.ui.util.ECPModelElementOpener;
import org.eclipse.swt.widgets.Display;

import archive.Register;

public class ArchivRegisterOpener implements ECPModelElementOpener
{

	public ArchivRegisterOpener()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public void openModelElement(Object element, ECPProject ecpProject)
	{
		if(element instanceof Register)
		{
			RegisterDialog dialog = new RegisterDialog(Display.getDefault().getActiveShell(), (Register)element);
			dialog.open();
		}

	}

}
