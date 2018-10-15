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

package com.liferay.training.amf.search.results.model;

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
 * This class is a wrapper for {@link SearchResults}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchResults
 * @generated
 */
@ProviderType
public class SearchResultsWrapper implements SearchResults,
	ModelWrapper<SearchResults> {
	public SearchResultsWrapper(SearchResults searchResults) {
		_searchResults = searchResults;
	}

	@Override
	public Class<?> getModelClass() {
		return SearchResults.class;
	}

	@Override
	public String getModelClassName() {
		return SearchResults.class.getName();
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
		return new SearchResultsWrapper((SearchResults)_searchResults.clone());
	}

	@Override
	public int compareTo(SearchResults searchResults) {
		return _searchResults.compareTo(searchResults);
	}

	/**
	* Returns the company ID of this search results.
	*
	* @return the company ID of this search results
	*/
	@Override
	public long getCompanyId() {
		return _searchResults.getCompanyId();
	}

	/**
	* Returns the create date of this search results.
	*
	* @return the create date of this search results
	*/
	@Override
	public Date getCreateDate() {
		return _searchResults.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _searchResults.getExpandoBridge();
	}

	/**
	* Returns the field1 of this search results.
	*
	* @return the field1 of this search results
	*/
	@Override
	public String getField1() {
		return _searchResults.getField1();
	}

	/**
	* Returns the field2 of this search results.
	*
	* @return the field2 of this search results
	*/
	@Override
	public boolean getField2() {
		return _searchResults.getField2();
	}

	/**
	* Returns the field3 of this search results.
	*
	* @return the field3 of this search results
	*/
	@Override
	public int getField3() {
		return _searchResults.getField3();
	}

	/**
	* Returns the field4 of this search results.
	*
	* @return the field4 of this search results
	*/
	@Override
	public Date getField4() {
		return _searchResults.getField4();
	}

	/**
	* Returns the field5 of this search results.
	*
	* @return the field5 of this search results
	*/
	@Override
	public String getField5() {
		return _searchResults.getField5();
	}

	/**
	* Returns the foo ID of this search results.
	*
	* @return the foo ID of this search results
	*/
	@Override
	public long getFooId() {
		return _searchResults.getFooId();
	}

	/**
	* Returns the group ID of this search results.
	*
	* @return the group ID of this search results
	*/
	@Override
	public long getGroupId() {
		return _searchResults.getGroupId();
	}

	/**
	* Returns the modified date of this search results.
	*
	* @return the modified date of this search results
	*/
	@Override
	public Date getModifiedDate() {
		return _searchResults.getModifiedDate();
	}

	/**
	* Returns the primary key of this search results.
	*
	* @return the primary key of this search results
	*/
	@Override
	public long getPrimaryKey() {
		return _searchResults.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _searchResults.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this search results.
	*
	* @return the user ID of this search results
	*/
	@Override
	public long getUserId() {
		return _searchResults.getUserId();
	}

	/**
	* Returns the user name of this search results.
	*
	* @return the user name of this search results
	*/
	@Override
	public String getUserName() {
		return _searchResults.getUserName();
	}

	/**
	* Returns the user uuid of this search results.
	*
	* @return the user uuid of this search results
	*/
	@Override
	public String getUserUuid() {
		return _searchResults.getUserUuid();
	}

	/**
	* Returns the uuid of this search results.
	*
	* @return the uuid of this search results
	*/
	@Override
	public String getUuid() {
		return _searchResults.getUuid();
	}

	@Override
	public int hashCode() {
		return _searchResults.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _searchResults.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _searchResults.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this search results is field2.
	*
	* @return <code>true</code> if this search results is field2; <code>false</code> otherwise
	*/
	@Override
	public boolean isField2() {
		return _searchResults.isField2();
	}

	@Override
	public boolean isNew() {
		return _searchResults.isNew();
	}

	@Override
	public void persist() {
		_searchResults.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_searchResults.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this search results.
	*
	* @param companyId the company ID of this search results
	*/
	@Override
	public void setCompanyId(long companyId) {
		_searchResults.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this search results.
	*
	* @param createDate the create date of this search results
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_searchResults.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_searchResults.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_searchResults.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_searchResults.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the field1 of this search results.
	*
	* @param field1 the field1 of this search results
	*/
	@Override
	public void setField1(String field1) {
		_searchResults.setField1(field1);
	}

	/**
	* Sets whether this search results is field2.
	*
	* @param field2 the field2 of this search results
	*/
	@Override
	public void setField2(boolean field2) {
		_searchResults.setField2(field2);
	}

	/**
	* Sets the field3 of this search results.
	*
	* @param field3 the field3 of this search results
	*/
	@Override
	public void setField3(int field3) {
		_searchResults.setField3(field3);
	}

	/**
	* Sets the field4 of this search results.
	*
	* @param field4 the field4 of this search results
	*/
	@Override
	public void setField4(Date field4) {
		_searchResults.setField4(field4);
	}

	/**
	* Sets the field5 of this search results.
	*
	* @param field5 the field5 of this search results
	*/
	@Override
	public void setField5(String field5) {
		_searchResults.setField5(field5);
	}

	/**
	* Sets the foo ID of this search results.
	*
	* @param fooId the foo ID of this search results
	*/
	@Override
	public void setFooId(long fooId) {
		_searchResults.setFooId(fooId);
	}

	/**
	* Sets the group ID of this search results.
	*
	* @param groupId the group ID of this search results
	*/
	@Override
	public void setGroupId(long groupId) {
		_searchResults.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this search results.
	*
	* @param modifiedDate the modified date of this search results
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_searchResults.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_searchResults.setNew(n);
	}

	/**
	* Sets the primary key of this search results.
	*
	* @param primaryKey the primary key of this search results
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_searchResults.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_searchResults.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this search results.
	*
	* @param userId the user ID of this search results
	*/
	@Override
	public void setUserId(long userId) {
		_searchResults.setUserId(userId);
	}

	/**
	* Sets the user name of this search results.
	*
	* @param userName the user name of this search results
	*/
	@Override
	public void setUserName(String userName) {
		_searchResults.setUserName(userName);
	}

	/**
	* Sets the user uuid of this search results.
	*
	* @param userUuid the user uuid of this search results
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_searchResults.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this search results.
	*
	* @param uuid the uuid of this search results
	*/
	@Override
	public void setUuid(String uuid) {
		_searchResults.setUuid(uuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SearchResults> toCacheModel() {
		return _searchResults.toCacheModel();
	}

	@Override
	public SearchResults toEscapedModel() {
		return new SearchResultsWrapper(_searchResults.toEscapedModel());
	}

	@Override
	public String toString() {
		return _searchResults.toString();
	}

	@Override
	public SearchResults toUnescapedModel() {
		return new SearchResultsWrapper(_searchResults.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _searchResults.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SearchResultsWrapper)) {
			return false;
		}

		SearchResultsWrapper searchResultsWrapper = (SearchResultsWrapper)obj;

		if (Objects.equals(_searchResults, searchResultsWrapper._searchResults)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _searchResults.getStagedModelType();
	}

	@Override
	public SearchResults getWrappedModel() {
		return _searchResults;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _searchResults.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _searchResults.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_searchResults.resetOriginalValues();
	}

	private final SearchResults _searchResults;
}