package com.liferay.training.admin.monitor.service.listener;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.training.admin.monitor.model.StoreEvents;
import com.liferay.training.admin.monitor.service.StoreEventsLocalService;

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
		
		// move this logic into method in localServiceImpl and assign an id that links the two tables
		// rather than using a random one
		
		String counterName = "storeEventCounter";
		CounterLocalServiceUtil.createCounter(counterName);
		
		StoreEvents storeEvent = _storeEventsLocalService.createStoreEvents(CounterLocalServiceUtil.increment(counterName));
		_storeEventsLocalService.setEventFields(user, storeEvent, "Registration");
		
	}
	
	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected StoreEventsLocalService _storeEventsLocalService;
}
