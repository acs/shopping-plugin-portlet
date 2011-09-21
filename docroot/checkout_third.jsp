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
String orderId = ParamUtil.getString(request, "orderId");

try {
	ShoppingCart cart = ShoppingUtil.getCart(renderRequest);

	ShoppingCartLocalServiceUtil.updateCart(cart.getUserId(), cart.getGroupId(), StringPool.BLANK, StringPool.BLANK, 0, false);
}
catch (Exception e) {
}
%>

<liferay-util:include page="/tabs1.jsp">
	<liferay-util:param name="tabs1" value="cart" />
</liferay-util:include>

<div class="portlet-msg-success">
	<liferay-ui:message key="thank-you-for-your-purchase" />
</div>

<liferay-ui:message key="your-order-number-is" /> <strong><%= orderId %></strong>. <liferay-ui:message key="you-will-receive-an-email-shortly-with-your-order-summary-and-further-details" />