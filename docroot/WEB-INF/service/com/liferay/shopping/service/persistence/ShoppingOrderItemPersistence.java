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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.shopping.model.ShoppingOrderItem;

/**
 * The persistence interface for the shopping order item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingOrderItemPersistenceImpl
 * @see ShoppingOrderItemUtil
 * @generated
 */
public interface ShoppingOrderItemPersistence extends BasePersistence<ShoppingOrderItem> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingOrderItemUtil} to access the shopping order item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the shopping order item in the entity cache if it is enabled.
	*
	* @param shoppingOrderItem the shopping order item
	*/
	public void cacheResult(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem);

	/**
	* Caches the shopping order items in the entity cache if it is enabled.
	*
	* @param shoppingOrderItems the shopping order items
	*/
	public void cacheResult(
		java.util.List<com.liferay.shopping.model.ShoppingOrderItem> shoppingOrderItems);

	/**
	* Creates a new shopping order item with the primary key. Does not add the shopping order item to the database.
	*
	* @param orderItemId the primary key for the new shopping order item
	* @return the new shopping order item
	*/
	public com.liferay.shopping.model.ShoppingOrderItem create(long orderItemId);

	/**
	* Removes the shopping order item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orderItemId the primary key of the shopping order item
	* @return the shopping order item that was removed
	* @throws com.liferay.shopping.NoSuchOrderItemException if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingOrderItem remove(long orderItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException;

	public com.liferay.shopping.model.ShoppingOrderItem updateImpl(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping order item with the primary key or throws a {@link com.liferay.shopping.NoSuchOrderItemException} if it could not be found.
	*
	* @param orderItemId the primary key of the shopping order item
	* @return the shopping order item
	* @throws com.liferay.shopping.NoSuchOrderItemException if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingOrderItem findByPrimaryKey(
		long orderItemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException;

	/**
	* Returns the shopping order item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orderItemId the primary key of the shopping order item
	* @return the shopping order item, or <code>null</code> if a shopping order item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingOrderItem fetchByPrimaryKey(
		long orderItemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shopping order items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the matching shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findByOrderId(
		long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findByOrderId(
		long orderId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findByOrderId(
		long orderId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.shopping.model.ShoppingOrderItem findByOrderId_First(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException;

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
	public com.liferay.shopping.model.ShoppingOrderItem findByOrderId_Last(
		long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException;

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
	public com.liferay.shopping.model.ShoppingOrderItem[] findByOrderId_PrevAndNext(
		long orderItemId, long orderId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchOrderItemException;

	/**
	* Returns all the shopping order items.
	*
	* @return the shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.shopping.model.ShoppingOrderItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping order items where orderId = &#63; from the database.
	*
	* @param orderId the order ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping order items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping order items where orderId = &#63;.
	*
	* @param orderId the order ID
	* @return the number of matching shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public int countByOrderId(long orderId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping order items.
	*
	* @return the number of shopping order items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	public ShoppingOrderItem remove(ShoppingOrderItem shoppingOrderItem)
		throws SystemException;
}