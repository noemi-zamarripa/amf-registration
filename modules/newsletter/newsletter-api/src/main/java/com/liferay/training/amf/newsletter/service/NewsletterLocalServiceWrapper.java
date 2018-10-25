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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NewsletterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterLocalService
 * @generated
 */
@ProviderType
public class NewsletterLocalServiceWrapper implements NewsletterLocalService,
	ServiceWrapper<NewsletterLocalService> {
	public NewsletterLocalServiceWrapper(
		NewsletterLocalService newsletterLocalService) {
		_newsletterLocalService = newsletterLocalService;
	}

	/**
	* Adds the newsletter to the database. Also notifies the appropriate model listeners.
	*
	* @param newsletter the newsletter
	* @return the newsletter that was added
	*/
	@Override
	public com.liferay.training.amf.newsletter.model.Newsletter addNewsletter(
		com.liferay.training.amf.newsletter.model.Newsletter newsletter) {
		return _newsletterLocalService.addNewsletter(newsletter);
	}

	@Override
	public int convertMonthToInteger(String month) {
		return _newsletterLocalService.convertMonthToInteger(month);
	}

	@Override
	public String convertMonthToString(int month) {
		return _newsletterLocalService.convertMonthToString(month);
	}

	/**
	* Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	*
	* @param newsletterId the primary key for the new newsletter
	* @return the new newsletter
	*/
	@Override
	public com.liferay.training.amf.newsletter.model.Newsletter createNewsletter(
		long newsletterId) {
		return _newsletterLocalService.createNewsletter(newsletterId);
	}

	/**
	* Deletes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter that was removed
	* @throws PortalException if a newsletter with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.newsletter.model.Newsletter deleteNewsletter(
		long newsletterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsletterLocalService.deleteNewsletter(newsletterId);
	}

	/**
	* Deletes the newsletter from the database. Also notifies the appropriate model listeners.
	*
	* @param newsletter the newsletter
	* @return the newsletter that was removed
	*/
	@Override
	public com.liferay.training.amf.newsletter.model.Newsletter deleteNewsletter(
		com.liferay.training.amf.newsletter.model.Newsletter newsletter) {
		return _newsletterLocalService.deleteNewsletter(newsletter);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsletterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _newsletterLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _newsletterLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _newsletterLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _newsletterLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _newsletterLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _newsletterLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.training.amf.newsletter.model.Newsletter fetchNewsletter(
		long newsletterId) {
		return _newsletterLocalService.fetchNewsletter(newsletterId);
	}

	@Override
	public java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> findByIssueNumber(
		int issueNumber) {
		return _newsletterLocalService.findByIssueNumber(issueNumber);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _newsletterLocalService.getActionableDynamicQuery();
	}

	@Override
	public String getAuthor(com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return _newsletterLocalService.getAuthor(ja);
	}

	@Override
	public String getByline(
		java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> news)
		throws com.liferay.portal.kernel.xml.DocumentException,
			com.liferay.portal.kernel.exception.PortalException {
		return _newsletterLocalService.getByline(news);
	}

	@Override
	public String getContent(com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return _newsletterLocalService.getContent(ja);
	}

	@Override
	public String getDescription(com.liferay.journal.model.JournalArticle ja) {
		return _newsletterLocalService.getDescription(ja);
	}

	@Override
	public String getFormattedDate(java.util.Date d) {
		return _newsletterLocalService.getFormattedDate(d);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _newsletterLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> getIssue(
		String month, String year) {
		return _newsletterLocalService.getIssue(month, year);
	}

	@Override
	public java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> getIssueArticles(
		com.liferay.training.amf.newsletter.model.Newsletter news) {
		return _newsletterLocalService.getIssueArticles(news);
	}

	@Override
	public java.sql.Date getIssueDate(
		com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return _newsletterLocalService.getIssueDate(ja);
	}

	@Override
	public int getIssueNumber(com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return _newsletterLocalService.getIssueNumber(ja);
	}

	@Override
	public com.liferay.journal.model.JournalArticle getJournalArticle(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsletterLocalService.getJournalArticle(id);
	}

	@Override
	public java.util.List<com.liferay.journal.model.JournalArticle> getJournalArticles(
		java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> news)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsletterLocalService.getJournalArticles(news);
	}

	@Override
	public java.util.List<String> getMonthsWithIssues(int issueYear) {
		return _newsletterLocalService.getMonthsWithIssues(issueYear);
	}

	/**
	* Returns the newsletter with the primary key.
	*
	* @param newsletterId the primary key of the newsletter
	* @return the newsletter
	* @throws PortalException if a newsletter with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.newsletter.model.Newsletter getNewsletter(
		long newsletterId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsletterLocalService.getNewsletter(newsletterId);
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
	@Override
	public java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> getNewsletters(
		int start, int end) {
		return _newsletterLocalService.getNewsletters(start, end);
	}

	/**
	* Returns the number of newsletters.
	*
	* @return the number of newsletters
	*/
	@Override
	public int getNewslettersCount() {
		return _newsletterLocalService.getNewslettersCount();
	}

	@Override
	public int getOrder(com.liferay.journal.model.JournalArticle ja)
		throws com.liferay.portal.kernel.xml.DocumentException {
		return _newsletterLocalService.getOrder(ja);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _newsletterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _newsletterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public String getTabs(java.util.List<Integer> years)
		throws com.liferay.portal.kernel.xml.DocumentException,
			com.liferay.portal.kernel.exception.PortalException {
		return _newsletterLocalService.getTabs(years);
	}

	@Override
	public String getTitle(com.liferay.journal.model.JournalArticle ja) {
		return _newsletterLocalService.getTitle(ja);
	}

	@Override
	public java.util.List<Integer> getYearsWithIssues() {
		return _newsletterLocalService.getYearsWithIssues();
	}

	@Override
	public void markAsPastVersion(
		java.util.List<com.liferay.training.amf.newsletter.model.Newsletter> news) {
		_newsletterLocalService.markAsPastVersion(news);
	}

	/**
	* Updates the newsletter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param newsletter the newsletter
	* @return the newsletter that was updated
	*/
	@Override
	public com.liferay.training.amf.newsletter.model.Newsletter updateNewsletter(
		com.liferay.training.amf.newsletter.model.Newsletter newsletter) {
		return _newsletterLocalService.updateNewsletter(newsletter);
	}

	@Override
	public void updateVersion(String articleId, boolean isArticle) {
		_newsletterLocalService.updateVersion(articleId, isArticle);
	}

	@Override
	public NewsletterLocalService getWrappedService() {
		return _newsletterLocalService;
	}

	@Override
	public void setWrappedService(NewsletterLocalService newsletterLocalService) {
		_newsletterLocalService = newsletterLocalService;
	}

	private NewsletterLocalService _newsletterLocalService;
}