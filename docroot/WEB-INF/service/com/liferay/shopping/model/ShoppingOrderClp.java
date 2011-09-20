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

package com.liferay.shopping.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.liferay.shopping.service.ShoppingOrderLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingOrderClp extends BaseModelImpl<ShoppingOrder>
	implements ShoppingOrder {
	public ShoppingOrderClp() {
	}

	public Class<?> getModelClass() {
		return ShoppingOrder.class;
	}

	public String getModelClassName() {
		return ShoppingOrder.class.getName();
	}

	public long getPrimaryKey() {
		return _orderId;
	}

	public void setPrimaryKey(long primaryKey) {
		setOrderId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_orderId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getOrderId() {
		return _orderId;
	}

	public void setOrderId(long orderId) {
		_orderId = orderId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
	}

	public double getTax() {
		return _tax;
	}

	public void setTax(double tax) {
		_tax = tax;
	}

	public double getShipping() {
		return _shipping;
	}

	public void setShipping(double shipping) {
		_shipping = shipping;
	}

	public String getAltShipping() {
		return _altShipping;
	}

	public void setAltShipping(String altShipping) {
		_altShipping = altShipping;
	}

	public boolean getRequiresShipping() {
		return _requiresShipping;
	}

	public boolean isRequiresShipping() {
		return _requiresShipping;
	}

	public void setRequiresShipping(boolean requiresShipping) {
		_requiresShipping = requiresShipping;
	}

	public boolean getInsure() {
		return _insure;
	}

	public boolean isInsure() {
		return _insure;
	}

	public void setInsure(boolean insure) {
		_insure = insure;
	}

	public double getInsurance() {
		return _insurance;
	}

	public void setInsurance(double insurance) {
		_insurance = insurance;
	}

	public String getCouponCodes() {
		return _couponCodes;
	}

	public void setCouponCodes(String couponCodes) {
		_couponCodes = couponCodes;
	}

	public double getCouponDiscount() {
		return _couponDiscount;
	}

	public void setCouponDiscount(double couponDiscount) {
		_couponDiscount = couponDiscount;
	}

	public String getBillingFirstName() {
		return _billingFirstName;
	}

	public void setBillingFirstName(String billingFirstName) {
		_billingFirstName = billingFirstName;
	}

	public String getBillingLastName() {
		return _billingLastName;
	}

	public void setBillingLastName(String billingLastName) {
		_billingLastName = billingLastName;
	}

	public String getBillingEmailAddress() {
		return _billingEmailAddress;
	}

	public void setBillingEmailAddress(String billingEmailAddress) {
		_billingEmailAddress = billingEmailAddress;
	}

	public String getBillingCompany() {
		return _billingCompany;
	}

	public void setBillingCompany(String billingCompany) {
		_billingCompany = billingCompany;
	}

	public String getBillingStreet() {
		return _billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		_billingStreet = billingStreet;
	}

	public String getBillingCity() {
		return _billingCity;
	}

	public void setBillingCity(String billingCity) {
		_billingCity = billingCity;
	}

	public String getBillingState() {
		return _billingState;
	}

	public void setBillingState(String billingState) {
		_billingState = billingState;
	}

	public String getBillingZip() {
		return _billingZip;
	}

	public void setBillingZip(String billingZip) {
		_billingZip = billingZip;
	}

	public String getBillingCountry() {
		return _billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		_billingCountry = billingCountry;
	}

	public String getBillingPhone() {
		return _billingPhone;
	}

	public void setBillingPhone(String billingPhone) {
		_billingPhone = billingPhone;
	}

	public boolean getShipToBilling() {
		return _shipToBilling;
	}

	public boolean isShipToBilling() {
		return _shipToBilling;
	}

	public void setShipToBilling(boolean shipToBilling) {
		_shipToBilling = shipToBilling;
	}

	public String getShippingFirstName() {
		return _shippingFirstName;
	}

	public void setShippingFirstName(String shippingFirstName) {
		_shippingFirstName = shippingFirstName;
	}

	public String getShippingLastName() {
		return _shippingLastName;
	}

	public void setShippingLastName(String shippingLastName) {
		_shippingLastName = shippingLastName;
	}

	public String getShippingEmailAddress() {
		return _shippingEmailAddress;
	}

	public void setShippingEmailAddress(String shippingEmailAddress) {
		_shippingEmailAddress = shippingEmailAddress;
	}

	public String getShippingCompany() {
		return _shippingCompany;
	}

	public void setShippingCompany(String shippingCompany) {
		_shippingCompany = shippingCompany;
	}

	public String getShippingStreet() {
		return _shippingStreet;
	}

	public void setShippingStreet(String shippingStreet) {
		_shippingStreet = shippingStreet;
	}

	public String getShippingCity() {
		return _shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		_shippingCity = shippingCity;
	}

	public String getShippingState() {
		return _shippingState;
	}

	public void setShippingState(String shippingState) {
		_shippingState = shippingState;
	}

	public String getShippingZip() {
		return _shippingZip;
	}

	public void setShippingZip(String shippingZip) {
		_shippingZip = shippingZip;
	}

	public String getShippingCountry() {
		return _shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		_shippingCountry = shippingCountry;
	}

	public String getShippingPhone() {
		return _shippingPhone;
	}

	public void setShippingPhone(String shippingPhone) {
		_shippingPhone = shippingPhone;
	}

	public String getCcName() {
		return _ccName;
	}

	public void setCcName(String ccName) {
		_ccName = ccName;
	}

	public String getCcType() {
		return _ccType;
	}

	public void setCcType(String ccType) {
		_ccType = ccType;
	}

	public String getCcNumber() {
		return _ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		_ccNumber = ccNumber;
	}

	public int getCcExpMonth() {
		return _ccExpMonth;
	}

	public void setCcExpMonth(int ccExpMonth) {
		_ccExpMonth = ccExpMonth;
	}

	public int getCcExpYear() {
		return _ccExpYear;
	}

	public void setCcExpYear(int ccExpYear) {
		_ccExpYear = ccExpYear;
	}

	public String getCcVerNumber() {
		return _ccVerNumber;
	}

	public void setCcVerNumber(String ccVerNumber) {
		_ccVerNumber = ccVerNumber;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	public String getPpTxnId() {
		return _ppTxnId;
	}

	public void setPpTxnId(String ppTxnId) {
		_ppTxnId = ppTxnId;
	}

	public String getPpPaymentStatus() {
		return _ppPaymentStatus;
	}

	public void setPpPaymentStatus(String ppPaymentStatus) {
		_ppPaymentStatus = ppPaymentStatus;
	}

	public double getPpPaymentGross() {
		return _ppPaymentGross;
	}

	public void setPpPaymentGross(double ppPaymentGross) {
		_ppPaymentGross = ppPaymentGross;
	}

	public String getPpReceiverEmail() {
		return _ppReceiverEmail;
	}

	public void setPpReceiverEmail(String ppReceiverEmail) {
		_ppReceiverEmail = ppReceiverEmail;
	}

	public String getPpPayerEmail() {
		return _ppPayerEmail;
	}

	public void setPpPayerEmail(String ppPayerEmail) {
		_ppPayerEmail = ppPayerEmail;
	}

	public boolean getSendOrderEmail() {
		return _sendOrderEmail;
	}

	public boolean isSendOrderEmail() {
		return _sendOrderEmail;
	}

	public void setSendOrderEmail(boolean sendOrderEmail) {
		_sendOrderEmail = sendOrderEmail;
	}

	public boolean getSendShippingEmail() {
		return _sendShippingEmail;
	}

	public boolean isSendShippingEmail() {
		return _sendShippingEmail;
	}

	public void setSendShippingEmail(boolean sendShippingEmail) {
		_sendShippingEmail = sendShippingEmail;
	}

	public void persist() throws SystemException {
		ShoppingOrderLocalServiceUtil.updateShoppingOrder(this);
	}

	@Override
	public ShoppingOrder toEscapedModel() {
		if (isEscapedModel()) {
			return this;
		}
		else {
			return (ShoppingOrder)Proxy.newProxyInstance(ShoppingOrder.class.getClassLoader(),
				new Class[] { ShoppingOrder.class },
				new AutoEscapeBeanHandler(this));
		}
	}

	@Override
	public Object clone() {
		ShoppingOrderClp clone = new ShoppingOrderClp();

		clone.setOrderId(getOrderId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setNumber(getNumber());
		clone.setTax(getTax());
		clone.setShipping(getShipping());
		clone.setAltShipping(getAltShipping());
		clone.setRequiresShipping(getRequiresShipping());
		clone.setInsure(getInsure());
		clone.setInsurance(getInsurance());
		clone.setCouponCodes(getCouponCodes());
		clone.setCouponDiscount(getCouponDiscount());
		clone.setBillingFirstName(getBillingFirstName());
		clone.setBillingLastName(getBillingLastName());
		clone.setBillingEmailAddress(getBillingEmailAddress());
		clone.setBillingCompany(getBillingCompany());
		clone.setBillingStreet(getBillingStreet());
		clone.setBillingCity(getBillingCity());
		clone.setBillingState(getBillingState());
		clone.setBillingZip(getBillingZip());
		clone.setBillingCountry(getBillingCountry());
		clone.setBillingPhone(getBillingPhone());
		clone.setShipToBilling(getShipToBilling());
		clone.setShippingFirstName(getShippingFirstName());
		clone.setShippingLastName(getShippingLastName());
		clone.setShippingEmailAddress(getShippingEmailAddress());
		clone.setShippingCompany(getShippingCompany());
		clone.setShippingStreet(getShippingStreet());
		clone.setShippingCity(getShippingCity());
		clone.setShippingState(getShippingState());
		clone.setShippingZip(getShippingZip());
		clone.setShippingCountry(getShippingCountry());
		clone.setShippingPhone(getShippingPhone());
		clone.setCcName(getCcName());
		clone.setCcType(getCcType());
		clone.setCcNumber(getCcNumber());
		clone.setCcExpMonth(getCcExpMonth());
		clone.setCcExpYear(getCcExpYear());
		clone.setCcVerNumber(getCcVerNumber());
		clone.setComments(getComments());
		clone.setPpTxnId(getPpTxnId());
		clone.setPpPaymentStatus(getPpPaymentStatus());
		clone.setPpPaymentGross(getPpPaymentGross());
		clone.setPpReceiverEmail(getPpReceiverEmail());
		clone.setPpPayerEmail(getPpPayerEmail());
		clone.setSendOrderEmail(getSendOrderEmail());
		clone.setSendShippingEmail(getSendShippingEmail());

		return clone;
	}

	public int compareTo(ShoppingOrder shoppingOrder) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				shoppingOrder.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ShoppingOrderClp shoppingOrder = null;

		try {
			shoppingOrder = (ShoppingOrderClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = shoppingOrder.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(103);

		sb.append("{orderId=");
		sb.append(getOrderId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", number=");
		sb.append(getNumber());
		sb.append(", tax=");
		sb.append(getTax());
		sb.append(", shipping=");
		sb.append(getShipping());
		sb.append(", altShipping=");
		sb.append(getAltShipping());
		sb.append(", requiresShipping=");
		sb.append(getRequiresShipping());
		sb.append(", insure=");
		sb.append(getInsure());
		sb.append(", insurance=");
		sb.append(getInsurance());
		sb.append(", couponCodes=");
		sb.append(getCouponCodes());
		sb.append(", couponDiscount=");
		sb.append(getCouponDiscount());
		sb.append(", billingFirstName=");
		sb.append(getBillingFirstName());
		sb.append(", billingLastName=");
		sb.append(getBillingLastName());
		sb.append(", billingEmailAddress=");
		sb.append(getBillingEmailAddress());
		sb.append(", billingCompany=");
		sb.append(getBillingCompany());
		sb.append(", billingStreet=");
		sb.append(getBillingStreet());
		sb.append(", billingCity=");
		sb.append(getBillingCity());
		sb.append(", billingState=");
		sb.append(getBillingState());
		sb.append(", billingZip=");
		sb.append(getBillingZip());
		sb.append(", billingCountry=");
		sb.append(getBillingCountry());
		sb.append(", billingPhone=");
		sb.append(getBillingPhone());
		sb.append(", shipToBilling=");
		sb.append(getShipToBilling());
		sb.append(", shippingFirstName=");
		sb.append(getShippingFirstName());
		sb.append(", shippingLastName=");
		sb.append(getShippingLastName());
		sb.append(", shippingEmailAddress=");
		sb.append(getShippingEmailAddress());
		sb.append(", shippingCompany=");
		sb.append(getShippingCompany());
		sb.append(", shippingStreet=");
		sb.append(getShippingStreet());
		sb.append(", shippingCity=");
		sb.append(getShippingCity());
		sb.append(", shippingState=");
		sb.append(getShippingState());
		sb.append(", shippingZip=");
		sb.append(getShippingZip());
		sb.append(", shippingCountry=");
		sb.append(getShippingCountry());
		sb.append(", shippingPhone=");
		sb.append(getShippingPhone());
		sb.append(", ccName=");
		sb.append(getCcName());
		sb.append(", ccType=");
		sb.append(getCcType());
		sb.append(", ccNumber=");
		sb.append(getCcNumber());
		sb.append(", ccExpMonth=");
		sb.append(getCcExpMonth());
		sb.append(", ccExpYear=");
		sb.append(getCcExpYear());
		sb.append(", ccVerNumber=");
		sb.append(getCcVerNumber());
		sb.append(", comments=");
		sb.append(getComments());
		sb.append(", ppTxnId=");
		sb.append(getPpTxnId());
		sb.append(", ppPaymentStatus=");
		sb.append(getPpPaymentStatus());
		sb.append(", ppPaymentGross=");
		sb.append(getPpPaymentGross());
		sb.append(", ppReceiverEmail=");
		sb.append(getPpReceiverEmail());
		sb.append(", ppPayerEmail=");
		sb.append(getPpPayerEmail());
		sb.append(", sendOrderEmail=");
		sb.append(getSendOrderEmail());
		sb.append(", sendShippingEmail=");
		sb.append(getSendShippingEmail());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(157);

		sb.append("<model><model-name>");
		sb.append("com.liferay.shopping.model.ShoppingOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orderId</column-name><column-value><![CDATA[");
		sb.append(getOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>number</column-name><column-value><![CDATA[");
		sb.append(getNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tax</column-name><column-value><![CDATA[");
		sb.append(getTax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipping</column-name><column-value><![CDATA[");
		sb.append(getShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>altShipping</column-name><column-value><![CDATA[");
		sb.append(getAltShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiresShipping</column-name><column-value><![CDATA[");
		sb.append(getRequiresShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insure</column-name><column-value><![CDATA[");
		sb.append(getInsure());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>insurance</column-name><column-value><![CDATA[");
		sb.append(getInsurance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>couponCodes</column-name><column-value><![CDATA[");
		sb.append(getCouponCodes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>couponDiscount</column-name><column-value><![CDATA[");
		sb.append(getCouponDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingFirstName</column-name><column-value><![CDATA[");
		sb.append(getBillingFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingLastName</column-name><column-value><![CDATA[");
		sb.append(getBillingLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getBillingEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingCompany</column-name><column-value><![CDATA[");
		sb.append(getBillingCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingStreet</column-name><column-value><![CDATA[");
		sb.append(getBillingStreet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingCity</column-name><column-value><![CDATA[");
		sb.append(getBillingCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingState</column-name><column-value><![CDATA[");
		sb.append(getBillingState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingZip</column-name><column-value><![CDATA[");
		sb.append(getBillingZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingCountry</column-name><column-value><![CDATA[");
		sb.append(getBillingCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingPhone</column-name><column-value><![CDATA[");
		sb.append(getBillingPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipToBilling</column-name><column-value><![CDATA[");
		sb.append(getShipToBilling());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingFirstName</column-name><column-value><![CDATA[");
		sb.append(getShippingFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingLastName</column-name><column-value><![CDATA[");
		sb.append(getShippingLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getShippingEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCompany</column-name><column-value><![CDATA[");
		sb.append(getShippingCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingStreet</column-name><column-value><![CDATA[");
		sb.append(getShippingStreet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCity</column-name><column-value><![CDATA[");
		sb.append(getShippingCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingState</column-name><column-value><![CDATA[");
		sb.append(getShippingState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingZip</column-name><column-value><![CDATA[");
		sb.append(getShippingZip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingCountry</column-name><column-value><![CDATA[");
		sb.append(getShippingCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shippingPhone</column-name><column-value><![CDATA[");
		sb.append(getShippingPhone());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccName</column-name><column-value><![CDATA[");
		sb.append(getCcName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccType</column-name><column-value><![CDATA[");
		sb.append(getCcType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccNumber</column-name><column-value><![CDATA[");
		sb.append(getCcNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccExpMonth</column-name><column-value><![CDATA[");
		sb.append(getCcExpMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccExpYear</column-name><column-value><![CDATA[");
		sb.append(getCcExpYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ccVerNumber</column-name><column-value><![CDATA[");
		sb.append(getCcVerNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comments</column-name><column-value><![CDATA[");
		sb.append(getComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppTxnId</column-name><column-value><![CDATA[");
		sb.append(getPpTxnId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppPaymentStatus</column-name><column-value><![CDATA[");
		sb.append(getPpPaymentStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppPaymentGross</column-name><column-value><![CDATA[");
		sb.append(getPpPaymentGross());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppReceiverEmail</column-name><column-value><![CDATA[");
		sb.append(getPpReceiverEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ppPayerEmail</column-name><column-value><![CDATA[");
		sb.append(getPpPayerEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendOrderEmail</column-name><column-value><![CDATA[");
		sb.append(getSendOrderEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sendShippingEmail</column-name><column-value><![CDATA[");
		sb.append(getSendShippingEmail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orderId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _number;
	private double _tax;
	private double _shipping;
	private String _altShipping;
	private boolean _requiresShipping;
	private boolean _insure;
	private double _insurance;
	private String _couponCodes;
	private double _couponDiscount;
	private String _billingFirstName;
	private String _billingLastName;
	private String _billingEmailAddress;
	private String _billingCompany;
	private String _billingStreet;
	private String _billingCity;
	private String _billingState;
	private String _billingZip;
	private String _billingCountry;
	private String _billingPhone;
	private boolean _shipToBilling;
	private String _shippingFirstName;
	private String _shippingLastName;
	private String _shippingEmailAddress;
	private String _shippingCompany;
	private String _shippingStreet;
	private String _shippingCity;
	private String _shippingState;
	private String _shippingZip;
	private String _shippingCountry;
	private String _shippingPhone;
	private String _ccName;
	private String _ccType;
	private String _ccNumber;
	private int _ccExpMonth;
	private int _ccExpYear;
	private String _ccVerNumber;
	private String _comments;
	private String _ppTxnId;
	private String _ppPaymentStatus;
	private double _ppPaymentGross;
	private String _ppReceiverEmail;
	private String _ppPayerEmail;
	private boolean _sendOrderEmail;
	private boolean _sendShippingEmail;
}