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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.training.amf.newsletter.exception.NoSuchNewsletterException;
import com.liferay.training.amf.newsletter.model.Newsletter;

import java.util.Date;

/**
 * The persistence interface for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.newsletter.service.persistence.impl.NewsletterPersistenceImpl
 * @see NewsletterUtil
 * @generated
 */
@ProviderType
public interface NewsletterPersistence extends BasePersistence<Newsletter> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the newsletters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching newsletters
	*/
	public java.util.List<Newsletter> findByUuid(String uuid);

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
	public java.util.List<Newsletter> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Newsletter> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public java.util.List<Newsletter> findByUuid(String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first newsletter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter
	* @throws NoSuchNewsletterException if a matching newsletter could not be found
	*/
	public Newsletter findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Returns the first newsletter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public Newsletter fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

	/**
	* Returns the last newsletter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter
	* @throws NoSuchNewsletterException if a matching newsletter could not be found
	*/
	public Newsletter findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Returns the last newsletter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public Newsletter fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

	/**
	* Returns the newsletters before and after the current newsletter in the ordered set where uuid = &#63;.
	*
	* @param newsletterId the primary key of the current newsletter
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next newsletter
	* @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	*/
	public Newsletter[] findByUuid_PrevAndNext(long newsletterId, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Removes all the newsletters where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of newsletters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching newsletters
	*/
	public int countByUuid(String uuid);

	/**
	* Returns all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueDate the issue date
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @return the matching newsletters
	*/
	public java.util.List<Newsletter> findByIssueDate(Date issueDate,
		boolean isArticle, boolean mostRecent);

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
	public java.util.List<Newsletter> findByIssueDate(Date issueDate,
		boolean isArticle, boolean mostRecent, int start, int end);

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
	public java.util.List<Newsletter> findByIssueDate(Date issueDate,
		boolean isArticle, boolean mostRecent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public java.util.List<Newsletter> findByIssueDate(Date issueDate,
		boolean isArticle, boolean mostRecent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache);

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
	public Newsletter findByIssueDate_First(Date issueDate, boolean isArticle,
		boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Returns the first newsletter in the ordered set where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueDate the issue date
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public Newsletter fetchByIssueDate_First(Date issueDate, boolean isArticle,
		boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public Newsletter findByIssueDate_Last(Date issueDate, boolean isArticle,
		boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Returns the last newsletter in the ordered set where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueDate the issue date
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public Newsletter fetchByIssueDate_Last(Date issueDate, boolean isArticle,
		boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public Newsletter[] findByIssueDate_PrevAndNext(long newsletterId,
		Date issueDate, boolean isArticle, boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Removes all the newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63; from the database.
	*
	* @param issueDate the issue date
	* @param isArticle the is article
	* @param mostRecent the most recent
	*/
	public void removeByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent);

	/**
	* Returns the number of newsletters where issueDate = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueDate the issue date
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @return the number of matching newsletters
	*/
	public int countByIssueDate(Date issueDate, boolean isArticle,
		boolean mostRecent);

	/**
	* Returns all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueNumber the issue number
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @return the matching newsletters
	*/
	public java.util.List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent);

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
	public java.util.List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end);

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
	public java.util.List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public java.util.List<Newsletter> findByIssueNumber(int issueNumber,
		boolean isArticle, boolean mostRecent, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache);

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
	public Newsletter findByIssueNumber_First(int issueNumber,
		boolean isArticle, boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Returns the first newsletter in the ordered set where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueNumber the issue number
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public Newsletter fetchByIssueNumber_First(int issueNumber,
		boolean isArticle, boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public Newsletter findByIssueNumber_Last(int issueNumber,
		boolean isArticle, boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Returns the last newsletter in the ordered set where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueNumber the issue number
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public Newsletter fetchByIssueNumber_Last(int issueNumber,
		boolean isArticle, boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public Newsletter[] findByIssueNumber_PrevAndNext(long newsletterId,
		int issueNumber, boolean isArticle, boolean mostRecent,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Removes all the newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63; from the database.
	*
	* @param issueNumber the issue number
	* @param isArticle the is article
	* @param mostRecent the most recent
	*/
	public void removeByIssueNumber(int issueNumber, boolean isArticle,
		boolean mostRecent);

	/**
	* Returns the number of newsletters where issueNumber = &#63; and isArticle = &#63; and mostRecent = &#63;.
	*
	* @param issueNumber the issue number
	* @param isArticle the is article
	* @param mostRecent the most recent
	* @return the number of matching newsletters
	*/
	public int countByIssueNumber(int issueNumber, boolean isArticle,
		boolean mostRecent);

	/**
	* Returns all the newsletters where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @return the matching newsletters
	*/
	public java.util.List<Newsletter> findByArticleId(String articleId,
		boolean isArticle);

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
	public java.util.List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end);

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
	public java.util.List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public java.util.List<Newsletter> findByArticleId(String articleId,
		boolean isArticle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter
	* @throws NoSuchNewsletterException if a matching newsletter could not be found
	*/
	public Newsletter findByArticleId_First(String articleId,
		boolean isArticle,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Returns the first newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public Newsletter fetchByArticleId_First(String articleId,
		boolean isArticle,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

	/**
	* Returns the last newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter
	* @throws NoSuchNewsletterException if a matching newsletter could not be found
	*/
	public Newsletter findByArticleId_Last(String articleId, boolean isArticle,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Returns the last newsletter in the ordered set where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
	*/
	public Newsletter fetchByArticleId_Last(String articleId,
		boolean isArticle,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public Newsletter[] findByArticleId_PrevAndNext(long newsletterId,
		String articleId, boolean isArticle,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator)
		throws NoSuchNewsletterException;

	/**
	* Removes all the newsletters where articleId = &#63; and isArticle = &#63; from the database.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	*/
	public void removeByArticleId(String articleId, boolean isArticle);

	/**
	* Returns the number of newsletters where articleId = &#63; and isArticle = &#63;.
	*
	* @param articleId the article ID
	* @param isArticle the is article
	* @return the number of matching newsletters
	*/
	public int countByArticleId(String articleId, boolean isArticle);

	/**
	* Caches the newsletter in the entity cache if it is enabled.
	*
	* @param newsletter the newsletter
	*/
	public void cacheResult(Newsletter newsletter);

	/**
	* Caches the newsletters in the entity cache if it is enabled.
	*
	* @param newsletters the newsletters
	*/
	public void cacheResult(java.util.List<Newsletter> newsletters);

	/**
	* Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	*
	* @param newsletterId the primary key for the new newsletter
	* @return the new newsletter
	*/
	public Newsletter create(long newsletterId);

	/**
	* Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter that was removed
	* @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	*/
	public Newsletter remove(long newsletterId)
		throws NoSuchNewsletterException;

	public Newsletter updateImpl(Newsletter newsletter);

	/**
	* Returns the newsletter with the primary key or throws a {@link NoSuchNewsletterException} if it could not be found.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter
	* @throws NoSuchNewsletterException if a newsletter with the primary key could not be found
	*/
	public Newsletter findByPrimaryKey(long newsletterId)
		throws NoSuchNewsletterException;

	/**
	* Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
	*/
	public Newsletter fetchByPrimaryKey(long newsletterId);

	@Override
	public java.util.Map<java.io.Serializable, Newsletter> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the newsletters.
	*
	* @return the newsletters
	*/
	public java.util.List<Newsletter> findAll();

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
	public java.util.List<Newsletter> findAll(int start, int end);

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
	public java.util.List<Newsletter> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator);

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
	public java.util.List<Newsletter> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Newsletter> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the newsletters from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of newsletters.
	*
	* @return the number of newsletters
	*/
	public int countAll();

	@Override
	public java.util.Set<String> getBadColumnNames();
}