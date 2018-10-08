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

package com.liferay.training.amf.eventmonitor.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.training.amf.eventmonitor.service.exception.NoSuchEventMonitorException;
import com.liferay.training.amf.eventmonitor.service.model.EventMonitor;

/**
 * The persistence interface for the event monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.eventmonitor.service.service.persistence.impl.EventMonitorPersistenceImpl
 * @see EventMonitorUtil
 * @generated
 */
@ProviderType
public interface EventMonitorPersistence extends BasePersistence<EventMonitor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventMonitorUtil} to access the event monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the event monitors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching event monitors
	*/
	public java.util.List<EventMonitor> findByUuid(String uuid);

	/**
	* Returns a range of all the event monitors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByUuid(String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the event monitors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns an ordered range of all the event monitors where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event monitor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor
	* @throws NoSuchEventMonitorException if a matching event monitor could not be found
	*/
	public EventMonitor findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Returns the first event monitor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public EventMonitor fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns the last event monitor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor
	* @throws NoSuchEventMonitorException if a matching event monitor could not be found
	*/
	public EventMonitor findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Returns the last event monitor in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public EventMonitor fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns the event monitors before and after the current event monitor in the ordered set where uuid = &#63;.
	*
	* @param fooId the primary key of the current event monitor
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event monitor
	* @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	*/
	public EventMonitor[] findByUuid_PrevAndNext(long fooId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Removes all the event monitors where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of event monitors where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching event monitors
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the event monitor where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEventMonitorException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching event monitor
	* @throws NoSuchEventMonitorException if a matching event monitor could not be found
	*/
	public EventMonitor findByUUID_G(String uuid, long groupId)
		throws NoSuchEventMonitorException;

	/**
	* Returns the event monitor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public EventMonitor fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the event monitor where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public EventMonitor fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the event monitor where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the event monitor that was removed
	*/
	public EventMonitor removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventMonitorException;

	/**
	* Returns the number of event monitors where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching event monitors
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Returns all the event monitors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching event monitors
	*/
	public java.util.List<EventMonitor> findByUuid_C(String uuid, long companyId);

	/**
	* Returns a range of all the event monitors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByUuid_C(String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the event monitors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByUuid_C(String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns an ordered range of all the event monitors where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByUuid_C(String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event monitor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor
	* @throws NoSuchEventMonitorException if a matching event monitor could not be found
	*/
	public EventMonitor findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Returns the first event monitor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public EventMonitor fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns the last event monitor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor
	* @throws NoSuchEventMonitorException if a matching event monitor could not be found
	*/
	public EventMonitor findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Returns the last event monitor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public EventMonitor fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns the event monitors before and after the current event monitor in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param fooId the primary key of the current event monitor
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event monitor
	* @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	*/
	public EventMonitor[] findByUuid_C_PrevAndNext(long fooId, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Removes all the event monitors where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of event monitors where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching event monitors
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the event monitors where field2 = &#63;.
	*
	* @param field2 the field2
	* @return the matching event monitors
	*/
	public java.util.List<EventMonitor> findByField2(boolean field2);

	/**
	* Returns a range of all the event monitors where field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param field2 the field2
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByField2(boolean field2, int start,
		int end);

	/**
	* Returns an ordered range of all the event monitors where field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param field2 the field2
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByField2(boolean field2, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns an ordered range of all the event monitors where field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param field2 the field2
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching event monitors
	*/
	public java.util.List<EventMonitor> findByField2(boolean field2, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event monitor in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor
	* @throws NoSuchEventMonitorException if a matching event monitor could not be found
	*/
	public EventMonitor findByField2_First(boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Returns the first event monitor in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public EventMonitor fetchByField2_First(boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns the last event monitor in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor
	* @throws NoSuchEventMonitorException if a matching event monitor could not be found
	*/
	public EventMonitor findByField2_Last(boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Returns the last event monitor in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event monitor, or <code>null</code> if a matching event monitor could not be found
	*/
	public EventMonitor fetchByField2_Last(boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns the event monitors before and after the current event monitor in the ordered set where field2 = &#63;.
	*
	* @param fooId the primary key of the current event monitor
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event monitor
	* @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	*/
	public EventMonitor[] findByField2_PrevAndNext(long fooId, boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator)
		throws NoSuchEventMonitorException;

	/**
	* Removes all the event monitors where field2 = &#63; from the database.
	*
	* @param field2 the field2
	*/
	public void removeByField2(boolean field2);

	/**
	* Returns the number of event monitors where field2 = &#63;.
	*
	* @param field2 the field2
	* @return the number of matching event monitors
	*/
	public int countByField2(boolean field2);

	/**
	* Caches the event monitor in the entity cache if it is enabled.
	*
	* @param eventMonitor the event monitor
	*/
	public void cacheResult(EventMonitor eventMonitor);

	/**
	* Caches the event monitors in the entity cache if it is enabled.
	*
	* @param eventMonitors the event monitors
	*/
	public void cacheResult(java.util.List<EventMonitor> eventMonitors);

	/**
	* Creates a new event monitor with the primary key. Does not add the event monitor to the database.
	*
	* @param fooId the primary key for the new event monitor
	* @return the new event monitor
	*/
	public EventMonitor create(long fooId);

	/**
	* Removes the event monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor that was removed
	* @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	*/
	public EventMonitor remove(long fooId) throws NoSuchEventMonitorException;

	public EventMonitor updateImpl(EventMonitor eventMonitor);

	/**
	* Returns the event monitor with the primary key or throws a {@link NoSuchEventMonitorException} if it could not be found.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor
	* @throws NoSuchEventMonitorException if a event monitor with the primary key could not be found
	*/
	public EventMonitor findByPrimaryKey(long fooId)
		throws NoSuchEventMonitorException;

	/**
	* Returns the event monitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fooId the primary key of the event monitor
	* @return the event monitor, or <code>null</code> if a event monitor with the primary key could not be found
	*/
	public EventMonitor fetchByPrimaryKey(long fooId);

	@Override
	public java.util.Map<java.io.Serializable, EventMonitor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the event monitors.
	*
	* @return the event monitors
	*/
	public java.util.List<EventMonitor> findAll();

	/**
	* Returns a range of all the event monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @return the range of event monitors
	*/
	public java.util.List<EventMonitor> findAll(int start, int end);

	/**
	* Returns an ordered range of all the event monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of event monitors
	*/
	public java.util.List<EventMonitor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator);

	/**
	* Returns an ordered range of all the event monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of event monitors
	* @param end the upper bound of the range of event monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of event monitors
	*/
	public java.util.List<EventMonitor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EventMonitor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the event monitors from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of event monitors.
	*
	* @return the number of event monitors
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}