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
 * This class is a wrapper for {@link ShoppingCategoryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingCategoryLocalService
 * @generated
 */
public class ShoppingCategoryLocalServiceWrapper
	implements ShoppingCategoryLocalService {
	public ShoppingCategoryLocalServiceWrapper(
		ShoppingCategoryLocalService shoppingCategoryLocalService) {
		_shoppingCategoryLocalService = shoppingCategoryLocalService;
	}

	/**
	* Adds the shopping category to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategory the shopping category to add
	* @return the shopping category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingCategory addShoppingCategory(
		com.liferay.shopping.model.ShoppingCategory shoppingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.addShoppingCategory(shoppingCategory);
	}

	/**
	* Creates a new shopping category with the primary key. Does not add the shopping category to the database.
	*
	* @param categoryId the primary key for the new shopping category
	* @return the new shopping category
	*/
	public com.liferay.shopping.model.ShoppingCategory createShoppingCategory(
		long categoryId) {
		return _shoppingCategoryLocalService.createShoppingCategory(categoryId);
	}

	/**
	* Deletes the shopping category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the shopping category to delete
	* @throws PortalException if a shopping category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.deleteShoppingCategory(categoryId);
	}

	/**
	* Deletes the shopping category from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategory the shopping category to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteShoppingCategory(
		com.liferay.shopping.model.ShoppingCategory shoppingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.deleteShoppingCategory(shoppingCategory);
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
		return _shoppingCategoryLocalService.dynamicQuery(dynamicQuery);
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
		return _shoppingCategoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _shoppingCategoryLocalService.dynamicQuery(dynamicQuery, start,
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
		return _shoppingCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the shopping category with the primary key.
	*
	* @param categoryId the primary key of the shopping category to get
	* @return the shopping category
	* @throws PortalException if a shopping category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingCategory getShoppingCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getShoppingCategory(categoryId);
	}

	/**
	* Gets a range of all the shopping categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping categories to return
	* @param end the upper bound of the range of shopping categories to return (not inclusive)
	* @return the range of shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getShoppingCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getShoppingCategories(start, end);
	}

	/**
	* Gets the number of shopping categories.
	*
	* @return the number of shopping categories
	* @throws SystemException if a system exception occurred
	*/
	public int getShoppingCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getShoppingCategoriesCount();
	}

	/**
	* Updates the shopping category in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategory the shopping category to update
	* @return the shopping category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingCategory updateShoppingCategory(
		com.liferay.shopping.model.ShoppingCategory shoppingCategory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.updateShoppingCategory(shoppingCategory);
	}

	/**
	* Updates the shopping category in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingCategory the shopping category to update
	* @param merge whether to merge the shopping category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.shopping.model.ShoppingCategory updateShoppingCategory(
		com.liferay.shopping.model.ShoppingCategory shoppingCategory,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.updateShoppingCategory(shoppingCategory,
			merge);
	}

	public com.liferay.shopping.model.ShoppingCategory addCategory(
		long userId, long parentCategoryId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.addCategory(userId,
			parentCategoryId, name, description, serviceContext);
	}

	public void addCategoryResources(long categoryId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.addCategoryResources(categoryId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(long categoryId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.addCategoryResources(categoryId,
			communityPermissions, guestPermissions);
	}

	public void addCategoryResources(
		com.liferay.shopping.model.ShoppingCategory category,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.addCategoryResources(category,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addCategoryResources(
		com.liferay.shopping.model.ShoppingCategory category,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.addCategoryResources(category,
			communityPermissions, guestPermissions);
	}

	public void deleteCategories(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.deleteCategories(groupId);
	}

	public void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.deleteCategory(categoryId);
	}

	public void deleteCategory(
		com.liferay.shopping.model.ShoppingCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.deleteCategory(category);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getCategories(groupId);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getCategories(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getCategories(groupId,
			parentCategoryId, start, end);
	}

	public int getCategoriesCount(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getCategoriesCount(groupId,
			parentCategoryId);
	}

	public com.liferay.shopping.model.ShoppingCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getCategory(categoryId);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getParentCategories(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getParentCategories(categoryId);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getParentCategories(
		com.liferay.shopping.model.ShoppingCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getParentCategories(category);
	}

	public com.liferay.shopping.model.ShoppingCategory getParentCategory(
		com.liferay.shopping.model.ShoppingCategory category)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.getParentCategory(category);
	}

	public void getSubcategoryIds(java.util.List<java.lang.Long> categoryIds,
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryLocalService.getSubcategoryIds(categoryIds, groupId,
			categoryId);
	}

	public com.liferay.shopping.model.ShoppingCategory updateCategory(
		long categoryId, long parentCategoryId, java.lang.String name,
		java.lang.String description, boolean mergeWithParentCategory,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryLocalService.updateCategory(categoryId,
			parentCategoryId, name, description, mergeWithParentCategory,
			serviceContext);
	}

	public ShoppingCategoryLocalService getWrappedShoppingCategoryLocalService() {
		return _shoppingCategoryLocalService;
	}

	private ShoppingCategoryLocalService _shoppingCategoryLocalService;
}