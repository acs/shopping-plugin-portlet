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

package com.liferay.portlet.shopping.model;

/**
 * <p>
 * This class is a wrapper for {@link ShoppingItemPrice}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingItemPrice
 * @generated
 */
public class ShoppingItemPriceWrapper implements ShoppingItemPrice {
	public ShoppingItemPriceWrapper(ShoppingItemPrice shoppingItemPrice) {
		_shoppingItemPrice = shoppingItemPrice;
	}

	public Class<?> getModelClass() {
		return ShoppingItemPrice.class;
	}

	public String getModelClassName() {
		return ShoppingItemPrice.class.getName();
	}

	/**
	* Returns the primary key of this shopping item price.
	*
	* @return the primary key of this shopping item price
	*/
	public long getPrimaryKey() {
		return _shoppingItemPrice.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping item price.
	*
	* @param primaryKey the primary key of this shopping item price
	*/
	public void setPrimaryKey(long primaryKey) {
		_shoppingItemPrice.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the item price ID of this shopping item price.
	*
	* @return the item price ID of this shopping item price
	*/
	public long getItemPriceId() {
		return _shoppingItemPrice.getItemPriceId();
	}

	/**
	* Sets the item price ID of this shopping item price.
	*
	* @param itemPriceId the item price ID of this shopping item price
	*/
	public void setItemPriceId(long itemPriceId) {
		_shoppingItemPrice.setItemPriceId(itemPriceId);
	}

	/**
	* Returns the item ID of this shopping item price.
	*
	* @return the item ID of this shopping item price
	*/
	public long getItemId() {
		return _shoppingItemPrice.getItemId();
	}

	/**
	* Sets the item ID of this shopping item price.
	*
	* @param itemId the item ID of this shopping item price
	*/
	public void setItemId(long itemId) {
		_shoppingItemPrice.setItemId(itemId);
	}

	/**
	* Returns the min quantity of this shopping item price.
	*
	* @return the min quantity of this shopping item price
	*/
	public int getMinQuantity() {
		return _shoppingItemPrice.getMinQuantity();
	}

	/**
	* Sets the min quantity of this shopping item price.
	*
	* @param minQuantity the min quantity of this shopping item price
	*/
	public void setMinQuantity(int minQuantity) {
		_shoppingItemPrice.setMinQuantity(minQuantity);
	}

	/**
	* Returns the max quantity of this shopping item price.
	*
	* @return the max quantity of this shopping item price
	*/
	public int getMaxQuantity() {
		return _shoppingItemPrice.getMaxQuantity();
	}

	/**
	* Sets the max quantity of this shopping item price.
	*
	* @param maxQuantity the max quantity of this shopping item price
	*/
	public void setMaxQuantity(int maxQuantity) {
		_shoppingItemPrice.setMaxQuantity(maxQuantity);
	}

	/**
	* Returns the price of this shopping item price.
	*
	* @return the price of this shopping item price
	*/
	public double getPrice() {
		return _shoppingItemPrice.getPrice();
	}

	/**
	* Sets the price of this shopping item price.
	*
	* @param price the price of this shopping item price
	*/
	public void setPrice(double price) {
		_shoppingItemPrice.setPrice(price);
	}

	/**
	* Returns the discount of this shopping item price.
	*
	* @return the discount of this shopping item price
	*/
	public double getDiscount() {
		return _shoppingItemPrice.getDiscount();
	}

	/**
	* Sets the discount of this shopping item price.
	*
	* @param discount the discount of this shopping item price
	*/
	public void setDiscount(double discount) {
		_shoppingItemPrice.setDiscount(discount);
	}

	/**
	* Returns the taxable of this shopping item price.
	*
	* @return the taxable of this shopping item price
	*/
	public boolean getTaxable() {
		return _shoppingItemPrice.getTaxable();
	}

	/**
	* Returns <code>true</code> if this shopping item price is taxable.
	*
	* @return <code>true</code> if this shopping item price is taxable; <code>false</code> otherwise
	*/
	public boolean isTaxable() {
		return _shoppingItemPrice.isTaxable();
	}

	/**
	* Sets whether this shopping item price is taxable.
	*
	* @param taxable the taxable of this shopping item price
	*/
	public void setTaxable(boolean taxable) {
		_shoppingItemPrice.setTaxable(taxable);
	}

	/**
	* Returns the shipping of this shopping item price.
	*
	* @return the shipping of this shopping item price
	*/
	public double getShipping() {
		return _shoppingItemPrice.getShipping();
	}

	/**
	* Sets the shipping of this shopping item price.
	*
	* @param shipping the shipping of this shopping item price
	*/
	public void setShipping(double shipping) {
		_shoppingItemPrice.setShipping(shipping);
	}

	/**
	* Returns the use shipping formula of this shopping item price.
	*
	* @return the use shipping formula of this shopping item price
	*/
	public boolean getUseShippingFormula() {
		return _shoppingItemPrice.getUseShippingFormula();
	}

	/**
	* Returns <code>true</code> if this shopping item price is use shipping formula.
	*
	* @return <code>true</code> if this shopping item price is use shipping formula; <code>false</code> otherwise
	*/
	public boolean isUseShippingFormula() {
		return _shoppingItemPrice.isUseShippingFormula();
	}

	/**
	* Sets whether this shopping item price is use shipping formula.
	*
	* @param useShippingFormula the use shipping formula of this shopping item price
	*/
	public void setUseShippingFormula(boolean useShippingFormula) {
		_shoppingItemPrice.setUseShippingFormula(useShippingFormula);
	}

	/**
	* Returns the status of this shopping item price.
	*
	* @return the status of this shopping item price
	*/
	public int getStatus() {
		return _shoppingItemPrice.getStatus();
	}

	/**
	* Sets the status of this shopping item price.
	*
	* @param status the status of this shopping item price
	*/
	public void setStatus(int status) {
		_shoppingItemPrice.setStatus(status);
	}

	public boolean isNew() {
		return _shoppingItemPrice.isNew();
	}

	public void setNew(boolean n) {
		_shoppingItemPrice.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingItemPrice.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingItemPrice.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingItemPrice.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingItemPrice.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingItemPrice.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shoppingItemPrice.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingItemPrice.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingItemPrice.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingItemPriceWrapper((ShoppingItemPrice)_shoppingItemPrice.clone());
	}

	public int compareTo(
		com.liferay.portlet.shopping.model.ShoppingItemPrice shoppingItemPrice) {
		return _shoppingItemPrice.compareTo(shoppingItemPrice);
	}

	@Override
	public int hashCode() {
		return _shoppingItemPrice.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portlet.shopping.model.ShoppingItemPrice> toCacheModel() {
		return _shoppingItemPrice.toCacheModel();
	}

	public com.liferay.portlet.shopping.model.ShoppingItemPrice toEscapedModel() {
		return new ShoppingItemPriceWrapper(_shoppingItemPrice.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shoppingItemPrice.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingItemPrice.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingItemPrice.persist();
	}

	public ShoppingItemPrice getWrappedShoppingItemPrice() {
		return _shoppingItemPrice;
	}

	public void resetOriginalValues() {
		_shoppingItemPrice.resetOriginalValues();
	}

	private ShoppingItemPrice _shoppingItemPrice;
}