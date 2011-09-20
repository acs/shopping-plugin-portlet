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

package com.liferay.portlet.shopping.model;

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

	public Class<?> getModelClass() {
		return ShoppingOrder.class;
	}

	public String getModelClassName() {
		return ShoppingOrder.class.getName();
	}

	/**
	* Returns the primary key of this shopping order.
	*
	* @return the primary key of this shopping order
	*/
	public long getPrimaryKey() {
		return _shoppingOrder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this shopping order.
	*
	* @param primaryKey the primary key of this shopping order
	*/
	public void setPrimaryKey(long primaryKey) {
		_shoppingOrder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the order ID of this shopping order.
	*
	* @return the order ID of this shopping order
	*/
	public long getOrderId() {
		return _shoppingOrder.getOrderId();
	}

	/**
	* Sets the order ID of this shopping order.
	*
	* @param orderId the order ID of this shopping order
	*/
	public void setOrderId(long orderId) {
		_shoppingOrder.setOrderId(orderId);
	}

	/**
	* Returns the group ID of this shopping order.
	*
	* @return the group ID of this shopping order
	*/
	public long getGroupId() {
		return _shoppingOrder.getGroupId();
	}

	/**
	* Sets the group ID of this shopping order.
	*
	* @param groupId the group ID of this shopping order
	*/
	public void setGroupId(long groupId) {
		_shoppingOrder.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this shopping order.
	*
	* @return the company ID of this shopping order
	*/
	public long getCompanyId() {
		return _shoppingOrder.getCompanyId();
	}

	/**
	* Sets the company ID of this shopping order.
	*
	* @param companyId the company ID of this shopping order
	*/
	public void setCompanyId(long companyId) {
		_shoppingOrder.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this shopping order.
	*
	* @return the user ID of this shopping order
	*/
	public long getUserId() {
		return _shoppingOrder.getUserId();
	}

	/**
	* Sets the user ID of this shopping order.
	*
	* @param userId the user ID of this shopping order
	*/
	public void setUserId(long userId) {
		_shoppingOrder.setUserId(userId);
	}

	/**
	* Returns the user uuid of this shopping order.
	*
	* @return the user uuid of this shopping order
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _shoppingOrder.getUserUuid();
	}

	/**
	* Sets the user uuid of this shopping order.
	*
	* @param userUuid the user uuid of this shopping order
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_shoppingOrder.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this shopping order.
	*
	* @return the user name of this shopping order
	*/
	public java.lang.String getUserName() {
		return _shoppingOrder.getUserName();
	}

	/**
	* Sets the user name of this shopping order.
	*
	* @param userName the user name of this shopping order
	*/
	public void setUserName(java.lang.String userName) {
		_shoppingOrder.setUserName(userName);
	}

	/**
	* Returns the create date of this shopping order.
	*
	* @return the create date of this shopping order
	*/
	public java.util.Date getCreateDate() {
		return _shoppingOrder.getCreateDate();
	}

	/**
	* Sets the create date of this shopping order.
	*
	* @param createDate the create date of this shopping order
	*/
	public void setCreateDate(java.util.Date createDate) {
		_shoppingOrder.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this shopping order.
	*
	* @return the modified date of this shopping order
	*/
	public java.util.Date getModifiedDate() {
		return _shoppingOrder.getModifiedDate();
	}

	/**
	* Sets the modified date of this shopping order.
	*
	* @param modifiedDate the modified date of this shopping order
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_shoppingOrder.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the number of this shopping order.
	*
	* @return the number of this shopping order
	*/
	public java.lang.String getNumber() {
		return _shoppingOrder.getNumber();
	}

	/**
	* Sets the number of this shopping order.
	*
	* @param number the number of this shopping order
	*/
	public void setNumber(java.lang.String number) {
		_shoppingOrder.setNumber(number);
	}

	/**
	* Returns the tax of this shopping order.
	*
	* @return the tax of this shopping order
	*/
	public double getTax() {
		return _shoppingOrder.getTax();
	}

	/**
	* Sets the tax of this shopping order.
	*
	* @param tax the tax of this shopping order
	*/
	public void setTax(double tax) {
		_shoppingOrder.setTax(tax);
	}

	/**
	* Returns the shipping of this shopping order.
	*
	* @return the shipping of this shopping order
	*/
	public double getShipping() {
		return _shoppingOrder.getShipping();
	}

	/**
	* Sets the shipping of this shopping order.
	*
	* @param shipping the shipping of this shopping order
	*/
	public void setShipping(double shipping) {
		_shoppingOrder.setShipping(shipping);
	}

	/**
	* Returns the alt shipping of this shopping order.
	*
	* @return the alt shipping of this shopping order
	*/
	public java.lang.String getAltShipping() {
		return _shoppingOrder.getAltShipping();
	}

	/**
	* Sets the alt shipping of this shopping order.
	*
	* @param altShipping the alt shipping of this shopping order
	*/
	public void setAltShipping(java.lang.String altShipping) {
		_shoppingOrder.setAltShipping(altShipping);
	}

	/**
	* Returns the requires shipping of this shopping order.
	*
	* @return the requires shipping of this shopping order
	*/
	public boolean getRequiresShipping() {
		return _shoppingOrder.getRequiresShipping();
	}

	/**
	* Returns <code>true</code> if this shopping order is requires shipping.
	*
	* @return <code>true</code> if this shopping order is requires shipping; <code>false</code> otherwise
	*/
	public boolean isRequiresShipping() {
		return _shoppingOrder.isRequiresShipping();
	}

	/**
	* Sets whether this shopping order is requires shipping.
	*
	* @param requiresShipping the requires shipping of this shopping order
	*/
	public void setRequiresShipping(boolean requiresShipping) {
		_shoppingOrder.setRequiresShipping(requiresShipping);
	}

	/**
	* Returns the insure of this shopping order.
	*
	* @return the insure of this shopping order
	*/
	public boolean getInsure() {
		return _shoppingOrder.getInsure();
	}

	/**
	* Returns <code>true</code> if this shopping order is insure.
	*
	* @return <code>true</code> if this shopping order is insure; <code>false</code> otherwise
	*/
	public boolean isInsure() {
		return _shoppingOrder.isInsure();
	}

	/**
	* Sets whether this shopping order is insure.
	*
	* @param insure the insure of this shopping order
	*/
	public void setInsure(boolean insure) {
		_shoppingOrder.setInsure(insure);
	}

	/**
	* Returns the insurance of this shopping order.
	*
	* @return the insurance of this shopping order
	*/
	public double getInsurance() {
		return _shoppingOrder.getInsurance();
	}

	/**
	* Sets the insurance of this shopping order.
	*
	* @param insurance the insurance of this shopping order
	*/
	public void setInsurance(double insurance) {
		_shoppingOrder.setInsurance(insurance);
	}

	/**
	* Returns the coupon codes of this shopping order.
	*
	* @return the coupon codes of this shopping order
	*/
	public java.lang.String getCouponCodes() {
		return _shoppingOrder.getCouponCodes();
	}

	/**
	* Sets the coupon codes of this shopping order.
	*
	* @param couponCodes the coupon codes of this shopping order
	*/
	public void setCouponCodes(java.lang.String couponCodes) {
		_shoppingOrder.setCouponCodes(couponCodes);
	}

	/**
	* Returns the coupon discount of this shopping order.
	*
	* @return the coupon discount of this shopping order
	*/
	public double getCouponDiscount() {
		return _shoppingOrder.getCouponDiscount();
	}

	/**
	* Sets the coupon discount of this shopping order.
	*
	* @param couponDiscount the coupon discount of this shopping order
	*/
	public void setCouponDiscount(double couponDiscount) {
		_shoppingOrder.setCouponDiscount(couponDiscount);
	}

	/**
	* Returns the billing first name of this shopping order.
	*
	* @return the billing first name of this shopping order
	*/
	public java.lang.String getBillingFirstName() {
		return _shoppingOrder.getBillingFirstName();
	}

	/**
	* Sets the billing first name of this shopping order.
	*
	* @param billingFirstName the billing first name of this shopping order
	*/
	public void setBillingFirstName(java.lang.String billingFirstName) {
		_shoppingOrder.setBillingFirstName(billingFirstName);
	}

	/**
	* Returns the billing last name of this shopping order.
	*
	* @return the billing last name of this shopping order
	*/
	public java.lang.String getBillingLastName() {
		return _shoppingOrder.getBillingLastName();
	}

	/**
	* Sets the billing last name of this shopping order.
	*
	* @param billingLastName the billing last name of this shopping order
	*/
	public void setBillingLastName(java.lang.String billingLastName) {
		_shoppingOrder.setBillingLastName(billingLastName);
	}

	/**
	* Returns the billing email address of this shopping order.
	*
	* @return the billing email address of this shopping order
	*/
	public java.lang.String getBillingEmailAddress() {
		return _shoppingOrder.getBillingEmailAddress();
	}

	/**
	* Sets the billing email address of this shopping order.
	*
	* @param billingEmailAddress the billing email address of this shopping order
	*/
	public void setBillingEmailAddress(java.lang.String billingEmailAddress) {
		_shoppingOrder.setBillingEmailAddress(billingEmailAddress);
	}

	/**
	* Returns the billing company of this shopping order.
	*
	* @return the billing company of this shopping order
	*/
	public java.lang.String getBillingCompany() {
		return _shoppingOrder.getBillingCompany();
	}

	/**
	* Sets the billing company of this shopping order.
	*
	* @param billingCompany the billing company of this shopping order
	*/
	public void setBillingCompany(java.lang.String billingCompany) {
		_shoppingOrder.setBillingCompany(billingCompany);
	}

	/**
	* Returns the billing street of this shopping order.
	*
	* @return the billing street of this shopping order
	*/
	public java.lang.String getBillingStreet() {
		return _shoppingOrder.getBillingStreet();
	}

	/**
	* Sets the billing street of this shopping order.
	*
	* @param billingStreet the billing street of this shopping order
	*/
	public void setBillingStreet(java.lang.String billingStreet) {
		_shoppingOrder.setBillingStreet(billingStreet);
	}

	/**
	* Returns the billing city of this shopping order.
	*
	* @return the billing city of this shopping order
	*/
	public java.lang.String getBillingCity() {
		return _shoppingOrder.getBillingCity();
	}

	/**
	* Sets the billing city of this shopping order.
	*
	* @param billingCity the billing city of this shopping order
	*/
	public void setBillingCity(java.lang.String billingCity) {
		_shoppingOrder.setBillingCity(billingCity);
	}

	/**
	* Returns the billing state of this shopping order.
	*
	* @return the billing state of this shopping order
	*/
	public java.lang.String getBillingState() {
		return _shoppingOrder.getBillingState();
	}

	/**
	* Sets the billing state of this shopping order.
	*
	* @param billingState the billing state of this shopping order
	*/
	public void setBillingState(java.lang.String billingState) {
		_shoppingOrder.setBillingState(billingState);
	}

	/**
	* Returns the billing zip of this shopping order.
	*
	* @return the billing zip of this shopping order
	*/
	public java.lang.String getBillingZip() {
		return _shoppingOrder.getBillingZip();
	}

	/**
	* Sets the billing zip of this shopping order.
	*
	* @param billingZip the billing zip of this shopping order
	*/
	public void setBillingZip(java.lang.String billingZip) {
		_shoppingOrder.setBillingZip(billingZip);
	}

	/**
	* Returns the billing country of this shopping order.
	*
	* @return the billing country of this shopping order
	*/
	public java.lang.String getBillingCountry() {
		return _shoppingOrder.getBillingCountry();
	}

	/**
	* Sets the billing country of this shopping order.
	*
	* @param billingCountry the billing country of this shopping order
	*/
	public void setBillingCountry(java.lang.String billingCountry) {
		_shoppingOrder.setBillingCountry(billingCountry);
	}

	/**
	* Returns the billing phone of this shopping order.
	*
	* @return the billing phone of this shopping order
	*/
	public java.lang.String getBillingPhone() {
		return _shoppingOrder.getBillingPhone();
	}

	/**
	* Sets the billing phone of this shopping order.
	*
	* @param billingPhone the billing phone of this shopping order
	*/
	public void setBillingPhone(java.lang.String billingPhone) {
		_shoppingOrder.setBillingPhone(billingPhone);
	}

	/**
	* Returns the ship to billing of this shopping order.
	*
	* @return the ship to billing of this shopping order
	*/
	public boolean getShipToBilling() {
		return _shoppingOrder.getShipToBilling();
	}

	/**
	* Returns <code>true</code> if this shopping order is ship to billing.
	*
	* @return <code>true</code> if this shopping order is ship to billing; <code>false</code> otherwise
	*/
	public boolean isShipToBilling() {
		return _shoppingOrder.isShipToBilling();
	}

	/**
	* Sets whether this shopping order is ship to billing.
	*
	* @param shipToBilling the ship to billing of this shopping order
	*/
	public void setShipToBilling(boolean shipToBilling) {
		_shoppingOrder.setShipToBilling(shipToBilling);
	}

	/**
	* Returns the shipping first name of this shopping order.
	*
	* @return the shipping first name of this shopping order
	*/
	public java.lang.String getShippingFirstName() {
		return _shoppingOrder.getShippingFirstName();
	}

	/**
	* Sets the shipping first name of this shopping order.
	*
	* @param shippingFirstName the shipping first name of this shopping order
	*/
	public void setShippingFirstName(java.lang.String shippingFirstName) {
		_shoppingOrder.setShippingFirstName(shippingFirstName);
	}

	/**
	* Returns the shipping last name of this shopping order.
	*
	* @return the shipping last name of this shopping order
	*/
	public java.lang.String getShippingLastName() {
		return _shoppingOrder.getShippingLastName();
	}

	/**
	* Sets the shipping last name of this shopping order.
	*
	* @param shippingLastName the shipping last name of this shopping order
	*/
	public void setShippingLastName(java.lang.String shippingLastName) {
		_shoppingOrder.setShippingLastName(shippingLastName);
	}

	/**
	* Returns the shipping email address of this shopping order.
	*
	* @return the shipping email address of this shopping order
	*/
	public java.lang.String getShippingEmailAddress() {
		return _shoppingOrder.getShippingEmailAddress();
	}

	/**
	* Sets the shipping email address of this shopping order.
	*
	* @param shippingEmailAddress the shipping email address of this shopping order
	*/
	public void setShippingEmailAddress(java.lang.String shippingEmailAddress) {
		_shoppingOrder.setShippingEmailAddress(shippingEmailAddress);
	}

	/**
	* Returns the shipping company of this shopping order.
	*
	* @return the shipping company of this shopping order
	*/
	public java.lang.String getShippingCompany() {
		return _shoppingOrder.getShippingCompany();
	}

	/**
	* Sets the shipping company of this shopping order.
	*
	* @param shippingCompany the shipping company of this shopping order
	*/
	public void setShippingCompany(java.lang.String shippingCompany) {
		_shoppingOrder.setShippingCompany(shippingCompany);
	}

	/**
	* Returns the shipping street of this shopping order.
	*
	* @return the shipping street of this shopping order
	*/
	public java.lang.String getShippingStreet() {
		return _shoppingOrder.getShippingStreet();
	}

	/**
	* Sets the shipping street of this shopping order.
	*
	* @param shippingStreet the shipping street of this shopping order
	*/
	public void setShippingStreet(java.lang.String shippingStreet) {
		_shoppingOrder.setShippingStreet(shippingStreet);
	}

	/**
	* Returns the shipping city of this shopping order.
	*
	* @return the shipping city of this shopping order
	*/
	public java.lang.String getShippingCity() {
		return _shoppingOrder.getShippingCity();
	}

	/**
	* Sets the shipping city of this shopping order.
	*
	* @param shippingCity the shipping city of this shopping order
	*/
	public void setShippingCity(java.lang.String shippingCity) {
		_shoppingOrder.setShippingCity(shippingCity);
	}

	/**
	* Returns the shipping state of this shopping order.
	*
	* @return the shipping state of this shopping order
	*/
	public java.lang.String getShippingState() {
		return _shoppingOrder.getShippingState();
	}

	/**
	* Sets the shipping state of this shopping order.
	*
	* @param shippingState the shipping state of this shopping order
	*/
	public void setShippingState(java.lang.String shippingState) {
		_shoppingOrder.setShippingState(shippingState);
	}

	/**
	* Returns the shipping zip of this shopping order.
	*
	* @return the shipping zip of this shopping order
	*/
	public java.lang.String getShippingZip() {
		return _shoppingOrder.getShippingZip();
	}

	/**
	* Sets the shipping zip of this shopping order.
	*
	* @param shippingZip the shipping zip of this shopping order
	*/
	public void setShippingZip(java.lang.String shippingZip) {
		_shoppingOrder.setShippingZip(shippingZip);
	}

	/**
	* Returns the shipping country of this shopping order.
	*
	* @return the shipping country of this shopping order
	*/
	public java.lang.String getShippingCountry() {
		return _shoppingOrder.getShippingCountry();
	}

	/**
	* Sets the shipping country of this shopping order.
	*
	* @param shippingCountry the shipping country of this shopping order
	*/
	public void setShippingCountry(java.lang.String shippingCountry) {
		_shoppingOrder.setShippingCountry(shippingCountry);
	}

	/**
	* Returns the shipping phone of this shopping order.
	*
	* @return the shipping phone of this shopping order
	*/
	public java.lang.String getShippingPhone() {
		return _shoppingOrder.getShippingPhone();
	}

	/**
	* Sets the shipping phone of this shopping order.
	*
	* @param shippingPhone the shipping phone of this shopping order
	*/
	public void setShippingPhone(java.lang.String shippingPhone) {
		_shoppingOrder.setShippingPhone(shippingPhone);
	}

	/**
	* Returns the cc name of this shopping order.
	*
	* @return the cc name of this shopping order
	*/
	public java.lang.String getCcName() {
		return _shoppingOrder.getCcName();
	}

	/**
	* Sets the cc name of this shopping order.
	*
	* @param ccName the cc name of this shopping order
	*/
	public void setCcName(java.lang.String ccName) {
		_shoppingOrder.setCcName(ccName);
	}

	/**
	* Returns the cc type of this shopping order.
	*
	* @return the cc type of this shopping order
	*/
	public java.lang.String getCcType() {
		return _shoppingOrder.getCcType();
	}

	/**
	* Sets the cc type of this shopping order.
	*
	* @param ccType the cc type of this shopping order
	*/
	public void setCcType(java.lang.String ccType) {
		_shoppingOrder.setCcType(ccType);
	}

	/**
	* Returns the cc number of this shopping order.
	*
	* @return the cc number of this shopping order
	*/
	public java.lang.String getCcNumber() {
		return _shoppingOrder.getCcNumber();
	}

	/**
	* Sets the cc number of this shopping order.
	*
	* @param ccNumber the cc number of this shopping order
	*/
	public void setCcNumber(java.lang.String ccNumber) {
		_shoppingOrder.setCcNumber(ccNumber);
	}

	/**
	* Returns the cc exp month of this shopping order.
	*
	* @return the cc exp month of this shopping order
	*/
	public int getCcExpMonth() {
		return _shoppingOrder.getCcExpMonth();
	}

	/**
	* Sets the cc exp month of this shopping order.
	*
	* @param ccExpMonth the cc exp month of this shopping order
	*/
	public void setCcExpMonth(int ccExpMonth) {
		_shoppingOrder.setCcExpMonth(ccExpMonth);
	}

	/**
	* Returns the cc exp year of this shopping order.
	*
	* @return the cc exp year of this shopping order
	*/
	public int getCcExpYear() {
		return _shoppingOrder.getCcExpYear();
	}

	/**
	* Sets the cc exp year of this shopping order.
	*
	* @param ccExpYear the cc exp year of this shopping order
	*/
	public void setCcExpYear(int ccExpYear) {
		_shoppingOrder.setCcExpYear(ccExpYear);
	}

	/**
	* Returns the cc ver number of this shopping order.
	*
	* @return the cc ver number of this shopping order
	*/
	public java.lang.String getCcVerNumber() {
		return _shoppingOrder.getCcVerNumber();
	}

	/**
	* Sets the cc ver number of this shopping order.
	*
	* @param ccVerNumber the cc ver number of this shopping order
	*/
	public void setCcVerNumber(java.lang.String ccVerNumber) {
		_shoppingOrder.setCcVerNumber(ccVerNumber);
	}

	/**
	* Returns the comments of this shopping order.
	*
	* @return the comments of this shopping order
	*/
	public java.lang.String getComments() {
		return _shoppingOrder.getComments();
	}

	/**
	* Sets the comments of this shopping order.
	*
	* @param comments the comments of this shopping order
	*/
	public void setComments(java.lang.String comments) {
		_shoppingOrder.setComments(comments);
	}

	/**
	* Returns the pp txn ID of this shopping order.
	*
	* @return the pp txn ID of this shopping order
	*/
	public java.lang.String getPpTxnId() {
		return _shoppingOrder.getPpTxnId();
	}

	/**
	* Sets the pp txn ID of this shopping order.
	*
	* @param ppTxnId the pp txn ID of this shopping order
	*/
	public void setPpTxnId(java.lang.String ppTxnId) {
		_shoppingOrder.setPpTxnId(ppTxnId);
	}

	/**
	* Returns the pp payment status of this shopping order.
	*
	* @return the pp payment status of this shopping order
	*/
	public java.lang.String getPpPaymentStatus() {
		return _shoppingOrder.getPpPaymentStatus();
	}

	/**
	* Sets the pp payment status of this shopping order.
	*
	* @param ppPaymentStatus the pp payment status of this shopping order
	*/
	public void setPpPaymentStatus(java.lang.String ppPaymentStatus) {
		_shoppingOrder.setPpPaymentStatus(ppPaymentStatus);
	}

	/**
	* Returns the pp payment gross of this shopping order.
	*
	* @return the pp payment gross of this shopping order
	*/
	public double getPpPaymentGross() {
		return _shoppingOrder.getPpPaymentGross();
	}

	/**
	* Sets the pp payment gross of this shopping order.
	*
	* @param ppPaymentGross the pp payment gross of this shopping order
	*/
	public void setPpPaymentGross(double ppPaymentGross) {
		_shoppingOrder.setPpPaymentGross(ppPaymentGross);
	}

	/**
	* Returns the pp receiver email of this shopping order.
	*
	* @return the pp receiver email of this shopping order
	*/
	public java.lang.String getPpReceiverEmail() {
		return _shoppingOrder.getPpReceiverEmail();
	}

	/**
	* Sets the pp receiver email of this shopping order.
	*
	* @param ppReceiverEmail the pp receiver email of this shopping order
	*/
	public void setPpReceiverEmail(java.lang.String ppReceiverEmail) {
		_shoppingOrder.setPpReceiverEmail(ppReceiverEmail);
	}

	/**
	* Returns the pp payer email of this shopping order.
	*
	* @return the pp payer email of this shopping order
	*/
	public java.lang.String getPpPayerEmail() {
		return _shoppingOrder.getPpPayerEmail();
	}

	/**
	* Sets the pp payer email of this shopping order.
	*
	* @param ppPayerEmail the pp payer email of this shopping order
	*/
	public void setPpPayerEmail(java.lang.String ppPayerEmail) {
		_shoppingOrder.setPpPayerEmail(ppPayerEmail);
	}

	/**
	* Returns the send order email of this shopping order.
	*
	* @return the send order email of this shopping order
	*/
	public boolean getSendOrderEmail() {
		return _shoppingOrder.getSendOrderEmail();
	}

	/**
	* Returns <code>true</code> if this shopping order is send order email.
	*
	* @return <code>true</code> if this shopping order is send order email; <code>false</code> otherwise
	*/
	public boolean isSendOrderEmail() {
		return _shoppingOrder.isSendOrderEmail();
	}

	/**
	* Sets whether this shopping order is send order email.
	*
	* @param sendOrderEmail the send order email of this shopping order
	*/
	public void setSendOrderEmail(boolean sendOrderEmail) {
		_shoppingOrder.setSendOrderEmail(sendOrderEmail);
	}

	/**
	* Returns the send shipping email of this shopping order.
	*
	* @return the send shipping email of this shopping order
	*/
	public boolean getSendShippingEmail() {
		return _shoppingOrder.getSendShippingEmail();
	}

	/**
	* Returns <code>true</code> if this shopping order is send shipping email.
	*
	* @return <code>true</code> if this shopping order is send shipping email; <code>false</code> otherwise
	*/
	public boolean isSendShippingEmail() {
		return _shoppingOrder.isSendShippingEmail();
	}

	/**
	* Sets whether this shopping order is send shipping email.
	*
	* @param sendShippingEmail the send shipping email of this shopping order
	*/
	public void setSendShippingEmail(boolean sendShippingEmail) {
		_shoppingOrder.setSendShippingEmail(sendShippingEmail);
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

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_shoppingOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _shoppingOrder.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_shoppingOrder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ShoppingOrderWrapper((ShoppingOrder)_shoppingOrder.clone());
	}

	public int compareTo(
		com.liferay.portlet.shopping.model.ShoppingOrder shoppingOrder) {
		return _shoppingOrder.compareTo(shoppingOrder);
	}

	@Override
	public int hashCode() {
		return _shoppingOrder.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.liferay.portlet.shopping.model.ShoppingOrder> toCacheModel() {
		return _shoppingOrder.toCacheModel();
	}

	public com.liferay.portlet.shopping.model.ShoppingOrder toEscapedModel() {
		return new ShoppingOrderWrapper(_shoppingOrder.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _shoppingOrder.toString();
	}

	public java.lang.String toXmlString() {
		return _shoppingOrder.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_shoppingOrder.persist();
	}

	public ShoppingOrder getWrappedShoppingOrder() {
		return _shoppingOrder;
	}

	public void resetOriginalValues() {
		_shoppingOrder.resetOriginalValues();
	}

	private ShoppingOrder _shoppingOrder;
}