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

package com.liferay.training.amf.registration.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Registration service. Represents a row in the &quot;Registration_Registration&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.training.amf.registration.model.impl.RegistrationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.training.amf.registration.model.impl.RegistrationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Registration
 * @see com.liferay.training.amf.registration.model.impl.RegistrationImpl
 * @see com.liferay.training.amf.registration.model.impl.RegistrationModelImpl
 * @generated
 */
@ProviderType
public interface RegistrationModel extends BaseModel<Registration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a registration model instance should use the {@link Registration} interface instead.
	 */

	/**
	 * Returns the primary key of this registration.
	 *
	 * @return the primary key of this registration
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this registration.
	 *
	 * @param primaryKey the primary key of this registration
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this registration.
	 *
	 * @return the uuid of this registration
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this registration.
	 *
	 * @param uuid the uuid of this registration
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the user ID of this registration.
	 *
	 * @return the user ID of this registration
	 */
	public long getUserID();

	/**
	 * Sets the user ID of this registration.
	 *
	 * @param userID the user ID of this registration
	 */
	public void setUserID(long userID);

	/**
	 * Returns the group ID of this registration.
	 *
	 * @return the group ID of this registration
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this registration.
	 *
	 * @param groupId the group ID of this registration
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the firstname of this registration.
	 *
	 * @return the firstname of this registration
	 */
	@AutoEscape
	public String getFirstname();

	/**
	 * Sets the firstname of this registration.
	 *
	 * @param firstname the firstname of this registration
	 */
	public void setFirstname(String firstname);

	/**
	 * Returns the lastname of this registration.
	 *
	 * @return the lastname of this registration
	 */
	@AutoEscape
	public String getLastname();

	/**
	 * Sets the lastname of this registration.
	 *
	 * @param lastname the lastname of this registration
	 */
	public void setLastname(String lastname);

	/**
	 * Returns the email of this registration.
	 *
	 * @return the email of this registration
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this registration.
	 *
	 * @param email the email of this registration
	 */
	public void setEmail(String email);

	/**
	 * Returns the username of this registration.
	 *
	 * @return the username of this registration
	 */
	@AutoEscape
	public String getUsername();

	/**
	 * Sets the username of this registration.
	 *
	 * @param username the username of this registration
	 */
	public void setUsername(String username);

	/**
	 * Returns the password of this registration.
	 *
	 * @return the password of this registration
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this registration.
	 *
	 * @param password the password of this registration
	 */
	public void setPassword(String password);

	/**
	 * Returns the gender of this registration.
	 *
	 * @return the gender of this registration
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this registration.
	 *
	 * @param gender the gender of this registration
	 */
	public void setGender(String gender);

	/**
	 * Returns the dob of this registration.
	 *
	 * @return the dob of this registration
	 */
	public Date getDob();

	/**
	 * Sets the dob of this registration.
	 *
	 * @param dob the dob of this registration
	 */
	public void setDob(Date dob);

	/**
	 * Returns the homephone of this registration.
	 *
	 * @return the homephone of this registration
	 */
	@AutoEscape
	public String getHomephone();

	/**
	 * Sets the homephone of this registration.
	 *
	 * @param homephone the homephone of this registration
	 */
	public void setHomephone(String homephone);

	/**
	 * Returns the mobilephone of this registration.
	 *
	 * @return the mobilephone of this registration
	 */
	@AutoEscape
	public String getMobilephone();

	/**
	 * Sets the mobilephone of this registration.
	 *
	 * @param mobilephone the mobilephone of this registration
	 */
	public void setMobilephone(String mobilephone);

	/**
	 * Returns the address1 of this registration.
	 *
	 * @return the address1 of this registration
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this registration.
	 *
	 * @param address1 the address1 of this registration
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the address2 of this registration.
	 *
	 * @return the address2 of this registration
	 */
	@AutoEscape
	public String getAddress2();

	/**
	 * Sets the address2 of this registration.
	 *
	 * @param address2 the address2 of this registration
	 */
	public void setAddress2(String address2);

	/**
	 * Returns the city of this registration.
	 *
	 * @return the city of this registration
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this registration.
	 *
	 * @param city the city of this registration
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this registration.
	 *
	 * @return the state of this registration
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this registration.
	 *
	 * @param state the state of this registration
	 */
	public void setState(String state);

	/**
	 * Returns the zipcode of this registration.
	 *
	 * @return the zipcode of this registration
	 */
	@AutoEscape
	public String getZipcode();

	/**
	 * Sets the zipcode of this registration.
	 *
	 * @param zipcode the zipcode of this registration
	 */
	public void setZipcode(String zipcode);

	/**
	 * Returns the securityquestion of this registration.
	 *
	 * @return the securityquestion of this registration
	 */
	@AutoEscape
	public String getSecurityquestion();

	/**
	 * Sets the securityquestion of this registration.
	 *
	 * @param securityquestion the securityquestion of this registration
	 */
	public void setSecurityquestion(String securityquestion);

	/**
	 * Returns the answer of this registration.
	 *
	 * @return the answer of this registration
	 */
	@AutoEscape
	public String getAnswer();

	/**
	 * Sets the answer of this registration.
	 *
	 * @param answer the answer of this registration
	 */
	public void setAnswer(String answer);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Registration registration);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Registration> toCacheModel();

	@Override
	public Registration toEscapedModel();

	@Override
	public Registration toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}