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
 * The utility for the shopping item price local service. This utility wraps {@link com.liferay.shopping.service.impl.ShoppingItemPriceLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.shopping.service.impl.ShoppingItemPriceLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPriceLocalService
 * @see com.liferay.shopping.service.base.ShoppingItemPriceLocalServiceBaseImpl
 * @see com.liferay.shopping.service.impl.ShoppingItemPriceLocalServiceImpl
 * @generated
 */
public class ShoppingItemPriceLocalServiceUtil {
	/**
	* Adds the shopping item price to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemPrice the shopping item price to add
	* @return the shopping item price that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItemPrice addShoppingItemPrice(
		com.liferay.shopping.model.ShoppingItemPrice shoppingItemPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addShoppingItemPrice(shoppingItemPrice);
	}

	/**
	* Creates a new shopping item price with the primary key. Does not add the shopping item price to the database.
	*
	* @param itemPriceId the primary key for the new shopping item price
	* @return the new shopping item price
	*/
	public static com.liferay.shopping.model.ShoppingItemPrice createShoppingItemPrice(
		long itemPriceId) {
		return getService().createShoppingItemPrice(itemPriceId);
	}

	/**
	* Deletes the shopping item price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemPriceId the primary key of the shopping item price to delete
	* @throws PortalException if a shopping item price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingItemPrice(long itemPriceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingItemPrice(itemPriceId);
	}

	/**
	* Deletes the shopping item price from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemPrice the shopping item price to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingItemPrice(
		com.liferay.shopping.model.ShoppingItemPrice shoppingItemPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingItemPrice(shoppingItemPrice);
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
	* Gets the shopping item price with the primary key.
	*
	* @param itemPriceId the primary key of the shopping item price to get
	* @return the shopping item price
	* @throws PortalException if a shopping item price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItemPrice getShoppingItemPrice(
		long itemPriceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingItemPrice(itemPriceId);
	}

	/**
	* Gets a range of all the shopping item prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping item prices to return
	* @param end the upper bound of the range of shopping item prices to return (not inclusive)
	* @return the range of shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingItemPrices(start, end);
	}

	/**
	* Gets the number of shopping item prices.
	*
	* @return the number of shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public static int getShoppingItemPricesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingItemPricesCount();
	}

	/**
	* Updates the shopping item price in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemPrice the shopping item price to update
	* @return the shopping item price that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItemPrice updateShoppingItemPrice(
		com.liferay.shopping.model.ShoppingItemPrice shoppingItemPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingItemPrice(shoppingItemPrice);
	}

	/**
	* Updates the shopping item price in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemPrice the shopping item price to update
	* @param merge whether to merge the shopping item price with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping item price that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItemPrice updateShoppingItemPrice(
		com.liferay.shopping.model.ShoppingItemPrice shoppingItemPrice,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingItemPrice(shoppingItemPrice, merge);
	}

	public static java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getItemPrices(
		long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemPrices(itemId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ShoppingItemPriceLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ShoppingItemPriceLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ShoppingItemPriceLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ShoppingItemPriceLocalService service) {
		_service = service;
	}

	private static ShoppingItemPriceLocalService _service;
}