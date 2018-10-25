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

package com.liferay.training.amf.newsletter.service.impl;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.training.amf.newsletter.model.Newsletter;
import com.liferay.training.amf.newsletter.service.base.NewsletterLocalServiceBaseImpl;
import com.liferay.training.amf.newsletter.service.persistence.NewsletterUtil;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * The implementation of the newsletter local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.amf.newsletter.service.NewsletterLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterLocalServiceBaseImpl
 * @see com.liferay.training.amf.newsletter.service.NewsletterLocalServiceUtil
 */
public class NewsletterLocalServiceImpl extends NewsletterLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.liferay.training.amf.newsletter.service.NewsletterLocalServiceUtil} to
	 * access the newsletter local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(NewsletterLocalServiceImpl.class);

	public int convertMonthToInteger(String month) {
		int m = 0;

		switch (month) {
		case "January":
			m = 0;
			break;
		case "February":
			m = 1;
			break;
		case "March":
			m = 2;
			break;
		case "April":
			m = 3;
			break;
		case "May":
			m = 4;
			break;
		case "June":
			m = 5;
			break;
		case "July":
			m = 6;
			break;
		case "August":
			m = 7;
			break;
		case "September":
			m = 8;
			break;
		case "October":
			m = 9;
			break;
		case "November":
			m = 10;
			break;
		case "December":
			m = 11;
			break;
		}

		return m;
	}
	
	public String convertMonthToString(int month) {
		String m = null;

		switch (month) {
		case 0:
			m = "January";
			break;
		case 1:
			m = "February";
			break;
		case 2:
			m = "March";
			break;
		case 3:
			m = "April";
			break;
		case 4:
			m = "May";
			break;
		case 5:
			m = "June";
			break;
		case 6:
			m = "July";
			break;
		case 7:
			m = "August";
			break;
		case 8:
			m = "September";
			break;
		case 9:
			m = "October";
			break;
		case 10:
			m = "November";
			break;
		case 11:
			m = "December";
			break;
		}

		return m;
	}
	
	public List<Newsletter> findByIssueNumber(int issueNumber){
		return NewsletterUtil.findByIssueNumber(issueNumber, false, true);
	}
	
	public String getAuthor(JournalArticle ja) throws DocumentException {

		String xmlContent = ja.getContent();
		String author = "Author";

		Document doc = SAXReaderUtil.read(xmlContent);

		Node node = doc.selectSingleNode("/root/dynamic-element[@name='" + author + "']/dynamic-content");

		String authr = node.getText();

		return authr;
	}
	
	public String getByline(List<Newsletter> news) throws DocumentException, PortalException {
		StringBuilder authors = new StringBuilder();

		for (Newsletter n : news) {
			authors.append(n.getAuthor()).append(", ");
		}

		return authors.substring(0, authors.length()-2);
	}
	
	public String getContent(JournalArticle ja) throws DocumentException {

		String xmlContent = ja.getContent();
		String content = "Content";

		Document doc = SAXReaderUtil.read(xmlContent);

		Node node = doc.selectSingleNode("/root/dynamic-element[@name='" + content + "']/dynamic-content");

		String cont = node.getText();

		return cont;

	}
	
	public String getDescription(JournalArticle ja) {
		return ja.getDescription(LocaleUtil.getDefault().getLanguage());
	}
	
	public String getFormattedDate(java.util.Date d) {		
		String pattern = "MMM dd,yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		return sdf.format(d);
	}
	
	public List<Newsletter> getIssue(String month, String year) {
		int m = convertMonthToInteger(month);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, m);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		
		java.util.Date startDate = cal.getTime();
		
		cal.add(Calendar.MONTH, 1);
		
		java.util.Date endDate = cal.getTime();
		
		DynamicQuery issueQuery = newsletterLocalService.dynamicQuery();
		issueQuery.add(RestrictionsFactoryUtil.between("issueDate", startDate, endDate));
		issueQuery.add(RestrictionsFactoryUtil.eq("mostRecent", true));
		issueQuery.addOrder(OrderFactoryUtil.desc("issueDate"));

		try {
			List<Newsletter> issue = newsletterLocalService.dynamicQuery(issueQuery);

			return issue;
		}catch (SystemException e) {
			_log.error("no-newsletter-for-this-month");
		}
		
		return null;

	}
	
	public List<Newsletter> getIssueArticles(Newsletter news){
		List<Newsletter> articles = new ArrayList<>();
		
		int issueNumber = news.getIssueNumber();
		
		articles = NewsletterUtil.findByIssueNumber(issueNumber, true, true);
		
		return articles;
		
	}
	
	public Date getIssueDate(JournalArticle ja) throws DocumentException {

		String xmlContent = ja.getContent();
		String issueDate = "IssueDate";

		Document doc = SAXReaderUtil.read(xmlContent);

		Node node = doc.selectSingleNode("/root/dynamic-element[@name='" + issueDate + "']/dynamic-content");

		Date date = Date.valueOf(node.getText());

		return date;
	}
	
	public int getIssueNumber(JournalArticle ja) throws DocumentException {

		String xmlContent = ja.getContent();
		String issueNumber = "IssueNumber";

		Document doc = SAXReaderUtil.read(xmlContent);

		Node node = doc.selectSingleNode("/root/dynamic-element[@name='" + issueNumber + "']/dynamic-content");

		int number = Integer.parseInt(node.getText());

		return number;
	}
	
	public JournalArticle getJournalArticle(long id) throws PortalException {
		return journalArticleLocalService.getArticle(id);
	}
	
	public List<JournalArticle> getJournalArticles(List<Newsletter> news) throws PortalException{
		List<JournalArticle> articles = new ArrayList<>();
		
		for (Newsletter n : news) {
			articles.add(getJournalArticle(n.getNewsletterId()));
		}
		
		return articles;
	}
	
	public List<String> getMonthsWithIssues(int issueYear){
		List<String> month = new ArrayList<>();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_YEAR, 1);
		cal.set(Calendar.YEAR, issueYear);
		
		java.util.Date startDate = cal.getTime();
		
		cal.add(Calendar.YEAR, 1);
		
		java.util.Date endDate = cal.getTime();
		
		DynamicQuery months = newsletterLocalService.dynamicQuery();
		months.add(RestrictionsFactoryUtil.isNotNull("issueDate"));
		months.add(RestrictionsFactoryUtil.between("issueDate", startDate, endDate));
		months.add(RestrictionsFactoryUtil.eq("mostRecent", true));
		months.setProjection(PropertyFactoryUtil.forName("issueDate"));
		
		try {
			List<Timestamp> issueMonths = newsletterLocalService.dynamicQuery(months);
			
			Calendar c = Calendar.getInstance();
			
			for (Timestamp t : issueMonths) {
				Date d = new Date(t.getTime());
				c.setTime(d);
				String m = convertMonthToString(c.get(Calendar.MONTH));
				if (!month.contains(m)) {
					month.add(m);
				}
			}
			
			return month;
			
		}catch (SystemException e) {
			_log.error("no-newsletter-for-this-month");
		}
		
		return null;
	}
	
	public int getOrder(JournalArticle ja) throws DocumentException {

		String xmlContent = ja.getContent();
		String order = "Order";

		Document doc = SAXReaderUtil.read(xmlContent);

		Node node = doc.selectSingleNode("/root/dynamic-element[@name='" + order + "']/dynamic-content");

		int or;

		try {
			or = Integer.parseInt(node.getText());
		} catch (NullPointerException e) {
			or = -1;
		}

		return or;
	}
	
	public String getTabs(List<Integer> years) throws DocumentException, PortalException {
		StringBuilder tabs = new StringBuilder();

		for (Integer n : years) {
			tabs.append(n).append(",");
		}

		return tabs.substring(0, tabs.length()-1);
	}
	
	public String getTitle(JournalArticle ja) {
		return ja.getTitle(LocaleUtil.getDefault().getLanguage());
	}
	
	public List<Integer> getYearsWithIssues(){
		List<Integer> year = new ArrayList<>();
		
		DynamicQuery years = newsletterLocalService.dynamicQuery();
		years.add(RestrictionsFactoryUtil.isNotNull("issueDate"));
		years.add(RestrictionsFactoryUtil.eq("mostRecent", true));
		years.setProjection(PropertyFactoryUtil.forName("issueDate"));
		
		try {
			List<Timestamp> issueYears = newsletterLocalService.dynamicQuery(years);
			
			Calendar c = Calendar.getInstance();
			
			for (Timestamp t : issueYears) {
				Date d = new Date(t.getTime());
				c.setTime(d);
				if (!year.contains(c.get(Calendar.YEAR))) {
					year.add(c.get(Calendar.YEAR));
				}
			}
			
			Collections.sort(year, Collections.reverseOrder());
			
			return year;
			
		}catch (SystemException e) {
			_log.error("no-newsletter-for-this-month");
		}
		
		return null;
	}
	
	public void markAsPastVersion(List<Newsletter> news) {
		for (Newsletter n : news) {
			n.setMostRecent(false);
		}
	}
	
	public void updateVersion(String articleId, boolean isArticle) {
		List<Newsletter> news = NewsletterUtil.findByArticleId(articleId, isArticle);
		
		if (news.size() != 0) {
			markAsPastVersion(news);
		}
		
	}
}