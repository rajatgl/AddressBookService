package com.bridgelabz.addressbookservice.entity;

import java.util.Date;

public class AddressBook {
    private int addressId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emailId;

    public AddressBook(int addressId,
                       String firstName,
                       String lastName,
                       String address,
                       String city,
                       String state,
                       String zipCode,
                       String phoneNumber,
                       String emailId) {
        this.addressId = addressId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }
    public AddressBook(String firstName,
                       String lastName,
                       String address,
                       String city,
                       String state,
                       String zipCode,
                       String phoneNumber,
                       String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
    }

    public int getAddressId() {
        return addressId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }
}
