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

package com.liferay.shopping.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
// import com.liferay.portal.util.PropsValues;
// import com.liferay.portal.util.SubscriptionSender;
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
import com.liferay.shopping.CartMinOrderException;
import com.liferay.shopping.NoSuchOrderException;
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
import com.liferay.shopping.model.ShoppingCartItem;
import com.liferay.shopping.model.ShoppingItem;
import com.liferay.shopping.model.ShoppingItemField;
import com.liferay.shopping.model.ShoppingOrder;
import com.liferay.shopping.model.ShoppingOrderConstants;
import com.liferay.shopping.model.ShoppingOrderItem;
import com.liferay.shopping.model.impl.ShoppingCartItemImpl;
import com.liferay.shopping.service.base.ShoppingOrderLocalServiceBaseImpl;
import com.liferay.shopping.util.ShoppingPreferences;
import com.liferay.shopping.util.ShoppingUtil;
import com.liferay.shopping.util.comparator.OrderDateComparator;
import com.liferay.util.CreditCard;
import com.liferay.util.PwdGenerator;

import java.io.IOException;

import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingOrderLocalServiceImpl
	extends ShoppingOrderLocalServiceBaseImpl {

	public ShoppingOrder addLatestOrder(long userId, long groupId)
		throws PortalException, SystemException {

		// Order

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		String number = getNumber();

		ShoppingOrder order = null;

		long orderId = counterLocalService.increment();

		List<ShoppingOrder> pastOrders =
			shoppingOrderPersistence.findByG_U_PPPS(
				groupId, userId, ShoppingOrderConstants.STATUS_CHECKOUT, 0, 1);

		if (pastOrders.size() > 0) {
			ShoppingOrder pastOrder = pastOrders.get(0);

			order = shoppingOrderPersistence.create(orderId);

			order.setBillingCompany(pastOrder.getBillingCompany());
			order.setBillingStreet(pastOrder.getBillingStreet());
			order.setBillingCity(pastOrder.getBillingCity());
			order.setBillingState(pastOrder.getBillingState());
			order.setBillingZip(pastOrder.getBillingZip());
			order.setBillingCountry(pastOrder.getBillingCountry());
			order.setBillingPhone(pastOrder.getBillingPhone());
			order.setShipToBilling(pastOrder.isShipToBilling());
			order.setShippingCompany(pastOrder.getShippingCompany());
			order.setShippingStreet(pastOrder.getShippingStreet());
			order.setShippingCity(pastOrder.getShippingCity());
			order.setShippingState(pastOrder.getShippingState());
			order.setShippingZip(pastOrder.getShippingZip());
			order.setShippingCountry(pastOrder.getShippingCountry());
			order.setShippingPhone(pastOrder.getShippingPhone());
		}
		else {
			order = shoppingOrderPersistence.create(orderId);
		}

		order.setGroupId(groupId);
		order.setCompanyId(user.getCompanyId());
		order.setUserId(user.getUserId());
		order.setUserName(user.getFullName());
		order.setCreateDate(now);
		order.setModifiedDate(now);
		order.setNumber(number);
		order.setBillingFirstName(user.getFirstName());
		order.setBillingLastName(user.getLastName());
		order.setBillingEmailAddress(user.getEmailAddress());
		order.setShippingFirstName(user.getFirstName());
		order.setShippingLastName(user.getLastName());
		order.setShippingEmailAddress(user.getEmailAddress());
		order.setCcName(user.getFullName());
		order.setPpPaymentStatus(ShoppingOrderConstants.STATUS_LATEST);
		order.setSendOrderEmail(true);
		order.setSendShippingEmail(true);

		shoppingOrderPersistence.update(order, false);

		// Message boards

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.SHOPPING_ORDER_COMMENTS_ENABLED))) {
			mbMessageLocalService.addDiscussionMessage(
				userId, order.getUserName(), groupId,
				ShoppingOrder.class.getName(), orderId,
				WorkflowConstants.ACTION_PUBLISH);
		}

		return order;
	}

	public void completeOrder(
		String number, String ppTxnId, String ppPaymentStatus,
		double ppPaymentGross, String ppReceiverEmail, String ppPayerEmail,
		boolean updateInventory)
		throws PortalException, SystemException {

		// Order

		ShoppingOrder order = shoppingOrderPersistence.findByNumber(number);

		order.setModifiedDate(new Date());
		order.setPpTxnId(ppTxnId);
		order.setPpPaymentStatus(ppPaymentStatus);
		order.setPpPaymentGross(ppPaymentGross);
		order.setPpReceiverEmail(ppReceiverEmail);
		order.setPpPayerEmail(ppPayerEmail);

		shoppingOrderPersistence.update(order, false);

		// Inventory

		if (updateInventory &&
			ppPaymentStatus.equals(ShoppingOrderConstants.STATUS_COMPLETED)) {

			List<ShoppingOrderItem> orderItems =
				shoppingOrderItemLocalService.getOrderItems(order.getOrderId());

			for (ShoppingOrderItem orderItem : orderItems) {
				ShoppingItem item =
					shoppingItemLocalService.getItem(ShoppingUtil.getItemId(orderItem.getItemId()));

				if (!item.isFields()) {
					int quantity =
						item.getStockQuantity() - orderItem.getQuantity();

					item.setStockQuantity(quantity);
				}
				else {
					List<ShoppingItemField> itemFields =
						shoppingItemFieldLocalService.getItemFields(item.getItemId());

					ShoppingItemField[] itemFieldsArray =
						itemFields.toArray(new ShoppingItemField[itemFields.size()]);

					String[] fieldsArray =
						ShoppingCartItemImpl.getFieldsArray(ShoppingUtil.getItemFields(orderItem.getItemId()));

					int rowPos =
						ShoppingUtil.getFieldsQuantitiesPos(
							item, itemFieldsArray, fieldsArray);

					String[] fieldsQuantities = item.getFieldsQuantitiesArray();

					try {
						int quantity =
							GetterUtil.getInteger(fieldsQuantities[rowPos]) -
								orderItem.getQuantity();

						fieldsQuantities[rowPos] = String.valueOf(quantity);

						item.setFieldsQuantitiesArray(fieldsQuantities);
					}
					catch (Exception e) {
					}
				}

				shoppingItemPersistence.update(item, false);
			}
		}

		// Email

		try {
			doSendEmail(order, "confirmation");
		}
		catch (IOException ioe) {
			throw new SystemException(ioe);
		}
	}

	public void deleteOrder(long orderId)
		throws PortalException, SystemException {

		ShoppingOrder order =
			shoppingOrderPersistence.findByPrimaryKey(orderId);

		deleteOrder(order);
	}

	public void deleteOrder(ShoppingOrder order)
		throws PortalException, SystemException {

		// Order

		shoppingOrderPersistence.remove(order);

		// Items

		shoppingOrderItemPersistence.removeByOrderId(order.getOrderId());

		// Message boards

		mbMessageLocalService.deleteDiscussionMessages(
			ShoppingOrder.class.getName(), order.getOrderId());
	}

	public void deleteOrders(long groupId)
		throws PortalException, SystemException {

		List<ShoppingOrder> orders =
			shoppingOrderPersistence.findByGroupId(groupId);

		for (ShoppingOrder order : orders) {
			deleteOrder(order);
		}
	}

	public ShoppingOrder getLatestOrder(long userId, long groupId)
		throws PortalException, SystemException {

		List<ShoppingOrder> orders =
			shoppingOrderPersistence.findByG_U_PPPS(
				groupId, userId, ShoppingOrderConstants.STATUS_LATEST, 0, 1);

		ShoppingOrder order = null;

		if (orders.size() == 1) {
			order = orders.get(0);
		}
		else {
			order = shoppingOrderLocalService.addLatestOrder(userId, groupId);
		}

		return order;
	}

	public ShoppingOrder getOrder(long orderId)
		throws PortalException, SystemException {

		return shoppingOrderPersistence.findByPrimaryKey(orderId);
	}

	public ShoppingOrder getOrder(String number)
		throws PortalException, SystemException {

		return shoppingOrderPersistence.findByNumber(number);
	}

	public ShoppingOrder getPayPalTxnIdOrder(String ppTxnId)
		throws PortalException, SystemException {

		return shoppingOrderPersistence.findByPPTxnId(ppTxnId);
	}

	public ShoppingOrder saveLatestOrder(ShoppingCart cart)
		throws PortalException, SystemException {

		Map<ShoppingCartItem, Integer> items = cart.getItems();
		Date now = new Date();

		ShoppingPreferences shoppingPrefs =
			ShoppingPreferences.getInstance(
				cart.getCompanyId(), cart.getGroupId());

		if (!ShoppingUtil.meetsMinOrder(shoppingPrefs, items)) {
			throw new CartMinOrderException();
		}

		ShoppingOrder order =
			getLatestOrder(cart.getUserId(), cart.getGroupId());

		order.setCreateDate(now);
		order.setModifiedDate(now);
		order.setPpPaymentStatus(ShoppingOrderConstants.STATUS_CHECKOUT);

		shoppingOrderPersistence.update(order, false);

		boolean requiresShipping = false;

		Iterator<Map.Entry<ShoppingCartItem, Integer>> itr =
			items.entrySet().iterator();

		while (itr.hasNext()) {
			Map.Entry<ShoppingCartItem, Integer> entry = itr.next();

			ShoppingCartItem cartItem = entry.getKey();
			Integer count = entry.getValue();

			ShoppingItem item = cartItem.getItem();

			if (item.isRequiresShipping()) {
				requiresShipping = true;
			}

			long orderItemId = counterLocalService.increment();

			ShoppingOrderItem orderItem =
				shoppingOrderItemPersistence.create(orderItemId);

			orderItem.setOrderId(order.getOrderId());
			orderItem.setItemId(cartItem.getCartItemId());
			orderItem.setSku(item.getSku());
			orderItem.setName(item.getName());
			orderItem.setDescription(item.getDescription());
			orderItem.setProperties(item.getProperties());
			orderItem.setPrice(ShoppingUtil.calculateActualPrice(
				item, count.intValue()) /
				count.intValue());
			orderItem.setQuantity(count.intValue());

			shoppingOrderItemPersistence.update(orderItem, false);
		}

		order.setModifiedDate(new Date());
		order.setTax(ShoppingUtil.calculateTax(items, order.getBillingState()));
		order.setShipping(ShoppingUtil.calculateAlternativeShipping(
			items, cart.getAltShipping()));
		order.setAltShipping(shoppingPrefs.getAlternativeShippingName(cart.getAltShipping()));
		order.setRequiresShipping(requiresShipping);
		order.setInsure(cart.isInsure());
		order.setInsurance(ShoppingUtil.calculateInsurance(items));
		order.setCouponCodes(cart.getCouponCodes());
		order.setCouponDiscount(ShoppingUtil.calculateCouponDiscount(
			items, order.getBillingState(), cart.getCoupon()));
		order.setSendOrderEmail(true);
		order.setSendShippingEmail(true);

		shoppingOrderPersistence.update(order, false);

		return order;
	}

	public List<ShoppingOrder> search(
		long groupId, long companyId, long userId, String number,
		String billingFirstName, String billingLastName,
		String billingEmailAddress, String shippingFirstName,
		String shippingLastName, String shippingEmailAddress,
		String ppPaymentStatus, boolean andOperator, int start, int end)
		throws SystemException {

		OrderDateComparator obc = new OrderDateComparator(false);

		return shoppingOrderFinder.findByG_C_U_N_PPPS(
			groupId, companyId, userId, number, billingFirstName,
			billingLastName, billingEmailAddress, shippingFirstName,
			shippingLastName, shippingEmailAddress, ppPaymentStatus,
			andOperator, start, end, obc);
	}

	public int searchCount(
		long groupId, long companyId, long userId, String number,
		String billingFirstName, String billingLastName,
		String billingEmailAddress, String shippingFirstName,
		String shippingLastName, String shippingEmailAddress,
		String ppPaymentStatus, boolean andOperator)
		throws SystemException {

		return shoppingOrderFinder.countByG_C_U_N_PPPS(
			groupId, companyId, userId, number, billingFirstName,
			billingLastName, billingEmailAddress, shippingFirstName,
			shippingLastName, shippingEmailAddress, ppPaymentStatus,
			andOperator);
	}

	public void sendEmail(long orderId, String emailType)
		throws PortalException, SystemException {

		ShoppingOrder order =
			shoppingOrderPersistence.findByPrimaryKey(orderId);

		try {
			doSendEmail(order, emailType);
		}
		catch (IOException ioe) {
			throw new SystemException(ioe);
		}
	}

	public void sendEmail(ShoppingOrder order, String emailType)
		throws PortalException, SystemException {

		try {
			doSendEmail(order, emailType);
		}
		catch (IOException ioe) {
			throw new SystemException(ioe);
		}
	}

	public ShoppingOrder updateLatestOrder(
		long userId, long groupId, String billingFirstName,
		String billingLastName, String billingEmailAddress,
		String billingCompany, String billingStreet, String billingCity,
		String billingState, String billingZip, String billingCountry,
		String billingPhone, boolean shipToBilling, String shippingFirstName,
		String shippingLastName, String shippingEmailAddress,
		String shippingCompany, String shippingStreet, String shippingCity,
		String shippingState, String shippingZip, String shippingCountry,
		String shippingPhone, String ccName, String ccType, String ccNumber,
		int ccExpMonth, int ccExpYear, String ccVerNumber, String comments)
		throws PortalException, SystemException {

		ShoppingOrder order = getLatestOrder(userId, groupId);

		return updateOrder(
			order.getOrderId(), billingFirstName, billingLastName,
			billingEmailAddress, billingCompany, billingStreet, billingCity,
			billingState, billingZip, billingCountry, billingPhone,
			shipToBilling, shippingFirstName, shippingLastName,
			shippingEmailAddress, shippingCompany, shippingStreet,
			shippingCity, shippingState, shippingZip, shippingCountry,
			shippingPhone, ccName, ccType, ccNumber, ccExpMonth, ccExpYear,
			ccVerNumber, comments);
	}

	public ShoppingOrder updateOrder(
		long orderId, String ppTxnId, String ppPaymentStatus,
		double ppPaymentGross, String ppReceiverEmail, String ppPayerEmail)
		throws PortalException, SystemException {

		ShoppingOrder order =
			shoppingOrderPersistence.findByPrimaryKey(orderId);

		order.setModifiedDate(new Date());
		order.setPpTxnId(ppTxnId);
		order.setPpPaymentStatus(ppPaymentStatus);
		order.setPpPaymentGross(ppPaymentGross);
		order.setPpReceiverEmail(ppReceiverEmail);
		order.setPpPayerEmail(ppPayerEmail);

		shoppingOrderPersistence.update(order, false);

		return order;
	}

	public ShoppingOrder updateOrder(
		long orderId, String billingFirstName, String billingLastName,
		String billingEmailAddress, String billingCompany,
		String billingStreet, String billingCity, String billingState,
		String billingZip, String billingCountry, String billingPhone,
		boolean shipToBilling, String shippingFirstName,
		String shippingLastName, String shippingEmailAddress,
		String shippingCompany, String shippingStreet, String shippingCity,
		String shippingState, String shippingZip, String shippingCountry,
		String shippingPhone, String ccName, String ccType, String ccNumber,
		int ccExpMonth, int ccExpYear, String ccVerNumber, String comments)
		throws PortalException, SystemException {

		ShoppingOrder order =
			shoppingOrderPersistence.findByPrimaryKey(orderId);

		ShoppingPreferences shoppingPrefs =
			ShoppingPreferences.getInstance(
				order.getCompanyId(), order.getGroupId());

		validate(
			shoppingPrefs, billingFirstName, billingLastName,
			billingEmailAddress, billingStreet, billingCity, billingState,
			billingZip, billingCountry, billingPhone, shipToBilling,
			shippingFirstName, shippingLastName, shippingEmailAddress,
			shippingStreet, shippingCity, shippingState, shippingZip,
			shippingCountry, shippingPhone, ccName, ccType, ccNumber,
			ccExpMonth, ccExpYear, ccVerNumber);

		order.setModifiedDate(new Date());
		order.setBillingFirstName(billingFirstName);
		order.setBillingLastName(billingLastName);
		order.setBillingEmailAddress(billingEmailAddress);
		order.setBillingCompany(billingCompany);
		order.setBillingStreet(billingStreet);
		order.setBillingCity(billingCity);
		order.setBillingState(billingState);
		order.setBillingZip(billingZip);
		order.setBillingCountry(billingCountry);
		order.setBillingPhone(billingPhone);
		order.setShipToBilling(shipToBilling);

		if (shipToBilling) {
			order.setShippingFirstName(billingFirstName);
			order.setShippingLastName(billingLastName);
			order.setShippingEmailAddress(billingEmailAddress);
			order.setShippingCompany(billingCompany);
			order.setShippingStreet(billingStreet);
			order.setShippingCity(billingCity);
			order.setShippingState(billingState);
			order.setShippingZip(billingZip);
			order.setShippingCountry(billingCountry);
			order.setShippingPhone(billingPhone);
		}
		else {
			order.setShippingFirstName(shippingFirstName);
			order.setShippingLastName(shippingLastName);
			order.setShippingEmailAddress(shippingEmailAddress);
			order.setShippingCompany(shippingCompany);
			order.setShippingStreet(shippingStreet);
			order.setShippingCity(shippingCity);
			order.setShippingState(shippingState);
			order.setShippingZip(shippingZip);
			order.setShippingCountry(shippingCountry);
			order.setShippingPhone(shippingPhone);
		}

		order.setCcName(ccName);
		order.setCcType(ccType);
		order.setCcNumber(ccNumber);
		order.setCcExpMonth(ccExpMonth);
		order.setCcExpYear(ccExpYear);
		order.setCcVerNumber(ccVerNumber);
		order.setComments(comments);

		shoppingOrderPersistence.update(order, false);

		return order;
	}

	protected void doSendEmail(ShoppingOrder order, String emailType)
		throws IOException, PortalException, SystemException {

		ShoppingPreferences shoppingPrefs =
			ShoppingPreferences.getInstance(
				order.getCompanyId(), order.getGroupId());

		if (emailType.equals("confirmation") &&
			shoppingPrefs.getEmailOrderConfirmationEnabled()) {
		}
		else if (emailType.equals("shipping") &&
			shoppingPrefs.getEmailOrderShippingEnabled()) {
		}
		else {
			return;
		}

		Company company =
			companyPersistence.findByPrimaryKey(order.getCompanyId());

		User user = userPersistence.findByPrimaryKey(order.getUserId());

		Currency currency = Currency.getInstance(shoppingPrefs.getCurrencyId());

		String billingAddress =
			order.getBillingFirstName() + " " + order.getBillingLastName() +
				"<br>" + order.getBillingEmailAddress() + "<br>" +
				order.getBillingStreet() + "<br>" + order.getBillingCity() +
				"<br>" + order.getBillingState() + "<br>" +
				order.getBillingZip() + "<br>" + order.getBillingCountry() +
				"<br>" + order.getBillingPhone() + "<br>";

		String shippingAddress =
			order.getShippingFirstName() + " " + order.getShippingLastName() +
				"<br>" + order.getShippingEmailAddress() + "<br>" +
				order.getShippingStreet() + "<br>" + order.getShippingCity() +
				"<br>" + order.getShippingState() + "<br>" +
				order.getShippingZip() + "<br>" + order.getShippingCountry() +
				"<br>" + order.getShippingPhone() + "<br>";

		double total = ShoppingUtil.calculateTotal(order);

		String portletName =
			PortalUtil.getPortletTitle(PortletKeys.SHOPPING, user);

		String fromName = shoppingPrefs.getEmailFromName();
		String fromAddress = shoppingPrefs.getEmailFromAddress();

		String toName = user.getFullName();
		String toAddress = user.getEmailAddress();

		String subject = null;
		String body = null;

		if (emailType.equals("confirmation")) {
			subject = shoppingPrefs.getEmailOrderConfirmationSubject();
			body = shoppingPrefs.getEmailOrderConfirmationBody();
		}
		else if (emailType.equals("shipping")) {
			subject = shoppingPrefs.getEmailOrderShippingSubject();
			body = shoppingPrefs.getEmailOrderShippingBody();
		}

		subject =
			StringUtil.replace(subject, new String[] {
				"[$FROM_ADDRESS$]", "[$FROM_NAME$]",
				"[$ORDER_BILLING_ADDRESS$]", "[$ORDER_CURRENCY$]",
				"[$ORDER_NUMBER$]", "[$ORDER_SHIPPING_ADDRESS$]",
				"[$ORDER_TOTAL$]", "[$PORTAL_URL$]", "[$PORTLET_NAME$]",
				"[$TO_ADDRESS$]", "[$TO_NAME$]"
			}, new String[] {
				fromAddress, fromName, billingAddress, currency.getSymbol(),
				order.getNumber(), shippingAddress, String.valueOf(total),
				company.getVirtualHost(), portletName, toAddress, toName
			});

		body =
			StringUtil.replace(body, new String[] {
				"[$FROM_ADDRESS$]", "[$FROM_NAME$]",
				"[$ORDER_BILLING_ADDRESS$]", "[$ORDER_CURRENCY$]",
				"[$ORDER_NUMBER$]", "[$ORDER_SHIPPING_ADDRESS$]",
				"[$ORDER_TOTAL$]", "[$PORTAL_URL$]", "[$PORTLET_NAME$]",
				"[$TO_ADDRESS$]", "[$TO_NAME$]"
			}, new String[] {
				fromAddress, fromName, billingAddress, currency.getSymbol(),
				order.getNumber(), shippingAddress, String.valueOf(total),
				company.getVirtualHost(), portletName, toAddress, toName
			});

		InternetAddress from = new InternetAddress(fromAddress, fromName);

		InternetAddress to = new InternetAddress(toAddress, toName);

		MailMessage message = new MailMessage(from, to, subject, body, true);

		mailService.sendEmail(message);

		if (emailType.equals("confirmation") && order.isSendOrderEmail()) {
			order.setSendOrderEmail(false);

			shoppingOrderPersistence.update(order, false);
		}
		else if (emailType.equals("shipping") && order.isSendShippingEmail()) {

			order.setSendShippingEmail(false);

			shoppingOrderPersistence.update(order, false);
		}
	}

	protected String getNumber()
		throws SystemException {

		String number =
			PwdGenerator.getPassword(PwdGenerator.KEY1 + PwdGenerator.KEY2, 12);

		try {
			shoppingOrderPersistence.findByNumber(number);

			return getNumber();
		}
		catch (NoSuchOrderException nsoe) {
			return number;
		}
	}

	protected void validate(
		ShoppingPreferences shoppingPrefs, String billingFirstName,
		String billingLastName, String billingEmailAddress,
		String billingStreet, String billingCity, String billingState,
		String billingZip, String billingCountry, String billingPhone,
		boolean shipToBilling, String shippingFirstName,
		String shippingLastName, String shippingEmailAddress,
		String shippingStreet, String shippingCity, String shippingState,
		String shippingZip, String shippingCountry, String shippingPhone,
		String ccName, String ccType, String ccNumber, int ccExpMonth,
		int ccExpYear, String ccVerNumber)
		throws PortalException {

		if (Validator.isNull(billingFirstName)) {
			throw new BillingFirstNameException();
		}
		else if (Validator.isNull(billingLastName)) {
			throw new BillingLastNameException();
		}
		else if (!Validator.isEmailAddress(billingEmailAddress)) {
			throw new BillingEmailAddressException();
		}
		else if (Validator.isNull(billingStreet)) {
			throw new BillingStreetException();
		}
		else if (Validator.isNull(billingCity)) {
			throw new BillingCityException();
		}
		else if (Validator.isNull(billingState)) {
			throw new BillingStateException();
		}
		else if (Validator.isNull(billingZip)) {
			throw new BillingZipException();
		}
		else if (Validator.isNull(billingCountry)) {
			throw new BillingCountryException();
		}
		else if (Validator.isNull(billingPhone)) {
			throw new BillingPhoneException();
		}

		if (!shipToBilling) {
			if (Validator.isNull(shippingFirstName)) {
				throw new ShippingFirstNameException();
			}
			else if (Validator.isNull(shippingLastName)) {
				throw new ShippingLastNameException();
			}
			else if (!Validator.isEmailAddress(shippingEmailAddress)) {
				throw new ShippingEmailAddressException();
			}
			else if (Validator.isNull(shippingStreet)) {
				throw new ShippingStreetException();
			}
			else if (Validator.isNull(shippingCity)) {
				throw new ShippingCityException();
			}
			else if (Validator.isNull(shippingState)) {
				throw new ShippingStateException();
			}
			else if (Validator.isNull(shippingZip)) {
				throw new ShippingZipException();
			}
			else if (Validator.isNull(shippingCountry)) {
				throw new ShippingCountryException();
			}
			else if (Validator.isNull(shippingPhone)) {
				throw new ShippingPhoneException();
			}
		}

		if ((!shoppingPrefs.useGoogleCheckout()) &&
			(!shoppingPrefs.usePayPal()) &&
			(shoppingPrefs.getCcTypes().length > 0)) {

			if (Validator.isNull(ccName)) {
				throw new CCNameException();
			}
			else if (Validator.isNull(ccType)) {
				throw new CCTypeException();
			}
			else if (!CreditCard.isValid(ccNumber, ccType)) {
				throw new CCNumberException();
			}
			else if (!CalendarUtil.isFuture(ccExpMonth, ccExpYear)) {
				throw new CCExpirationException();
			}
		}
	}

	private static Log _log =
		LogFactoryUtil.getLog(ShoppingOrderLocalServiceImpl.class);
}
