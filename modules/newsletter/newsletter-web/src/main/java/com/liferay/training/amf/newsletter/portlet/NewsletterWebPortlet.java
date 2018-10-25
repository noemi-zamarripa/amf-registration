package com.liferay.training.amf.newsletter.portlet;

import com.liferay.training.amf.newsletter.constants.NewsletterWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NewsletterWebPortletKeys.NEWSLETTER_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.display-name=Newsletter Listing Portlet",
	},
	service = Portlet.class
)
public class NewsletterWebPortlet extends MVCPortlet {
}