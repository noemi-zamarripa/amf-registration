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

package com.liferay.training.amf.eventmonitor.service.service.impl;

import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;
import com.liferay.training.amf.eventmonitor.service.service.StoreEventsLocalService;
import com.liferay.training.amf.eventmonitor.service.service.StoreEventsLocalServiceUtil;
import com.liferay.training.amf.eventmonitor.service.service.base.StoreEventsLocalServiceBaseImpl;
import com.liferay.training.amf.eventmonitor.service.service.persistence.StoreEventsFinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

/**
 * The implementation of the store events local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.amf.eventmonitor.service.service.StoreEventsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoreEventsLocalServiceBaseImpl
 * @see com.liferay.training.amf.eventmonitor.service.service.StoreEventsLocalServiceUtil
 */
public class StoreEventsLocalServiceImpl extends StoreEventsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.training.amf.eventmonitor.service.service.StoreEventsLocalServiceUtil} to access the store events local service.
	 */
	
	public List<StoreEvents> findByEventType(String eventType){
		return storeEventsFinder.findByEventType(eventType);
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected StoreEventsLocalService _storeEventsLocalService;
}