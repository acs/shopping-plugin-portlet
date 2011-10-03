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

package com.liferay.shopping.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingCouponFinderUtil {
	public static int countByG_C_C_A_DT(long groupId, long companyId,
		java.lang.String code, boolean active, java.lang.String discountType,
		boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByG_C_C_A_DT(groupId, companyId, code, active,
			discountType, andOperator);
	}

	public static java.util.List<com.liferay.shopping.model.ShoppingCoupon> findByG_C_C_A_DT(
		long groupId, long companyId, java.lang.String code, boolean active,
		java.lang.String discountType, boolean andOperator, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_C_C_A_DT(groupId, companyId, code, active,
			discountType, andOperator, start, end);
	}

	public static ShoppingCouponFinder getFinder() {
		if (_finder == null) {
			_finder = (ShoppingCouponFinder)PortletBeanLocatorUtil.locate(com.liferay.shopping.service.ClpSerializer.SERVLET_CONTEXT_NAME,
					ShoppingCouponFinder.class.getName());
		}

		return _finder;
	}

	public void setFinder(ShoppingCouponFinder finder) {
		_finder = finder;
	}

	private static ShoppingCouponFinder _finder;
}