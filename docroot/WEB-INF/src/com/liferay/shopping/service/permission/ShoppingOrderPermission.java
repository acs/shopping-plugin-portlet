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
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.shopping.model.ShoppingOrder;
import com.liferay.shopping.service.ShoppingOrderLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingOrderPermission {

	public static void check(
			PermissionChecker permissionChecker, long groupId, long orderId,
			String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, groupId, orderId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, long groupId,
			ShoppingOrder order, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, order, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long groupId, long orderId,
			String actionId)
		throws PortalException, SystemException {

		ShoppingOrder order =
			ShoppingOrderLocalServiceUtil.getOrder(orderId);

		return contains(permissionChecker, groupId, order, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, ShoppingOrder order,
		String actionId) {

		if (ShoppingPermission.contains(
				permissionChecker, groupId, ActionKeys.MANAGE_ORDERS)) {

			return true;
		}
		else {
			if (permissionChecker.hasOwnerPermission(
					order.getCompanyId(), ShoppingOrder.class.getName(),
					order.getOrderId(), order.getUserId(), actionId)) {

				return true;
			}

			return permissionChecker.hasPermission(
				order.getGroupId(), ShoppingOrder.class.getName(),
				order.getOrderId(), actionId);
		}
	}

}