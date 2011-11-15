/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 * Copyright (c) 2011 Andago Ingenieria S.L.. All rights reserved.
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

package com.liferay.shopping;

import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.io.unsync.UnsyncPrintWriter;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.shopping.model.ShoppingCart;
import com.liferay.shopping.model.ShoppingCategory;
import com.liferay.shopping.model.ShoppingCoupon;
import com.liferay.shopping.model.ShoppingItem;
import com.liferay.shopping.model.ShoppingItemField;
import com.liferay.shopping.model.ShoppingItemPrice;
import com.liferay.shopping.model.ShoppingItemPriceConstants;
import com.liferay.shopping.model.ShoppingOrder;
import com.liferay.shopping.service.ShoppingCartLocalServiceUtil;
import com.liferay.shopping.service.ShoppingCategoryServiceUtil;
import com.liferay.shopping.service.ShoppingCouponServiceUtil;
import com.liferay.shopping.service.ShoppingItemLocalServiceUtil;
import com.liferay.shopping.service.ShoppingItemServiceUtil;
import com.liferay.shopping.service.ShoppingOrderLocalServiceUtil;
import com.liferay.shopping.service.ShoppingOrderServiceUtil;
import com.liferay.shopping.service.persistence.ShoppingItemFieldUtil;
import com.liferay.shopping.service.persistence.ShoppingItemPriceUtil;
import com.liferay.shopping.util.ShoppingPreferences;
import com.liferay.shopping.util.ShoppingUtil;
import com.liferay.shopping.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.net.URL;
import java.net.URLConnection;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import java.text.NumberFormat;
import java.util.Locale;

import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;
import com.liferay.shopping.model.ShoppingCartItem;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.checkout.sdk.commands.ApiContext;
import com.google.checkout.sdk.commands.Environment;
import com.google.checkout.sdk.domain.AuthorizationAmountNotification;
import com.google.checkout.sdk.notifications.BaseNotificationDispatcher;
import com.google.checkout.sdk.notifications.Notification;

import com.google.checkout.sdk.domain.FinancialOrderState;
import com.google.checkout.sdk.domain.NewOrderNotification;
import com.google.checkout.sdk.domain.OrderStateChangeNotification;
import com.google.checkout.sdk.domain.OrderSummary;
import com.google.checkout.sdk.notifications.JDBCNotificationDispatcher;
import com.google.checkout.sdk.notifications.NamedDatabaseNotificationDispatcher;

import com.google.checkout.sdk.commands.OrderCommands;
import com.google.checkout.sdk.domain.ChargeAmountNotification;

import java.math.BigDecimal;

/**
 * @author Brian Wing Shun Chan
 * @author Alvaro del Castillo
 */

public class ShoppingPortlet extends MVCPortlet {

	// CATEGORY

	public void deleteCategory(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long categoryId = ParamUtil.getLong(actionRequest, "categoryId");

		ShoppingCategoryServiceUtil.deleteCategory(categoryId);
	}

	public void updateCategory(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long categoryId = ParamUtil.getLong(actionRequest, "categoryId");

			long parentCategoryId =
				ParamUtil.getLong(actionRequest, "parentCategoryId");
			String name = ParamUtil.getString(actionRequest, "name");
			String description =
				ParamUtil.getString(actionRequest, "description");

			boolean mergeWithParentCategory =
				ParamUtil.getBoolean(actionRequest, "mergeWithParentCategory");

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ShoppingCategory.class.getName(), actionRequest);

