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
 * Provides a wrapper for {@link EventMonitorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventMonitorLocalService
 * @generated
 */
@ProviderType
public class EventMonitorLocalServiceWrapper implements EventMonitorLocalService,
	ServiceWrapper<EventMonitorLocalService> {
	public EventMonitorLocalServiceWrapper(
		EventMonitorLocalService eventMonitorLocalService) {
		_eventMonitorLocalService = eventMonitorLocalService;
	}

	/**
	* Adds the event monitor to the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was added
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor addEventMonitor(
		com.liferay.training.amf.eventmonitor.service.model.EventMonitor eventMonitor) {
		return _eventMonitorLocalService.addEventMonitor(eventMonitor);
	}

	/**
	* Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	*
	* @param fooId the primary key for the new event monitor
	* @return the new event monitor
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor createEventMonitor(
		long fooId) {
		return _eventMonitorLocalService.createEventMonitor(fooId);
	}

	/**
	* Deletes the event monitor from the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was removed
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor deleteEventMonitor(
		com.liferay.training.amf.eventmonitor.service.model.EventMonitor eventMonitor) {
		return _eventMonitorLocalService.deleteEventMonitor(eventMonitor);
	}

	/**
	* Deletes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor that was removed
	* @throws PortalException if a event monitor with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor deleteEventMonitor(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return _eventMonitorLocalService.deleteEventMonitor(fooId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventMonitorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventMonitorLocalService.dynamicQuery();
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
		return _eventMonitorLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _eventMonitorLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _eventMonitorLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _eventMonitorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _eventMonitorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor fetchEventMonitor(
		long fooId) {
		return _eventMonitorLocalService.fetchEventMonitor(fooId);
	}

	/**
	* Returns the event monitor matching the UUID and group.
	*
	* @param uuid the event monitor's UUID
	* @param groupId the primary key of the group
	* @return the matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor fetchEventMonitorByUuidAndGroupId(
		String uuid, long groupId) {
		return _eventMonitorLocalService.fetchEventMonitorByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _eventMonitorLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the event monitor with the primary key.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor
	* @throws PortalException if a event monitor with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor getEventMonitor(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return _eventMonitorLocalService.getEventMonitor(fooId);
	}

	/**
	* Returns the event monitor matching the UUID and group.
	*
	* @param uuid the event monitor's UUID
	* @param groupId the primary key of the group
	* @return the matching event monitor
	* @throws PortalException if a matching event monitor could not be found
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor getEventMonitorByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventMonitorLocalService.getEventMonitorByUuidAndGroupId(uuid,
			groupId);
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
	@Override
	public java.util.List<com.liferay.training.amf.eventmonitor.service.model.EventMonitor> getEventMonitors(
		int start, int end) {
		return _eventMonitorLocalService.getEventMonitors(start, end);
	}

	/**
	* Returns all the event monitors matching the UUID and company.
	*
	* @param uuid the UUID of the event monitors
	* @param companyId the primary key of the company
	* @return the matching event monitors, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.liferay.training.amf.eventmonitor.service.model.EventMonitor> getEventMonitorsByUuidAndCompanyId(
		String uuid, long companyId) {
		return _eventMonitorLocalService.getEventMonitorsByUuidAndCompanyId(uuid,
			companyId);
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
	@Override
	public java.util.List<com.liferay.training.amf.eventmonitor.service.model.EventMonitor> getEventMonitorsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.training.amf.eventmonitor.service.model.EventMonitor> orderByComparator) {
		return _eventMonitorLocalService.getEventMonitorsByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of event monitors.
	*
	* @return the number of event monitors
	*/
	@Override
	public int getEventMonitorsCount() {
		return _eventMonitorLocalService.getEventMonitorsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _eventMonitorLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _eventMonitorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _eventMonitorLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventMonitorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the event monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was updated
	*/
	@Override
	public com.liferay.training.amf.eventmonitor.service.model.EventMonitor updateEventMonitor(
		com.liferay.training.amf.eventmonitor.service.model.EventMonitor eventMonitor) {
		return _eventMonitorLocalService.updateEventMonitor(eventMonitor);
	}

	@Override
	public EventMonitorLocalService getWrappedService() {
		return _eventMonitorLocalService;
	}

	@Override
	public void setWrappedService(
		EventMonitorLocalService eventMonitorLocalService) {
		_eventMonitorLocalService = eventMonitorLocalService;
	}

	private EventMonitorLocalService _eventMonitorLocalService;
}