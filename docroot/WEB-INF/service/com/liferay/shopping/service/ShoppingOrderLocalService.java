/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.shopping.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the shopping order local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderLocalServiceUtil
 * @see com.liferay.shopping.service.base.ShoppingOrderLocalServiceBaseImpl
 * @see com.liferay.shopping.service.impl.ShoppingOrderLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ShoppingOrderLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingOrderLocalServiceUtil} to access the shopping order local service. Add custom service methods to {@link com.liferay.shopping.service.impl.ShoppingOrderLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the shopping order to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the shopping order
	* @return the shopping order that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingOrder addShoppingOrder(
		com.liferay.shopping.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new shopping order with the primary key. Does not add the shopping order to the database.
	*
	* @param orderId the primary key for the new shopping order
	* @return the new shopping order
	*/
	public com.liferay.shopping.model.ShoppingOrder createShoppingOrder(
		long orderId);

	/**
	* Deletes the shopping order with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderId the primary key of the shopping order
	* @throws PortalException if a shopping order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingOrder(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the shopping order from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the shopping order
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingOrder(
		com.liferay.shopping.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping order with the primary key.
	*
	* @param orderId the primary key of the shopping order
	* @return the shopping order
	* @throws PortalException if a shopping order with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.shopping.model.ShoppingOrder getShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shopping orders.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping orders
	* @param end the upper bound of the range of shopping orders (not inclusive)
	* @return the range of shopping orders
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.shopping.model.ShoppingOrder> getShoppingOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping orders.
	*
	* @return the number of shopping orders
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getShoppingOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the shopping order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the shopping order
	* @return the shopping order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingOrder updateShoppingOrder(
		com.liferay.shopping.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the shopping order in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrder the shopping order
	* @param merge whether to merge the shopping order with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping order that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingOrder updateShoppingOrder(
		com.liferay.shopping.model.ShoppingOrder shoppingOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public com.liferay.shopping.model.ShoppingOrder addLatestOrder(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void completeOrder(java.lang.String number,
		java.lang.String ppTxnId, java.lang.String ppPaymentStatus,
		double ppPaymentGross, java.lang.String ppReceiverEmail,
		java.lang.String ppPayerEmail, boolean updateInventory)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteOrder(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteOrder(com.liferay.shopping.model.ShoppingOrder order)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void deleteOrders(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.shopping.model.ShoppingOrder getLatestOrder(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.shopping.model.ShoppingOrder getOrder(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.shopping.model.ShoppingOrder getOrder(
		java.lang.String number)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.shopping.model.ShoppingOrder getPayPalTxnIdOrder(
		java.lang.String ppTxnId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.shopping.model.ShoppingOrder saveLatestOrder(
		com.liferay.shopping.model.ShoppingCart cart)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.shopping.model.ShoppingOrder> search(
		long groupId, long companyId, long userId, java.lang.String number,
		java.lang.String billingFirstName, java.lang.String billingLastName,
		java.lang.String billingEmailAddress,
		java.lang.String shippingFirstName, java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String ppPaymentStatus, boolean andOperator, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int searchCount(long groupId, long companyId, long userId,
		java.lang.String number, java.lang.String billingFirstName,
		java.lang.String billingLastName, java.lang.String billingEmailAddress,
		java.lang.String shippingFirstName, java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String ppPaymentStatus, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void sendEmail(long orderId, java.lang.String emailType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public void sendEmail(com.liferay.shopping.model.ShoppingOrder order,
		java.lang.String emailType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.shopping.model.ShoppingOrder updateLatestOrder(
		long userId, long groupId, java.lang.String billingFirstName,
		java.lang.String billingLastName, java.lang.String billingEmailAddress,
		java.lang.String billingCompany, java.lang.String billingStreet,
		java.lang.String billingCity, java.lang.String billingState,
		java.lang.String billingZip, java.lang.String billingCountry,
		java.lang.String billingPhone, boolean shipToBilling,
		java.lang.String shippingFirstName, java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String shippingCompany, java.lang.String shippingStreet,
		java.lang.String shippingCity, java.lang.String shippingState,
		java.lang.String shippingZip, java.lang.String shippingCountry,
		java.lang.String shippingPhone, java.lang.String ccName,
		java.lang.String ccType, java.lang.String ccNumber, int ccExpMonth,
		int ccExpYear, java.lang.String ccVerNumber, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.shopping.model.ShoppingOrder updateOrder(long orderId,
		java.lang.String ppTxnId, java.lang.String ppPaymentStatus,
		double ppPaymentGross, java.lang.String ppReceiverEmail,
		java.lang.String ppPayerEmail)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.shopping.model.ShoppingOrder updateOrder(long orderId,
		java.lang.String billingFirstName, java.lang.String billingLastName,
		java.lang.String billingEmailAddress, java.lang.String billingCompany,
		java.lang.String billingStreet, java.lang.String billingCity,
		java.lang.String billingState, java.lang.String billingZip,
		java.lang.String billingCountry, java.lang.String billingPhone,
		boolean shipToBilling, java.lang.String shippingFirstName,
		java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String shippingCompany, java.lang.String shippingStreet,
		java.lang.String shippingCity, java.lang.String shippingState,
		java.lang.String shippingZip, java.lang.String shippingCountry,
		java.lang.String shippingPhone, java.lang.String ccName,
		java.lang.String ccType, java.lang.String ccNumber, int ccExpMonth,
		int ccExpYear, java.lang.String ccVerNumber, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;
}