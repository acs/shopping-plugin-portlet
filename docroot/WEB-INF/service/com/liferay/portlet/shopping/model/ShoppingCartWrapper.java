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
 * This class is a wrapper for {@link ShoppingCart}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingCart
 * @generated
 */
public class ShoppingCartWrapper implements ShoppingCart {
	public ShoppingCartWrapper(ShoppingCart shoppingCart) {
		_shoppingCart = shoppingCart;
	}

	public Class<?> getModelClass() {
		return ShoppingCart.class;
	}

	public String getModelClassName() {
		return ShoppingCart.class.getName();
	}

	/**
	* Returns the primary key of this shopping cart.
	*
	* @return the primary key of this shopping cart
	*/
	public long getPrimaryKey() {
		return _shoppingCart.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping cart.
	*
	* @param primaryKey the primary key of this shopping cart
	*/
	public void setPrimaryKey(long primaryKey) {
		_shoppingCart.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cart ID of this shopping cart.
	*
	* @return the cart ID of this shopping cart
	*/
	public long getCartId() {
		return _shoppingCart.getCartId();
	}

	/**
	* Sets the cart ID of this shopping cart.
	*
	* @param cartId the cart ID of this shopping cart
	*/
	public void setCartId(long cartId) {
		_shoppingCart.setCartId(cartId);
	}

	/**
	* Returns the group ID of this shopping cart.
	*
	* @return the group ID of this shopping cart
	*/
	public long getGroupId() {
		return _shoppingCart.getGroupId();
	}

	/**
	* Sets the group ID of this shopping cart.
	*
	* @param groupId the group ID of this shopping cart
	*/
	public void setGroupId(long groupId) {
		_shoppingCart.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this shopping cart.
	*
	* @return the company ID of this shopping cart
	*/
	public long getCompanyId() {
		return _shoppingCart.getCompanyId();
	}

	/**
	* Sets the company ID of this shopping cart.
	*
	* @param companyId the company ID of this shopping cart
	*/
	public void setCompanyId(long companyId) {
		_shoppingCart.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this shopping cart.
	*
	* @return the user ID of this shopping cart
	*/
	public long getUserId() {
		return _shoppingCart.getUserId();
	}

	/**
	* Sets the user ID of this shopping cart.
	*
	* @param userId the user ID of this shopping cart
	*/
	public void setUserId(long userId) {
		_shoppingCart.setUserId(userId);
	}

	/**
	* Returns the user uuid of this shopping cart.
	*
	* @return the user uuid of this shopping cart
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCart.getUserUuid();
	}

	/**
	* Sets the user uuid of this shopping cart.
	*
	* @param userUuid the user uuid of this shopping cart
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_shoppingCart.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this shopping cart.
	*
	* @return the user name of this shopping cart
	*/
	public java.lang.String getUserName() {
		return _shoppingCart.getUserName();
	}

	/**
	* Sets the user name of this shopping cart.
	*
	* @param userName the user name of this shopping cart
	*/
	public void setUserName(java.lang.String userName) {
		_shoppingCart.setUserName(userName);
	}

	/**
	* Returns the create date of this shopping cart.
	*
	* @return the create date of this shopping cart
	*/
	public java.util.Date getCreateDate() {
		return _shoppingCart.getCreateDate();
	}

	/**
	* Sets the create date of this shopping cart.
	*
	* @param createDate the create date of this shopping cart
	*/
	public void setCreateDate(java.util.Date createDate) {
		_shoppingCart.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this shopping cart.
	*
	* @return the modified date of this shopping cart
	*/
	public java.util.Date getModifiedDate() {
		return _shoppingCart.getModifiedDate();
	}

	/**
	* Sets the modified date of this shopping cart.
	*
	* @param modifiedDate the modified date of this shopping cart
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingCart.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the item IDs of this shopping cart.
	*
	* @return the item IDs of this shopping cart
	*/
	public java.lang.String getItemIds() {
		return _shoppingCart.getItemIds();
	}

	/**
	* Sets the item IDs of this shopping cart.
	*
	* @param itemIds the item IDs of this shopping cart
	*/
	public void setItemIds(java.lang.String itemIds) {
		_shoppingCart.setItemIds(itemIds);
	}

	/**
	* Returns the coupon codes of this shopping cart.
	*
	* @return the coupon codes of this shopping cart
	*/
	public java.lang.String getCouponCodes() {
		return _shoppingCart.getCouponCodes();
	}

	/**
	* Sets the coupon codes of this shopping cart.
	*
	* @param couponCodes the coupon codes of this shopping cart
	*/
	public void setCouponCodes(java.lang.String couponCodes) {
		_shoppingCart.setCouponCodes(couponCodes);
	}

	/**
	* Returns the alt shipping of this shopping cart.
	*
	* @return the alt shipping of this shopping cart
	*/
	public int getAltShipping() {
		return _shoppingCart.getAltShipping();
	}

	/**
	* Sets the alt shipping of this shopping cart.
	*
	* @param altShipping the alt shipping of this shopping cart
	*/
	public void setAltShipping(int altShipping) {
		_shoppingCart.setAltShipping(altShipping);
	}

	/**
	* Returns the insure of this shopping cart.
	*
	* @return the insure of this shopping cart
	*/
	public boolean getInsure() {
		return _shoppingCart.getInsure();
	}

	/**
	* Returns <code>true</code> if this shopping cart is insure.
	*
	* @return <code>true</code> if this shopping cart is insure; <code>false</code> otherwise
	*/
	public boolean isInsure() {
		return _shoppingCart.isInsure();
	}

	/**
	* Sets whether this shopping cart is insure.
	*
	* @param insure the insure of this shopping cart
	*/
	public void setInsure(boolean insure) {
		_shoppingCart.setInsure(insure);
	}

	public boolean isNew() {
		return _shoppingCart.isNew();
	}

	public void setNew(boolean n) {
		_shoppingCart.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingCart.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingCart.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingCart.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingCart.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingCart.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shoppingCart.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCart.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCart.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingCartWrapper((ShoppingCart)_shoppingCart.clone());
	}

	public int compareTo(
		com.liferay.portlet.shopping.model.ShoppingCart shoppingCart) {
		return _shoppingCart.compareTo(shoppingCart);
	}

	@Override
	public int hashCode() {
		return _shoppingCart.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portlet.shopping.model.ShoppingCart> toCacheModel() {
		return _shoppingCart.toCacheModel();
	}

	public com.liferay.portlet.shopping.model.ShoppingCart toEscapedModel() {
		return new ShoppingCartWrapper(_shoppingCart.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shoppingCart.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCart.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingCart.persist();
	}

	public ShoppingCart getWrappedShoppingCart() {
		return _shoppingCart;
	}

	public void resetOriginalValues() {
		_shoppingCart.resetOriginalValues();
	}

	private ShoppingCart _shoppingCart;
}