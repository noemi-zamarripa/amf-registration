package com.liferay.training.admin.monitor.portlet.command;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.admin.monitor.constants.AdminMonitorWebPortletKeys;
import com.liferay.training.admin.monitor.model.StoreEvents;
import com.liferay.training.admin.monitor.service.StoreEventsLocalService;
import com.liferay.training.admin.monitor.service.StoreEventsService;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(
		immediate = true,
		property = {"javax.portlet.name=" + AdminMonitorWebPortletKeys.ADMIN_PORTLET,
		"mvc.command.name=/",
		},
		service = MVCRenderCommand.class)

public class ViewAdminMonitorMVCRenderCommand implements MVCRenderCommand{

	private static Log _log = LogFactoryUtil.getLog(ViewAdminMonitorMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String currentTab = ParamUtil.getString(renderRequest, "currTab", AdminMonitorWebPortletKeys.ALL);
		
		SearchContainer storeEventContainer = createSearchContainer(renderRequest, renderResponse, currentTab);
		
		boolean hasPermission = validatePermissions(themeDisplay, renderRequest);

		if (hasPermission) {
			setSearchContainerProperties(storeEventContainer, -1, currentTab);
			renderRequest.setAttribute("displayAdminEvents", storeEventContainer);
		}else {
			setSearchContainerProperties(storeEventContainer, themeDisplay.getRealUserId(), currentTab);
			renderRequest.setAttribute("displayAdminEvents", storeEventContainer);
		}
		
		return "/view.jsp";
	}
	
	public boolean validatePermissions(ThemeDisplay themeDisplay, RenderRequest renderRequest) {
		long scopeGroupId = themeDisplay.getScopeGroupId();
		String portletName = PortalUtil.getPortletId(renderRequest);
		String primaryKey = themeDisplay.getLayout().getPlid() + LiferayPortletSession.LAYOUT_SEPARATOR + portletName;
		
		try {
			return _storeEventsService.checkPermissions(scopeGroupId, StoreEvents.class.getName(), primaryKey, AdminMonitorWebPortletKeys.VIEW_MONITOR_ADMIN);
		} catch (Exception e) {
			_log.error("user-permission-invalid");
		}
		
		return false;
	}
	
	public SearchContainer createSearchContainer(RenderRequest renderRequest, RenderResponse renderResponse, String currentTab) {
		List<String> headerNames = Collections.emptyList();
		int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 20);
		
		PortletURL portletURL = renderResponse.createRenderURL();
		portletURL.setParameter("jspPage", "/view.jsp");
		portletURL.setParameter("currTab", currentTab);
		
		SearchContainer<StoreEvents> storeEventContainer = new SearchContainer<>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, headerNames, "no-results-to-show");
	
		return storeEventContainer;
	}

	public SearchContainer setSearchContainerProperties(SearchContainer searchContainer, long userId, String currentTab) {
		
		if (userId == -1) {
			int eventCount = _storeEventsLocalService.getEventCount(currentTab);
			
			List<StoreEvents> eventsToDisplay = _storeEventsLocalService.getEvents(currentTab, searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setResults(eventsToDisplay);
			searchContainer.setTotal(eventCount);
		}else {
			int eventCount = _storeEventsLocalService.getUserEventCount(currentTab, userId);
			
			List<StoreEvents> eventsToDisplay = _storeEventsLocalService.getEventsByUser(currentTab, userId, searchContainer.getStart(), searchContainer.getEnd());
			searchContainer.setResults(eventsToDisplay);
			searchContainer.setTotal(eventCount);
		}
		
		return searchContainer;

	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private StoreEventsService _storeEventsService;
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	private StoreEventsLocalService _storeEventsLocalService;

}
