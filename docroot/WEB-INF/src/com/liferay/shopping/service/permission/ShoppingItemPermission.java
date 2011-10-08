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

package com.liferay.shopping.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
// import com.liferay.portal.util.PropsValues;
import com.liferay.shopping.model.ShoppingCategory;
import com.liferay.shopping.model.ShoppingCategoryConstants;
import com.liferay.shopping.model.ShoppingItem;
import com.liferay.shopping.service.ShoppingItemLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemPermission {

	public static void check(
			PermissionChecker permissionChecker, long itemId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, itemId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, ShoppingItem item,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, item, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long itemId, String actionId)
		throws PortalException, SystemException {

		ShoppingItem item = ShoppingItemLocalServiceUtil.getItem(itemId);

		return contains(permissionChecker, item, actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, ShoppingItem item,
			String actionId)
		throws PortalException, SystemException {

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.PERMISSIONS_VIEW_DYNAMIC_INHERITANCE))) {
			if (item.getCategoryId() !=
					ShoppingCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) {

				ShoppingCategory category = item.getCategory();

				if (!ShoppingCategoryPermission.contains(
						permissionChecker, category, ActionKeys.VIEW)) {

					return false;
				}
			}
		}

		if (permissionChecker.hasOwnerPermission(
				item.getCompanyId(), ShoppingItem.class.getName(),
				item.getItemId(), item.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(
			item.getGroupId(), ShoppingItem.class.getName(), item.getItemId(),
			actionId);
	}

}