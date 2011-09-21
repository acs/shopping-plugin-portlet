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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the shopping item remote service. This utility wraps {@link com.liferay.shopping.service.impl.ShoppingItemServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemService
 * @see com.liferay.shopping.service.base.ShoppingItemServiceBaseImpl
 * @see com.liferay.shopping.service.impl.ShoppingItemServiceImpl
 * @generated
 */
public class ShoppingItemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.shopping.service.impl.ShoppingItemServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.shopping.model.ShoppingItem addItem(
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
		return getService()
				   .addItem(groupId, categoryId, sku, name, description,
			properties, fieldsQuantities, requiresShipping, stockQuantity,
			featured, sale, smallImage, smallImageURL, smallFile, mediumImage,
			mediumImageURL, mediumFile, largeImage, largeImageURL, largeFile,
			itemFields, itemPrices, serviceContext);
	}

	public static void deleteItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteItem(itemId);
	}

	public static int getCategoriesItemsCount(long groupId,
		java.util.List<java.lang.Long> categoryIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoriesItemsCount(groupId, categoryIds);
	}

	public static com.liferay.shopping.model.ShoppingItem getItem(long itemId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getItem(itemId);
	}

	public static java.util.List<com.liferay.shopping.model.ShoppingItem> getItems(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItems(groupId, categoryId);
	}

	public static java.util.List<com.liferay.shopping.model.ShoppingItem> getItems(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItems(groupId, categoryId, start, end, obc);
	}

	public static int getItemsCount(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemsCount(groupId, categoryId);
	}

	public static com.liferay.shopping.model.ShoppingItem[] getItemsPrevAndNext(
		long itemId, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemsPrevAndNext(itemId, obc);
	}

	public static com.liferay.shopping.model.ShoppingItem updateItem(
		long itemId, long groupId, long categoryId, java.lang.String sku,
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
		return getService()
				   .updateItem(itemId, groupId, categoryId, sku, name,
			description, properties, fieldsQuantities, requiresShipping,
			stockQuantity, featured, sale, smallImage, smallImageURL,
			smallFile, mediumImage, mediumImageURL, mediumFile, largeImage,
			largeImageURL, largeFile, itemFields, itemPrices, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static ShoppingItemService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ShoppingItemService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ShoppingItemService.class.getName(), portletClassLoader);

			_service = new ShoppingItemServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ShoppingItemServiceUtil.class,
				"_service");
			MethodCache.remove(ShoppingItemService.class);
		}

		return _service;
	}

	public void setService(ShoppingItemService service) {
		MethodCache.remove(ShoppingItemService.class);

		_service = service;

		ReferenceRegistry.registerReference(ShoppingItemServiceUtil.class,
			"_service");
		MethodCache.remove(ShoppingItemService.class);
	}

	private static ShoppingItemService _service;
}