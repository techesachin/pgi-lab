package com.pgi.utils;

import java.sql.*;

public class PGIDAOUtil {
    final static String URL = "jdbc:postgresql://localhost:5432/postgres";
    final static String user = "postgres";
    final static String password = "admin";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {


        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static Statement getStatement(Connection connection) {


        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public static void closeConnect(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void closeStatement(PreparedStatement preparedStatement) {
        // search from google and write the code
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
