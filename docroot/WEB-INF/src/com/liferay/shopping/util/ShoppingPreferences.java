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

package com.liferay.shopping.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.util.portlet.PortletProps;
// import com.liferay.portal.util.PropsUtil;
// import com.liferay.util.ContentUtil;

import java.io.IOException;

import java.util.Currency;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ValidatorException;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingPreferences {

	public static final String CC_NONE = "none";

	public static final String[] CC_TYPES = new String[] {
		"visa", "mastercard", "discover", "amex"
	};

	public static final String[] CURRENCY_IDS;

	static {
		String[] ids = null;

		try {
			Set<String> set = new TreeSet<String>();

			Locale[] locales = Locale.getAvailableLocales();

			for (int i = 0; i < locales.length; i++) {
				Locale locale = locales[i];

				if (locale.getCountry().length() == 2) {
					Currency currency = Currency.getInstance(locale);

					String currencyId = currency.getCurrencyCode();

					set.add(currencyId);
				}
			}

			ids = set.toArray(new String[set.size()]);
		}
		catch (Exception e) {
			ids = new String[] {
				"USD", "CAD", "EUR", "GBP", "JPY"
			};
		}
		finally {
			CURRENCY_IDS = ids;
		}
	}

	public static final double[] SHIPPING_RANGE = {
		0.01, 9.99, 10.00, 49.99, 50.00, 99.99, 100.00, 199.99, 200.00,
		Double.POSITIVE_INFINITY
	};

	public static final double[] INSURANCE_RANGE = {
		0.01, 9.99, 10.00, 49.99, 50.00, 99.99, 100.00, 199.99, 200.00,
		Double.POSITIVE_INFINITY
	};

	public static ShoppingPreferences getInstance(long companyId, long groupId)
		throws SystemException {

		return new ShoppingPreferences(companyId, groupId);
	}

	public String getPayPalEmailAddress() {

		return _portletPreferences.getValue(
			"paypalEmailAddress", StringPool.BLANK);
	}

	public void setPayPalEmailAddress(String payPalEmailAddress)
		throws ReadOnlyException {

		_portletPreferences.setValue(
				"paypalEmailAddress", payPalEmailAddress);
	}

	public boolean usePayPal() {

		return Validator.isNotNull(getPayPalEmailAddress());
	}

	public String getGoogleCheckoutMerchantId() {

		return _portletPreferences.getValue(
				"GCMerchantId", StringPool.BLANK);
	}

	public void setGoogleCheckoutMerchantId(String GCMerchantId)
		throws ReadOnlyException {

		_portletPreferences.setValue(
				"GCMerchantId", GCMerchantId);

	}
	
	
	public String getGoogleCheckoutAuthorizationKey() {

		return _portletPreferences.getValue(
				"GCAuthorizationKey", StringPool.BLANK);
	}

	public void setGoogleCheckoutAuthorizationKey(String GCAuthorizationKey)
		throws ReadOnlyException {

		_portletPreferences.setValue(
				"GCAuthorizationKey", GCAuthorizationKey);

	}
	

	public boolean useGoogleCheckout() {

		return Validator.isNotNull(
				getGoogleCheckoutMerchantId());
	}

	public String getCurrencyId() {

		return _portletPreferences.getValue("currencyId", "USD");
	}

	public void setCurrencyId(String currencyId)
		throws ReadOnlyException {

		_portletPreferences.setValue("currencyId", currencyId);
	}

	public String[] getCcTypes() {

		String ccTypes =
			_portletPreferences.getValue("ccTypes", StringUtil.merge(CC_TYPES));

		if (ccTypes.equals(CC_NONE)) {
			return new String[0];
		}
		else {
			return StringUtil.split(ccTypes);
		}
	}

	public void setCcTypes(String[] ccTypes)
		throws ReadOnlyException {

		if (ccTypes.length == 0) {
			_portletPreferences.setValue("ccTypes", CC_NONE);
		}
		else {
			_portletPreferences.setValue("ccTypes", StringUtil.merge(ccTypes));
		}
	}

	public String getTaxState() {

		return _portletPreferences.getValue("taxState", "CA");
	}

	public void setTaxState(String taxState)
		throws ReadOnlyException {

		_portletPreferences.setValue("taxState", taxState);
	}

	public double getTaxRate() {

		return GetterUtil.getDouble(_portletPreferences.getValue(
			"taxRate", StringPool.BLANK));
	}

	public void setTaxRate(double taxRate)
		throws ReadOnlyException {

		_portletPreferences.setValue("taxRate", String.valueOf(taxRate));
	}

	public String getShippingFormula() {

		return _portletPreferences.getValue("shippingFormula", "flat");
	}

	public void setShippingFormula(String shippingFormula)
		throws ReadOnlyException {

		_portletPreferences.setValue("shippingFormula", shippingFormula);
	}

	public String[] getShipping() {

		String value = _portletPreferences.getValue("shipping", null);

		if (value == null) {
			return new String[5];
		}
		else {
			return StringUtil.split(value);
		}
	}

	public void setShipping(String[] shipping)
		throws ReadOnlyException {

		_portletPreferences.setValue("shipping", StringUtil.merge(shipping));
	}

	public String[][] getAlternativeShipping() {

		String value =
			_portletPreferences.getValue("alternativeShipping", null);

		if (value == null) {
			return new String[0][0];
		}
		else {
			String[] array =
				StringUtil.split("alternativeShipping", "[$_ARRAY_$]");

			String[][] alternativeShipping = new String[array.length][0];

			for (int i = 0; i < array.length; i++) {
				alternativeShipping[i] = StringUtil.split(array[i]);
			}

			return alternativeShipping;
		}
	}

	public void setAlternativeShipping(String[][] alternativeShipping)
		throws ReadOnlyException {

		if (alternativeShipping.length == 0) {
			_portletPreferences.setValue(
				"alternativeShipping", StringPool.BLANK);
		}

		StringBundler sb =
			new StringBundler(alternativeShipping.length * 2 - 1);

		for (int i = 0; i < alternativeShipping.length; i++) {
			sb.append(StringUtil.merge(alternativeShipping[i]));

			if ((i + 1) < alternativeShipping.length) {
				sb.append("[$_ARRAY_$]");
			}
		}

		_portletPreferences.setValue("alternativeShipping", sb.toString());
	}

	public boolean useAlternativeShipping() {

		String[][] alternativeShipping = getAlternativeShipping();

		try {
			for (int i = 0; i < 10; i++) {
				if (Validator.isNotNull(alternativeShipping[0][i]) &&
					Validator.isNotNull(alternativeShipping[1][i])) {

					return true;
				}
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	public String getAlternativeShippingName(int altShipping) {

		String altShippingName = StringPool.BLANK;

		try {
			altShippingName = getAlternativeShipping()[0][altShipping];
		}
		catch (Exception e) {
		}

		return altShippingName;
	}

	public String getInsuranceFormula() {

		return _portletPreferences.getValue("insuranceFormula", "flat");
	}

	public void setInsuranceFormula(String insuranceFormula)
		throws ReadOnlyException {

		_portletPreferences.setValue("insuranceFormula", insuranceFormula);
	}

	public String[] getInsurance() {

		String value = _portletPreferences.getValue("insurance", null);

		if (value == null) {
			return new String[5];
		}
		else {
			return StringUtil.split(value);
		}
	}

	public void setInsurance(String[] insurance)
		throws ReadOnlyException {

		_portletPreferences.setValue("insurance", StringUtil.merge(insurance));
	}

	public double getMinOrder() {

		return GetterUtil.getDouble(_portletPreferences.getValue(
			"min-order", StringPool.BLANK));
	}

	public void setMinOrder(double minOrder)
		throws ReadOnlyException {

		_portletPreferences.setValue("min-order", String.valueOf(minOrder));
	}

	public String getEmailFromAddress() {

		String emailFromAddress =
			PropsUtil.get(PropsKeys.SHOPPING_EMAIL_FROM_ADDRESS);

		return _portletPreferences.getValue(
			"emailFromAddress", emailFromAddress);
	}

	public void setEmailFromAddress(String emailFromAddress)
		throws ReadOnlyException {

		_portletPreferences.setValue("emailFromAddress", emailFromAddress);
	}

	public String getEmailFromName() {

		String emailFromName =
			PropsUtil.get(PropsKeys.SHOPPING_EMAIL_FROM_NAME);

		return _portletPreferences.getValue("emailFromName", emailFromName);
	}

	public void setEmailFromName(String emailFromName)
		throws ReadOnlyException {

		_portletPreferences.setValue("emailFromName", emailFromName);
	}

	public boolean getEmailOrderConfirmationEnabled() {

		String emailOrderConfirmationEnabled =
			_portletPreferences.getValue(
				"emailOrderConfirmationEnabled", StringPool.BLANK);

		if (Validator.isNotNull(emailOrderConfirmationEnabled)) {
			return GetterUtil.getBoolean(emailOrderConfirmationEnabled);
		}
		else {
			return GetterUtil.getBoolean(PropsUtil.get(PropsKeys.SHOPPING_EMAIL_ORDER_CONFIRMATION_ENABLED));
		}
	}

	public void setEmailOrderConfirmationEnabled(
		boolean emailOrderConfirmationEnabled)
		throws ReadOnlyException {

		_portletPreferences.setValue(
			"emailOrderConfirmationEnabled",
			String.valueOf(emailOrderConfirmationEnabled));
	}

	public String getEmailOrderConfirmationBody() {

		String emailOrderConfirmationBody =
			PortletProps.get(PortletPropsKeys.SHOPPING_EMAIL_ORDER_CONFIRMATION_BODY);

		_log.error(PortletPropsKeys.SHOPPING_EMAIL_ORDER_CONFIRMATION_BODY +
			" " + emailOrderConfirmationBody);

		if (Validator.isNotNull(emailOrderConfirmationBody)) {
			return ContentUtil.get(emailOrderConfirmationBody);
		}
		else {
			return ContentUtil.get(PropsUtil.get(PropsKeys.SHOPPING_EMAIL_ORDER_CONFIRMATION_BODY));
		}
	}

	public void setEmailOrderConfirmationBody(String emailOrderConfirmationBody)
		throws ReadOnlyException {

		_portletPreferences.setValue(
			"emailOrderConfirmationBody", emailOrderConfirmationBody);
	}

	public String getEmailOrderConfirmationSubject() {

		String emailOrderConfirmationSubject =
			PortletProps.get(PortletPropsKeys.SHOPPING_EMAIL_ORDER_CONFIRMATION_SUBJECT);

		_log.error(PortletPropsKeys.SHOPPING_EMAIL_ORDER_CONFIRMATION_SUBJECT +
			" " + emailOrderConfirmationSubject);

		if (Validator.isNotNull(emailOrderConfirmationSubject)) {
			return ContentUtil.get(emailOrderConfirmationSubject);
		}
		else {
			return ContentUtil.get(PropsUtil.get(PropsKeys.SHOPPING_EMAIL_ORDER_CONFIRMATION_SUBJECT));
		}
	}

	public void setEmailOrderConfirmationSubject(
		String emailOrderConfirmationSubject)
		throws ReadOnlyException {

		_portletPreferences.setValue(
			"emailOrderConfirmationSubject", emailOrderConfirmationSubject);
	}

	public boolean getEmailOrderShippingEnabled() {

		// String emailOrderShippingEnabled = _portletPreferences.getValue(
		// "emailOrderShippingEnabled", StringPool.BLANK);
		String emailOrderShippingEnabled =
			PortletProps.get(PortletPropsKeys.SHOPPING_EMAIL_ORDER_SHIPPING_ENABLED);

		if (Validator.isNotNull(emailOrderShippingEnabled)) {
			return GetterUtil.getBoolean(emailOrderShippingEnabled);
		}
		else {
			return GetterUtil.getBoolean(PropsUtil.get(PropsKeys.SHOPPING_EMAIL_ORDER_SHIPPING_ENABLED));
		}
	}

	public void setEmailOrderShippingEnabled(boolean emailOrderShippingEnabled)
		throws ReadOnlyException {

		_portletPreferences.setValue(
			"emailOrderShippingEnabled",
			String.valueOf(emailOrderShippingEnabled));
	}

	public String getEmailOrderShippingBody() {

		// String emailOrderShippingBody = _portletPreferences.getValue(
		// "emailOrderShippingBody", StringPool.BLANK);
		String emailOrderShippingBody =
			PortletProps.get(PortletPropsKeys.SHOPPING_EMAIL_ORDER_SHIPPING_BODY);

		if (Validator.isNotNull(emailOrderShippingBody)) {
			return ContentUtil.get(emailOrderShippingBody);
		}
		else {
			return ContentUtil.get(PropsUtil.get(PropsKeys.SHOPPING_EMAIL_ORDER_SHIPPING_BODY));
		}
	}

	public void setEmailOrderShippingBody(String emailOrderShippingBody)
		throws ReadOnlyException {

		_portletPreferences.setValue(
			"emailOrderShippingBody", emailOrderShippingBody);
	}

	public String getEmailOrderShippingSubject() {

		// String emailOrderShippingSubject = _portletPreferences.getValue(
		// "emailOrderShippingSubject", StringPool.BLANK);
		String emailOrderShippingSubject =
			PortletProps.get(PortletPropsKeys.SHOPPING_EMAIL_ORDER_SHIPPING_SUBJECT);

		if (Validator.isNotNull(emailOrderShippingSubject)) {
			return ContentUtil.get(emailOrderShippingSubject);
		}
		else {
			return ContentUtil.get(PropsUtil.get(PropsKeys.SHOPPING_EMAIL_ORDER_SHIPPING_SUBJECT));
		}
	}

	public void setEmailOrderShippingSubject(String emailOrderShippingSubject)
		throws ReadOnlyException {

		_portletPreferences.setValue(
			"emailOrderShippingSubject", emailOrderShippingSubject);
	}

	public void store()
		throws IOException, ValidatorException {

		_portletPreferences.store();
	}

	protected ShoppingPreferences(long companyId, long groupId)
		throws SystemException {

		long ownerId = groupId;
		int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
		long plid = PortletKeys.PREFS_PLID_SHARED;
		String portletId = PortletKeys.SHOPPING;

		_portletPreferences =
			PortletPreferencesLocalServiceUtil.getPreferences(
				companyId, ownerId, ownerType, plid, portletId);
	}

	private PortletPreferences _portletPreferences;

	private static Log _log = LogFactoryUtil.getLog(ShoppingPreferences.class);
}
