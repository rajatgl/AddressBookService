package com.bridgelabz.addressbookservice.mysql;

import com.bridgelabz.addressbookservice.entity.AddressBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressTable extends AddressTableUtils {

    public AddressTable() {
        try{
            createTable();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param resultSet connection of selected items
     * @return list of address-book objects
     * @throws SQLException expected
     */
    protected List<AddressBook> collectData(ResultSet resultSet) throws SQLException {
        List<AddressBook> addressBooks = new ArrayList<AddressBook>();
        while(resultSet.next()){
            AddressBook addressBook = new AddressBook(resultSet.getInt("addressId"),
                    resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("address"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getString("zipcode"),
                    resultSet.getString("phone"),
                    resultSet.getString("email"));
            addressBooks.add(addressBook);
        }
        return  addressBooks;
    }

    private void createTable() throws SQLException {
        String createAddressBookTableQuery = "CREATE TABLE IF NOT EXISTS address_book (\n" +
                "`addressId` INT NOT NULL UNIQUE AUTO_INCREMENT,\n" +
                "`firstname` VARCHAR(10),\n" +
                "`lastname` VARCHAR(10),\n" +
                "`address` VARCHAR(100),\n" +
                "`city` VARCHAR(10),\n" +
                "`state` VARCHAR(10),\n" +
                "`zipcode` VARCHAR(8),\n" +
                "`phone` varchar(10) unique,\n" +
                "`email` varchar(50) unique,\n" +
                "primary key(addressId))";
        execute(createAddressBookTableQuery);
    }

    public void create(AddressBook addressBook) {
        String insertQuery = "INSERT INTO address_book(`firstname`,`lastname`,`address`,\n" +
                "`city`,`state`,`zipcode`,`phone`,`email`) value\n" +
                "('"+addressBook.getFirstName()+"','"+addressBook.getLastName()+"','"+addressBook.getAddress()+"',\n" +
                "'"+addressBook.getCity()+"','"+addressBook.getState()+"','"+addressBook.getZipCode()+"','"+addressBook.getPhoneNumber()+"','"+addressBook.getEmailId()+"')";
        try {
            executeUpdate(insertQuery);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<AddressBook> retrieveAll(){
        List<AddressBook> addressBooks = new ArrayList<AddressBook>();
        String selectQuery = "select * from address_book";
        try{
            addressBooks = executeQuery(selectQuery);
        }catch (Exception e){
            e.printStackTrace();
        }
        return addressBooks;
    }

}
