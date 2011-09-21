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

package com.liferay.shopping.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.shopping.model.ShoppingItemField;
import com.liferay.shopping.service.base.ShoppingItemFieldLocalServiceBaseImpl;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemFieldLocalServiceImpl
	extends ShoppingItemFieldLocalServiceBaseImpl {

	public List<ShoppingItemField> getItemFields(long itemId)
		throws SystemException {

		return shoppingItemFieldPersistence.findByItemId(itemId);
	}

}