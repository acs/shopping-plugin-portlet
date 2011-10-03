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
 * This class is a wrapper for {@link ShoppingCategory}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingCategory
 * @generated
 */
public class ShoppingCategoryWrapper implements ShoppingCategory {
	public ShoppingCategoryWrapper(ShoppingCategory shoppingCategory) {
		_shoppingCategory = shoppingCategory;
	}

	public long getPrimaryKey() {
		return _shoppingCategory.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_shoppingCategory.setPrimaryKey(pk);
	}

	public long getCategoryId() {
		return _shoppingCategory.getCategoryId();
	}

	public void setCategoryId(long categoryId) {
		_shoppingCategory.setCategoryId(categoryId);
	}

	public long getGroupId() {
		return _shoppingCategory.getGroupId();
	}

	public void setGroupId(long groupId) {
		_shoppingCategory.setGroupId(groupId);
	}

	public long getCompanyId() {
		return _shoppingCategory.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_shoppingCategory.setCompanyId(companyId);
	}

	public long getUserId() {
		return _shoppingCategory.getUserId();
	}

	public void setUserId(long userId) {
		_shoppingCategory.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingCategory.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_shoppingCategory.setUserUuid(userUuid);
	}

	public java.lang.String getUserName() {
		return _shoppingCategory.getUserName();
	}

	public void setUserName(java.lang.String userName) {
		_shoppingCategory.setUserName(userName);
	}

	public java.util.Date getCreateDate() {
		return _shoppingCategory.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_shoppingCategory.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _shoppingCategory.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingCategory.setModifiedDate(modifiedDate);
	}

	public long getParentCategoryId() {
		return _shoppingCategory.getParentCategoryId();
	}

	public void setParentCategoryId(long parentCategoryId) {
		_shoppingCategory.setParentCategoryId(parentCategoryId);
	}

	public java.lang.String getName() {
		return _shoppingCategory.getName();
	}

	public void setName(java.lang.String name) {
		_shoppingCategory.setName(name);
	}

	public java.lang.String getDescription() {
		return _shoppingCategory.getDescription();
	}

	public void setDescription(java.lang.String description) {
		_shoppingCategory.setDescription(description);
	}

	public ShoppingCategory toEscapedModel() {
		return _shoppingCategory.toEscapedModel();
	}

	public boolean isNew() {
		return _shoppingCategory.isNew();
	}

	public void setNew(boolean n) {
		_shoppingCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingCategory.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingCategory.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingCategory.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingCategory.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _shoppingCategory.clone();
	}

	public int compareTo(ShoppingCategory shoppingCategory) {
		return _shoppingCategory.compareTo(shoppingCategory);
	}

	public int hashCode() {
		return _shoppingCategory.hashCode();
	}

	public java.lang.String toString() {
		return _shoppingCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingCategory.toXmlString();
	}

	public boolean isRoot() {
		return _shoppingCategory.isRoot();
	}

	public ShoppingCategory getWrappedShoppingCategory() {
		return _shoppingCategory;
	}

	private ShoppingCategory _shoppingCategory;
}