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

package com.liferay.shopping.model.impl;

import com.liferay.portal.kernel.util.HashCode;
import com.liferay.portal.kernel.util.HashCodeFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.shopping.model.ShoppingCartItem;
import com.liferay.shopping.model.ShoppingItem;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingCartItemImpl implements ShoppingCartItem {

	public static String[] getFieldsArray(String fields) {
		return StringUtil.split(fields, "&");
	}

	public ShoppingCartItemImpl(ShoppingItem item, String fields) {
		_item = item;
		_fields = fields;
	}

	public int compareTo(ShoppingCartItem cartItem) {
		if (cartItem == null) {
			return -1;
		}

		int value = getItem().compareTo(cartItem.getItem());

		if (value == 0) {
			value = getFields().compareTo(cartItem.getFields());
		}

		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ShoppingCartItem cartItem = (ShoppingCartItem)obj;

		if (getItem().equals(cartItem.getItem()) &&
			getFields().equals(cartItem.getFields())) {

			return true;
		}
		else {
			return false;
		}
	}

	public String getCartItemId() {
		long itemId = getItem().getItemId();

		if (Validator.isNull(_fields)) {
			return String.valueOf(itemId);
		}
		else {
			return itemId + "|" + _fields;
		}
	}

	public String getFields() {
		return _fields;
	}

	public String[] getFieldsArray() {
		return getFieldsArray(_fields);
	}

	public ShoppingItem getItem() {
		return _item;
	}

	@Override
	public int hashCode() {
		HashCode hashCode = HashCodeFactoryUtil.getHashCode();

		hashCode.append(_item.getItemId());
		hashCode.append(_fields);

		return hashCode.toHashCode();
	}

	private String _fields;
	private ShoppingItem _item;

}
