package com.bridgelabz.addressbookservice.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConfig {
    private boolean isDriverLoaded = false;
    private Connection connection = null;
    private static MySqlConfig mySqlInstance = null;

    private boolean loadDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return isDriverLoaded = true;
        }catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in classpath",e);
        }
    }
    public Connection getSqlConnection(String username,String password) throws SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/address_book_service";
        try {
            if(!loadDriver())
                loadDriver();
            return connection = DriverManager.getConnection(jdbcUrl, username, password);
        }catch (SQLException e){
            throw new SQLException("mysql connection failed");
        }
    }
    public static MySqlConfig getMySqlInstance(){
        if(mySqlInstance == null)
            mySqlInstance = new MySqlConfig();
        return mySqlInstance;
    }

}
