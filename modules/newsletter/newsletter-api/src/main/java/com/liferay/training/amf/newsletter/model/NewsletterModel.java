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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Newsletter service. Represents a row in the &quot;Newsletter_Newsletter&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.training.amf.newsletter.model.impl.NewsletterModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.training.amf.newsletter.model.impl.NewsletterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @see com.liferay.training.amf.newsletter.model.impl.NewsletterImpl
 * @see com.liferay.training.amf.newsletter.model.impl.NewsletterModelImpl
 * @generated
 */
@ProviderType
public interface NewsletterModel extends BaseModel<Newsletter> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a newsletter model instance should use the {@link Newsletter} interface instead.
	 */

	/**
	 * Returns the primary key of this newsletter.
	 *
	 * @return the primary key of this newsletter
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this newsletter.
	 *
	 * @param primaryKey the primary key of this newsletter
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this newsletter.
	 *
	 * @return the uuid of this newsletter
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this newsletter.
	 *
	 * @param uuid the uuid of this newsletter
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the newsletter ID of this newsletter.
	 *
	 * @return the newsletter ID of this newsletter
	 */
	public long getNewsletterId();

	/**
	 * Sets the newsletter ID of this newsletter.
	 *
	 * @param newsletterId the newsletter ID of this newsletter
	 */
	public void setNewsletterId(long newsletterId);

	/**
	 * Returns the article ID of this newsletter.
	 *
	 * @return the article ID of this newsletter
	 */
	@AutoEscape
	public String getArticleId();

	/**
	 * Sets the article ID of this newsletter.
	 *
	 * @param articleId the article ID of this newsletter
	 */
	public void setArticleId(String articleId);

	/**
	 * Returns the issue number of this newsletter.
	 *
	 * @return the issue number of this newsletter
	 */
	public int getIssueNumber();

	/**
	 * Sets the issue number of this newsletter.
	 *
	 * @param issueNumber the issue number of this newsletter
	 */
	public void setIssueNumber(int issueNumber);

	/**
	 * Returns the issue date of this newsletter.
	 *
	 * @return the issue date of this newsletter
	 */
	public Date getIssueDate();

	/**
	 * Sets the issue date of this newsletter.
	 *
	 * @param issueDate the issue date of this newsletter
	 */
	public void setIssueDate(Date issueDate);

	/**
	 * Returns the order of this newsletter.
	 *
	 * @return the order of this newsletter
	 */
	public int getOrder();

	/**
	 * Sets the order of this newsletter.
	 *
	 * @param order the order of this newsletter
	 */
	public void setOrder(int order);

	/**
	 * Returns the is article of this newsletter.
	 *
	 * @return the is article of this newsletter
	 */
	public boolean getIsArticle();

	/**
	 * Returns <code>true</code> if this newsletter is is article.
	 *
	 * @return <code>true</code> if this newsletter is is article; <code>false</code> otherwise
	 */
	public boolean isIsArticle();

	/**
	 * Sets whether this newsletter is is article.
	 *
	 * @param isArticle the is article of this newsletter
	 */
	public void setIsArticle(boolean isArticle);

	/**
	 * Returns the author of this newsletter.
	 *
	 * @return the author of this newsletter
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this newsletter.
	 *
	 * @param author the author of this newsletter
	 */
	public void setAuthor(String author);

	/**
	 * Returns the most recent of this newsletter.
	 *
	 * @return the most recent of this newsletter
	 */
	public boolean getMostRecent();

	/**
	 * Returns <code>true</code> if this newsletter is most recent.
	 *
	 * @return <code>true</code> if this newsletter is most recent; <code>false</code> otherwise
	 */
	public boolean isMostRecent();

	/**
	 * Sets whether this newsletter is most recent.
	 *
	 * @param mostRecent the most recent of this newsletter
	 */
	public void setMostRecent(boolean mostRecent);

	/**
	 * Returns the string date of this newsletter.
	 *
	 * @return the string date of this newsletter
	 */
	@AutoEscape
	public String getStringDate();

	/**
	 * Sets the string date of this newsletter.
	 *
	 * @param stringDate the string date of this newsletter
	 */
	public void setStringDate(String stringDate);

	/**
	 * Returns the month of this newsletter.
	 *
	 * @return the month of this newsletter
	 */
	@AutoEscape
	public String getMonth();

	/**
	 * Sets the month of this newsletter.
	 *
	 * @param month the month of this newsletter
	 */
	public void setMonth(String month);

	/**
	 * Returns the year of this newsletter.
	 *
	 * @return the year of this newsletter
	 */
	public int getYear();

	/**
	 * Sets the year of this newsletter.
	 *
	 * @param year the year of this newsletter
	 */
	public void setYear(int year);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Newsletter newsletter);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Newsletter> toCacheModel();

	@Override
	public Newsletter toEscapedModel();

	@Override
	public Newsletter toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}