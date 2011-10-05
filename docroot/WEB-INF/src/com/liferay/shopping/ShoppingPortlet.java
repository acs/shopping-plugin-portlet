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


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import com.liferay.shopping.CartMinQuantityException;
import com.liferay.shopping.CouponActiveException;
import com.liferay.shopping.CouponEndDateException;
import com.liferay.shopping.CouponStartDateException;
import com.liferay.shopping.NoSuchCouponException;
import com.liferay.shopping.NoSuchItemException;

import com.liferay.shopping.BillingCityException;
import com.liferay.shopping.BillingCountryException;
import com.liferay.shopping.BillingEmailAddressException;
import com.liferay.shopping.BillingFirstNameException;
import com.liferay.shopping.BillingLastNameException;
import com.liferay.shopping.BillingPhoneException;
import com.liferay.shopping.BillingStateException;
import com.liferay.shopping.BillingStreetException;
import com.liferay.shopping.BillingZipException;
import com.liferay.shopping.CCExpirationException;
import com.liferay.shopping.CCNameException;
import com.liferay.shopping.CCNumberException;
import com.liferay.shopping.CCTypeException;
import com.liferay.shopping.ShippingCityException;
import com.liferay.shopping.ShippingCountryException;
import com.liferay.shopping.ShippingEmailAddressException;
import com.liferay.shopping.ShippingFirstNameException;
import com.liferay.shopping.ShippingLastNameException;
import com.liferay.shopping.ShippingPhoneException;
import com.liferay.shopping.ShippingStateException;
import com.liferay.shopping.ShippingStreetException;
import com.liferay.shopping.ShippingZipException;

import com.liferay.shopping.model.ShoppingCart;
import com.liferay.shopping.model.ShoppingCategory;
import com.liferay.shopping.model.ShoppingCoupon;
import com.liferay.shopping.model.ShoppingItem;
import com.liferay.shopping.model.ShoppingItemField;
import com.liferay.shopping.model.ShoppingItemPrice;
import com.liferay.shopping.model.ShoppingItemPriceConstants;
import com.liferay.shopping.model.ShoppingOrder;
import com.liferay.shopping.service.persistence.ShoppingItemFieldUtil;
import com.liferay.shopping.service.persistence.ShoppingItemPriceUtil;
import com.liferay.shopping.service.ShoppingCartLocalServiceUtil;
import com.liferay.shopping.service.ShoppingCategoryServiceUtil;
import com.liferay.shopping.service.ShoppingCouponServiceUtil;
import com.liferay.shopping.service.ShoppingItemLocalServiceUtil;
import com.liferay.shopping.service.ShoppingItemServiceUtil;
import com.liferay.shopping.service.ShoppingOrderServiceUtil;
import com.liferay.shopping.service.ShoppingOrderLocalServiceUtil;
import com.liferay.shopping.util.ShoppingUtil;
import com.liferay.shopping.util.WebKeys;

import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Brian Wing Shun Chan
 * @author Alvaro del Castillo
 */


public class ShoppingPortlet extends MVCPortlet {

    // CATEGORY

    public void addCategory (
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        updateCategory (actionRequest, actionResponse);
    }

    public void deleteCategory(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        long categoryId = ParamUtil.getLong(actionRequest, "categoryId");

        ShoppingCategoryServiceUtil.deleteCategory(categoryId);
    }

    protected void updateCategory (
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {

        long categoryId = ParamUtil.getLong(actionRequest, "categoryId");

        long parentCategoryId = ParamUtil.getLong(
            actionRequest, "parentCategoryId");
        String name = ParamUtil.getString(actionRequest, "name");
        String description = ParamUtil.getString(actionRequest, "description");

        boolean mergeWithParentCategory = ParamUtil.getBoolean(
            actionRequest, "mergeWithParentCategory");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            ShoppingCategory.class.getName(), actionRequest);

       
        try {
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
        } catch (Exception ex) {
            actionResponse.setRenderParameter("jspPage","/edit_category.jsp");
            throw ex;
        }
    }

