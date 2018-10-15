package com.liferay.training.amf.search.box.portlet.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.box.constants.SearchBoxWebPortletKeys;
import com.liferay.training.amf.search.box.service.SearchBoxLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.namespace.QName;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(immediate = true, property = { "javax.portlet.name=" + SearchBoxWebPortletKeys.PORTLET_NAME,
		"mvc.command.name=/search/box/lookup", "mvc.command.name=/" }, service = MVCActionCommand.class)

public class LookupSearchBoxMVCActionCommand implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		
		String zip = ParamUtil.getString(actionRequest, "enter-us-zip");
		
		actionRequest.setAttribute("enteredZip", zip);
		
		actionResponse.setRenderParameter("zip", zip);
		QName qName = new QName("http://localhost:8080", "ipc.sendzip");
		actionResponse.setEvent(qName, zip);

		return true;
	}

	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected SearchBoxLocalService _searchBoxLocalService;
}
