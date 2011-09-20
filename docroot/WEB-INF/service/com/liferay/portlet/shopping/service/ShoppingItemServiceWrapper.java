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
 * This class is a wrapper for {@link ShoppingItemService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingItemService
 * @generated
 */
public class ShoppingItemServiceWrapper implements ShoppingItemService {
	public ShoppingItemServiceWrapper(ShoppingItemService shoppingItemService) {
		_shoppingItemService = shoppingItemService;
	}

	public ShoppingItemService getWrappedShoppingItemService() {
		return _shoppingItemService;
	}

	public void setWrappedShoppingItemService(
		ShoppingItemService shoppingItemService) {
		_shoppingItemService = shoppingItemService;
	}

	private ShoppingItemService _shoppingItemService;
}