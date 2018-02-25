package it.naturtalent.archiv.ui.importClassic;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.action.Action;

public class ArchivImportAction extends Action
{
	@Inject
	@Optional
	private IEclipseContext context;
	
	@Override
	public void run()
	{
		
		ArchivImportDialog dialog = ContextInjectionFactory.make(ArchivImportDialog.class, context);
		dialog.open();
		super.run();

		
		
		/*
		SelectImportDialog dialog = new SelectImportDialog(LoginProcessor.shell);
		if(dialog.open() == SelectImportDialog.OK)
		{					
			ILoginServiceData [] loginDatas = dialog.getImportLoginServiceDatas();
			for(ILoginServiceData loginData : loginDatas)
				LoginProcessor.iLoginDataFactory.saveOrUpdate(loginData);
		}
		*/
	}
	
	/*
	public static ILoginServiceData readProjectData(InputStream in)
	{
		return (ILoginServiceData) JAXB.unmarshal(in, ILoginServiceData.class);
	}
	*/
}
