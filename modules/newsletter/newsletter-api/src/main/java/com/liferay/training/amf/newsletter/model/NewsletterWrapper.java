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

package com.liferay.training.amf.newsletter.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Newsletter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @generated
 */
@ProviderType
public class NewsletterWrapper implements Newsletter, ModelWrapper<Newsletter> {
	public NewsletterWrapper(Newsletter newsletter) {
		_newsletter = newsletter;
	}

	@Override
	public Class<?> getModelClass() {
		return Newsletter.class;
	}

	@Override
	public String getModelClassName() {
		return Newsletter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("newsletterId", getNewsletterId());
		attributes.put("articleId", getArticleId());
		attributes.put("issueNumber", getIssueNumber());
		attributes.put("issueDate", getIssueDate());
		attributes.put("order", getOrder());
		attributes.put("isArticle", isIsArticle());
		attributes.put("author", getAuthor());
		attributes.put("mostRecent", isMostRecent());
		attributes.put("stringDate", getStringDate());
		attributes.put("month", getMonth());
		attributes.put("year", getYear());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long newsletterId = (Long)attributes.get("newsletterId");

		if (newsletterId != null) {
			setNewsletterId(newsletterId);
		}

		String articleId = (String)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		Integer issueNumber = (Integer)attributes.get("issueNumber");

		if (issueNumber != null) {
			setIssueNumber(issueNumber);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Boolean isArticle = (Boolean)attributes.get("isArticle");

		if (isArticle != null) {
			setIsArticle(isArticle);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Boolean mostRecent = (Boolean)attributes.get("mostRecent");

		if (mostRecent != null) {
			setMostRecent(mostRecent);
		}

		String stringDate = (String)attributes.get("stringDate");

		if (stringDate != null) {
			setStringDate(stringDate);
		}

		String month = (String)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}
	}

	@Override
	public Object clone() {
		return new NewsletterWrapper((Newsletter)_newsletter.clone());
	}

	@Override
	public int compareTo(Newsletter newsletter) {
		return _newsletter.compareTo(newsletter);
	}

	/**
	* Returns the article ID of this newsletter.
	*
	* @return the article ID of this newsletter
	*/
	@Override
	public String getArticleId() {
		return _newsletter.getArticleId();
	}

	/**
	* Returns the author of this newsletter.
	*
	* @return the author of this newsletter
	*/
	@Override
	public String getAuthor() {
		return _newsletter.getAuthor();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _newsletter.getExpandoBridge();
	}

	/**
	* Returns the is article of this newsletter.
	*
	* @return the is article of this newsletter
	*/
	@Override
	public boolean getIsArticle() {
		return _newsletter.getIsArticle();
	}

	/**
	* Returns the issue date of this newsletter.
	*
	* @return the issue date of this newsletter
	*/
	@Override
	public Date getIssueDate() {
		return _newsletter.getIssueDate();
	}

	/**
	* Returns the issue number of this newsletter.
	*
	* @return the issue number of this newsletter
	*/
	@Override
	public int getIssueNumber() {
		return _newsletter.getIssueNumber();
	}

	/**
	* Returns the month of this newsletter.
	*
	* @return the month of this newsletter
	*/
	@Override
	public String getMonth() {
		return _newsletter.getMonth();
	}

	/**
	* Returns the most recent of this newsletter.
	*
	* @return the most recent of this newsletter
	*/
	@Override
	public boolean getMostRecent() {
		return _newsletter.getMostRecent();
	}

	/**
	* Returns the newsletter ID of this newsletter.
	*
	* @return the newsletter ID of this newsletter
	*/
	@Override
	public long getNewsletterId() {
		return _newsletter.getNewsletterId();
	}

	/**
	* Returns the order of this newsletter.
	*
	* @return the order of this newsletter
	*/
	@Override
	public int getOrder() {
		return _newsletter.getOrder();
	}

	/**
	* Returns the primary key of this newsletter.
	*
	* @return the primary key of this newsletter
	*/
	@Override
	public long getPrimaryKey() {
		return _newsletter.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _newsletter.getPrimaryKeyObj();
	}

	/**
	* Returns the string date of this newsletter.
	*
	* @return the string date of this newsletter
	*/
	@Override
	public String getStringDate() {
		return _newsletter.getStringDate();
	}

	/**
	* Returns the uuid of this newsletter.
	*
	* @return the uuid of this newsletter
	*/
	@Override
	public String getUuid() {
		return _newsletter.getUuid();
	}

	/**
	* Returns the year of this newsletter.
	*
	* @return the year of this newsletter
	*/
	@Override
	public int getYear() {
		return _newsletter.getYear();
	}

	@Override
	public int hashCode() {
		return _newsletter.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _newsletter.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _newsletter.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this newsletter is is article.
	*
	* @return <code>true</code> if this newsletter is is article; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsArticle() {
		return _newsletter.isIsArticle();
	}

	/**
	* Returns <code>true</code> if this newsletter is most recent.
	*
	* @return <code>true</code> if this newsletter is most recent; <code>false</code> otherwise
	*/
	@Override
	public boolean isMostRecent() {
		return _newsletter.isMostRecent();
	}

	@Override
	public boolean isNew() {
		return _newsletter.isNew();
	}

	@Override
	public void persist() {
		_newsletter.persist();
	}

	/**
	* Sets the article ID of this newsletter.
	*
	* @param articleId the article ID of this newsletter
	*/
	@Override
	public void setArticleId(String articleId) {
		_newsletter.setArticleId(articleId);
	}

	/**
	* Sets the author of this newsletter.
	*
	* @param author the author of this newsletter
	*/
	@Override
	public void setAuthor(String author) {
		_newsletter.setAuthor(author);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_newsletter.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_newsletter.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_newsletter.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_newsletter.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this newsletter is is article.
	*
	* @param isArticle the is article of this newsletter
	*/
	@Override
	public void setIsArticle(boolean isArticle) {
		_newsletter.setIsArticle(isArticle);
	}

	/**
	* Sets the issue date of this newsletter.
	*
	* @param issueDate the issue date of this newsletter
	*/
	@Override
	public void setIssueDate(Date issueDate) {
		_newsletter.setIssueDate(issueDate);
	}

	/**
	* Sets the issue number of this newsletter.
	*
	* @param issueNumber the issue number of this newsletter
	*/
	@Override
	public void setIssueNumber(int issueNumber) {
		_newsletter.setIssueNumber(issueNumber);
	}

	/**
	* Sets the month of this newsletter.
	*
	* @param month the month of this newsletter
	*/
	@Override
	public void setMonth(String month) {
		_newsletter.setMonth(month);
	}

	/**
	* Sets whether this newsletter is most recent.
	*
	* @param mostRecent the most recent of this newsletter
	*/
	@Override
	public void setMostRecent(boolean mostRecent) {
		_newsletter.setMostRecent(mostRecent);
	}

	@Override
	public void setNew(boolean n) {
		_newsletter.setNew(n);
	}

	/**
	* Sets the newsletter ID of this newsletter.
	*
	* @param newsletterId the newsletter ID of this newsletter
	*/
	@Override
	public void setNewsletterId(long newsletterId) {
		_newsletter.setNewsletterId(newsletterId);
	}

	/**
	* Sets the order of this newsletter.
	*
	* @param order the order of this newsletter
	*/
	@Override
	public void setOrder(int order) {
		_newsletter.setOrder(order);
	}

	/**
	* Sets the primary key of this newsletter.
	*
	* @param primaryKey the primary key of this newsletter
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_newsletter.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_newsletter.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the string date of this newsletter.
	*
	* @param stringDate the string date of this newsletter
	*/
	@Override
	public void setStringDate(String stringDate) {
		_newsletter.setStringDate(stringDate);
	}

	/**
	* Sets the uuid of this newsletter.
	*
	* @param uuid the uuid of this newsletter
	*/
	@Override
	public void setUuid(String uuid) {
		_newsletter.setUuid(uuid);
	}

	/**
	* Sets the year of this newsletter.
	*
	* @param year the year of this newsletter
	*/
	@Override
	public void setYear(int year) {
		_newsletter.setYear(year);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Newsletter> toCacheModel() {
		return _newsletter.toCacheModel();
	}

	@Override
	public Newsletter toEscapedModel() {
		return new NewsletterWrapper(_newsletter.toEscapedModel());
	}

	@Override
	public String toString() {
		return _newsletter.toString();
	}

	@Override
	public Newsletter toUnescapedModel() {
		return new NewsletterWrapper(_newsletter.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _newsletter.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsletterWrapper)) {
			return false;
		}

		NewsletterWrapper newsletterWrapper = (NewsletterWrapper)obj;

		if (Objects.equals(_newsletter, newsletterWrapper._newsletter)) {
			return true;
		}

		return false;
	}

	@Override
	public Newsletter getWrappedModel() {
		return _newsletter;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _newsletter.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _newsletter.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_newsletter.resetOriginalValues();
	}

	private final Newsletter _newsletter;
}