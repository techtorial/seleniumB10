package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData resultSetMetaData;

    // create the connection to DB and provide your credentials
    public static void establishConnection() {

        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@techtorialhr.coum1jh8y6he.us-east-2.rds.amazonaws.com:1521/ORCL",
                    "admin",
                    "techtorial2200"
            );
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // executeQuery("select * from departments");

    public static List<Map<String, Object>> executeQuery (String query) {

        List<Map<String, Object>> employees = new ArrayList<>();

        try {
            resultSet = statement.executeQuery(query);
            resultSet.beforeFirst(); //it will go to the column names
            resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {

                Map<String, Object> employee = new LinkedHashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    employee.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
                }

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    // get total number of rows returned
    public static int getRowNum () throws SQLException {
        resultSet.last();
        return resultSet.getRow();
    }

    // close the open connections
    public static void closeConnection() {

        try {

            if (connection != null) {
                connection.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