    // ITEM

    public void deleteItem (
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {

        long itemId = ParamUtil.getLong(actionRequest, "itemId");

        ShoppingItemServiceUtil.deleteItem(itemId);
    }

    public void updateItem(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        UploadPortletRequest uploadPortletRequest =
            PortalUtil.getUploadPortletRequest(actionRequest);

        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
            WebKeys.THEME_DISPLAY);

        long itemId = ParamUtil.getLong(uploadPortletRequest, "itemId");

        long groupId = themeDisplay.getScopeGroupId();
        long categoryId = ParamUtil.getLong(uploadPortletRequest, "categoryId");
        String sku = ParamUtil.getString(uploadPortletRequest, "sku");
        String name = ParamUtil.getString(uploadPortletRequest, "name");
        String description = ParamUtil.getString(
            uploadPortletRequest, "description");
        String properties = ParamUtil.getString(
            uploadPortletRequest, "properties");

        int fieldsCount = ParamUtil.getInteger(
            uploadPortletRequest, "fieldsCount", 1);

        List<ShoppingItemField> itemFields = new ArrayList<ShoppingItemField>();

        for (int i = 0; i < fieldsCount; i ++) {
            String fieldName = ParamUtil.getString(
                uploadPortletRequest, "fieldName" + i);
            String fieldValues = ParamUtil.getString(
                uploadPortletRequest, "fieldValues" + i);
            String fieldDescription = ParamUtil.getString(
                uploadPortletRequest, "fieldDescription" + i);

            ShoppingItemField itemField = ShoppingItemFieldUtil.create(0);

            itemField.setName(fieldName);
            itemField.setValues(fieldValues);
            itemField.setDescription(fieldDescription);

            itemFields.add(itemField);
        }

        String fieldsQuantities = ParamUtil.getString(
            uploadPortletRequest, "fieldsQuantities");

        int pricesCount = ParamUtil.getInteger(
            uploadPortletRequest, "pricesCount", 1);

        List<ShoppingItemPrice> itemPrices = new ArrayList<ShoppingItemPrice>();

        for (int i = 0; i < pricesCount; i ++) {
            int minQuantity = ParamUtil.getInteger(
                uploadPortletRequest, "minQuantity" + i);
            int maxQuantity = ParamUtil.getInteger(
                uploadPortletRequest, "maxQuantity" + i);
            double price = ParamUtil.getDouble(
                uploadPortletRequest, "price" + i);
            double discount = ParamUtil.getDouble(
                uploadPortletRequest, "discount" + i) / 100;
            boolean taxable = ParamUtil.getBoolean(
                uploadPortletRequest, "taxable" + i);
            double shipping = ParamUtil.getDouble(
                uploadPortletRequest, "shipping" + i);
            boolean useShippingFormula = ParamUtil.getBoolean(
                uploadPortletRequest, "useShippingFormula" + i);
            boolean active = ParamUtil.getBoolean(
                uploadPortletRequest, "active" + i);
            int defaultPrice = ParamUtil.getInteger(
                uploadPortletRequest, "defaultPrice");

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

        boolean requiresShipping = ParamUtil.getBoolean(
            uploadPortletRequest, "requiresShipping");
        int stockQuantity = ParamUtil.getInteger(
            uploadPortletRequest, "stockQuantity");

        boolean featured = ParamUtil.getBoolean(
            uploadPortletRequest, "featured");
        Boolean sale = null;

        boolean smallImage = ParamUtil.getBoolean(
            uploadPortletRequest, "smallImage");
        String smallImageURL = ParamUtil.getString(
            uploadPortletRequest, "smallImageURL");
        File smallFile = uploadPortletRequest.getFile("smallFile");

        boolean mediumImage = ParamUtil.getBoolean(
            uploadPortletRequest, "mediumImage");
       String mediumImageURL = ParamUtil.getString(
            uploadPortletRequest, "mediumImageURL");
        File mediumFile = uploadPortletRequest.getFile("mediumFile");

        boolean largeImage = ParamUtil.getBoolean(
            uploadPortletRequest, "largeImage");
        String largeImageURL = ParamUtil.getString(
            uploadPortletRequest, "largeImageURL");
        File largeFile = uploadPortletRequest.getFile("largeFile");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            ShoppingItem.class.getName(), actionRequest);

    
        if (itemId <= 0) {

            // Add item

            ShoppingItemServiceUtil.addItem(
                groupId, categoryId, sku, name, description, properties,
                fieldsQuantities, requiresShipping, stockQuantity, featured,
                sale, smallImage, smallImageURL, smallFile, mediumImage,
                mediumImageURL, mediumFile, largeImage, largeImageURL,
                largeFile, itemFields, itemPrices, serviceContext);
        }
        else {

            // Update item

            ShoppingItemServiceUtil.updateItem(
                itemId, groupId, categoryId, sku, name, description, properties,
                fieldsQuantities, requiresShipping, stockQuantity, featured,
                sale, smallImage, smallImageURL, smallFile, mediumImage,
                mediumImageURL, mediumFile, largeImage, largeImageURL,
                largeFile, itemFields, itemPrices, serviceContext);
        }
    }

