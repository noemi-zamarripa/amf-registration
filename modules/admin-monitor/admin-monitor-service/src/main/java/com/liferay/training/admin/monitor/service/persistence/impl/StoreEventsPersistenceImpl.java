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

package com.liferay.training.admin.monitor.service.persistence.impl;

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

import com.liferay.training.admin.monitor.exception.NoSuchStoreEventsException;
import com.liferay.training.admin.monitor.model.StoreEvents;
import com.liferay.training.admin.monitor.model.impl.StoreEventsImpl;
import com.liferay.training.admin.monitor.model.impl.StoreEventsModelImpl;
import com.liferay.training.admin.monitor.service.persistence.StoreEventsPersistence;

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
 * @see com.liferay.training.admin.monitor.service.persistence.StoreEventsUtil
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
	 * @param eventId the primary key of the current store events
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next store events
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents[] findByUuid_PrevAndNext(long eventId, String uuid,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = findByPrimaryKey(eventId);

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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventType",
			new String[] { String.class.getName() },
			StoreEventsModelImpl.EVENTTYPE_COLUMN_BITMASK |
			StoreEventsModelImpl.LOGGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPE = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the store eventses where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching store eventses
	 */
	@Override
	public List<StoreEvents> findByEventType(String eventType) {
		return findByEventType(eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the store eventses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @return the range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByEventType(String eventType, int start,
		int end) {
		return findByEventType(eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the store eventses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByEventType(String eventType, int start,
		int end, OrderByComparator<StoreEvents> orderByComparator) {
		return findByEventType(eventType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the store eventses where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByEventType(String eventType, int start,
		int end, OrderByComparator<StoreEvents> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType, start, end, orderByComparator };
		}

		List<StoreEvents> list = null;

		if (retrieveFromCache) {
			list = (List<StoreEvents>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StoreEvents storeEvents : list) {
					if (!Objects.equals(eventType, storeEvents.getEventType())) {
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

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals("")) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
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

				if (bindEventType) {
					qPos.add(eventType);
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
	 * Returns the first store events in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByEventType_First(String eventType,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByEventType_First(eventType,
				orderByComparator);

		if (storeEvents != null) {
			return storeEvents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append("}");

		throw new NoSuchStoreEventsException(msg.toString());
	}

	/**
	 * Returns the first store events in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByEventType_First(String eventType,
		OrderByComparator<StoreEvents> orderByComparator) {
		List<StoreEvents> list = findByEventType(eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last store events in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByEventType_Last(String eventType,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByEventType_Last(eventType,
				orderByComparator);

		if (storeEvents != null) {
			return storeEvents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append("}");

		throw new NoSuchStoreEventsException(msg.toString());
	}

	/**
	 * Returns the last store events in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByEventType_Last(String eventType,
		OrderByComparator<StoreEvents> orderByComparator) {
		int count = countByEventType(eventType);

		if (count == 0) {
			return null;
		}

		List<StoreEvents> list = findByEventType(eventType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the store eventses before and after the current store events in the ordered set where eventType = &#63;.
	 *
	 * @param eventId the primary key of the current store events
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next store events
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents[] findByEventType_PrevAndNext(long eventId,
		String eventType, OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			StoreEvents[] array = new StoreEventsImpl[3];

			array[0] = getByEventType_PrevAndNext(session, storeEvents,
					eventType, orderByComparator, true);

			array[1] = storeEvents;

			array[2] = getByEventType_PrevAndNext(session, storeEvents,
					eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StoreEvents getByEventType_PrevAndNext(Session session,
		StoreEvents storeEvents, String eventType,
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

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
		}
		else if (eventType.equals("")) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
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

		if (bindEventType) {
			qPos.add(eventType);
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
	 * Removes all the store eventses where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	@Override
	public void removeByEventType(String eventType) {
		for (StoreEvents storeEvents : findByEventType(eventType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(storeEvents);
		}
	}

	/**
	 * Returns the number of store eventses where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching store eventses
	 */
	@Override
	public int countByEventType(String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTTYPE;

		Object[] finderArgs = new Object[] { eventType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOREEVENTS_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals("")) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
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

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1 = "storeEvents.eventType IS NULL";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 = "storeEvents.eventType = ?";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3 = "(storeEvents.eventType IS NULL OR storeEvents.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName() },
			StoreEventsModelImpl.USERID_COLUMN_BITMASK |
			StoreEventsModelImpl.LOGGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the store eventses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUser(long userId) {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the store eventses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @return the range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUser(long userId, int start, int end) {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the store eventses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUser(long userId, int start, int end,
		OrderByComparator<StoreEvents> orderByComparator) {
		return findByUser(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the store eventses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUser(long userId, int start, int end,
		OrderByComparator<StoreEvents> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<StoreEvents> list = null;

		if (retrieveFromCache) {
			list = (List<StoreEvents>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StoreEvents storeEvents : list) {
					if ((userId != storeEvents.getUserId())) {
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

			query.append(_FINDER_COLUMN_USER_USERID_2);

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

				qPos.add(userId);

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
	 * Returns the first store events in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByUser_First(long userId,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByUser_First(userId, orderByComparator);

		if (storeEvents != null) {
			return storeEvents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchStoreEventsException(msg.toString());
	}

	/**
	 * Returns the first store events in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByUser_First(long userId,
		OrderByComparator<StoreEvents> orderByComparator) {
		List<StoreEvents> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last store events in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByUser_Last(long userId,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByUser_Last(userId, orderByComparator);

		if (storeEvents != null) {
			return storeEvents;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchStoreEventsException(msg.toString());
	}

	/**
	 * Returns the last store events in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByUser_Last(long userId,
		OrderByComparator<StoreEvents> orderByComparator) {
		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<StoreEvents> list = findByUser(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the store eventses before and after the current store events in the ordered set where userId = &#63;.
	 *
	 * @param eventId the primary key of the current store events
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next store events
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents[] findByUser_PrevAndNext(long eventId, long userId,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			StoreEvents[] array = new StoreEventsImpl[3];

			array[0] = getByUser_PrevAndNext(session, storeEvents, userId,
					orderByComparator, true);

			array[1] = storeEvents;

			array[2] = getByUser_PrevAndNext(session, storeEvents, userId,
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

	protected StoreEvents getByUser_PrevAndNext(Session session,
		StoreEvents storeEvents, long userId,
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

		query.append(_FINDER_COLUMN_USER_USERID_2);

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

		qPos.add(userId);

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
	 * Removes all the store eventses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUser(long userId) {
		for (StoreEvents storeEvents : findByUser(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(storeEvents);
		}
	}

	/**
	 * Returns the number of store eventses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching store eventses
	 */
	@Override
	public int countByUser(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STOREEVENTS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "storeEvents.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDEVENTTYPE =
		new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserAndEventType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDEVENTTYPE =
		new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, StoreEventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUserAndEventType",
			new String[] { String.class.getName(), Long.class.getName() },
			StoreEventsModelImpl.EVENTTYPE_COLUMN_BITMASK |
			StoreEventsModelImpl.USERID_COLUMN_BITMASK |
			StoreEventsModelImpl.LOGGED_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERANDEVENTTYPE = new FinderPath(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUserAndEventType",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the store eventses where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @return the matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUserAndEventType(String eventType,
		long userId) {
		return findByUserAndEventType(eventType, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the store eventses where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @return the range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUserAndEventType(String eventType,
		long userId, int start, int end) {
		return findByUserAndEventType(eventType, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the store eventses where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUserAndEventType(String eventType,
		long userId, int start, int end,
		OrderByComparator<StoreEvents> orderByComparator) {
		return findByUserAndEventType(eventType, userId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the store eventses where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StoreEventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of store eventses
	 * @param end the upper bound of the range of store eventses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching store eventses
	 */
	@Override
	public List<StoreEvents> findByUserAndEventType(String eventType,
		long userId, int start, int end,
		OrderByComparator<StoreEvents> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDEVENTTYPE;
			finderArgs = new Object[] { eventType, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERANDEVENTTYPE;
			finderArgs = new Object[] {
					eventType, userId,
					
					start, end, orderByComparator
				};
		}

		List<StoreEvents> list = null;

		if (retrieveFromCache) {
			list = (List<StoreEvents>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StoreEvents storeEvents : list) {
					if (!Objects.equals(eventType, storeEvents.getEventType()) ||
							(userId != storeEvents.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STOREEVENTS_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals("")) {
				query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_2);
			}

			query.append(_FINDER_COLUMN_USERANDEVENTTYPE_USERID_2);

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

				if (bindEventType) {
					qPos.add(eventType);
				}

				qPos.add(userId);

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
	 * Returns the first store events in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByUserAndEventType_First(String eventType,
		long userId, OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByUserAndEventType_First(eventType,
				userId, orderByComparator);

		if (storeEvents != null) {
			return storeEvents;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(", userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchStoreEventsException(msg.toString());
	}

	/**
	 * Returns the first store events in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByUserAndEventType_First(String eventType,
		long userId, OrderByComparator<StoreEvents> orderByComparator) {
		List<StoreEvents> list = findByUserAndEventType(eventType, userId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last store events in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store events
	 * @throws NoSuchStoreEventsException if a matching store events could not be found
	 */
	@Override
	public StoreEvents findByUserAndEventType_Last(String eventType,
		long userId, OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = fetchByUserAndEventType_Last(eventType,
				userId, orderByComparator);

		if (storeEvents != null) {
			return storeEvents;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(", userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchStoreEventsException(msg.toString());
	}

	/**
	 * Returns the last store events in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching store events, or <code>null</code> if a matching store events could not be found
	 */
	@Override
	public StoreEvents fetchByUserAndEventType_Last(String eventType,
		long userId, OrderByComparator<StoreEvents> orderByComparator) {
		int count = countByUserAndEventType(eventType, userId);

		if (count == 0) {
			return null;
		}

		List<StoreEvents> list = findByUserAndEventType(eventType, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the store eventses before and after the current store events in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventId the primary key of the current store events
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next store events
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents[] findByUserAndEventType_PrevAndNext(long eventId,
		String eventType, long userId,
		OrderByComparator<StoreEvents> orderByComparator)
		throws NoSuchStoreEventsException {
		StoreEvents storeEvents = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			StoreEvents[] array = new StoreEventsImpl[3];

			array[0] = getByUserAndEventType_PrevAndNext(session, storeEvents,
					eventType, userId, orderByComparator, true);

			array[1] = storeEvents;

			array[2] = getByUserAndEventType_PrevAndNext(session, storeEvents,
					eventType, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StoreEvents getByUserAndEventType_PrevAndNext(Session session,
		StoreEvents storeEvents, String eventType, long userId,
		OrderByComparator<StoreEvents> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_STOREEVENTS_WHERE);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_1);
		}
		else if (eventType.equals("")) {
			query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_2);
		}

		query.append(_FINDER_COLUMN_USERANDEVENTTYPE_USERID_2);

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

		if (bindEventType) {
			qPos.add(eventType);
		}

		qPos.add(userId);

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
	 * Removes all the store eventses where eventType = &#63; and userId = &#63; from the database.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserAndEventType(String eventType, long userId) {
		for (StoreEvents storeEvents : findByUserAndEventType(eventType,
				userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(storeEvents);
		}
	}

	/**
	 * Returns the number of store eventses where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @return the number of matching store eventses
	 */
	@Override
	public int countByUserAndEventType(String eventType, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERANDEVENTTYPE;

		Object[] finderArgs = new Object[] { eventType, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STOREEVENTS_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals("")) {
				query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_2);
			}

			query.append(_FINDER_COLUMN_USERANDEVENTTYPE_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_1 = "storeEvents.eventType IS NULL AND ";
	private static final String _FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_2 = "storeEvents.eventType = ? AND ";
	private static final String _FINDER_COLUMN_USERANDEVENTTYPE_EVENTTYPE_3 = "(storeEvents.eventType IS NULL OR storeEvents.eventType = '') AND ";
	private static final String _FINDER_COLUMN_USERANDEVENTTYPE_USERID_2 = "storeEvents.userId = ?";

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
	}

	@Override
	public void clearCache(List<StoreEvents> storeEventses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StoreEvents storeEvents : storeEventses) {
			entityCache.removeResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
				StoreEventsImpl.class, storeEvents.getPrimaryKey());
		}
	}

	/**
	 * Creates a new store events with the primary key. Does not add the store events to the database.
	 *
	 * @param eventId the primary key for the new store events
	 * @return the new store events
	 */
	@Override
	public StoreEvents create(long eventId) {
		StoreEvents storeEvents = new StoreEventsImpl();

		storeEvents.setNew(true);
		storeEvents.setPrimaryKey(eventId);

		String uuid = PortalUUIDUtil.generate();

		storeEvents.setUuid(uuid);

		return storeEvents;
	}

	/**
	 * Removes the store events with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the store events
	 * @return the store events that was removed
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents remove(long eventId) throws NoSuchStoreEventsException {
		return remove((Serializable)eventId);
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

			args = new Object[] { storeEventsModelImpl.getEventType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
				args);

			args = new Object[] { storeEventsModelImpl.getUserId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
				args);

			args = new Object[] {
					storeEventsModelImpl.getEventType(),
					storeEventsModelImpl.getUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_USERANDEVENTTYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDEVENTTYPE,
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

			if ((storeEventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						storeEventsModelImpl.getOriginalEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);

				args = new Object[] { storeEventsModelImpl.getEventType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);
			}

			if ((storeEventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						storeEventsModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] { storeEventsModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((storeEventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDEVENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						storeEventsModelImpl.getOriginalEventType(),
						storeEventsModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERANDEVENTTYPE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDEVENTTYPE,
					args);

				args = new Object[] {
						storeEventsModelImpl.getEventType(),
						storeEventsModelImpl.getUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERANDEVENTTYPE,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERANDEVENTTYPE,
					args);
			}
		}

		entityCache.putResult(StoreEventsModelImpl.ENTITY_CACHE_ENABLED,
			StoreEventsImpl.class, storeEvents.getPrimaryKey(), storeEvents,
			false);

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
	 * @param eventId the primary key of the store events
	 * @return the store events
	 * @throws NoSuchStoreEventsException if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents findByPrimaryKey(long eventId)
		throws NoSuchStoreEventsException {
		return findByPrimaryKey((Serializable)eventId);
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
	 * @param eventId the primary key of the store events
	 * @return the store events, or <code>null</code> if a store events with the primary key could not be found
	 */
	@Override
	public StoreEvents fetchByPrimaryKey(long eventId) {
		return fetchByPrimaryKey((Serializable)eventId);
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
	private static final String _SQL_SELECT_STOREEVENTS_WHERE_PKS_IN = "SELECT storeEvents FROM StoreEvents storeEvents WHERE eventId IN (";
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