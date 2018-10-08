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

package com.liferay.training.amf.eventmonitor.service.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.training.amf.eventmonitor.service.exception.NoSuchStoreEventsException;
import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;
import com.liferay.training.amf.eventmonitor.service.model.impl.StoreEventsImpl;
import com.liferay.training.amf.eventmonitor.service.model.impl.StoreEventsModelImpl;
import com.liferay.training.amf.eventmonitor.service.service.persistence.StoreEventsPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the store events service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StoreEventsPersistence
 * @see com.liferay.training.amf.eventmonitor.service.service.persistence.StoreEventsUtil
 * @generated
 */
@ProviderType
public class StoreEventsPersistenceImpl extends BasePersistenceImpl<StoreEvents>
	implements StoreEventsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StoreEventsUtil} to access the store events persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StoreEventsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			StoreEventsModelImpl.UUID_COLUMN_BITMASK |
			StoreEventsModelImpl.LOGGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the store eventses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StoreEvents> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<StoreEvents> findByUuid(String uuid, int start, int end,
		OrderByComparator<StoreEvents> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<StoreEvents> findByUuid(String uuid, int start, int end,
		OrderByComparator<StoreEvents> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<StoreEvents> list = null;

		if (retrieveFromCache) {
			list = (List<StoreEvents>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StoreEvents storeEvents : list) {
					if (!Objects.equals(uuid, storeEvents.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STOREEVENTS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StoreEventsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<StoreEvents>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StoreEvents>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first store events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByUuid_First(String uuid,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByUuid_First(uuid, orderByComparator);

		if (storeEvents != null) {
			return storeEvents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchStoreEventsException(msg.toString());
	}

	/**
	 * Returns the first store events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByUuid_First(String uuid,
		OrderByComparator<StoreEvents> orderByComparator) {
		List<StoreEvents> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last store events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByUuid_Last(String uuid,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByUuid_Last(uuid, orderByComparator);

		if (storeEvents != null) {
			return storeEvents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchStoreEventsException(msg.toString());
	}

	/**
	 * Returns the last store events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByUuid_Last(String uuid,
		OrderByComparator<StoreEvents> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<StoreEvents> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the store eventses before and after the current store events in the ordered set where uuid = &#63;.
	 *
	 * @param fooId the primary key of the current store events
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next store events
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents[] findByUuid_PrevAndNext(long fooId, String uuid,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			StoreEvents[] array = new StoreEventsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, storeEvents, uuid,
					orderByComparator, true);

			array[1] = storeEvents;

			array[2] = getByUuid_PrevAndNext(session, storeEvents, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StoreEvents getByUuid_PrevAndNext(Session session,
		StoreEvents storeEvents, String uuid,
		OrderByComparator<StoreEvents> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STOREEVENTS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals("")) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StoreEventsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(storeEvents);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StoreEvents> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the store eventses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (StoreEvents storeEvents : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(storeEvents);
		}
	}

	/**
	 * Returns the number of store eventses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching store eventses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOREEVENTS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "storeEvents.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "storeEvents.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(storeEvents.uuid IS NULL OR storeEvents.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			StoreEventsModelImpl.UUID_COLUMN_BITMASK |
			StoreEventsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the store events where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchStoreEventsException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByUUID_G(String uuid, long groupId)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByUUID_G(uuid, groupId);

		if (storeEvents == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchStoreEventsException(msg.toString());
		}

		return storeEvents;
	}

	/**
	 * Returns the store events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the store events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof StoreEvents) {
			StoreEvents storeEvents = (StoreEvents)result;

			if (!Objects.equals(uuid, storeEvents.getUuid()) ||
					(groupId != storeEvents.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_STOREEVENTS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<StoreEvents> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					StoreEvents storeEvents = list.get(0);

					result = storeEvents;

					cacheResult(storeEvents);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (StoreEvents)result;
		}
	}

	/**
	 * Removes the store events where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the store events that was removed
	 */
	@Override
	public StoreEvents removeByUUID_G(String uuid, long groupId)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = findByUUID_G(uuid, groupId);

		return remove(storeEvents);
	}

	/**
	 * Returns the number of store eventses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching store eventses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STOREEVENTS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals("")) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "storeEvents.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "storeEvents.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(storeEvents.uuid IS NULL OR storeEvents.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "storeEvents.groupId = ?";

	public StoreEventsPersistenceImpl() {
		setModelClass(StoreEvents.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the store events in the entity cache if it is enabled.
	 *
	 * @param storeEvents the store events
	 */
	@Override
	public void cacheResult(StoreEvents storeEvents) {
		entityCache.putResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsImpl.class, storeEvents.getPrimaryKey(), storeEvents);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { storeEvents.getUuid(), storeEvents.getGroupId() },
			storeEvents);

		storeEvents.resetOriginalValues();
	}

	/**
	 * Caches the store eventses in the entity cache if it is enabled.
	 *
	 * @param storeEventses the store eventses
	 */
	@Override
	public void cacheResult(List<StoreEvents> storeEventses) {
		for (StoreEvents storeEvents : storeEventses) {
			if (entityCache.getResult(
						StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
						StoreEventsImpl.class, storeEvents.getPrimaryKey()) == null) {
				cacheResult(storeEvents);
			}
			else {
				storeEvents.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all store eventses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StoreEventsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the store events.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StoreEvents storeEvents) {
		entityCache.removeResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsImpl.class, storeEvents.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((StoreEventsModelImpl)storeEvents, true);
	}

	@Override
	public void clearCache(List<StoreEvents> storeEventses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StoreEvents storeEvents : storeEventses) {
			entityCache.removeResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
				StoreEventsImpl.class, storeEvents.getPrimaryKey());

			clearUniqueFindersCache((StoreEventsModelImpl)storeEvents, true);
		}
	}

	protected void cacheUniqueFindersCache(
		StoreEventsModelImpl storeEventsModelImpl) {
		Object[] args = new Object[] {
				storeEventsModelImpl.getUuid(),
				storeEventsModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			storeEventsModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		StoreEventsModelImpl storeEventsModelImpl, boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					storeEventsModelImpl.getUuid(),
					storeEventsModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((storeEventsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					storeEventsModelImpl.getOriginalUuid(),
					storeEventsModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new store events with the primary key. Does not add the store events to the database.
	 *
	 * @param fooId the primary key for the new store events
	 * @return the new store events
	 */
	@Override
	public StoreEvents create(long fooId) {
		StoreEvents storeEvents = new StoreEventsImpl();

		storeEvents.setNew(true);
		storeEvents.setPrimaryKey(fooId);

		String uuid = PortalUUIDUtil.generate();

		storeEvents.setUuid(uuid);

		return storeEvents;
	}

	/**
	 * Removes the store events with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the store events
	 * @return the store events that was removed
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents remove(long fooId) throws NoSuchStoreEventsException {
		return remove((Serializable)fooId);
	}

	/**
	 * Removes the store events with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the store events
	 * @return the store events that was removed
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents remove(Serializable primaryKey)
		throws NoSuchStoreEventsException {
		Session session = null;

		try {
			session = openSession();

			StoreEvents storeEvents = (StoreEvents)session.get(StoreEventsImpl.class,
					primaryKey);

			if (storeEvents == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStoreEventsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(storeEvents);
		}
		catch (NoSuchStoreEventsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected StoreEvents removeImpl(StoreEvents storeEvents) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(storeEvents)) {
				storeEvents = (StoreEvents)session.get(StoreEventsImpl.class,
						storeEvents.getPrimaryKeyObj());
			}

			if (storeEvents != null) {
				session.delete(storeEvents);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (storeEvents != null) {
			clearCache(storeEvents);
		}

		return storeEvents;
	}

	@Override
	public StoreEvents updateImpl(StoreEvents storeEvents) {
		boolean isNew = storeEvents.isNew();

		if (!(storeEvents instanceof StoreEventsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(storeEvents.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(storeEvents);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in storeEvents proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom StoreEvents implementation " +
				storeEvents.getClass());
		}

		StoreEventsModelImpl storeEventsModelImpl = (StoreEventsModelImpl)storeEvents;

		if (Validator.isNull(storeEvents.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			storeEvents.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (storeEvents.isNew()) {
				session.save(storeEvents);

				storeEvents.setNew(false);
			}
			else {
				storeEvents = (StoreEvents)session.merge(storeEvents);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!StoreEventsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { storeEventsModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((storeEventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						storeEventsModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { storeEventsModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		entityCache.putResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsImpl.class, storeEvents.getPrimaryKey(), storeEvents,
			false);

		clearUniqueFindersCache(storeEventsModelImpl, false);
		cacheUniqueFindersCache(storeEventsModelImpl);

		storeEvents.resetOriginalValues();

		return storeEvents;
	}

	/**
	 * Returns the store events with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the store events
	 * @return the store events
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByPrimaryKey(primaryKey);

		if (storeEvents == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStoreEventsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return storeEvents;
	}

	/**
	 * Returns the store events with the primary key or throws a {@link NoSuchStoreEventsException} if it could not be found.
	 *
	 * @param fooId the primary key of the store events
	 * @return the store events
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents findByPrimaryKey(long fooId)
		throws NoSuchStoreEventsException {
		return findByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns the store events with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the store events
	 * @return the store events, or <code>null</code> if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
				StoreEventsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StoreEvents storeEvents = (StoreEvents)serializable;

		if (storeEvents == null) {
			Session session = null;

			try {
				session = openSession();

				storeEvents = (StoreEvents)session.get(StoreEventsImpl.class,
						primaryKey);

				if (storeEvents != null) {
					cacheResult(storeEvents);
				}
				else {
					entityCache.putResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
						StoreEventsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
					StoreEventsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return storeEvents;
	}

	/**
	 * Returns the store events with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the store events
	 * @return the store events, or <code>null</code> if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents fetchByPrimaryKey(long fooId) {
		return fetchByPrimaryKey((Serializable)fooId);
	}

	@Override
	public Map<Serializable, StoreEvents> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StoreEvents> map = new HashMap<Serializable, StoreEvents>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StoreEvents storeEvents = fetchByPrimaryKey(primaryKey);

			if (storeEvents != null) {
				map.put(primaryKey, storeEvents);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
					StoreEventsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StoreEvents)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STOREEVENTS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (StoreEvents storeEvents : (List<StoreEvents>)q.list()) {
				map.put(storeEvents.getPrimaryKeyObj(), storeEvents);

				cacheResult(storeEvents);

				uncachedPrimaryKeys.remove(storeEvents.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
					StoreEventsImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the store eventses.
	 *
	 * @return the store eventses
	 */
	@Override
	public List<StoreEvents> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<StoreEvents> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<StoreEvents> findAll(int start, int end,
		OrderByComparator<StoreEvents> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<StoreEvents> findAll(int start, int end,
		OrderByComparator<StoreEvents> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<StoreEvents> list = null;

		if (retrieveFromCache) {
			list = (List<StoreEvents>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STOREEVENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STOREEVENTS;

				if (pagination) {
					sql = sql.concat(StoreEventsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StoreEvents>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StoreEvents>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the store eventses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StoreEvents storeEvents : findAll()) {
			remove(storeEvents);
		}
	}

	/**
	 * Returns the number of store eventses.
	 *
	 * @return the number of store eventses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STOREEVENTS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StoreEventsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the store events persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StoreEventsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STOREEVENTS = "SELECT storeEvents FROM StoreEvents storeEvents";
	private static final String _SQL_SELECT_STOREEVENTS_WHERE_PKS_IN = "SELECT storeEvents FROM StoreEvents storeEvents WHERE fooId IN (";
	private static final String _SQL_SELECT_STOREEVENTS_WHERE = "SELECT storeEvents FROM StoreEvents storeEvents WHERE ";
	private static final String _SQL_COUNT_STOREEVENTS = "SELECT COUNT(storeEvents) FROM StoreEvents storeEvents";
	private static final String _SQL_COUNT_STOREEVENTS_WHERE = "SELECT COUNT(storeEvents) FROM StoreEvents storeEvents WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "storeEvents.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StoreEvents exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StoreEvents exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StoreEventsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}