package com.liferay.training.amf.registration.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.registration.constants.RegistrationPortletKeys;
import com.liferay.training.amf.registration.service.RegistrationLocalService;
import com.liferay.training.amf.registration.validator.RegistrationValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

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
		"javax.portlet.name=" + RegistrationPortletKeys.PORTLET_NAME,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.display-name.RegistrationPortletKeys.PORTLET_NAME=Registration Portlet",
		"com.liferay.portlet.add-default-resource=true"
	},
	service = Portlet.class
)
public class RegistrationPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	@ProcessAction(name="addNewUser")
	public void addNewUser(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
//		AddUserMVCActionCommand mvc = new AddUserMVCActionCommand();
//		mvc.processAction(actionRequest, actionResponse);
		
		try {
			String first_name = ParamUtil.getString(actionRequest, "firstname");
			String last_name = ParamUtil.getString(actionRequest, "lastname");
			String email_address = ParamUtil.getString(actionRequest, "email");
			String username = ParamUtil.getString(actionRequest, "username");
			String gender = ParamUtil.getString(actionRequest, "gender");
			int b_month = ParamUtil.getInteger(actionRequest, "dobMonth");
			int b_day = ParamUtil.getInteger(actionRequest, "dobDay");
			int b_year = ParamUtil.getInteger(actionRequest, "dobYear");
			String password1 = ParamUtil.getString(actionRequest, "password");
			String password2 = ParamUtil.getString(actionRequest, "confirmpassword");

			String home_phone = ParamUtil.getString(actionRequest, "homephone");
			String mobile_phone = ParamUtil.getString(actionRequest, "mobilephone");

			String address = ParamUtil.getString(actionRequest, "address1");
			String address2 = ParamUtil.getString(actionRequest, "address2");
			String city = ParamUtil.getString(actionRequest, "city");
			String state = ParamUtil.getString(actionRequest, "state");
			String zip = ParamUtil.getString(actionRequest, "zipcode");

			String security_question = ParamUtil.getString(actionRequest, "securityquestion");
			String security_answer = ParamUtil.getString(actionRequest, "answer");
			boolean terms_of_use = ParamUtil.getBoolean(actionRequest, "tou");

			long stateId = _registrationLocalService.getRegionID(state);
			
			// validate basic info here
			ArrayList<String> err = RegistrationValidator.isFormInfoValid(first_name, last_name, email_address,
					username, b_year, password1, password2, home_phone, mobile_phone, address, address2, city, zip,
					security_question, security_answer, terms_of_use, stateId);

			if (err.size() > 0) {
				for (String s : err) {
					throw new Exception(s);
				}
			} else {
				// process gender field to boolean value
				boolean isMale;
				if (gender.equals("Female")) {
					isMale = false;
				} else {
					isMale = true;
				}

				// set locale
				Locale locale = new Locale("US");

				// save data to database
				_registrationLocalService.addingBasicInfo(password1, password2, username, email_address, first_name,
						last_name, isMale, b_month, b_day, b_year, locale);
				if (!home_phone.isEmpty()) {
					_registrationLocalService.addingPhoneInfo(_registrationLocalService.getUserId(username, 20115),
							home_phone, true);
				}
				if (!mobile_phone.isEmpty()) {
					_registrationLocalService.addingPhoneInfo(_registrationLocalService.getUserId(username, 20115),
							mobile_phone, false);
				}
				_registrationLocalService.addingAddressInfo(_registrationLocalService.getUserId(username, 20115),
						address, address2, city, zip, state);
				_registrationLocalService.addingSecurityInfo(_registrationLocalService.getUserId(username, 20115),
						security_question, security_answer, terms_of_use);

				sendRedirect(actionRequest, actionResponse);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Reference(cardinality=ReferenceCardinality.MANDATORY)
	protected RegistrationLocalService _registrationLocalService;
}