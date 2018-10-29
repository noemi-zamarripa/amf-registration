<%@ include file="/init.jsp"%>

<portlet:actionURL name="/newsletter/search" var="searchForKeywordURL">
</portlet:actionURL>

<aui:form action="${searchForKeywordURL}" method="post">
	<aui:row>
		<aui:col width="25">
			<aui:input label="Keyword Search" name="keyword-search" type="text"
				value="${enteredKeyword}" />
		</aui:col>
	</aui:row>
	<aui:button name="search" value="Search" type="submit" />
</aui:form>
<br>

<c:if test="${not empty enteredKeyword}">
	<h1>
		<liferay-ui:message key="Search Results for: ${enteredKeyword}" />
	</h1>
</c:if>

<div>
	<liferay-ui:search-container
		searchContainer="${searchResultsContainer}">
		<c:set var="count" value=""></c:set>
		<liferay-ui:search-container-row
			className="com.liferay.training.amf.newsletter.model.Newsletter"
			modelVar="newsletter">
			
			<portlet:actionURL name="/newsletter/article/issue" var="redirectToIssueURL" >
				<portlet:param name="issueNumber" value="${newsletter.getIssueNumber()}"/>
			</portlet:actionURL>
			
			<liferay-ui:search-container-column-text name="Issue Number"
				value="${newsletter.getIssueNumber()}" />

			<liferay-ui:search-container-column-text name="Issue Date"
				value="${newsletter.getStringDate()}" />

			<liferay-ui:search-container-column-text name="Issue Title"
				value="${journalArticle.getArticle(newsletter.getNewsletterId()).getTitle(LocaleUtil.getDefault().getLanguage())}" 
				href="${redirectToIssueURL}" />

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
</div>