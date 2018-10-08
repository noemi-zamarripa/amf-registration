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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
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

import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for StoreEvents. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see StoreEventsLocalServiceUtil
 * @see com.liferay.training.amf.eventmonitor.service.service.base.StoreEventsLocalServiceBaseImpl
 * @see com.liferay.training.amf.eventmonitor.service.service.impl.StoreEventsLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface StoreEventsLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StoreEventsLocalServiceUtil} to access the store events local service. Add custom service methods to {@link com.liferay.training.amf.eventmonitor.service.service.impl.StoreEventsLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the store events to the database. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public StoreEvents addStoreEvents(StoreEvents storeEvents);

	/**
	* Creates a new store events with the primary key. Does not add the store events to the database.
	*
	* @param fooId the primary key for the new store events
	* @return the new store events
	*/
	@Transactional(enabled = false)
	public StoreEvents createStoreEvents(long fooId);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	* Deletes the store events with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the store events
	* @return the store events that was removed
	* @throws PortalException if a store events with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public StoreEvents deleteStoreEvents(long fooId) throws PortalException;

	/**
	* Deletes the store events from the database. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public StoreEvents deleteStoreEvents(StoreEvents storeEvents);

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.eventmonitor.service.model.impl.StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.eventmonitor.service.model.impl.StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public StoreEvents fetchStoreEvents(long fooId);

	/**
	* Returns the store events matching the UUID and group.
	*
	* @param uuid the store events's UUID
	* @param groupId the primary key of the group
	* @return the matching store events, or <code>null</code> if a matching store events could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StoreEvents fetchStoreEventsByUuidAndGroupId(String uuid,
		long groupId);

	public List<StoreEvents> findByEventType(String eventType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

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
	* Returns the store events with the primary key.
	*
	* @param fooId the primary key of the store events
	* @return the store events
	* @throws PortalException if a store events with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StoreEvents getStoreEvents(long fooId) throws PortalException;

	/**
	* Returns the store events matching the UUID and group.
	*
	* @param uuid the store events's UUID
	* @param groupId the primary key of the group
	* @return the matching store events
	* @throws PortalException if a matching store events could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public StoreEvents getStoreEventsByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<StoreEvents> getStoreEventses(int start, int end);

	/**
	* Returns the number of store eventses.
	*
	* @return the number of store eventses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStoreEventsesCount();

	/**
	* Updates the store events in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param storeEvents the store events
	* @return the store events that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public StoreEvents updateStoreEvents(StoreEvents storeEvents);
}