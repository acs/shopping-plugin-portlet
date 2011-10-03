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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * The utility for the shopping item field local service. This utility wraps {@link com.liferay.shopping.service.impl.ShoppingItemFieldLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.shopping.service.impl.ShoppingItemFieldLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemFieldLocalService
 * @see com.liferay.shopping.service.base.ShoppingItemFieldLocalServiceBaseImpl
 * @see com.liferay.shopping.service.impl.ShoppingItemFieldLocalServiceImpl
 * @generated
 */
public class ShoppingItemFieldLocalServiceUtil {
	/**
	* Adds the shopping item field to the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemField the shopping item field to add
	* @return the shopping item field that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItemField addShoppingItemField(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addShoppingItemField(shoppingItemField);
	}

	/**
	* Creates a new shopping item field with the primary key. Does not add the shopping item field to the database.
	*
	* @param itemFieldId the primary key for the new shopping item field
	* @return the new shopping item field
	*/
	public static com.liferay.shopping.model.ShoppingItemField createShoppingItemField(
		long itemFieldId) {
		return getService().createShoppingItemField(itemFieldId);
	}

	/**
	* Deletes the shopping item field with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param itemFieldId the primary key of the shopping item field to delete
	* @throws PortalException if a shopping item field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingItemField(long itemFieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingItemField(itemFieldId);
	}

	/**
	* Deletes the shopping item field from the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemField the shopping item field to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteShoppingItemField(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteShoppingItemField(shoppingItemField);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the shopping item field with the primary key.
	*
	* @param itemFieldId the primary key of the shopping item field to get
	* @return the shopping item field
	* @throws PortalException if a shopping item field with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItemField getShoppingItemField(
		long itemFieldId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingItemField(itemFieldId);
	}

	/**
	* Gets a range of all the shopping item fields.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of shopping item fields to return
	* @param end the upper bound of the range of shopping item fields to return (not inclusive)
	* @return the range of shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.shopping.model.ShoppingItemField> getShoppingItemFields(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingItemFields(start, end);
	}

	/**
	* Gets the number of shopping item fields.
	*
	* @return the number of shopping item fields
	* @throws SystemException if a system exception occurred
	*/
	public static int getShoppingItemFieldsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getShoppingItemFieldsCount();
	}

	/**
	* Updates the shopping item field in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemField the shopping item field to update
	* @return the shopping item field that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItemField updateShoppingItemField(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingItemField(shoppingItemField);
	}

	/**
	* Updates the shopping item field in the database. Also notifies the appropriate model listeners.
	*
	* @param shoppingItemField the shopping item field to update
	* @param merge whether to merge the shopping item field with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the shopping item field that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.shopping.model.ShoppingItemField updateShoppingItemField(
		com.liferay.shopping.model.ShoppingItemField shoppingItemField,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateShoppingItemField(shoppingItemField, merge);
	}

	public static java.util.List<com.liferay.shopping.model.ShoppingItemField> getItemFields(
		long itemId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getItemFields(itemId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ShoppingItemFieldLocalService getService() {
		if (_service == null) {
			Object obj = PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					ShoppingItemFieldLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.SERVLET_CONTEXT_NAME,
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(obj,
					portletClassLoader);

			_service = new ShoppingItemFieldLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);
		}

		return _service;
	}

	public void setService(ShoppingItemFieldLocalService service) {
		_service = service;
	}

	private static ShoppingItemFieldLocalService _service;
}