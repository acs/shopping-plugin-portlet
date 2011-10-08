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

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.shopping.model.ShoppingOrder;

/**
 * @author Brian Wing Shun Chan
 */
public class OrderDateComparator extends OrderByComparator {

	public static String ORDER_BY_ASC = "Shopping_ShoppingOrder.createDate ASC";

	public static String ORDER_BY_DESC = "Shopping_ShoppingOrder.createDate DESC";

	public static String[] ORDER_BY_FIELDS = {"createDate"};

	public OrderDateComparator() {
		this(false);
	}

	public OrderDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		ShoppingOrder order1 = (ShoppingOrder)obj1;
		ShoppingOrder order2 = (ShoppingOrder)obj2;

		int value = DateUtil.compareTo(
			order1.getCreateDate(), order2.getCreateDate());

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