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

/**
 * <p>
 * This class is a wrapper for {@link ShoppingOrder}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       ShoppingOrder
 * @generated
 */
public class ShoppingOrderWrapper implements ShoppingOrder {
	public ShoppingOrderWrapper(ShoppingOrder shoppingOrder) {
		_shoppingOrder = shoppingOrder;
	}

	public long getPrimaryKey() {
		return _shoppingOrder.getPrimaryKey();
	}

	public void setPrimaryKey(long pk) {
		_shoppingOrder.setPrimaryKey(pk);
	}

	public long getOrderId() {
		return _shoppingOrder.getOrderId();
	}

	public void setOrderId(long orderId) {
		_shoppingOrder.setOrderId(orderId);
	}

	public long getGroupId() {
		return _shoppingOrder.getGroupId();
	}

	public void setGroupId(long groupId) {
		_shoppingOrder.setGroupId(groupId);
	}

	public long getCompanyId() {
		return _shoppingOrder.getCompanyId();
	}

	public void setCompanyId(long companyId) {
		_shoppingOrder.setCompanyId(companyId);
	}

	public long getUserId() {
		return _shoppingOrder.getUserId();
	}

	public void setUserId(long userId) {
		_shoppingOrder.setUserId(userId);
	}

	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrder.getUserUuid();
	}

	public void setUserUuid(java.lang.String userUuid) {
		_shoppingOrder.setUserUuid(userUuid);
	}

	public java.lang.String getUserName() {
		return _shoppingOrder.getUserName();
	}

	public void setUserName(java.lang.String userName) {
		_shoppingOrder.setUserName(userName);
	}

	public java.util.Date getCreateDate() {
		return _shoppingOrder.getCreateDate();
	}

	public void setCreateDate(java.util.Date createDate) {
		_shoppingOrder.setCreateDate(createDate);
	}

	public java.util.Date getModifiedDate() {
		return _shoppingOrder.getModifiedDate();
	}

	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingOrder.setModifiedDate(modifiedDate);
	}

	public java.lang.String getNumber() {
		return _shoppingOrder.getNumber();
	}

	public void setNumber(java.lang.String number) {
		_shoppingOrder.setNumber(number);
	}

	public double getTax() {
		return _shoppingOrder.getTax();
	}

	public void setTax(double tax) {
		_shoppingOrder.setTax(tax);
	}

	public double getShipping() {
		return _shoppingOrder.getShipping();
	}

	public void setShipping(double shipping) {
		_shoppingOrder.setShipping(shipping);
	}

	public java.lang.String getAltShipping() {
		return _shoppingOrder.getAltShipping();
	}

	public void setAltShipping(java.lang.String altShipping) {
		_shoppingOrder.setAltShipping(altShipping);
	}

	public boolean getRequiresShipping() {
		return _shoppingOrder.getRequiresShipping();
	}

	public boolean isRequiresShipping() {
		return _shoppingOrder.isRequiresShipping();
	}

	public void setRequiresShipping(boolean requiresShipping) {
		_shoppingOrder.setRequiresShipping(requiresShipping);
	}

	public boolean getInsure() {
		return _shoppingOrder.getInsure();
	}

	public boolean isInsure() {
		return _shoppingOrder.isInsure();
	}

	public void setInsure(boolean insure) {
		_shoppingOrder.setInsure(insure);
	}

	public double getInsurance() {
		return _shoppingOrder.getInsurance();
	}

	public void setInsurance(double insurance) {
		_shoppingOrder.setInsurance(insurance);
	}

	public java.lang.String getCouponCodes() {
		return _shoppingOrder.getCouponCodes();
	}

	public void setCouponCodes(java.lang.String couponCodes) {
		_shoppingOrder.setCouponCodes(couponCodes);
	}

	public double getCouponDiscount() {
		return _shoppingOrder.getCouponDiscount();
	}

	public void setCouponDiscount(double couponDiscount) {
		_shoppingOrder.setCouponDiscount(couponDiscount);
	}

	public java.lang.String getBillingFirstName() {
		return _shoppingOrder.getBillingFirstName();
	}

	public void setBillingFirstName(java.lang.String billingFirstName) {
		_shoppingOrder.setBillingFirstName(billingFirstName);
	}

	public java.lang.String getBillingLastName() {
		return _shoppingOrder.getBillingLastName();
	}

	public void setBillingLastName(java.lang.String billingLastName) {
		_shoppingOrder.setBillingLastName(billingLastName);
	}

	public java.lang.String getBillingEmailAddress() {
		return _shoppingOrder.getBillingEmailAddress();
	}

	public void setBillingEmailAddress(java.lang.String billingEmailAddress) {
		_shoppingOrder.setBillingEmailAddress(billingEmailAddress);
	}

	public java.lang.String getBillingCompany() {
		return _shoppingOrder.getBillingCompany();
	}

	public void setBillingCompany(java.lang.String billingCompany) {
		_shoppingOrder.setBillingCompany(billingCompany);
	}

	public java.lang.String getBillingStreet() {
		return _shoppingOrder.getBillingStreet();
	}

	public void setBillingStreet(java.lang.String billingStreet) {
		_shoppingOrder.setBillingStreet(billingStreet);
	}

	public java.lang.String getBillingCity() {
		return _shoppingOrder.getBillingCity();
	}

	public void setBillingCity(java.lang.String billingCity) {
		_shoppingOrder.setBillingCity(billingCity);
	}

	public java.lang.String getBillingState() {
		return _shoppingOrder.getBillingState();
	}

	public void setBillingState(java.lang.String billingState) {
		_shoppingOrder.setBillingState(billingState);
	}

	public java.lang.String getBillingZip() {
		return _shoppingOrder.getBillingZip();
	}

	public void setBillingZip(java.lang.String billingZip) {
		_shoppingOrder.setBillingZip(billingZip);
	}

	public java.lang.String getBillingCountry() {
		return _shoppingOrder.getBillingCountry();
	}

	public void setBillingCountry(java.lang.String billingCountry) {
		_shoppingOrder.setBillingCountry(billingCountry);
	}

	public java.lang.String getBillingPhone() {
		return _shoppingOrder.getBillingPhone();
	}

	public void setBillingPhone(java.lang.String billingPhone) {
		_shoppingOrder.setBillingPhone(billingPhone);
	}

	public boolean getShipToBilling() {
		return _shoppingOrder.getShipToBilling();
	}

	public boolean isShipToBilling() {
		return _shoppingOrder.isShipToBilling();
	}

	public void setShipToBilling(boolean shipToBilling) {
		_shoppingOrder.setShipToBilling(shipToBilling);
	}

	public java.lang.String getShippingFirstName() {
		return _shoppingOrder.getShippingFirstName();
	}

	public void setShippingFirstName(java.lang.String shippingFirstName) {
		_shoppingOrder.setShippingFirstName(shippingFirstName);
	}

	public java.lang.String getShippingLastName() {
		return _shoppingOrder.getShippingLastName();
	}

	public void setShippingLastName(java.lang.String shippingLastName) {
		_shoppingOrder.setShippingLastName(shippingLastName);
	}

	public java.lang.String getShippingEmailAddress() {
		return _shoppingOrder.getShippingEmailAddress();
	}

	public void setShippingEmailAddress(java.lang.String shippingEmailAddress) {
		_shoppingOrder.setShippingEmailAddress(shippingEmailAddress);
	}

	public java.lang.String getShippingCompany() {
		return _shoppingOrder.getShippingCompany();
	}

	public void setShippingCompany(java.lang.String shippingCompany) {
		_shoppingOrder.setShippingCompany(shippingCompany);
	}

	public java.lang.String getShippingStreet() {
		return _shoppingOrder.getShippingStreet();
	}

	public void setShippingStreet(java.lang.String shippingStreet) {
		_shoppingOrder.setShippingStreet(shippingStreet);
	}

	public java.lang.String getShippingCity() {
		return _shoppingOrder.getShippingCity();
	}

	public void setShippingCity(java.lang.String shippingCity) {
		_shoppingOrder.setShippingCity(shippingCity);
	}

	public java.lang.String getShippingState() {
		return _shoppingOrder.getShippingState();
	}

	public void setShippingState(java.lang.String shippingState) {
		_shoppingOrder.setShippingState(shippingState);
	}

	public java.lang.String getShippingZip() {
		return _shoppingOrder.getShippingZip();
	}

	public void setShippingZip(java.lang.String shippingZip) {
		_shoppingOrder.setShippingZip(shippingZip);
	}

	public java.lang.String getShippingCountry() {
		return _shoppingOrder.getShippingCountry();
	}

	public void setShippingCountry(java.lang.String shippingCountry) {
		_shoppingOrder.setShippingCountry(shippingCountry);
	}

	public java.lang.String getShippingPhone() {
		return _shoppingOrder.getShippingPhone();
	}

	public void setShippingPhone(java.lang.String shippingPhone) {
		_shoppingOrder.setShippingPhone(shippingPhone);
	}

	public java.lang.String getCcName() {
		return _shoppingOrder.getCcName();
	}

	public void setCcName(java.lang.String ccName) {
		_shoppingOrder.setCcName(ccName);
	}

	public java.lang.String getCcType() {
		return _shoppingOrder.getCcType();
	}

	public void setCcType(java.lang.String ccType) {
		_shoppingOrder.setCcType(ccType);
	}

	public java.lang.String getCcNumber() {
		return _shoppingOrder.getCcNumber();
	}

	public void setCcNumber(java.lang.String ccNumber) {
		_shoppingOrder.setCcNumber(ccNumber);
	}

	public int getCcExpMonth() {
		return _shoppingOrder.getCcExpMonth();
	}

	public void setCcExpMonth(int ccExpMonth) {
		_shoppingOrder.setCcExpMonth(ccExpMonth);
	}

	public int getCcExpYear() {
		return _shoppingOrder.getCcExpYear();
	}

	public void setCcExpYear(int ccExpYear) {
		_shoppingOrder.setCcExpYear(ccExpYear);
	}

	public java.lang.String getCcVerNumber() {
		return _shoppingOrder.getCcVerNumber();
	}

	public void setCcVerNumber(java.lang.String ccVerNumber) {
		_shoppingOrder.setCcVerNumber(ccVerNumber);
	}

	public java.lang.String getComments() {
		return _shoppingOrder.getComments();
	}

	public void setComments(java.lang.String comments) {
		_shoppingOrder.setComments(comments);
	}

	public java.lang.String getPpTxnId() {
		return _shoppingOrder.getPpTxnId();
	}

	public void setPpTxnId(java.lang.String ppTxnId) {
		_shoppingOrder.setPpTxnId(ppTxnId);
	}

	public java.lang.String getPpPaymentStatus() {
		return _shoppingOrder.getPpPaymentStatus();
	}

	public void setPpPaymentStatus(java.lang.String ppPaymentStatus) {
		_shoppingOrder.setPpPaymentStatus(ppPaymentStatus);
	}

	public double getPpPaymentGross() {
		return _shoppingOrder.getPpPaymentGross();
	}

	public void setPpPaymentGross(double ppPaymentGross) {
		_shoppingOrder.setPpPaymentGross(ppPaymentGross);
	}

	public java.lang.String getPpReceiverEmail() {
		return _shoppingOrder.getPpReceiverEmail();
	}

	public void setPpReceiverEmail(java.lang.String ppReceiverEmail) {
		_shoppingOrder.setPpReceiverEmail(ppReceiverEmail);
	}

	public java.lang.String getPpPayerEmail() {
		return _shoppingOrder.getPpPayerEmail();
	}

	public void setPpPayerEmail(java.lang.String ppPayerEmail) {
		_shoppingOrder.setPpPayerEmail(ppPayerEmail);
	}

	public boolean getSendOrderEmail() {
		return _shoppingOrder.getSendOrderEmail();
	}

	public boolean isSendOrderEmail() {
		return _shoppingOrder.isSendOrderEmail();
	}

	public void setSendOrderEmail(boolean sendOrderEmail) {
		_shoppingOrder.setSendOrderEmail(sendOrderEmail);
	}

	public boolean getSendShippingEmail() {
		return _shoppingOrder.getSendShippingEmail();
	}

	public boolean isSendShippingEmail() {
		return _shoppingOrder.isSendShippingEmail();
	}

	public void setSendShippingEmail(boolean sendShippingEmail) {
		_shoppingOrder.setSendShippingEmail(sendShippingEmail);
	}

	public com.liferay.shopping.model.ShoppingOrder toEscapedModel() {
		return _shoppingOrder.toEscapedModel();
	}

	public boolean isNew() {
		return _shoppingOrder.isNew();
	}

	public void setNew(boolean n) {
		_shoppingOrder.setNew(n);
	}

	public boolean isCachedModel() {
		return _shoppingOrder.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_shoppingOrder.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _shoppingOrder.isEscapedModel();
	}

	public void setEscapedModel(boolean escapedModel) {
		_shoppingOrder.setEscapedModel(escapedModel);
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _shoppingOrder.getPrimaryKeyObj();
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingOrder.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingOrder.setExpandoBridgeAttributes(serviceContext);
	}

	public java.lang.Object clone() {
		return _shoppingOrder.clone();
	}

	public int compareTo(com.liferay.shopping.model.ShoppingOrder shoppingOrder) {
		return _shoppingOrder.compareTo(shoppingOrder);
	}

	public int hashCode() {
		return _shoppingOrder.hashCode();
	}

	public java.lang.String toString() {
		return _shoppingOrder.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingOrder.toXmlString();
	}

	public ShoppingOrder getWrappedShoppingOrder() {
		return _shoppingOrder;
	}

	private ShoppingOrder _shoppingOrder;
}