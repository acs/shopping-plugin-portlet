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

/**
 * <p>
 * This class is a wrapper for {@link ShoppingItemField}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingItemField
 * @generated
 */
public class ShoppingItemFieldWrapper implements ShoppingItemField {
	public ShoppingItemFieldWrapper(ShoppingItemField shoppingItemField) {
		_shoppingItemField = shoppingItemField;
	}

	public long getPrimaryKey() {
		return _shoppingItemField.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_shoppingItemField.setPrimaryKey(pk);
	}

	public long getItemFieldId() {
		return _shoppingItemField.getItemFieldId();
	}

	public void setItemFieldId(long itemFieldId) {
		_shoppingItemField.setItemFieldId(itemFieldId);
	}

	public long getItemId() {
		return _shoppingItemField.getItemId();
	}

	public void setItemId(long itemId) {
		_shoppingItemField.setItemId(itemId);
	}

	public java.lang.String getName() {
		return _shoppingItemField.getName();
	}

	public void setName(java.lang.String name) {
		_shoppingItemField.setName(name);
	}

	public java.lang.String getValues() {
		return _shoppingItemField.getValues();
	}

	public void setValues(java.lang.String values) {
		_shoppingItemField.setValues(values);
	}

	public java.lang.String getDescription() {
		return _shoppingItemField.getDescription();
	}

	public void setDescription(java.lang.String description) {
		_shoppingItemField.setDescription(description);
	}

	public com.liferay.shopping.model.ShoppingItemField toEscapedModel() {
		return _shoppingItemField.toEscapedModel();
	}

	public boolean isNew() {
		return _shoppingItemField.isNew();
	}

	public void setNew(boolean n) {
		_shoppingItemField.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingItemField.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingItemField.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingItemField.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingItemField.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingItemField.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingItemField.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingItemField.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _shoppingItemField.clone();
	}

	public int compareTo(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField) {
		return _shoppingItemField.compareTo(shoppingItemField);
	}

	public int hashCode() {
		return _shoppingItemField.hashCode();
	}

	public java.lang.String toString() {
		return _shoppingItemField.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingItemField.toXmlString();
	}

	public java.lang.String[] getValuesArray() {
		return _shoppingItemField.getValuesArray();
	}

	public void setValuesArray(java.lang.String[] valuesArray) {
		_shoppingItemField.setValuesArray(valuesArray);
	}

	public ShoppingItemField getWrappedShoppingItemField() {
		return _shoppingItemField;
	}

	private ShoppingItemField _shoppingItemField;
}