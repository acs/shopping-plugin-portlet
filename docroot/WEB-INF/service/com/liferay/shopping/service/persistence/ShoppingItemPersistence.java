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

import com.liferay.shopping.model.ShoppingItem;

/**
 * The persistence interface for the shopping item service.
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
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ShoppingItemUtil} to access the shopping item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the shopping item in the entity cache if it is enabled.
	*
	* @param shoppingItem the shopping item
	*/
	public void cacheResult(
		com.liferay.shopping.model.ShoppingItem shoppingItem);

	/**
	* Caches the shopping items in the entity cache if it is enabled.
	*
	* @param shoppingItems the shopping items
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
	* @param itemId the primary key of the shopping item
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
	* Returns the shopping item with the primary key or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param itemId the primary key of the shopping item
	* @return the shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByPrimaryKey(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Returns the shopping item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the shopping item
	* @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByPrimaryKey(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping item where smallImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param smallImageId the small image ID
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Returns the shopping item where smallImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param smallImageId the small image ID
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping item where smallImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param smallImageId the small image ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchBySmallImageId(
		long smallImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping item where mediumImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param mediumImageId the medium image ID
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByMediumImageId(
		long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Returns the shopping item where mediumImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mediumImageId the medium image ID
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByMediumImageId(
		long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping item where mediumImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mediumImageId the medium image ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByMediumImageId(
		long mediumImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping item where largeImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param largeImageId the large image ID
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Returns the shopping item where largeImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param largeImageId the large image ID
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping item where largeImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param largeImageId the large image ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByLargeImageId(
		long largeImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of shopping items
	* @param end the upper bound of the range of shopping items (not inclusive)
	* @return the range of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of shopping items
	* @param end the upper bound of the range of shopping items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
	* Returns the last shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
	* Returns the shopping items before and after the current shopping item in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the primary key of the current shopping item
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
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
	* Returns the shopping item where companyId = &#63; and sku = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param companyId the company ID
	* @param sku the sku
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem findByC_S(long companyId,
		java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Returns the shopping item where companyId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param sku the sku
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByC_S(long companyId,
		java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the shopping item where companyId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param sku the sku
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItem fetchByC_S(long companyId,
		java.lang.String sku, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shopping items.
	*
	* @return the shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shopping items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping items
	* @param end the upper bound of the range of shopping items (not inclusive)
	* @return the range of shopping items
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shopping items.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping items
	* @param end the upper bound of the range of shopping items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
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
	* @param smallImageId the small image ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySmallImageId(long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Removes the shopping item where mediumImageId = &#63; from the database.
	*
	* @param mediumImageId the medium image ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMediumImageId(long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Removes the shopping item where largeImageId = &#63; from the database.
	*
	* @param largeImageId the large image ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLargeImageId(long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException;

	/**
	* Removes all the shopping items where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the shopping item where companyId = &#63; and sku = &#63; from the database.
	*
	* @param companyId the company ID
	* @param sku the sku
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
	* Returns the number of shopping items where smallImageId = &#63;.
	*
	* @param smallImageId the small image ID
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countBySmallImageId(long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping items where mediumImageId = &#63;.
	*
	* @param mediumImageId the medium image ID
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countByMediumImageId(long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping items where largeImageId = &#63;.
	*
	* @param largeImageId the large image ID
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countByLargeImageId(long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping items where companyId = &#63; and sku = &#63;.
	*
	* @param companyId the company ID
	* @param sku the sku
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_S(long companyId, java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping items.
	*
	* @return the number of shopping items
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the shopping item prices associated with the shopping item.
	*
	* @param pk the primary key of the shopping item
	* @return the shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the shopping item prices associated with the shopping item.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the shopping item
	* @param start the lower bound of the range of shopping items
	* @param end the upper bound of the range of shopping items (not inclusive)
	* @return the range of shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the shopping item prices associated with the shopping item.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the shopping item
	* @param start the lower bound of the range of shopping items
	* @param end the upper bound of the range of shopping items (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of shopping item prices associated with the shopping item.
	*
	* @param pk the primary key of the shopping item
	* @return the number of shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public int getShoppingItemPricesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the shopping item price is associated with the shopping item.
	*
	* @param pk the primary key of the shopping item
	* @param shoppingItemPricePK the primary key of the shopping item price
	* @return <code>true</code> if the shopping item price is associated with the shopping item; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsShoppingItemPrice(long pk, long shoppingItemPricePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the shopping item has any shopping item prices associated with it.
	*
	* @param pk the primary key of the shopping item to check for associations with shopping item prices
	* @return <code>true</code> if the shopping item has any shopping item prices associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsShoppingItemPrices(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	public ShoppingItem remove(ShoppingItem shoppingItem)
		throws SystemException;
}