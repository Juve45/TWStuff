/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import javax.annotation.PostConstruct;

/**
 *
 * @author alexandru
 */
public class Database {
    
   
    private static final String URL = "jdbc:postgresql://localhost:5432/tw";
    private static final String USER = "andreea";
    private static final String PASSWORD = "sql";
    private static Connection connection = null;
/**
 * crearea conexiunii
 */
    public static void createConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    private Database() {
    }
/**
 * 
 * @return 
 */
    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }
    /**
     * 
     * @throws SQLException 
     */
    public static void commit() throws SQLException
    {
        connection.commit();
    }
      public static void rollback() throws SQLException
    {
        connection.rollback();
    }
/**
 * inchiderea conexiunii
 * 
 */
    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Closed database successfully");

    }
    
    
}
