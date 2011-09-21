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

package com.liferay.shopping.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.shopping.model.ShoppingItem;

/**
 * @author Brian Wing Shun Chan
 */
public class ItemMinQuantityComparator extends OrderByComparator {

	public static String ORDER_BY_ASC =
		"ShoppingItem.categoryId ASC, ShoppingItem.minQuantity ASC, " +
			"ShoppingItem.name ASC";

	public static String ORDER_BY_DESC =
		"ShoppingItem.categoryId DESC, ShoppingItem.minQuantity DESC, " +
			"ShoppingItem.name DESC";

	public static String[] ORDER_BY_FIELDS = {
		"categoryId", "minQuantity", "name"
	};

	public ItemMinQuantityComparator() {
		this(false);
	}

	public ItemMinQuantityComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		ShoppingItem item1 = (ShoppingItem)obj1;
		ShoppingItem item2 = (ShoppingItem)obj2;

		Long categoryId1 = new Long(item1.getCategoryId());
		Long categoryId2 = new Long(item2.getCategoryId());

		int value = categoryId1.compareTo(categoryId2);

		if (value == 0) {
			if (item1.getMinQuantity() < item2.getMinQuantity()) {
				value = -1;
			}
			else if (item1.getMinQuantity() > item2.getMinQuantity()) {
				value = 1;
			}
		}

		if (value == 0) {
			value = item1.getName().toLowerCase().compareTo(
				item2.getName().toLowerCase());
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}