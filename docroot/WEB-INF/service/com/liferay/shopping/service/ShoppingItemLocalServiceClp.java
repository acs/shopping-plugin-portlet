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

package com.liferay.shopping.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemLocalServiceClp implements ShoppingItemLocalService {
	public ShoppingItemLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addShoppingItemMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addShoppingItem", com.liferay.shopping.model.ShoppingItem.class);

		_createShoppingItemMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createShoppingItem", long.class);

		_deleteShoppingItemMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteShoppingItem", long.class);

		_deleteShoppingItemMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteShoppingItem",
				com.liferay.shopping.model.ShoppingItem.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_getShoppingItemMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingItem", long.class);

		_getPersistedModelMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getShoppingItemsMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingItems", int.class, int.class);

		_getShoppingItemsCountMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingItemsCount");

		_updateShoppingItemMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateShoppingItem",
				com.liferay.shopping.model.ShoppingItem.class);

		_updateShoppingItemMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateShoppingItem",
				com.liferay.shopping.model.ShoppingItem.class, boolean.class);

		_getBeanIdentifierMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_addItemMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"addItem", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, int.class,
				boolean.class, java.lang.Boolean.class, boolean.class,
				java.lang.String.class, java.io.File.class, boolean.class,
				java.lang.String.class, java.io.File.class, boolean.class,
				java.lang.String.class, java.io.File.class,
				java.util.List.class, java.util.List.class,
				com.liferay.portal.service.ServiceContext.class);

		_addItemResourcesMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"addItemResources", long.class, boolean.class, boolean.class);

		_addItemResourcesMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"addItemResources", long.class, java.lang.String[].class,
				java.lang.String[].class);

		_addItemResourcesMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"addItemResources",
				com.liferay.shopping.model.ShoppingItem.class, boolean.class,
				boolean.class);

		_addItemResourcesMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"addItemResources",
				com.liferay.shopping.model.ShoppingItem.class,
				java.lang.String[].class, java.lang.String[].class);

		_deleteItemMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteItem", long.class);

		_deleteItemMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteItem", com.liferay.shopping.model.ShoppingItem.class);

		_deleteItemsMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteItems", long.class, long.class);

		_getCategoriesItemsCountMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesItemsCount", long.class, java.util.List.class);

		_getFeaturedItemsMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"getFeaturedItems", long.class, long.class, int.class);

		_getItemMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItem", long.class);

		_getItemMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItem", long.class, java.lang.String.class);

		_getItemByLargeImageIdMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemByLargeImageId", long.class);

		_getItemByMediumImageIdMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemByMediumImageId", long.class);

		_getItemBySmallImageIdMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemBySmallImageId", long.class);

		_getItemsMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItems", long.class, long.class);

		_getItemsMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItems", long.class, long.class, int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_getItemsCountMethodKey33 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemsCount", long.class, long.class);

		_getItemsPrevAndNextMethodKey34 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemsPrevAndNext", long.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_getSaleItemsMethodKey35 = new MethodKey(_classLoaderProxy.getClassName(),
				"getSaleItems", long.class, long.class, int.class);

		_searchMethodKey36 = new MethodKey(_classLoaderProxy.getClassName(),
				"search", long.class, long[].class, java.lang.String.class,
				int.class, int.class);

		_searchCountMethodKey37 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchCount", long.class, long[].class, java.lang.String.class);

		_updateItemMethodKey38 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateItem", long.class, long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, int.class,
				boolean.class, java.lang.Boolean.class, boolean.class,
				java.lang.String.class, java.io.File.class, boolean.class,
				java.lang.String.class, java.io.File.class, boolean.class,
				java.lang.String.class, java.io.File.class,
				java.util.List.class, java.util.List.class,
				com.liferay.portal.service.ServiceContext.class);
	}

	public com.liferay.shopping.model.ShoppingItem addShoppingItem(
		com.liferay.shopping.model.ShoppingItem shoppingItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addShoppingItemMethodKey0,
				ClpSerializer.translateInput(shoppingItem));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingItem createShoppingItem(
		long itemId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createShoppingItemMethodKey1,
				itemId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteShoppingItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteShoppingItemMethodKey2,
				itemId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteShoppingItem(
		com.liferay.shopping.model.ShoppingItem shoppingItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteShoppingItemMethodKey3,
				ClpSerializer.translateInput(shoppingItem));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.liferay.shopping.model.ShoppingItem getShoppingItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingItemMethodKey8,
				itemId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey9,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingItem> getShoppingItems(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingItemsMethodKey10,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.shopping.model.ShoppingItem>)ClpSerializer.translateOutput(returnObj);
	}

	public int getShoppingItemsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingItemsCountMethodKey11);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.liferay.shopping.model.ShoppingItem updateShoppingItem(
		com.liferay.shopping.model.ShoppingItem shoppingItem)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateShoppingItemMethodKey12,
				ClpSerializer.translateInput(shoppingItem));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingItem updateShoppingItem(
		com.liferay.shopping.model.ShoppingItem shoppingItem, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateShoppingItemMethodKey13,
				ClpSerializer.translateInput(shoppingItem), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey14);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey15,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.liferay.shopping.model.ShoppingItem addItem(long userId,
		long groupId, long categoryId, java.lang.String sku,
		java.lang.String name, java.lang.String description,
		java.lang.String properties, java.lang.String fieldsQuantities,
		boolean requiresShipping, int stockQuantity, boolean featured,
		java.lang.Boolean sale, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallImageFile,
		boolean mediumImage, java.lang.String mediumImageURL,
		java.io.File mediumImageFile, boolean largeImage,
		java.lang.String largeImageURL, java.io.File largeImageFile,
		java.util.List<com.liferay.shopping.model.ShoppingItemField> itemFields,
		java.util.List<com.liferay.shopping.model.ShoppingItemPrice> itemPrices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addItemMethodKey16,
				userId, groupId, categoryId, ClpSerializer.translateInput(sku),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(properties),
				ClpSerializer.translateInput(fieldsQuantities),
				requiresShipping, stockQuantity, featured,
				ClpSerializer.translateInput(sale), smallImage,
				ClpSerializer.translateInput(smallImageURL),
				ClpSerializer.translateInput(smallImageFile), mediumImage,
				ClpSerializer.translateInput(mediumImageURL),
				ClpSerializer.translateInput(mediumImageFile), largeImage,
				ClpSerializer.translateInput(largeImageURL),
				ClpSerializer.translateInput(largeImageFile),
				ClpSerializer.translateInput(itemFields),
				ClpSerializer.translateInput(itemPrices),
				ClpSerializer.translateInput(serviceContext));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public void addItemResources(long itemId, boolean addGroupPermissions,
		boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addItemResourcesMethodKey17,
				itemId, addGroupPermissions, addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addItemResources(long itemId,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addItemResourcesMethodKey18,
				itemId, ClpSerializer.translateInput(groupPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addItemResources(com.liferay.shopping.model.ShoppingItem item,
		boolean addGroupPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addItemResourcesMethodKey19,
				ClpSerializer.translateInput(item), addGroupPermissions,
				addGuestPermissions);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void addItemResources(com.liferay.shopping.model.ShoppingItem item,
		java.lang.String[] groupPermissions, java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_addItemResourcesMethodKey20,
				ClpSerializer.translateInput(item),
				ClpSerializer.translateInput(groupPermissions),
				ClpSerializer.translateInput(guestPermissions));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteItemMethodKey21,
				itemId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteItem(com.liferay.shopping.model.ShoppingItem item)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteItemMethodKey22,
				ClpSerializer.translateInput(item));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteItems(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteItemsMethodKey23,
				groupId, categoryId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public int getCategoriesItemsCount(long groupId,
		java.util.List<java.lang.Long> categoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesItemsCountMethodKey24,
				groupId, ClpSerializer.translateInput(categoryIds));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public java.util.List<com.liferay.shopping.model.ShoppingItem> getFeaturedItems(
		long groupId, long categoryId, int numOfItems)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getFeaturedItemsMethodKey25,
				groupId, categoryId, numOfItems);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.shopping.model.ShoppingItem>)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingItem getItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemMethodKey26,
				itemId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingItem getItem(long companyId,
		java.lang.String sku)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemMethodKey27,
				companyId, ClpSerializer.translateInput(sku));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingItem getItemByLargeImageId(
		long largeImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemByLargeImageIdMethodKey28,
				largeImageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingItem getItemByMediumImageId(
		long mediumImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemByMediumImageIdMethodKey29,
				mediumImageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingItem getItemBySmallImageId(
		long smallImageId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemBySmallImageIdMethodKey30,
				smallImageId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingItem> getItems(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemsMethodKey31,
				groupId, categoryId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.shopping.model.ShoppingItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingItem> getItems(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemsMethodKey32,
				groupId, categoryId, start, end,
				ClpSerializer.translateInput(obc));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.shopping.model.ShoppingItem>)ClpSerializer.translateOutput(returnObj);
	}

	public int getItemsCount(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemsCountMethodKey33,
				groupId, categoryId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.liferay.shopping.model.ShoppingItem[] getItemsPrevAndNext(
		long itemId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemsPrevAndNextMethodKey34,
				itemId, ClpSerializer.translateInput(obc));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem[])ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingItem> getSaleItems(
		long groupId, long categoryId, int numOfItems)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getSaleItemsMethodKey35,
				groupId, categoryId, numOfItems);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.shopping.model.ShoppingItem>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingItem> search(
		long groupId, long[] categoryIds, java.lang.String keywords, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchMethodKey36,
				groupId, ClpSerializer.translateInput(categoryIds),
				ClpSerializer.translateInput(keywords), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.shopping.model.ShoppingItem>)ClpSerializer.translateOutput(returnObj);
	}

	public int searchCount(long groupId, long[] categoryIds,
		java.lang.String keywords)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchCountMethodKey37,
				groupId, ClpSerializer.translateInput(categoryIds),
				ClpSerializer.translateInput(keywords));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.liferay.shopping.model.ShoppingItem updateItem(long userId,
		long itemId, long groupId, long categoryId, java.lang.String sku,
		java.lang.String name, java.lang.String description,
		java.lang.String properties, java.lang.String fieldsQuantities,
		boolean requiresShipping, int stockQuantity, boolean featured,
		java.lang.Boolean sale, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallImageFile,
		boolean mediumImage, java.lang.String mediumImageURL,
		java.io.File mediumImageFile, boolean largeImage,
		java.lang.String largeImageURL, java.io.File largeImageFile,
		java.util.List<com.liferay.shopping.model.ShoppingItemField> itemFields,
		java.util.List<com.liferay.shopping.model.ShoppingItemPrice> itemPrices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateItemMethodKey38,
				userId, itemId, groupId, categoryId,
				ClpSerializer.translateInput(sku),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(properties),
				ClpSerializer.translateInput(fieldsQuantities),
				requiresShipping, stockQuantity, featured,
				ClpSerializer.translateInput(sale), smallImage,
				ClpSerializer.translateInput(smallImageURL),
				ClpSerializer.translateInput(smallImageFile), mediumImage,
				ClpSerializer.translateInput(mediumImageURL),
				ClpSerializer.translateInput(mediumImageFile), largeImage,
				ClpSerializer.translateInput(largeImageURL),
				ClpSerializer.translateInput(largeImageFile),
				ClpSerializer.translateInput(itemFields),
				ClpSerializer.translateInput(itemPrices),
				ClpSerializer.translateInput(serviceContext));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.lang.Exception) {
				throw (java.lang.Exception)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingItem)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addShoppingItemMethodKey0;
	private MethodKey _createShoppingItemMethodKey1;
	private MethodKey _deleteShoppingItemMethodKey2;
	private MethodKey _deleteShoppingItemMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _getShoppingItemMethodKey8;
	private MethodKey _getPersistedModelMethodKey9;
	private MethodKey _getShoppingItemsMethodKey10;
	private MethodKey _getShoppingItemsCountMethodKey11;
	private MethodKey _updateShoppingItemMethodKey12;
	private MethodKey _updateShoppingItemMethodKey13;
	private MethodKey _getBeanIdentifierMethodKey14;
	private MethodKey _setBeanIdentifierMethodKey15;
	private MethodKey _addItemMethodKey16;
	private MethodKey _addItemResourcesMethodKey17;
	private MethodKey _addItemResourcesMethodKey18;
	private MethodKey _addItemResourcesMethodKey19;
	private MethodKey _addItemResourcesMethodKey20;
	private MethodKey _deleteItemMethodKey21;
	private MethodKey _deleteItemMethodKey22;
	private MethodKey _deleteItemsMethodKey23;
	private MethodKey _getCategoriesItemsCountMethodKey24;
	private MethodKey _getFeaturedItemsMethodKey25;
	private MethodKey _getItemMethodKey26;
	private MethodKey _getItemMethodKey27;
	private MethodKey _getItemByLargeImageIdMethodKey28;
	private MethodKey _getItemByMediumImageIdMethodKey29;
	private MethodKey _getItemBySmallImageIdMethodKey30;
	private MethodKey _getItemsMethodKey31;
	private MethodKey _getItemsMethodKey32;
	private MethodKey _getItemsCountMethodKey33;
	private MethodKey _getItemsPrevAndNextMethodKey34;
	private MethodKey _getSaleItemsMethodKey35;
	private MethodKey _searchMethodKey36;
	private MethodKey _searchCountMethodKey37;
	private MethodKey _updateItemMethodKey38;
}