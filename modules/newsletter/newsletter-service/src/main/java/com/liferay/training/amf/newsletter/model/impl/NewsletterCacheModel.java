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

package com.liferay.training.amf.newsletter.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.training.amf.newsletter.model.Newsletter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Newsletter in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @generated
 */
@ProviderType
public class NewsletterCacheModel implements CacheModel<Newsletter>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NewsletterCacheModel)) {
			return false;
		}

		NewsletterCacheModel newsletterCacheModel = (NewsletterCacheModel)obj;

		if (newsletterId == newsletterCacheModel.newsletterId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, newsletterId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", newsletterId=");
		sb.append(newsletterId);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", issueNumber=");
		sb.append(issueNumber);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append(", order=");
		sb.append(order);
		sb.append(", isArticle=");
		sb.append(isArticle);
		sb.append(", author=");
		sb.append(author);
		sb.append(", mostRecent=");
		sb.append(mostRecent);
		sb.append(", stringDate=");
		sb.append(stringDate);
		sb.append(", month=");
		sb.append(month);
		sb.append(", year=");
		sb.append(year);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Newsletter toEntityModel() {
		NewsletterImpl newsletterImpl = new NewsletterImpl();

		if (uuid == null) {
			newsletterImpl.setUuid("");
		}
		else {
			newsletterImpl.setUuid(uuid);
		}

		newsletterImpl.setNewsletterId(newsletterId);

		if (articleId == null) {
			newsletterImpl.setArticleId("");
		}
		else {
			newsletterImpl.setArticleId(articleId);
		}

		newsletterImpl.setIssueNumber(issueNumber);

		if (issueDate == Long.MIN_VALUE) {
			newsletterImpl.setIssueDate(null);
		}
		else {
			newsletterImpl.setIssueDate(new Date(issueDate));
		}

		newsletterImpl.setOrder(order);
		newsletterImpl.setIsArticle(isArticle);

		if (author == null) {
			newsletterImpl.setAuthor("");
		}
		else {
			newsletterImpl.setAuthor(author);
		}

		newsletterImpl.setMostRecent(mostRecent);

		if (stringDate == null) {
			newsletterImpl.setStringDate("");
		}
		else {
			newsletterImpl.setStringDate(stringDate);
		}

		if (month == null) {
			newsletterImpl.setMonth("");
		}
		else {
			newsletterImpl.setMonth(month);
		}

		newsletterImpl.setYear(year);

		newsletterImpl.resetOriginalValues();

		return newsletterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		newsletterId = objectInput.readLong();
		articleId = objectInput.readUTF();

		issueNumber = objectInput.readInt();
		issueDate = objectInput.readLong();

		order = objectInput.readInt();

		isArticle = objectInput.readBoolean();
		author = objectInput.readUTF();

		mostRecent = objectInput.readBoolean();
		stringDate = objectInput.readUTF();
		month = objectInput.readUTF();

		year = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(newsletterId);

		if (articleId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(articleId);
		}

		objectOutput.writeInt(issueNumber);
		objectOutput.writeLong(issueDate);

		objectOutput.writeInt(order);

		objectOutput.writeBoolean(isArticle);

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeBoolean(mostRecent);

		if (stringDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stringDate);
		}

		if (month == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(month);
		}

		objectOutput.writeInt(year);
	}

	public String uuid;
	public long newsletterId;
	public String articleId;
	public int issueNumber;
	public long issueDate;
	public int order;
	public boolean isArticle;
	public String author;
	public boolean mostRecent;
	public String stringDate;
	public String month;
	public int year;
}