package it.naturtalent.archiv.ui.actions1;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.dialogs1.OrdnerDialog;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.icons.core.Icon;
import it.naturtalent.icons.core.IconSize;


public class AddOrdnerAction extends DefaultModelAction
{

	public AddOrdnerAction(StructuredViewer viewer)
	{
		super(viewer);
		setImageDescriptor(Icon.COMMAND_ADD.getImageDescriptor(IconSize._16x16_DefaultIconSize));
	}
	
	//@Override
	public void run()
	{
		// neuen Ordner erzeugen und im ECPProject speichern 
		final ECPProject ecpProject = ArchivUtils.getArchivProject();
		EClass newMEType  = ArchivPackage.eINSTANCE.getOrdner();
		EPackage ePackage = newMEType.getEPackage();	
		final EObject eObject = ePackage.getEFactoryInstance().create(newMEType);	
		((Ordner)eObject).setLabel("neuer ordner");
		ecpProject.getContents().add(eObject);
		
		OrdnerDialog dialog = new OrdnerDialog(
				Display.getDefault().getActiveShell(), eObject);
		if (dialog.open() == Dialog.OK)
		{			
			//EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(ecpProject);			
			ecpProject.getEditingDomain().getCommandStack().execute(new ChangeCommand(eObject)
			{
				@Override
				protected void doExecute()
				{					
					ECPHandlerHelper.saveProject(ecpProject);				
					eventBroker.send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, eObject);
					eventBroker.send(ModelEventKey.DEFAULT_NEW_MODELEVENT, eObject);
				}
			});			
		}
		else
		{
			undo();

			// aus dem ECPProject entfernen
			List<Object> delObjects = new ArrayList<Object>();
			delObjects.add(eObject);
			ecpProject.deleteElements(delObjects);
		}
		
	}	
	
/*
	@Override
	public void run()
	{
		// neuen Ordner erzeugen und im ECPProject speichern 	
		final ECPProject ecpProject = Activator.getECPProject();
		EClass newMEType = ArchivePackage.eINSTANCE.getOrdner();
		EPackage ePackage = newMEType.getEPackage();
		final EObject newMEInstance = ePackage.getEFactoryInstance().create(newMEType);
		ecpProject.getContents().add(newMEInstance);
		
		
		OrdnerDialog dialog = new OrdnerDialog(
				Display.getDefault().getActiveShell(), newMEInstance);
		if (dialog.open() == Dialog.OK)
		{		
			EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(ecpProject);			
			domain.getCommandStack().execute(new ChangeCommand(newMEInstance)
			{
				@Override
				protected void doExecute()
				{					
					viewer.refresh(ecpProject);
					viewer.setSelection(new StructuredSelection(eObject));
				}
			});
		}
		else
		{
			// aus dem ECPProject entfernen
			List<Object> delObjects = new ArrayList<Object>();
			delObjects.add(eObject);
			ecpProject.deleteElements(delObjects);
		}
	
	}
	*/
	

}
