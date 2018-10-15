package com.liferay.training.amf.search.results.portlet;

import com.liferay.training.amf.search.results.constants.SearchResultsWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessEvent;

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
		"javax.portlet.name=" + SearchResultsWebPortletKeys.PORTLET_NAME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user", 
		"javax.portlet.display-name=Search Results Portlet", 
		"javax.portlet.supported-processing-event=ipc.sendzip;http://localhost:8080",
		"javax.portlet.supported-public-render-parameter=zip;http://localhost:8080"
	},
	service = Portlet.class
)
public class SearchResultsWebPortlet extends MVCPortlet {
	
	@ProcessEvent(qname="{http://localhost:8080}ipc.sendzip")
	public void arrivalDestination(EventRequest request, EventResponse response) {
		Event event = request.getEvent();
		String zip = (String) event.getValue();
		response.setRenderParameter("sendzip", zip);
	}
}