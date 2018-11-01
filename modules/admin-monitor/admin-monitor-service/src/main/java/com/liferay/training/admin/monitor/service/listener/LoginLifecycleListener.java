package com.liferay.training.admin.monitor.service.listener;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.training.admin.monitor.model.StoreEvents;
import com.liferay.training.admin.monitor.service.StoreEventsLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(
		immediate = true, 
		property = {"key=login.events.post"},
		service = LifecycleAction.class
		)

public class LoginLifecycleListener implements LifecycleAction{

	private static Log _log = LogFactoryUtil.getLog(LoginLifecycleListener.class);

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		
		try {
			User user = PortalUtil.getUser(lifecycleEvent.getRequest());
			String counterName = "storeEventCounter";
			CounterLocalServiceUtil.createCounter(counterName);
			
			StoreEvents storeEvent = _storeEventsLocalService.createStoreEvents(CounterLocalServiceUtil.increment(counterName));
			_storeEventsLocalService.setEventFields(user, storeEvent, "Login");
			
		} catch (PortalException pe) {
			_log.error("invalid-request-user-not-found");
			
		}
		
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected StoreEventsLocalService _storeEventsLocalService;

}
