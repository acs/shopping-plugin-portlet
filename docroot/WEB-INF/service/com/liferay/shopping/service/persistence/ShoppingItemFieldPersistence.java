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

import com.liferay.shopping.model.ShoppingItemField;

/**
 * The persistence interface for the shopping item field service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link ShoppingItemFieldUtil} to access the shopping item field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemFieldPersistenceImpl
 * @see ShoppingItemFieldUtil
 * @generated
 */
public interface ShoppingItemFieldPersistence extends BasePersistence<ShoppingItemField> {
	/**
	* Caches the shopping item field in the entity cache if it is enabled.
	*
	* @param shoppingItemField the shopping item field to cache
	*/
	public void cacheResult(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField);

	/**
	* Caches the shopping item fields in the entity cache if it is enabled.
	*
	* @param shoppingItemFields the shopping item fields to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.shopping.model.ShoppingItemField> shoppingItemFields);

	/**
	* Creates a new shopping item field with the primary key. Does not add the shopping item field to the database.
	*
	* @param itemFieldId the primary key for the new shopping item field
	* @return the new shopping item field
	*/
	public com.liferay.shopping.model.ShoppingItemField create(long itemFieldId);

	/**
	* Removes the shopping item field with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemFieldId the primary key of the shopping item field to remove
	* @return the shopping item field that was removed
	* @throws com.liferay.shopping.NoSuchItemFieldException if a shopping item field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField remove(long itemFieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemFieldException;

	public com.liferay.shopping.model.ShoppingItemField updateImpl(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the shopping item field with the primary key or throws a {@link com.liferay.shopping.NoSuchItemFieldException} if it could not be found.
	*
	* @param itemFieldId the primary key of the shopping item field to find
	* @return the shopping item field
	* @throws com.liferay.shopping.NoSuchItemFieldException if a shopping item field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField findByPrimaryKey(
		long itemFieldId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemFieldException;

	/**
	* Finds the shopping item field with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param itemFieldId the primary key of the shopping item field to find
	* @return the shopping item field, or <code>null</code> if a shopping item field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField fetchByPrimaryKey(
		long itemFieldId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the shopping item fields where itemId = &#63;.
	*
	* @param itemId the item id to search with
	* @return the matching shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemField> findByItemId(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the shopping item fields where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the item id to search with
	* @param start the lower bound of the range of shopping item fields to return
	* @param end the upper bound of the range of shopping item fields to return (not inclusive)
	* @return the range of matching shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemField> findByItemId(
		long itemId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the shopping item fields where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the item id to search with
	* @param start the lower bound of the range of shopping item fields to return
	* @param end the upper bound of the range of shopping item fields to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemField> findByItemId(
		long itemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first shopping item field in the ordered set where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the item id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching shopping item field
	* @throws com.liferay.shopping.NoSuchItemFieldException if a matching shopping item field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField findByItemId_First(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemFieldException;

	/**
	* Finds the last shopping item field in the ordered set where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemId the item id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching shopping item field
	* @throws com.liferay.shopping.NoSuchItemFieldException if a matching shopping item field could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField findByItemId_Last(
		long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemFieldException;

	/**
	* Finds the shopping item fields before and after the current shopping item field in the ordered set where itemId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param itemFieldId the primary key of the current shopping item field
	* @param itemId the item id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next shopping item field
	* @throws com.liferay.shopping.NoSuchItemFieldException if a shopping item field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField[] findByItemId_PrevAndNext(
		long itemFieldId, long itemId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.shopping.NoSuchItemFieldException;

	/**
	* Finds all the shopping item fields.
	*
	* @return the shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemField> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the shopping item fields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping item fields to return
	* @param end the upper bound of the range of shopping item fields to return (not inclusive)
	* @return the range of shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemField> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the shopping item fields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping item fields to return
	* @param end the upper bound of the range of shopping item fields to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingItemField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping item fields where itemId = &#63; from the database.
	*
	* @param itemId the item id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the shopping item fields from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping item fields where itemId = &#63;.
	*
	* @param itemId the item id to search with
	* @return the number of matching shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemId(long itemId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the shopping item fields.
	*
	* @return the number of shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}