package it.naturtalent.archiv.ui;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.IPartListener;

public class PartListenerAdapter implements IPartListener
{
	protected EModelService modelService;
	
	public void setModelService(EModelService modelService)
	{
		this.modelService = modelService;
	}
	
	@Override
	public void partActivated(MPart part)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void partBroughtToTop(MPart part)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void partDeactivated(MPart part)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void partHidden(MPart part)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void partVisible(MPart part)
	{
		// TODO Auto-generated method stub

	}

}
