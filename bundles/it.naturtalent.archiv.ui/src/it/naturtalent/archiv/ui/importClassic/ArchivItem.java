package it.naturtalent.archiv.ui.importClassic;

import java.beans.PropertyChangeEvent;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Ein einzelner Archiveintrag, entspricht dem Register in einem Ordner
 * 
 * @author Dieter.Apel
 *
 */
@XmlRootElement(name="archivItem")
public class ArchivItem extends BaseBean implements Cloneable
{
	// Default RegisterLabel
	public static final String DEFAULT_ARCHIVITEMLABEL = "Register";
	
	// Properties der persistenten Daten	
	public static final String PROP_ARCHIVITEMKEY = "archivitemkey";
	public static final String PROP_ARCHIVITEMLABEL = "archivitemlabel";
	public static final String PROP_ARCHIVITEMPROJECT = "archivitemproject";
	
	private String key;      // ID des zugehoerigen ArchivDatensatzes 
	private String label;    // Bezeichung (z.B. Registernummer)
	private String projekt;  // ID des zugeordneten Projekts
	
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		firePropertyChange(new PropertyChangeEvent(this, PROP_ARCHIVITEMLABEL, this.label,
				this.label = label));				
	}
	public String getProjekt()
	{
		return projekt;
	}
	public void setProjekt(String projekt)
	{
		firePropertyChange(new PropertyChangeEvent(this, PROP_ARCHIVITEMPROJECT, this.projekt,
				this.projekt = projekt));				
	}
	
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		result = prime * result + ((projekt == null) ? 0 : projekt.hashCode());
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
		ArchivItem other = (ArchivItem) obj;
		if (key == null)
		{
			if (other.key != null)
				return false;
		}
		else if (!key.equals(other.key))
			return false;
		if (label == null)
		{
			if (other.label != null)
				return false;
		}
		else if (!label.equals(other.label))
			return false;
		if (projekt == null)
		{
			if (other.projekt != null)
				return false;
		}
		else if (!projekt.equals(other.projekt))
			return false;
		return true;
	}
	
	@Override
	public ArchivItem clone()
	{	
		try
		{
			return (ArchivItem) super.clone();
		} catch (CloneNotSupportedException e)
		{
			return null;
		}
	}
}
