package it.naturtalent.archiv.ui;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import it.naturtalent.e4.project.INtProject;

public class Utils
{
	

	/**
	 * Alle ProjektIDs in einer Map mit dem Key Projektname zusammenfassen
	 * 
	 * @return
	 */
	public static Map<String, String> getAllProjects()
	{
		Map<String, String>allProjects = new HashMap<String, String>();
		
		
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		
		for(IProject project : projects)
		{
			try
			{
				if (project.isOpen())
				{
					String name = project
							.getPersistentProperty(INtProject.projectNameQualifiedName);
					if (StringUtils.isNotEmpty(name))
						allProjects.put(project.getName(), name);
				}

			} catch (CoreException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return allProjects;
	}
	
	/**
	 * Aus Nummer und Text einen Label generierern.
	 * 
	 * @param numberPrefix
	 * @param number
	 * @param text
	 * @return
	 */
	public static String generateLabel(boolean numberPrefix, int number, String text)
	{
		text = (StringUtils.isNotEmpty(text)) ? text : " ";

		// Token 'Number' entfernen
		String checkNumber = parseNumberToken(text);
		if (StringUtils.isNotEmpty(checkNumber))
			text = StringUtils.remove(text, checkNumber);

		// Nummer voransetzen
		if (numberPrefix)
			text = number + "-" + text;

		return StringUtils.trim(text);
	}

	/**
	 * Aus Nummer und Text einen Label generierern
	 * 
	 * @param number
	 * @param text
	 * @return
	 */
	public static String generateLabel(int number, String text)
	{
		return generateLabel((number > 0), number, text);
	}
	
	/*
	public static String generateLabel(int number, String text)
	{
		text = (StringUtils.isNotEmpty(text)) ? text : " ";

		// Token 'Number' entfernen
		String checkNumber = parseNumberToken(text);
		if (StringUtils.isNotEmpty(checkNumber))
			text = StringUtils.remove(text, checkNumber);

		// Nummer voransetzen
		if (number > 0)
			text = number + "-" + text;

		return StringUtils.trim(text);
	}
	*/

	/**
	 * Beginnt der Label mit einer Zahl und Bindestrich, dann wird dieser Token (Zahl und '-') zurueckgegeben,
	 * ansonsten Rueckgabe null
	 * 
	 * @param label
	 * @return
	 */
	public static String parseNumberToken(String label)	
	{
		if (StringUtils.isNotEmpty(label))
		{
			if (Character.isDigit(label.charAt(0)))
			{
				int n = 0;
				while (!(n >= label.length())
						&& Character.isDigit(label.charAt(n)))
				{
					n += 1;
				}

				String start = StringUtils.mid(label, 0, n);
				String check = StringUtils.mid(label, n, 1);
				if (StringUtils.equals(check, "-"))
					return start + check;
			}
		}

		return null;
	}

	/**
	 * Label parsen und Nummer zurueckgeben
	 * 
	 * @param label
	 * @return Nummer im Label oder (-1)
	 */
	public static int parseNumber(String label)
	{
		String token = parseNumberToken(label);
		
		if(token != null)
		{
			token = StringUtils.replace(token, "-", "");
			Integer number = NumberUtils.createInteger(token);
			return number.intValue();
		}
					
		return (-1);
	}


}
