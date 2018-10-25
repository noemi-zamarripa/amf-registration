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

package com.liferay.training.amf.newsletter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.amf.newsletter.model.Newsletter;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the newsletter service. This utility wraps {@link com.liferay.training.amf.newsletter.service.persistence.impl.NewsletterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterPersistence
 * @see com.liferay.training.amf.newsletter.service.persistence.impl.NewsletterPersistenceImpl
 * @generated
 */
@ProviderType
public class NewsletterUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Newsletter newsletter) {
		getPersistence().clearCache(newsletter);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Newsletter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Newsletter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Newsletter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Newsletter update(Newsletter newsletter) {
		return getPersistence().update(newsletter);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Newsletter update(Newsletter newsletter,
		ServiceContext serviceContext) {
		return getPersistence().update(newsletter, serviceContext);
	}

	/**
	* Returns all the newsletters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching newsletters
	*/
	public static List<Newsletter> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Newsletter> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Newsletter> findByUuid(String uuid, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Newsletter> findByUuid(String uuid, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first newsletter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter
	* @throws NoSuchNewsletterException if a matching newsletter could not be found
	*/
	public static Newsletter findByUuid_First(String uuid,
		OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first newsletter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public static Newsletter fetchByUuid_First(String uuid,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last newsletter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter
	* @throws NoSuchNewsletterException if a matching newsletter could not be found
	*/
	public static Newsletter findByUuid_Last(String uuid,
		OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last newsletter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public static Newsletter fetchByUuid_Last(String uuid,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Newsletter[] findByUuid_PrevAndNext(long newsletterId,
		String uuid, OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByUuid_PrevAndNext(newsletterId, uuid, orderByComparator);
	}

	/**
	* Removes all the newsletters where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of newsletters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching newsletters
	*/
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueDate the issue date
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @return the matching newsletters
	*/
	public static List<Newsletter> findByIssueDate(Date issueDate,
		boolean isArticle, boolean mostRecent) {
		return getPersistence().findByIssueDate(issueDate, isArticle, mostRecent);
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
	public static List<Newsletter> findByIssueDate(Date issueDate,
		boolean isArticle, boolean mostRecent, int start, int end) {
		return getPersistence()
				   .findByIssueDate(issueDate, isArticle, mostRecent, start, end);
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
	public static List<Newsletter> findByIssueDate(Date issueDate,
		boolean isArticle, boolean mostRecent, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .findByIssueDate(issueDate, isArticle, mostRecent, start,
			end, orderByComparator);
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
	public static List<Newsletter> findByIssueDate(Date issueDate,
		boolean isArticle, boolean mostRecent, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIssueDate(issueDate, isArticle, mostRecent, start,
			end, orderByComparator, retrieveFromCache);
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
	public static Newsletter findByIssueDate_First(Date issueDate,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByIssueDate_First(issueDate, isArticle, mostRecent,
			orderByComparator);
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
	public static Newsletter fetchByIssueDate_First(Date issueDate,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .fetchByIssueDate_First(issueDate, isArticle, mostRecent,
			orderByComparator);
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
	public static Newsletter findByIssueDate_Last(Date issueDate,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByIssueDate_Last(issueDate, isArticle, mostRecent,
			orderByComparator);
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
	public static Newsletter fetchByIssueDate_Last(Date issueDate,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .fetchByIssueDate_Last(issueDate, isArticle, mostRecent,
			orderByComparator);
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
	public static Newsletter[] findByIssueDate_PrevAndNext(long newsletterId,
		Date issueDate, boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByIssueDate_PrevAndNext(newsletterId, issueDate,
			isArticle, mostRecent, orderByComparator);
	}

	/**
	* Removes all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63; from the database.
	*
	* @param issueDate the issue date
	* @param isArticle the is article
	* @param mostRecent the most recent
	*/
	public static void removeByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent) {
		getPersistence().removeByIssueDate(issueDate, isArticle, mostRecent);
	}

	/**
	* Returns the number of newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueDate the issue date
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @return the number of matching newsletters
	*/
	public static int countByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent) {
		return getPersistence()
				   .countByIssueDate(issueDate, isArticle, mostRecent);
	}

	/**
	* Returns all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueNumber the issue number
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @return the matching newsletters
	*/
	public static List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent) {
		return getPersistence()
				   .findByIssueNumber(issueNumber, isArticle, mostRecent);
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
	public static List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end) {
		return getPersistence()
				   .findByIssueNumber(issueNumber, isArticle, mostRecent,
			start, end);
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
	public static List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .findByIssueNumber(issueNumber, isArticle, mostRecent,
			start, end, orderByComparator);
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
	public static List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByIssueNumber(issueNumber, isArticle, mostRecent,
			start, end, orderByComparator, retrieveFromCache);
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
	public static Newsletter findByIssueNumber_First(int issueNumber,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByIssueNumber_First(issueNumber, isArticle, mostRecent,
			orderByComparator);
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
	public static Newsletter fetchByIssueNumber_First(int issueNumber,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .fetchByIssueNumber_First(issueNumber, isArticle,
			mostRecent, orderByComparator);
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
	public static Newsletter findByIssueNumber_Last(int issueNumber,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByIssueNumber_Last(issueNumber, isArticle, mostRecent,
			orderByComparator);
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
	public static Newsletter fetchByIssueNumber_Last(int issueNumber,
		boolean isArticle, boolean mostRecent,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .fetchByIssueNumber_Last(issueNumber, isArticle, mostRecent,
			orderByComparator);
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
	public static Newsletter[] findByIssueNumber_PrevAndNext(
		long newsletterId, int issueNumber, boolean isArticle,
		boolean mostRecent, OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByIssueNumber_PrevAndNext(newsletterId, issueNumber,
			isArticle, mostRecent, orderByComparator);
	}

	/**
	* Removes all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63; from the database.
	*
	* @param issueNumber the issue number
	* @param isArticle the is article
	* @param mostRecent the most recent
	*/
	public static void removeByIssueNumber(int issueNumber, boolean isArticle,
		boolean mostRecent) {
		getPersistence().removeByIssueNumber(issueNumber, isArticle, mostRecent);
	}

	/**
	* Returns the number of newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueNumber the issue number
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @return the number of matching newsletters
	*/
	public static int countByIssueNumber(int issueNumber, boolean isArticle,
		boolean mostRecent) {
		return getPersistence()
				   .countByIssueNumber(issueNumber, isArticle, mostRecent);
	}

	/**
	* Returns all the newsletters where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @return the matching newsletters
	*/
	public static List<Newsletter> findByArticleId(String articleId,
		boolean isArticle) {
		return getPersistence().findByArticleId(articleId, isArticle);
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
	public static List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end) {
		return getPersistence().findByArticleId(articleId, isArticle, start, end);
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
	public static List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .findByArticleId(articleId, isArticle, start, end,
			orderByComparator);
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
	public static List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByArticleId(articleId, isArticle, start, end,
			orderByComparator, retrieveFromCache);
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
	public static Newsletter findByArticleId_First(String articleId,
		boolean isArticle, OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByArticleId_First(articleId, isArticle,
			orderByComparator);
	}

	/**
	* Returns the first newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public static Newsletter fetchByArticleId_First(String articleId,
		boolean isArticle, OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .fetchByArticleId_First(articleId, isArticle,
			orderByComparator);
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
	public static Newsletter findByArticleId_Last(String articleId,
		boolean isArticle, OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByArticleId_Last(articleId, isArticle, orderByComparator);
	}

	/**
	* Returns the last newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public static Newsletter fetchByArticleId_Last(String articleId,
		boolean isArticle, OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence()
				   .fetchByArticleId_Last(articleId, isArticle,
			orderByComparator);
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
	public static Newsletter[] findByArticleId_PrevAndNext(long newsletterId,
		String articleId, boolean isArticle,
		OrderByComparator<Newsletter> orderByComparator)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence()
				   .findByArticleId_PrevAndNext(newsletterId, articleId,
			isArticle, orderByComparator);
	}

	/**
	* Removes all the newsletters where articleId = &#63; and isArticle = &#63; from the database.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	*/
	public static void removeByArticleId(String articleId, boolean isArticle) {
		getPersistence().removeByArticleId(articleId, isArticle);
	}

	/**
	* Returns the number of newsletters where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @return the number of matching newsletters
	*/
	public static int countByArticleId(String articleId, boolean isArticle) {
		return getPersistence().countByArticleId(articleId, isArticle);
	}

	/**
	* Caches the newsletter in the entity cache if it is enabled.
	*
	* @param newsletter the newsletter
	*/
	public static void cacheResult(Newsletter newsletter) {
		getPersistence().cacheResult(newsletter);
	}

	/**
	* Caches the newsletters in the entity cache if it is enabled.
	*
	* @param newsletters the newsletters
	*/
	public static void cacheResult(List<Newsletter> newsletters) {
		getPersistence().cacheResult(newsletters);
	}

	/**
	* Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	*
	* @param newsletterId the primary key for the new newsletter
	* @return the new newsletter
	*/
	public static Newsletter create(long newsletterId) {
		return getPersistence().create(newsletterId);
	}

	/**
	* Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter that was removed
	* @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	*/
	public static Newsletter remove(long newsletterId)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence().remove(newsletterId);
	}

	public static Newsletter updateImpl(Newsletter newsletter) {
		return getPersistence().updateImpl(newsletter);
	}

	/**
	* Returns the newsletter with the primary key or throws a {@link NoSuchNewsletterException} if it could not be found.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter
	* @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	*/
	public static Newsletter findByPrimaryKey(long newsletterId)
		throws com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException {
		return getPersistence().findByPrimaryKey(newsletterId);
	}

	/**
	* Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	*/
	public static Newsletter fetchByPrimaryKey(long newsletterId) {
		return getPersistence().fetchByPrimaryKey(newsletterId);
	}

	public static java.util.Map<java.io.Serializable, Newsletter> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the newsletters.
	*
	* @return the newsletters
	*/
	public static List<Newsletter> findAll() {
		return getPersistence().findAll();
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
	public static List<Newsletter> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Newsletter> findAll(int start, int end,
		OrderByComparator<Newsletter> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Newsletter> findAll(int start, int end,
		OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the newsletters from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of newsletters.
	*
	* @return the number of newsletters
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static NewsletterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NewsletterPersistence, NewsletterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NewsletterPersistence.class);

		ServiceTracker<NewsletterPersistence, NewsletterPersistence> serviceTracker =
			new ServiceTracker<NewsletterPersistence, NewsletterPersistence>(bundle.getBundleContext(),
				NewsletterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}