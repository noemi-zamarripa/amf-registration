package com.liferay.training.amf.newsletter.portlet.command;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.newsletter.constants.NewsletterWebPortletKeys;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, 
			property = {
			"javax.portlet.name=" + NewsletterWebPortletKeys.NEWSLETTER_PORTLET,
			"javax.portlet.name=" + NewsletterWebPortletKeys.NEWSLETTER_SEARCH_PORTLET,
			"javax.portlet.name=" + NewsletterWebPortletKeys.ISSUE_PORTLET,
			"mvc.command.name=/newsletter/article/issue",
			"mvc.command.name=/"
			}, 
			service = MVCActionCommand.class)

public class RedirectToIssueMVCActionCommand implements MVCActionCommand{
	
	private static Log _log = LogFactoryUtil.getLog(RedirectToIssueMVCActionCommand.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		int issueNumber = ParamUtil.getInteger(actionRequest, "issueNumber");
		actionRequest.getPortletSession().setAttribute("sharedIssueNumber", issueNumber, PortletSession.APPLICATION_SCOPE);
		
		try {
			actionResponse.sendRedirect("http://localhost:8080/web/guest/newsletter/-/article-issue/" + String.valueOf(issueNumber));
		} catch (IOException e) {
			_log.error("redirect-failed");
		}
		
		return false;
	}

}
