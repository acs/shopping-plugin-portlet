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

package com.liferay.shopping.service.messaging;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;

import com.liferay.shopping.service.ClpSerializer;
import com.liferay.shopping.service.ShoppingCartLocalServiceUtil;
import com.liferay.shopping.service.ShoppingCategoryLocalServiceUtil;
import com.liferay.shopping.service.ShoppingCategoryServiceUtil;
import com.liferay.shopping.service.ShoppingCouponLocalServiceUtil;
import com.liferay.shopping.service.ShoppingCouponServiceUtil;
import com.liferay.shopping.service.ShoppingItemFieldLocalServiceUtil;
import com.liferay.shopping.service.ShoppingItemLocalServiceUtil;
import com.liferay.shopping.service.ShoppingItemPriceLocalServiceUtil;
import com.liferay.shopping.service.ShoppingItemServiceUtil;
import com.liferay.shopping.service.ShoppingOrderItemLocalServiceUtil;
import com.liferay.shopping.service.ShoppingOrderLocalServiceUtil;
import com.liferay.shopping.service.ShoppingOrderServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener implements MessageListener {
	public static final String SERVLET_CONTEXT_NAME = ClpSerializer.SERVLET_CONTEXT_NAME;

	public void receive(Message message) {
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}

	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(SERVLET_CONTEXT_NAME)) {
			ShoppingCartLocalServiceUtil.clearService();

			ShoppingCategoryLocalServiceUtil.clearService();

			ShoppingCategoryServiceUtil.clearService();
			ShoppingCouponLocalServiceUtil.clearService();

			ShoppingCouponServiceUtil.clearService();
			ShoppingItemLocalServiceUtil.clearService();

			ShoppingItemServiceUtil.clearService();
			ShoppingItemFieldLocalServiceUtil.clearService();

			ShoppingItemPriceLocalServiceUtil.clearService();

			ShoppingOrderLocalServiceUtil.clearService();

			ShoppingOrderServiceUtil.clearService();
			ShoppingOrderItemLocalServiceUtil.clearService();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpMessageListener.class);
}