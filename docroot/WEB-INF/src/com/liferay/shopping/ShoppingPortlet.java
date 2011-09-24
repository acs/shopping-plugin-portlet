package com.liferay.shopping;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;

import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

import com.liferay.shopping.model.ShoppingItem;
import com.liferay.shopping.model.ShoppingItemField;
import com.liferay.shopping.model.ShoppingCategory;
import com.liferay.shopping.model.ShoppingItemPrice;
import com.liferay.shopping.model.ShoppingItemPriceConstants;
import com.liferay.shopping.service.persistence.ShoppingItemFieldUtil;
import com.liferay.shopping.service.persistence.ShoppingItemPriceUtil;
import com.liferay.shopping.service.ShoppingItemServiceUtil;
import com.liferay.shopping.service.ShoppingCategoryServiceUtil;
import com.liferay.shopping.util.WebKeys;

import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;

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

    private static Log _log = LogFactoryUtil.getLog(ShoppingPortlet.class);
}
