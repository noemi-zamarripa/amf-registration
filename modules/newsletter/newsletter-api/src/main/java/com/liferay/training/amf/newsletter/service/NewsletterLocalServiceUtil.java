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

package com.liferay.training.amf.newsletter.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Newsletter. This utility wraps
 * {@link com.liferay.training.amf.newsletter.service.impl.NewsletterLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterLocalService
 * @see com.liferay.training.amf.newsletter.service.base.NewsletterLocalServiceBaseImpl
 * @see com.liferay.training.amf.newsletter.service.impl.NewsletterLocalServiceImpl
 * @generated
 */
@ProviderType
public class NewsletterLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.newsletter.service.impl.NewsletterLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the newsletter to the database. Also notifies the appropriate model listeners.
	*
	* @param newsletter the newsletter
	* @return the newsletter that was added
	*/
	public static com.liferay.training.amf.newsletter.model.Newsletter addNewsletter(
		com.liferay.training.amf.newsletter.model.Newsletter newsletter) {
		return getService().addNewsletter(newsletter);
	}

	public static int convertMonthToInteger(String month) {
		return getService().convertMonthToInteger(month);
	}

	public static String convertMonthToString(int month) {
		return getService().convertMonthToString(month);
	}

	/**
	* Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	*
	* @param newsletterId the primary key for the new newsletter
	* @return the new newsletter
	*/
	public static com.liferay.training.amf.newsletter.model.Newsletter createNewsletter(
		long newsletterId) {
		return getService().createNewsletter(newsletterId);
	}

	/**
	* Deletes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter that was removed
	* @throws PortalException if a newsletter with the primary key could not be found
	*/
	public static com.liferay.training.amf.newsletter.model.Newsletter deleteNewsletter(
		long newsletterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteNewsletter(newsletterId);
	}

	/**
	* Deletes the newsletter from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletter the newsletter
	* @return the newsletter that was removed
	*/
	public static com.liferay.training.amf.newsletter.model.Newsletter deleteNewsletter(
		com.liferay.training.amf.newsletter.model.Newsletter newsletter) {
		return getService().deleteNewsletter(newsletter);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.training.amf.newsletter.model.Newsletter fetchNewsletter(
		long newsletterId) {
		return getService().fetchNewsletter(newsletterId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> filterSearchResults(
		java.util.List<com.liferay.portal.kernel.search.Document> hits,
		com.liferay.portal.kernel.search.SearchContext context)
		throws com.liferay.portal.kernel.search.SearchException {
		return getService().filterSearchResults(hits, context);
	}

	public static java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> findByIssueNumber(
		int issueNumber) {
		return getService().findByIssueNumber(issueNumber);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static String getAuthor(com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return getService().getAuthor(ja);
	}

	public static String getByline(
		java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> news)
		throws com.liferay.portal.kernel.xml.DocumentException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService().getByline(news);
	}

	public static String getContent(com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return getService().getContent(ja);
	}

	public static String getDescription(
		com.liferay.journal.model.JournalArticle ja) {
		return getService().getDescription(ja);
	}

	public static String getFormattedDate(java.util.Date d) {
		return getService().getFormattedDate(d);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> getIssue(
		String month, String year) {
		return getService().getIssue(month, year);
	}

	public static java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> getIssueArticles(
		com.liferay.training.amf.newsletter.model.Newsletter news) {
		return getService().getIssueArticles(news);
	}

	public static java.sql.Date getIssueDate(
		com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return getService().getIssueDate(ja);
	}

	public static int getIssueNumber(
		com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return getService().getIssueNumber(ja);
	}

	public static com.liferay.journal.model.JournalArticle getJournalArticle(
		long id) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getJournalArticle(id);
	}

	public static java.util.List<com.liferay.journal.model.JournalArticle> getJournalArticles(
		java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> news)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getJournalArticles(news);
	}

	public static java.util.List<String> getMonthsWithIssues(int issueYear) {
		return getService().getMonthsWithIssues(issueYear);
	}

	/**
	* Returns the newsletter with the primary key.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter
	* @throws PortalException if a newsletter with the primary key could not be found
	*/
	public static com.liferay.training.amf.newsletter.model.Newsletter getNewsletter(
		long newsletterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getNewsletter(newsletterId);
	}

	/**
	* Returns a range of all the newsletters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.newsletter.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of newsletters
	* @param end the upper bound of the range of newsletters (not inclusive)
	* @return the range of newsletters
	*/
	public static java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> getNewsletters(
		int start, int end) {
		return getService().getNewsletters(start, end);
	}

	/**
	* Returns the number of newsletters.
	*
	* @return the number of newsletters
	*/
	public static int getNewslettersCount() {
		return getService().getNewslettersCount();
	}

	public static int getOrder(com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return getService().getOrder(ja);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static String getTabs(java.util.List<Integer> years)
		throws com.liferay.portal.kernel.xml.DocumentException,
			com.liferay.portal.kernel.exception.PortalException {
		return getService().getTabs(years);
	}

	public static String getTitle(com.liferay.journal.model.JournalArticle ja) {
		return getService().getTitle(ja);
	}

	public static java.util.List<Integer> getYearsWithIssues() {
		return getService().getYearsWithIssues();
	}

	public static void markAsPastVersion(
		java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> news) {
		getService().markAsPastVersion(news);
	}

	public static java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> matchToNewsletter(
		java.util.List<com.liferay.portal.kernel.search.Document> hits,
		int start, int end) {
		return getService().matchToNewsletter(hits, start, end);
	}

	public static long parseNewsletterId(String uid) {
		return getService().parseNewsletterId(uid);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> search(
		String title, String description, String content, String author,
		String keyword, com.liferay.portal.kernel.search.SearchContext context)
		throws com.liferay.portal.kernel.search.SearchException {
		return getService()
				   .search(title, description, content, author, keyword, context);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchForNewsletters(
		String field, int issueNumber,
		com.liferay.portal.kernel.search.SearchContext context)
		throws com.liferay.portal.kernel.search.SearchException {
		return getService().searchForNewsletters(field, issueNumber, context);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchOnField(
		String field, String keyword,
		com.liferay.portal.kernel.search.SearchContext context)
		throws com.liferay.portal.kernel.search.SearchException {
		return getService().searchOnField(field, keyword, context);
	}

	public static com.liferay.portal.kernel.dao.search.SearchContainer setSearchContainer(
		javax.portlet.RenderRequest renderRequest,
		javax.portlet.RenderResponse renderResponse,
		java.util.List<com.liferay.portal.kernel.search.Document> hits) {
		return getService()
				   .setSearchContainer(renderRequest, renderResponse, hits);
	}

	/**
	* Updates the newsletter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newsletter the newsletter
	* @return the newsletter that was updated
	*/
	public static com.liferay.training.amf.newsletter.model.Newsletter updateNewsletter(
		com.liferay.training.amf.newsletter.model.Newsletter newsletter) {
		return getService().updateNewsletter(newsletter);
	}

	public static void updateVersion(String articleId, boolean isArticle) {
		getService().updateVersion(articleId, isArticle);
	}

	public static NewsletterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<NewsletterLocalService, NewsletterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(NewsletterLocalService.class);

		ServiceTracker<NewsletterLocalService, NewsletterLocalService> serviceTracker =
			new ServiceTracker<NewsletterLocalService, NewsletterLocalService>(bundle.getBundleContext(),
				NewsletterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}