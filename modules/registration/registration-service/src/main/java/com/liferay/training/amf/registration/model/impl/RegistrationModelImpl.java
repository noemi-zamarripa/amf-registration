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

package com.liferay.training.amf.registration.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.training.amf.registration.model.Registration;
import com.liferay.training.amf.registration.model.RegistrationModel;
import com.liferay.training.amf.registration.model.RegistrationSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Registration service. Represents a row in the &quot;Registration_Registration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link RegistrationModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationImpl
 * @see Registration
 * @see RegistrationModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RegistrationModelImpl extends BaseModelImpl<Registration>
	implements RegistrationModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a registration model instance should use the {@link Registration} interface instead.
	 */
	public static final String TABLE_NAME = "Registration_Registration";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "userID", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "firstname", Types.VARCHAR },
			{ "lastname", Types.VARCHAR },
			{ "email", Types.VARCHAR },
			{ "username", Types.VARCHAR },
			{ "password_", Types.VARCHAR },
			{ "gender", Types.VARCHAR },
			{ "dob", Types.TIMESTAMP },
			{ "homephone", Types.VARCHAR },
			{ "mobilephone", Types.VARCHAR },
			{ "address1", Types.VARCHAR },
			{ "address2", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "state_", Types.VARCHAR },
			{ "zipcode", Types.VARCHAR },
			{ "securityquestion", Types.VARCHAR },
			{ "answer", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("firstname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("username", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("password_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("gender", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dob", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("homephone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobilephone", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address2", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("city", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("state_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("zipcode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("securityquestion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("answer", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table Registration_Registration (uuid_ VARCHAR(75) null,userID LONG not null primary key,groupId LONG,firstname VARCHAR(75) null,lastname VARCHAR(75) null,email VARCHAR(75) null,username VARCHAR(75) null,password_ VARCHAR(75) null,gender VARCHAR(75) null,dob DATE null,homephone VARCHAR(75) null,mobilephone VARCHAR(75) null,address1 VARCHAR(75) null,address2 VARCHAR(75) null,city VARCHAR(75) null,state_ VARCHAR(75) null,zipcode VARCHAR(75) null,securityquestion VARCHAR(75) null,answer VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Registration_Registration";
	public static final String ORDER_BY_JPQL = " ORDER BY registration.userID ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Registration_Registration.userID ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.registration.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.training.amf.registration.model.Registration"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.registration.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.training.amf.registration.model.Registration"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.registration.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.training.amf.registration.model.Registration"),
			true);
	public static final long GROUPID_COLUMN_BITMASK = 1L;
	public static final long UUID_COLUMN_BITMASK = 2L;
	public static final long USERID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Registration toModel(RegistrationSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Registration model = new RegistrationImpl();

		model.setUuid(soapModel.getUuid());
		model.setUserID(soapModel.getUserID());
		model.setGroupId(soapModel.getGroupId());
		model.setFirstname(soapModel.getFirstname());
		model.setLastname(soapModel.getLastname());
		model.setEmail(soapModel.getEmail());
		model.setUsername(soapModel.getUsername());
		model.setPassword(soapModel.getPassword());
		model.setGender(soapModel.getGender());
		model.setDob(soapModel.getDob());
		model.setHomephone(soapModel.getHomephone());
		model.setMobilephone(soapModel.getMobilephone());
		model.setAddress1(soapModel.getAddress1());
		model.setAddress2(soapModel.getAddress2());
		model.setCity(soapModel.getCity());
		model.setState(soapModel.getState());
		model.setZipcode(soapModel.getZipcode());
		model.setSecurityquestion(soapModel.getSecurityquestion());
		model.setAnswer(soapModel.getAnswer());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Registration> toModels(RegistrationSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Registration> models = new ArrayList<Registration>(soapModels.length);

		for (RegistrationSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.training.amf.registration.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.training.amf.registration.model.Registration"));

	public RegistrationModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _userID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Registration.class;
	}

	@Override
	public String getModelClassName() {
		return Registration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userID", getUserID());
		attributes.put("groupId", getGroupId());
		attributes.put("firstname", getFirstname());
		attributes.put("lastname", getLastname());
		attributes.put("email", getEmail());
		attributes.put("username", getUsername());
		attributes.put("password", getPassword());
		attributes.put("gender", getGender());
		attributes.put("dob", getDob());
		attributes.put("homephone", getHomephone());
		attributes.put("mobilephone", getMobilephone());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("zipcode", getZipcode());
		attributes.put("securityquestion", getSecurityquestion());
		attributes.put("answer", getAnswer());

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

		Long userID = (Long)attributes.get("userID");

		if (userID != null) {
			setUserID(userID);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String firstname = (String)attributes.get("firstname");

		if (firstname != null) {
			setFirstname(firstname);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String username = (String)attributes.get("username");

		if (username != null) {
			setUsername(username);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String homephone = (String)attributes.get("homephone");

		if (homephone != null) {
			setHomephone(homephone);
		}

		String mobilephone = (String)attributes.get("mobilephone");

		if (mobilephone != null) {
			setMobilephone(mobilephone);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String securityquestion = (String)attributes.get("securityquestion");

		if (securityquestion != null) {
			setSecurityquestion(securityquestion);
		}

		String answer = (String)attributes.get("answer");

		if (answer != null) {
			setAnswer(answer);
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
	public long getUserID() {
		return _userID;
	}

	@Override
	public void setUserID(long userID) {
		_userID = userID;
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
	public String getFirstname() {
		if (_firstname == null) {
			return "";
		}
		else {
			return _firstname;
		}
	}

	@Override
	public void setFirstname(String firstname) {
		_firstname = firstname;
	}

	@JSON
	@Override
	public String getLastname() {
		if (_lastname == null) {
			return "";
		}
		else {
			return _lastname;
		}
	}

	@Override
	public void setLastname(String lastname) {
		_lastname = lastname;
	}

	@JSON
	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@JSON
	@Override
	public String getUsername() {
		if (_username == null) {
			return "";
		}
		else {
			return _username;
		}
	}

	@Override
	public void setUsername(String username) {
		_username = username;
	}

	@JSON
	@Override
	public String getPassword() {
		if (_password == null) {
			return "";
		}
		else {
			return _password;
		}
	}

	@Override
	public void setPassword(String password) {
		_password = password;
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return "";
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;
	}

	@JSON
	@Override
	public Date getDob() {
		return _dob;
	}

	@Override
	public void setDob(Date dob) {
		_dob = dob;
	}

	@JSON
	@Override
	public String getHomephone() {
		if (_homephone == null) {
			return "";
		}
		else {
			return _homephone;
		}
	}

	@Override
	public void setHomephone(String homephone) {
		_homephone = homephone;
	}

	@JSON
	@Override
	public String getMobilephone() {
		if (_mobilephone == null) {
			return "";
		}
		else {
			return _mobilephone;
		}
	}

	@Override
	public void setMobilephone(String mobilephone) {
		_mobilephone = mobilephone;
	}

	@JSON
	@Override
	public String getAddress1() {
		if (_address1 == null) {
			return "";
		}
		else {
			return _address1;
		}
	}

	@Override
	public void setAddress1(String address1) {
		_address1 = address1;
	}

	@JSON
	@Override
	public String getAddress2() {
		if (_address2 == null) {
			return "";
		}
		else {
			return _address2;
		}
	}

	@Override
	public void setAddress2(String address2) {
		_address2 = address2;
	}

	@JSON
	@Override
	public String getCity() {
		if (_city == null) {
			return "";
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@JSON
	@Override
	public String getState() {
		if (_state == null) {
			return "";
		}
		else {
			return _state;
		}
	}

	@Override
	public void setState(String state) {
		_state = state;
	}

	@JSON
	@Override
	public String getZipcode() {
		if (_zipcode == null) {
			return "";
		}
		else {
			return _zipcode;
		}
	}

	@Override
	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}

	@JSON
	@Override
	public String getSecurityquestion() {
		if (_securityquestion == null) {
			return "";
		}
		else {
			return _securityquestion;
		}
	}

	@Override
	public void setSecurityquestion(String securityquestion) {
		_securityquestion = securityquestion;
	}

	@JSON
	@Override
	public String getAnswer() {
		if (_answer == null) {
			return "";
		}
		else {
			return _answer;
		}
	}

	@Override
	public void setAnswer(String answer) {
		_answer = answer;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Registration.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Registration toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Registration)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RegistrationImpl registrationImpl = new RegistrationImpl();

		registrationImpl.setUuid(getUuid());
		registrationImpl.setUserID(getUserID());
		registrationImpl.setGroupId(getGroupId());
		registrationImpl.setFirstname(getFirstname());
		registrationImpl.setLastname(getLastname());
		registrationImpl.setEmail(getEmail());
		registrationImpl.setUsername(getUsername());
		registrationImpl.setPassword(getPassword());
		registrationImpl.setGender(getGender());
		registrationImpl.setDob(getDob());
		registrationImpl.setHomephone(getHomephone());
		registrationImpl.setMobilephone(getMobilephone());
		registrationImpl.setAddress1(getAddress1());
		registrationImpl.setAddress2(getAddress2());
		registrationImpl.setCity(getCity());
		registrationImpl.setState(getState());
		registrationImpl.setZipcode(getZipcode());
		registrationImpl.setSecurityquestion(getSecurityquestion());
		registrationImpl.setAnswer(getAnswer());

		registrationImpl.resetOriginalValues();

		return registrationImpl;
	}

	@Override
	public int compareTo(Registration registration) {
		long primaryKey = registration.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Registration)) {
			return false;
		}

		Registration registration = (Registration)obj;

		long primaryKey = registration.getPrimaryKey();

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
		RegistrationModelImpl registrationModelImpl = this;

		registrationModelImpl._originalUuid = registrationModelImpl._uuid;

		registrationModelImpl._originalGroupId = registrationModelImpl._groupId;

		registrationModelImpl._setOriginalGroupId = false;

		registrationModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Registration> toCacheModel() {
		RegistrationCacheModel registrationCacheModel = new RegistrationCacheModel();

		registrationCacheModel.uuid = getUuid();

		String uuid = registrationCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			registrationCacheModel.uuid = null;
		}

		registrationCacheModel.userID = getUserID();

		registrationCacheModel.groupId = getGroupId();

		registrationCacheModel.firstname = getFirstname();

		String firstname = registrationCacheModel.firstname;

		if ((firstname != null) && (firstname.length() == 0)) {
			registrationCacheModel.firstname = null;
		}

		registrationCacheModel.lastname = getLastname();

		String lastname = registrationCacheModel.lastname;

		if ((lastname != null) && (lastname.length() == 0)) {
			registrationCacheModel.lastname = null;
		}

		registrationCacheModel.email = getEmail();

		String email = registrationCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			registrationCacheModel.email = null;
		}

		registrationCacheModel.username = getUsername();

		String username = registrationCacheModel.username;

		if ((username != null) && (username.length() == 0)) {
			registrationCacheModel.username = null;
		}

		registrationCacheModel.password = getPassword();

		String password = registrationCacheModel.password;

		if ((password != null) && (password.length() == 0)) {
			registrationCacheModel.password = null;
		}

		registrationCacheModel.gender = getGender();

		String gender = registrationCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			registrationCacheModel.gender = null;
		}

		Date dob = getDob();

		if (dob != null) {
			registrationCacheModel.dob = dob.getTime();
		}
		else {
			registrationCacheModel.dob = Long.MIN_VALUE;
		}

		registrationCacheModel.homephone = getHomephone();

		String homephone = registrationCacheModel.homephone;

		if ((homephone != null) && (homephone.length() == 0)) {
			registrationCacheModel.homephone = null;
		}

		registrationCacheModel.mobilephone = getMobilephone();

		String mobilephone = registrationCacheModel.mobilephone;

		if ((mobilephone != null) && (mobilephone.length() == 0)) {
			registrationCacheModel.mobilephone = null;
		}

		registrationCacheModel.address1 = getAddress1();

		String address1 = registrationCacheModel.address1;

		if ((address1 != null) && (address1.length() == 0)) {
			registrationCacheModel.address1 = null;
		}

		registrationCacheModel.address2 = getAddress2();

		String address2 = registrationCacheModel.address2;

		if ((address2 != null) && (address2.length() == 0)) {
			registrationCacheModel.address2 = null;
		}

		registrationCacheModel.city = getCity();

		String city = registrationCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			registrationCacheModel.city = null;
		}

		registrationCacheModel.state = getState();

		String state = registrationCacheModel.state;

		if ((state != null) && (state.length() == 0)) {
			registrationCacheModel.state = null;
		}

		registrationCacheModel.zipcode = getZipcode();

		String zipcode = registrationCacheModel.zipcode;

		if ((zipcode != null) && (zipcode.length() == 0)) {
			registrationCacheModel.zipcode = null;
		}

		registrationCacheModel.securityquestion = getSecurityquestion();

		String securityquestion = registrationCacheModel.securityquestion;

		if ((securityquestion != null) && (securityquestion.length() == 0)) {
			registrationCacheModel.securityquestion = null;
		}

		registrationCacheModel.answer = getAnswer();

		String answer = registrationCacheModel.answer;

		if ((answer != null) && (answer.length() == 0)) {
			registrationCacheModel.answer = null;
		}

		return registrationCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", userID=");
		sb.append(getUserID());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", firstname=");
		sb.append(getFirstname());
		sb.append(", lastname=");
		sb.append(getLastname());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", username=");
		sb.append(getUsername());
		sb.append(", password=");
		sb.append(getPassword());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", dob=");
		sb.append(getDob());
		sb.append(", homephone=");
		sb.append(getHomephone());
		sb.append(", mobilephone=");
		sb.append(getMobilephone());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", address2=");
		sb.append(getAddress2());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", zipcode=");
		sb.append(getZipcode());
		sb.append(", securityquestion=");
		sb.append(getSecurityquestion());
		sb.append(", answer=");
		sb.append(getAnswer());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.liferay.training.amf.registration.model.Registration");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userID</column-name><column-value><![CDATA[");
		sb.append(getUserID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstname</column-name><column-value><![CDATA[");
		sb.append(getFirstname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastname</column-name><column-value><![CDATA[");
		sb.append(getLastname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>username</column-name><column-value><![CDATA[");
		sb.append(getUsername());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>password</column-name><column-value><![CDATA[");
		sb.append(getPassword());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dob</column-name><column-value><![CDATA[");
		sb.append(getDob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>homephone</column-name><column-value><![CDATA[");
		sb.append(getHomephone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobilephone</column-name><column-value><![CDATA[");
		sb.append(getMobilephone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address2</column-name><column-value><![CDATA[");
		sb.append(getAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zipcode</column-name><column-value><![CDATA[");
		sb.append(getZipcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>securityquestion</column-name><column-value><![CDATA[");
		sb.append(getSecurityquestion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>answer</column-name><column-value><![CDATA[");
		sb.append(getAnswer());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Registration.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Registration.class, ModelWrapper.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _userID;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private String _firstname;
	private String _lastname;
	private String _email;
	private String _username;
	private String _password;
	private String _gender;
	private Date _dob;
	private String _homephone;
	private String _mobilephone;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _zipcode;
	private String _securityquestion;
	private String _answer;
	private long _columnBitmask;
	private Registration _escapedModel;
}