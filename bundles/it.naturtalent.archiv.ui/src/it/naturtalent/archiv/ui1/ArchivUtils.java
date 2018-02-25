package it.naturtalent.archiv.ui1;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.emf.model.ModelEventKey;
import it.naturtalent.emf.model.ModelEventKeys;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.archiv.model.archiv.RegisterType;
import it.naturtalent.archiv.model.archiv.impl.ArchivPackageImpl;

public class ArchivUtils
{
	/**
	 * Zu welchem Ordner gehoert das Register 'childRegister'
	 * @param childRegister
	 * @return
	 */
	public static Ordner findParentOrdner(Register childRegister)
	{
		if (childRegister instanceof Register)
		{
			EList<Object> archivObjects = it.naturtalent.archiv.ui.ArchivUtils.getArchivProject().getContents();
			for (Object archivObject : archivObjects)
			{
				if (archivObject instanceof Ordner)
				{
					Ordner ordner = (Ordner) archivObject;
					EList<Register> registers = ordner.getRegisters();
					if (registers.contains(childRegister))
						return (Ordner) archivObject;
				}
			}
		}
		 
		return null;
	}
	
	/**
	 * Fuegt dem Ordner ein neues Register 'childRegister' hinzu.
	 * 
	 * @param newParentOrdner
	 * @param childRegister
	 */
	public static boolean autoAddRegister(Ordner newParentOrdner, Register childRegister)
	{
		if (childRegister != null) 
		{			
			Ordner oldParentOrdner = (Ordner) childRegister.eContainer();
			if (!newParentOrdner.equals(oldParentOrdner))
			{
				String dialogRegisterLabel = (childRegister
						.getProjectID() != null) ? childRegister.getLabel()
								: Messages.ArchivUtils_NewRegisterLabel;
						
				if (MessageDialog.openQuestion(
						Display.getDefault().getActiveShell(),
						Messages.ArchivUtils_AddRegisterLabel,
						Messages.bind(
								Messages.ArchivUtils_QuestionInsertRegistger,
								dialogRegisterLabel,
								newParentOrdner.getLabel())))
				{
					// das childRegister aus dem bisherigen Ordner entfernen
					if (oldParentOrdner != null)
					{
						EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(oldParentOrdner);		
						EReference eReference = ArchivPackageImpl.eINSTANCE.getOrdner_Registers();					
						Command delCommand = DeleteCommand.create(domain, childRegister);
						if(delCommand.canExecute())
							domain.getCommandStack().execute(delCommand);

						//oldParentOrdner.getRegisters().remove(childRegister);
					}

					// Register hinzufuegen
					autoSetRegisterTypeData(newParentOrdner, childRegister);
					EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor(newParentOrdner);		
					EReference eReference = ArchivPackageImpl.eINSTANCE.getOrdner_Registers();					
					Command addCommand = AddCommand.create(domain, newParentOrdner , eReference, childRegister);
					if(addCommand.canExecute())
						domain.getCommandStack().execute(addCommand);
					
					Activator.getEventBroker().send(ModelEventKey.DEFAULT_UNDO_MODELEVENT, childRegister);					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void autoSetRegisterTypeData(Ordner parentOrdner, Register childRegister)
	{
		RegisterType type = parentOrdner.getRegisterType();
		switch (type)
			{
				case NUMERIC_TYPE:
					short number = NumericRegisterComposite.autoRegisterNumber(parentOrdner, (short) 0);
					childRegister.setNumericData(number);
					break;

				case LETTER_TYPE:
					String alpha = LetterRegisterComposite.autoRegisterAlpha(parentOrdner, null);
					childRegister.setAlphaData(alpha);
					break;
					
				default:
					break;
			}
	}
	
}
