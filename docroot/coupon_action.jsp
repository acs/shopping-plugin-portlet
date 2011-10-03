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

<%@ include file="/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

ShoppingCoupon coupon = (ShoppingCoupon)row.getObject();

%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<%-- <portlet:param name="struts_action" value="/shopping/edit_coupon" /> --%>
		<portlet:param name="jspPage" value="/edit_coupon.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="couponId" value="<%= String.valueOf(coupon.getCouponId()) %>" />
	</portlet:renderURL>

	<liferay-ui:icon
		image="edit"
		url="<%= editURL %>"
	/>

	<portlet:actionURL var="deleteURL" name="deleteCoupons">
		<%-- <portlet:param name="struts_action" value="/shopping/edit_coupon" /> --%>
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="deleteCouponIds" value="<%= String.valueOf(coupon.getCouponId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete url="<%= deleteURL %>" />
</liferay-ui:icon-menu>
