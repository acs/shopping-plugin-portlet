<%--
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
--%>

<%--
--
<%@ include file="init-common.jsp" %>
--
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.servlet.ImageServletTokenUtil" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.kernel.util.ArrayUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.KeyValuePair" %>
<%@ page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@ page import="com.liferay.portal.kernel.util.OrderedProperties" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropertiesUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PrefsPropsUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@ page import="com.liferay.portal.kernel.util.StringBundler" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.UnicodeFormatter" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.service.AddressServiceUtil" %>
<%@ page import="com.liferay.portal.model.Address" %>
<%@ page import="com.liferay.portal.model.Contact" %>
<%@ page import="com.liferay.portal.model.Country" %>
<%@ page import="com.liferay.portal.model.Country" %>
<%@ page import="com.liferay.portal.model.Region" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.util.PortletKeys" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil" %>
<%@ page import="com.liferay.portlet.PortletURLUtil" %>
<%@ page import="com.liferay.portal.service.permission.GroupPermissionUtil" %>
<%-- <%@ page import="com.liferay.portal.webserver.WebServerServletTokenUtil" %> --%>
<%@ page import="com.liferay.shopping.webserver.WebServerServletTokenUtil" %>
<%@ page import="com.liferay.util.CreditCard" %>
<%@ page import="com.liferay.util.StateUtil" %>
<%@ page import="java.text.Format" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Currency" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.util.Set" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.PortletMode" %>

<%--
--
<%@ include file="init-portlet.jsp" %>
--
--%>

<portlet:defineObjects />

<liferay-theme:defineObjects />

<%
WindowState windowState = null;
PortletMode portletMode = null;

PortletURL currentURLObj = null;

if (renderRequest != null) {
    windowState = renderRequest.getWindowState();
    portletMode = renderRequest.getPortletMode();

    currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
}
else if (resourceRequest != null) {
    windowState = resourceRequest.getWindowState();
    portletMode = resourceRequest.getPortletMode();

    currentURLObj = PortletURLUtil.getCurrent(resourceRequest, resourceResponse);
}

String currentURL = currentURLObj.toString();
//String currentURL = PortalUtil.getCurrentURL(request);
%>


