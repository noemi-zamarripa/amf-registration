/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.registration.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Registration. This utility wraps
 * {@link com.liferay.training.amf.registration.service.impl.RegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLocalService
 * @see com.liferay.training.amf.registration.service.base.RegistrationLocalServiceBaseImpl
 * @see com.liferay.training.amf.registration.service.impl.RegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class RegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.registration.service.impl.RegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addingAddressInfo(long uid, String address1,
		String address2, String city, String zip, String state) {
		getService().addingAddressInfo(uid, address1, address2, city, zip, state);
	}

	public static void addingBasicInfo(String password1, String password2,
		String username, String emailAddress, String firstname,
		String lastname, boolean isMale, int month, int day, int year,
		java.util.Locale locale) {
		getService()
			.addingBasicInfo(password1, password2, username, emailAddress,
			firstname, lastname, isMale, month, day, year, locale);
	}

	public static void addingPhoneInfo(long uid, String phoneNumber,
		boolean home) {
		getService().addingPhoneInfo(uid, phoneNumber, home);
	}

	public static void addingSecurityInfo(long uid, String question,
		String answer, boolean tou) {
		getService().addingSecurityInfo(uid, question, answer, tou);
	}

	/**
	* Adds the registration to the database. Also notifies the appropriate model listeners.
	*
	* @param registration the registration
	* @return the registration that was added
	*/
	public static com.liferay.training.amf.registration.model.Registration addRegistration(
		com.liferay.training.amf.registration.model.Registration registration) {
		return getService().addRegistration(registration);
	}

	/**
	* Creates a new registration with the primary key. Does not add the registration to the database.
	*
	* @param userID the primary key for the new registration
	* @return the new registration
	*/
	public static com.liferay.training.amf.registration.model.Registration createRegistration(
		long userID) {
		return getService().createRegistration(userID);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	/**
	* Deletes the registration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userID the primary key of the registration
	* @return the registration that was removed
	* @throws PortalException if a registration with the primary key could not be found
	*/
	public static com.liferay.training.amf.registration.model.Registration deleteRegistration(
		long userID) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteRegistration(userID);
	}

	/**
	* Deletes the registration from the database. Also notifies the appropriate model listeners.
	*
	* @param registration the registration
	* @return the registration that was removed
	*/
	public static com.liferay.training.amf.registration.model.Registration deleteRegistration(
		com.liferay.training.amf.registration.model.Registration registration) {
		return getService().deleteRegistration(registration);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.registration.model.impl.RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.registration.model.impl.RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.training.amf.registration.model.Registration fetchRegistration(
		long userID) {
		return getService().fetchRegistration(userID);
	}

	/**
	* Returns the registration matching the UUID and group.
	*
	* @param uuid the registration's UUID
	* @param groupId the primary key of the group
	* @return the matching registration, or <code>null</code> if a matching registration could not be found
	*/
	public static com.liferay.training.amf.registration.model.Registration fetchRegistrationByUuidAndGroupId(
		String uuid, long groupId) {
		return getService().fetchRegistrationByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static long getRegionID(String state)
		throws com.liferay.portal.kernel.exception.NoSuchRegionException {
		return getService().getRegionID(state);
	}

	/**
	* Returns the registration with the primary key.
	*
	* @param userID the primary key of the registration
	* @return the registration
	* @throws PortalException if a registration with the primary key could not be found
	*/
	public static com.liferay.training.amf.registration.model.Registration getRegistration(
		long userID) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRegistration(userID);
	}

	/**
	* Returns the registration matching the UUID and group.
	*
	* @param uuid the registration's UUID
	* @param groupId the primary key of the group
	* @return the matching registration
	* @throws PortalException if a matching registration could not be found
	*/
	public static com.liferay.training.amf.registration.model.Registration getRegistrationByUuidAndGroupId(
		String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getRegistrationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the registrations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.registration.model.impl.RegistrationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of registrations
	* @param end the upper bound of the range of registrations (not inclusive)
	* @return the range of registrations
	*/
	public static java.util.List<com.liferay.training.amf.registration.model.Registration> getRegistrations(
		int start, int end) {
		return getService().getRegistrations(start, end);
	}

	/**
	* Returns the number of registrations.
	*
	* @return the number of registrations
	*/
	public static int getRegistrationsCount() {
		return getService().getRegistrationsCount();
	}

	public static long getUserId(String username, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getUserId(username, companyId);
	}

	/**
	* Updates the registration in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param registration the registration
	* @return the registration that was updated
	*/
	public static com.liferay.training.amf.registration.model.Registration updateRegistration(
		com.liferay.training.amf.registration.model.Registration registration) {
		return getService().updateRegistration(registration);
	}

	public static RegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistrationLocalService, RegistrationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RegistrationLocalService.class);

		ServiceTracker<RegistrationLocalService, RegistrationLocalService> serviceTracker =
			new ServiceTracker<RegistrationLocalService, RegistrationLocalService>(bundle.getBundleContext(),
				RegistrationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}