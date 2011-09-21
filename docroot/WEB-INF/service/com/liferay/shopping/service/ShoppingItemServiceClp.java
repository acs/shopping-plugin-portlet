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
public class ShoppingItemServiceClp implements ShoppingItemService {
	public ShoppingItemServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addItemMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addItem", long.class, long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				int.class, boolean.class, java.lang.Boolean.class,
				boolean.class, java.lang.String.class, java.io.File.class,
				boolean.class, java.lang.String.class, java.io.File.class,
				boolean.class, java.lang.String.class, java.io.File.class,
				java.util.List.class, java.util.List.class,
				com.liferay.portal.service.ServiceContext.class);

		_deleteItemMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteItem", long.class);

		_getCategoriesItemsCountMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesItemsCount", long.class, java.util.List.class);

		_getItemMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItem", long.class);

		_getItemsMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItems", long.class, long.class);

		_getItemsMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItems", long.class, long.class, int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_getItemsCountMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemsCount", long.class, long.class);

		_getItemsPrevAndNextMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"getItemsPrevAndNext", long.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_updateItemMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateItem", long.class, long.class, long.class,
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

	public com.liferay.shopping.model.ShoppingItem addItem(long groupId,
		long categoryId, java.lang.String sku, java.lang.String name,
		java.lang.String description, java.lang.String properties,
		java.lang.String fieldsQuantities, boolean requiresShipping,
		int stockQuantity, boolean featured, java.lang.Boolean sale,
		boolean smallImage, java.lang.String smallImageURL,
		java.io.File smallFile, boolean mediumImage,
		java.lang.String mediumImageURL, java.io.File mediumFile,
		boolean largeImage, java.lang.String largeImageURL,
		java.io.File largeFile,
		java.util.List<com.liferay.shopping.model.ShoppingItemField> itemFields,
		java.util.List<com.liferay.shopping.model.ShoppingItemPrice> itemPrices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addItemMethodKey0,
				groupId, categoryId, ClpSerializer.translateInput(sku),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(properties),
				ClpSerializer.translateInput(fieldsQuantities),
				requiresShipping, stockQuantity, featured,
				ClpSerializer.translateInput(sale), smallImage,
				ClpSerializer.translateInput(smallImageURL),
				ClpSerializer.translateInput(smallFile), mediumImage,
				ClpSerializer.translateInput(mediumImageURL),
				ClpSerializer.translateInput(mediumFile), largeImage,
				ClpSerializer.translateInput(largeImageURL),
				ClpSerializer.translateInput(largeFile),
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

	public void deleteItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteItemMethodKey1,
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

	public int getCategoriesItemsCount(long groupId,
		java.util.List<java.lang.Long> categoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesItemsCountMethodKey2,
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

	public com.liferay.shopping.model.ShoppingItem getItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemMethodKey3,
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

	public java.util.List<com.liferay.shopping.model.ShoppingItem> getItems(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getItemsMethodKey4,
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

		MethodHandler methodHandler = new MethodHandler(_getItemsMethodKey5,
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

		MethodHandler methodHandler = new MethodHandler(_getItemsCountMethodKey6,
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

		MethodHandler methodHandler = new MethodHandler(_getItemsPrevAndNextMethodKey7,
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

	public com.liferay.shopping.model.ShoppingItem updateItem(long itemId,
		long groupId, long categoryId, java.lang.String sku,
		java.lang.String name, java.lang.String description,
		java.lang.String properties, java.lang.String fieldsQuantities,
		boolean requiresShipping, int stockQuantity, boolean featured,
		java.lang.Boolean sale, boolean smallImage,
		java.lang.String smallImageURL, java.io.File smallFile,
		boolean mediumImage, java.lang.String mediumImageURL,
		java.io.File mediumFile, boolean largeImage,
		java.lang.String largeImageURL, java.io.File largeFile,
		java.util.List<com.liferay.shopping.model.ShoppingItemField> itemFields,
		java.util.List<com.liferay.shopping.model.ShoppingItemPrice> itemPrices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			java.lang.Exception {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateItemMethodKey8,
				itemId, groupId, categoryId, ClpSerializer.translateInput(sku),
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				ClpSerializer.translateInput(properties),
				ClpSerializer.translateInput(fieldsQuantities),
				requiresShipping, stockQuantity, featured,
				ClpSerializer.translateInput(sale), smallImage,
				ClpSerializer.translateInput(smallImageURL),
				ClpSerializer.translateInput(smallFile), mediumImage,
				ClpSerializer.translateInput(mediumImageURL),
				ClpSerializer.translateInput(mediumFile), largeImage,
				ClpSerializer.translateInput(largeImageURL),
				ClpSerializer.translateInput(largeFile),
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
	private MethodKey _addItemMethodKey0;
	private MethodKey _deleteItemMethodKey1;
	private MethodKey _getCategoriesItemsCountMethodKey2;
	private MethodKey _getItemMethodKey3;
	private MethodKey _getItemsMethodKey4;
	private MethodKey _getItemsMethodKey5;
	private MethodKey _getItemsCountMethodKey6;
	private MethodKey _getItemsPrevAndNextMethodKey7;
	private MethodKey _updateItemMethodKey8;
}