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
 * This class is a wrapper for {@link ShoppingOrderItem}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingOrderItem
 * @generated
 */
public class ShoppingOrderItemWrapper implements ShoppingOrderItem {
	public ShoppingOrderItemWrapper(ShoppingOrderItem shoppingOrderItem) {
		_shoppingOrderItem = shoppingOrderItem;
	}

	public long getPrimaryKey() {
		return _shoppingOrderItem.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_shoppingOrderItem.setPrimaryKey(pk);
	}

	public long getOrderItemId() {
		return _shoppingOrderItem.getOrderItemId();
	}

	public void setOrderItemId(long orderItemId) {
		_shoppingOrderItem.setOrderItemId(orderItemId);
	}

	public long getOrderId() {
		return _shoppingOrderItem.getOrderId();
	}

	public void setOrderId(long orderId) {
		_shoppingOrderItem.setOrderId(orderId);
	}

	public java.lang.String getItemId() {
		return _shoppingOrderItem.getItemId();
	}

	public void setItemId(java.lang.String itemId) {
		_shoppingOrderItem.setItemId(itemId);
	}

	public java.lang.String getSku() {
		return _shoppingOrderItem.getSku();
	}

	public void setSku(java.lang.String sku) {
		_shoppingOrderItem.setSku(sku);
	}

	public java.lang.String getName() {
		return _shoppingOrderItem.getName();
	}

	public void setName(java.lang.String name) {
		_shoppingOrderItem.setName(name);
	}

	public java.lang.String getDescription() {
		return _shoppingOrderItem.getDescription();
	}

	public void setDescription(java.lang.String description) {
		_shoppingOrderItem.setDescription(description);
	}

	public java.lang.String getProperties() {
		return _shoppingOrderItem.getProperties();
	}

	public void setProperties(java.lang.String properties) {
		_shoppingOrderItem.setProperties(properties);
	}

	public double getPrice() {
		return _shoppingOrderItem.getPrice();
	}

	public void setPrice(double price) {
		_shoppingOrderItem.setPrice(price);
	}

	public int getQuantity() {
		return _shoppingOrderItem.getQuantity();
	}

	public void setQuantity(int quantity) {
		_shoppingOrderItem.setQuantity(quantity);
	}

	public java.util.Date getShippedDate() {
		return _shoppingOrderItem.getShippedDate();
	}

	public void setShippedDate(java.util.Date shippedDate) {
		_shoppingOrderItem.setShippedDate(shippedDate);
	}

	public ShoppingOrderItem toEscapedModel() {
		return _shoppingOrderItem.toEscapedModel();
	}

	public boolean isNew() {
		return _shoppingOrderItem.isNew();
	}

	public void setNew(boolean n) {
		_shoppingOrderItem.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingOrderItem.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingOrderItem.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingOrderItem.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingOrderItem.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingOrderItem.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingOrderItem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingOrderItem.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _shoppingOrderItem.clone();
	}

	public int compareTo(ShoppingOrderItem shoppingOrderItem) {
		return _shoppingOrderItem.compareTo(shoppingOrderItem);
	}

	public int hashCode() {
		return _shoppingOrderItem.hashCode();
	}

	public java.lang.String toString() {
		return _shoppingOrderItem.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingOrderItem.toXmlString();
	}

	public ShoppingOrderItem getWrappedShoppingOrderItem() {
		return _shoppingOrderItem;
	}

	private ShoppingOrderItem _shoppingOrderItem;
}