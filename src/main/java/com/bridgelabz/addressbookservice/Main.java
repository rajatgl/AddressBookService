package com.bridgelabz.addressbookservice;

import com.bridgelabz.addressbookservice.entity.AddressBook;
import com.bridgelabz.addressbookservice.mysql.AddressTable;

import java.util.List;

public class Main {
    public static void main(String[] args){
        AddressBook addressBook1 = new AddressBook("rajat","gundi","shahu park,rajendranager",
                "kolhapur","MH","416004","8496942482","glrajat@gmail.com");

        AddressTable addressTable = new AddressTable();

        //insert address book
        addressTable.create(addressBook1);

        //retrieve all address books
        List<AddressBook> addressBooks = addressTable.retrieveAll();
        for (AddressBook addressBook: addressBooks) {
            System.out.println(addressBook.toString());
        }

    }
}
