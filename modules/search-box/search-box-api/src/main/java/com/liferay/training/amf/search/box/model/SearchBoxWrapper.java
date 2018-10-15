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

package com.liferay.training.amf.search.box.model;

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
 * This class is a wrapper for {@link SearchBox}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchBox
 * @generated
 */
@ProviderType
public class SearchBoxWrapper implements SearchBox, ModelWrapper<SearchBox> {
	public SearchBoxWrapper(SearchBox searchBox) {
		_searchBox = searchBox;
	}

	@Override
	public Class<?> getModelClass() {
		return SearchBox.class;
	}

	@Override
	public String getModelClassName() {
		return SearchBox.class.getName();
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
		return new SearchBoxWrapper((SearchBox)_searchBox.clone());
	}

	@Override
	public int compareTo(SearchBox searchBox) {
		return _searchBox.compareTo(searchBox);
	}

	/**
	* Returns the company ID of this search box.
	*
	* @return the company ID of this search box
	*/
	@Override
	public long getCompanyId() {
		return _searchBox.getCompanyId();
	}

	/**
	* Returns the create date of this search box.
	*
	* @return the create date of this search box
	*/
	@Override
	public Date getCreateDate() {
		return _searchBox.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _searchBox.getExpandoBridge();
	}

	/**
	* Returns the field1 of this search box.
	*
	* @return the field1 of this search box
	*/
	@Override
	public String getField1() {
		return _searchBox.getField1();
	}

	/**
	* Returns the field2 of this search box.
	*
	* @return the field2 of this search box
	*/
	@Override
	public boolean getField2() {
		return _searchBox.getField2();
	}

	/**
	* Returns the field3 of this search box.
	*
	* @return the field3 of this search box
	*/
	@Override
	public int getField3() {
		return _searchBox.getField3();
	}

	/**
	* Returns the field4 of this search box.
	*
	* @return the field4 of this search box
	*/
	@Override
	public Date getField4() {
		return _searchBox.getField4();
	}

	/**
	* Returns the field5 of this search box.
	*
	* @return the field5 of this search box
	*/
	@Override
	public String getField5() {
		return _searchBox.getField5();
	}

	/**
	* Returns the foo ID of this search box.
	*
	* @return the foo ID of this search box
	*/
	@Override
	public long getFooId() {
		return _searchBox.getFooId();
	}

	/**
	* Returns the group ID of this search box.
	*
	* @return the group ID of this search box
	*/
	@Override
	public long getGroupId() {
		return _searchBox.getGroupId();
	}

	/**
	* Returns the modified date of this search box.
	*
	* @return the modified date of this search box
	*/
	@Override
	public Date getModifiedDate() {
		return _searchBox.getModifiedDate();
	}

	/**
	* Returns the primary key of this search box.
	*
	* @return the primary key of this search box
	*/
	@Override
	public long getPrimaryKey() {
		return _searchBox.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _searchBox.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this search box.
	*
	* @return the user ID of this search box
	*/
	@Override
	public long getUserId() {
		return _searchBox.getUserId();
	}

	/**
	* Returns the user name of this search box.
	*
	* @return the user name of this search box
	*/
	@Override
	public String getUserName() {
		return _searchBox.getUserName();
	}

	/**
	* Returns the user uuid of this search box.
	*
	* @return the user uuid of this search box
	*/
	@Override
	public String getUserUuid() {
		return _searchBox.getUserUuid();
	}

	/**
	* Returns the uuid of this search box.
	*
	* @return the uuid of this search box
	*/
	@Override
	public String getUuid() {
		return _searchBox.getUuid();
	}

	@Override
	public int hashCode() {
		return _searchBox.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _searchBox.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _searchBox.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this search box is field2.
	*
	* @return <code>true</code> if this search box is field2; <code>false</code> otherwise
	*/
	@Override
	public boolean isField2() {
		return _searchBox.isField2();
	}

	@Override
	public boolean isNew() {
		return _searchBox.isNew();
	}

	@Override
	public void persist() {
		_searchBox.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_searchBox.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this search box.
	*
	* @param companyId the company ID of this search box
	*/
	@Override
	public void setCompanyId(long companyId) {
		_searchBox.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this search box.
	*
	* @param createDate the create date of this search box
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_searchBox.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_searchBox.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_searchBox.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_searchBox.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the field1 of this search box.
	*
	* @param field1 the field1 of this search box
	*/
	@Override
	public void setField1(String field1) {
		_searchBox.setField1(field1);
	}

	/**
	* Sets whether this search box is field2.
	*
	* @param field2 the field2 of this search box
	*/
	@Override
	public void setField2(boolean field2) {
		_searchBox.setField2(field2);
	}

	/**
	* Sets the field3 of this search box.
	*
	* @param field3 the field3 of this search box
	*/
	@Override
	public void setField3(int field3) {
		_searchBox.setField3(field3);
	}

	/**
	* Sets the field4 of this search box.
	*
	* @param field4 the field4 of this search box
	*/
	@Override
	public void setField4(Date field4) {
		_searchBox.setField4(field4);
	}

	/**
	* Sets the field5 of this search box.
	*
	* @param field5 the field5 of this search box
	*/
	@Override
	public void setField5(String field5) {
		_searchBox.setField5(field5);
	}

	/**
	* Sets the foo ID of this search box.
	*
	* @param fooId the foo ID of this search box
	*/
	@Override
	public void setFooId(long fooId) {
		_searchBox.setFooId(fooId);
	}

	/**
	* Sets the group ID of this search box.
	*
	* @param groupId the group ID of this search box
	*/
	@Override
	public void setGroupId(long groupId) {
		_searchBox.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this search box.
	*
	* @param modifiedDate the modified date of this search box
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_searchBox.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_searchBox.setNew(n);
	}

	/**
	* Sets the primary key of this search box.
	*
	* @param primaryKey the primary key of this search box
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_searchBox.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_searchBox.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this search box.
	*
	* @param userId the user ID of this search box
	*/
	@Override
	public void setUserId(long userId) {
		_searchBox.setUserId(userId);
	}

	/**
	* Sets the user name of this search box.
	*
	* @param userName the user name of this search box
	*/
	@Override
	public void setUserName(String userName) {
		_searchBox.setUserName(userName);
	}

	/**
	* Sets the user uuid of this search box.
	*
	* @param userUuid the user uuid of this search box
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_searchBox.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this search box.
	*
	* @param uuid the uuid of this search box
	*/
	@Override
	public void setUuid(String uuid) {
		_searchBox.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SearchBox> toCacheModel() {
		return _searchBox.toCacheModel();
	}

	@Override
	public SearchBox toEscapedModel() {
		return new SearchBoxWrapper(_searchBox.toEscapedModel());
	}

	@Override
	public String toString() {
		return _searchBox.toString();
	}

	@Override
	public SearchBox toUnescapedModel() {
		return new SearchBoxWrapper(_searchBox.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _searchBox.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SearchBoxWrapper)) {
			return false;
		}

		SearchBoxWrapper searchBoxWrapper = (SearchBoxWrapper)obj;

		if (Objects.equals(_searchBox, searchBoxWrapper._searchBox)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _searchBox.getStagedModelType();
	}

	@Override
	public SearchBox getWrappedModel() {
		return _searchBox;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _searchBox.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _searchBox.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_searchBox.resetOriginalValues();
	}

	private final SearchBox _searchBox;
}