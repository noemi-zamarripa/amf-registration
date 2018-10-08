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

package com.liferay.training.amf.eventmonitor.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StoreEvents in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see StoreEvents
 * @generated
 */
@ProviderType
public class StoreEventsCacheModel implements CacheModel<StoreEvents>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoreEventsCacheModel)) {
			return false;
		}

		StoreEventsCacheModel storeEventsCacheModel = (StoreEventsCacheModel)obj;

		if (fooId == storeEventsCacheModel.fooId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fooId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fooId=");
		sb.append(fooId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", logged=");
		sb.append(logged);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", requestIp=");
		sb.append(requestIp);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StoreEvents toEntityModel() {
		StoreEventsImpl storeEventsImpl = new StoreEventsImpl();

		if (uuid == null) {
			storeEventsImpl.setUuid("");
		}
		else {
			storeEventsImpl.setUuid(uuid);
		}

		storeEventsImpl.setFooId(fooId);
		storeEventsImpl.setGroupId(groupId);

		if (logged == Long.MIN_VALUE) {
			storeEventsImpl.setLogged(null);
		}
		else {
			storeEventsImpl.setLogged(new Date(logged));
		}

		storeEventsImpl.setUserId(userId);

		if (userName == null) {
			storeEventsImpl.setUserName("");
		}
		else {
			storeEventsImpl.setUserName(userName);
		}

		if (requestIp == null) {
			storeEventsImpl.setRequestIp("");
		}
		else {
			storeEventsImpl.setRequestIp(requestIp);
		}

		if (eventType == null) {
			storeEventsImpl.setEventType("");
		}
		else {
			storeEventsImpl.setEventType(eventType);
		}

		storeEventsImpl.resetOriginalValues();

		return storeEventsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fooId = objectInput.readLong();

		groupId = objectInput.readLong();
		logged = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		requestIp = objectInput.readUTF();
		eventType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fooId);

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(logged);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (requestIp == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(requestIp);
		}

		if (eventType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eventType);
		}
	}

	public String uuid;
	public long fooId;
	public long groupId;
	public long logged;
	public long userId;
	public String userName;
	public String requestIp;
	public String eventType;
}