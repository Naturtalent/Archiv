package it.naturtalent.archiv.ui1;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import archive.Ordner;
import archive.Register;

public class RegisterTypeSorter extends ViewerSorter
{
	
	private Ordner ordner;

	@Override
	public int compare(Viewer viewer, Object e1, Object e2)
	{
		if (ordner != null)
		{
			if (e1 instanceof Register)
			{
				switch (ordner.getRegisterType())
					{
						case NUMERIC_TYPE:
							Short s1 = new Short(((Register) e1).getNumericData());
							Short s2 = new Short(((Register) e2).getNumericData());
							return s1.compareTo(s2);

						default:
							break;
					}
			}
		}
				
		return super.compare(viewer, e1, e2);
	}

	public void setOrdner(Ordner ordner)
	{
		this.ordner = ordner;
	}
	
	
}
