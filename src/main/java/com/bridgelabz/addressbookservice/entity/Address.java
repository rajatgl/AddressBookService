package com.bridgelabz.addressbookservice.entity;

public class Address {
    private final int addressId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emailId;
    private String date;

    public Address(int addressId,
                   String firstName,
                   String lastName,
                   String address,
                   String city,
                   String state,
                   String zipCode,
                   String phoneNumber,
                   String emailId,
                   String date) {
        this.addressId = addressId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.date = date;
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

    public String getDate() {
        return date;
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
                ", date='" + date + '\'' +
                '}';
    }
}
