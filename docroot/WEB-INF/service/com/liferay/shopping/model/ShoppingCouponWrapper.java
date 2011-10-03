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
 * This class is a wrapper for {@link ShoppingCoupon}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingCoupon
 * @generated
 */
public class ShoppingCouponWrapper implements ShoppingCoupon {
	public ShoppingCouponWrapper(ShoppingCoupon shoppingCoupon) {
		_shoppingCoupon = shoppingCoupon;
	}

	public long getPrimaryKey() {
		return _shoppingCoupon.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_shoppingCoupon.setPrimaryKey(pk);
	}

	public long getCouponId() {
		return _shoppingCoupon.getCouponId();
	}

	public void setCouponId(long couponId) {
		_shoppingCoupon.setCouponId(couponId);
	}

	public long getGroupId() {
		return _shoppingCoupon.getGroupId();
	}

	public void setGroupId(long groupId) {
		_shoppingCoupon.setGroupId(groupId);
	}

	public long getCompanyId() {
		return _shoppingCoupon.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_shoppingCoupon.setCompanyId(companyId);
	}

	public long getUserId() {
		return _shoppingCoupon.getUserId();
	}

	public void setUserId(long userId) {
		_shoppingCoupon.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCoupon.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_shoppingCoupon.setUserUuid(userUuid);
	}

	public java.lang.String getUserName() {
		return _shoppingCoupon.getUserName();
	}

	public void setUserName(java.lang.String userName) {
		_shoppingCoupon.setUserName(userName);
	}

	public java.util.Date getCreateDate() {
		return _shoppingCoupon.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_shoppingCoupon.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _shoppingCoupon.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingCoupon.setModifiedDate(modifiedDate);
	}

	public java.lang.String getCode() {
		return _shoppingCoupon.getCode();
	}

	public void setCode(java.lang.String code) {
		_shoppingCoupon.setCode(code);
	}

	public java.lang.String getName() {
		return _shoppingCoupon.getName();
	}

	public void setName(java.lang.String name) {
		_shoppingCoupon.setName(name);
	}

	public java.lang.String getDescription() {
		return _shoppingCoupon.getDescription();
	}

	public void setDescription(java.lang.String description) {
		_shoppingCoupon.setDescription(description);
	}

	public java.util.Date getStartDate() {
		return _shoppingCoupon.getStartDate();
	}

	public void setStartDate(java.util.Date startDate) {
		_shoppingCoupon.setStartDate(startDate);
	}

	public java.util.Date getEndDate() {
		return _shoppingCoupon.getEndDate();
	}

	public void setEndDate(java.util.Date endDate) {
		_shoppingCoupon.setEndDate(endDate);
	}

	public boolean getActive() {
		return _shoppingCoupon.getActive();
	}

	public boolean isActive() {
		return _shoppingCoupon.isActive();
	}

	public void setActive(boolean active) {
		_shoppingCoupon.setActive(active);
	}

	public java.lang.String getLimitCategories() {
		return _shoppingCoupon.getLimitCategories();
	}

	public void setLimitCategories(java.lang.String limitCategories) {
		_shoppingCoupon.setLimitCategories(limitCategories);
	}

	public java.lang.String getLimitSkus() {
		return _shoppingCoupon.getLimitSkus();
	}

	public void setLimitSkus(java.lang.String limitSkus) {
		_shoppingCoupon.setLimitSkus(limitSkus);
	}

	public double getMinOrder() {
		return _shoppingCoupon.getMinOrder();
	}

	public void setMinOrder(double minOrder) {
		_shoppingCoupon.setMinOrder(minOrder);
	}

	public double getDiscount() {
		return _shoppingCoupon.getDiscount();
	}

	public void setDiscount(double discount) {
		_shoppingCoupon.setDiscount(discount);
	}

	public java.lang.String getDiscountType() {
		return _shoppingCoupon.getDiscountType();
	}

	public void setDiscountType(java.lang.String discountType) {
		_shoppingCoupon.setDiscountType(discountType);
	}

	public ShoppingCoupon toEscapedModel() {
		return _shoppingCoupon.toEscapedModel();
	}

	public boolean isNew() {
		return _shoppingCoupon.isNew();
	}

	public void setNew(boolean n) {
		_shoppingCoupon.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingCoupon.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingCoupon.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingCoupon.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingCoupon.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingCoupon.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCoupon.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCoupon.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _shoppingCoupon.clone();
	}

	public int compareTo(ShoppingCoupon shoppingCoupon) {
		return _shoppingCoupon.compareTo(shoppingCoupon);
	}

	public int hashCode() {
		return _shoppingCoupon.hashCode();
	}

	public java.lang.String toString() {
		return _shoppingCoupon.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCoupon.toXmlString();
	}

	public boolean hasValidDateRange() {
		return _shoppingCoupon.hasValidDateRange();
	}

	public boolean hasValidEndDate() {
		return _shoppingCoupon.hasValidEndDate();
	}

	public boolean hasValidStartDate() {
		return _shoppingCoupon.hasValidStartDate();
	}

	public ShoppingCoupon getWrappedShoppingCoupon() {
		return _shoppingCoupon;
	}

	private ShoppingCoupon _shoppingCoupon;
}