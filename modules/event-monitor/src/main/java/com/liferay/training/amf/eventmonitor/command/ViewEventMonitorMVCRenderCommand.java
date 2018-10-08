package com.liferay.training.amf.eventmonitor.command;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.eventmonitor.constants.EventMonitorPortletKeys;
import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;
import com.liferay.training.amf.eventmonitor.service.service.EventMonitorLocalService;
import com.liferay.training.amf.eventmonitor.service.service.StoreEventsLocalService;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(
		immediate = true,
		property = {"javax.portlet.name=" + EventMonitorPortletKeys.PORTLET_NAME,
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.instanceable=true",
		"mvc.command.name=/event-monitor/resources/view", 
		"mvc.command.name=/"},
		service = MVCRenderCommand.class)

public class ViewEventMonitorMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		List<StoreEvents> se1 = _storeEventsLocalService.findByEventType("All");
		List<StoreEvents> se2 = _storeEventsLocalService.findByEventType("Registration");
		List<StoreEvents> se3 = _storeEventsLocalService.findByEventType("Login");
		List<String> headerNames = Collections.EMPTY_LIST;
		
		SearchContainer<StoreEvents> sc = new SearchContainer<StoreEvents>(renderRequest, renderResponse.createRenderURL(), headerNames, "No results to show.");
		sc.setDelta(20);
		sc.setResults(se1);
		sc.setTotal(se1.size());
		
		SearchContainer<StoreEvents> sc1 = new SearchContainer<StoreEvents>(renderRequest, renderResponse.createRenderURL(), headerNames, "No results to show.");
		sc1.setDelta(20);
		sc1.setResults(se2);
		sc1.setTotal(se2.size());
		
		SearchContainer<StoreEvents> sc2 = new SearchContainer<StoreEvents>(renderRequest, renderResponse.createRenderURL(), headerNames, "No results to show.");
		sc2.setDelta(20);
		sc2.setResults(se3);
		sc2.setTotal(se3.size());
		
		renderRequest.setAttribute("displayAllSearchContainer", sc);
		renderRequest.setAttribute("displayRegistrationSearchContainer", sc1);
		renderRequest.setAttribute("displayLoginSearchContainer", sc2);
		
		return "/view.jsp";
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private EventMonitorLocalService _eventMonitorLocalService;
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private StoreEventsLocalService _storeEventsLocalService;

}
