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
String redirect = ParamUtil.getString(request, "redirect");

long categoryId = ParamUtil.getLong(request, "categoryId", ShoppingCategoryConstants.DEFAULT_PARENT_CATEGORY_ID);
%>

<portlet:actionURL var="addBookItemsURL">
	<portlet:param name="struts_action" value="/shopping/add_book_items" />
</portlet:actionURL>

<aui:form action="<%= addBookItemsURL %>" method="post" name="fm" onSubmit='<%= renderResponse.getNamespace() + "saveBookItem();" %>'>
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="categoryId" type="hidden" value="<%= categoryId %>" />

	<liferay-util:include page="/tabs1.jsp">
		<liferay-util:param name="tabs1" value="categories" />
	</liferay-util:include>

	<div class="breadcrumbs">
		<%= ShoppingUtil.getBreadcrumbs(categoryId, pageContext, renderRequest, renderResponse) %>
	</div>

	<aui:fieldset>
		<aui:input cssClass="lfr-textarea-container" label="add-all-isbn-numbers-separated-by-spaces" name="isbns" type="textarea" wrap="soft" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<input type="button" value='<liferay-ui:message key="cancel" />' onClick='location.href = "<%= redirect.toString() %>"' />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />saveBookItem() {
		alert('<%= UnicodeLanguageUtil.get(pageContext, "please-be-patient") %>');

		submitForm(this);
	}

	<c:if test="<%= windowState.equals(WindowState.MAXIMIZED) %>">
		Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />isbns);
	</c:if>
</aui:script>
