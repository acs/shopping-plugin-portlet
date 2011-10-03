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

package com.liferay.shopping.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemPriceClp extends BaseModelImpl<ShoppingItemPrice>
	implements ShoppingItemPrice {
	public ShoppingItemPriceClp() {
	}

	public long getPrimaryKey() {
		return _itemPriceId;
	}

	public void setPrimaryKey(long pk) {
		setItemPriceId(pk);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_itemPriceId);
	}

	public long getItemPriceId() {
		return _itemPriceId;
	}

	public void setItemPriceId(long itemPriceId) {
		_itemPriceId = itemPriceId;
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public int getMinQuantity() {
		return _minQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		_minQuantity = minQuantity;
	}

	public int getMaxQuantity() {
		return _maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		_maxQuantity = maxQuantity;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;
	}

	public boolean getTaxable() {
		return _taxable;
	}

	public boolean isTaxable() {
		return _taxable;
	}

	public void setTaxable(boolean taxable) {
		_taxable = taxable;
	}

	public double getShipping() {
		return _shipping;
	}

	public void setShipping(double shipping) {
		_shipping = shipping;
	}

	public boolean getUseShippingFormula() {
		return _useShippingFormula;
	}

	public boolean isUseShippingFormula() {
		return _useShippingFormula;
	}

	public void setUseShippingFormula(boolean useShippingFormula) {
		_useShippingFormula = useShippingFormula;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public ShoppingItemPrice toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ShoppingItemPrice)Proxy.newProxyInstance(ShoppingItemPrice.class.getClassLoader(),
				new Class[] { ShoppingItemPrice.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	public Object clone() {
		ShoppingItemPriceClp clone = new ShoppingItemPriceClp();

		clone.setItemPriceId(getItemPriceId());
		clone.setItemId(getItemId());
		clone.setMinQuantity(getMinQuantity());
		clone.setMaxQuantity(getMaxQuantity());
		clone.setPrice(getPrice());
		clone.setDiscount(getDiscount());
		clone.setTaxable(getTaxable());
		clone.setShipping(getShipping());
		clone.setUseShippingFormula(getUseShippingFormula());
		clone.setStatus(getStatus());

		return clone;
	}

	public int compareTo(ShoppingItemPrice shoppingItemPrice) {
		int value = 0;

		if (getItemId() < shoppingItemPrice.getItemId()) {
			value = -1;
		}
		else if (getItemId() > shoppingItemPrice.getItemId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getItemPriceId() < shoppingItemPrice.getItemPriceId()) {
			value = -1;
		}
		else if (getItemPriceId() > shoppingItemPrice.getItemPriceId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ShoppingItemPriceClp shoppingItemPrice = null;

		try {
			shoppingItemPrice = (ShoppingItemPriceClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long pk = shoppingItemPrice.getPrimaryKey();

		if (getPrimaryKey() == pk) {
			return true;
		}
		else {
			return false;
		}
	}

	public int hashCode() {
		return (int)getPrimaryKey();
	}

	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{itemPriceId=");
		sb.append(getItemPriceId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", minQuantity=");
		sb.append(getMinQuantity());
		sb.append(", maxQuantity=");
		sb.append(getMaxQuantity());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", taxable=");
		sb.append(getTaxable());
		sb.append(", shipping=");
		sb.append(getShipping());
		sb.append(", useShippingFormula=");
		sb.append(getUseShippingFormula());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingItemPrice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemPriceId</column-name><column-value><![CDATA[");
		sb.append(getItemPriceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minQuantity</column-name><column-value><![CDATA[");
		sb.append(getMinQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxQuantity</column-name><column-value><![CDATA[");
		sb.append(getMaxQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxable</column-name><column-value><![CDATA[");
		sb.append(getTaxable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipping</column-name><column-value><![CDATA[");
		sb.append(getShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useShippingFormula</column-name><column-value><![CDATA[");
		sb.append(getUseShippingFormula());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemPriceId;
	private long _itemId;
	private int _minQuantity;
	private int _maxQuantity;
	private double _price;
	private double _discount;
	private boolean _taxable;
	private double _shipping;
	private boolean _useShippingFormula;
	private int _status;
}