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
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingOrderFinderUtil {
	public static int countByG_C_U_N_PPPS(long groupId, long companyId,
		long userId, java.lang.String number,
		java.lang.String billingFirstName, java.lang.String billingLastName,
		java.lang.String billingEmailAddress,
		java.lang.String shippingFirstName, java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String ppPaymentStatus, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByG_C_U_N_PPPS(groupId, companyId, userId, number,
			billingFirstName, billingLastName, billingEmailAddress,
			shippingFirstName, shippingLastName, shippingEmailAddress,
			ppPaymentStatus, andOperator);
	}

	public static java.util.List<com.liferay.shopping.model.ShoppingOrder> findByG_C_U_N_PPPS(
		long groupId, long companyId, long userId, java.lang.String number,
		java.lang.String billingFirstName, java.lang.String billingLastName,
		java.lang.String billingEmailAddress,
		java.lang.String shippingFirstName, java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String ppPaymentStatus, boolean andOperator, int start,
		int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByG_C_U_N_PPPS(groupId, companyId, userId, number,
			billingFirstName, billingLastName, billingEmailAddress,
			shippingFirstName, shippingLastName, shippingEmailAddress,
			ppPaymentStatus, andOperator, start, end, obc);
	}

	public static ShoppingOrderFinder getFinder() {
		if (_finder == null) {
			_finder = (ShoppingOrderFinder)PortletBeanLocatorUtil.locate(com.liferay.shopping.service.ClpSerializer.getServletContextName(),
					ShoppingOrderFinder.class.getName());

			ReferenceRegistry.registerReference(ShoppingOrderFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ShoppingOrderFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ShoppingOrderFinderUtil.class,
			"_finder");
	}

	private static ShoppingOrderFinder _finder;
}