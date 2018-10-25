<%@ include file="/init.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

Issue: #${newsletter.getIssueNumber()}, ${newsletter.getStringDate()}<br>
<b>${newsletterArticle.getTitle(LocaleUtil.getDefault().getLanguage())}</b><br>
${newsletterByline}<br><br>
${newsletterDescription}<br><br>
<c:forEach items="${newsletterArticles}" var="article" varStatus="status">
	<b>${article.getTitle(LocaleUtil.getDefault().getLanguage())}</b><br>
	${newsletterArticleContent[status.index]}<br><br>
</c:forEach>