<%-- SERVICE CLASSES --%>
<%@ page import="com.liferay.shopping.BillingCityException" %>
<%@ page import="com.liferay.shopping.BillingCountryException" %>
<%@ page import="com.liferay.shopping.BillingEmailAddressException" %>
<%@ page import="com.liferay.shopping.BillingFirstNameException" %>
<%@ page import="com.liferay.shopping.BillingLastNameException" %>
<%@ page import="com.liferay.shopping.BillingPhoneException" %>
<%@ page import="com.liferay.shopping.BillingStateException" %>
<%@ page import="com.liferay.shopping.BillingStreetException" %>
<%@ page import="com.liferay.shopping.BillingZipException" %>
<%@ page import="com.liferay.shopping.CCExpirationException" %>
<%@ page import="com.liferay.shopping.CCNameException" %>
<%@ page import="com.liferay.shopping.CCNumberException" %>
<%@ page import="com.liferay.shopping.CCTypeException" %>
<%@ page import="com.liferay.shopping.CartMinQuantityException" %>
<%@ page import="com.liferay.shopping.CategoryNameException" %>
<%@ page import="com.liferay.shopping.CouponActiveException" %>
<%@ page import="com.liferay.shopping.CouponCodeException" %>
<%@ page import="com.liferay.shopping.CouponDateException" %>
<%@ page import="com.liferay.shopping.CouponDescriptionException" %>
<%@ page import="com.liferay.shopping.CouponDiscountException" %>
<%@ page import="com.liferay.shopping.CouponEndDateException" %>
<%@ page import="com.liferay.shopping.CouponLimitCategoriesException" %>
<%@ page import="com.liferay.shopping.CouponLimitSKUsException" %>
<%@ page import="com.liferay.shopping.CouponMinimumOrderException" %>
<%@ page import="com.liferay.shopping.CouponNameException" %>
<%@ page import="com.liferay.shopping.CouponStartDateException" %>
<%@ page import="com.liferay.shopping.DuplicateCouponCodeException" %>
<%@ page import="com.liferay.shopping.DuplicateItemSKUException" %>
<%@ page import="com.liferay.shopping.ItemLargeImageNameException" %>
<%@ page import="com.liferay.shopping.ItemLargeImageSizeException" %>
<%@ page import="com.liferay.shopping.ItemMediumImageNameException" %>
<%@ page import="com.liferay.shopping.ItemMediumImageSizeException" %>
<%@ page import="com.liferay.shopping.ItemNameException" %>
<%@ page import="com.liferay.shopping.ItemSKUException" %>
<%@ page import="com.liferay.shopping.ItemSmallImageNameException" %>
<%@ page import="com.liferay.shopping.ItemSmallImageSizeException" %>
<%@ page import="com.liferay.shopping.NoSuchCategoryException" %>
<%@ page import="com.liferay.shopping.NoSuchCouponException" %>
<%@ page import="com.liferay.shopping.NoSuchItemException" %>
<%@ page import="com.liferay.shopping.NoSuchOrderException" %>
<%@ page import="com.liferay.shopping.ShippingCityException" %>
<%@ page import="com.liferay.shopping.ShippingCountryException" %>
<%@ page import="com.liferay.shopping.ShippingEmailAddressException" %>
<%@ page import="com.liferay.shopping.ShippingFirstNameException" %>
<%@ page import="com.liferay.shopping.ShippingLastNameException" %>
<%@ page import="com.liferay.shopping.ShippingPhoneException" %>
<%@ page import="com.liferay.shopping.ShippingStateException" %>
<%@ page import="com.liferay.shopping.ShippingStreetException" %>
<%@ page import="com.liferay.shopping.ShippingZipException" %>
<%@ page import="com.liferay.shopping.model.ShoppingCart" %>
<%@ page import="com.liferay.shopping.model.ShoppingCartItem" %>
<%@ page import="com.liferay.shopping.model.ShoppingCategory" %>
<%@ page import="com.liferay.shopping.model.ShoppingCategoryConstants" %>
<%@ page import="com.liferay.shopping.model.ShoppingCoupon" %>
<%@ page import="com.liferay.shopping.model.ShoppingCouponConstants" %>
<%@ page import="com.liferay.shopping.model.ShoppingItem" %>
<%@ page import="com.liferay.shopping.model.ShoppingItemField" %>
<%@ page import="com.liferay.shopping.model.ShoppingItemPrice" %>
<%@ page import="com.liferay.shopping.model.ShoppingItemPriceConstants" %>
<%@ page import="com.liferay.shopping.model.ShoppingOrder" %>
<%@ page import="com.liferay.shopping.model.ShoppingOrderConstants" %>
<%@ page import="com.liferay.shopping.model.ShoppingOrderItem" %>
<%@ page import="com.liferay.shopping.search.CouponDisplayTerms" %>
<%@ page import="com.liferay.shopping.search.CouponSearch" %>
<%@ page import="com.liferay.shopping.search.CouponSearchTerms" %>
<%@ page import="com.liferay.shopping.search.OrderDisplayTerms" %>
<%@ page import="com.liferay.shopping.search.OrderSearch" %>
<%@ page import="com.liferay.shopping.search.OrderSearchTerms" %>
<%@ page import="com.liferay.shopping.service.ShoppingCartLocalServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingCategoryServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingCouponLocalServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingCouponServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingItemFieldLocalServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingItemLocalServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingItemPriceLocalServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingItemServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingOrderItemLocalServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingOrderLocalServiceUtil" %>
<%@ page import="com.liferay.shopping.service.ShoppingOrderServiceUtil" %>
<%@ page import="com.liferay.shopping.service.permission.ShoppingCategoryPermission" %>
<%@ page import="com.liferay.shopping.service.permission.ShoppingItemPermission" %>
<%@ page import="com.liferay.shopping.service.permission.ShoppingOrderPermission" %>
<%@ page import="com.liferay.shopping.service.permission.ShoppingPermission" %>
<%@ page import="com.liferay.shopping.util.ShoppingPreferences" %>
<%@ page import="com.liferay.shopping.util.ShoppingUtil" %>
<%@ page import="com.liferay.shopping.util.WebKeys" %>


<%
PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(request);
ShoppingPreferences shoppingPrefs = ShoppingPreferences.getInstance(company.getCompanyId(), scopeGroupId);

Currency currency = Currency.getInstance(shoppingPrefs.getCurrencyId());

NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);

currencyFormat.setCurrency(currency);

Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

NumberFormat doubleFormat = NumberFormat.getNumberInstance(locale);

doubleFormat.setMaximumFractionDigits(2);
doubleFormat.setMinimumFractionDigits(2);

NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);

NumberFormat taxFormat = NumberFormat.getPercentInstance(locale);

taxFormat.setMinimumFractionDigits(3);
%>
