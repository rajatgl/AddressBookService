package com.bridgelabz.addressbookservice;

import com.bridgelabz.addressbookservice.entity.AddressBook;
import com.bridgelabz.addressbookservice.mysql.AddressTable;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean runner = true;
        AddressBook addressBook1 = new AddressBook("rajat","gundi","shahu park,rajendranager",
                "kolhapur","MH","416004","8496942482","glrajat@gmail.com");

        AddressTable addressTable = new AddressTable();
        Scanner sc = new Scanner(System.in);
        System.out.println("choice: ");
        System.out.println("1.Insert new address-book\n" +
                "2.retrieve all\n" +
                "3.retrieve by addressId\n" +
                "4.update phone by addressId\n" +
                "5.get record count\n" +
                "6.exit");

        while (runner) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    //insert address book
                    addressTable.create(addressBook1);
                    break;

                case 2:
                    //retrieve all address books
                    List<AddressBook> addressBooks = addressTable.retrieveAll();
                    for (AddressBook addressBook : addressBooks) {
                        System.out.println(addressBook.toString());
                    }
                    break;

                case 3:
                    //retrieve specific address book
                    System.out.println("addressId: ");
                    int addressId = sc.nextInt();
                    addressBooks = addressTable.retrieve(addressId);
                    for (AddressBook addressBook : addressBooks) {
                        System.out.println(addressBook.toString());
                    }
                case 4:
                    //update phone number using prepared statement
                    System.out.println("addressId: ");
                    int id = sc.nextInt();
                    System.out.println("phone: ");
                    String phone = sc.next();
                    addressTable.updatePhoneNumber(id, phone);
                case 5:
                    //retrieve record count
                    int count = addressTable.countRecords();
                    System.out.println("Number of records: " + count);
                    break;
                case 6:
                    runner = false;
            }
        }
    }
}
