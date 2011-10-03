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

/**
 * <p>
 * This class is a wrapper for {@link ShoppingItemFieldLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingItemFieldLocalService
 * @generated
 */
public class ShoppingItemFieldLocalServiceWrapper
	implements ShoppingItemFieldLocalService {
	public ShoppingItemFieldLocalServiceWrapper(
		ShoppingItemFieldLocalService shoppingItemFieldLocalService) {
		_shoppingItemFieldLocalService = shoppingItemFieldLocalService;
	}

	/**
	* Adds the shopping item field to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemField the shopping item field to add
	* @return the shopping item field that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField addShoppingItemField(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.addShoppingItemField(shoppingItemField);
	}

	/**
	* Creates a new shopping item field with the primary key. Does not add the shopping item field to the database.
	*
	* @param itemFieldId the primary key for the new shopping item field
	* @return the new shopping item field
	*/
	public com.liferay.shopping.model.ShoppingItemField createShoppingItemField(
		long itemFieldId) {
		return _shoppingItemFieldLocalService.createShoppingItemField(itemFieldId);
	}

	/**
	* Deletes the shopping item field with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemFieldId the primary key of the shopping item field to delete
	* @throws PortalException if a shopping item field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingItemField(long itemFieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingItemFieldLocalService.deleteShoppingItemField(itemFieldId);
	}

	/**
	* Deletes the shopping item field from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemField the shopping item field to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingItemField(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingItemFieldLocalService.deleteShoppingItemField(shoppingItemField);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the shopping item field with the primary key.
	*
	* @param itemFieldId the primary key of the shopping item field to get
	* @return the shopping item field
	* @throws PortalException if a shopping item field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField getShoppingItemField(
		long itemFieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.getShoppingItemField(itemFieldId);
	}

	/**
	* Gets a range of all the shopping item fields.
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
	public java.util.List<com.liferay.shopping.model.ShoppingItemField> getShoppingItemFields(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.getShoppingItemFields(start, end);
	}

	/**
	* Gets the number of shopping item fields.
	*
	* @return the number of shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public int getShoppingItemFieldsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.getShoppingItemFieldsCount();
	}

	/**
	* Updates the shopping item field in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemField the shopping item field to update
	* @return the shopping item field that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField updateShoppingItemField(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.updateShoppingItemField(shoppingItemField);
	}

	/**
	* Updates the shopping item field in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemField the shopping item field to update
	* @param merge whether to merge the shopping item field with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping item field that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingItemField updateShoppingItemField(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.updateShoppingItemField(shoppingItemField,
			merge);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingItemField> getItemFields(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingItemFieldLocalService.getItemFields(itemId);
	}

	public ShoppingItemFieldLocalService getWrappedShoppingItemFieldLocalService() {
		return _shoppingItemFieldLocalService;
	}

	private ShoppingItemFieldLocalService _shoppingItemFieldLocalService;
}