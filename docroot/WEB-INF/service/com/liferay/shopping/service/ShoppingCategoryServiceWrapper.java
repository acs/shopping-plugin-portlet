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
 * This class is a wrapper for {@link ShoppingCategoryService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingCategoryService
 * @generated
 */
public class ShoppingCategoryServiceWrapper implements ShoppingCategoryService {
	public ShoppingCategoryServiceWrapper(
		ShoppingCategoryService shoppingCategoryService) {
		_shoppingCategoryService = shoppingCategoryService;
	}

	public com.liferay.shopping.model.ShoppingCategory addCategory(
		long parentCategoryId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryService.addCategory(parentCategoryId, name,
			description, serviceContext);
	}

	public void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryService.deleteCategory(categoryId);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryService.getCategories(groupId);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getCategories(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryService.getCategories(groupId,
			parentCategoryId, start, end);
	}

	public int getCategoriesCount(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryService.getCategoriesCount(groupId,
			parentCategoryId);
	}

	public com.liferay.shopping.model.ShoppingCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryService.getCategory(categoryId);
	}

	public void getSubcategoryIds(java.util.List<java.lang.Long> categoryIds,
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCategoryService.getSubcategoryIds(categoryIds, groupId,
			categoryId);
	}

	public com.liferay.shopping.model.ShoppingCategory updateCategory(
		long categoryId, long parentCategoryId, java.lang.String name,
		java.lang.String description, boolean mergeWithParentCategory,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategoryService.updateCategory(categoryId,
			parentCategoryId, name, description, mergeWithParentCategory,
			serviceContext);
	}

	public ShoppingCategoryService getWrappedShoppingCategoryService() {
		return _shoppingCategoryService;
	}

	public void setWrappedShoppingCategoryService(
		ShoppingCategoryService shoppingCategoryService) {
		_shoppingCategoryService = shoppingCategoryService;
	}

	private ShoppingCategoryService _shoppingCategoryService;
}