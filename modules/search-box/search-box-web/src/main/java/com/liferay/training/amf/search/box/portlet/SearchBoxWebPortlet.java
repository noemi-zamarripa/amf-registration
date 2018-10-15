package com.liferay.training.amf.search.box.portlet;

import com.liferay.training.amf.search.box.constants.SearchBoxWebPortletKeys;

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
		"javax.portlet.name=" + SearchBoxWebPortletKeys.PORTLET_NAME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.display-name=Search Box Portlet",
		"javax.portlet.supported-publishing-event=ipc.sendzip;http://localhost:8080", 
		"javax.portlet.supported-public-render-parameter=zip;http://localhost:8080"
	},
	service = Portlet.class
)
public class SearchBoxWebPortlet extends MVCPortlet {
}