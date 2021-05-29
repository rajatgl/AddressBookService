package com.bridgelabz.addressbookservice;

import com.bridgelabz.addressbookservice.entity.AddressBook;
import com.bridgelabz.addressbookservice.mysql.AddressTable;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        Instant start,end;

        //address-books to be inserted
        AddressBook[] addressBooks = {
                new AddressBook("rajat","gundi","shahu park,rajendranager",
                "kolhapur","MH","416004","8496942482","glrajat@gmail.com"),
                new AddressBook("raj","gundi","shahu park,rajendranager",
                        "kolhapur","MH","416004","8496942480","glraj@gmail.com"),
                new AddressBook("dark","prince","rajendranager",
                        "kolhapur","MH","416000","8975001115","dp@gmail.com"),
                new AddressBook("rajx","gundi","shahu park,rajendranager",
                        "kolhapur","MH","416004","8496942483","glrajx@gmail.com")
        };

        AddressTable addressTable = new AddressTable();
        addressTable.deleteAll();

        //run duration without multi-threading
        start = Instant.now();
        Arrays.stream(addressBooks).forEach(addressTable::create);
        end = Instant.now();
        addressTable.deleteAll();
        System.out.println("Duration without thread:" + Duration.between(start, end));

        //run duration using multi-threading
        start = Instant.now();
        Arrays.stream(addressBooks).forEach(addressBook -> {
            Runnable task = () ->{
                addressTable.create(addressBook);
            };
        });
        end = Instant.now();
        addressTable.deleteAll();
        System.out.println("Duration with thread:" + Duration.between(start, end));

    }
}
