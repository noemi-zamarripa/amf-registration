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

package com.liferay.training.amf.eventmonitor.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link StoreEvents}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoreEvents
 * @generated
 */
@ProviderType
public class StoreEventsWrapper implements StoreEvents,
	ModelWrapper<StoreEvents> {
	public StoreEventsWrapper(StoreEvents storeEvents) {
		_storeEvents = storeEvents;
	}

	@Override
	public Class<?> getModelClass() {
		return StoreEvents.class;
	}

	@Override
	public String getModelClassName() {
		return StoreEvents.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fooId", getFooId());
		attributes.put("groupId", getGroupId());
		attributes.put("logged", getLogged());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("requestIp", getRequestIp());
		attributes.put("eventType", getEventType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fooId = (Long)attributes.get("fooId");

		if (fooId != null) {
			setFooId(fooId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Date logged = (Date)attributes.get("logged");

		if (logged != null) {
			setLogged(logged);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String requestIp = (String)attributes.get("requestIp");

		if (requestIp != null) {
			setRequestIp(requestIp);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}
	}

	@Override
	public Object clone() {
		return new StoreEventsWrapper((StoreEvents)_storeEvents.clone());
	}

	@Override
	public int compareTo(StoreEvents storeEvents) {
		return _storeEvents.compareTo(storeEvents);
	}

	/**
	* Returns the event type of this store events.
	*
	* @return the event type of this store events
	*/
	@Override
	public String getEventType() {
		return _storeEvents.getEventType();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _storeEvents.getExpandoBridge();
	}

	/**
	* Returns the foo ID of this store events.
	*
	* @return the foo ID of this store events
	*/
	@Override
	public long getFooId() {
		return _storeEvents.getFooId();
	}

	/**
	* Returns the group ID of this store events.
	*
	* @return the group ID of this store events
	*/
	@Override
	public long getGroupId() {
		return _storeEvents.getGroupId();
	}

	/**
	* Returns the logged of this store events.
	*
	* @return the logged of this store events
	*/
	@Override
	public Date getLogged() {
		return _storeEvents.getLogged();
	}

	/**
	* Returns the primary key of this store events.
	*
	* @return the primary key of this store events
	*/
	@Override
	public long getPrimaryKey() {
		return _storeEvents.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _storeEvents.getPrimaryKeyObj();
	}

	/**
	* Returns the request ip of this store events.
	*
	* @return the request ip of this store events
	*/
	@Override
	public String getRequestIp() {
		return _storeEvents.getRequestIp();
	}

	/**
	* Returns the user ID of this store events.
	*
	* @return the user ID of this store events
	*/
	@Override
	public long getUserId() {
		return _storeEvents.getUserId();
	}

	/**
	* Returns the user name of this store events.
	*
	* @return the user name of this store events
	*/
	@Override
	public String getUserName() {
		return _storeEvents.getUserName();
	}

	/**
	* Returns the user uuid of this store events.
	*
	* @return the user uuid of this store events
	*/
	@Override
	public String getUserUuid() {
		return _storeEvents.getUserUuid();
	}

	/**
	* Returns the uuid of this store events.
	*
	* @return the uuid of this store events
	*/
	@Override
	public String getUuid() {
		return _storeEvents.getUuid();
	}

	@Override
	public int hashCode() {
		return _storeEvents.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _storeEvents.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _storeEvents.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _storeEvents.isNew();
	}

	@Override
	public void persist() {
		_storeEvents.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_storeEvents.setCachedModel(cachedModel);
	}

	/**
	* Sets the event type of this store events.
	*
	* @param eventType the event type of this store events
	*/
	@Override
	public void setEventType(String eventType) {
		_storeEvents.setEventType(eventType);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_storeEvents.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_storeEvents.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_storeEvents.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the foo ID of this store events.
	*
	* @param fooId the foo ID of this store events
	*/
	@Override
	public void setFooId(long fooId) {
		_storeEvents.setFooId(fooId);
	}

	/**
	* Sets the group ID of this store events.
	*
	* @param groupId the group ID of this store events
	*/
	@Override
	public void setGroupId(long groupId) {
		_storeEvents.setGroupId(groupId);
	}

	/**
	* Sets the logged of this store events.
	*
	* @param logged the logged of this store events
	*/
	@Override
	public void setLogged(Date logged) {
		_storeEvents.setLogged(logged);
	}

	@Override
	public void setNew(boolean n) {
		_storeEvents.setNew(n);
	}

	/**
	* Sets the primary key of this store events.
	*
	* @param primaryKey the primary key of this store events
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_storeEvents.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_storeEvents.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the request ip of this store events.
	*
	* @param requestIp the request ip of this store events
	*/
	@Override
	public void setRequestIp(String requestIp) {
		_storeEvents.setRequestIp(requestIp);
	}

	/**
	* Sets the user ID of this store events.
	*
	* @param userId the user ID of this store events
	*/
	@Override
	public void setUserId(long userId) {
		_storeEvents.setUserId(userId);
	}

	/**
	* Sets the user name of this store events.
	*
	* @param userName the user name of this store events
	*/
	@Override
	public void setUserName(String userName) {
		_storeEvents.setUserName(userName);
	}

	/**
	* Sets the user uuid of this store events.
	*
	* @param userUuid the user uuid of this store events
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_storeEvents.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this store events.
	*
	* @param uuid the uuid of this store events
	*/
	@Override
	public void setUuid(String uuid) {
		_storeEvents.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<StoreEvents> toCacheModel() {
		return _storeEvents.toCacheModel();
	}

	@Override
	public StoreEvents toEscapedModel() {
		return new StoreEventsWrapper(_storeEvents.toEscapedModel());
	}

	@Override
	public String toString() {
		return _storeEvents.toString();
	}

	@Override
	public StoreEvents toUnescapedModel() {
		return new StoreEventsWrapper(_storeEvents.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _storeEvents.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoreEventsWrapper)) {
			return false;
		}

		StoreEventsWrapper storeEventsWrapper = (StoreEventsWrapper)obj;

		if (Objects.equals(_storeEvents, storeEventsWrapper._storeEvents)) {
			return true;
		}

		return false;
	}

	@Override
	public StoreEvents getWrappedModel() {
		return _storeEvents;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _storeEvents.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _storeEvents.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_storeEvents.resetOriginalValues();
	}

	private final StoreEvents _storeEvents;
}