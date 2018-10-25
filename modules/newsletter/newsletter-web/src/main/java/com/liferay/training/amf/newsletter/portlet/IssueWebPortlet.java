package com.liferay.training.amf.newsletter.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.training.amf.newsletter.constants.NewsletterWebPortletKeys;

import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/newsletter_issue_display.jsp",
			"javax.portlet.name=" + NewsletterWebPortletKeys.ISSUE_PORTLET,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.display-name=Issue View Portlet",
		},
		service = Portlet.class)

public class IssueWebPortlet extends MVCPortlet{
}
