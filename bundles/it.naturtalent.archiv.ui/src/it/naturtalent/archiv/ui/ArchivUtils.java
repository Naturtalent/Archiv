package it.naturtalent.archiv.ui;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.core.ECPProject;
import org.eclipse.emf.ecp.core.ECPProjectManager;
import org.eclipse.emf.ecp.core.util.ECPUtil;

import it.naturtalent.archiv.model.archiv.Archiv;
import it.naturtalent.archiv.model.archiv.ArchivPackage;
import it.naturtalent.archiv.model.archiv.Archive;
import it.naturtalent.archiv.model.archiv.Ordner;
import it.naturtalent.archiv.model.archiv.Register;
import it.naturtalent.emf.model.EMFModelUtils;

public class ArchivUtils
{
	
	//public final static String ARCHIV_TREEVIEWER_EVENT = "archivtreeviewerevent";
	
	// Name des ECP Projekts indem die ArchivDaten gespeichert werden
	public final static String ARCHIVPROJECTNAME = "ArchivEMFProject";
		
	public final static String SELECT_ARCHIV_REQUEST = "selectArchivRequest";
	public final static String SELECT_REGISTER_REQUEST = "selectRegisterRequest";
	
	//MasterTreeRefreshing erforderlich z.B. nach Aenderung des RegisterTypes im Ordner
	public final static String REFRESH_MASTER_REQUEST = "refreshmasterrequest";
	
	//einen Ordner selektieren
	public final static String SELECT_ORDNER_REQUEST = "selectordnerrequest";
	
	// Im MasterTree hat eine Selektion stattgefunden
	public final static String ARCHIVE_SELECTION_EVENT = "archiveselectionevent";
	
	// Ecore Model Definition - Attribute in Ordner
	public final static String FEATURE_REGISTERTYPE = "registerType";
	
	private static Archive archive;
		
	private static Log log = LogFactory.getLog(ArchivUtils.class);


	/**
	 * Den Rootcntainer Archive zurueckgeben.
	 * @return
	 */
	public static Archive getArchive()
	{
		if(archive != null)
			return archive;
		
		ECPProject ecpProject = getArchivProject();
		if (ecpProject != null)
		{
			EList<Object> projectContents = ecpProject.getContents();
			if (!projectContents.isEmpty())
			{
				for (Object projectContent : projectContents)
				{
					if (projectContent instanceof Archive)
					{
						archive = (Archive) projectContent;
						break;
					}
				}
			}
			else
			{
				// Archive erzeugen und ECPProject speichern
				EClass archiveClass = ArchivPackage.eINSTANCE.getArchive();
				archive = (Archive) EcoreUtil.create(archiveClass);
				projectContents.add(archive);
				ECPProject ecpArchivProject = getArchivProject();
				if (ecpArchivProject != null)
					ecpArchivProject.saveContents();
			}
		}
		
		return archive;
	}
		

	/**
	 * Das Archiv-ECPProject zurueckgeben.
	 * 
	 * @return
	 */
	private static ECPProject ecpArchivProject;
	public static ECPProject getArchivProject()
	{
		if(ecpArchivProject == null)
			ecpArchivProject = ECPUtil.getECPProjectManager().getProject(ARCHIVPROJECTNAME);
		
		if(ecpArchivProject == null)
		{
			ecpArchivProject = EMFModelUtils.createProject(ARCHIVPROJECTNAME);
			if(ecpArchivProject == null)
				log.error("es konnte kein ECPProject erzeugt werden");
		}
		
		return ecpArchivProject;
	}
	
	/**
	 * In allen Archiven nach einem Register suchen, dass mit einem Project gekoppelt ist
	 * 
	 * @param iProjectID
	 * @return
	 */
	public static Register findIProjectRegister(String iProjectID)
	{
		if (StringUtils.isNotEmpty(iProjectID))
		{
			Archive archive = getArchive();
			if (archive != null)
			{
				for (Archiv archiv : archive.getArchiv())
				{
					for (Ordner ordner : archiv.getOrdner())
					{
						for (Register register : ordner.getRegisters())
						{
							if (StringUtils.equals(register.getProjectID(),iProjectID))
								return register;
						}
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * @param ordner
	 * @param start
	 * @return
	 */
	public static short autoRegisterNumber(Ordner ordner, short start)
	{
		start = (start <= 0) ? 1 : start;
		
		short [] numbers = getArchivNumbers(ordner);
		if(ArrayUtils.isNotEmpty(numbers))
		{
			for(short i = start;i < 100;i++)
			{
				if(!ArrayUtils.contains(numbers, i))
					return i;
			}
		}
		
		return 1;
	}
	
	/**
	 * Alle im Ordner verwendeten Nummern auflisten.
	 * 
	 * @param archivData
	 * @return
	 */
	private static short [] getArchivNumbers(Ordner ordner)
	{
		short [] numArray = null;
		
		EList<Register>registers = ordner.getRegisters();
		if((registers != null) && (!registers.isEmpty()))
		{
			for(Register register : registers)
			{
				short num = register.getNumericData();				
				if(num > 0)
					numArray = ArrayUtils.add(numArray, num);
			}
			//Arrays.sort(numArray);
		}

		return numArray;
	}
	
	public static String autoRegisterAlpha(Ordner ordner, String letter)
	{
		letter = (StringUtils.isEmpty(letter)) ? "A" : letter;
		
		String [] alphaArray = getArchivLetters(ordner);
		if(ArrayUtils.isNotEmpty(alphaArray))
		{
			for(char c = 'A';c < 'Z';c++)
			{				
				if(!ArrayUtils.contains(alphaArray, String.valueOf(c)))
					return String.valueOf(c);
			}
		}
		
		return "A";
	}

	
	/**
	 * Alle im Ordner verwendeten Buchstaben auflisten.
	 * 
	 * @param archivData
	 * @return
	 */
	public static String [] getArchivLetters(Ordner ordner)
	{
		String [] alphaArray = null;
		
		EList<Register>registers = ordner.getRegisters();
		if((registers != null) && (!registers.isEmpty()))
		{
			for(Register register : registers)
			{
				String alpha = register.getAlphaData();				
				if(StringUtils.isNotEmpty(alpha))
					alphaArray = ArrayUtils.add(alphaArray, alpha);
			}
		}

		return alphaArray;
	}
	
	
}
