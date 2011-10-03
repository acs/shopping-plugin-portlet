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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.shopping.model.ShoppingItemPrice;

/**
 * The persistence interface for the shopping item price service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ShoppingItemPriceUtil} to access the shopping item price persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPricePersistenceImpl
 * @see ShoppingItemPriceUtil
 * @generated
 */
public interface ShoppingItemPricePersistence extends BasePersistence<ShoppingItemPrice> {
	/**
	* Caches the shopping item price in the entity cache if it is enabled.
	*
	* @param shoppingItemPrice the shopping item price to cache
	*/
	public void cacheResult(
		com.liferay.shopping.model.ShoppingItemPrice shoppingItemPrice);

	/**
	* Caches the shopping item prices in the entity cache if it is enabled.
	*
	* @param shoppingItemPrices the shopping item prices to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.shopping.model.ShoppingItemPrice> shoppingItemPrices);

	/**
	* Creates a new shopping item price with the primary key. Does not add the shopping item price to the database.
	*
	* @param itemPriceId the primary key for the new shopping item price
	* @return the new shopping item price
	*/
	public com.liferay.shopping.model.ShoppingItemPrice create(long itemPriceId);

	/**
	* Removes the shopping item price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemPriceId the primary key of the shopping item price to remove
	* @return the shopping item price that was removed
	* @throws com.liferay.shopping.NoSuchItemPriceException if a shopping item price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemPrice remove(long itemPriceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemPriceException;

	public com.liferay.shopping.model.ShoppingItemPrice updateImpl(
		com.liferay.shopping.model.ShoppingItemPrice shoppingItemPrice,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item price with the primary key or throws a {@link com.liferay.shopping.NoSuchItemPriceException} if it could not be found.
	*
	* @param itemPriceId the primary key of the shopping item price to find
	* @return the shopping item price
	* @throws com.liferay.shopping.NoSuchItemPriceException if a shopping item price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemPrice findByPrimaryKey(
		long itemPriceId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemPriceException;

	/**
	* Finds the shopping item price with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemPriceId the primary key of the shopping item price to find
	* @return the shopping item price, or <code>null</code> if a shopping item price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemPrice fetchByPrimaryKey(
		long itemPriceId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the shopping item prices where itemId = &#63;.
	*
	* @param itemId the item id to search with
	* @return the matching shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> findByItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the shopping item prices where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the item id to search with
	* @param start the lower bound of the range of shopping item prices to return
	* @param end the upper bound of the range of shopping item prices to return (not inclusive)
	* @return the range of matching shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> findByItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the shopping item prices where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the item id to search with
	* @param start the lower bound of the range of shopping item prices to return
	* @param end the upper bound of the range of shopping item prices to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> findByItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first shopping item price in the ordered set where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the item id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching shopping item price
	* @throws com.liferay.shopping.NoSuchItemPriceException if a matching shopping item price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemPrice findByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemPriceException;

	/**
	* Finds the last shopping item price in the ordered set where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the item id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching shopping item price
	* @throws com.liferay.shopping.NoSuchItemPriceException if a matching shopping item price could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemPrice findByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemPriceException;

	/**
	* Finds the shopping item prices before and after the current shopping item price in the ordered set where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemPriceId the primary key of the current shopping item price
	* @param itemId the item id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next shopping item price
	* @throws com.liferay.shopping.NoSuchItemPriceException if a shopping item price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemPrice[] findByItemId_PrevAndNext(
		long itemPriceId, long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemPriceException;

	/**
	* Finds all the shopping item prices.
	*
	* @return the shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the shopping item prices.
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
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the shopping item prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping item prices to return
	* @param end the upper bound of the range of shopping item prices to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping item prices where itemId = &#63; from the database.
	*
	* @param itemId the item id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping item prices from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping item prices where itemId = &#63;.
	*
	* @param itemId the item id to search with
	* @return the number of matching shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping item prices.
	*
	* @return the number of shopping item prices
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}