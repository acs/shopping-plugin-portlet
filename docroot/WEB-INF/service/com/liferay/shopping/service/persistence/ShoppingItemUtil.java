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
import com.liferay.portal.service.ServiceContext;

import com.liferay.shopping.model.ShoppingItem;

import java.util.List;

/**
 * The persistence utility for the shopping item service. This utility wraps {@link ShoppingItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPersistence
 * @see ShoppingItemPersistenceImpl
 * @generated
 */
public class ShoppingItemUtil {
	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ShoppingItem shoppingItem) {
		getPersistence().clearCache(shoppingItem);
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
	public static List<ShoppingItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ShoppingItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ShoppingItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#remove(com.liferay.portal.model.BaseModel)
	 */
	public static ShoppingItem remove(ShoppingItem shoppingItem)
		throws SystemException {
		return getPersistence().remove(shoppingItem);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ShoppingItem update(ShoppingItem shoppingItem, boolean merge)
		throws SystemException {
		return getPersistence().update(shoppingItem, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ShoppingItem update(ShoppingItem shoppingItem, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(shoppingItem, merge, serviceContext);
	}

	/**
	* Caches the shopping item in the entity cache if it is enabled.
	*
	* @param shoppingItem the shopping item to cache
	*/
	public static void cacheResult(
		com.liferay.shopping.model.ShoppingItem shoppingItem) {
		getPersistence().cacheResult(shoppingItem);
	}

	/**
	* Caches the shopping items in the entity cache if it is enabled.
	*
	* @param shoppingItems the shopping items to cache
	*/
	public static void cacheResult(
		java.util.List<com.liferay.shopping.model.ShoppingItem> shoppingItems) {
		getPersistence().cacheResult(shoppingItems);
	}

	/**
	* Creates a new shopping item with the primary key. Does not add the shopping item to the database.
	*
	* @param itemId the primary key for the new shopping item
	* @return the new shopping item
	*/
	public static com.liferay.shopping.model.ShoppingItem create(long itemId) {
		return getPersistence().create(itemId);
	}

	/**
	* Removes the shopping item with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemId the primary key of the shopping item to remove
	* @return the shopping item that was removed
	* @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem remove(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence().remove(itemId);
	}

	public static com.liferay.shopping.model.ShoppingItem updateImpl(
		com.liferay.shopping.model.ShoppingItem shoppingItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(shoppingItem, merge);
	}

	/**
	* Finds the shopping item with the primary key or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param itemId the primary key of the shopping item to find
	* @return the shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem findByPrimaryKey(
		long itemId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence().findByPrimaryKey(itemId);
	}

	/**
	* Finds the shopping item with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemId the primary key of the shopping item to find
	* @return the shopping item, or <code>null</code> if a shopping item with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchByPrimaryKey(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(itemId);
	}

	/**
	* Finds the shopping item where smallImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param smallImageId the small image id to search with
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem findBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence().findBySmallImageId(smallImageId);
	}

	/**
	* Finds the shopping item where smallImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param smallImageId the small image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySmallImageId(smallImageId);
	}

	/**
	* Finds the shopping item where smallImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param smallImageId the small image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchBySmallImageId(
		long smallImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySmallImageId(smallImageId, retrieveFromCache);
	}

	/**
	* Finds the shopping item where mediumImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param mediumImageId the medium image id to search with
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem findByMediumImageId(
		long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence().findByMediumImageId(mediumImageId);
	}

	/**
	* Finds the shopping item where mediumImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param mediumImageId the medium image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchByMediumImageId(
		long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMediumImageId(mediumImageId);
	}

	/**
	* Finds the shopping item where mediumImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param mediumImageId the medium image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchByMediumImageId(
		long mediumImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMediumImageId(mediumImageId, retrieveFromCache);
	}

	/**
	* Finds the shopping item where largeImageId = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param largeImageId the large image id to search with
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem findByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence().findByLargeImageId(largeImageId);
	}

	/**
	* Finds the shopping item where largeImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param largeImageId the large image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLargeImageId(largeImageId);
	}

	/**
	* Finds the shopping item where largeImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param largeImageId the large image id to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchByLargeImageId(
		long largeImageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLargeImageId(largeImageId, retrieveFromCache);
	}

	/**
	* Finds all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @return the matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, categoryId);
	}

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
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, categoryId, start, end);
	}

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
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> findByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C(groupId, categoryId, start, end, orderByComparator);
	}

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
	public static com.liferay.shopping.model.ShoppingItem findByG_C_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence()
				   .findByG_C_First(groupId, categoryId, orderByComparator);
	}

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
	public static com.liferay.shopping.model.ShoppingItem findByG_C_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence()
				   .findByG_C_Last(groupId, categoryId, orderByComparator);
	}

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
	public static com.liferay.shopping.model.ShoppingItem[] findByG_C_PrevAndNext(
		long itemId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence()
				   .findByG_C_PrevAndNext(itemId, groupId, categoryId,
			orderByComparator);
	}

	/**
	* Filters by the user's permissions and finds all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @return the matching shopping items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> filterFindByG_C(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C(groupId, categoryId);
	}

	/**
	* Filters by the user's permissions and finds a range of all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @param start the lower bound of the range of shopping items to return
	* @param end the upper bound of the range of shopping items to return (not inclusive)
	* @return the range of matching shopping items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> filterFindByG_C(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C(groupId, categoryId, start, end);
	}

	/**
	* Filters by the user's permissions and finds an ordered range of all the shopping items where groupId = &#63; and categoryId = &#63;.
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
	* @return the ordered range of matching shopping items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> filterFindByG_C(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C(groupId, categoryId, start, end,
			orderByComparator);
	}

	/**
	* Finds the shopping item where companyId = &#63; and sku = &#63; or throws a {@link com.liferay.shopping.NoSuchItemException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @return the matching shopping item
	* @throws com.liferay.shopping.NoSuchItemException if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem findByC_S(
		long companyId, java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		return getPersistence().findByC_S(companyId, sku);
	}

	/**
	* Finds the shopping item where companyId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchByC_S(
		long companyId, java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_S(companyId, sku);
	}

	/**
	* Finds the shopping item where companyId = &#63; and sku = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @return the matching shopping item, or <code>null</code> if a matching shopping item could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItem fetchByC_S(
		long companyId, java.lang.String sku, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByC_S(companyId, sku, retrieveFromCache);
	}

	/**
	* Finds all the shopping items.
	*
	* @return the shopping items
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.shopping.model.ShoppingItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes the shopping item where smallImageId = &#63; from the database.
	*
	* @param smallImageId the small image id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBySmallImageId(long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		getPersistence().removeBySmallImageId(smallImageId);
	}

	/**
	* Removes the shopping item where mediumImageId = &#63; from the database.
	*
	* @param mediumImageId the medium image id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMediumImageId(long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		getPersistence().removeByMediumImageId(mediumImageId);
	}

	/**
	* Removes the shopping item where largeImageId = &#63; from the database.
	*
	* @param largeImageId the large image id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLargeImageId(long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		getPersistence().removeByLargeImageId(largeImageId);
	}

	/**
	* Removes all the shopping items where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C(groupId, categoryId);
	}

	/**
	* Removes the shopping item where companyId = &#63; and sku = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByC_S(long companyId, java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemException {
		getPersistence().removeByC_S(companyId, sku);
	}

	/**
	* Removes all the shopping items from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Counts all the shopping items where smallImageId = &#63;.
	*
	* @param smallImageId the small image id to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySmallImageId(long smallImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySmallImageId(smallImageId);
	}

	/**
	* Counts all the shopping items where mediumImageId = &#63;.
	*
	* @param mediumImageId the medium image id to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMediumImageId(long mediumImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMediumImageId(mediumImageId);
	}

	/**
	* Counts all the shopping items where largeImageId = &#63;.
	*
	* @param largeImageId the large image id to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLargeImageId(long largeImageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLargeImageId(largeImageId);
	}

	/**
	* Counts all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C(groupId, categoryId);
	}

	/**
	* Filters by the user's permissions and counts all the shopping items where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group id to search with
	* @param categoryId the category id to search with
	* @return the number of matching shopping items that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_C(groupId, categoryId);
	}

	/**
	* Counts all the shopping items where companyId = &#63; and sku = &#63;.
	*
	* @param companyId the company id to search with
	* @param sku the sku to search with
	* @return the number of matching shopping items
	* @throws SystemException if a system exception occurred
	*/
	public static int countByC_S(long companyId, java.lang.String sku)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByC_S(companyId, sku);
	}

	/**
	* Counts all the shopping items.
	*
	* @return the number of shopping items
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Gets all the shopping item prices associated with the shopping item.
	*
	* @param pk the primary key of the shopping item to get the associated shopping item prices for
	* @return the shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getShoppingItemPrices(pk);
	}

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
	public static java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getShoppingItemPrices(pk, start, end);
	}

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
	public static java.util.List<com.liferay.shopping.model.ShoppingItemPrice> getShoppingItemPrices(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getShoppingItemPrices(pk, start, end, orderByComparator);
	}

	/**
	* Gets the number of shopping item prices associated with the shopping item.
	*
	* @param pk the primary key of the shopping item to get the number of associated shopping item prices for
	* @return the number of shopping item prices associated with the shopping item
	* @throws SystemException if a system exception occurred
	*/
	public static int getShoppingItemPricesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getShoppingItemPricesSize(pk);
	}

	/**
	* Determines if the shopping item price is associated with the shopping item.
	*
	* @param pk the primary key of the shopping item
	* @param shoppingItemPricePK the primary key of the shopping item price
	* @return <code>true</code> if the shopping item price is associated with the shopping item; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsShoppingItemPrice(long pk,
		long shoppingItemPricePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .containsShoppingItemPrice(pk, shoppingItemPricePK);
	}

	/**
	* Determines if the shopping item has any shopping item prices associated with it.
	*
	* @param pk the primary key of the shopping item to check for associations with shopping item prices
	* @return <code>true</code> if the shopping item has any shopping item prices associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsShoppingItemPrices(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsShoppingItemPrices(pk);
	}

	public static ShoppingItemPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ShoppingItemPersistence)PortletBeanLocatorUtil.locate(com.liferay.shopping.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ShoppingItemPersistence.class.getName());
		}

		return _persistence;
	}

	public void setPersistence(ShoppingItemPersistence persistence) {
		_persistence = persistence;
	}

	private static ShoppingItemPersistence _persistence;
}