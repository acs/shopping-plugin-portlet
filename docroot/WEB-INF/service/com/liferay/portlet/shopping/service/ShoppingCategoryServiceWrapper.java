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

package com.liferay.portlet.shopping.service;

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

	public ShoppingCategoryService getWrappedShoppingCategoryService() {
		return _shoppingCategoryService;
	}

	public void setWrappedShoppingCategoryService(
		ShoppingCategoryService shoppingCategoryService) {
		_shoppingCategoryService = shoppingCategoryService;
	}

	private ShoppingCategoryService _shoppingCategoryService;
}