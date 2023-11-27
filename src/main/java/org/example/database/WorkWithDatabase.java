package org.example.database;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class WorkWithDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbproject?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Создание коннекшена к бд
     * @return
     * @throws SQLException
     */
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
    /**
     * Создание таблицы reports
     * @throws SQLException
     */
    public void createTable() throws SQLException {
//        Connection conn = connection().createStatement();
        Statement statement = connection().createStatement();

        statement.execute("""
                create table reports(
                id integer primary key auto_increment, operations varchar(1000))
                """);
//        statement.close();
    }
//    public void createTable() throws SQLException {
//        Statement statement = connection().createStatement();
//        statement.execute("""
//                create table reports(
//                id integer primary key auto_increment,
//                date varchar(100), file varchar(100), account_numbers varchar(100), sum double, result varchar(200))
//                """);
//    }

    /**
     * Добавить элемент в таблицу
     * @param operations
     * @throws SQLException
     */
    public void addInfoToTable(String operation) throws SQLException {
        String sql = "INSERT INTO reports (operations) VALUES(?)";
        PreparedStatement prepared = connection().prepareStatement(sql);
        prepared.setString(1, operation);

        prepared.execute();
        prepared.close();
    }
//    public void addInfoToTable(String date, String file, String account_numbers, Double sum, String result) throws SQLException {
//        String sql = "INSERT INTO reports ( date, file, account_numbers, sum, result) Values(?, ?, ?, ?, ?)";
//        PreparedStatement prepared = connection().prepareStatement(sql);
//
//        prepared.setString(1, date);
//        prepared.setString(2, file );
//        prepared.setString(3, account_numbers);
//        prepared.setDouble(4, sum);
//        prepared.setString(5, result);
//
//        prepared.execute();
//        prepared.close();
//    }

    /**
     * Удаление элемента из таблицы по индексу
     * @param id
     * @throws SQLException
     */
    public void deleteInfoToTable(int id) throws SQLException {
        String sql = "DELETE FROM reports WHERE id = ?";
        PreparedStatement prepared = connection().prepareStatement(sql);

        prepared.setInt(1, id);
        prepared.executeUpdate();
        prepared.close();
    }

    /**
     * Обновить элемент по опеределенному индекс на переданный методу параметр
     * @param id
     * @param operations
     * @throws SQLException
     */
    public void updateInfoToTable(int id, String operations) throws SQLException{
        String sql = "UPDATE reports SET  operations = ? WHERE id = ?";
        PreparedStatement prepared = connection().prepareStatement(sql);

        prepared.setString(1, operations);
        prepared.setInt(2, id);

        prepared.executeUpdate();
        prepared.close();
    }
//    public void updateInfoToTable(int id, String date, String file) throws SQLException {
//        String sql = "UPDATE reports SET  date = ?, file = ? WHERE id = ?";
//        PreparedStatement prepared = connection().prepareStatement(sql);
//
//        prepared.setString(1, date);
//        prepared.setString(2, file);
//        prepared.setInt(3, id);
//
//        prepared.executeUpdate();
//        prepared.close();
//    }

    /**
     * Вывод информации из таблицы
     * @throws SQLException
     */
    public void readInfoToTable() throws SQLException{
        String sql = "SELECT * FROM reports";
        Connection conn = connection();
        ResultSet resultSet = conn.createStatement().executeQuery(sql);

        while(resultSet.next()){
            System.out.println(resultSet.getInt("id") + " | " +
                    resultSet.getString("operations"));
        }

        conn.setAutoCommit(true);
        conn.close();
    }
//    public void readInfoToTable() throws SQLException {
//        String sql = "SELECT * FROM reports";
//        Connection conn = connection();
//        ResultSet resultSet = conn.createStatement().executeQuery(sql);
//
//        while(resultSet.next()){
//            System.out.println(resultSet.getInt("id") + " | " +
//                    resultSet.getString("date") + " | " +
//                    resultSet.getString("file") + " | " +
//                    resultSet.getString("account_numbers") + " " +
//                    resultSet.getDouble("sum") + " | " +
//                    resultSet.getString("result"));
//        }
//        conn.setAutoCommit(true);
//        conn.close();
//    }

}
