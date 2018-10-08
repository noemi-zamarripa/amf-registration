package com.liferay.training.amf.eventmonitor.service.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.training.amf.eventmonitor.service.model.StoreEvents;
import com.liferay.training.amf.eventmonitor.service.model.impl.StoreEventsImpl;
import com.liferay.training.amf.eventmonitor.service.service.persistence.StoreEventsFinder;
import java.util.List;

public class StoreEventsFinderImpl extends StoreEventsFinderBaseImpl implements StoreEventsFinder{
	
	@SuppressWarnings("unchecked")
	public List<StoreEvents> findByEventType(String eventType){
		Session session = null;
		
		session = openSession();
		String sql = null;
		
		if (eventType.equals("All")) {
			sql = "SELECT * FROM eventmonitor_storeevents WHERE eventType is not null ORDER BY logged desc"; 
		}else if (eventType.equals("Registration")) {
			sql = "SELECT * FROM eventmonitor_storeevents WHERE eventType = 'Registration' ORDER BY logged desc";
		}else {
			sql = "SELECT * FROM eventmonitor_storeevents WHERE eventType = 'Login' ORDER BY logged desc";
		}
		
		SQLQuery q = session.createSQLQuery(sql);
		q.setCacheable(false);
		q.addEntity("StoreEvent_Event", StoreEventsImpl.class);
		
		return (List<StoreEvents>)q.list();
		
	}
}
