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

	public long getPrimaryKey() {
		return _shoppingCart.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_shoppingCart.setPrimaryKey(pk);
	}

	public long getCartId() {
		return _shoppingCart.getCartId();
	}

	public void setCartId(long cartId) {
		_shoppingCart.setCartId(cartId);
	}

	public long getGroupId() {
		return _shoppingCart.getGroupId();
	}

	public void setGroupId(long groupId) {
		_shoppingCart.setGroupId(groupId);
	}

	public long getCompanyId() {
		return _shoppingCart.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_shoppingCart.setCompanyId(companyId);
	}

	public long getUserId() {
		return _shoppingCart.getUserId();
	}

	public void setUserId(long userId) {
		_shoppingCart.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCart.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_shoppingCart.setUserUuid(userUuid);
	}

	public java.lang.String getUserName() {
		return _shoppingCart.getUserName();
	}

	public void setUserName(java.lang.String userName) {
		_shoppingCart.setUserName(userName);
	}

	public java.util.Date getCreateDate() {
		return _shoppingCart.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_shoppingCart.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _shoppingCart.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingCart.setModifiedDate(modifiedDate);
	}

	public java.lang.String getItemIds() {
		return _shoppingCart.getItemIds();
	}

	public void setItemIds(java.lang.String itemIds) {
		_shoppingCart.setItemIds(itemIds);
	}

	public java.lang.String getCouponCodes() {
		return _shoppingCart.getCouponCodes();
	}

	public void setCouponCodes(java.lang.String couponCodes) {
		_shoppingCart.setCouponCodes(couponCodes);
	}

	public int getAltShipping() {
		return _shoppingCart.getAltShipping();
	}

	public void setAltShipping(int altShipping) {
		_shoppingCart.setAltShipping(altShipping);
	}

	public boolean getInsure() {
		return _shoppingCart.getInsure();
	}

	public boolean isInsure() {
		return _shoppingCart.isInsure();
	}

	public void setInsure(boolean insure) {
		_shoppingCart.setInsure(insure);
	}

	public ShoppingCart toEscapedModel() {
		return _shoppingCart.toEscapedModel();
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

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCart.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCart.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _shoppingCart.clone();
	}

	public int compareTo(ShoppingCart shoppingCart) {
		return _shoppingCart.compareTo(shoppingCart);
	}

	public int hashCode() {
		return _shoppingCart.hashCode();
	}

	public java.lang.String toString() {
		return _shoppingCart.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCart.toXmlString();
	}

	public void addItemId(long itemId, java.lang.String fields) {
		_shoppingCart.addItemId(itemId, fields);
	}

	public com.liferay.shopping.model.ShoppingCoupon getCoupon()
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCart.getCoupon();
	}

	public java.util.Map<com.liferay.shopping.model.ShoppingCartItem, java.lang.Integer> getItems()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCart.getItems();
	}

	public int getItemsSize() {
		return _shoppingCart.getItemsSize();
	}

	public ShoppingCart getWrappedShoppingCart() {
		return _shoppingCart;
	}

	private ShoppingCart _shoppingCart;
}