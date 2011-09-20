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

package com.liferay.shopping.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.shopping.model.ShoppingOrderItem;

import java.util.List;

/**
 * The persistence utility for the shopping order item service. This utility wraps {@link ShoppingOrderItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemPersistence
 * @see ShoppingOrderItemPersistenceImpl
 * @generated
 */
public class ShoppingOrderItemUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ShoppingOrderItem shoppingOrderItem) {
		getPersistence().clearCache(shoppingOrderItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShoppingOrderItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ShoppingOrderItem remove(ShoppingOrderItem shoppingOrderItem)
		throws SystemException {
		return getPersistence().remove(shoppingOrderItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ShoppingOrderItem update(
		ShoppingOrderItem shoppingOrderItem, boolean merge)
		throws SystemException {
		return getPersistence().update(shoppingOrderItem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ShoppingOrderItem update(
		ShoppingOrderItem shoppingOrderItem, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(shoppingOrderItem, merge, serviceContext);
	}

	/**
	* Caches the shopping order item in the entity cache if it is enabled.
	*
	* @param shoppingOrderItem the shopping order item
	*/
	public static void cacheResult(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem) {
		getPersistence().cacheResult(shoppingOrderItem);
	}

	/**
	* Caches the shopping order items in the entity cache if it is enabled.
	*
	* @param shoppingOrderItems the shopping order items
	*/
	public static void cacheResult(
		java.util.List<com.liferay.shopping.model.ShoppingOrderItem> shoppingOrderItems) {
		getPersistence().cacheResult(shoppingOrderItems);
	}

	/**
	* Creates a new shopping order item with the primary key. Does not add the shopping order item to the database.
	*
	* @param orderItemId the primary key for the new shopping order item
	* @return the new shopping order item
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem create(
		long orderItemId) {
		return getPersistence().create(orderItemId);
	}

	/**
	* Removes the shopping order item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderItemId the primary key of the shopping order item
	* @return the shopping order item that was removed
	* @throws com.liferay.shopping.NoSuchOrderItemException if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem remove(
		long orderItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException {
		return getPersistence().remove(orderItemId);
	}

	public static com.liferay.shopping.model.ShoppingOrderItem updateImpl(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shoppingOrderItem, merge);
	}

	/**
	* Returns the shopping order item with the primary key or throws a {@link com.liferay.shopping.NoSuchOrderItemException} if it could not be found.
	*
	* @param orderItemId the primary key of the shopping order item
	* @return the shopping order item
	* @throws com.liferay.shopping.NoSuchOrderItemException if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem findByPrimaryKey(
		long orderItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException {
		return getPersistence().findByPrimaryKey(orderItemId);
	}

	/**
	* Returns the shopping order item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderItemId the primary key of the shopping order item
	* @return the shopping order item, or <code>null</code> if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem fetchByPrimaryKey(
		long orderItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(orderItemId);
	}

	/**
	* Returns all the shopping order items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findByOrderId(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrderId(orderId);
	}

	/**
	* Returns a range of all the shopping order items where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of shopping order items
	* @param end the upper bound of the range of shopping order items (not inclusive)
	* @return the range of matching shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findByOrderId(
		long orderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByOrderId(orderId, start, end);
	}

	/**
	* Returns an ordered range of all the shopping order items where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orderId the order ID
	* @param start the lower bound of the range of shopping order items
	* @param end the upper bound of the range of shopping order items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findByOrderId(
		long orderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByOrderId(orderId, start, end, orderByComparator);
	}

	/**
	* Returns the first shopping order item in the ordered set where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching shopping order item
	* @throws com.liferay.shopping.NoSuchOrderItemException if a matching shopping order item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem findByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException {
		return getPersistence().findByOrderId_First(orderId, orderByComparator);
	}

	/**
	* Returns the last shopping order item in the ordered set where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching shopping order item
	* @throws com.liferay.shopping.NoSuchOrderItemException if a matching shopping order item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem findByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException {
		return getPersistence().findByOrderId_Last(orderId, orderByComparator);
	}

	/**
	* Returns the shopping order items before and after the current shopping order item in the ordered set where orderId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param orderItemId the primary key of the current shopping order item
	* @param orderId the order ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next shopping order item
	* @throws com.liferay.shopping.NoSuchOrderItemException if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingOrderItem[] findByOrderId_PrevAndNext(
		long orderItemId, long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException {
		return getPersistence()
				   .findByOrderId_PrevAndNext(orderItemId, orderId,
			orderByComparator);
	}

	/**
	* Returns all the shopping order items.
	*
	* @return the shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the shopping order items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping order items
	* @param end the upper bound of the range of shopping order items (not inclusive)
	* @return the range of shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the shopping order items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping order items
	* @param end the upper bound of the range of shopping order items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the shopping order items where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByOrderId(orderId);
	}

	/**
	* Removes all the shopping order items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of shopping order items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByOrderId(orderId);
	}

	/**
	* Returns the number of shopping order items.
	*
	* @return the number of shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ShoppingOrderItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShoppingOrderItemPersistence)PortletBeanLocatorUtil.locate(com.liferay.shopping.service.ClpSerializer.getServletContextName(),
					ShoppingOrderItemPersistence.class.getName());

			ReferenceRegistry.registerReference(ShoppingOrderItemUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ShoppingOrderItemPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ShoppingOrderItemUtil.class,
			"_persistence");
	}

	private static ShoppingOrderItemPersistence _persistence;
}