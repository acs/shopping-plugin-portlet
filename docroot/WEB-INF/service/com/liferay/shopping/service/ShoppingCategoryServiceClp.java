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
public class ShoppingCategoryServiceClp implements ShoppingCategoryService {
	public ShoppingCategoryServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addCategoryMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addCategory", long.class, java.lang.String.class,
				java.lang.String.class,
				com.liferay.portal.service.ServiceContext.class);

		_deleteCategoryMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteCategory", long.class);

		_getCategoriesMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategories", long.class);

		_getCategoriesMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategories", long.class, long.class, int.class, int.class);

		_getCategoriesCountMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategoriesCount", long.class, long.class);

		_getCategoryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"getCategory", long.class);

		_getSubcategoryIdsMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"getSubcategoryIds", java.util.List.class, long.class,
				long.class);

		_updateCategoryMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateCategory", long.class, long.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				com.liferay.portal.service.ServiceContext.class);
	}

	public com.liferay.shopping.model.ShoppingCategory addCategory(
		long parentCategoryId, java.lang.String name,
		java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addCategoryMethodKey0,
				parentCategoryId, ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
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

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingCategory)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteCategoryMethodKey1,
				categoryId);

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

	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getCategories(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesMethodKey2,
				groupId);

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

		return (java.util.List<com.liferay.shopping.model.ShoppingCategory>)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingCategory> getCategories(
		long groupId, long parentCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesMethodKey3,
				groupId, parentCategoryId, start, end);

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

		return (java.util.List<com.liferay.shopping.model.ShoppingCategory>)ClpSerializer.translateOutput(returnObj);
	}

	public int getCategoriesCount(long groupId, long parentCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoriesCountMethodKey4,
				groupId, parentCategoryId);

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

	public com.liferay.shopping.model.ShoppingCategory getCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getCategoryMethodKey5,
				categoryId);

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

		return (com.liferay.shopping.model.ShoppingCategory)ClpSerializer.translateOutput(returnObj);
	}

	public void getSubcategoryIds(java.util.List<java.lang.Long> categoryIds,
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_getSubcategoryIdsMethodKey6,
				ClpSerializer.translateInput(categoryIds), groupId, categoryId);

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

	public com.liferay.shopping.model.ShoppingCategory updateCategory(
		long categoryId, long parentCategoryId, java.lang.String name,
		java.lang.String description, boolean mergeWithParentCategory,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateCategoryMethodKey7,
				categoryId, parentCategoryId,
				ClpSerializer.translateInput(name),
				ClpSerializer.translateInput(description),
				mergeWithParentCategory,
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

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingCategory)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addCategoryMethodKey0;
	private MethodKey _deleteCategoryMethodKey1;
	private MethodKey _getCategoriesMethodKey2;
	private MethodKey _getCategoriesMethodKey3;
	private MethodKey _getCategoriesCountMethodKey4;
	private MethodKey _getCategoryMethodKey5;
	private MethodKey _getSubcategoryIdsMethodKey6;
	private MethodKey _updateCategoryMethodKey7;
}