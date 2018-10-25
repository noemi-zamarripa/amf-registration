package com.liferay.training.amf.newsletter.portlet.command;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.newsletter.constants.NewsletterWebPortletKeys;
import com.liferay.training.amf.newsletter.model.Newsletter;
import com.liferay.training.amf.newsletter.service.NewsletterLocalService;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(immediate = true, 
		   property = { 
		   "javax.portlet.name=" + NewsletterWebPortletKeys.NEWSLETTER_PORTLET,
		   "com.liferay.portlet.display-category=category.sample",
		   "javax.portlet.resource-bundle=content.Language",
		   "javax.portlet.security-role-ref=power-user,user",
		   "com.liferay.portlet.instanceable=true", 
		   "mvc.command.name=/newsletter/issue/display",
		   "mvc.command.name=/", 
		   }, 
		   service = MVCRenderCommand.class)

public class ViewNewsletterMVCRenderCommand implements MVCRenderCommand{
	
	private static Log _log = LogFactoryUtil.getLog(ViewNewsletterMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		int currentTab = ParamUtil.getInteger(renderRequest, "currTab", 2018);
		
		try {
			List<Integer> years = _newsletterLocalService.getYearsWithIssues();
			String yearTabs = _newsletterLocalService.getTabs(years);
			renderRequest.setAttribute("year", yearTabs);
			
			List<String> months = _newsletterLocalService.getMonthsWithIssues(currentTab);
			renderRequest.setAttribute("months", months);
			
			List<List<Newsletter>> issues = new ArrayList<List<Newsletter>>();
			
			for (String m : months) {
				issues.add(_newsletterLocalService.getIssue(m, String.valueOf(currentTab)));
			}
			
			renderRequest.setAttribute("newsletters", issues);
			
			List<JournalArticle> newsletterTitle = new ArrayList<>();
			
			for (List<Newsletter> ln : issues) {
				for (Newsletter n : ln) {
					newsletterTitle.add(_newsletterLocalService.getJournalArticle(n.getNewsletterId()));
				}
			}
			
			renderRequest.setAttribute("newsletterArticleObject", newsletterTitle);
			
			List<List<Newsletter>> articles = new ArrayList<List<Newsletter>>();
			
			for (List<Newsletter> ln : issues) {
				for (Newsletter n : ln) {
					articles.add(_newsletterLocalService.getIssueArticles(n));
				}
			}
			
			renderRequest.setAttribute("articles", articles);
			
			List<JournalArticle> jas = new ArrayList<>();
			
			for (List<Newsletter> la : articles) {
				for (Newsletter n : la) {
					jas.add(_newsletterLocalService.getJournalArticle(n.getNewsletterId()));
				}
			}
			
			renderRequest.setAttribute("articleTitles", jas);
			
		} catch (Exception e) {
			_log.error("portlet-failed-to-load");
		}
		
		return "/view.jsp";
	}
	
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected NewsletterLocalService _newsletterLocalService;
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected JournalArticleLocalService _journalArticleLocalService;
}
