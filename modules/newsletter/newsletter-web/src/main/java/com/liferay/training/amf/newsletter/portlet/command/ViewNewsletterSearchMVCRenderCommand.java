package com.liferay.training.amf.newsletter.portlet.command;

import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.amf.newsletter.constants.NewsletterWebPortletKeys;
import com.liferay.training.amf.newsletter.service.NewsletterLocalService;

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
			"javax.portlet.name=" + NewsletterWebPortletKeys.NEWSLETTER_SEARCH_PORTLET,
			"javax.portlet.name=" + NewsletterWebPortletKeys.NEWSLETTER_PORTLET,
			"com.liferay.portlet.display-category=category.sample",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user",
			"com.liferay.portlet.instanceable=true", 
			"mvc.command.name=/newsletter/search",
			"mvc.command.name=/", 
			}, 
			service = MVCRenderCommand.class)

public class ViewNewsletterSearchMVCRenderCommand implements MVCRenderCommand{

	private static Log _log = LogFactoryUtil.getLog(ViewNewsletterMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		String keyword = (String) renderRequest.getPortletSession().getAttribute("sharedKeyword", PortletSession.APPLICATION_SCOPE);
		renderRequest.setAttribute("enteredKeyword", keyword);
		
		SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
		
		try {
			List<Document> hits = _newsletterLocalService.search("title_en_US", "description_en_US", "ddm__text__31307__Content_en_US", "ddm__keyword__31307__Author_en_US", keyword, searchContext);
			
			renderRequest.setAttribute("searchResultsContainer", _newsletterLocalService.setSearchContainer(renderRequest, renderResponse, hits));
			renderRequest.setAttribute("journalArticle", _journalArticleLocalService);
			
		} catch (SearchException e) {
			_log.error("no-hits-returned");
		}
		
		return "/newsletter_search.jsp";
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected NewsletterLocalService _newsletterLocalService;
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected JournalArticleLocalService _journalArticleLocalService;

}
