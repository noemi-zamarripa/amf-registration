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

package com.liferay.training.amf.eventmonitor.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StoreEventsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StoreEventsLocalService
 * @generated
 */
@ProviderType
public class StoreEventsLocalServiceWrapper implements StoreEventsLocalService,
	ServiceWrapper<StoreEventsLocalService> {
	public StoreEventsLocalServiceWrapper(
		StoreEventsLocalService storeEventsLocalService) {
		_storeEventsLocalService = storeEventsLocalService;
	}

	/**
	* Adds the store events to the database. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was added
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents addStoreEvents(
		com.liferay.training.amf.eventmonitor.service.model.StoreEvents storeEvents) {
		return _storeEventsLocalService.addStoreEvents(storeEvents);
	}

	/**
	* Creates a new store events with the primary key. Does not add the store events to the database.
	*
	* @param fooId the primary key for the new store events
	* @return the new store events
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents createStoreEvents(
		long fooId) {
		return _storeEventsLocalService.createStoreEvents(fooId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _storeEventsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the store events with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the store events
	* @return the store events that was removed
	* @throws PortalException if a store events with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents deleteStoreEvents(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return _storeEventsLocalService.deleteStoreEvents(fooId);
	}

	/**
	* Deletes the store events from the database. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was removed
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents deleteStoreEvents(
		com.liferay.training.amf.eventmonitor.service.model.StoreEvents storeEvents) {
		return _storeEventsLocalService.deleteStoreEvents(storeEvents);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _storeEventsLocalService.dynamicQuery();
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
		return _storeEventsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.eventmonitor.service.model.impl.StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _storeEventsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.eventmonitor.service.model.impl.StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _storeEventsLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _storeEventsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _storeEventsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents fetchStoreEvents(
		long fooId) {
		return _storeEventsLocalService.fetchStoreEvents(fooId);
	}

	/**
	* Returns the store events matching the UUID and group.
	*
	* @param uuid the store events's UUID
	* @param groupId the primary key of the group
	* @return the matching store events, or <code>null</code> if a matching store events could not be found
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents fetchStoreEventsByUuidAndGroupId(
		String uuid, long groupId) {
		return _storeEventsLocalService.fetchStoreEventsByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public java.util.List<com.liferay.training.amf.eventmonitor.service.model.StoreEvents> findByEventType(
		String eventType) {
		return _storeEventsLocalService.findByEventType(eventType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _storeEventsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _storeEventsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _storeEventsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _storeEventsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the store events with the primary key.
	*
	* @param fooId the primary key of the store events
	* @return the store events
	* @throws PortalException if a store events with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents getStoreEvents(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return _storeEventsLocalService.getStoreEvents(fooId);
	}

	/**
	* Returns the store events matching the UUID and group.
	*
	* @param uuid the store events's UUID
	* @param groupId the primary key of the group
	* @return the matching store events
	* @throws PortalException if a matching store events could not be found
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents getStoreEventsByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _storeEventsLocalService.getStoreEventsByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Returns a range of all the store eventses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.eventmonitor.service.model.impl.StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of store eventses
	* @param end the upper bound of the range of store eventses (not inclusive)
	* @return the range of store eventses
	*/
	@Override
	public java.util.List<com.liferay.training.amf.eventmonitor.service.model.StoreEvents> getStoreEventses(
		int start, int end) {
		return _storeEventsLocalService.getStoreEventses(start, end);
	}

	/**
	* Returns the number of store eventses.
	*
	* @return the number of store eventses
	*/
	@Override
	public int getStoreEventsesCount() {
		return _storeEventsLocalService.getStoreEventsesCount();
	}

	/**
	* Updates the store events in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was updated
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.StoreEvents updateStoreEvents(
		com.liferay.training.amf.eventmonitor.service.model.StoreEvents storeEvents) {
		return _storeEventsLocalService.updateStoreEvents(storeEvents);
	}

	@Override
	public StoreEventsLocalService getWrappedService() {
		return _storeEventsLocalService;
	}

	@Override
	public void setWrappedService(
		StoreEventsLocalService storeEventsLocalService) {
		_storeEventsLocalService = storeEventsLocalService;
	}

	private StoreEventsLocalService _storeEventsLocalService;
}