    // COUPONS

    public void deleteCoupons(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
            WebKeys.THEME_DISPLAY);

        long[] deleteCouponIds = StringUtil.split(
            ParamUtil.getString(actionRequest, "deleteCouponIds"), 0L);

        for (int i = 0; i < deleteCouponIds.length; i++) {
            ShoppingCouponServiceUtil.deleteCoupon(
                themeDisplay.getScopeGroupId(), deleteCouponIds[i]);
        }
    }


    public void updateCoupon(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        long couponId = ParamUtil.getLong(actionRequest, "couponId");

        String code = ParamUtil.getString(actionRequest, "code");
        boolean autoCode = ParamUtil.getBoolean(actionRequest, "autoCode");

        String name = ParamUtil.getString(actionRequest, "name");
        String description = ParamUtil.getString(actionRequest, "description");

        int startDateMonth = ParamUtil.getInteger(
            actionRequest, "startDateMonth");
        int startDateDay = ParamUtil.getInteger(actionRequest, "startDateDay");
        int startDateYear = ParamUtil.getInteger(
            actionRequest, "startDateYear");
        int startDateHour = ParamUtil.getInteger(
            actionRequest, "startDateHour");
        int startDateMinute = ParamUtil.getInteger(
            actionRequest, "startDateMinute");
        int startDateAmPm = ParamUtil.getInteger(
            actionRequest, "startDateAmPm");

        if (startDateAmPm == Calendar.PM) {
            startDateHour += 12;
        }

        int endDateMonth = ParamUtil.getInteger(actionRequest, "endDateMonth");
        int endDateDay = ParamUtil.getInteger(actionRequest, "endDateDay");
        int endDateYear = ParamUtil.getInteger(actionRequest, "endDateYear");
        int endDateHour = ParamUtil.getInteger(actionRequest, "endDateHour");
        int endDateMinute = ParamUtil.getInteger(
            actionRequest, "endDateMinute");
        int endDateAmPm = ParamUtil.getInteger(actionRequest, "endDateAmPm");
        boolean neverExpire = ParamUtil.getBoolean(
            actionRequest, "neverExpire");

        if (endDateAmPm == Calendar.PM) {
            endDateHour += 12;
        }

        boolean active = ParamUtil.getBoolean(actionRequest, "active");
        String limitCategories = ParamUtil.getString(
            actionRequest, "limitCategories");
        String limitSkus = ParamUtil.getString(actionRequest, "limitSkus");
        double minOrder = ParamUtil.getDouble(actionRequest, "minOrder", -1.0);
        double discount = ParamUtil.getDouble(actionRequest, "discount", -1.0);
        String discountType = ParamUtil.getString(
            actionRequest, "discountType");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            ShoppingCoupon.class.getName(), actionRequest);

        if (couponId <= 0) {

            // Add coupon
            _log.error("AA CouponId: " + couponId);

            ShoppingCouponServiceUtil.addCoupon(
                code, autoCode, name, description, startDateMonth, startDateDay,
                startDateYear, startDateHour, startDateMinute, endDateMonth,
                endDateDay, endDateYear, endDateHour, endDateMinute,
                neverExpire, active, limitCategories, limitSkus, minOrder,
                discount, discountType, serviceContext);
        }
        else {

            // Update coupon
            _log.error("UPDATE CouponId: " + couponId);

            ShoppingCouponServiceUtil.updateCoupon(
                couponId, name, description, startDateMonth, startDateDay,
                startDateYear, startDateHour, startDateMinute, endDateMonth,
                endDateDay, endDateYear, endDateHour, endDateMinute,
                neverExpire, active, limitCategories, limitSkus, minOrder,
                discount, discountType, serviceContext);
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

            ShoppingItem item = ShoppingItemLocalServiceUtil.getItem(itemId);

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
            String couponCodes = ParamUtil.getString(
                actionRequest, "couponCodes");
            int altShipping = ParamUtil.getInteger(
                actionRequest, "altShipping");
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
            actionResponse.setRenderParameter("jspPage","/cart.jsp");
        }

        } catch (Exception e) {
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

                _log.error ("Cart Exception: " + e.getClass().getName());
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
        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
            WebKeys.THEME_DISPLAY);

        long[] deleteOrderIds = StringUtil.split(
            ParamUtil.getString(actionRequest, "deleteOrderIds"), 0L);

        for (int i = 0; i < deleteOrderIds.length; i++) {
            ShoppingOrderServiceUtil.deleteOrder(
                themeDisplay.getScopeGroupId(), deleteOrderIds[i]);
        }
    }

    public void sendEmail(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
            WebKeys.THEME_DISPLAY);

        long orderId = ParamUtil.getLong(actionRequest, "orderId");

        String emailType = ParamUtil.getString(actionRequest, "emailType");

        ShoppingOrderServiceUtil.sendEmail(
            themeDisplay.getScopeGroupId(), orderId, emailType);
    }

    public void updateOrder(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
            WebKeys.THEME_DISPLAY);

        String number = ParamUtil.getString(actionRequest, "number");
        String ppTxnId = ParamUtil.getString(actionRequest, "ppTxnId");
        String ppPaymentStatus = ShoppingUtil.getPpPaymentStatus(
            ParamUtil.getString(actionRequest, "ppPaymentStatus"));
        double ppPaymentGross = ParamUtil.getDouble(
            actionRequest, "ppPaymentGross");
        String ppReceiverEmail = ParamUtil.getString(
            actionRequest, "ppReceiverEmail");
        String ppPayerEmail = ParamUtil.getString(
            actionRequest, "ppPayerEmail");

        ShoppingOrderServiceUtil.completeOrder(
            themeDisplay.getScopeGroupId(), number, ppTxnId, ppPaymentStatus,
            ppPaymentGross, ppReceiverEmail, ppPayerEmail);
    }

    // CHECKOUT

    public void updateLatestOrder(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {

        ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
            WebKeys.THEME_DISPLAY);

        String billingFirstName = ParamUtil.getString(
            actionRequest, "billingFirstName");
        String billingLastName = ParamUtil.getString(
            actionRequest, "billingLastName");
        String billingEmailAddress = ParamUtil.getString(
            actionRequest, "billingEmailAddress");
        String billingCompany = ParamUtil.getString(
            actionRequest, "billingCompany");
        String billingStreet = ParamUtil.getString(
            actionRequest, "billingStreet");
        String billingCity = ParamUtil.getString(actionRequest, "billingCity");

        String billingStateSel = ParamUtil.getString(
            actionRequest, "billingStateSel");
        String billingState = billingStateSel;
        if (Validator.isNull(billingStateSel)) {
            billingState = ParamUtil.getString(actionRequest, "billingState");
        }

        String billingZip = ParamUtil.getString(actionRequest, "billingZip");
        String billingCountry = ParamUtil.getString(
            actionRequest, "billingCountry");
        String billingPhone = ParamUtil.getString(
            actionRequest, "billingPhone");

        boolean shipToBilling = ParamUtil.getBoolean(
            actionRequest, "shipToBilling");
        String shippingFirstName = ParamUtil.getString(
            actionRequest, "shippingFirstName");
        String shippingLastName = ParamUtil.getString(
            actionRequest, "shippingLastName");
        String shippingEmailAddress = ParamUtil.getString(
            actionRequest, "shippingEmailAddress");
        String shippingCompany = ParamUtil.getString(
            actionRequest, "shippingCompany");
        String shippingStreet = ParamUtil.getString(
            actionRequest, "shippingStreet");
        String shippingCity = ParamUtil.getString(
            actionRequest, "shippingCity");

        String shippingStateSel = ParamUtil.getString(
            actionRequest, "shippingStateSel");
        String shippingState = shippingStateSel;
        if (Validator.isNull(shippingStateSel)) {
            shippingState = ParamUtil.getString(actionRequest, "shippingState");
        }

        String shippingZip = ParamUtil.getString(actionRequest, "shippingZip");
        String shippingCountry = ParamUtil.getString(
            actionRequest, "shippingCountry");
        String shippingPhone = ParamUtil.getString(
            actionRequest, "shippingPhone");

        String ccName = ParamUtil.getString(actionRequest, "ccName");
        String ccType = ParamUtil.getString(actionRequest, "ccType");
        String ccNumber = ParamUtil.getString(actionRequest, "ccNumber");
        int ccExpMonth = ParamUtil.getInteger(actionRequest, "ccExpMonth");
        int ccExpYear = ParamUtil.getInteger(actionRequest, "ccExpYear");
        String ccVerNumber = ParamUtil.getString(actionRequest, "ccVerNumber");

        String comments = ParamUtil.getString(actionRequest, "comments");

        try {
        ShoppingOrder order = ShoppingOrderLocalServiceUtil.updateLatestOrder(
            themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
            billingFirstName, billingLastName, billingEmailAddress,
            billingCompany, billingStreet, billingCity, billingState,
            billingZip, billingCountry, billingPhone, shipToBilling,
            shippingFirstName, shippingLastName, shippingEmailAddress,
            shippingCompany, shippingStreet, shippingCity, shippingState,
            shippingZip, shippingCountry, shippingPhone, ccName, ccType,
            ccNumber, ccExpMonth, ccExpYear, ccVerNumber, comments);

        actionRequest.setAttribute(WebKeys.SHOPPING_ORDER, order);
        actionResponse.setRenderParameter("jspPage","/checkout_second.jsp");
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
                    actionResponse.setRenderParameter("jspPage","/checkout_first.jsp");

                    //setForward(
                    //    actionRequest, "portlet.shopping.checkout_first");
                }
                //else if (e instanceof PrincipalException) {
                    // setForward(actionRequest, "portlet.shopping.error");
                //}
                else {
                    throw e;
                }
        }
    }

    public void saveLatestOrder(
            ActionRequest actionRequest, ActionResponse actionResponse)
        throws Exception {

        updateCart(actionRequest, actionResponse);
        updateLatestOrder(actionRequest, actionResponse);

        ShoppingCart cart = ShoppingUtil.getCart(actionRequest);

        ShoppingOrder order =
            ShoppingOrderLocalServiceUtil.saveLatestOrder(cart);

        actionRequest.setAttribute(WebKeys.SHOPPING_ORDER, order);
        actionResponse.setRenderParameter("jspPage","/checkout_third.jsp");
    }


    private static Log _log = LogFactoryUtil.getLog(ShoppingPortlet.class);
}
