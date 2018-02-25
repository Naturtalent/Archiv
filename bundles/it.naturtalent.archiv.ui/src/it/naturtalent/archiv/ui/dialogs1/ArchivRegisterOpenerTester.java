package it.naturtalent.archiv.ui.dialogs1;

import org.eclipse.emf.ecp.ui.util.ECPModelElementOpenTester;

import it.naturtalent.archiv.model.archiv.Register;




public class ArchivRegisterOpenerTester implements ECPModelElementOpenTester
{

	@Override
	public int isApplicable(Object objectToBeOpened)
	{
	
		if(objectToBeOpened instanceof Register)
			return 3;
	
		
		return NOT_APPLICABLE;
	}

}
