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
 * This class is a wrapper for {@link ShoppingOrderService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingOrderService
 * @generated
 */
public class ShoppingOrderServiceWrapper implements ShoppingOrderService {
	public ShoppingOrderServiceWrapper(
		ShoppingOrderService shoppingOrderService) {
		_shoppingOrderService = shoppingOrderService;
	}

	public ShoppingOrderService getWrappedShoppingOrderService() {
		return _shoppingOrderService;
	}

	public void setWrappedShoppingOrderService(
		ShoppingOrderService shoppingOrderService) {
		_shoppingOrderService = shoppingOrderService;
	}

	private ShoppingOrderService _shoppingOrderService;
}