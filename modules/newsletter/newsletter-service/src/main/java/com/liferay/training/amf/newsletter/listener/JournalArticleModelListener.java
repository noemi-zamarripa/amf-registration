package com.liferay.training.amf.newsletter.listener;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.training.amf.newsletter.model.Newsletter;
import com.liferay.training.amf.newsletter.service.NewsletterLocalService;

import java.util.Calendar;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(
		immediate = true,
		service = ModelListener.class
	)

public class JournalArticleModelListener extends BaseModelListener<JournalArticle>{
	
	private static Log _log = LogFactoryUtil.getLog(JournalArticleModelListener.class);
	
	@Override
	public void onAfterCreate(JournalArticle ja) {
		
		Newsletter nl = _newsletterLocalService.createNewsletter(ja.getId());
		nl.setArticleId(ja.getArticleId());
		
		try {
			if (_newsletterLocalService.getOrder(ja) == -1) {
				Calendar c = Calendar.getInstance();
				nl.setIsArticle(false);
				_newsletterLocalService.updateVersion(nl.getArticleId(), nl.getIsArticle());
				nl.setIssueDate(_newsletterLocalService.getIssueDate(ja));
				nl.setStringDate(_newsletterLocalService.getFormattedDate(nl.getIssueDate()));
				c.setTime(nl.getIssueDate());
				nl.setMonth(_newsletterLocalService.convertMonthToString(c.get(Calendar.MONTH)));
				nl.setYear(c.get(Calendar.YEAR));
				nl.setIssueNumber(_newsletterLocalService.getIssueNumber(ja));
				nl.setMostRecent(true);
				_newsletterLocalService.addNewsletter(nl);
			}else {
				nl.setIsArticle(true);
				_newsletterLocalService.updateVersion(nl.getArticleId(), nl.getIsArticle());
				nl.setOrder(_newsletterLocalService.getOrder(ja));
				nl.setIssueNumber(_newsletterLocalService.getIssueNumber(ja));
				nl.setAuthor(_newsletterLocalService.getAuthor(ja));
				nl.setMostRecent(true);
				_newsletterLocalService.addNewsletter(nl);
			}
		} catch (DocumentException e) {
			_log.error("newsletter-entry-failed");
		}
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected NewsletterLocalService _newsletterLocalService;
}
