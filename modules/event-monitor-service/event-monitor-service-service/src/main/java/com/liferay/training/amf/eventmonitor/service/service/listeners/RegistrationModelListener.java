package com.liferay.training.amf.eventmonitor.service.service.listeners;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;
import com.liferay.training.amf.eventmonitor.service.service.StoreEventsLocalService;

import java.util.Random;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

@Component(
		immediate = true,
		service = ModelListener.class
	)

public class RegistrationModelListener extends BaseModelListener<User>{
	
	@Override
	public void onAfterCreate(User user) throws ModelListenerException{
		
		Random r = new Random();
		
		StoreEvents se = _storeEventsLocalService.createStoreEvents(r.nextLong());
		se.setLogged(user.getCreateDate());
		se.setUserName(user.getScreenName());
		se.setUserId(user.getUserId());
		se.setRequestIp("0.0.0.0");
		se.setEventType("Registration");
		
		_storeEventsLocalService.addStoreEvents(se);
		
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected StoreEventsLocalService _storeEventsLocalService;
}
