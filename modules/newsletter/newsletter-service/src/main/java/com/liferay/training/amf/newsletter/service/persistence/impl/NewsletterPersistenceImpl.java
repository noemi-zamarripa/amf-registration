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

package com.liferay.training.amf.newsletter.service.persistence.impl;

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

import com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException;
import com.liferay.training.amf.newsletter.model.Newsletter;
import com.liferay.training.amf.newsletter.model.impl.NewsletterImpl;
import com.liferay.training.amf.newsletter.model.impl.NewsletterModelImpl;
import com.liferay.training.amf.newsletter.service.persistence.NewsletterPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterPersistence
 * @see com.liferay.training.amf.newsletter.service.persistence.NewsletterUtil
 * @generated
 */
@ProviderType
public class NewsletterPersistenceImpl extends BasePersistenceImpl<Newsletter>
	implements NewsletterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = NewsletterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			NewsletterModelImpl.UUID_COLUMN_BITMASK |
			NewsletterModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the newsletters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching newsletters
	 */
	@Override
	public List<Newsletter> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByUuid(String uuid, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletters where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByUuid(String uuid, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
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

		List<Newsletter> list = null;

		if (retrieveFromCache) {
			list = (List<Newsletter>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Newsletter newsletter : list) {
					if (!Objects.equals(uuid, newsletter.getUuid())) {
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

			query.append(_SQL_SELECT_NEWSLETTER_WHERE);

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
				query.append(NewsletterModelImpl.ORDER_BY_JPQL);
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
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	@Override
	public Newsletter findByUuid_First(String uuid,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByUuid_First(uuid, orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the first newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	@Override
	public Newsletter fetchByUuid_First(String uuid,
		OrderByComparator<Newsletter> orderByComparator) {
		List<Newsletter> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	@Override
	public Newsletter findByUuid_Last(String uuid,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByUuid_Last(uuid, orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the last newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	@Override
	public Newsletter fetchByUuid_Last(String uuid,
		OrderByComparator<Newsletter> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Newsletter> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newsletters before and after the current newsletter in the ordered set where uuid = &#63;.
	 *
	 * @param newsletterId the primary key of the current newsletter
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter[] findByUuid_PrevAndNext(long newsletterId, String uuid,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = findByPrimaryKey(newsletterId);

		Session session = null;

		try {
			session = openSession();

			Newsletter[] array = new NewsletterImpl[3];

			array[0] = getByUuid_PrevAndNext(session, newsletter, uuid,
					orderByComparator, true);

			array[1] = newsletter;

			array[2] = getByUuid_PrevAndNext(session, newsletter, uuid,
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

	protected Newsletter getByUuid_PrevAndNext(Session session,
		Newsletter newsletter, String uuid,
		OrderByComparator<Newsletter> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_NEWSLETTER_WHERE);

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
			query.append(NewsletterModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(newsletter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Newsletter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newsletters where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Newsletter newsletter : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(newsletter);
		}
	}

	/**
	 * Returns the number of newsletters where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching newsletters
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_NEWSLETTER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "newsletter.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "newsletter.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(newsletter.uuid IS NULL OR newsletter.uuid = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUEDATE =
		new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIssueDate",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEDATE =
		new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIssueDate",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			NewsletterModelImpl.ISSUEDATE_COLUMN_BITMASK |
			NewsletterModelImpl.ISARTICLE_COLUMN_BITMASK |
			NewsletterModelImpl.MOSTRECENT_COLUMN_BITMASK |
			NewsletterModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSUEDATE = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssueDate",
			new String[] {
				Date.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @return the matching newsletters
	 */
	@Override
	public List<Newsletter> findByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent) {
		return findByIssueDate(issueDate, isArticle, mostRecent,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent, int start, int end) {
		return findByIssueDate(issueDate, isArticle, mostRecent, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return findByIssueDate(issueDate, isArticle, mostRecent, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEDATE;
			finderArgs = new Object[] { _getTime(issueDate), isArticle, mostRecent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUEDATE;
			finderArgs = new Object[] {
					_getTime(issueDate), isArticle, mostRecent,
					
					start, end, orderByComparator
				};
		}

		List<Newsletter> list = null;

		if (retrieveFromCache) {
			list = (List<Newsletter>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Newsletter newsletter : list) {
					if (!Objects.equals(issueDate, newsletter.getIssueDate()) ||
							(isArticle != newsletter.isIsArticle()) ||
							(mostRecent != newsletter.isMostRecent())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_NEWSLETTER_WHERE);

			boolean bindIssueDate = false;

			if (issueDate == null) {
				query.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_1);
			}
			else {
				bindIssueDate = true;

				query.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_2);
			}

			query.append(_FINDER_COLUMN_ISSUEDATE_ISARTICLE_2);

			query.append(_FINDER_COLUMN_ISSUEDATE_MOSTRECENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NewsletterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIssueDate) {
					qPos.add(new Timestamp(issueDate.getTime()));
				}

				qPos.add(isArticle);

				qPos.add(mostRecent);

				if (!pagination) {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first newsletter in the ordered set where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	@Override
	public Newsletter findByIssueDate_First(Date issueDate, boolean isArticle,
		boolean mostRecent, OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByIssueDate_First(issueDate, isArticle,
				mostRecent, orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issueDate=");
		msg.append(issueDate);

		msg.append(", isArticle=");
		msg.append(isArticle);

		msg.append(", mostRecent=");
		msg.append(mostRecent);

		msg.append("}");

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the first newsletter in the ordered set where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	@Override
	public Newsletter fetchByIssueDate_First(Date issueDate, boolean isArticle,
		boolean mostRecent, OrderByComparator<Newsletter> orderByComparator) {
		List<Newsletter> list = findByIssueDate(issueDate, isArticle,
				mostRecent, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last newsletter in the ordered set where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	@Override
	public Newsletter findByIssueDate_Last(Date issueDate, boolean isArticle,
		boolean mostRecent, OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByIssueDate_Last(issueDate, isArticle,
				mostRecent, orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issueDate=");
		msg.append(issueDate);

		msg.append(", isArticle=");
		msg.append(isArticle);

		msg.append(", mostRecent=");
		msg.append(mostRecent);

		msg.append("}");

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the last newsletter in the ordered set where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	@Override
	public Newsletter fetchByIssueDate_Last(Date issueDate, boolean isArticle,
		boolean mostRecent, OrderByComparator<Newsletter> orderByComparator) {
		int count = countByIssueDate(issueDate, isArticle, mostRecent);

		if (count == 0) {
			return null;
		}

		List<Newsletter> list = findByIssueDate(issueDate, isArticle,
				mostRecent, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newsletters before and after the current newsletter in the ordered set where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param newsletterId the primary key of the current newsletter
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter[] findByIssueDate_PrevAndNext(long newsletterId,
		Date issueDate, boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = findByPrimaryKey(newsletterId);

		Session session = null;

		try {
			session = openSession();

			Newsletter[] array = new NewsletterImpl[3];

			array[0] = getByIssueDate_PrevAndNext(session, newsletter,
					issueDate, isArticle, mostRecent, orderByComparator, true);

			array[1] = newsletter;

			array[2] = getByIssueDate_PrevAndNext(session, newsletter,
					issueDate, isArticle, mostRecent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Newsletter getByIssueDate_PrevAndNext(Session session,
		Newsletter newsletter, Date issueDate, boolean isArticle,
		boolean mostRecent, OrderByComparator<Newsletter> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_NEWSLETTER_WHERE);

		boolean bindIssueDate = false;

		if (issueDate == null) {
			query.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_1);
		}
		else {
			bindIssueDate = true;

			query.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_2);
		}

		query.append(_FINDER_COLUMN_ISSUEDATE_ISARTICLE_2);

		query.append(_FINDER_COLUMN_ISSUEDATE_MOSTRECENT_2);

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
			query.append(NewsletterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindIssueDate) {
			qPos.add(new Timestamp(issueDate.getTime()));
		}

		qPos.add(isArticle);

		qPos.add(mostRecent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(newsletter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Newsletter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63; from the database.
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 */
	@Override
	public void removeByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent) {
		for (Newsletter newsletter : findByIssueDate(issueDate, isArticle,
				mostRecent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(newsletter);
		}
	}

	/**
	 * Returns the number of newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueDate the issue date
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @return the number of matching newsletters
	 */
	@Override
	public int countByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISSUEDATE;

		Object[] finderArgs = new Object[] {
				_getTime(issueDate), isArticle, mostRecent
			};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_NEWSLETTER_WHERE);

			boolean bindIssueDate = false;

			if (issueDate == null) {
				query.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_1);
			}
			else {
				bindIssueDate = true;

				query.append(_FINDER_COLUMN_ISSUEDATE_ISSUEDATE_2);
			}

			query.append(_FINDER_COLUMN_ISSUEDATE_ISARTICLE_2);

			query.append(_FINDER_COLUMN_ISSUEDATE_MOSTRECENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIssueDate) {
					qPos.add(new Timestamp(issueDate.getTime()));
				}

				qPos.add(isArticle);

				qPos.add(mostRecent);

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

	private static final String _FINDER_COLUMN_ISSUEDATE_ISSUEDATE_1 = "newsletter.issueDate IS NULL AND ";
	private static final String _FINDER_COLUMN_ISSUEDATE_ISSUEDATE_2 = "newsletter.issueDate = ? AND ";
	private static final String _FINDER_COLUMN_ISSUEDATE_ISARTICLE_2 = "newsletter.isArticle = ? AND ";
	private static final String _FINDER_COLUMN_ISSUEDATE_MOSTRECENT_2 = "newsletter.mostRecent = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUENUMBER =
		new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIssueNumber",
			new String[] {
				Integer.class.getName(), Boolean.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENUMBER =
		new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIssueNumber",
			new String[] {
				Integer.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			},
			NewsletterModelImpl.ISSUENUMBER_COLUMN_BITMASK |
			NewsletterModelImpl.ISARTICLE_COLUMN_BITMASK |
			NewsletterModelImpl.MOSTRECENT_COLUMN_BITMASK |
			NewsletterModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSUENUMBER = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssueNumber",
			new String[] {
				Integer.class.getName(), Boolean.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @return the matching newsletters
	 */
	@Override
	public List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent) {
		return findByIssueNumber(issueNumber, isArticle, mostRecent,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end) {
		return findByIssueNumber(issueNumber, isArticle, mostRecent, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return findByIssueNumber(issueNumber, isArticle, mostRecent, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENUMBER;
			finderArgs = new Object[] { issueNumber, isArticle, mostRecent };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISSUENUMBER;
			finderArgs = new Object[] {
					issueNumber, isArticle, mostRecent,
					
					start, end, orderByComparator
				};
		}

		List<Newsletter> list = null;

		if (retrieveFromCache) {
			list = (List<Newsletter>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Newsletter newsletter : list) {
					if ((issueNumber != newsletter.getIssueNumber()) ||
							(isArticle != newsletter.isIsArticle()) ||
							(mostRecent != newsletter.isMostRecent())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_NEWSLETTER_WHERE);

			query.append(_FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2);

			query.append(_FINDER_COLUMN_ISSUENUMBER_ISARTICLE_2);

			query.append(_FINDER_COLUMN_ISSUENUMBER_MOSTRECENT_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NewsletterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueNumber);

				qPos.add(isArticle);

				qPos.add(mostRecent);

				if (!pagination) {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first newsletter in the ordered set where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	@Override
	public Newsletter findByIssueNumber_First(int issueNumber,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByIssueNumber_First(issueNumber,
				isArticle, mostRecent, orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issueNumber=");
		msg.append(issueNumber);

		msg.append(", isArticle=");
		msg.append(isArticle);

		msg.append(", mostRecent=");
		msg.append(mostRecent);

		msg.append("}");

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the first newsletter in the ordered set where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	@Override
	public Newsletter fetchByIssueNumber_First(int issueNumber,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator) {
		List<Newsletter> list = findByIssueNumber(issueNumber, isArticle,
				mostRecent, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last newsletter in the ordered set where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	@Override
	public Newsletter findByIssueNumber_Last(int issueNumber,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByIssueNumber_Last(issueNumber, isArticle,
				mostRecent, orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("issueNumber=");
		msg.append(issueNumber);

		msg.append(", isArticle=");
		msg.append(isArticle);

		msg.append(", mostRecent=");
		msg.append(mostRecent);

		msg.append("}");

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the last newsletter in the ordered set where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	@Override
	public Newsletter fetchByIssueNumber_Last(int issueNumber,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator) {
		int count = countByIssueNumber(issueNumber, isArticle, mostRecent);

		if (count == 0) {
			return null;
		}

		List<Newsletter> list = findByIssueNumber(issueNumber, isArticle,
				mostRecent, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newsletters before and after the current newsletter in the ordered set where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param newsletterId the primary key of the current newsletter
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter[] findByIssueNumber_PrevAndNext(long newsletterId,
		int issueNumber, boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = findByPrimaryKey(newsletterId);

		Session session = null;

		try {
			session = openSession();

			Newsletter[] array = new NewsletterImpl[3];

			array[0] = getByIssueNumber_PrevAndNext(session, newsletter,
					issueNumber, isArticle, mostRecent, orderByComparator, true);

			array[1] = newsletter;

			array[2] = getByIssueNumber_PrevAndNext(session, newsletter,
					issueNumber, isArticle, mostRecent, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Newsletter getByIssueNumber_PrevAndNext(Session session,
		Newsletter newsletter, int issueNumber, boolean isArticle,
		boolean mostRecent, OrderByComparator<Newsletter> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_NEWSLETTER_WHERE);

		query.append(_FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2);

		query.append(_FINDER_COLUMN_ISSUENUMBER_ISARTICLE_2);

		query.append(_FINDER_COLUMN_ISSUENUMBER_MOSTRECENT_2);

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
			query.append(NewsletterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(issueNumber);

		qPos.add(isArticle);

		qPos.add(mostRecent);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(newsletter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Newsletter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 */
	@Override
	public void removeByIssueNumber(int issueNumber, boolean isArticle,
		boolean mostRecent) {
		for (Newsletter newsletter : findByIssueNumber(issueNumber, isArticle,
				mostRecent, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(newsletter);
		}
	}

	/**
	 * Returns the number of newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @param isArticle the is article
	 * @param mostRecent the most recent
	 * @return the number of matching newsletters
	 */
	@Override
	public int countByIssueNumber(int issueNumber, boolean isArticle,
		boolean mostRecent) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISSUENUMBER;

		Object[] finderArgs = new Object[] { issueNumber, isArticle, mostRecent };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_NEWSLETTER_WHERE);

			query.append(_FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2);

			query.append(_FINDER_COLUMN_ISSUENUMBER_ISARTICLE_2);

			query.append(_FINDER_COLUMN_ISSUENUMBER_MOSTRECENT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueNumber);

				qPos.add(isArticle);

				qPos.add(mostRecent);

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

	private static final String _FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2 = "newsletter.issueNumber = ? AND ";
	private static final String _FINDER_COLUMN_ISSUENUMBER_ISARTICLE_2 = "newsletter.isArticle = ? AND ";
	private static final String _FINDER_COLUMN_ISSUENUMBER_MOSTRECENT_2 = "newsletter.mostRecent = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLEID =
		new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArticleId",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID =
		new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArticleId",
			new String[] { String.class.getName(), Boolean.class.getName() },
			NewsletterModelImpl.ARTICLEID_COLUMN_BITMASK |
			NewsletterModelImpl.ISARTICLE_COLUMN_BITMASK |
			NewsletterModelImpl.ORDER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEID = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArticleId",
			new String[] { String.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the newsletters where articleId = &#63; and isArticle = &#63;.
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @return the matching newsletters
	 */
	@Override
	public List<Newsletter> findByArticleId(String articleId, boolean isArticle) {
		return findByArticleId(articleId, isArticle, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletters where articleId = &#63; and isArticle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end) {
		return findByArticleId(articleId, isArticle, start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletters where articleId = &#63; and isArticle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return findByArticleId(articleId, isArticle, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletters where articleId = &#63; and isArticle = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching newsletters
	 */
	@Override
	public List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID;
			finderArgs = new Object[] { articleId, isArticle };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTICLEID;
			finderArgs = new Object[] {
					articleId, isArticle,
					
					start, end, orderByComparator
				};
		}

		List<Newsletter> list = null;

		if (retrieveFromCache) {
			list = (List<Newsletter>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Newsletter newsletter : list) {
					if (!Objects.equals(articleId, newsletter.getArticleId()) ||
							(isArticle != newsletter.isIsArticle())) {
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

			query.append(_SQL_SELECT_NEWSLETTER_WHERE);

			boolean bindArticleId = false;

			if (articleId == null) {
				query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_1);
			}
			else if (articleId.equals("")) {
				query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_3);
			}
			else {
				bindArticleId = true;

				query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);
			}

			query.append(_FINDER_COLUMN_ARTICLEID_ISARTICLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(NewsletterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArticleId) {
					qPos.add(articleId);
				}

				qPos.add(isArticle);

				if (!pagination) {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	@Override
	public Newsletter findByArticleId_First(String articleId,
		boolean isArticle, OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByArticleId_First(articleId, isArticle,
				orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append(", isArticle=");
		msg.append(isArticle);

		msg.append("}");

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the first newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	@Override
	public Newsletter fetchByArticleId_First(String articleId,
		boolean isArticle, OrderByComparator<Newsletter> orderByComparator) {
		List<Newsletter> list = findByArticleId(articleId, isArticle, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter
	 * @throws NoSuchNewsletterException if a matching newsletter could not be found
	 */
	@Override
	public Newsletter findByArticleId_Last(String articleId, boolean isArticle,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByArticleId_Last(articleId, isArticle,
				orderByComparator);

		if (newsletter != null) {
			return newsletter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("articleId=");
		msg.append(articleId);

		msg.append(", isArticle=");
		msg.append(isArticle);

		msg.append("}");

		throw new NoSuchNewsletterException(msg.toString());
	}

	/**
	 * Returns the last newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	 */
	@Override
	public Newsletter fetchByArticleId_Last(String articleId,
		boolean isArticle, OrderByComparator<Newsletter> orderByComparator) {
		int count = countByArticleId(articleId, isArticle);

		if (count == 0) {
			return null;
		}

		List<Newsletter> list = findByArticleId(articleId, isArticle,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the newsletters before and after the current newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	 *
	 * @param newsletterId the primary key of the current newsletter
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter[] findByArticleId_PrevAndNext(long newsletterId,
		String articleId, boolean isArticle,
		OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException {
		Newsletter newsletter = findByPrimaryKey(newsletterId);

		Session session = null;

		try {
			session = openSession();

			Newsletter[] array = new NewsletterImpl[3];

			array[0] = getByArticleId_PrevAndNext(session, newsletter,
					articleId, isArticle, orderByComparator, true);

			array[1] = newsletter;

			array[2] = getByArticleId_PrevAndNext(session, newsletter,
					articleId, isArticle, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Newsletter getByArticleId_PrevAndNext(Session session,
		Newsletter newsletter, String articleId, boolean isArticle,
		OrderByComparator<Newsletter> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_NEWSLETTER_WHERE);

		boolean bindArticleId = false;

		if (articleId == null) {
			query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_1);
		}
		else if (articleId.equals("")) {
			query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_3);
		}
		else {
			bindArticleId = true;

			query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);
		}

		query.append(_FINDER_COLUMN_ARTICLEID_ISARTICLE_2);

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
			query.append(NewsletterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindArticleId) {
			qPos.add(articleId);
		}

		qPos.add(isArticle);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(newsletter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Newsletter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the newsletters where articleId = &#63; and isArticle = &#63; from the database.
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 */
	@Override
	public void removeByArticleId(String articleId, boolean isArticle) {
		for (Newsletter newsletter : findByArticleId(articleId, isArticle,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(newsletter);
		}
	}

	/**
	 * Returns the number of newsletters where articleId = &#63; and isArticle = &#63;.
	 *
	 * @param articleId the article ID
	 * @param isArticle the is article
	 * @return the number of matching newsletters
	 */
	@Override
	public int countByArticleId(String articleId, boolean isArticle) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTICLEID;

		Object[] finderArgs = new Object[] { articleId, isArticle };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_NEWSLETTER_WHERE);

			boolean bindArticleId = false;

			if (articleId == null) {
				query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_1);
			}
			else if (articleId.equals("")) {
				query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_3);
			}
			else {
				bindArticleId = true;

				query.append(_FINDER_COLUMN_ARTICLEID_ARTICLEID_2);
			}

			query.append(_FINDER_COLUMN_ARTICLEID_ISARTICLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindArticleId) {
					qPos.add(articleId);
				}

				qPos.add(isArticle);

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

	private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_1 = "newsletter.articleId IS NULL AND ";
	private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_2 = "newsletter.articleId = ? AND ";
	private static final String _FINDER_COLUMN_ARTICLEID_ARTICLEID_3 = "(newsletter.articleId IS NULL OR newsletter.articleId = '') AND ";
	private static final String _FINDER_COLUMN_ARTICLEID_ISARTICLE_2 = "newsletter.isArticle = ?";

	public NewsletterPersistenceImpl() {
		setModelClass(Newsletter.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");
			dbColumnNames.put("order", "order_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the newsletter in the entity cache if it is enabled.
	 *
	 * @param newsletter the newsletter
	 */
	@Override
	public void cacheResult(Newsletter newsletter) {
		entityCache.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterImpl.class, newsletter.getPrimaryKey(), newsletter);

		newsletter.resetOriginalValues();
	}

	/**
	 * Caches the newsletters in the entity cache if it is enabled.
	 *
	 * @param newsletters the newsletters
	 */
	@Override
	public void cacheResult(List<Newsletter> newsletters) {
		for (Newsletter newsletter : newsletters) {
			if (entityCache.getResult(
						NewsletterModelImpl.ENTITY_CACHE_ENABLED,
						NewsletterImpl.class, newsletter.getPrimaryKey()) == null) {
				cacheResult(newsletter);
			}
			else {
				newsletter.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all newsletters.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NewsletterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the newsletter.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Newsletter newsletter) {
		entityCache.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterImpl.class, newsletter.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Newsletter> newsletters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Newsletter newsletter : newsletters) {
			entityCache.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
				NewsletterImpl.class, newsletter.getPrimaryKey());
		}
	}

	/**
	 * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	 *
	 * @param newsletterId the primary key for the new newsletter
	 * @return the new newsletter
	 */
	@Override
	public Newsletter create(long newsletterId) {
		Newsletter newsletter = new NewsletterImpl();

		newsletter.setNew(true);
		newsletter.setPrimaryKey(newsletterId);

		String uuid = PortalUUIDUtil.generate();

		newsletter.setUuid(uuid);

		return newsletter;
	}

	/**
	 * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterId the primary key of the newsletter
	 * @return the newsletter that was removed
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter remove(long newsletterId)
		throws NoSuchNewsletterException {
		return remove((Serializable)newsletterId);
	}

	/**
	 * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the newsletter
	 * @return the newsletter that was removed
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter remove(Serializable primaryKey)
		throws NoSuchNewsletterException {
		Session session = null;

		try {
			session = openSession();

			Newsletter newsletter = (Newsletter)session.get(NewsletterImpl.class,
					primaryKey);

			if (newsletter == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNewsletterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(newsletter);
		}
		catch (NoSuchNewsletterException nsee) {
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
	protected Newsletter removeImpl(Newsletter newsletter) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(newsletter)) {
				newsletter = (Newsletter)session.get(NewsletterImpl.class,
						newsletter.getPrimaryKeyObj());
			}

			if (newsletter != null) {
				session.delete(newsletter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (newsletter != null) {
			clearCache(newsletter);
		}

		return newsletter;
	}

	@Override
	public Newsletter updateImpl(Newsletter newsletter) {
		boolean isNew = newsletter.isNew();

		if (!(newsletter instanceof NewsletterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(newsletter.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(newsletter);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in newsletter proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Newsletter implementation " +
				newsletter.getClass());
		}

		NewsletterModelImpl newsletterModelImpl = (NewsletterModelImpl)newsletter;

		if (Validator.isNull(newsletter.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			newsletter.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (newsletter.isNew()) {
				session.save(newsletter);

				newsletter.setNew(false);
			}
			else {
				newsletter = (Newsletter)session.merge(newsletter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!NewsletterModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { newsletterModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					newsletterModelImpl.getIssueDate(),
					newsletterModelImpl.isIsArticle(),
					newsletterModelImpl.isMostRecent()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUEDATE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEDATE,
				args);

			args = new Object[] {
					newsletterModelImpl.getIssueNumber(),
					newsletterModelImpl.isIsArticle(),
					newsletterModelImpl.isMostRecent()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUENUMBER, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENUMBER,
				args);

			args = new Object[] {
					newsletterModelImpl.getArticleId(),
					newsletterModelImpl.isIsArticle()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((newsletterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newsletterModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { newsletterModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((newsletterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newsletterModelImpl.getOriginalIssueDate(),
						newsletterModelImpl.getOriginalIsArticle(),
						newsletterModelImpl.getOriginalMostRecent()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUEDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEDATE,
					args);

				args = new Object[] {
						newsletterModelImpl.getIssueDate(),
						newsletterModelImpl.isIsArticle(),
						newsletterModelImpl.isMostRecent()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUEDATE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUEDATE,
					args);
			}

			if ((newsletterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newsletterModelImpl.getOriginalIssueNumber(),
						newsletterModelImpl.getOriginalIsArticle(),
						newsletterModelImpl.getOriginalMostRecent()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUENUMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENUMBER,
					args);

				args = new Object[] {
						newsletterModelImpl.getIssueNumber(),
						newsletterModelImpl.isIsArticle(),
						newsletterModelImpl.isMostRecent()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUENUMBER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISSUENUMBER,
					args);
			}

			if ((newsletterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						newsletterModelImpl.getOriginalArticleId(),
						newsletterModelImpl.getOriginalIsArticle()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID,
					args);

				args = new Object[] {
						newsletterModelImpl.getArticleId(),
						newsletterModelImpl.isIsArticle()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ARTICLEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTICLEID,
					args);
			}
		}

		entityCache.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
			NewsletterImpl.class, newsletter.getPrimaryKey(), newsletter, false);

		newsletter.resetOriginalValues();

		return newsletter;
	}

	/**
	 * Returns the newsletter with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the newsletter
	 * @return the newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNewsletterException {
		Newsletter newsletter = fetchByPrimaryKey(primaryKey);

		if (newsletter == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNewsletterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return newsletter;
	}

	/**
	 * Returns the newsletter with the primary key or throws a {@link NoSuchNewsletterException} if it could not be found.
	 *
	 * @param newsletterId the primary key of the newsletter
	 * @return the newsletter
	 * @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter findByPrimaryKey(long newsletterId)
		throws NoSuchNewsletterException {
		return findByPrimaryKey((Serializable)newsletterId);
	}

	/**
	 * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the newsletter
	 * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
				NewsletterImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Newsletter newsletter = (Newsletter)serializable;

		if (newsletter == null) {
			Session session = null;

			try {
				session = openSession();

				newsletter = (Newsletter)session.get(NewsletterImpl.class,
						primaryKey);

				if (newsletter != null) {
					cacheResult(newsletter);
				}
				else {
					entityCache.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
						NewsletterImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
					NewsletterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return newsletter;
	}

	/**
	 * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param newsletterId the primary key of the newsletter
	 * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	 */
	@Override
	public Newsletter fetchByPrimaryKey(long newsletterId) {
		return fetchByPrimaryKey((Serializable)newsletterId);
	}

	@Override
	public Map<Serializable, Newsletter> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Newsletter> map = new HashMap<Serializable, Newsletter>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Newsletter newsletter = fetchByPrimaryKey(primaryKey);

			if (newsletter != null) {
				map.put(primaryKey, newsletter);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
					NewsletterImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Newsletter)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_NEWSLETTER_WHERE_PKS_IN);

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

			for (Newsletter newsletter : (List<Newsletter>)q.list()) {
				map.put(newsletter.getPrimaryKeyObj(), newsletter);

				cacheResult(newsletter);

				uncachedPrimaryKeys.remove(newsletter.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
					NewsletterImpl.class, primaryKey, nullModel);
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
	 * Returns all the newsletters.
	 *
	 * @return the newsletters
	 */
	@Override
	public List<Newsletter> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of newsletters
	 */
	@Override
	public List<Newsletter> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of newsletters
	 */
	@Override
	public List<Newsletter> findAll(int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of newsletters
	 */
	@Override
	public List<Newsletter> findAll(int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
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

		List<Newsletter> list = null;

		if (retrieveFromCache) {
			list = (List<Newsletter>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_NEWSLETTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_NEWSLETTER;

				if (pagination) {
					sql = sql.concat(NewsletterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Newsletter>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the newsletters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Newsletter newsletter : findAll()) {
			remove(newsletter);
		}
	}

	/**
	 * Returns the number of newsletters.
	 *
	 * @return the number of newsletters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_NEWSLETTER);

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
		return NewsletterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the newsletter persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(NewsletterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_NEWSLETTER = "SELECT newsletter FROM Newsletter newsletter";
	private static final String _SQL_SELECT_NEWSLETTER_WHERE_PKS_IN = "SELECT newsletter FROM Newsletter newsletter WHERE newsletterId IN (";
	private static final String _SQL_SELECT_NEWSLETTER_WHERE = "SELECT newsletter FROM Newsletter newsletter WHERE ";
	private static final String _SQL_COUNT_NEWSLETTER = "SELECT COUNT(newsletter) FROM Newsletter newsletter";
	private static final String _SQL_COUNT_NEWSLETTER_WHERE = "SELECT COUNT(newsletter) FROM Newsletter newsletter WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "newsletter.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Newsletter exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Newsletter exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(NewsletterPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid", "order"
			});
}