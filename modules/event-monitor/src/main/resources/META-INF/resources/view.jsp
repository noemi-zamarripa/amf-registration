<%@ include file="/init.jsp"%>

<h1>
	<liferay-ui:message key="javax.portlet.title.eventmonitor" />
</h1>


<div id="myTab">

	<ul class="nav nav-tabs">
		<li class="active"><a href="#tab-1">All</a></li>
		<li><a href="#tab-2">Registration</a></li>
		<li><a href="#tab-3">Login</a></li>
	</ul>

	<div class="tab-content">
		<div id="tab-1" class="tab-pane">
			<div>
				<liferay-ui:search-container
					searchContainer="${displayAllSearchContainer}">
					<liferay-ui:search-container-row
						className="com.liferay.training.amf.eventmonitor.service.model.StoreEvents"
						modelVar="storeEvents">
						<liferay-ui:search-container-column-date name="Date-Time"
							value="${storeEvents.getLogged()}" />

						<liferay-ui:search-container-column-text name="Username"
							value="${storeEvents.getUserName()}" />

						<liferay-ui:search-container-column-text name="User ID"
							value="(${storeEvents.getUserId()})" />

						<liferay-ui:search-container-column-text name="Request IP"
							value="${storeEvents.getRequestIp()}" />

						<liferay-ui:search-container-column-text name="Event"
							value="${storeEvents.getEventType()}" />

					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
		<div id="tab-2">
			<div>
				<liferay-ui:search-container
					searchContainer="${displayRegistrationSearchContainer}">
					<liferay-ui:search-container-row
						className="com.liferay.training.amf.eventmonitor.service.model.StoreEvents"
						modelVar="storeEvents">
						<liferay-ui:search-container-column-date name="Date-Time"
							value="${storeEvents.getLogged()}" />

						<liferay-ui:search-container-column-text name="Username"
							value="${storeEvents.getUserName()}" />

						<liferay-ui:search-container-column-text name="User ID"
							value="(${storeEvents.getUserId()})" />

						<liferay-ui:search-container-column-text name="Request IP"
							value="${storeEvents.getRequestIp()}" />

						<liferay-ui:search-container-column-text name="Event"
							value="${storeEvents.getEventType()}" />

					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
		<div id="tab-3" class="tab-pane">
			<div>
				<liferay-ui:search-container
					searchContainer="${displayLoginSearchContainer}">
					<liferay-ui:search-container-row
						className="com.liferay.training.amf.eventmonitor.service.model.StoreEvents"
						modelVar="storeEvents">
						<liferay-ui:search-container-column-date name="Date-Time"
							value="${storeEvents.getLogged()}" />

						<liferay-ui:search-container-column-text name="Username"
							value="${storeEvents.getUserName()}" />

						<liferay-ui:search-container-column-text name="User ID"
							value="(${storeEvents.getUserId()})" />

						<liferay-ui:search-container-column-text name="Request IP"
							value="${storeEvents.getRequestIp()}" />

						<liferay-ui:search-container-column-text name="Event"
							value="${storeEvents.getEventType()}" />

					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>

</div>

<aui:script>
	YUI().use('aui-tabview', function(Y) {
		new Y.TabView({
			srcNode : '#myTab'
		}).render();
	});
</aui:script>