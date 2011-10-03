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

package com.liferay.shopping.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import com.liferay.shopping.model.ShoppingCartClp;
import com.liferay.shopping.model.ShoppingCategoryClp;
import com.liferay.shopping.model.ShoppingCouponClp;
import com.liferay.shopping.model.ShoppingItemClp;
import com.liferay.shopping.model.ShoppingItemFieldClp;
import com.liferay.shopping.model.ShoppingItemPriceClp;
import com.liferay.shopping.model.ShoppingOrderClp;
import com.liferay.shopping.model.ShoppingOrderItemClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "shop-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(ShoppingCartClp.class.getName())) {
			ShoppingCartClp oldCplModel = (ShoppingCartClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.shopping.model.impl.ShoppingCartImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCartId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getCartId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getGroupId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getCompanyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserName",
							new Class[] { String.class });

					String value4 = oldCplModel.getUserName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getCreateDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getModifiedDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setItemIds",
							new Class[] { String.class });

					String value7 = oldCplModel.getItemIds();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setCouponCodes",
							new Class[] { String.class });

					String value8 = oldCplModel.getCouponCodes();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setAltShipping",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getAltShipping());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setInsure",
							new Class[] { Boolean.TYPE });

					Boolean value10 = new Boolean(oldCplModel.getInsure());

					method10.invoke(newModel, value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ShoppingCategoryClp.class.getName())) {
			ShoppingCategoryClp oldCplModel = (ShoppingCategoryClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.shopping.model.impl.ShoppingCategoryImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCategoryId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getCategoryId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getGroupId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getCompanyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserName",
							new Class[] { String.class });

					String value4 = oldCplModel.getUserName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getCreateDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getModifiedDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setParentCategoryId",
							new Class[] { Long.TYPE });

					Long value7 = new Long(oldCplModel.getParentCategoryId());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value8 = oldCplModel.getName();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value9 = oldCplModel.getDescription();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ShoppingCouponClp.class.getName())) {
			ShoppingCouponClp oldCplModel = (ShoppingCouponClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.shopping.model.impl.ShoppingCouponImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setCouponId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getCouponId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getGroupId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getCompanyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserName",
							new Class[] { String.class });

					String value4 = oldCplModel.getUserName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getCreateDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getModifiedDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCode",
							new Class[] { String.class });

					String value7 = oldCplModel.getCode();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value8 = oldCplModel.getName();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value9 = oldCplModel.getDescription();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setStartDate",
							new Class[] { Date.class });

					Date value10 = oldCplModel.getStartDate();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setEndDate",
							new Class[] { Date.class });

					Date value11 = oldCplModel.getEndDate();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setActive",
							new Class[] { Boolean.TYPE });

					Boolean value12 = new Boolean(oldCplModel.getActive());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setLimitCategories",
							new Class[] { String.class });

					String value13 = oldCplModel.getLimitCategories();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setLimitSkus",
							new Class[] { String.class });

					String value14 = oldCplModel.getLimitSkus();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setMinOrder",
							new Class[] { Double.TYPE });

					Double value15 = new Double(oldCplModel.getMinOrder());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setDiscount",
							new Class[] { Double.TYPE });

					Double value16 = new Double(oldCplModel.getDiscount());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setDiscountType",
							new Class[] { String.class });

					String value17 = oldCplModel.getDiscountType();

					method17.invoke(newModel, value17);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ShoppingItemClp.class.getName())) {
			ShoppingItemClp oldCplModel = (ShoppingItemClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.shopping.model.impl.ShoppingItemImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setItemId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getItemId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getGroupId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getCompanyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserName",
							new Class[] { String.class });

					String value4 = oldCplModel.getUserName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getCreateDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getModifiedDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setCategoryId",
							new Class[] { Long.TYPE });

					Long value7 = new Long(oldCplModel.getCategoryId());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setSku",
							new Class[] { String.class });

					String value8 = oldCplModel.getSku();

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value9 = oldCplModel.getName();

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value10 = oldCplModel.getDescription();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setProperties",
							new Class[] { String.class });

					String value11 = oldCplModel.getProperties();

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setFields",
							new Class[] { Boolean.TYPE });

					Boolean value12 = new Boolean(oldCplModel.getFields());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setFieldsQuantities",
							new Class[] { String.class });

					String value13 = oldCplModel.getFieldsQuantities();

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setMinQuantity",
							new Class[] { Integer.TYPE });

					Integer value14 = new Integer(oldCplModel.getMinQuantity());

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setMaxQuantity",
							new Class[] { Integer.TYPE });

					Integer value15 = new Integer(oldCplModel.getMaxQuantity());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setPrice",
							new Class[] { Double.TYPE });

					Double value16 = new Double(oldCplModel.getPrice());

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setDiscount",
							new Class[] { Double.TYPE });

					Double value17 = new Double(oldCplModel.getDiscount());

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setTaxable",
							new Class[] { Boolean.TYPE });

					Boolean value18 = new Boolean(oldCplModel.getTaxable());

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setShipping",
							new Class[] { Double.TYPE });

					Double value19 = new Double(oldCplModel.getShipping());

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setUseShippingFormula",
							new Class[] { Boolean.TYPE });

					Boolean value20 = new Boolean(oldCplModel.getUseShippingFormula());

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setRequiresShipping",
							new Class[] { Boolean.TYPE });

					Boolean value21 = new Boolean(oldCplModel.getRequiresShipping());

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setStockQuantity",
							new Class[] { Integer.TYPE });

					Integer value22 = new Integer(oldCplModel.getStockQuantity());

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setFeatured",
							new Class[] { Boolean.TYPE });

					Boolean value23 = new Boolean(oldCplModel.getFeatured());

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setSale",
							new Class[] { Boolean.TYPE });

					Boolean value24 = new Boolean(oldCplModel.getSale());

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setSmallImage",
							new Class[] { Boolean.TYPE });

					Boolean value25 = new Boolean(oldCplModel.getSmallImage());

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setSmallImageId",
							new Class[] { Long.TYPE });

					Long value26 = new Long(oldCplModel.getSmallImageId());

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setSmallImageURL",
							new Class[] { String.class });

					String value27 = oldCplModel.getSmallImageURL();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setMediumImage",
							new Class[] { Boolean.TYPE });

					Boolean value28 = new Boolean(oldCplModel.getMediumImage());

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setMediumImageId",
							new Class[] { Long.TYPE });

					Long value29 = new Long(oldCplModel.getMediumImageId());

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setMediumImageURL",
							new Class[] { String.class });

					String value30 = oldCplModel.getMediumImageURL();

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setLargeImage",
							new Class[] { Boolean.TYPE });

					Boolean value31 = new Boolean(oldCplModel.getLargeImage());

					method31.invoke(newModel, value31);

					Method method32 = newModelClass.getMethod("setLargeImageId",
							new Class[] { Long.TYPE });

					Long value32 = new Long(oldCplModel.getLargeImageId());

					method32.invoke(newModel, value32);

					Method method33 = newModelClass.getMethod("setLargeImageURL",
							new Class[] { String.class });

					String value33 = oldCplModel.getLargeImageURL();

					method33.invoke(newModel, value33);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ShoppingItemFieldClp.class.getName())) {
			ShoppingItemFieldClp oldCplModel = (ShoppingItemFieldClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.shopping.model.impl.ShoppingItemFieldImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setItemFieldId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getItemFieldId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setItemId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getItemId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value2 = oldCplModel.getName();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setValues",
							new Class[] { String.class });

					String value3 = oldCplModel.getValues();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value4 = oldCplModel.getDescription();

					method4.invoke(newModel, value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ShoppingItemPriceClp.class.getName())) {
			ShoppingItemPriceClp oldCplModel = (ShoppingItemPriceClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.shopping.model.impl.ShoppingItemPriceImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setItemPriceId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getItemPriceId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setItemId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getItemId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setMinQuantity",
							new Class[] { Integer.TYPE });

					Integer value2 = new Integer(oldCplModel.getMinQuantity());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setMaxQuantity",
							new Class[] { Integer.TYPE });

					Integer value3 = new Integer(oldCplModel.getMaxQuantity());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setPrice",
							new Class[] { Double.TYPE });

					Double value4 = new Double(oldCplModel.getPrice());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setDiscount",
							new Class[] { Double.TYPE });

					Double value5 = new Double(oldCplModel.getDiscount());

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setTaxable",
							new Class[] { Boolean.TYPE });

					Boolean value6 = new Boolean(oldCplModel.getTaxable());

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setShipping",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getShipping());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setUseShippingFormula",
							new Class[] { Boolean.TYPE });

					Boolean value8 = new Boolean(oldCplModel.getUseShippingFormula());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setStatus",
							new Class[] { Integer.TYPE });

					Integer value9 = new Integer(oldCplModel.getStatus());

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ShoppingOrderClp.class.getName())) {
			ShoppingOrderClp oldCplModel = (ShoppingOrderClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.shopping.model.impl.ShoppingOrderImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrderId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getOrderId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setGroupId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getGroupId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setCompanyId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getCompanyId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getUserId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setUserName",
							new Class[] { String.class });

					String value4 = oldCplModel.getUserName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setCreateDate",
							new Class[] { Date.class });

					Date value5 = oldCplModel.getCreateDate();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setModifiedDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getModifiedDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setNumber",
							new Class[] { String.class });

					String value7 = oldCplModel.getNumber();

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setTax",
							new Class[] { Double.TYPE });

					Double value8 = new Double(oldCplModel.getTax());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setShipping",
							new Class[] { Double.TYPE });

					Double value9 = new Double(oldCplModel.getShipping());

					method9.invoke(newModel, value9);

					Method method10 = newModelClass.getMethod("setAltShipping",
							new Class[] { String.class });

					String value10 = oldCplModel.getAltShipping();

					method10.invoke(newModel, value10);

					Method method11 = newModelClass.getMethod("setRequiresShipping",
							new Class[] { Boolean.TYPE });

					Boolean value11 = new Boolean(oldCplModel.getRequiresShipping());

					method11.invoke(newModel, value11);

					Method method12 = newModelClass.getMethod("setInsure",
							new Class[] { Boolean.TYPE });

					Boolean value12 = new Boolean(oldCplModel.getInsure());

					method12.invoke(newModel, value12);

					Method method13 = newModelClass.getMethod("setInsurance",
							new Class[] { Double.TYPE });

					Double value13 = new Double(oldCplModel.getInsurance());

					method13.invoke(newModel, value13);

					Method method14 = newModelClass.getMethod("setCouponCodes",
							new Class[] { String.class });

					String value14 = oldCplModel.getCouponCodes();

					method14.invoke(newModel, value14);

					Method method15 = newModelClass.getMethod("setCouponDiscount",
							new Class[] { Double.TYPE });

					Double value15 = new Double(oldCplModel.getCouponDiscount());

					method15.invoke(newModel, value15);

					Method method16 = newModelClass.getMethod("setBillingFirstName",
							new Class[] { String.class });

					String value16 = oldCplModel.getBillingFirstName();

					method16.invoke(newModel, value16);

					Method method17 = newModelClass.getMethod("setBillingLastName",
							new Class[] { String.class });

					String value17 = oldCplModel.getBillingLastName();

					method17.invoke(newModel, value17);

					Method method18 = newModelClass.getMethod("setBillingEmailAddress",
							new Class[] { String.class });

					String value18 = oldCplModel.getBillingEmailAddress();

					method18.invoke(newModel, value18);

					Method method19 = newModelClass.getMethod("setBillingCompany",
							new Class[] { String.class });

					String value19 = oldCplModel.getBillingCompany();

					method19.invoke(newModel, value19);

					Method method20 = newModelClass.getMethod("setBillingStreet",
							new Class[] { String.class });

					String value20 = oldCplModel.getBillingStreet();

					method20.invoke(newModel, value20);

					Method method21 = newModelClass.getMethod("setBillingCity",
							new Class[] { String.class });

					String value21 = oldCplModel.getBillingCity();

					method21.invoke(newModel, value21);

					Method method22 = newModelClass.getMethod("setBillingState",
							new Class[] { String.class });

					String value22 = oldCplModel.getBillingState();

					method22.invoke(newModel, value22);

					Method method23 = newModelClass.getMethod("setBillingZip",
							new Class[] { String.class });

					String value23 = oldCplModel.getBillingZip();

					method23.invoke(newModel, value23);

					Method method24 = newModelClass.getMethod("setBillingCountry",
							new Class[] { String.class });

					String value24 = oldCplModel.getBillingCountry();

					method24.invoke(newModel, value24);

					Method method25 = newModelClass.getMethod("setBillingPhone",
							new Class[] { String.class });

					String value25 = oldCplModel.getBillingPhone();

					method25.invoke(newModel, value25);

					Method method26 = newModelClass.getMethod("setShipToBilling",
							new Class[] { Boolean.TYPE });

					Boolean value26 = new Boolean(oldCplModel.getShipToBilling());

					method26.invoke(newModel, value26);

					Method method27 = newModelClass.getMethod("setShippingFirstName",
							new Class[] { String.class });

					String value27 = oldCplModel.getShippingFirstName();

					method27.invoke(newModel, value27);

					Method method28 = newModelClass.getMethod("setShippingLastName",
							new Class[] { String.class });

					String value28 = oldCplModel.getShippingLastName();

					method28.invoke(newModel, value28);

					Method method29 = newModelClass.getMethod("setShippingEmailAddress",
							new Class[] { String.class });

					String value29 = oldCplModel.getShippingEmailAddress();

					method29.invoke(newModel, value29);

					Method method30 = newModelClass.getMethod("setShippingCompany",
							new Class[] { String.class });

					String value30 = oldCplModel.getShippingCompany();

					method30.invoke(newModel, value30);

					Method method31 = newModelClass.getMethod("setShippingStreet",
							new Class[] { String.class });

					String value31 = oldCplModel.getShippingStreet();

					method31.invoke(newModel, value31);

					Method method32 = newModelClass.getMethod("setShippingCity",
							new Class[] { String.class });

					String value32 = oldCplModel.getShippingCity();

					method32.invoke(newModel, value32);

					Method method33 = newModelClass.getMethod("setShippingState",
							new Class[] { String.class });

					String value33 = oldCplModel.getShippingState();

					method33.invoke(newModel, value33);

					Method method34 = newModelClass.getMethod("setShippingZip",
							new Class[] { String.class });

					String value34 = oldCplModel.getShippingZip();

					method34.invoke(newModel, value34);

					Method method35 = newModelClass.getMethod("setShippingCountry",
							new Class[] { String.class });

					String value35 = oldCplModel.getShippingCountry();

					method35.invoke(newModel, value35);

					Method method36 = newModelClass.getMethod("setShippingPhone",
							new Class[] { String.class });

					String value36 = oldCplModel.getShippingPhone();

					method36.invoke(newModel, value36);

					Method method37 = newModelClass.getMethod("setCcName",
							new Class[] { String.class });

					String value37 = oldCplModel.getCcName();

					method37.invoke(newModel, value37);

					Method method38 = newModelClass.getMethod("setCcType",
							new Class[] { String.class });

					String value38 = oldCplModel.getCcType();

					method38.invoke(newModel, value38);

					Method method39 = newModelClass.getMethod("setCcNumber",
							new Class[] { String.class });

					String value39 = oldCplModel.getCcNumber();

					method39.invoke(newModel, value39);

					Method method40 = newModelClass.getMethod("setCcExpMonth",
							new Class[] { Integer.TYPE });

					Integer value40 = new Integer(oldCplModel.getCcExpMonth());

					method40.invoke(newModel, value40);

					Method method41 = newModelClass.getMethod("setCcExpYear",
							new Class[] { Integer.TYPE });

					Integer value41 = new Integer(oldCplModel.getCcExpYear());

					method41.invoke(newModel, value41);

					Method method42 = newModelClass.getMethod("setCcVerNumber",
							new Class[] { String.class });

					String value42 = oldCplModel.getCcVerNumber();

					method42.invoke(newModel, value42);

					Method method43 = newModelClass.getMethod("setComments",
							new Class[] { String.class });

					String value43 = oldCplModel.getComments();

					method43.invoke(newModel, value43);

					Method method44 = newModelClass.getMethod("setPpTxnId",
							new Class[] { String.class });

					String value44 = oldCplModel.getPpTxnId();

					method44.invoke(newModel, value44);

					Method method45 = newModelClass.getMethod("setPpPaymentStatus",
							new Class[] { String.class });

					String value45 = oldCplModel.getPpPaymentStatus();

					method45.invoke(newModel, value45);

					Method method46 = newModelClass.getMethod("setPpPaymentGross",
							new Class[] { Double.TYPE });

					Double value46 = new Double(oldCplModel.getPpPaymentGross());

					method46.invoke(newModel, value46);

					Method method47 = newModelClass.getMethod("setPpReceiverEmail",
							new Class[] { String.class });

					String value47 = oldCplModel.getPpReceiverEmail();

					method47.invoke(newModel, value47);

					Method method48 = newModelClass.getMethod("setPpPayerEmail",
							new Class[] { String.class });

					String value48 = oldCplModel.getPpPayerEmail();

					method48.invoke(newModel, value48);

					Method method49 = newModelClass.getMethod("setSendOrderEmail",
							new Class[] { Boolean.TYPE });

					Boolean value49 = new Boolean(oldCplModel.getSendOrderEmail());

					method49.invoke(newModel, value49);

					Method method50 = newModelClass.getMethod("setSendShippingEmail",
							new Class[] { Boolean.TYPE });

					Boolean value50 = new Boolean(oldCplModel.getSendShippingEmail());

					method50.invoke(newModel, value50);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(ShoppingOrderItemClp.class.getName())) {
			ShoppingOrderItemClp oldCplModel = (ShoppingOrderItemClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.liferay.shopping.model.impl.ShoppingOrderItemImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setOrderItemId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getOrderItemId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOrderId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getOrderId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setItemId",
							new Class[] { String.class });

					String value2 = oldCplModel.getItemId();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setSku",
							new Class[] { String.class });

					String value3 = oldCplModel.getSku();

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setName",
							new Class[] { String.class });

					String value4 = oldCplModel.getName();

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setDescription",
							new Class[] { String.class });

					String value5 = oldCplModel.getDescription();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setProperties",
							new Class[] { String.class });

					String value6 = oldCplModel.getProperties();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setPrice",
							new Class[] { Double.TYPE });

					Double value7 = new Double(oldCplModel.getPrice());

					method7.invoke(newModel, value7);

					Method method8 = newModelClass.getMethod("setQuantity",
							new Class[] { Integer.TYPE });

					Integer value8 = new Integer(oldCplModel.getQuantity());

					method8.invoke(newModel, value8);

					Method method9 = newModelClass.getMethod("setShippedDate",
							new Class[] { Date.class });

					Date value9 = oldCplModel.getShippedDate();

					method9.invoke(newModel, value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingCartImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ShoppingCartClp newModel = new ShoppingCartClp();

					Method method0 = oldModelClass.getMethod("getCartId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setCartId(value0);

					Method method1 = oldModelClass.getMethod("getGroupId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value1);

					Method method2 = oldModelClass.getMethod("getCompanyId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value2);

					Method method3 = oldModelClass.getMethod("getUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setUserId(value3);

					Method method4 = oldModelClass.getMethod("getUserName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserName(value4);

					Method method5 = oldModelClass.getMethod("getCreateDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value5);

					Method method6 = oldModelClass.getMethod("getModifiedDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value6);

					Method method7 = oldModelClass.getMethod("getItemIds");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setItemIds(value7);

					Method method8 = oldModelClass.getMethod("getCouponCodes");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setCouponCodes(value8);

					Method method9 = oldModelClass.getMethod("getAltShipping");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setAltShipping(value9);

					Method method10 = oldModelClass.getMethod("getInsure");

					Boolean value10 = (Boolean)method10.invoke(oldModel,
							(Object[])null);

					newModel.setInsure(value10);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingCategoryImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ShoppingCategoryClp newModel = new ShoppingCategoryClp();

					Method method0 = oldModelClass.getMethod("getCategoryId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setCategoryId(value0);

					Method method1 = oldModelClass.getMethod("getGroupId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value1);

					Method method2 = oldModelClass.getMethod("getCompanyId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value2);

					Method method3 = oldModelClass.getMethod("getUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setUserId(value3);

					Method method4 = oldModelClass.getMethod("getUserName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserName(value4);

					Method method5 = oldModelClass.getMethod("getCreateDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value5);

					Method method6 = oldModelClass.getMethod("getModifiedDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value6);

					Method method7 = oldModelClass.getMethod(
							"getParentCategoryId");

					Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

					newModel.setParentCategoryId(value7);

					Method method8 = oldModelClass.getMethod("getName");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setName(value8);

					Method method9 = oldModelClass.getMethod("getDescription");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingCouponImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ShoppingCouponClp newModel = new ShoppingCouponClp();

					Method method0 = oldModelClass.getMethod("getCouponId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setCouponId(value0);

					Method method1 = oldModelClass.getMethod("getGroupId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value1);

					Method method2 = oldModelClass.getMethod("getCompanyId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value2);

					Method method3 = oldModelClass.getMethod("getUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setUserId(value3);

					Method method4 = oldModelClass.getMethod("getUserName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserName(value4);

					Method method5 = oldModelClass.getMethod("getCreateDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value5);

					Method method6 = oldModelClass.getMethod("getModifiedDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value6);

					Method method7 = oldModelClass.getMethod("getCode");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setCode(value7);

					Method method8 = oldModelClass.getMethod("getName");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setName(value8);

					Method method9 = oldModelClass.getMethod("getDescription");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value9);

					Method method10 = oldModelClass.getMethod("getStartDate");

					Date value10 = (Date)method10.invoke(oldModel,
							(Object[])null);

					newModel.setStartDate(value10);

					Method method11 = oldModelClass.getMethod("getEndDate");

					Date value11 = (Date)method11.invoke(oldModel,
							(Object[])null);

					newModel.setEndDate(value11);

					Method method12 = oldModelClass.getMethod("getActive");

					Boolean value12 = (Boolean)method12.invoke(oldModel,
							(Object[])null);

					newModel.setActive(value12);

					Method method13 = oldModelClass.getMethod(
							"getLimitCategories");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setLimitCategories(value13);

					Method method14 = oldModelClass.getMethod("getLimitSkus");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setLimitSkus(value14);

					Method method15 = oldModelClass.getMethod("getMinOrder");

					Double value15 = (Double)method15.invoke(oldModel,
							(Object[])null);

					newModel.setMinOrder(value15);

					Method method16 = oldModelClass.getMethod("getDiscount");

					Double value16 = (Double)method16.invoke(oldModel,
							(Object[])null);

					newModel.setDiscount(value16);

					Method method17 = oldModelClass.getMethod("getDiscountType");

					String value17 = (String)method17.invoke(oldModel,
							(Object[])null);

					newModel.setDiscountType(value17);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingItemImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ShoppingItemClp newModel = new ShoppingItemClp();

					Method method0 = oldModelClass.getMethod("getItemId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setItemId(value0);

					Method method1 = oldModelClass.getMethod("getGroupId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value1);

					Method method2 = oldModelClass.getMethod("getCompanyId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value2);

					Method method3 = oldModelClass.getMethod("getUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setUserId(value3);

					Method method4 = oldModelClass.getMethod("getUserName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserName(value4);

					Method method5 = oldModelClass.getMethod("getCreateDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value5);

					Method method6 = oldModelClass.getMethod("getModifiedDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value6);

					Method method7 = oldModelClass.getMethod("getCategoryId");

					Long value7 = (Long)method7.invoke(oldModel, (Object[])null);

					newModel.setCategoryId(value7);

					Method method8 = oldModelClass.getMethod("getSku");

					String value8 = (String)method8.invoke(oldModel,
							(Object[])null);

					newModel.setSku(value8);

					Method method9 = oldModelClass.getMethod("getName");

					String value9 = (String)method9.invoke(oldModel,
							(Object[])null);

					newModel.setName(value9);

					Method method10 = oldModelClass.getMethod("getDescription");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value10);

					Method method11 = oldModelClass.getMethod("getProperties");

					String value11 = (String)method11.invoke(oldModel,
							(Object[])null);

					newModel.setProperties(value11);

					Method method12 = oldModelClass.getMethod("getFields");

					Boolean value12 = (Boolean)method12.invoke(oldModel,
							(Object[])null);

					newModel.setFields(value12);

					Method method13 = oldModelClass.getMethod(
							"getFieldsQuantities");

					String value13 = (String)method13.invoke(oldModel,
							(Object[])null);

					newModel.setFieldsQuantities(value13);

					Method method14 = oldModelClass.getMethod("getMinQuantity");

					Integer value14 = (Integer)method14.invoke(oldModel,
							(Object[])null);

					newModel.setMinQuantity(value14);

					Method method15 = oldModelClass.getMethod("getMaxQuantity");

					Integer value15 = (Integer)method15.invoke(oldModel,
							(Object[])null);

					newModel.setMaxQuantity(value15);

					Method method16 = oldModelClass.getMethod("getPrice");

					Double value16 = (Double)method16.invoke(oldModel,
							(Object[])null);

					newModel.setPrice(value16);

					Method method17 = oldModelClass.getMethod("getDiscount");

					Double value17 = (Double)method17.invoke(oldModel,
							(Object[])null);

					newModel.setDiscount(value17);

					Method method18 = oldModelClass.getMethod("getTaxable");

					Boolean value18 = (Boolean)method18.invoke(oldModel,
							(Object[])null);

					newModel.setTaxable(value18);

					Method method19 = oldModelClass.getMethod("getShipping");

					Double value19 = (Double)method19.invoke(oldModel,
							(Object[])null);

					newModel.setShipping(value19);

					Method method20 = oldModelClass.getMethod(
							"getUseShippingFormula");

					Boolean value20 = (Boolean)method20.invoke(oldModel,
							(Object[])null);

					newModel.setUseShippingFormula(value20);

					Method method21 = oldModelClass.getMethod(
							"getRequiresShipping");

					Boolean value21 = (Boolean)method21.invoke(oldModel,
							(Object[])null);

					newModel.setRequiresShipping(value21);

					Method method22 = oldModelClass.getMethod(
							"getStockQuantity");

					Integer value22 = (Integer)method22.invoke(oldModel,
							(Object[])null);

					newModel.setStockQuantity(value22);

					Method method23 = oldModelClass.getMethod("getFeatured");

					Boolean value23 = (Boolean)method23.invoke(oldModel,
							(Object[])null);

					newModel.setFeatured(value23);

					Method method24 = oldModelClass.getMethod("getSale");

					Boolean value24 = (Boolean)method24.invoke(oldModel,
							(Object[])null);

					newModel.setSale(value24);

					Method method25 = oldModelClass.getMethod("getSmallImage");

					Boolean value25 = (Boolean)method25.invoke(oldModel,
							(Object[])null);

					newModel.setSmallImage(value25);

					Method method26 = oldModelClass.getMethod("getSmallImageId");

					Long value26 = (Long)method26.invoke(oldModel,
							(Object[])null);

					newModel.setSmallImageId(value26);

					Method method27 = oldModelClass.getMethod(
							"getSmallImageURL");

					String value27 = (String)method27.invoke(oldModel,
							(Object[])null);

					newModel.setSmallImageURL(value27);

					Method method28 = oldModelClass.getMethod("getMediumImage");

					Boolean value28 = (Boolean)method28.invoke(oldModel,
							(Object[])null);

					newModel.setMediumImage(value28);

					Method method29 = oldModelClass.getMethod(
							"getMediumImageId");

					Long value29 = (Long)method29.invoke(oldModel,
							(Object[])null);

					newModel.setMediumImageId(value29);

					Method method30 = oldModelClass.getMethod(
							"getMediumImageURL");

					String value30 = (String)method30.invoke(oldModel,
							(Object[])null);

					newModel.setMediumImageURL(value30);

					Method method31 = oldModelClass.getMethod("getLargeImage");

					Boolean value31 = (Boolean)method31.invoke(oldModel,
							(Object[])null);

					newModel.setLargeImage(value31);

					Method method32 = oldModelClass.getMethod("getLargeImageId");

					Long value32 = (Long)method32.invoke(oldModel,
							(Object[])null);

					newModel.setLargeImageId(value32);

					Method method33 = oldModelClass.getMethod(
							"getLargeImageURL");

					String value33 = (String)method33.invoke(oldModel,
							(Object[])null);

					newModel.setLargeImageURL(value33);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingItemFieldImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ShoppingItemFieldClp newModel = new ShoppingItemFieldClp();

					Method method0 = oldModelClass.getMethod("getItemFieldId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setItemFieldId(value0);

					Method method1 = oldModelClass.getMethod("getItemId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setItemId(value1);

					Method method2 = oldModelClass.getMethod("getName");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setName(value2);

					Method method3 = oldModelClass.getMethod("getValues");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setValues(value3);

					Method method4 = oldModelClass.getMethod("getDescription");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value4);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingItemPriceImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ShoppingItemPriceClp newModel = new ShoppingItemPriceClp();

					Method method0 = oldModelClass.getMethod("getItemPriceId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setItemPriceId(value0);

					Method method1 = oldModelClass.getMethod("getItemId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setItemId(value1);

					Method method2 = oldModelClass.getMethod("getMinQuantity");

					Integer value2 = (Integer)method2.invoke(oldModel,
							(Object[])null);

					newModel.setMinQuantity(value2);

					Method method3 = oldModelClass.getMethod("getMaxQuantity");

					Integer value3 = (Integer)method3.invoke(oldModel,
							(Object[])null);

					newModel.setMaxQuantity(value3);

					Method method4 = oldModelClass.getMethod("getPrice");

					Double value4 = (Double)method4.invoke(oldModel,
							(Object[])null);

					newModel.setPrice(value4);

					Method method5 = oldModelClass.getMethod("getDiscount");

					Double value5 = (Double)method5.invoke(oldModel,
							(Object[])null);

					newModel.setDiscount(value5);

					Method method6 = oldModelClass.getMethod("getTaxable");

					Boolean value6 = (Boolean)method6.invoke(oldModel,
							(Object[])null);

					newModel.setTaxable(value6);

					Method method7 = oldModelClass.getMethod("getShipping");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setShipping(value7);

					Method method8 = oldModelClass.getMethod(
							"getUseShippingFormula");

					Boolean value8 = (Boolean)method8.invoke(oldModel,
							(Object[])null);

					newModel.setUseShippingFormula(value8);

					Method method9 = oldModelClass.getMethod("getStatus");

					Integer value9 = (Integer)method9.invoke(oldModel,
							(Object[])null);

					newModel.setStatus(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingOrderImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ShoppingOrderClp newModel = new ShoppingOrderClp();

					Method method0 = oldModelClass.getMethod("getOrderId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setOrderId(value0);

					Method method1 = oldModelClass.getMethod("getGroupId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setGroupId(value1);

					Method method2 = oldModelClass.getMethod("getCompanyId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setCompanyId(value2);

					Method method3 = oldModelClass.getMethod("getUserId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setUserId(value3);

					Method method4 = oldModelClass.getMethod("getUserName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setUserName(value4);

					Method method5 = oldModelClass.getMethod("getCreateDate");

					Date value5 = (Date)method5.invoke(oldModel, (Object[])null);

					newModel.setCreateDate(value5);

					Method method6 = oldModelClass.getMethod("getModifiedDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setModifiedDate(value6);

					Method method7 = oldModelClass.getMethod("getNumber");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setNumber(value7);

					Method method8 = oldModelClass.getMethod("getTax");

					Double value8 = (Double)method8.invoke(oldModel,
							(Object[])null);

					newModel.setTax(value8);

					Method method9 = oldModelClass.getMethod("getShipping");

					Double value9 = (Double)method9.invoke(oldModel,
							(Object[])null);

					newModel.setShipping(value9);

					Method method10 = oldModelClass.getMethod("getAltShipping");

					String value10 = (String)method10.invoke(oldModel,
							(Object[])null);

					newModel.setAltShipping(value10);

					Method method11 = oldModelClass.getMethod(
							"getRequiresShipping");

					Boolean value11 = (Boolean)method11.invoke(oldModel,
							(Object[])null);

					newModel.setRequiresShipping(value11);

					Method method12 = oldModelClass.getMethod("getInsure");

					Boolean value12 = (Boolean)method12.invoke(oldModel,
							(Object[])null);

					newModel.setInsure(value12);

					Method method13 = oldModelClass.getMethod("getInsurance");

					Double value13 = (Double)method13.invoke(oldModel,
							(Object[])null);

					newModel.setInsurance(value13);

					Method method14 = oldModelClass.getMethod("getCouponCodes");

					String value14 = (String)method14.invoke(oldModel,
							(Object[])null);

					newModel.setCouponCodes(value14);

					Method method15 = oldModelClass.getMethod(
							"getCouponDiscount");

					Double value15 = (Double)method15.invoke(oldModel,
							(Object[])null);

					newModel.setCouponDiscount(value15);

					Method method16 = oldModelClass.getMethod(
							"getBillingFirstName");

					String value16 = (String)method16.invoke(oldModel,
							(Object[])null);

					newModel.setBillingFirstName(value16);

					Method method17 = oldModelClass.getMethod(
							"getBillingLastName");

					String value17 = (String)method17.invoke(oldModel,
							(Object[])null);

					newModel.setBillingLastName(value17);

					Method method18 = oldModelClass.getMethod(
							"getBillingEmailAddress");

					String value18 = (String)method18.invoke(oldModel,
							(Object[])null);

					newModel.setBillingEmailAddress(value18);

					Method method19 = oldModelClass.getMethod(
							"getBillingCompany");

					String value19 = (String)method19.invoke(oldModel,
							(Object[])null);

					newModel.setBillingCompany(value19);

					Method method20 = oldModelClass.getMethod(
							"getBillingStreet");

					String value20 = (String)method20.invoke(oldModel,
							(Object[])null);

					newModel.setBillingStreet(value20);

					Method method21 = oldModelClass.getMethod("getBillingCity");

					String value21 = (String)method21.invoke(oldModel,
							(Object[])null);

					newModel.setBillingCity(value21);

					Method method22 = oldModelClass.getMethod("getBillingState");

					String value22 = (String)method22.invoke(oldModel,
							(Object[])null);

					newModel.setBillingState(value22);

					Method method23 = oldModelClass.getMethod("getBillingZip");

					String value23 = (String)method23.invoke(oldModel,
							(Object[])null);

					newModel.setBillingZip(value23);

					Method method24 = oldModelClass.getMethod(
							"getBillingCountry");

					String value24 = (String)method24.invoke(oldModel,
							(Object[])null);

					newModel.setBillingCountry(value24);

					Method method25 = oldModelClass.getMethod("getBillingPhone");

					String value25 = (String)method25.invoke(oldModel,
							(Object[])null);

					newModel.setBillingPhone(value25);

					Method method26 = oldModelClass.getMethod(
							"getShipToBilling");

					Boolean value26 = (Boolean)method26.invoke(oldModel,
							(Object[])null);

					newModel.setShipToBilling(value26);

					Method method27 = oldModelClass.getMethod(
							"getShippingFirstName");

					String value27 = (String)method27.invoke(oldModel,
							(Object[])null);

					newModel.setShippingFirstName(value27);

					Method method28 = oldModelClass.getMethod(
							"getShippingLastName");

					String value28 = (String)method28.invoke(oldModel,
							(Object[])null);

					newModel.setShippingLastName(value28);

					Method method29 = oldModelClass.getMethod(
							"getShippingEmailAddress");

					String value29 = (String)method29.invoke(oldModel,
							(Object[])null);

					newModel.setShippingEmailAddress(value29);

					Method method30 = oldModelClass.getMethod(
							"getShippingCompany");

					String value30 = (String)method30.invoke(oldModel,
							(Object[])null);

					newModel.setShippingCompany(value30);

					Method method31 = oldModelClass.getMethod(
							"getShippingStreet");

					String value31 = (String)method31.invoke(oldModel,
							(Object[])null);

					newModel.setShippingStreet(value31);

					Method method32 = oldModelClass.getMethod("getShippingCity");

					String value32 = (String)method32.invoke(oldModel,
							(Object[])null);

					newModel.setShippingCity(value32);

					Method method33 = oldModelClass.getMethod(
							"getShippingState");

					String value33 = (String)method33.invoke(oldModel,
							(Object[])null);

					newModel.setShippingState(value33);

					Method method34 = oldModelClass.getMethod("getShippingZip");

					String value34 = (String)method34.invoke(oldModel,
							(Object[])null);

					newModel.setShippingZip(value34);

					Method method35 = oldModelClass.getMethod(
							"getShippingCountry");

					String value35 = (String)method35.invoke(oldModel,
							(Object[])null);

					newModel.setShippingCountry(value35);

					Method method36 = oldModelClass.getMethod(
							"getShippingPhone");

					String value36 = (String)method36.invoke(oldModel,
							(Object[])null);

					newModel.setShippingPhone(value36);

					Method method37 = oldModelClass.getMethod("getCcName");

					String value37 = (String)method37.invoke(oldModel,
							(Object[])null);

					newModel.setCcName(value37);

					Method method38 = oldModelClass.getMethod("getCcType");

					String value38 = (String)method38.invoke(oldModel,
							(Object[])null);

					newModel.setCcType(value38);

					Method method39 = oldModelClass.getMethod("getCcNumber");

					String value39 = (String)method39.invoke(oldModel,
							(Object[])null);

					newModel.setCcNumber(value39);

					Method method40 = oldModelClass.getMethod("getCcExpMonth");

					Integer value40 = (Integer)method40.invoke(oldModel,
							(Object[])null);

					newModel.setCcExpMonth(value40);

					Method method41 = oldModelClass.getMethod("getCcExpYear");

					Integer value41 = (Integer)method41.invoke(oldModel,
							(Object[])null);

					newModel.setCcExpYear(value41);

					Method method42 = oldModelClass.getMethod("getCcVerNumber");

					String value42 = (String)method42.invoke(oldModel,
							(Object[])null);

					newModel.setCcVerNumber(value42);

					Method method43 = oldModelClass.getMethod("getComments");

					String value43 = (String)method43.invoke(oldModel,
							(Object[])null);

					newModel.setComments(value43);

					Method method44 = oldModelClass.getMethod("getPpTxnId");

					String value44 = (String)method44.invoke(oldModel,
							(Object[])null);

					newModel.setPpTxnId(value44);

					Method method45 = oldModelClass.getMethod(
							"getPpPaymentStatus");

					String value45 = (String)method45.invoke(oldModel,
							(Object[])null);

					newModel.setPpPaymentStatus(value45);

					Method method46 = oldModelClass.getMethod(
							"getPpPaymentGross");

					Double value46 = (Double)method46.invoke(oldModel,
							(Object[])null);

					newModel.setPpPaymentGross(value46);

					Method method47 = oldModelClass.getMethod(
							"getPpReceiverEmail");

					String value47 = (String)method47.invoke(oldModel,
							(Object[])null);

					newModel.setPpReceiverEmail(value47);

					Method method48 = oldModelClass.getMethod("getPpPayerEmail");

					String value48 = (String)method48.invoke(oldModel,
							(Object[])null);

					newModel.setPpPayerEmail(value48);

					Method method49 = oldModelClass.getMethod(
							"getSendOrderEmail");

					Boolean value49 = (Boolean)method49.invoke(oldModel,
							(Object[])null);

					newModel.setSendOrderEmail(value49);

					Method method50 = oldModelClass.getMethod(
							"getSendShippingEmail");

					Boolean value50 = (Boolean)method50.invoke(oldModel,
							(Object[])null);

					newModel.setSendShippingEmail(value50);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.liferay.shopping.model.impl.ShoppingOrderItemImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					ShoppingOrderItemClp newModel = new ShoppingOrderItemClp();

					Method method0 = oldModelClass.getMethod("getOrderItemId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setOrderItemId(value0);

					Method method1 = oldModelClass.getMethod("getOrderId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setOrderId(value1);

					Method method2 = oldModelClass.getMethod("getItemId");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setItemId(value2);

					Method method3 = oldModelClass.getMethod("getSku");

					String value3 = (String)method3.invoke(oldModel,
							(Object[])null);

					newModel.setSku(value3);

					Method method4 = oldModelClass.getMethod("getName");

					String value4 = (String)method4.invoke(oldModel,
							(Object[])null);

					newModel.setName(value4);

					Method method5 = oldModelClass.getMethod("getDescription");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setDescription(value5);

					Method method6 = oldModelClass.getMethod("getProperties");

					String value6 = (String)method6.invoke(oldModel,
							(Object[])null);

					newModel.setProperties(value6);

					Method method7 = oldModelClass.getMethod("getPrice");

					Double value7 = (Double)method7.invoke(oldModel,
							(Object[])null);

					newModel.setPrice(value7);

					Method method8 = oldModelClass.getMethod("getQuantity");

					Integer value8 = (Integer)method8.invoke(oldModel,
							(Object[])null);

					newModel.setQuantity(value8);

					Method method9 = oldModelClass.getMethod("getShippedDate");

					Date value9 = (Date)method9.invoke(oldModel, (Object[])null);

					newModel.setShippedDate(value9);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}