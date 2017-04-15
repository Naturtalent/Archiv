package it.naturtalent.archiv.ui1;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Composite;

import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.parts1.ArchivViewContentProvider;
import it.naturtalent.archiv.ui.parts1.ArchivViewLabelProvider;
import it.naturtalent.emf.model.parts.DefaultMasterComposite;
import it.naturtalent.emf.model.parts.DefaultMasterDetailsModelView;

public class ArchivProjectWizardView extends DefaultMasterComposite
{

	public ArchivProjectWizardView(Composite parent, int style)
	{
		super(parent, style);
		// TODO Auto-generated constructor stub
	}

	/*
	@Override
	public void postConstruct(Composite parent)
	{		
		super.postConstruct(parent);
		
		ecpProject = Activator.getECPProject();
		StructuredViewer masterViewer = getMasterViewer();
		
		masterViewer.setContentProvider(new ArchivViewContentProvider());
		masterViewer.setLabelProvider(new ArchivViewLabelProvider());
		masterViewer.setInput(Activator.getECPProject());

	}
	*/
	
	


}
