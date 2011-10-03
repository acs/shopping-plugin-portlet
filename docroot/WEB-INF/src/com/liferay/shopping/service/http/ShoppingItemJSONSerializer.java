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

import com.liferay.shopping.model.ShoppingItem;

import java.util.Date;
import java.util.List;

/**
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class ShoppingItemJSONSerializer {
	public static JSONObject toJSONObject(ShoppingItem model) {
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		jsonObj.put("itemId", model.getItemId());
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
		jsonObj.put("categoryId", model.getCategoryId());
		jsonObj.put("sku", model.getSku());
		jsonObj.put("name", model.getName());
		jsonObj.put("description", model.getDescription());
		jsonObj.put("properties", model.getProperties());
		jsonObj.put("fields", model.getFields());
		jsonObj.put("fieldsQuantities", model.getFieldsQuantities());
		jsonObj.put("minQuantity", model.getMinQuantity());
		jsonObj.put("maxQuantity", model.getMaxQuantity());
		jsonObj.put("price", model.getPrice());
		jsonObj.put("discount", model.getDiscount());
		jsonObj.put("taxable", model.getTaxable());
		jsonObj.put("shipping", model.getShipping());
		jsonObj.put("useShippingFormula", model.getUseShippingFormula());
		jsonObj.put("requiresShipping", model.getRequiresShipping());
		jsonObj.put("stockQuantity", model.getStockQuantity());
		jsonObj.put("featured", model.getFeatured());
		jsonObj.put("sale", model.getSale());
		jsonObj.put("smallImage", model.getSmallImage());
		jsonObj.put("smallImageId", model.getSmallImageId());
		jsonObj.put("smallImageURL", model.getSmallImageURL());
		jsonObj.put("mediumImage", model.getMediumImage());
		jsonObj.put("mediumImageId", model.getMediumImageId());
		jsonObj.put("mediumImageURL", model.getMediumImageURL());
		jsonObj.put("largeImage", model.getLargeImage());
		jsonObj.put("largeImageId", model.getLargeImageId());
		jsonObj.put("largeImageURL", model.getLargeImageURL());

		return jsonObj;
	}

	public static JSONArray toJSONArray(
		com.liferay.shopping.model.ShoppingItem[] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ShoppingItem model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		com.liferay.shopping.model.ShoppingItem[][] models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ShoppingItem[] model : models) {
			jsonArray.put(toJSONArray(model));
		}

		return jsonArray;
	}

	public static JSONArray toJSONArray(
		List<com.liferay.shopping.model.ShoppingItem> models) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ShoppingItem model : models) {
			jsonArray.put(toJSONObject(model));
		}

		return jsonArray;
	}
}