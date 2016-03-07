package tsi.daw.upa.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import tsi.daw.upa.bean.LoginBean;;

public class Authorizer implements PhaseListener
{
	private static final long serialVersionUID = 1L;

	public void afterPhase(PhaseEvent event)
	{
		FacesContext context = event.getFacesContext();
		if("/login.xhtml".equals(context.getViewRoot().getViewId()))
		{
			return;
		}
		LoginBean loginBean = context.getApplication().evaluateExpressionGet(context, "#{loginBean}", LoginBean.class);
		
		if(!loginBean.isLogged())
		{
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "login?faces-redirect=true");
			context.renderResponse();
		}
	}

	public PhaseId getPhaseId()
	{
		return PhaseId.RESTORE_VIEW;
	}
	
	@Override
	public void beforePhase(PhaseEvent event)
	{
		
	}
}
