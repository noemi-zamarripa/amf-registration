package com.liferay.training.amf.search.results.portlet.command;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.box.service.SearchBoxLocalService;
import com.liferay.training.amf.search.results.constants.SearchResultsWebPortletKeys;

import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(immediate = true, property = { "javax.portlet.name=" + SearchResultsWebPortletKeys.PORTLET_NAME,
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.instanceable=true", "mvc.command.name=/search-results-web/resources/view",
		"mvc.command.name=/" }, service = MVCRenderCommand.class)

public class ViewSearchResultsMVCRenderCommand implements MVCRenderCommand {

	private static Log _log = LogFactoryUtil.getLog(ViewSearchResultsMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		String zip = ParamUtil.getString(renderRequest, "zip");
		
		try {
			
			@SuppressWarnings({ "unchecked" })
			List<String> headerNames = Collections.EMPTY_LIST;
			
			int delta = ParamUtil.getInteger(renderRequest, SearchContainer.DEFAULT_DELTA_PARAM, 5);
			
			SearchContainer<User> sc = new SearchContainer<>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, renderResponse.createRenderURL(), headerNames, "no-results-to-show");
			List<User> users = _searchBoxLocalService.getUsers(zip, sc.getStart(), sc.getEnd());
			sc.setResults(users);
			sc.setTotal(_searchBoxLocalService.getTotalUsers(zip));
			
			renderRequest.setAttribute("displayResultsContainer", sc);
			renderRequest.setAttribute("zipCode", zip);
			
		}catch (Exception e) {
			_log.error("No users for this zip!");
		}
		
		return "/view.jsp";
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected SearchBoxLocalService _searchBoxLocalService;

}
