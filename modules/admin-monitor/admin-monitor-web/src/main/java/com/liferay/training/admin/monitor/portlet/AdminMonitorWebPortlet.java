package com.liferay.training.admin.monitor.portlet;

import com.liferay.training.admin.monitor.constants.AdminMonitorWebPortletKeys;

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
		"javax.portlet.name=" + AdminMonitorWebPortletKeys.ADMIN_PORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.display-name=Admin Monitor Portlet"
	},
	service = Portlet.class
)
public class AdminMonitorWebPortlet extends MVCPortlet {
}