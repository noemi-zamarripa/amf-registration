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

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.amf.eventmonitor.service.model.EventMonitor;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for EventMonitor. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EventMonitorLocalServiceUtil
 * @see com.liferay.training.amf.eventmonitor.service.service.base.EventMonitorLocalServiceBaseImpl
 * @see com.liferay.training.amf.eventmonitor.service.service.impl.EventMonitorLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EventMonitorLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventMonitorLocalServiceUtil} to access the event monitor local service. Add custom service methods to {@link com.liferay.training.amf.eventmonitor.service.service.impl.EventMonitorLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the event monitor to the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public EventMonitor addEventMonitor(EventMonitor eventMonitor);

	/**
	* Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	*
	* @param fooId the primary key for the new event monitor
	* @return the new event monitor
	*/
	@Transactional(enabled = false)
	public EventMonitor createEventMonitor(long fooId);

	/**
	* Deletes the event monitor from the database. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public EventMonitor deleteEventMonitor(EventMonitor eventMonitor);

	/**
	* Deletes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor that was removed
	* @throws PortalException if a event monitor with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public EventMonitor deleteEventMonitor(long fooId)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EventMonitor fetchEventMonitor(long fooId);

	/**
	* Returns the event monitor matching the UUID and group.
	*
	* @param uuid the event monitor's UUID
	* @param groupId the primary key of the group
	* @return the matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EventMonitor fetchEventMonitorByUuidAndGroupId(String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the event monitor with the primary key.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor
	* @throws PortalException if a event monitor with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EventMonitor getEventMonitor(long fooId) throws PortalException;

	/**
	* Returns the event monitor matching the UUID and group.
	*
	* @param uuid the event monitor's UUID
	* @param groupId the primary key of the group
	* @return the matching event monitor
	* @throws PortalException if a matching event monitor could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EventMonitor getEventMonitorByUuidAndGroupId(String uuid,
		long groupId) throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EventMonitor> getEventMonitors(int start, int end);

	/**
	* Returns all the event monitors matching the UUID and company.
	*
	* @param uuid the UUID of the event monitors
	* @param companyId the primary key of the company
	* @return the matching event monitors, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EventMonitor> getEventMonitorsByUuidAndCompanyId(String uuid,
		long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EventMonitor> getEventMonitorsByUuidAndCompanyId(String uuid,
		long companyId, int start, int end,
		OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns the number of event monitors.
	*
	* @return the number of event monitors
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEventMonitorsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Updates the event monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eventMonitor the event monitor
	* @return the event monitor that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public EventMonitor updateEventMonitor(EventMonitor eventMonitor);
}