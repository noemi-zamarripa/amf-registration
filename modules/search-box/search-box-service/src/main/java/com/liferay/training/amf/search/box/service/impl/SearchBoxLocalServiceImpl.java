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

package com.liferay.training.amf.search.box.service.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.training.amf.search.box.service.base.SearchBoxLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the search box local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.amf.search.box.service.SearchBoxLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchBoxLocalServiceBaseImpl
 * @see com.liferay.training.amf.search.box.service.SearchBoxLocalServiceUtil
 */
public class SearchBoxLocalServiceImpl extends SearchBoxLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.liferay.training.amf.search.box.service.SearchBoxLocalServiceUtil} to
	 * access the search box local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(SearchBoxLocalServiceImpl.class);

	public List<Long> getUserIdFromZip(String zip, int start, int end) {

		DynamicQuery addressQuery = addressLocalService.dynamicQuery();
		addressQuery.add(RestrictionsFactoryUtil.eq("zip", zip));
		addressQuery.setProjection(PropertyFactoryUtil.forName("userId"));

		try {
			List<Long> addressIds = addressLocalService.dynamicQuery(addressQuery, start, end);

			return addressIds;

		} catch (SystemException e) {
			_log.error("No users for this zip!");
		}

		return null;
	}

	public int getTotalUsers(String zip) {

		DynamicQuery addressQuery = addressLocalService.dynamicQuery();
		addressQuery.add(RestrictionsFactoryUtil.eq("zip", zip));
		addressQuery.setProjection(PropertyFactoryUtil.forName("userId"));

		try {
			List<Long> addressIds = addressLocalService.dynamicQuery(addressQuery);

			return addressIds.size();

		} catch (SystemException e) {
			_log.error("No users for this zip!");
		}

		return 0;
	}

	public List<User> getUsersFromIds(List<Long> userIds) throws PortalException {
		List<User> users = new ArrayList<>();

		for (Long u : userIds) {
			users.add(userLocalService.getUser(u));
		}

		return users;
	}

	public List<User> getUsers(String zip, int start, int end) throws PortalException {
		List<Long> userIds = getUserIdFromZip(zip, start, end);
		return getUsersFromIds(userIds);
	}

}