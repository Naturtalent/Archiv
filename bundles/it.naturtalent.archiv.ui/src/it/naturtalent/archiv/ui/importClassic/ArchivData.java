package it.naturtalent.archiv.ui.importClassic;

import java.beans.PropertyChangeEvent;
import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ein Archivdatensatz, entspricht einem Ordner mit Registereinlagen.
 * 
 * @author Dieter Apel
 *
 */
@XmlRootElement(name="archivData")
public class ArchivData extends BaseBean
{

	// Properties der persistenten Daten	
	public static final String PROP_ARCHIVLABEL = "archivLabel";
	public static final String PROP_ARCHIVORT = "archivOrt";
	public static final String PROP_ARCHIVITEMS = "archivItems";

	// primary key
	private java.lang.String id;

	private String label;         	// Beschriftung des Ordner
	private String archivOrt;		// Aufbewahrungsort	
	private ArchivItem [] items;	// die einzelnen Register
	
	/**
	 * Konstruktion
	 */
	public ArchivData()
	{
		id = makeIdentifier();			
	}
	
	public java.lang.String getId()
	{
		return id;
	}
	public void setId(java.lang.String id)
	{
		this.id = id;
	}
	
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		firePropertyChange(new PropertyChangeEvent(this, PROP_ARCHIVLABEL, this.label,
				this.label = label));				
	}
	
	public String getArchivOrt()
	{
		return archivOrt;
	}
	public void setArchivOrt(String archivOrt)
	{
		firePropertyChange(new PropertyChangeEvent(this, PROP_ARCHIVORT, this.archivOrt,
				this.archivOrt = archivOrt));				
	}
	
	public ArchivItem[] getItems()
	{
		return items;
	}
	public void setItems(ArchivItem[] items)
	{
		firePropertyChange(new PropertyChangeEvent(this, PROP_ARCHIVITEMS, this.items,
				this.items = items));				
	}
	
	
	/**
	 * einen datumsbasierenden Key erzeugen
	 */

	private static String date;

	private static long identifierCounter;

	/**
	 * Einen eindeutigen, datumsbasierenden Schluessel erzeugen
	 * 
	 * @return
	 */
	public static String makeIdentifier()
	{
		if (date == null)
			date = Long.toString((new Date().getTime())) + "-";
		return date + Long.toString(++identifierCounter);
	}

	/* Probleme mit TreeViewer */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((archivOrt == null) ? 0 : archivOrt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(items);
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArchivData other = (ArchivData) obj;
		if (archivOrt == null)
		{
			if (other.archivOrt != null)
				return false;
		}
		else if (!archivOrt.equals(other.archivOrt))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(items, other.items))
			return false;
		if (label == null)
		{
			if (other.label != null)
				return false;
		}
		else if (!label.equals(other.label))
			return false;
		return true;
	}
	
}
