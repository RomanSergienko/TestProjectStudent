package me.sergienko.dao;

import java.sql.*;

 class ConnectionGetter {
     Connection getConnection() {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String name = "postgres";
        String password = "postgres";


        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}

