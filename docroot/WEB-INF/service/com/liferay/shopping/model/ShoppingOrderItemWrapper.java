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

	public Class<?> getModelClass() {
		return ShoppingOrderItem.class;
	}

	public String getModelClassName() {
		return ShoppingOrderItem.class.getName();
	}

	/**
	* Returns the primary key of this shopping order item.
	*
	* @return the primary key of this shopping order item
	*/
	public long getPrimaryKey() {
		return _shoppingOrderItem.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping order item.
	*
	* @param primaryKey the primary key of this shopping order item
	*/
	public void setPrimaryKey(long primaryKey) {
		_shoppingOrderItem.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the order item ID of this shopping order item.
	*
	* @return the order item ID of this shopping order item
	*/
	public long getOrderItemId() {
		return _shoppingOrderItem.getOrderItemId();
	}

	/**
	* Sets the order item ID of this shopping order item.
	*
	* @param orderItemId the order item ID of this shopping order item
	*/
	public void setOrderItemId(long orderItemId) {
		_shoppingOrderItem.setOrderItemId(orderItemId);
	}

	/**
	* Returns the order ID of this shopping order item.
	*
	* @return the order ID of this shopping order item
	*/
	public long getOrderId() {
		return _shoppingOrderItem.getOrderId();
	}

	/**
	* Sets the order ID of this shopping order item.
	*
	* @param orderId the order ID of this shopping order item
	*/
	public void setOrderId(long orderId) {
		_shoppingOrderItem.setOrderId(orderId);
	}

	/**
	* Returns the item ID of this shopping order item.
	*
	* @return the item ID of this shopping order item
	*/
	public java.lang.String getItemId() {
		return _shoppingOrderItem.getItemId();
	}

	/**
	* Sets the item ID of this shopping order item.
	*
	* @param itemId the item ID of this shopping order item
	*/
	public void setItemId(java.lang.String itemId) {
		_shoppingOrderItem.setItemId(itemId);
	}

	/**
	* Returns the sku of this shopping order item.
	*
	* @return the sku of this shopping order item
	*/
	public java.lang.String getSku() {
		return _shoppingOrderItem.getSku();
	}

	/**
	* Sets the sku of this shopping order item.
	*
	* @param sku the sku of this shopping order item
	*/
	public void setSku(java.lang.String sku) {
		_shoppingOrderItem.setSku(sku);
	}

	/**
	* Returns the name of this shopping order item.
	*
	* @return the name of this shopping order item
	*/
	public java.lang.String getName() {
		return _shoppingOrderItem.getName();
	}

	/**
	* Sets the name of this shopping order item.
	*
	* @param name the name of this shopping order item
	*/
	public void setName(java.lang.String name) {
		_shoppingOrderItem.setName(name);
	}

	/**
	* Returns the description of this shopping order item.
	*
	* @return the description of this shopping order item
	*/
	public java.lang.String getDescription() {
		return _shoppingOrderItem.getDescription();
	}

	/**
	* Sets the description of this shopping order item.
	*
	* @param description the description of this shopping order item
	*/
	public void setDescription(java.lang.String description) {
		_shoppingOrderItem.setDescription(description);
	}

	/**
	* Returns the properties of this shopping order item.
	*
	* @return the properties of this shopping order item
	*/
	public java.lang.String getProperties() {
		return _shoppingOrderItem.getProperties();
	}

	/**
	* Sets the properties of this shopping order item.
	*
	* @param properties the properties of this shopping order item
	*/
	public void setProperties(java.lang.String properties) {
		_shoppingOrderItem.setProperties(properties);
	}

	/**
	* Returns the price of this shopping order item.
	*
	* @return the price of this shopping order item
	*/
	public double getPrice() {
		return _shoppingOrderItem.getPrice();
	}

	/**
	* Sets the price of this shopping order item.
	*
	* @param price the price of this shopping order item
	*/
	public void setPrice(double price) {
		_shoppingOrderItem.setPrice(price);
	}

	/**
	* Returns the quantity of this shopping order item.
	*
	* @return the quantity of this shopping order item
	*/
	public int getQuantity() {
		return _shoppingOrderItem.getQuantity();
	}

	/**
	* Sets the quantity of this shopping order item.
	*
	* @param quantity the quantity of this shopping order item
	*/
	public void setQuantity(int quantity) {
		_shoppingOrderItem.setQuantity(quantity);
	}

	/**
	* Returns the shipped date of this shopping order item.
	*
	* @return the shipped date of this shopping order item
	*/
	public java.util.Date getShippedDate() {
		return _shoppingOrderItem.getShippedDate();
	}

	/**
	* Sets the shipped date of this shopping order item.
	*
	* @param shippedDate the shipped date of this shopping order item
	*/
	public void setShippedDate(java.util.Date shippedDate) {
		_shoppingOrderItem.setShippedDate(shippedDate);
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

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shoppingOrderItem.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingOrderItem.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingOrderItem.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingOrderItemWrapper((ShoppingOrderItem)_shoppingOrderItem.clone());
	}

	public int compareTo(
		com.liferay.shopping.model.ShoppingOrderItem shoppingOrderItem) {
		return _shoppingOrderItem.compareTo(shoppingOrderItem);
	}

	@Override
	public int hashCode() {
		return _shoppingOrderItem.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.shopping.model.ShoppingOrderItem> toCacheModel() {
		return _shoppingOrderItem.toCacheModel();
	}

	public com.liferay.shopping.model.ShoppingOrderItem toEscapedModel() {
		return new ShoppingOrderItemWrapper(_shoppingOrderItem.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shoppingOrderItem.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingOrderItem.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrderItem.persist();
	}

	public ShoppingOrderItem getWrappedShoppingOrderItem() {
		return _shoppingOrderItem;
	}

	public void resetOriginalValues() {
		_shoppingOrderItem.resetOriginalValues();
	}

	private ShoppingOrderItem _shoppingOrderItem;
}