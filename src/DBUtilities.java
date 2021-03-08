/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author murli
 */
import java.sql.*;

public class DBUtilities {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
 String url="jdbc:mysql://localhost:3306/petrolpump?zeroDateTimeBehavior=convertToNull";
   
    public DBUtilities() throws SQLException {
        try {
            connection = DriverManager.getConnection(url, "root", "");

        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void ExecuteSQLStatement(String sql_stmt) {
        try {
            statement = connection.createStatement();

            statement.executeUpdate(sql_stmt);
        } catch (SQLException ex) {
            System.out.println("The following error has occured: " + ex.getMessage());
        }
    }
}
