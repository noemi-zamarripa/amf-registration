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

package com.liferay.training.amf.search.box.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SearchBoxLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SearchBoxLocalService
 * @generated
 */
@ProviderType
public class SearchBoxLocalServiceWrapper implements SearchBoxLocalService,
	ServiceWrapper<SearchBoxLocalService> {
	public SearchBoxLocalServiceWrapper(
		SearchBoxLocalService searchBoxLocalService) {
		_searchBoxLocalService = searchBoxLocalService;
	}

	/**
	* Adds the search box to the database. Also notifies the appropriate model listeners.
	*
	* @param searchBox the search box
	* @return the search box that was added
	*/
	@Override
	public com.liferay.training.amf.search.box.model.SearchBox addSearchBox(
		com.liferay.training.amf.search.box.model.SearchBox searchBox) {
		return _searchBoxLocalService.addSearchBox(searchBox);
	}

	/**
	* Creates a new search box with the primary key. Does not add the search box to the database.
	*
	* @param fooId the primary key for the new search box
	* @return the new search box
	*/
	@Override
	public com.liferay.training.amf.search.box.model.SearchBox createSearchBox(
		long fooId) {
		return _searchBoxLocalService.createSearchBox(fooId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _searchBoxLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the search box with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the search box
	* @return the search box that was removed
	* @throws PortalException if a search box with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.search.box.model.SearchBox deleteSearchBox(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return _searchBoxLocalService.deleteSearchBox(fooId);
	}

	/**
	* Deletes the search box from the database. Also notifies the appropriate model listeners.
	*
	* @param searchBox the search box
	* @return the search box that was removed
	*/
	@Override
	public com.liferay.training.amf.search.box.model.SearchBox deleteSearchBox(
		com.liferay.training.amf.search.box.model.SearchBox searchBox) {
		return _searchBoxLocalService.deleteSearchBox(searchBox);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _searchBoxLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _searchBoxLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.search.box.model.impl.SearchBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _searchBoxLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.search.box.model.impl.SearchBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _searchBoxLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _searchBoxLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _searchBoxLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.training.amf.search.box.model.SearchBox fetchSearchBox(
		long fooId) {
		return _searchBoxLocalService.fetchSearchBox(fooId);
	}

	/**
	* Returns the search box matching the UUID and group.
	*
	* @param uuid the search box's UUID
	* @param groupId the primary key of the group
	* @return the matching search box, or <code>null</code> if a matching search box could not be found
	*/
	@Override
	public com.liferay.training.amf.search.box.model.SearchBox fetchSearchBoxByUuidAndGroupId(
		String uuid, long groupId) {
		return _searchBoxLocalService.fetchSearchBoxByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _searchBoxLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _searchBoxLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _searchBoxLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _searchBoxLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _searchBoxLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the search box with the primary key.
	*
	* @param fooId the primary key of the search box
	* @return the search box
	* @throws PortalException if a search box with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.search.box.model.SearchBox getSearchBox(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return _searchBoxLocalService.getSearchBox(fooId);
	}

	/**
	* Returns the search box matching the UUID and group.
	*
	* @param uuid the search box's UUID
	* @param groupId the primary key of the group
	* @return the matching search box
	* @throws PortalException if a matching search box could not be found
	*/
	@Override
	public com.liferay.training.amf.search.box.model.SearchBox getSearchBoxByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _searchBoxLocalService.getSearchBoxByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the search boxs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.search.box.model.impl.SearchBoxModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of search boxs
	* @param end the upper bound of the range of search boxs (not inclusive)
	* @return the range of search boxs
	*/
	@Override
	public java.util.List<com.liferay.training.amf.search.box.model.SearchBox> getSearchBoxs(
		int start, int end) {
		return _searchBoxLocalService.getSearchBoxs(start, end);
	}

	/**
	* Returns all the search boxs matching the UUID and company.
	*
	* @param uuid the UUID of the search boxs
	* @param companyId the primary key of the company
	* @return the matching search boxs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.training.amf.search.box.model.SearchBox> getSearchBoxsByUuidAndCompanyId(
		String uuid, long companyId) {
		return _searchBoxLocalService.getSearchBoxsByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of search boxs matching the UUID and company.
	*
	* @param uuid the UUID of the search boxs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of search boxs
	* @param end the upper bound of the range of search boxs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching search boxs, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.training.amf.search.box.model.SearchBox> getSearchBoxsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.amf.search.box.model.SearchBox> orderByComparator) {
		return _searchBoxLocalService.getSearchBoxsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of search boxs.
	*
	* @return the number of search boxs
	*/
	@Override
	public int getSearchBoxsCount() {
		return _searchBoxLocalService.getSearchBoxsCount();
	}

	@Override
	public int getTotalUsers(String zip) {
		return _searchBoxLocalService.getTotalUsers(zip);
	}

	@Override
	public java.util.List<Long> getUserIdFromZip(String zip, int start, int end) {
		return _searchBoxLocalService.getUserIdFromZip(zip, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> getUsers(
		String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _searchBoxLocalService.getUsers(zip, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.model.User> getUsersFromIds(
		java.util.List<Long> userIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _searchBoxLocalService.getUsersFromIds(userIds);
	}

	/**
	* Updates the search box in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param searchBox the search box
	* @return the search box that was updated
	*/
	@Override
	public com.liferay.training.amf.search.box.model.SearchBox updateSearchBox(
		com.liferay.training.amf.search.box.model.SearchBox searchBox) {
		return _searchBoxLocalService.updateSearchBox(searchBox);
	}

	@Override
	public SearchBoxLocalService getWrappedService() {
		return _searchBoxLocalService;
	}

	@Override
	public void setWrappedService(SearchBoxLocalService searchBoxLocalService) {
		_searchBoxLocalService = searchBoxLocalService;
	}

	private SearchBoxLocalService _searchBoxLocalService;
}