package utils;

import org.testng.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JDBCPractice {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData resultSetMetaData;

    public static void main(String[] args) throws SQLException {

        connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@techtorialhr.coum1jh8y6he.us-east-2.rds.amazonaws.com:1521/ORCL",
                "admin",
                "techtorial2200"
        );

        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        resultSet = statement.executeQuery("select * from regions");


        // resultSet = statement.executeQuery("select * from patients where first_name = John and last_name = Smith");

        resultSet.next(); // return type of next() is boolean. It will go to the next row and if there is a next row it will return TRUE.
        // It will go to the next row. If there is no next row, itw ill stop and return FALSE.

        System.out.println(resultSet.getString("region_name"));

        resultSet.last(); //go to the last row
        resultSet.first(); //go to the first row


        // METADATA - is the information about the columns, rows, etc. in your table.
        // A set of data that describes and gives the information about the other related data.

        resultSetMetaData = resultSet.getMetaData();

        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(2));

        // List of maps of type String and Object

        List<Map<String, Object>> employees = new ArrayList<>();

        resultSet.beforeFirst(); //it will go to the column names

        while (resultSet.next()) {

            Map<String, Object> employee = new LinkedHashMap<>();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                employee.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
            }

            employees.add(employee);
        }

        System.out.println(employees.get(2).get("REGION_NAME"));

    }
}