			if (categoryId <= 0) {

				// Add category

				ShoppingCategoryServiceUtil.addCategory(
					parentCategoryId, name, description, serviceContext);
			}
			else {

				// Update category

				ShoppingCategoryServiceUtil.updateCategory(
					categoryId, parentCategoryId, name, description,
					mergeWithParentCategory, serviceContext);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchCategoryException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				// setForward(actionRequest, "portlet.shopping.error");
				actionResponse.setRenderParameter("jspPage", "/error.jsp");
			}
			else if (e instanceof CategoryNameException) {
				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter(
					"jspPage", "/edit_category.jsp");
			}
			else {
				throw e;
			}
		}
	}

	// ITEM

	public void deleteItem(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		long itemId = ParamUtil.getLong(actionRequest, "itemId");

		ShoppingItemServiceUtil.deleteItem(itemId);
	}

	public void updateItem(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {

			UploadPortletRequest uploadPortletRequest =
				PortalUtil.getUploadPortletRequest(actionRequest);

			ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long itemId = ParamUtil.getLong(uploadPortletRequest, "itemId");

			long groupId = themeDisplay.getScopeGroupId();
			long categoryId =
				ParamUtil.getLong(uploadPortletRequest, "categoryId");
			String sku = ParamUtil.getString(uploadPortletRequest, "sku");
			String name = ParamUtil.getString(uploadPortletRequest, "name");
			String description =
				ParamUtil.getString(uploadPortletRequest, "description");
			String properties =
				ParamUtil.getString(uploadPortletRequest, "properties");

			int fieldsCount =
				ParamUtil.getInteger(uploadPortletRequest, "fieldsCount", 1);

			List<ShoppingItemField> itemFields =
				new ArrayList<ShoppingItemField>();

			for (int i = 0; i < fieldsCount; i++) {
				String fieldName =
					ParamUtil.getString(uploadPortletRequest, "fieldName" + i);
				String fieldValues =
					ParamUtil.getString(uploadPortletRequest, "fieldValues" + i);
				String fieldDescription =
					ParamUtil.getString(
						uploadPortletRequest, "fieldDescription" + i);

				ShoppingItemField itemField = ShoppingItemFieldUtil.create(0);

				itemField.setName(fieldName);
				itemField.setValues(fieldValues);
				itemField.setDescription(fieldDescription);

				itemFields.add(itemField);
			}

			String fieldsQuantities =
				ParamUtil.getString(uploadPortletRequest, "fieldsQuantities");

			int pricesCount =
				ParamUtil.getInteger(uploadPortletRequest, "pricesCount", 1);

			List<ShoppingItemPrice> itemPrices =
				new ArrayList<ShoppingItemPrice>();

			for (int i = 0; i < pricesCount; i++) {
				int minQuantity =
					ParamUtil.getInteger(uploadPortletRequest, "minQuantity" +
						i);
				int maxQuantity =
					ParamUtil.getInteger(uploadPortletRequest, "maxQuantity" +
						i);
				double price =
					ParamUtil.getDouble(uploadPortletRequest, "price" + i);
				double discount =
					ParamUtil.getDouble(uploadPortletRequest, "discount" + i) / 100;
				boolean taxable =
					ParamUtil.getBoolean(uploadPortletRequest, "taxable" + i);
				double shipping =
					ParamUtil.getDouble(uploadPortletRequest, "shipping" + i);
				boolean useShippingFormula =
					ParamUtil.getBoolean(
						uploadPortletRequest, "useShippingFormula" + i);
				boolean active =
					ParamUtil.getBoolean(uploadPortletRequest, "active" + i);
				int defaultPrice =
					ParamUtil.getInteger(uploadPortletRequest, "defaultPrice");

				int status = ShoppingItemPriceConstants.STATUS_ACTIVE_DEFAULT;

				if ((defaultPrice != i) && active) {
					status = ShoppingItemPriceConstants.STATUS_ACTIVE;
				}
				ShoppingItemPrice itemPrice = ShoppingItemPriceUtil.create(0);

				itemPrice.setMinQuantity(minQuantity);
				itemPrice.setMaxQuantity(maxQuantity);
				itemPrice.setPrice(price);
				itemPrice.setDiscount(discount);
				itemPrice.setTaxable(taxable);
				itemPrice.setShipping(shipping);
				itemPrice.setUseShippingFormula(useShippingFormula);
				itemPrice.setStatus(status);

				itemPrices.add(itemPrice);
			}

			boolean requiresShipping =
				ParamUtil.getBoolean(uploadPortletRequest, "requiresShipping");
			int stockQuantity =
				ParamUtil.getInteger(uploadPortletRequest, "stockQuantity");

			boolean featured =
				ParamUtil.getBoolean(uploadPortletRequest, "featured");
			Boolean sale = null;

			boolean smallImage =
				ParamUtil.getBoolean(uploadPortletRequest, "smallImage");
			String smallImageURL =
				ParamUtil.getString(uploadPortletRequest, "smallImageURL");
			File smallFile = uploadPortletRequest.getFile("smallFile");

			boolean mediumImage =
				ParamUtil.getBoolean(uploadPortletRequest, "mediumImage");
			String mediumImageURL =
				ParamUtil.getString(uploadPortletRequest, "mediumImageURL");
			File mediumFile = uploadPortletRequest.getFile("mediumFile");

			boolean largeImage =
				ParamUtil.getBoolean(uploadPortletRequest, "largeImage");
			String largeImageURL =
				ParamUtil.getString(uploadPortletRequest, "largeImageURL");
			File largeFile = uploadPortletRequest.getFile("largeFile");

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ShoppingItem.class.getName(), actionRequest);

			if (itemId <= 0) {

				// Add item

				ShoppingItemServiceUtil.addItem(
					groupId, categoryId, sku, name, description, properties,
					fieldsQuantities, requiresShipping, stockQuantity,
					featured, sale, smallImage, smallImageURL, smallFile,
					mediumImage, mediumImageURL, mediumFile, largeImage,
					largeImageURL, largeFile, itemFields, itemPrices,
					serviceContext);
			}
			else {

				// Update item

				ShoppingItemServiceUtil.updateItem(
					itemId, groupId, categoryId, sku, name, description,
					properties, fieldsQuantities, requiresShipping,
					stockQuantity, featured, sale, smallImage, smallImageURL,
					smallFile, mediumImage, mediumImageURL, mediumFile,
					largeImage, largeImageURL, largeFile, itemFields,
					itemPrices, serviceContext);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchCategoryException ||
				e instanceof NoSuchItemException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				// setForward(actionRequest, "portlet.shopping.error");
				actionResponse.setRenderParameter("jspPage", "/error.jsp");
			}
			else if (e instanceof DuplicateItemSKUException ||
				e instanceof ItemLargeImageNameException ||
				e instanceof ItemLargeImageSizeException ||
				e instanceof ItemMediumImageNameException ||
				e instanceof ItemMediumImageSizeException ||
				e instanceof ItemNameException ||
				e instanceof ItemSKUException ||
				e instanceof ItemSmallImageNameException ||
				e instanceof ItemSmallImageSizeException) {

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("jspPage", "/edit_item.jsp");
			}
			else {
				throw e;
			}
		}
	}

	// COUPONS

	public void deleteCoupons(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long[] deleteCouponIds =
			StringUtil.split(
				ParamUtil.getString(actionRequest, "deleteCouponIds"), 0L);

		for (int i = 0; i < deleteCouponIds.length; i++) {
			ShoppingCouponServiceUtil.deleteCoupon(
				themeDisplay.getScopeGroupId(), deleteCouponIds[i]);
		}
	}

	public void updateCoupon(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long couponId = ParamUtil.getLong(actionRequest, "couponId");

			String code = ParamUtil.getString(actionRequest, "code");
			boolean autoCode = ParamUtil.getBoolean(actionRequest, "autoCode");

			String name = ParamUtil.getString(actionRequest, "name");
			String description =
				ParamUtil.getString(actionRequest, "description");

			int startDateMonth =
				ParamUtil.getInteger(actionRequest, "startDateMonth");
			int startDateDay =
				ParamUtil.getInteger(actionRequest, "startDateDay");
			int startDateYear =
				ParamUtil.getInteger(actionRequest, "startDateYear");
			int startDateHour =
				ParamUtil.getInteger(actionRequest, "startDateHour");
			int startDateMinute =
				ParamUtil.getInteger(actionRequest, "startDateMinute");
			int startDateAmPm =
				ParamUtil.getInteger(actionRequest, "startDateAmPm");

			if (startDateAmPm == Calendar.PM) {
				startDateHour += 12;
			}

			int endDateMonth =
				ParamUtil.getInteger(actionRequest, "endDateMonth");
			int endDateDay = ParamUtil.getInteger(actionRequest, "endDateDay");
			int endDateYear =
				ParamUtil.getInteger(actionRequest, "endDateYear");
			int endDateHour =
				ParamUtil.getInteger(actionRequest, "endDateHour");
			int endDateMinute =
				ParamUtil.getInteger(actionRequest, "endDateMinute");
			int endDateAmPm =
				ParamUtil.getInteger(actionRequest, "endDateAmPm");
			boolean neverExpire =
				ParamUtil.getBoolean(actionRequest, "neverExpire");

			if (endDateAmPm == Calendar.PM) {
				endDateHour += 12;
			}

			boolean active = ParamUtil.getBoolean(actionRequest, "active");
			String limitCategories =
				ParamUtil.getString(actionRequest, "limitCategories");
			String limitSkus = ParamUtil.getString(actionRequest, "limitSkus");
			double minOrder =
				ParamUtil.getDouble(actionRequest, "minOrder", -1.0);
			double discount =
				ParamUtil.getDouble(actionRequest, "discount", -1.0);
			String discountType =
				ParamUtil.getString(actionRequest, "discountType");

			ServiceContext serviceContext =
				ServiceContextFactory.getInstance(
					ShoppingCoupon.class.getName(), actionRequest);

			if (couponId <= 0) {

				// Add coupon
				_log.error("AA CouponId: " + couponId);

				ShoppingCouponServiceUtil.addCoupon(
					code, autoCode, name, description, startDateMonth,
					startDateDay, startDateYear, startDateHour,
					startDateMinute, endDateMonth, endDateDay, endDateYear,
					endDateHour, endDateMinute, neverExpire, active,
					limitCategories, limitSkus, minOrder, discount,
					discountType, serviceContext);
			}
			else {

				// Update coupon
				_log.error("UPDATE CouponId: " + couponId);

				ShoppingCouponServiceUtil.updateCoupon(
					couponId, name, description, startDateMonth, startDateDay,
					startDateYear, startDateHour, startDateMinute,
					endDateMonth, endDateDay, endDateYear, endDateHour,
					endDateMinute, neverExpire, active, limitCategories,
					limitSkus, minOrder, discount, discountType, serviceContext);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchCouponException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				// setForward(actionRequest, "portlet.shopping.error");
				actionResponse.setRenderParameter("jspPage", "/error.jsp");
			}
			else if (e instanceof CouponCodeException ||
				e instanceof CouponDateException ||
				e instanceof CouponDescriptionException ||
				e instanceof CouponDiscountException ||
				e instanceof CouponEndDateException ||
				e instanceof CouponLimitCategoriesException ||
				e instanceof CouponLimitSKUsException ||
				e instanceof CouponMinimumOrderException ||
				e instanceof CouponNameException ||
				e instanceof CouponStartDateException ||
				e instanceof DuplicateCouponCodeException) {

				if (e instanceof CouponLimitCategoriesException) {
					CouponLimitCategoriesException clce =
						(CouponLimitCategoriesException) e;

					SessionErrors.add(
						actionRequest, e.getClass().getName(),
						clce.getCategoryIds());
				}
				else if (e instanceof CouponLimitSKUsException) {
					CouponLimitSKUsException clskue =
						(CouponLimitSKUsException) e;

					SessionErrors.add(
						actionRequest, e.getClass().getName(), clskue.getSkus());
				}
				else {
					SessionErrors.add(actionRequest, e.getClass().getName());
				}
				actionResponse.setRenderParameter("jspPage", "/edit_coupon.jsp");
			}
			else {
				throw e;
			}
		}

	}

	// CART
	public void updateCart(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {

			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			ShoppingCart cart = ShoppingUtil.getCart(actionRequest);

			if (cmd.equals(Constants.ADD)) {
				long itemId = ParamUtil.getLong(actionRequest, "itemId");

				String fields = ParamUtil.getString(actionRequest, "fields");

				if (Validator.isNotNull(fields)) {
					fields = "|" + fields;
				}

				ShoppingItem item =
					ShoppingItemLocalServiceUtil.getItem(itemId);

				if (item.getMinQuantity() > 0) {
					for (int i = 0; i < item.getMinQuantity(); i++) {
						cart.addItemId(itemId, fields);
					}
				}
				else {
					cart.addItemId(itemId, fields);
				}
			}
			else {
				String itemIds = ParamUtil.getString(actionRequest, "itemIds");
				String couponCodes =
					ParamUtil.getString(actionRequest, "couponCodes");
				int altShipping =
					ParamUtil.getInteger(actionRequest, "altShipping");
				boolean insure = ParamUtil.getBoolean(actionRequest, "insure");

				cart.setItemIds(itemIds);
				cart.setCouponCodes(couponCodes);
				cart.setAltShipping(altShipping);
				cart.setInsure(insure);
			}

			ShoppingCartLocalServiceUtil.updateCart(
				cart.getUserId(), cart.getGroupId(), cart.getItemIds(),
				cart.getCouponCodes(), cart.getAltShipping(), cart.isInsure());

			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				addSuccessMessage(actionRequest, actionResponse);
				actionResponse.setRenderParameter("jspPage", "/cart.jsp");
			}

		}
		catch (Exception e) {
			if (e instanceof NoSuchItemException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				// setForward(actionRequest, "portlet.shopping.error");
			}
			else if (e instanceof CartMinQuantityException ||
				e instanceof CouponActiveException ||
				e instanceof CouponEndDateException ||
				e instanceof CouponStartDateException ||
				e instanceof NoSuchCouponException) {

				_log.error("Cart Exception: " + e.getClass().getName());
				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw e;
			}
		}

	}

	// ORDERS

	public void deleteOrders(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long[] deleteOrderIds =
			StringUtil.split(
				ParamUtil.getString(actionRequest, "deleteOrderIds"), 0L);

		for (int i = 0; i < deleteOrderIds.length; i++) {
			ShoppingOrderServiceUtil.deleteOrder(
				themeDisplay.getScopeGroupId(), deleteOrderIds[i]);
		}
	}

	public void sendEmail(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long orderId = ParamUtil.getLong(actionRequest, "orderId");

		String emailType = ParamUtil.getString(actionRequest, "emailType");

		ShoppingOrderServiceUtil.sendEmail(
			themeDisplay.getScopeGroupId(), orderId, emailType);
	}

	public void updateOrder(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {

			ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			String number = ParamUtil.getString(actionRequest, "number");
			String ppTxnId = ParamUtil.getString(actionRequest, "ppTxnId");
			String ppPaymentStatus =
				ShoppingUtil.getPpPaymentStatus(ParamUtil.getString(
					actionRequest, "ppPaymentStatus"));
			double ppPaymentGross =
				ParamUtil.getDouble(actionRequest, "ppPaymentGross");
			String ppReceiverEmail =
				ParamUtil.getString(actionRequest, "ppReceiverEmail");
			String ppPayerEmail =
				ParamUtil.getString(actionRequest, "ppPayerEmail");

			ShoppingOrderServiceUtil.completeOrder(
				themeDisplay.getScopeGroupId(), number, ppTxnId,
				ppPaymentStatus, ppPaymentGross, ppReceiverEmail, ppPayerEmail);
		}
		catch (Exception e) {
			if (e instanceof NoSuchOrderException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter("jspPage", "/error.jsp");
				// return mapping.findForward("portlet.shopping.error");
			}
			else {
				throw e;
			}
		}

	}

	// CHECKOUT

	public void updateLatestOrder(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String billingFirstName =
			ParamUtil.getString(actionRequest, "billingFirstName");
		String billingLastName =
			ParamUtil.getString(actionRequest, "billingLastName");
		String billingEmailAddress =
			ParamUtil.getString(actionRequest, "billingEmailAddress");
		String billingCompany =
			ParamUtil.getString(actionRequest, "billingCompany");
		String billingStreet =
			ParamUtil.getString(actionRequest, "billingStreet");
		String billingCity = ParamUtil.getString(actionRequest, "billingCity");

		String billingStateSel =
			ParamUtil.getString(actionRequest, "billingStateSel");
		String billingState = billingStateSel;
		if (Validator.isNull(billingStateSel)) {
			billingState = ParamUtil.getString(actionRequest, "billingState");
		}

		String billingZip = ParamUtil.getString(actionRequest, "billingZip");
		String billingCountry =
			ParamUtil.getString(actionRequest, "billingCountry");
		String billingPhone =
			ParamUtil.getString(actionRequest, "billingPhone");

		boolean shipToBilling =
			ParamUtil.getBoolean(actionRequest, "shipToBilling");
		String shippingFirstName =
			ParamUtil.getString(actionRequest, "shippingFirstName");
		String shippingLastName =
			ParamUtil.getString(actionRequest, "shippingLastName");
		String shippingEmailAddress =
			ParamUtil.getString(actionRequest, "shippingEmailAddress");
		String shippingCompany =
			ParamUtil.getString(actionRequest, "shippingCompany");
		String shippingStreet =
			ParamUtil.getString(actionRequest, "shippingStreet");
		String shippingCity =
			ParamUtil.getString(actionRequest, "shippingCity");

		String shippingStateSel =
			ParamUtil.getString(actionRequest, "shippingStateSel");
		String shippingState = shippingStateSel;
		if (Validator.isNull(shippingStateSel)) {
			shippingState = ParamUtil.getString(actionRequest, "shippingState");
		}

		String shippingZip = ParamUtil.getString(actionRequest, "shippingZip");
		String shippingCountry =
			ParamUtil.getString(actionRequest, "shippingCountry");
		String shippingPhone =
			ParamUtil.getString(actionRequest, "shippingPhone");

		String ccName = ParamUtil.getString(actionRequest, "ccName");
		String ccType = ParamUtil.getString(actionRequest, "ccType");
		String ccNumber = ParamUtil.getString(actionRequest, "ccNumber");
		int ccExpMonth = ParamUtil.getInteger(actionRequest, "ccExpMonth");
		int ccExpYear = ParamUtil.getInteger(actionRequest, "ccExpYear");
		String ccVerNumber = ParamUtil.getString(actionRequest, "ccVerNumber");

		String comments = ParamUtil.getString(actionRequest, "comments");

		try {
			ShoppingOrder order =
				ShoppingOrderLocalServiceUtil.updateLatestOrder(
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					billingFirstName, billingLastName, billingEmailAddress,
					billingCompany, billingStreet, billingCity, billingState,
					billingZip, billingCountry, billingPhone, shipToBilling,
					shippingFirstName, shippingLastName, shippingEmailAddress,
					shippingCompany, shippingStreet, shippingCity,
					shippingState, shippingZip, shippingCountry, shippingPhone,
					ccName, ccType, ccNumber, ccExpMonth, ccExpYear,
					ccVerNumber, comments);

			actionRequest.setAttribute(WebKeys.SHOPPING_ORDER, order);
			actionResponse.setRenderParameter("jspPage", "/checkout_second.jsp");
		}
		catch (Exception e) {
			if (e instanceof BillingCityException ||
				e instanceof BillingCountryException ||
				e instanceof BillingEmailAddressException ||
				e instanceof BillingFirstNameException ||
				e instanceof BillingLastNameException ||
				e instanceof BillingPhoneException ||
				e instanceof BillingStateException ||
				e instanceof BillingStreetException ||
				e instanceof BillingZipException ||
				e instanceof CCExpirationException ||
				e instanceof CCNameException ||
				e instanceof CCNumberException ||
				e instanceof CCTypeException ||
				e instanceof ShippingCityException ||
				e instanceof ShippingCountryException ||
				e instanceof ShippingEmailAddressException ||
				e instanceof ShippingFirstNameException ||
				e instanceof ShippingLastNameException ||
				e instanceof ShippingPhoneException ||
				e instanceof ShippingStateException ||
				e instanceof ShippingStreetException ||
				e instanceof ShippingZipException) {

				SessionErrors.add(actionRequest, e.getClass().getName());
				actionResponse.setRenderParameter(
					"jspPage", "/checkout_first.jsp");

				// setForward(
				// actionRequest, "portlet.shopping.checkout_first");
			}
			// else if (e instanceof PrincipalException) {
			// setForward(actionRequest, "portlet.shopping.error");
			// }
			else {
				throw e;
			}
		}
	}

	public void saveLatestOrder(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		LiferayPortletResponse liferayPortletResponse =
			(LiferayPortletResponse) actionResponse;

		// updateCart(actionRequest, actionResponse);
		// updateLatestOrder(actionRequest, actionResponse);

		ShoppingCart cart = ShoppingUtil.getCart(actionRequest);

		ShoppingOrder order =
			ShoppingOrderLocalServiceUtil.saveLatestOrder(cart);

		actionRequest.setAttribute(WebKeys.SHOPPING_ORDER, order);

		ShoppingPreferences preferences =
			ShoppingPreferences.getInstance(
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());

		if (preferences.usePayPal()) {
			String returnURL =
				ShoppingUtil.getPayPalReturnURL(
					liferayPortletResponse.createActionURL(), order);
			String notifyURL = ShoppingUtil.getPayPalNotifyURL(themeDisplay);

			double total =
				ShoppingUtil.calculateTotal(
					cart.getItems(), order.getBillingState(), cart.getCoupon(),
					cart.getAltShipping(), cart.isInsure());

			String redirectURL =
				ShoppingUtil.getPayPalRedirectURL(
					preferences, order, total, returnURL, notifyURL);

			_log.error(redirectURL);
			actionResponse.sendRedirect(redirectURL);
		}
		else if (preferences.useGoogleCheckout()) {

			_log.error("Using GoogleCheckout to pay this order...");

			String returnURL =
				ShoppingUtil.getGoogleCheckoutReturnURL(
					liferayPortletResponse.createActionURL(), order);
			String notifyURL =
				ShoppingUtil.getGoogleCheckoutNotifyURL(themeDisplay);

			double total =
				ShoppingUtil.calculateTotal(
					cart.getItems(), order.getBillingState(), cart.getCoupon(),
					cart.getAltShipping(), cart.isInsure());

			String currencyId = preferences.getCurrencyId();

			String redirectURL = ShoppingUtil.getGoogleCheckoutRedirectURL();

			_log.error(redirectURL);

			String Authorization_Key =
				"ODY5Mzg3NDY4ODAzMzgwOkxudU5rTnlZTk5pU0dpR2hYMHNXdHc";
			
			String couponDiscountName = null;
			String couponDiscountDescription = null;
			double couponDiscount = 0;
			
			if (cart.getCoupon()!=null)
			{
				couponDiscountName = 
						cart.getCoupon().getName();
		        
				couponDiscountDescription = 
						cart.getCoupon().getDescription();
		        
				couponDiscount = 
						ShoppingUtil.calculateCouponDiscount(cart.getItems(), cart.getCoupon());
			}

			// Build parameter string

			Map<ShoppingCartItem, Integer> items = cart.getItems();
			Iterator<Map.Entry<ShoppingCartItem, Integer>> itr =
				items.entrySet().iterator();

			String data =
				" <?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+ "<checkout-shopping-cart xmlns=\"http://checkout.google.com/schema/2\">"
					+ "<shopping-cart>" + " <items>";

			while (itr.hasNext()) {
				Map.Entry<ShoppingCartItem, Integer> entry = itr.next();

				ShoppingCartItem cartItem = entry.getKey();
				Integer count = entry.getValue();

				ShoppingItem item = cartItem.getItem();

				data =
					data + "  <item>" + "   <item-name>" + item.getName() +
						"</item-name>";

				if (item.getDescription() != null &&
					!item.getDescription().equals("")) {
					data =
						data + " <item-description>" + item.getDescription() +
							"</item-description>";
				}

				data =
					data + " <unit-price currency=\"" + currencyId + "\">" +
						item.getPrice() + "</unit-price>" + " <quantity>" +
						count + "</quantity>" + " </item>";
			}
			
			
			if (cart.getCoupon()!=null && couponDiscountName!=null && couponDiscount>0)
            {
            	_log.error("Añadimos descuento: "+couponDiscountName+" cuyo valor total es: "+couponDiscount);
            	data = data+ "  <item>"+
                        "   <item-name>"+couponDiscountName+"</item-name>";
            	 data = data+" <item-description>"+couponDiscountDescription+"</item-description>";
            	 data = data+   " <unit-price currency=\""+currencyId+"\">-"+couponDiscount+"</unit-price>"+
                          " <quantity>1</quantity>"+
                        " </item>";
            }
			

			data =
				data + " </items>" + "<merchant-private-data>" +
					"<merchant-note>" + order.getNumber() + "</merchant-note>" +
					"</merchant-private-data>" + " </shopping-cart>" +
					" </checkout-shopping-cart>";

			_log.error(data);

			OutputStreamWriter writer = null;
			BufferedReader reader = null;

			try {

				// Send the request
				URL url = new URL(redirectURL);
				URLConnection conn = url.openConnection();
				conn.setDoOutput(true);

				conn.setRequestProperty("Authorization", "Basic " +
					Authorization_Key);
				conn.setRequestProperty(
					"Content-Type", "application/xml; charset=UTF-8");
				conn.setRequestProperty(
					"Accept", "application/xml; charset=UTF-8");

				writer = new OutputStreamWriter(conn.getOutputStream());

				// write parameters
				writer.write(data);
				writer.flush();

				// Get the response
				StringBuffer answer = new StringBuffer();
				reader =
					new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				String line;
				while ((line = reader.readLine()) != null) {
					answer.append(line);
				}

				String sAnswer = answer.toString();

				// Output the response
				_log.error("ANSWER FROM SERVER: " + sAnswer);

				String GCredirectURL =
					sAnswer.substring(
						sAnswer.indexOf("<redirect-url>") + 14,
						sAnswer.indexOf("</redirect-url>"));
				GCredirectURL = GCredirectURL.replaceAll("amp;", "");

				_log.error("redirectUrl: " + GCredirectURL);

				actionResponse.sendRedirect(GCredirectURL);

			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			finally {
				writer.close();
				reader.close();
			}

		}

		else {
			ShoppingOrderLocalServiceUtil.sendEmail(order, "confirmation");
			actionResponse.setRenderParameter("jspPage", "/checkout_third.jsp");
		}
	}

	public void editOrder(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateOrder(actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteOrders(actionRequest, actionResponse);
			}
			else if (cmd.equals("sendEmail")) {
				sendEmail(actionRequest, actionResponse);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof NoSuchOrderException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				// setForward(actionRequest, "portlet.shopping.error");
			}
			else {
				throw e;
			}
		}
	}

	// PayPal Notification
	public void paypalNotification(
		ActionRequest request, ActionResponse response)
		throws Exception {

		String invoice = null;

		_log.error("Receiving notification from PayPal");

		try {
			if (_log.isDebugEnabled()) {
				_log.debug("Receiving notification from PayPal");
			}

			String query = "cmd=_notify-validate";

			Enumeration<String> enu = request.getParameterNames();

			while (enu.hasMoreElements()) {
				String name = enu.nextElement();

				String value = request.getParameter(name);

				query = query + "&" + name + "=" + HttpUtil.encodeURL(value);
			}

			if (_log.isDebugEnabled()) {
				_log.debug("Sending response to PayPal " + query);
			}

			URL url = new URL("https://www.paypal.com/cgi-bin/webscr");

			URLConnection urlc = url.openConnection();

			urlc.setDoOutput(true);
			urlc.setRequestProperty(
				"Content-Type", "application/x-www-form-urlencoded");

			PrintWriter pw = new UnsyncPrintWriter(urlc.getOutputStream());

			pw.println(query);

			pw.close();

			UnsyncBufferedReader unsyncBufferedReader =
				new UnsyncBufferedReader(new InputStreamReader(
					urlc.getInputStream()));

			String payPalStatus = unsyncBufferedReader.readLine();

			unsyncBufferedReader.close();
			String itemName = ParamUtil.getString(request, "item_name");
			String itemNumber = ParamUtil.getString(request, "item_number");
			invoice = ParamUtil.getString(request, "invoice");
			String txnId = ParamUtil.getString(request, "txn_id");
			String paymentStatus =
				ParamUtil.getString(request, "payment_status");
			double paymentGross = ParamUtil.getDouble(request, "mc_gross");
			String receiverEmail =
				ParamUtil.getString(request, "receiver_email");
			String payerEmail = ParamUtil.getString(request, "payer_email");

			_log.error("Receiving response from PayPal " + payPalStatus);
			if (_log.isDebugEnabled()) {
				_log.debug("Receiving response from PayPal");
				_log.debug("Item name " + itemName);
				_log.debug("Item number " + itemNumber);
				_log.debug("Invoice " + invoice);
				_log.debug("Transaction ID " + txnId);
				_log.debug("Payment status " + paymentStatus);
				_log.debug("Payment gross " + paymentGross);
				_log.debug("Receiver email " + receiverEmail);
				_log.debug("Payer email " + payerEmail);
			}

			if (payPalStatus.equals("VERIFIED") && validate(request)) {
				ShoppingOrderLocalServiceUtil.completeOrder(
					invoice, txnId, paymentStatus, paymentGross, receiverEmail,
					payerEmail, true);
			}
			else if (payPalStatus.equals("INVALID")) {
			}
		}
		catch (Exception e) {
			PortalUtil.sendError(e, request, response);
		}
	}

	// GoogleCheckout Notification
	public void GoogleCheckoutNotification(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		_log.error("Receiving notification from GoogleCheckout");

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		ShoppingPreferences preferences =
			ShoppingPreferences.getInstance(
				themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId());
		String currencyId = preferences.getCurrencyId();

		final ApiContext api =
			new ApiContext(
				Environment.SANDBOX, "869387468803380",
				"LnuNkNyYNNiSGiGhX0sWtw", currencyId);

		try {

			HttpServletRequest request =
				PortalUtil.getHttpServletRequest(actionRequest);
			HttpServletResponse response =
				PortalUtil.getHttpServletResponse(actionResponse);

			api.handleNotification(new BaseNotificationDispatcher(
				request, response) {

				Map<String, OrderSummary> orders =
					new LinkedHashMap<String, OrderSummary>();

				@Override
				public void onAllNotifications(
					OrderSummary orderSummary, Notification notification)
					throws Exception {

					try {
						String GCorderId = orderSummary.getGoogleOrderNumber();
						String sNotification = notification.toString();
						String OrderNumber =
							sNotification.substring(
								sNotification.indexOf("<merchant-note>") + 15,
								sNotification.indexOf("</merchant-note>"));

						_log.error("Processing notification of OrderNumber " +
							OrderNumber + " and GCorderId " + GCorderId);
						_log.error(sNotification);

						ArrayList<String> GCorderIds = new ArrayList<String>();
						GCorderIds.add(GCorderId);
						List<OrderSummary> oss =
							api.reportsRequester().requestOrderSummaries(
								GCorderIds);

						FinancialOrderState status = null;

						for (OrderSummary os : oss) {

							BigDecimal orderTotal = null;
							BigDecimal chargedTotal = null;

							status = os.getFinancialOrderState();
							String sStatus = status.value();

							_log.error("Fulfilment state: " +
								os.getFulfillmentOrderState());
							_log.error("Financial state: " + sStatus);

							// Order is ready to be charged
							if (sStatus.equals("CHARGEABLE")) {
								_log.error("Charging ordernumber " + GCorderId);

								OrderCommands oc = api.orderCommands(GCorderId);
								ChargeAmountNotification can =
									oc.chargeAndShipOrder();

								boolean result = false;

								try {
									orderTotal =
										can.getOrderSummary().getOrderTotal().getValue();
									chargedTotal =
										can.getTotalChargeAmount().getValue();
									result = orderTotal.equals(chargedTotal);
								}
								catch (Exception e) {
									result = false;
								}
								_log.error("result of Charging OrderNumber " +
									OrderNumber + " and GCorderId " +
									GCorderId + ": " + result);

								// Order has been charged, so now we can
								// activate services or ship items
							}
							else if (sStatus.equals("CHARGED")) {
								_log.error("Activating services and shipping items associated to OrderNumber " +
									OrderNumber + " and GCorderId " + GCorderId);

								String invoice = OrderNumber;
								String txnId = GCorderId;
								String paymentStatus = "CHARGED";
								double paymentGross =
									Double.valueOf(sNotification.substring(
										sNotification.indexOf("<order-total currency=") + 28,
										sNotification.indexOf("</order-total>")));
								_log.error("paymentGross: " + paymentGross);
								String receiverEmail = "seller.csp@gmail.com";
								String payerEmail =
									sNotification.substring(
										sNotification.indexOf("<email>") + 7,
										sNotification.indexOf("</email>"));
								_log.error("Updating order status in BBDD");
								ShoppingOrderLocalServiceUtil.completeOrder(
									invoice, txnId, paymentStatus,
									paymentGross, receiverEmail, payerEmail,
									true);

							}

							orders.put(
								orderSummary.getGoogleOrderNumber(),
								orderSummary);

						}

					}
					catch (Exception e) {
						_log.error("error in onAllNotifications: " +
							e.getMessage());
						throw e;
					}

				}

				@Override
				public void onAuthorizationAmountNotification(
					OrderSummary orderSummary,
					AuthorizationAmountNotification notification) {

					_log.error("Order " + notification.getGoogleOrderNumber() +
						" authorized and ready to ship to:" +
						orderSummary.getBuyerShippingAddress().getContactName());
				}

				@Override
				protected void rememberSerialNumber(
					String serialNumber, OrderSummary orderSummary,
					Notification notification) {

					// NOTE: We'll have to remember serial numbers in our
					// database,
					// before using this for real
				}

				@Override
				public boolean hasAlreadyHandled(
					String serialNumber, OrderSummary orderSummary,
					Notification notification) {

					// NOTE: We'll have to look up serial numbers in our
					// database
					// before using this for real
					return false;
				}
			});

		}
		catch (Exception e) {
			PortalUtil.sendError(e, actionRequest, actionResponse);
		}

	}

	protected boolean validate(ActionRequest request)
		throws Exception {

		// Invoice

		String ppInvoice = ParamUtil.getString(request, "invoice");

		ShoppingOrder order = ShoppingOrderLocalServiceUtil.getOrder(ppInvoice);

		ShoppingPreferences shoppingPrefs =
			ShoppingPreferences.getInstance(
				order.getCompanyId(), order.getGroupId());

		// Receiver email address

		String ppReceiverEmail = ParamUtil.getString(request, "receiver_email");

		String payPalEmailAddress = shoppingPrefs.getPayPalEmailAddress();

		if (!payPalEmailAddress.equals(ppReceiverEmail)) {
			return false;
		}

		// Payment gross

		double ppGross = ParamUtil.getDouble(request, "mc_gross");

		double orderTotal = ShoppingUtil.calculateTotal(order);

		if (orderTotal != ppGross) {
			return false;
		}

		// Payment currency

		String ppCurrency = ParamUtil.getString(request, "mc_currency");

		String currencyId = shoppingPrefs.getCurrencyId();

		if (!currencyId.equals(ppCurrency)) {
			return false;
		}

		// Transaction ID

		String ppTxnId = ParamUtil.getString(request, "txn_id");

		try {
			ShoppingOrderLocalServiceUtil.getPayPalTxnIdOrder(ppTxnId);

			return false;
		}
		catch (NoSuchOrderException nsoe) {
		}

		return true;
	}

	private static Log _log = LogFactoryUtil.getLog(ShoppingPortlet.class);
}
