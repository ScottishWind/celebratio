package com.xcommerce.online.user.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	String userID;
	String firstName;
	String lastName;
	String mobileNumber;
	String email;
	String profilePicture;
	List<Address> billingAddress;
	List<Address> deliveryAddress;
	boolean isActive = true;
	boolean isEmailValidated = false;
	boolean isMobileNumberValidated = false;

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the profilePicture
	 */
	public String getProfilePicture() {
		return profilePicture;
	}

	/**
	 * @param profilePicture
	 *            the profilePicture to set
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	/**
	 * @return the billingAddress
	 */
	public List<Address> getBillingAddress() {
		return billingAddress;
	}

	/**
	 * @param billingAddress
	 *            the billingAddress to set
	 */
	public void setBillingAddress(List<Address> billingAddress) {
		this.billingAddress = billingAddress;
	}

	/**
	 * @return the deliveryAddress
	 */
	public List<Address> getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress
	 *            the deliveryAddress to set
	 */
	public void setDeliveryAddress(List<Address> deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName + ", mobileNumber="
				+ mobileNumber + ", email=" + email + ", profilePicture=" + profilePicture + ", billingAddress="
				+ billingAddress + ", deliveryAddress=" + deliveryAddress + "]";
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the isEmailValidated
	 */
	public boolean isEmailValidated() {
		return isEmailValidated;
	}

	/**
	 * @param isEmailValidated the isEmailValidated to set
	 */
	public void setEmailValidated(boolean isEmailValidated) {
		this.isEmailValidated = isEmailValidated;
	}

	/**
	 * @return the isMobileNumberValidated
	 */
	public boolean isMobileNumberValidated() {
		return isMobileNumberValidated;
	}

	/**
	 * @param isMobileNumberValidated the isMobileNumberValidated to set
	 */
	public void setMobileNumberValidated(boolean isMobileNumberValidated) {
		this.isMobileNumberValidated = isMobileNumberValidated;
	}

}
