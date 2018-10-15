package com.liferay.training.amf.search.box.portlet.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.box.constants.SearchBoxWebPortletKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + SearchBoxWebPortletKeys.PORTLET_NAME,
		"com.liferay.portlet.display-category=category.sample",
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"com.liferay.portlet.instanceable=true", "mvc.command.name=/search-box-web/resources/view",
		"mvc.command.name=/" }, service = MVCRenderCommand.class)

public class ViewSearchBoxMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		String zip = ParamUtil.getString(renderRequest, "enter-us-zip");
		
		renderRequest.setAttribute("enteredZip", zip);
		
		return "/view.jsp";
	}
	
}
