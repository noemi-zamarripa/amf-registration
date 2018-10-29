package com.liferay.training.amf.newsletter.portlet.command;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.newsletter.constants.NewsletterWebPortletKeys;
import com.liferay.training.amf.newsletter.model.Newsletter;
import com.liferay.training.amf.newsletter.service.NewsletterLocalService;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(immediate = true, 
		   property = { 
		   "javax.portlet.name=" + NewsletterWebPortletKeys.ISSUE_PORTLET,
		   "com.liferay.portlet.display-category=category.sample",
		   "javax.portlet.resource-bundle=content.Language",
		   "javax.portlet.security-role-ref=power-user,user",
		   "com.liferay.portlet.instanceable=true", 
		   "mvc.command.name=/newsletter/issue/display", 
		   "mvc.command.name=/"
		   }, 
		   service = MVCRenderCommand.class)

public class ViewIssueMVCRenderCommand implements MVCRenderCommand{
	
	private static Log _log = LogFactoryUtil.getLog(ViewIssueMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		int issueNumber = (Integer) renderRequest.getPortletSession().getAttribute("sharedIssueNumber", PortletSession.APPLICATION_SCOPE);
		
		try {
			List<Newsletter> issueNewsletter = _newsletterLocalService.findByIssueNumber(issueNumber);
			Newsletter n = null;
			
			if (!(issueNewsletter.size() > 1)) {
				n = issueNewsletter.get(0);
				renderRequest.setAttribute("newsletter", n);
			}
			
			List<Newsletter> news = _newsletterLocalService.getIssueArticles(n);
			
			JournalArticle ja = _newsletterLocalService.getJournalArticle(n.getNewsletterId());
			renderRequest.setAttribute("newsletterArticle", ja);
			
			String byline = _newsletterLocalService.getByline(news);
			renderRequest.setAttribute("newsletterByline", byline);
			
			String description = _newsletterLocalService.getDescription(ja);
			renderRequest.setAttribute("newsletterDescription", description);
			
			List<JournalArticle> jas = _newsletterLocalService.getJournalArticles(news);
			renderRequest.setAttribute("newsletterArticles", jas);
			
			List<String> content = new ArrayList<>();
			
			for (JournalArticle j : jas) {
				content.add(_newsletterLocalService.getContent(j));
			}
			
			renderRequest.setAttribute("newsletterArticleContent", content);
			
		} catch (Exception e) {
			_log.error("no-newsletter-to-show");
		}
		
		return "/newsletter_issue_display.jsp";
	}
	
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected NewsletterLocalService _newsletterLocalService;
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected JournalArticleLocalService _journalArticleLocalService;
}
