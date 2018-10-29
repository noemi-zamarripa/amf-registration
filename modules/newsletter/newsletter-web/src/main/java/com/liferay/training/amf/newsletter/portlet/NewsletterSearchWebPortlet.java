package com.liferay.training.amf.newsletter.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.training.amf.newsletter.constants.NewsletterWebPortletKeys;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/newsletter_search.jsp",
			"javax.portlet.name=" + NewsletterWebPortletKeys.NEWSLETTER_PORTLET,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"javax.portlet.display-name=Newsletter Listing Portlet",
		},
		service = Portlet.class
	)

public class NewsletterSearchWebPortlet extends MVCPortlet{
}
