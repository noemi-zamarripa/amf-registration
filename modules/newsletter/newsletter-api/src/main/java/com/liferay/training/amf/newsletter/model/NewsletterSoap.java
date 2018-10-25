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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.amf.newsletter.service.http.NewsletterServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.newsletter.service.http.NewsletterServiceSoap
 * @generated
 */
@ProviderType
public class NewsletterSoap implements Serializable {
	public static NewsletterSoap toSoapModel(Newsletter model) {
		NewsletterSoap soapModel = new NewsletterSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setNewsletterId(model.getNewsletterId());
		soapModel.setArticleId(model.getArticleId());
		soapModel.setIssueNumber(model.getIssueNumber());
		soapModel.setIssueDate(model.getIssueDate());
		soapModel.setOrder(model.getOrder());
		soapModel.setIsArticle(model.isIsArticle());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setMostRecent(model.isMostRecent());
		soapModel.setStringDate(model.getStringDate());
		soapModel.setMonth(model.getMonth());
		soapModel.setYear(model.getYear());

		return soapModel;
	}

	public static NewsletterSoap[] toSoapModels(Newsletter[] models) {
		NewsletterSoap[] soapModels = new NewsletterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NewsletterSoap[][] toSoapModels(Newsletter[][] models) {
		NewsletterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NewsletterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NewsletterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NewsletterSoap[] toSoapModels(List<Newsletter> models) {
		List<NewsletterSoap> soapModels = new ArrayList<NewsletterSoap>(models.size());

		for (Newsletter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NewsletterSoap[soapModels.size()]);
	}

	public NewsletterSoap() {
	}

	public long getPrimaryKey() {
		return _newsletterId;
	}

	public void setPrimaryKey(long pk) {
		setNewsletterId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getNewsletterId() {
		return _newsletterId;
	}

	public void setNewsletterId(long newsletterId) {
		_newsletterId = newsletterId;
	}

	public String getArticleId() {
		return _articleId;
	}

	public void setArticleId(String articleId) {
		_articleId = articleId;
	}

	public int getIssueNumber() {
		return _issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		_issueNumber = issueNumber;
	}

	public Date getIssueDate() {
		return _issueDate;
	}

	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public boolean getIsArticle() {
		return _isArticle;
	}

	public boolean isIsArticle() {
		return _isArticle;
	}

	public void setIsArticle(boolean isArticle) {
		_isArticle = isArticle;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public boolean getMostRecent() {
		return _mostRecent;
	}

	public boolean isMostRecent() {
		return _mostRecent;
	}

	public void setMostRecent(boolean mostRecent) {
		_mostRecent = mostRecent;
	}

	public String getStringDate() {
		return _stringDate;
	}

	public void setStringDate(String stringDate) {
		_stringDate = stringDate;
	}

	public String getMonth() {
		return _month;
	}

	public void setMonth(String month) {
		_month = month;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	private String _uuid;
	private long _newsletterId;
	private String _articleId;
	private int _issueNumber;
	private Date _issueDate;
	private int _order;
	private boolean _isArticle;
	private String _author;
	private boolean _mostRecent;
	private String _stringDate;
	private String _month;
	private int _year;
}