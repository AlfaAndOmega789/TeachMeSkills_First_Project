package org.example.database;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class WorkWithDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbproject?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public Connection connection() throws SQLException{
        Connection conn = null;
        try {
            Driver driver = new Driver();
            DriverManager.registerDriver(driver);
            conn =  DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return conn;
    }
    public void createTable() throws SQLException {
        Statement statement = connection().createStatement();
        statement.execute("""
                create table reports(
                id integer primary key auto_increment, 
                date varchar(100), file varchar(100), account_numbers varchar(100), sum double, result varchar(200))
                """);
    }
    public void addInfoToTable(String date, String file, String account_numbers, Double sum, String result) throws SQLException {
        String sql = "INSERT INTO reports ( date, file, account_numbers, sum, result) Values(?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection().prepareStatement(sql);

        preparedStatement.setString(1, date);
        preparedStatement.setString(2, file );
        preparedStatement.setString(3, account_numbers);
        preparedStatement.setDouble(4, sum);
        preparedStatement.setString(5, result);

        preparedStatement.execute();
    }
//    public void deleteInfoT
}
