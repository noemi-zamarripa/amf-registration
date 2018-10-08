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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;
import com.liferay.training.amf.eventmonitor.service.model.StoreEventsModel;
import com.liferay.training.amf.eventmonitor.service.model.StoreEventsSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the StoreEvents service. Represents a row in the &quot;EventMonitor_StoreEvents&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link StoreEventsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StoreEventsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoreEventsImpl
 * @see StoreEvents
 * @see StoreEventsModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class StoreEventsModelImpl extends BaseModelImpl<StoreEvents>
	implements StoreEventsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a store events model instance should use the {@link StoreEvents} interface instead.
	 */
	public static final String TABLE_NAME = "EventMonitor_StoreEvents";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "fooId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "logged", Types.TIMESTAMP },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "requestIp", Types.VARCHAR },
			{ "eventType", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("fooId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("logged", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("requestIp", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("eventType", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table EventMonitor_StoreEvents (uuid_ VARCHAR(75) null,fooId LONG not null primary key,groupId LONG,logged DATE null,userId LONG,userName VARCHAR(75) null,requestIp VARCHAR(75) null,eventType VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table EventMonitor_StoreEvents";
	public static final String ORDER_BY_JPQL = " ORDER BY storeEvents.logged DESC";
	public static final String ORDER_BY_SQL = " ORDER BY EventMonitor_StoreEvents.logged DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.eventmonitor.service.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.training.amf.eventmonitor.service.model.StoreEvents"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.eventmonitor.service.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.training.amf.eventmonitor.service.model.StoreEvents"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.eventmonitor.service.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.training.amf.eventmonitor.service.model.StoreEvents"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long LOGGED_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static StoreEvents toModel(StoreEventsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		StoreEvents model = new StoreEventsImpl();

		model.setUuid(soapModel.getUuid());
		model.setFooId(soapModel.getFooId());
		model.setGroupId(soapModel.getGroupId());
		model.setLogged(soapModel.getLogged());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setRequestIp(soapModel.getRequestIp());
		model.setEventType(soapModel.getEventType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<StoreEvents> toModels(StoreEventsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<StoreEvents> models = new ArrayList<StoreEvents>(soapModels.length);

		for (StoreEventsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.training.amf.eventmonitor.service.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.training.amf.eventmonitor.service.model.StoreEvents"));

	public StoreEventsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fooId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFooId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fooId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getFooId() {
		return _fooId;
	}

	@Override
	public void setFooId(long fooId) {
		_fooId = fooId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public Date getLogged() {
		return _logged;
	}

	@Override
	public void setLogged(Date logged) {
		_columnBitmask = -1L;

		_logged = logged;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public String getRequestIp() {
		if (_requestIp == null) {
			return "";
		}
		else {
			return _requestIp;
		}
	}

	@Override
	public void setRequestIp(String requestIp) {
		_requestIp = requestIp;
	}

	@JSON
	@Override
	public String getEventType() {
		if (_eventType == null) {
			return "";
		}
		else {
			return _eventType;
		}
	}

	@Override
	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			StoreEvents.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StoreEvents toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (StoreEvents)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StoreEventsImpl storeEventsImpl = new StoreEventsImpl();

		storeEventsImpl.setUuid(getUuid());
		storeEventsImpl.setFooId(getFooId());
		storeEventsImpl.setGroupId(getGroupId());
		storeEventsImpl.setLogged(getLogged());
		storeEventsImpl.setUserId(getUserId());
		storeEventsImpl.setUserName(getUserName());
		storeEventsImpl.setRequestIp(getRequestIp());
		storeEventsImpl.setEventType(getEventType());

		storeEventsImpl.resetOriginalValues();

		return storeEventsImpl;
	}

	@Override
	public int compareTo(StoreEvents storeEvents) {
		int value = 0;

		value = DateUtil.compareTo(getLogged(), storeEvents.getLogged());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StoreEvents)) {
			return false;
		}

		StoreEvents storeEvents = (StoreEvents)obj;

		long primaryKey = storeEvents.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		StoreEventsModelImpl storeEventsModelImpl = this;

		storeEventsModelImpl._originalUuid = storeEventsModelImpl._uuid;

		storeEventsModelImpl._originalGroupId = storeEventsModelImpl._groupId;

		storeEventsModelImpl._setOriginalGroupId = false;

		storeEventsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<StoreEvents> toCacheModel() {
		StoreEventsCacheModel storeEventsCacheModel = new StoreEventsCacheModel();

		storeEventsCacheModel.uuid = getUuid();

		String uuid = storeEventsCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			storeEventsCacheModel.uuid = null;
		}

		storeEventsCacheModel.fooId = getFooId();

		storeEventsCacheModel.groupId = getGroupId();

		Date logged = getLogged();

		if (logged != null) {
			storeEventsCacheModel.logged = logged.getTime();
		}
		else {
			storeEventsCacheModel.logged = Long.MIN_VALUE;
		}

		storeEventsCacheModel.userId = getUserId();

		storeEventsCacheModel.userName = getUserName();

		String userName = storeEventsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			storeEventsCacheModel.userName = null;
		}

		storeEventsCacheModel.requestIp = getRequestIp();

		String requestIp = storeEventsCacheModel.requestIp;

		if ((requestIp != null) && (requestIp.length() == 0)) {
			storeEventsCacheModel.requestIp = null;
		}

		storeEventsCacheModel.eventType = getEventType();

		String eventType = storeEventsCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			storeEventsCacheModel.eventType = null;
		}

		return storeEventsCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", fooId=");
		sb.append(getFooId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", logged=");
		sb.append(getLogged());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", requestIp=");
		sb.append(getRequestIp());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.training.amf.eventmonitor.service.model.StoreEvents");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fooId</column-name><column-value><![CDATA[");
		sb.append(getFooId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logged</column-name><column-value><![CDATA[");
		sb.append(getLogged());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestIp</column-name><column-value><![CDATA[");
		sb.append(getRequestIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = StoreEvents.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			StoreEvents.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _fooId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private Date _logged;
	private long _userId;
	private String _userName;
	private String _requestIp;
	private String _eventType;
	private long _columnBitmask;
	private StoreEvents _escapedModel;
}