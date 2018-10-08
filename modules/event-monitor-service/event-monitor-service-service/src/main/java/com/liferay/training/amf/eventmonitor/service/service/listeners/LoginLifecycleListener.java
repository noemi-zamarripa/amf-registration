package com.liferay.training.amf.eventmonitor.service.service.listeners;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Randomizer;
import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;
import com.liferay.training.amf.eventmonitor.service.service.StoreEventsLocalService;

import java.text.SimpleDateFormat;
import java.util.Random;

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
			Random r = new Random();
			
			StoreEvents se = _storeEventsLocalService.createStoreEvents(r.nextLong());
			se.setLogged(user.getLoginDate());
			se.setUserName(user.getScreenName());
			se.setUserId(user.getUserId());
			se.setRequestIp(user.getLoginIP());
			se.setEventType("Login");
			
			_storeEventsLocalService.addStoreEvents(se);
			
		} catch (PortalException e) {
			_log.error("Invalid request, user not found.");
			
		}
		
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected StoreEventsLocalService _storeEventsLocalService;

}
