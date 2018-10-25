<%@ include file="/init.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL name="processAction" var="issueDetailURL">
	<portlet:param name="pageName" value="/newsletter_issue_display.jsp"></portlet:param>
</portlet:actionURL>

<portlet:renderURL var="portletURL" >
	<portlet:param name="mvcRenderCommandName" value="/resources/newsletters"/>
</portlet:renderURL>

<liferay-ui:tabs param="currTab" names="${year}" refresh="true"
	url="${portletURL}">
	<c:forEach items="${months}" var="m" >
		<h1>${m}</h1>
		<c:forEach items="${newsletters}" var="news" varStatus="status1">
			<c:forEach items="${news}" var="n" varStatus="status2">
				<c:if test="${m == n.getMonth()}">
					<br>Issue: #${n.getIssueNumber()}, ${n.getStringDate()}<br>
					<c:forEach items="${newsletterArticleObject}" var="article" >
						<c:if test="${n.getNewsletterId() == article.getId()}">
							<b><a href="${issueDetailURL}">${article.getTitle(LocaleUtil.getDefault().getLanguage())}</a></b>
						</c:if>
					</c:forEach>
					<c:set var="issueNumber" value="${n.getIssueNumber()}"></c:set>
					<c:forEach items="${articles}" var="art" varStatus="articles1">
						<c:forEach items="${art}" var="a" varStatus="articles2">
							<c:if test="${issueNumber == articles[articles1.index][articles2.index].getIssueNumber()}">
								<c:set var="id" value="${articles[articles1.index][articles2.index].getNewsletterId()}"></c:set>
								<c:forEach items="${articleTitles}" var="article">
									<c:if test="${id == article.getId()}">
										<br><a href="${issueDetailURL}">${article.getTitle(LocaleUtil.getDefault().getLanguage())}</a>
									</c:if>
								</c:forEach>
							</c:if>
						</c:forEach>
					</c:forEach>
					<br>
				</c:if>
			</c:forEach>
		</c:forEach>
	</c:forEach>
</liferay-ui:tabs>