package com.liferay.training.amf.newsletter.portlet;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.liferay.training.amf.newsletter.constants.NewsletterWebPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
	    property = {
	        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	        "javax.portlet.name=" + NewsletterWebPortletKeys.ISSUE_PORTLET
	    },
	    service = FriendlyURLMapper.class
	)

public class NewsletterIssuesFriendlyURLMapper extends DefaultFriendlyURLMapper{

	 @Override
	    public String getMapping() {
	        return _MAPPING;
	    }

	    private static final String _MAPPING = "article-issue";
	
}
