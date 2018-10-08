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

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link EventMonitor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventMonitor
 * @generated
 */
@ProviderType
public class EventMonitorWrapper implements EventMonitor,
	ModelWrapper<EventMonitor> {
	public EventMonitorWrapper(EventMonitor eventMonitor) {
		_eventMonitor = eventMonitor;
	}

	@Override
	public Class<?> getModelClass() {
		return EventMonitor.class;
	}

	@Override
	public String getModelClassName() {
		return EventMonitor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fooId", getFooId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("field1", getField1());
		attributes.put("field2", isField2());
		attributes.put("field3", getField3());
		attributes.put("field4", getField4());
		attributes.put("field5", getField5());

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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String field1 = (String)attributes.get("field1");

		if (field1 != null) {
			setField1(field1);
		}

		Boolean field2 = (Boolean)attributes.get("field2");

		if (field2 != null) {
			setField2(field2);
		}

		Integer field3 = (Integer)attributes.get("field3");

		if (field3 != null) {
			setField3(field3);
		}

		Date field4 = (Date)attributes.get("field4");

		if (field4 != null) {
			setField4(field4);
		}

		String field5 = (String)attributes.get("field5");

		if (field5 != null) {
			setField5(field5);
		}
	}

	@Override
	public Object clone() {
		return new EventMonitorWrapper((EventMonitor)_eventMonitor.clone());
	}

	@Override
	public int compareTo(EventMonitor eventMonitor) {
		return _eventMonitor.compareTo(eventMonitor);
	}

	/**
	* Returns the company ID of this event monitor.
	*
	* @return the company ID of this event monitor
	*/
	@Override
	public long getCompanyId() {
		return _eventMonitor.getCompanyId();
	}

	/**
	* Returns the create date of this event monitor.
	*
	* @return the create date of this event monitor
	*/
	@Override
	public Date getCreateDate() {
		return _eventMonitor.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _eventMonitor.getExpandoBridge();
	}

	/**
	* Returns the field1 of this event monitor.
	*
	* @return the field1 of this event monitor
	*/
	@Override
	public String getField1() {
		return _eventMonitor.getField1();
	}

	/**
	* Returns the field2 of this event monitor.
	*
	* @return the field2 of this event monitor
	*/
	@Override
	public boolean getField2() {
		return _eventMonitor.getField2();
	}

	/**
	* Returns the field3 of this event monitor.
	*
	* @return the field3 of this event monitor
	*/
	@Override
	public int getField3() {
		return _eventMonitor.getField3();
	}

	/**
	* Returns the field4 of this event monitor.
	*
	* @return the field4 of this event monitor
	*/
	@Override
	public Date getField4() {
		return _eventMonitor.getField4();
	}

	/**
	* Returns the field5 of this event monitor.
	*
	* @return the field5 of this event monitor
	*/
	@Override
	public String getField5() {
		return _eventMonitor.getField5();
	}

	/**
	* Returns the foo ID of this event monitor.
	*
	* @return the foo ID of this event monitor
	*/
	@Override
	public long getFooId() {
		return _eventMonitor.getFooId();
	}

	/**
	* Returns the group ID of this event monitor.
	*
	* @return the group ID of this event monitor
	*/
	@Override
	public long getGroupId() {
		return _eventMonitor.getGroupId();
	}

	/**
	* Returns the modified date of this event monitor.
	*
	* @return the modified date of this event monitor
	*/
	@Override
	public Date getModifiedDate() {
		return _eventMonitor.getModifiedDate();
	}

	/**
	* Returns the primary key of this event monitor.
	*
	* @return the primary key of this event monitor
	*/
	@Override
	public long getPrimaryKey() {
		return _eventMonitor.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _eventMonitor.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this event monitor.
	*
	* @return the user ID of this event monitor
	*/
	@Override
	public long getUserId() {
		return _eventMonitor.getUserId();
	}

	/**
	* Returns the user name of this event monitor.
	*
	* @return the user name of this event monitor
	*/
	@Override
	public String getUserName() {
		return _eventMonitor.getUserName();
	}

	/**
	* Returns the user uuid of this event monitor.
	*
	* @return the user uuid of this event monitor
	*/
	@Override
	public String getUserUuid() {
		return _eventMonitor.getUserUuid();
	}

	/**
	* Returns the uuid of this event monitor.
	*
	* @return the uuid of this event monitor
	*/
	@Override
	public String getUuid() {
		return _eventMonitor.getUuid();
	}

	@Override
	public int hashCode() {
		return _eventMonitor.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _eventMonitor.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _eventMonitor.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this event monitor is field2.
	*
	* @return <code>true</code> if this event monitor is field2; <code>false</code> otherwise
	*/
	@Override
	public boolean isField2() {
		return _eventMonitor.isField2();
	}

	@Override
	public boolean isNew() {
		return _eventMonitor.isNew();
	}

	@Override
	public void persist() {
		_eventMonitor.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_eventMonitor.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this event monitor.
	*
	* @param companyId the company ID of this event monitor
	*/
	@Override
	public void setCompanyId(long companyId) {
		_eventMonitor.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this event monitor.
	*
	* @param createDate the create date of this event monitor
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_eventMonitor.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_eventMonitor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_eventMonitor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_eventMonitor.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the field1 of this event monitor.
	*
	* @param field1 the field1 of this event monitor
	*/
	@Override
	public void setField1(String field1) {
		_eventMonitor.setField1(field1);
	}

	/**
	* Sets whether this event monitor is field2.
	*
	* @param field2 the field2 of this event monitor
	*/
	@Override
	public void setField2(boolean field2) {
		_eventMonitor.setField2(field2);
	}

	/**
	* Sets the field3 of this event monitor.
	*
	* @param field3 the field3 of this event monitor
	*/
	@Override
	public void setField3(int field3) {
		_eventMonitor.setField3(field3);
	}

	/**
	* Sets the field4 of this event monitor.
	*
	* @param field4 the field4 of this event monitor
	*/
	@Override
	public void setField4(Date field4) {
		_eventMonitor.setField4(field4);
	}

	/**
	* Sets the field5 of this event monitor.
	*
	* @param field5 the field5 of this event monitor
	*/
	@Override
	public void setField5(String field5) {
		_eventMonitor.setField5(field5);
	}

	/**
	* Sets the foo ID of this event monitor.
	*
	* @param fooId the foo ID of this event monitor
	*/
	@Override
	public void setFooId(long fooId) {
		_eventMonitor.setFooId(fooId);
	}

	/**
	* Sets the group ID of this event monitor.
	*
	* @param groupId the group ID of this event monitor
	*/
	@Override
	public void setGroupId(long groupId) {
		_eventMonitor.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this event monitor.
	*
	* @param modifiedDate the modified date of this event monitor
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_eventMonitor.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_eventMonitor.setNew(n);
	}

	/**
	* Sets the primary key of this event monitor.
	*
	* @param primaryKey the primary key of this event monitor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_eventMonitor.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_eventMonitor.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this event monitor.
	*
	* @param userId the user ID of this event monitor
	*/
	@Override
	public void setUserId(long userId) {
		_eventMonitor.setUserId(userId);
	}

	/**
	* Sets the user name of this event monitor.
	*
	* @param userName the user name of this event monitor
	*/
	@Override
	public void setUserName(String userName) {
		_eventMonitor.setUserName(userName);
	}

	/**
	* Sets the user uuid of this event monitor.
	*
	* @param userUuid the user uuid of this event monitor
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_eventMonitor.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this event monitor.
	*
	* @param uuid the uuid of this event monitor
	*/
	@Override
	public void setUuid(String uuid) {
		_eventMonitor.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EventMonitor> toCacheModel() {
		return _eventMonitor.toCacheModel();
	}

	@Override
	public EventMonitor toEscapedModel() {
		return new EventMonitorWrapper(_eventMonitor.toEscapedModel());
	}

	@Override
	public String toString() {
		return _eventMonitor.toString();
	}

	@Override
	public EventMonitor toUnescapedModel() {
		return new EventMonitorWrapper(_eventMonitor.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _eventMonitor.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventMonitorWrapper)) {
			return false;
		}

		EventMonitorWrapper eventMonitorWrapper = (EventMonitorWrapper)obj;

		if (Objects.equals(_eventMonitor, eventMonitorWrapper._eventMonitor)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _eventMonitor.getStagedModelType();
	}

	@Override
	public EventMonitor getWrappedModel() {
		return _eventMonitor;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _eventMonitor.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _eventMonitor.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_eventMonitor.resetOriginalValues();
	}

	private final EventMonitor _eventMonitor;
}