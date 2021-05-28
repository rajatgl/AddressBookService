package com.bridgelabz.addressbookservice.mysql;

import com.bridgelabz.addressbookservice.entity.AddressBook;

import java.sql.*;
import java.util.List;

public abstract class AddressTableUtils {
    int count = 0;
    /**
     *
     * @param query to be executed [belongs to DDL]
     * @return true/false depending on the status of the operation
     * @throws SQLException
     */
    protected Boolean execute(String query) throws SQLException {
        Boolean isSuccessful = false;
        Connection connection = MySqlConfig.getMySqlInstance().getSqlConnection("root","password120596");
        try{
            Statement stmt = connection.createStatement();
            try{
                isSuccessful = stmt.execute(query);
            }finally {
                stmt.close();
            }
        }finally {
            connection.close();
        }
        return isSuccessful;
    }

    /**
     *
     * @param query to be executed [belongs to DML]
     * @return number of rows updated
     * @throws SQLException
     */
    protected Integer executeUpdate(String query) throws SQLException {
        Integer isSuccessful = 0;
        Connection connection = MySqlConfig.getMySqlInstance().getSqlConnection("root","password120596");
        try{
            Statement stmt = connection.createStatement();
            try{
                isSuccessful = stmt.executeUpdate(query);
            }finally {
                stmt.close();
            }
        }finally {
            connection.close();
        }
        return isSuccessful;
    }

    //Usage of prepared statement
    protected Integer updatePhone(int addressId, String phone) throws SQLException {
        Integer isSuccessful = 0;
        Connection connection = MySqlConfig.getMySqlInstance().getSqlConnection("root","password120596");
        try{
            String query ="Update address_book set phone=? where addressId=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(2,addressId);
            stmt.setString(1,phone);
            try{
                isSuccessful = stmt.executeUpdate();
            }finally {
                stmt.close();
            }
        }finally {
            connection.close();
        }
        return isSuccessful;
    }

    /**
     *
     * @param query to be executed [belongs to DQL]
     * @return list of items- each item representing each row in the MySQL table
     * @throws SQLException
     */
    protected List<AddressBook> executeQuery(String query) throws SQLException {
        List<AddressBook> list;
        Connection connection = MySqlConfig.getMySqlInstance().getSqlConnection("root","password120596");
        try{
            Statement stmt = connection.createStatement();
            try{
                ResultSet resultSet = stmt.executeQuery(query);
                try{
                    list = collectData(resultSet);
                }finally {
                    resultSet.close();
                }
            }finally {
                stmt.close();
            }
        }finally {
            connection.close();
        }
        return list;
    }

    protected int recordCount() throws SQLException {
        int count =0;
        Connection connection = MySqlConfig.getMySqlInstance().getSqlConnection("root","password120596");
        try{
            Statement stmt = connection.createStatement();
            try{
                String query = "select count(*) as BOOK_SIZE from address_book";
                ResultSet resultSet = stmt.executeQuery(query);
                try{
                    while (resultSet.next())
                        count = resultSet.getInt("BOOK_SIZE");
                }finally {
                    resultSet.close();
                }
            }finally {
                stmt.close();
            }
        }finally {
            connection.close();
        }
        return count;
    }

    protected abstract List<AddressBook> collectData(ResultSet resultSet) throws SQLException;
}
