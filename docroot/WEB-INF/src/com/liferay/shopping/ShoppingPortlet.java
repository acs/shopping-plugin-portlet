package com.liferay.shopping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;

import com.liferay.util.bridges.mvc.MVCPortlet;

import com.liferay.shopping.model.ShoppingCategory;
import com.liferay.shopping.service.ShoppingCategoryServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Alvaro del Castillo
 */


public class ShoppingPortlet extends MVCPortlet {

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

    private static Log _log = LogFactoryUtil.getLog(ShoppingPortlet.class);
}
