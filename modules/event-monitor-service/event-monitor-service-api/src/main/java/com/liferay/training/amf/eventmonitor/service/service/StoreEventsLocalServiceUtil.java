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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for StoreEvents. This utility wraps
 * {@link com.liferay.training.amf.eventmonitor.service.service.impl.StoreEventsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StoreEventsLocalService
 * @see com.liferay.training.amf.eventmonitor.service.service.base.StoreEventsLocalServiceBaseImpl
 * @see com.liferay.training.amf.eventmonitor.service.service.impl.StoreEventsLocalServiceImpl
 * @generated
 */
@ProviderType
public class StoreEventsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.eventmonitor.service.service.impl.StoreEventsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the store events to the database. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was added
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents addStoreEvents(
		com.liferay.training.amf.eventmonitor.service.model.StoreEvents storeEvents) {
		return getService().addStoreEvents(storeEvents);
	}

	/**
	* Creates a new store events with the primary key. Does not add the store events to the database.
	*
	* @param fooId the primary key for the new store events
	* @return the new store events
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents createStoreEvents(
		long fooId) {
		return getService().createStoreEvents(fooId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the store events with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the store events
	* @return the store events that was removed
	* @throws PortalException if a store events with the primary key could not be found
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents deleteStoreEvents(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStoreEvents(fooId);
	}

	/**
	* Deletes the store events from the database. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was removed
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents deleteStoreEvents(
		com.liferay.training.amf.eventmonitor.service.model.StoreEvents storeEvents) {
		return getService().deleteStoreEvents(storeEvents);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents fetchStoreEvents(
		long fooId) {
		return getService().fetchStoreEvents(fooId);
	}

	/**
	* Returns the store events matching the UUID and group.
	*
	* @param uuid the store events's UUID
	* @param groupId the primary key of the group
	* @return the matching store events, or <code>null</code> if a matching store events could not be found
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents fetchStoreEventsByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchStoreEventsByUuidAndGroupId(uuid, groupId);
	}

	public static java.util.List<com.liferay.training.amf.eventmonitor.service.model.StoreEvents> findByEventType(
		String eventType) {
		return getService().findByEventType(eventType);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the store events with the primary key.
	*
	* @param fooId the primary key of the store events
	* @return the store events
	* @throws PortalException if a store events with the primary key could not be found
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents getStoreEvents(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStoreEvents(fooId);
	}

	/**
	* Returns the store events matching the UUID and group.
	*
	* @param uuid the store events's UUID
	* @param groupId the primary key of the group
	* @return the matching store events
	* @throws PortalException if a matching store events could not be found
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents getStoreEventsByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStoreEventsByUuidAndGroupId(uuid, groupId);
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
	public static java.util.List<com.liferay.training.amf.eventmonitor.service.model.StoreEvents> getStoreEventses(
		int start, int end) {
		return getService().getStoreEventses(start, end);
	}

	/**
	* Returns the number of store eventses.
	*
	* @return the number of store eventses
	*/
	public static int getStoreEventsesCount() {
		return getService().getStoreEventsesCount();
	}

	/**
	* Updates the store events in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was updated
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.StoreEvents updateStoreEvents(
		com.liferay.training.amf.eventmonitor.service.model.StoreEvents storeEvents) {
		return getService().updateStoreEvents(storeEvents);
	}

	public static StoreEventsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StoreEventsLocalService, StoreEventsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StoreEventsLocalService.class);

		ServiceTracker<StoreEventsLocalService, StoreEventsLocalService> serviceTracker =
			new ServiceTracker<StoreEventsLocalService, StoreEventsLocalService>(bundle.getBundleContext(),
				StoreEventsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}