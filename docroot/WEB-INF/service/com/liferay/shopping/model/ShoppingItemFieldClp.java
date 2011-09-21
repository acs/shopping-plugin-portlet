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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.shopping.service.ShoppingItemFieldLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemFieldClp extends BaseModelImpl<ShoppingItemField>
	implements ShoppingItemField {
	public ShoppingItemFieldClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingItemField.class;
	}

	public String getModelClassName() {
		return ShoppingItemField.class.getName();
	}

	public long getPrimaryKey() {
		return _itemFieldId;
	}

	public void setPrimaryKey(long primaryKey) {
		setItemFieldId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_itemFieldId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getItemFieldId() {
		return _itemFieldId;
	}

	public void setItemFieldId(long itemFieldId) {
		_itemFieldId = itemFieldId;
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValues() {
		return _values;
	}

	public void setValues(String values) {
		_values = values;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public java.lang.String[] getValuesArray() {
		throw new UnsupportedOperationException();
	}

	public void setValuesArray(java.lang.String[] valuesArray) {
		throw new UnsupportedOperationException();
	}

	public void persist() throws SystemException {
		ShoppingItemFieldLocalServiceUtil.updateShoppingItemField(this);
	}

	@Override
	public ShoppingItemField toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ShoppingItemField)Proxy.newProxyInstance(ShoppingItemField.class.getClassLoader(),
				new Class[] { ShoppingItemField.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public Object clone() {
		ShoppingItemFieldClp clone = new ShoppingItemFieldClp();

		clone.setItemFieldId(getItemFieldId());
		clone.setItemId(getItemId());
		clone.setName(getName());
		clone.setValues(getValues());
		clone.setDescription(getDescription());

		return clone;
	}

	public int compareTo(ShoppingItemField shoppingItemField) {
		int value = 0;

		if (getItemId() < shoppingItemField.getItemId()) {
			value = -1;
		}
		else if (getItemId() > shoppingItemField.getItemId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getName().toLowerCase()
					.compareTo(shoppingItemField.getName().toLowerCase());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ShoppingItemFieldClp shoppingItemField = null;

		try {
			shoppingItemField = (ShoppingItemFieldClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = shoppingItemField.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{itemFieldId=");
		sb.append(getItemFieldId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", values=");
		sb.append(getValues());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingItemField");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemFieldId</column-name><column-value><![CDATA[");
		sb.append(getItemFieldId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>values</column-name><column-value><![CDATA[");
		sb.append(getValues());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _itemFieldId;
	private long _itemId;
	private String _name;
	private String _values;
	private String _description;
}