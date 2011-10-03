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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the shopping order item local service. This utility wraps {@link com.liferay.shopping.service.impl.ShoppingOrderItemLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.shopping.service.impl.ShoppingOrderItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemLocalService
 * @see com.liferay.shopping.service.base.ShoppingOrderItemLocalServiceBaseImpl
 * @see com.liferay.shopping.service.impl.ShoppingOrderItemLocalServiceImpl
 * @generated
 */
public class ShoppingOrderItemLocalServiceUtil {
	/**
	* Adds the shopping order item to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the shopping order item to add
	* @return the shopping order item that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem addShoppingOrderItem(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addShoppingOrderItem(shoppingOrderItem);
	}

	/**
	* Creates a new shopping order item with the primary key. Does not add the shopping order item to the database.
	*
	* @param orderItemId the primary key for the new shopping order item
	* @return the new shopping order item
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem createShoppingOrderItem(
		long orderItemId) {
		return getService().createShoppingOrderItem(orderItemId);
	}

	/**
	* Deletes the shopping order item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderItemId the primary key of the shopping order item to delete
	* @throws PortalException if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingOrderItem(long orderItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingOrderItem(orderItemId);
	}

	/**
	* Deletes the shopping order item from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the shopping order item to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingOrderItem(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingOrderItem(shoppingOrderItem);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the shopping order item with the primary key.
	*
	* @param orderItemId the primary key of the shopping order item to get
	* @return the shopping order item
	* @throws PortalException if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem getShoppingOrderItem(
		long orderItemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingOrderItem(orderItemId);
	}

	/**
	* Gets a range of all the shopping order items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping order items to return
	* @param end the upper bound of the range of shopping order items to return (not inclusive)
	* @return the range of shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingOrderItem> getShoppingOrderItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingOrderItems(start, end);
	}

	/**
	* Gets the number of shopping order items.
	*
	* @return the number of shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static int getShoppingOrderItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingOrderItemsCount();
	}

	/**
	* Updates the shopping order item in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the shopping order item to update
	* @return the shopping order item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem updateShoppingOrderItem(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingOrderItem(shoppingOrderItem);
	}

	/**
	* Updates the shopping order item in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingOrderItem the shopping order item to update
	* @param merge whether to merge the shopping order item with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping order item that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem updateShoppingOrderItem(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingOrderItem(shoppingOrderItem, merge);
	}

	public static java.util.List<com.liferay.shopping.model.ShoppingOrderItem> getOrderItems(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOrderItems(orderId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ShoppingOrderItemLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ShoppingOrderItemLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ShoppingOrderItemLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ShoppingOrderItemLocalService service) {
		_service = service;
	}

	private static ShoppingOrderItemLocalService _service;
}