package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/mototech_v2";
    private static final String USER = "root";
    private static final String PASSWORD = "mysqlPW";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try{
            Connection conn = getConnection();
            if (conn != null){
                System.out.println("Conexão estaelecida com sucesso!!!");
            } else {
                System.out.println("Falha na Conexão!!!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
