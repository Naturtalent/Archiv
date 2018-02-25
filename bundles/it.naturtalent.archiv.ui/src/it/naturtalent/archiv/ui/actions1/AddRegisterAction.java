package it.naturtalent.archiv.ui.actions1;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.widgets.Display;


import it.naturtalent.archiv.ui.dialogs1.RegisterDialog;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;
import it.naturtalent.emf.model.actions.DefaultModelAction;
import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl;

/**
 * Toolbaraktion einem Ordner ein neues Register hinzufuegen.
 * Der 'Parentordner' muss der Action uebergeben werden.
 * 
 * @author A682055
 *
 */
public class AddRegisterAction extends DefaultModelAction
{
	
	private String newRegisterLabel;
	
	
	public AddRegisterAction(StructuredViewer viewer)
	{
		super(viewer);		
	}

	@Override
	public void run()
	{
		// ist ein ParentOrdner gespeichert
		if(geteObject() instanceof Ordner)
		{
			Ordner parentOrdner = (Ordner) geteObject();
			if (parentOrdner != null)
			{
				// eine neues Register erzeugen
				EClass newMEType = ArchivPackage.eINSTANCE.getRegister();
				EPackage ePackage = newMEType.getEPackage();				
				Register register = (Register) ePackage.getEFactoryInstance().create(newMEType);
				
				if(StringUtils.isNotEmpty(newRegisterLabel))
					register.setLabel(newRegisterLabel);
				
				RegisterDialog registerDialog = new RegisterDialog(
						Display.getDefault().getActiveShell(), parentOrdner, register);						
				registerDialog.setTitle("Add Register");
				registerDialog.setMessage("ein neues Register hinzufuegen");
				
				// Registerdialog oeffnen
				if (registerDialog.open() == RegisterDialog.OK)
				{
					// das neue Register via AddCommand dem Modell hinzufuegen
					EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(parentOrdner);		
					EReference eReference = ArchivPackageImpl.eINSTANCE.getOrdner_Registers();					
					Command addCommand = AddCommand.create(domain, parentOrdner , eReference, register);
					if(addCommand.canExecute())
					{
						domain.getCommandStack().execute(addCommand);
						eventBroker.send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, register);
						seteObject(register);
					}
				}				
			}
		}
	}

	public void setNewRegisterLabel(String newRegisterLabel)
	{
		this.newRegisterLabel = newRegisterLabel;
	}


	

}
