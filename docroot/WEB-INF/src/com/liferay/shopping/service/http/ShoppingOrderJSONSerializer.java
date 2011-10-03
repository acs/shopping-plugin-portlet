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

package com.liferay.shopping.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.shopping.model.ShoppingOrder;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ShoppingOrderJSONSerializer {
	public static JSONObject toJSONObject(ShoppingOrder model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("orderId", model.getOrderId());
		jsonObj.put("groupId", model.getGroupId());
		jsonObj.put("companyId", model.getCompanyId());
		jsonObj.put("userId", model.getUserId());
		jsonObj.put("userName", model.getUserName());

		Date createDate = model.getCreateDate();

		String createDateJSON = StringPool.BLANK;

		if (createDate != null) {
			createDateJSON = String.valueOf(createDate.getTime());
		}

		jsonObj.put("createDate", createDateJSON);

		Date modifiedDate = model.getModifiedDate();

		String modifiedDateJSON = StringPool.BLANK;

		if (modifiedDate != null) {
			modifiedDateJSON = String.valueOf(modifiedDate.getTime());
		}

		jsonObj.put("modifiedDate", modifiedDateJSON);
		jsonObj.put("number", model.getNumber());
		jsonObj.put("tax", model.getTax());
		jsonObj.put("shipping", model.getShipping());
		jsonObj.put("altShipping", model.getAltShipping());
		jsonObj.put("requiresShipping", model.getRequiresShipping());
		jsonObj.put("insure", model.getInsure());
		jsonObj.put("insurance", model.getInsurance());
		jsonObj.put("couponCodes", model.getCouponCodes());
		jsonObj.put("couponDiscount", model.getCouponDiscount());
		jsonObj.put("billingFirstName", model.getBillingFirstName());
		jsonObj.put("billingLastName", model.getBillingLastName());
		jsonObj.put("billingEmailAddress", model.getBillingEmailAddress());
		jsonObj.put("billingCompany", model.getBillingCompany());
		jsonObj.put("billingStreet", model.getBillingStreet());
		jsonObj.put("billingCity", model.getBillingCity());
		jsonObj.put("billingState", model.getBillingState());
		jsonObj.put("billingZip", model.getBillingZip());
		jsonObj.put("billingCountry", model.getBillingCountry());
		jsonObj.put("billingPhone", model.getBillingPhone());
		jsonObj.put("shipToBilling", model.getShipToBilling());
		jsonObj.put("shippingFirstName", model.getShippingFirstName());
		jsonObj.put("shippingLastName", model.getShippingLastName());
		jsonObj.put("shippingEmailAddress", model.getShippingEmailAddress());
		jsonObj.put("shippingCompany", model.getShippingCompany());
		jsonObj.put("shippingStreet", model.getShippingStreet());
		jsonObj.put("shippingCity", model.getShippingCity());
		jsonObj.put("shippingState", model.getShippingState());
		jsonObj.put("shippingZip", model.getShippingZip());
		jsonObj.put("shippingCountry", model.getShippingCountry());
		jsonObj.put("shippingPhone", model.getShippingPhone());
		jsonObj.put("ccName", model.getCcName());
		jsonObj.put("ccType", model.getCcType());
		jsonObj.put("ccNumber", model.getCcNumber());
		jsonObj.put("ccExpMonth", model.getCcExpMonth());
		jsonObj.put("ccExpYear", model.getCcExpYear());
		jsonObj.put("ccVerNumber", model.getCcVerNumber());
		jsonObj.put("comments", model.getComments());
		jsonObj.put("ppTxnId", model.getPpTxnId());
		jsonObj.put("ppPaymentStatus", model.getPpPaymentStatus());
		jsonObj.put("ppPaymentGross", model.getPpPaymentGross());
		jsonObj.put("ppReceiverEmail", model.getPpReceiverEmail());
		jsonObj.put("ppPayerEmail", model.getPpPayerEmail());
		jsonObj.put("sendOrderEmail", model.getSendOrderEmail());
		jsonObj.put("sendShippingEmail", model.getSendShippingEmail());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.liferay.shopping.model.ShoppingOrder[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ShoppingOrder model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.shopping.model.ShoppingOrder[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ShoppingOrder[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.shopping.model.ShoppingOrder> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ShoppingOrder model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}