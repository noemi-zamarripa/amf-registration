/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.registration.service.impl;

import com.liferay.portal.kernel.exception.NoSuchRegionException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Region;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ListTypeLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.training.amf.registration.service.base.RegistrationLocalServiceBaseImpl;

import java.util.List;
import java.util.Locale;

import org.w3c.dom.ls.LSInput;

/**
 * The implementation of the registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.amf.registration.service.RegistrationLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLocalServiceBaseImpl
 * @see com.liferay.training.amf.registration.service.RegistrationLocalServiceUtil
 */
public class RegistrationLocalServiceImpl extends RegistrationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.liferay.training.amf.registration.service.RegistrationLocalServiceUtil}
	 * to access the registration local service.
	 */

	public void addingBasicInfo(String password1, String password2, String username, String emailAddress,
			String firstname, String lastname, boolean isMale, int month, int day, int year, Locale locale) {
		try {
			userLocalService.addUser(0, 20115, false, password1, password2, false, username, emailAddress, 0, null,
					locale, firstname, "test", lastname, 0, 0, isMale, month, day, year, null, null, null, null, null,
					false, new ServiceContext());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addingPhoneInfo(long uid, String phoneNumber, boolean home) {
		try {
			User u = userLocalService.getUser(uid);
			
			long type = 0;
			if (home == true) {
				type = 11009;
			}else {
				type = 11008;
			}
			System.out.println(phoneNumber);
			
			phoneLocalService.addPhone(uid, Contact.class.getName(), u.getContactId(), phoneNumber, null, type, true, new ServiceContext());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addingAddressInfo(long uid, String address1, String address2, String city, String zip, String state) {
		try {
			User u = userLocalService.getUser(uid);
			long stateId = 0;
			List<Region> r = regionPersistence.findByCountryId(19);
			for (Region rg : r) {
				long match = rg.getRegionId();
				String m = regionPersistence.findByPrimaryKey(match).getName();
				if (m.equalsIgnoreCase(state)) {
					stateId = match;
					break;
				}
			}
			
			addressLocalService.addAddress(uid, Contact.class.getName(), u.getContactId(), address1, address2, null, city, zip, stateId, 19, 11002, true, true, new ServiceContext());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addingSecurityInfo(long uid, String question, String answer, boolean tou) {
		try {
			userLocalService.updateReminderQuery(uid, question, answer);
			userLocalService.updateAgreedToTermsOfUse(uid, tou);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public long getUserId(String username, long companyId) throws PortalException {
		return userLocalService.getUserIdByScreenName(companyId, username);
	}
	
	public long getRegionID(String state) throws NoSuchRegionException {
		long stateId = 0;
		List<Region> r = regionPersistence.findByCountryId(19);
		for (Region rg : r) {
			long match = rg.getRegionId();
			String m = regionPersistence.findByPrimaryKey(match).getName();
			if (m.equalsIgnoreCase(state)) {
				stateId = match;
				break;
			}
		}
		return stateId;
	}
	
	public User getUser(String username) throws PortalException {
		return userLocalService.getUserByScreenName(20115, username);
	}

}