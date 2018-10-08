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
 * Provides the local service utility for EventMonitor. This utility wraps
 * {@link com.liferay.training.amf.eventmonitor.service.service.impl.EventMonitorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EventMonitorLocalService
 * @see com.liferay.training.amf.eventmonitor.service.service.base.EventMonitorLocalServiceBaseImpl
 * @see com.liferay.training.amf.eventmonitor.service.service.impl.EventMonitorLocalServiceImpl
 * @generated
 */
@ProviderType
public class EventMonitorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.eventmonitor.service.service.impl.EventMonitorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the event monitor to the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was added
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor addEventMonitor(
		com.liferay.training.amf.eventmonitor.service.model.EventMonitor eventMonitor) {
		return getService().addEventMonitor(eventMonitor);
	}

	/**
	* Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	*
	* @param fooId the primary key for the new event monitor
	* @return the new event monitor
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor createEventMonitor(
		long fooId) {
		return getService().createEventMonitor(fooId);
	}

	/**
	* Deletes the event monitor from the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was removed
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor deleteEventMonitor(
		com.liferay.training.amf.eventmonitor.service.model.EventMonitor eventMonitor) {
		return getService().deleteEventMonitor(eventMonitor);
	}

	/**
	* Deletes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor that was removed
	* @throws PortalException if a event monitor with the primary key could not be found
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor deleteEventMonitor(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEventMonitor(fooId);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.eventmonitor.service.model.impl.EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.eventmonitor.service.model.impl.EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor fetchEventMonitor(
		long fooId) {
		return getService().fetchEventMonitor(fooId);
	}

	/**
	* Returns the event monitor matching the UUID and group.
	*
	* @param uuid the event monitor's UUID
	* @param groupId the primary key of the group
	* @return the matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor fetchEventMonitorByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchEventMonitorByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the event monitor with the primary key.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor
	* @throws PortalException if a event monitor with the primary key could not be found
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor getEventMonitor(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEventMonitor(fooId);
	}

	/**
	* Returns the event monitor matching the UUID and group.
	*
	* @param uuid the event monitor's UUID
	* @param groupId the primary key of the group
	* @return the matching event monitor
	* @throws PortalException if a matching event monitor could not be found
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor getEventMonitorByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEventMonitorByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the event monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.eventmonitor.service.model.impl.EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of event monitors
	*/
	public static java.util.List<com.liferay.training.amf.eventmonitor.service.model.EventMonitor> getEventMonitors(
		int start, int end) {
		return getService().getEventMonitors(start, end);
	}

	/**
	* Returns all the event monitors matching the UUID and company.
	*
	* @param uuid the UUID of the event monitors
	* @param companyId the primary key of the company
	* @return the matching event monitors, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.training.amf.eventmonitor.service.model.EventMonitor> getEventMonitorsByUuidAndCompanyId(
		String uuid, long companyId) {
		return getService().getEventMonitorsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of event monitors matching the UUID and company.
	*
	* @param uuid the UUID of the event monitors
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching event monitors, or an empty list if no matches were found
	*/
	public static java.util.List<com.liferay.training.amf.eventmonitor.service.model.EventMonitor> getEventMonitorsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.amf.eventmonitor.service.model.EventMonitor> orderByComparator) {
		return getService()
				   .getEventMonitorsByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of event monitors.
	*
	* @return the number of event monitors
	*/
	public static int getEventMonitorsCount() {
		return getService().getEventMonitorsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
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
	* Updates the event monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was updated
	*/
	public static com.liferay.training.amf.eventmonitor.service.model.EventMonitor updateEventMonitor(
		com.liferay.training.amf.eventmonitor.service.model.EventMonitor eventMonitor) {
		return getService().updateEventMonitor(eventMonitor);
	}

	public static EventMonitorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EventMonitorLocalService, EventMonitorLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EventMonitorLocalService.class);

		ServiceTracker<EventMonitorLocalService, EventMonitorLocalService> serviceTracker =
			new ServiceTracker<EventMonitorLocalService, EventMonitorLocalService>(bundle.getBundleContext(),
				EventMonitorLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}