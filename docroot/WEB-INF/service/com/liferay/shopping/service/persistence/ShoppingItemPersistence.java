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

import com.liferay.shopping.model.ShoppingItem;

/**
 * The persistence interface for the shopping item service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ShoppingItemUtil} to access the shopping item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPersistenceImpl
 * @see ShoppingItemUtil
 * @generated
 */
public interface ShoppingItemPersistence extends BasePersistence<ShoppingItem> {
	/**
	* Caches the shopping item in the entity cache if it is enabled.
	*
	* @param shoppingItem the shopping item to cache
	*/
	public void cacheResult(
		com.liferay.shopping.model.ShoppingItem shoppingItem);

	/**
	* Caches the shopping items in the entity cache if it is enabled.
	*
	* @param shoppingItems the shopping items to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.shopping.model.ShoppingItem> shoppingItems);

	/**
	* Creates a new shopping item with the primary key. Does not add the shopping item to the database.
	*
	* @param itemId the primary key for the new shopping item
	* @return the new shopping item
	*/
	public com.liferay.shopping.model.ShoppingItem create(long itemId);

	/**
	* Removes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the shopping item to remove
	* @return the shopping item that was removed
	* @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem remove(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	public com.liferay.shopping.model.ShoppingItem updateImpl(
		com.liferay.shopping.model.ShoppingItem shoppingItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item with the primary key or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param itemId the primary key of the shopping item to find
	* @return the shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByPrimaryKey(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Finds the shopping item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the shopping item to find
	* @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByPrimaryKey(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item where smallImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param smallImageId the small image id to search with
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Finds the shopping item where smallImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param smallImageId the small image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item where smallImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param smallImageId the small image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchBySmallImageId(
		long smallImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item where mediumImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param mediumImageId the medium image id to search with
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByMediumImageId(
		long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Finds the shopping item where mediumImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mediumImageId the medium image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByMediumImageId(
		long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item where mediumImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mediumImageId the medium image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByMediumImageId(
		long mediumImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item where largeImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param largeImageId the large image id to search with
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Finds the shopping item where largeImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param largeImageId the large image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item where largeImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param largeImageId the large image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByLargeImageId(
		long largeImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @return the matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @param start the lower bound of the range of shopping items to return
	* @param end the upper bound of the range of shopping items to return (not inclusive)
	* @return the range of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @param start the lower bound of the range of shopping items to return
	* @param end the upper bound of the range of shopping items to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByG_C_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Finds the last shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByG_C_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Finds the shopping items before and after the current shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the primary key of the current shopping item
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem[] findByG_C_PrevAndNext(
		long itemId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Finds the shopping item where companyId = &#63; and sku = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByC_S(long companyId,
		java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Finds the shopping item where companyId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByC_S(long companyId,
		java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item where companyId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByC_S(long companyId,
		java.lang.String sku, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the shopping items.
	*
	* @return the shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the shopping items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping items to return
	* @param end the upper bound of the range of shopping items to return (not inclusive)
	* @return the range of shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the shopping items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping items to return
	* @param end the upper bound of the range of shopping items to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the shopping item where smallImageId = &#63; from the database.
	*
	* @param smallImageId the small image id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySmallImageId(long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Removes the shopping item where mediumImageId = &#63; from the database.
	*
	* @param mediumImageId the medium image id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMediumImageId(long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Removes the shopping item where largeImageId = &#63; from the database.
	*
	* @param largeImageId the large image id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLargeImageId(long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Removes all the shopping items where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the shopping item where companyId = &#63; and sku = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_S(long companyId, java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Removes all the shopping items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping items where smallImageId = &#63;.
	*
	* @param smallImageId the small image id to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countBySmallImageId(long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping items where mediumImageId = &#63;.
	*
	* @param mediumImageId the medium image id to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countByMediumImageId(long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping items where largeImageId = &#63;.
	*
	* @param largeImageId the large image id to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countByLargeImageId(long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping items where companyId = &#63; and sku = &#63;.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_S(long companyId, java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping items.
	*
	* @return the number of shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the shopping item prices associated with the shopping item.
	*
	* @param pk the primary key of the shopping item to get the associated shopping item prices for
	* @return the shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the shopping item prices associated with the shopping item.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the shopping item to get the associated shopping item prices for
	* @param start the lower bound of the range of shopping items to return
	* @param end the upper bound of the range of shopping items to return (not inclusive)
	* @return the range of shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the shopping item prices associated with the shopping item.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the shopping item to get the associated shopping item prices for
	* @param start the lower bound of the range of shopping items to return
	* @param end the upper bound of the range of shopping items to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of shopping item prices associated with the shopping item.
	*
	* @param pk the primary key of the shopping item to get the number of associated shopping item prices for
	* @return the number of shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public int getShoppingItemPricesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the shopping item price is associated with the shopping item.
	*
	* @param pk the primary key of the shopping item
	* @param shoppingItemPricePK the primary key of the shopping item price
	* @return <code>true</code> if the shopping item price is associated with the shopping item; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsShoppingItemPrice(long pk, long shoppingItemPricePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines if the shopping item has any shopping item prices associated with it.
	*
	* @param pk the primary key of the shopping item to check for associations with shopping item prices
	* @return <code>true</code> if the shopping item has any shopping item prices associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsShoppingItemPrices(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}