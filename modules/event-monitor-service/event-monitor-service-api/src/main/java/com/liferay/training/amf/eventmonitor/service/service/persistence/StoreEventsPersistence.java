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

import com.liferay.training.amf.eventmonitor.service.exception.NoSuchStoreEventsException;
import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;

/**
 * The persistence interface for the store events service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.eventmonitor.service.service.persistence.impl.StoreEventsPersistenceImpl
 * @see StoreEventsUtil
 * @generated
 */
@ProviderType
public interface StoreEventsPersistence extends BasePersistence<StoreEvents> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StoreEventsUtil} to access the store events persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the store eventses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching store eventses
	*/
	public java.util.List<StoreEvents> findByUuid(String uuid);

	/**
	* Returns a range of all the store eventses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of store eventses
	* @param end the upper bound of the range of store eventses (not inclusive)
	* @return the range of matching store eventses
	*/
	public java.util.List<StoreEvents> findByUuid(String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the store eventses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of store eventses
	* @param end the upper bound of the range of store eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching store eventses
	*/
	public java.util.List<StoreEvents> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator);

	/**
	* Returns an ordered range of all the store eventses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of store eventses
	* @param end the upper bound of the range of store eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching store eventses
	*/
	public java.util.List<StoreEvents> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first store events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching store events
	* @throws NoSuchStoreEventsException if a matching store events could not be found
	*/
	public StoreEvents findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException;

	/**
	* Returns the first store events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching store events, or <code>null</code> if a matching store events could not be found
	*/
	public StoreEvents fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator);

	/**
	* Returns the last store events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching store events
	* @throws NoSuchStoreEventsException if a matching store events could not be found
	*/
	public StoreEvents findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException;

	/**
	* Returns the last store events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching store events, or <code>null</code> if a matching store events could not be found
	*/
	public StoreEvents fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator);

	/**
	* Returns the store eventses before and after the current store events in the ordered set where uuid = &#63;.
	*
	* @param fooId the primary key of the current store events
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next store events
	* @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	*/
	public StoreEvents[] findByUuid_PrevAndNext(long fooId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException;

	/**
	* Removes all the store eventses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of store eventses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching store eventses
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the store events where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchStoreEventsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching store events
	* @throws NoSuchStoreEventsException if a matching store events could not be found
	*/
	public StoreEvents findByUUID_G(String uuid, long groupId)
		throws NoSuchStoreEventsException;

	/**
	* Returns the store events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching store events, or <code>null</code> if a matching store events could not be found
	*/
	public StoreEvents fetchByUUID_G(String uuid, long groupId);

	/**
	* Returns the store events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching store events, or <code>null</code> if a matching store events could not be found
	*/
	public StoreEvents fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the store events where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the store events that was removed
	*/
	public StoreEvents removeByUUID_G(String uuid, long groupId)
		throws NoSuchStoreEventsException;

	/**
	* Returns the number of store eventses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching store eventses
	*/
	public int countByUUID_G(String uuid, long groupId);

	/**
	* Caches the store events in the entity cache if it is enabled.
	*
	* @param storeEvents the store events
	*/
	public void cacheResult(StoreEvents storeEvents);

	/**
	* Caches the store eventses in the entity cache if it is enabled.
	*
	* @param storeEventses the store eventses
	*/
	public void cacheResult(java.util.List<StoreEvents> storeEventses);

	/**
	* Creates a new store events with the primary key. Does not add the store events to the database.
	*
	* @param fooId the primary key for the new store events
	* @return the new store events
	*/
	public StoreEvents create(long fooId);

	/**
	* Removes the store events with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the store events
	* @return the store events that was removed
	* @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	*/
	public StoreEvents remove(long fooId) throws NoSuchStoreEventsException;

	public StoreEvents updateImpl(StoreEvents storeEvents);

	/**
	* Returns the store events with the primary key or throws a {@link NoSuchStoreEventsException} if it could not be found.
	*
	* @param fooId the primary key of the store events
	* @return the store events
	* @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	*/
	public StoreEvents findByPrimaryKey(long fooId)
		throws NoSuchStoreEventsException;

	/**
	* Returns the store events with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fooId the primary key of the store events
	* @return the store events, or <code>null</code> if a store events with the primary key could not be found
	*/
	public StoreEvents fetchByPrimaryKey(long fooId);

	@Override
	public java.util.Map<java.io.Serializable, StoreEvents> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the store eventses.
	*
	* @return the store eventses
	*/
	public java.util.List<StoreEvents> findAll();

	/**
	* Returns a range of all the store eventses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of store eventses
	* @param end the upper bound of the range of store eventses (not inclusive)
	* @return the range of store eventses
	*/
	public java.util.List<StoreEvents> findAll(int start, int end);

	/**
	* Returns an ordered range of all the store eventses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of store eventses
	* @param end the upper bound of the range of store eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of store eventses
	*/
	public java.util.List<StoreEvents> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator);

	/**
	* Returns an ordered range of all the store eventses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of store eventses
	* @param end the upper bound of the range of store eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of store eventses
	*/
	public java.util.List<StoreEvents> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<StoreEvents> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the store eventses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of store eventses.
	*
	* @return the number of store eventses
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}