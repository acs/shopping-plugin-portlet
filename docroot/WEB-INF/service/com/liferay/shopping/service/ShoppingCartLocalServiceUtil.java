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
 * The utility for the shopping cart local service. This utility wraps {@link com.liferay.shopping.service.impl.ShoppingCartLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.shopping.service.impl.ShoppingCartLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingCartLocalService
 * @see com.liferay.shopping.service.base.ShoppingCartLocalServiceBaseImpl
 * @see com.liferay.shopping.service.impl.ShoppingCartLocalServiceImpl
 * @generated
 */
public class ShoppingCartLocalServiceUtil {
	/**
	* Adds the shopping cart to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCart the shopping cart to add
	* @return the shopping cart that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingCart addShoppingCart(
		com.liferay.shopping.model.ShoppingCart shoppingCart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addShoppingCart(shoppingCart);
	}

	/**
	* Creates a new shopping cart with the primary key. Does not add the shopping cart to the database.
	*
	* @param cartId the primary key for the new shopping cart
	* @return the new shopping cart
	*/
	public static com.liferay.shopping.model.ShoppingCart createShoppingCart(
		long cartId) {
		return getService().createShoppingCart(cartId);
	}

	/**
	* Deletes the shopping cart with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cartId the primary key of the shopping cart to delete
	* @throws PortalException if a shopping cart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingCart(long cartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingCart(cartId);
	}

	/**
	* Deletes the shopping cart from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCart the shopping cart to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingCart(
		com.liferay.shopping.model.ShoppingCart shoppingCart)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingCart(shoppingCart);
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
	* Gets the shopping cart with the primary key.
	*
	* @param cartId the primary key of the shopping cart to get
	* @return the shopping cart
	* @throws PortalException if a shopping cart with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingCart getShoppingCart(
		long cartId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCart(cartId);
	}

	/**
	* Gets a range of all the shopping carts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping carts to return
	* @param end the upper bound of the range of shopping carts to return (not inclusive)
	* @return the range of shopping carts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingCart> getShoppingCarts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCarts(start, end);
	}

	/**
	* Gets the number of shopping carts.
	*
	* @return the number of shopping carts
	* @throws SystemException if a system exception occurred
	*/
	public static int getShoppingCartsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingCartsCount();
	}

	/**
	* Updates the shopping cart in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCart the shopping cart to update
	* @return the shopping cart that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingCart updateShoppingCart(
		com.liferay.shopping.model.ShoppingCart shoppingCart)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingCart(shoppingCart);
	}

	/**
	* Updates the shopping cart in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCart the shopping cart to update
	* @param merge whether to merge the shopping cart with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping cart that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingCart updateShoppingCart(
		com.liferay.shopping.model.ShoppingCart shoppingCart, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingCart(shoppingCart, merge);
	}

	public static void deleteGroupCarts(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteGroupCarts(groupId);
	}

	public static void deleteUserCarts(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserCarts(userId);
	}

	public static com.liferay.shopping.model.ShoppingCart getCart(long userId,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCart(userId, groupId);
	}

	public static java.util.Map<com.liferay.shopping.model.ShoppingCartItem, java.lang.Integer> getItems(
		long groupId, java.lang.String itemIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItems(groupId, itemIds);
	}

	public static com.liferay.shopping.model.ShoppingCart updateCart(
		long userId, long groupId, java.lang.String itemIds,
		java.lang.String couponCodes, int altShipping, boolean insure)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCart(userId, groupId, itemIds, couponCodes,
			altShipping, insure);
	}

	public static void clearService() {
		_service = null;
	}

	public static ShoppingCartLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ShoppingCartLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ShoppingCartLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ShoppingCartLocalService service) {
		_service = service;
	}

	private static ShoppingCartLocalService _service;
}