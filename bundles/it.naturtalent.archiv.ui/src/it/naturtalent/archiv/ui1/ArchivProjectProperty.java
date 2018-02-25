package it.naturtalent.archiv.ui1;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecp.spi.ui.util.ECPHandlerHelper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;

import it.naturtalent.archiv.ui.Activator;
import it.naturtalent.archiv.ui.ArchivUtils;
import it.naturtalent.archiv.ui.actions1.SaveAction;
import it.naturtalent.e4.project.ui.DefaultNtProjectProperty;
import it.naturtalent.emf.model.EMFModelUtils;
import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Archive;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;



/**
 * @author A682055
 *
 * Erweitert das NtProjekt um die Archivfunktionalitaet.
 * 
 */
public class ArchivProjectProperty extends DefaultNtProjectProperty
{
	
	public ArchivProjectProperty()
	{
		ecpProject = ArchivUtils.getArchivProject();
		undoEventKey = ArchivViewEvent.ARCHIV_EVENT_UNDO;
		deleteEventKey = ArchivViewEvent.ARCHIV_EVENT_DELETE;
	}

	// interner Wizard
	public class ActionArchivWizard extends Wizard
	{
		@Override
		public void addPages()
		{			
			addPage(createWizardPage());
		}

		@Override
		public boolean performFinish()
		{			
			return true;
		}
		
		@Override
		public boolean performCancel()
		{
			// TODO Auto-generated method stub
			return super.performCancel();
		}
	}

	private static final String NEW_REGISTER_LABEL = "neues Register";
	
	// in diesem Ordner war das Register bisher zugeordnet
	private Ordner oldParentOrdner;
	
	// in diesem Ordner ist das Register jetzt zugeordnet
	private Ordner newParentOrdner;
	
	private IEclipseContext context;
		
	private ArchivProjectPropertyWizardPage page;
	
		
	//private final static String TASK_EMFPROJECT_NAME = "Jahresprojekt";
		
	//private static ECPProjectManager projectManager = null;
	//private static ECPProject ecpProject = null;
	private Map<String, Object> attributeMap;
	
	private Log log = LogFactory.getLog(this.getClass());
	
	
	
	
	
	/*
	public TasksProjektProperty()
	{
		if(projectManager == null)
			projectManager = ECPUtil.getECPProjectManager();
		
		if(ecpProject == null)
			ecpProject = projectManager.getProject(Activator.TASKSPROJECTNAME);
	}
	*/
	
	

	@Override
	public void setNtProjectID(String ntProjectID)
	{
		// TODO Auto-generated method stub
		super.setNtProjectID(ntProjectID);
	}



	@Override
	public String getLabel()
	{				
		return "Ordner (ArchivProjectProperty)";
	}

	@Override
	public String toString()
	{
		if(ntPropertyData == null)
			init();
			
		if(ntPropertyData != null)
			return ((Register)ntPropertyData).getLabel();
			
		return "ArchivProjectProperty " + super.toString();
	}
	
	@PostConstruct
	public void postConstruct(IEclipseContext context)
	{
		this.context = context;	
	}

	
	@Override
	public IWizardPage createWizardPage()
	{
		// spezifische WizardPage ArchiveProperty erzeugen 
		page = ContextInjectionFactory.make(ArchivProjectPropertyWizardPage.class, context);
		page.setArchivProjectProperty(this);
				
		if(ntPropertyData == null)
		{
			// Initialisierung erforderlich
			if(init() == null)
			{		
				// neues Register erzeugen 
				EClass newMEType = ArchivPackage.eINSTANCE.getRegister();
				EPackage ePackage = newMEType.getEPackage();
				ntPropertyData = ePackage.getEFactoryInstance().create(newMEType);
				Register register = (Register)ntPropertyData;
				register.setProjectID(ntProjectID);
				register.setLabel(NEW_REGISTER_LABEL);
				//setWizardModus(ADD_WIZARD_MODUS);
			}
		}
		
		/*
		if(ntPropertyData == null)
		{
			// neues Register erzeugen 
			EClass newMEType = ArchivePackage.eINSTANCE.getRegister();
			EPackage ePackage = newMEType.getEPackage();
			ntPropertyData = ePackage.getEFactoryInstance().create(newMEType);		
			
			((Register)ntPropertyData).setLabel(NEW_REGISTER_LABEL);
		}
		else
		{
			// ein bestehendes Register im Wizard bearbeiten
			wizardmodus = EDIT_WIZARD_MODUS;
			
			
			//if(ntPropertyData != null)
			//{
				//StructuredViewer viewer = page.getMasterViewer();
				//Ordner ordner = ArchivUtils.findParentOrdner((Register) ntPropertyData);
							
				//((TreeViewer)viewer).expandToLevel(ordner, 1);
				//viewer.reveal(ntPropertyData);
				//viewer.setSelection(new StructuredSelection(ntPropertyData));
			//}
			
			
		}
		*/
				
		page.setRegister((Register) ntPropertyData);
		
		return page;
	}
	
	
	//@Override
	public Action createAction()
	{
		
		Action action = new Action()
		{
			@Override
			public void run()
			{						
				Wizard internWizard = new ActionArchivWizard();
				WizardDialog dialog = new WizardDialog(Display.getDefault().getActiveShell(), internWizard);
				dialog.open();
			}
		};

		
		
		/*
		Action action = new Action()
		{
			@Override
			public void run()
			{
				OrdnerDialog dialog = new OrdnerDialog(
						Display.getDefault().getActiveShell(),
						(EObject) ntPropertyData);
				dialog.open();
			}
		};
		*/
		
		return action;
	}



