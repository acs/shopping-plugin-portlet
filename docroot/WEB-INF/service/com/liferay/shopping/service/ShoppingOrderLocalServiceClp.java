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

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingOrderLocalServiceClp implements ShoppingOrderLocalService {
	public ShoppingOrderLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
		_classLoaderProxy = classLoaderProxy;

		_addShoppingOrderMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
				"addShoppingOrder",
				com.liferay.shopping.model.ShoppingOrder.class);

		_createShoppingOrderMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
				"createShoppingOrder", long.class);

		_deleteShoppingOrderMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteShoppingOrder", long.class);

		_deleteShoppingOrderMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteShoppingOrder",
				com.liferay.shopping.model.ShoppingOrder.class);

		_dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class);

		_dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQuery",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
				int.class, int.class,
				com.liferay.portal.kernel.util.OrderByComparator.class);

		_dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
				"dynamicQueryCount",
				com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

		_getShoppingOrderMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingOrder", long.class);

		_getPersistedModelMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPersistedModel", java.io.Serializable.class);

		_getShoppingOrdersMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingOrders", int.class, int.class);

		_getShoppingOrdersCountMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
				"getShoppingOrdersCount");

		_updateShoppingOrderMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateShoppingOrder",
				com.liferay.shopping.model.ShoppingOrder.class);

		_updateShoppingOrderMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateShoppingOrder",
				com.liferay.shopping.model.ShoppingOrder.class, boolean.class);

		_getBeanIdentifierMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
				"getBeanIdentifier");

		_setBeanIdentifierMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
				"setBeanIdentifier", java.lang.String.class);

		_addLatestOrderMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
				"addLatestOrder", long.class, long.class);

		_completeOrderMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
				"completeOrder", java.lang.String.class,
				java.lang.String.class, java.lang.String.class, double.class,
				java.lang.String.class, java.lang.String.class, boolean.class);

		_deleteOrderMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteOrder", long.class);

		_deleteOrderMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteOrder", com.liferay.shopping.model.ShoppingOrder.class);

		_deleteOrdersMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
				"deleteOrders", long.class);

		_getLatestOrderMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
				"getLatestOrder", long.class, long.class);

		_getOrderMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOrder", long.class);

		_getOrderMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
				"getOrder", java.lang.String.class);

		_getPayPalTxnIdOrderMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
				"getPayPalTxnIdOrder", java.lang.String.class);

		_saveLatestOrderMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
				"saveLatestOrder", com.liferay.shopping.model.ShoppingCart.class);

		_searchMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
				"search", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				int.class, int.class);

		_searchCountMethodKey27 = new MethodKey(_classLoaderProxy.getClassName(),
				"searchCount", long.class, long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class);

		_sendEmailMethodKey28 = new MethodKey(_classLoaderProxy.getClassName(),
				"sendEmail", long.class, java.lang.String.class);

		_sendEmailMethodKey29 = new MethodKey(_classLoaderProxy.getClassName(),
				"sendEmail", com.liferay.shopping.model.ShoppingOrder.class,
				java.lang.String.class);

		_updateLatestOrderMethodKey30 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateLatestOrder", long.class, long.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, boolean.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, int.class, int.class,
				java.lang.String.class, java.lang.String.class);

		_updateOrderMethodKey31 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateOrder", long.class, java.lang.String.class,
				java.lang.String.class, double.class, java.lang.String.class,
				java.lang.String.class);

		_updateOrderMethodKey32 = new MethodKey(_classLoaderProxy.getClassName(),
				"updateOrder", long.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, boolean.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class,
				java.lang.String.class, java.lang.String.class, int.class,
				int.class, java.lang.String.class, java.lang.String.class);
	}

	public com.liferay.shopping.model.ShoppingOrder addShoppingOrder(
		com.liferay.shopping.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addShoppingOrderMethodKey0,
				ClpSerializer.translateInput(shoppingOrder));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingOrder createShoppingOrder(
		long orderId) {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_createShoppingOrderMethodKey1,
				orderId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public void deleteShoppingOrder(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteShoppingOrderMethodKey2,
				orderId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteShoppingOrder(
		com.liferay.shopping.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteShoppingOrderMethodKey3,
				ClpSerializer.translateInput(shoppingOrder));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
				ClpSerializer.translateInput(dynamicQuery), start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
				ClpSerializer.translateInput(dynamicQuery), start, end,
				ClpSerializer.translateInput(orderByComparator));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
				ClpSerializer.translateInput(dynamicQuery));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	public com.liferay.shopping.model.ShoppingOrder getShoppingOrder(
		long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingOrderMethodKey8,
				orderId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey9,
				ClpSerializer.translateInput(primaryKeyObj));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingOrder> getShoppingOrders(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingOrdersMethodKey10,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.shopping.model.ShoppingOrder>)ClpSerializer.translateOutput(returnObj);
	}

	public int getShoppingOrdersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getShoppingOrdersCountMethodKey11);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public com.liferay.shopping.model.ShoppingOrder updateShoppingOrder(
		com.liferay.shopping.model.ShoppingOrder shoppingOrder)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateShoppingOrderMethodKey12,
				ClpSerializer.translateInput(shoppingOrder));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingOrder updateShoppingOrder(
		com.liferay.shopping.model.ShoppingOrder shoppingOrder, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateShoppingOrderMethodKey13,
				ClpSerializer.translateInput(shoppingOrder), merge);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey14);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey15,
				ClpSerializer.translateInput(beanIdentifier));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.liferay.shopping.model.ShoppingOrder addLatestOrder(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_addLatestOrderMethodKey16,
				userId, groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public void completeOrder(java.lang.String number,
		java.lang.String ppTxnId, java.lang.String ppPaymentStatus,
		double ppPaymentGross, java.lang.String ppReceiverEmail,
		java.lang.String ppPayerEmail, boolean updateInventory)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_completeOrderMethodKey17,
				ClpSerializer.translateInput(number),
				ClpSerializer.translateInput(ppTxnId),
				ClpSerializer.translateInput(ppPaymentStatus), ppPaymentGross,
				ClpSerializer.translateInput(ppReceiverEmail),
				ClpSerializer.translateInput(ppPayerEmail), updateInventory);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteOrder(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteOrderMethodKey18,
				orderId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteOrder(com.liferay.shopping.model.ShoppingOrder order)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteOrderMethodKey19,
				ClpSerializer.translateInput(order));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void deleteOrders(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_deleteOrdersMethodKey20,
				groupId);

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.liferay.shopping.model.ShoppingOrder getLatestOrder(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getLatestOrderMethodKey21,
				userId, groupId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingOrder getOrder(long orderId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOrderMethodKey22,
				orderId);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingOrder getOrder(
		java.lang.String number)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getOrderMethodKey23,
				ClpSerializer.translateInput(number));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingOrder getPayPalTxnIdOrder(
		java.lang.String ppTxnId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_getPayPalTxnIdOrderMethodKey24,
				ClpSerializer.translateInput(ppTxnId));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingOrder saveLatestOrder(
		com.liferay.shopping.model.ShoppingCart cart)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_saveLatestOrderMethodKey25,
				ClpSerializer.translateInput(cart));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public java.util.List<com.liferay.shopping.model.ShoppingOrder> search(
		long groupId, long companyId, long userId, java.lang.String number,
		java.lang.String billingFirstName, java.lang.String billingLastName,
		java.lang.String billingEmailAddress,
		java.lang.String shippingFirstName, java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String ppPaymentStatus, boolean andOperator, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchMethodKey26,
				groupId, companyId, userId,
				ClpSerializer.translateInput(number),
				ClpSerializer.translateInput(billingFirstName),
				ClpSerializer.translateInput(billingLastName),
				ClpSerializer.translateInput(billingEmailAddress),
				ClpSerializer.translateInput(shippingFirstName),
				ClpSerializer.translateInput(shippingLastName),
				ClpSerializer.translateInput(shippingEmailAddress),
				ClpSerializer.translateInput(ppPaymentStatus), andOperator,
				start, end);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.shopping.model.ShoppingOrder>)ClpSerializer.translateOutput(returnObj);
	}

	public int searchCount(long groupId, long companyId, long userId,
		java.lang.String number, java.lang.String billingFirstName,
		java.lang.String billingLastName, java.lang.String billingEmailAddress,
		java.lang.String shippingFirstName, java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String ppPaymentStatus, boolean andOperator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_searchCountMethodKey27,
				groupId, companyId, userId,
				ClpSerializer.translateInput(number),
				ClpSerializer.translateInput(billingFirstName),
				ClpSerializer.translateInput(billingLastName),
				ClpSerializer.translateInput(billingEmailAddress),
				ClpSerializer.translateInput(shippingFirstName),
				ClpSerializer.translateInput(shippingLastName),
				ClpSerializer.translateInput(shippingEmailAddress),
				ClpSerializer.translateInput(ppPaymentStatus), andOperator);

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	public void sendEmail(long orderId, java.lang.String emailType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_sendEmailMethodKey28,
				orderId, ClpSerializer.translateInput(emailType));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public void sendEmail(com.liferay.shopping.model.ShoppingOrder order,
		java.lang.String emailType)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		MethodHandler methodHandler = new MethodHandler(_sendEmailMethodKey29,
				ClpSerializer.translateInput(order),
				ClpSerializer.translateInput(emailType));

		try {
			_classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	public com.liferay.shopping.model.ShoppingOrder updateLatestOrder(
		long userId, long groupId, java.lang.String billingFirstName,
		java.lang.String billingLastName, java.lang.String billingEmailAddress,
		java.lang.String billingCompany, java.lang.String billingStreet,
		java.lang.String billingCity, java.lang.String billingState,
		java.lang.String billingZip, java.lang.String billingCountry,
		java.lang.String billingPhone, boolean shipToBilling,
		java.lang.String shippingFirstName, java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String shippingCompany, java.lang.String shippingStreet,
		java.lang.String shippingCity, java.lang.String shippingState,
		java.lang.String shippingZip, java.lang.String shippingCountry,
		java.lang.String shippingPhone, java.lang.String ccName,
		java.lang.String ccType, java.lang.String ccNumber, int ccExpMonth,
		int ccExpYear, java.lang.String ccVerNumber, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateLatestOrderMethodKey30,
				userId, groupId,
				ClpSerializer.translateInput(billingFirstName),
				ClpSerializer.translateInput(billingLastName),
				ClpSerializer.translateInput(billingEmailAddress),
				ClpSerializer.translateInput(billingCompany),
				ClpSerializer.translateInput(billingStreet),
				ClpSerializer.translateInput(billingCity),
				ClpSerializer.translateInput(billingState),
				ClpSerializer.translateInput(billingZip),
				ClpSerializer.translateInput(billingCountry),
				ClpSerializer.translateInput(billingPhone), shipToBilling,
				ClpSerializer.translateInput(shippingFirstName),
				ClpSerializer.translateInput(shippingLastName),
				ClpSerializer.translateInput(shippingEmailAddress),
				ClpSerializer.translateInput(shippingCompany),
				ClpSerializer.translateInput(shippingStreet),
				ClpSerializer.translateInput(shippingCity),
				ClpSerializer.translateInput(shippingState),
				ClpSerializer.translateInput(shippingZip),
				ClpSerializer.translateInput(shippingCountry),
				ClpSerializer.translateInput(shippingPhone),
				ClpSerializer.translateInput(ccName),
				ClpSerializer.translateInput(ccType),
				ClpSerializer.translateInput(ccNumber), ccExpMonth, ccExpYear,
				ClpSerializer.translateInput(ccVerNumber),
				ClpSerializer.translateInput(comments));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingOrder updateOrder(long orderId,
		java.lang.String ppTxnId, java.lang.String ppPaymentStatus,
		double ppPaymentGross, java.lang.String ppReceiverEmail,
		java.lang.String ppPayerEmail)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateOrderMethodKey31,
				orderId, ClpSerializer.translateInput(ppTxnId),
				ClpSerializer.translateInput(ppPaymentStatus), ppPaymentGross,
				ClpSerializer.translateInput(ppReceiverEmail),
				ClpSerializer.translateInput(ppPayerEmail));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public com.liferay.shopping.model.ShoppingOrder updateOrder(long orderId,
		java.lang.String billingFirstName, java.lang.String billingLastName,
		java.lang.String billingEmailAddress, java.lang.String billingCompany,
		java.lang.String billingStreet, java.lang.String billingCity,
		java.lang.String billingState, java.lang.String billingZip,
		java.lang.String billingCountry, java.lang.String billingPhone,
		boolean shipToBilling, java.lang.String shippingFirstName,
		java.lang.String shippingLastName,
		java.lang.String shippingEmailAddress,
		java.lang.String shippingCompany, java.lang.String shippingStreet,
		java.lang.String shippingCity, java.lang.String shippingState,
		java.lang.String shippingZip, java.lang.String shippingCountry,
		java.lang.String shippingPhone, java.lang.String ccName,
		java.lang.String ccType, java.lang.String ccNumber, int ccExpMonth,
		int ccExpYear, java.lang.String ccVerNumber, java.lang.String comments)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		MethodHandler methodHandler = new MethodHandler(_updateOrderMethodKey32,
				orderId, ClpSerializer.translateInput(billingFirstName),
				ClpSerializer.translateInput(billingLastName),
				ClpSerializer.translateInput(billingEmailAddress),
				ClpSerializer.translateInput(billingCompany),
				ClpSerializer.translateInput(billingStreet),
				ClpSerializer.translateInput(billingCity),
				ClpSerializer.translateInput(billingState),
				ClpSerializer.translateInput(billingZip),
				ClpSerializer.translateInput(billingCountry),
				ClpSerializer.translateInput(billingPhone), shipToBilling,
				ClpSerializer.translateInput(shippingFirstName),
				ClpSerializer.translateInput(shippingLastName),
				ClpSerializer.translateInput(shippingEmailAddress),
				ClpSerializer.translateInput(shippingCompany),
				ClpSerializer.translateInput(shippingStreet),
				ClpSerializer.translateInput(shippingCity),
				ClpSerializer.translateInput(shippingState),
				ClpSerializer.translateInput(shippingZip),
				ClpSerializer.translateInput(shippingCountry),
				ClpSerializer.translateInput(shippingPhone),
				ClpSerializer.translateInput(ccName),
				ClpSerializer.translateInput(ccType),
				ClpSerializer.translateInput(ccNumber), ccExpMonth, ccExpYear,
				ClpSerializer.translateInput(ccVerNumber),
				ClpSerializer.translateInput(comments));

		try {
			returnObj = _classLoaderProxy.invoke(methodHandler);
		}
		catch (Throwable t) {
			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.shopping.model.ShoppingOrder)ClpSerializer.translateOutput(returnObj);
	}

	public ClassLoaderProxy getClassLoaderProxy() {
		return _classLoaderProxy;
	}

	private ClassLoaderProxy _classLoaderProxy;
	private MethodKey _addShoppingOrderMethodKey0;
	private MethodKey _createShoppingOrderMethodKey1;
	private MethodKey _deleteShoppingOrderMethodKey2;
	private MethodKey _deleteShoppingOrderMethodKey3;
	private MethodKey _dynamicQueryMethodKey4;
	private MethodKey _dynamicQueryMethodKey5;
	private MethodKey _dynamicQueryMethodKey6;
	private MethodKey _dynamicQueryCountMethodKey7;
	private MethodKey _getShoppingOrderMethodKey8;
	private MethodKey _getPersistedModelMethodKey9;
	private MethodKey _getShoppingOrdersMethodKey10;
	private MethodKey _getShoppingOrdersCountMethodKey11;
	private MethodKey _updateShoppingOrderMethodKey12;
	private MethodKey _updateShoppingOrderMethodKey13;
	private MethodKey _getBeanIdentifierMethodKey14;
	private MethodKey _setBeanIdentifierMethodKey15;
	private MethodKey _addLatestOrderMethodKey16;
	private MethodKey _completeOrderMethodKey17;
	private MethodKey _deleteOrderMethodKey18;
	private MethodKey _deleteOrderMethodKey19;
	private MethodKey _deleteOrdersMethodKey20;
	private MethodKey _getLatestOrderMethodKey21;
	private MethodKey _getOrderMethodKey22;
	private MethodKey _getOrderMethodKey23;
	private MethodKey _getPayPalTxnIdOrderMethodKey24;
	private MethodKey _saveLatestOrderMethodKey25;
	private MethodKey _searchMethodKey26;
	private MethodKey _searchCountMethodKey27;
	private MethodKey _sendEmailMethodKey28;
	private MethodKey _sendEmailMethodKey29;
	private MethodKey _updateLatestOrderMethodKey30;
	private MethodKey _updateOrderMethodKey31;
	private MethodKey _updateOrderMethodKey32;
}