	@Override
	public void commit()
	{
		if (validateRegisterforSave())
		{
			SaveAction saveAction = new SaveAction(null);
			saveAction.seteObject((EObject) ntPropertyData);
			saveAction.run();
		}
			
			/*
			if(wizardmodus == ADD_WIZARD_MODUS)
			{
				Register register = (Register) ntPropertyData;
				register.setProjectID(getNtProjectID());
				String label = register.getLabel(); 
				if(StringUtils.isEmpty(label) || (StringUtils.equals(label, NEW_REGISTER_LABEL)))
				{
					IProject iProject =  findIProject(getNtProjectID());
					try
					{
						String name = iProject.getPersistentProperty(INtProject.projectNameQualifiedName);
						register.setLabel(name);
					} catch (CoreException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}					
			}
						
			ECPProject ecpProject = Activator.getECPProject();			
			ECPHandlerHelper.saveProject(ecpProject);

			Object[] data = new Object[]{ parentOrdner, ntPropertyData };
			Activator.getEventBroker().post(ArchivViewEvent.ARCHIV_VIEWEVENT_ADDREGISTER, data);
			*/
	
	}
	
	/**
	 * ist 'ntPropertyData' formell gueltig zum speichern 
	 * @return
	 */
	private boolean validateRegisterforSave()
	{
		if (ntPropertyData instanceof Register)
		{
			Register register = (Register) ntPropertyData;
			
			// hat das Register eine Projektzuordnung und eine gueltige Bezeichung
			if (StringUtils.isNotEmpty(register.getProjectID()) && StringUtils.isNotEmpty(register.getLabel()))
			{
				// ist das Register im 'Ordner' eingetragen
				if (newParentOrdner != null)
				{
					List<Register> ordnerRegisters = newParentOrdner.getRegisters();
					if (ordnerRegisters != null)
					{
						for (Register ordnerRegister : ordnerRegisters)
							if (ordnerRegister.equals(register))
								return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/* In allen Ordnern nach dem Register suchen, das mit dem Projekt 'ntProjectID' verlinkt ist.
	 * Das verlinkte Register wird zurueckgegeben und gleichzeitig in 'ntPropertyData' hinterlegt.
	 * @see it.naturtalent.e4.project.DefaultNtProjectProperty#loadNtProjectProperty()
	 */
	@Override
	public Object init()
	{
		
		Archive archiveRoot = ArchivUtils.getArchive();
		List<Archiv>archive =  archiveRoot.getArchiv();
		for(Archiv archiv : archive)
		{
			List<Ordner>ordners = archiv.getOrdner();
			for(Ordner ordner : ordners)
			{
				List<Register>registers = ordner.getRegisters();
				for(Register register : registers)
				{
					if(StringUtils.equals(register.getProjectID(), ntProjectID))
					{													
						ntPropertyData = register;
						oldParentOrdner = ordner;
						return ntPropertyData;
					}
				}
			}
		}

		
		
		/*
		ntPropertyData = null;
		ecpProject = Activator.getECPProject();
		EList<Object>contents = ecpProject.getContents();
		for(Object content : contents)
		{
			if(content instanceof Ordner)
			{
				Ordner ordner = (Ordner) content;
				List<Register>registers = ordner.getRegisters();
				if(registers != null)
				{
					for(Register register : registers)
					{
						if(StringUtils.equals(register.getProjectID(), ntProjectID))
						{							
							attributeMap = EMFModelUtils.saveAttributes((EObject) content);
							ntPropertyData = register;
							oldParentOrdner = ordner;
							return ntPropertyData;
						}
					}
				}
			}
		}
		*/
		
		// 
		log.error("keine Propertydaten im Modell gespeichert");
		return ntPropertyData;
	}
	
	/**
	 * Im Zuge des Loeschen eines Projekts wird auch das verlinkte Register geloescht
	 * 
	 */
	@Override
	public void delete()
	{		
		if (ecpProject != null)
		{
			Object projectContent = init();
			if (projectContent instanceof Register)
			{
				Register register = (Register) projectContent;
				Ordner newParentOrdner = (Ordner) register.eContainer();
				List<Register>registers = newParentOrdner.getRegisters();
				registers.remove(register);				
				ECPHandlerHelper.saveProject(ecpProject);
				
				// Broker informiert
				Object [] data = new Object[]{newParentOrdner, register};					
				Activator.getEventBroker().post(ArchivViewEvent.ARCHIV_VIEWEVENT_REMOVEREGISTER, data);
			}
		}
	}


}
