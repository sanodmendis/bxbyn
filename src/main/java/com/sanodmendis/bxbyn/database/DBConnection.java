/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanodmendis.bxbyn.database;

import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

import com.sanodmendis.bxbyn.utils.StatusMessageHandler;
/**
 *
 * @author Sanod D. Mendis
 */

public class DBConnection {
    private static Connection connection = null;
    private static JTextField statusField = null;
    
    private static final Dotenv dotenv = Dotenv.load();

    private static final String HOST = dotenv.get("DB_HOST");
    private static final String PORT = dotenv.get("DB_PORT");
    private static final String DATABASE = dotenv.get("DB_NAME");
    private static final String USERNAME = dotenv.get("DB_USER");
    private static final String PASSWORD = dotenv.get("DB_PASS");

    private static final String DB_URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;

    static {
        initializeConnection();
    }

    public static void setStatusField(JTextField field) {
        statusField = field;
    }

    private static void initializeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            if (connection != null && !connection.isClosed()) {
                String successMsg = "Database connected successfully to: " + DB_URL;
                System.out.println(successMsg);

                if (statusField != null) {
                    StatusMessageHandler.showSuccess(statusField, successMsg);
                }
            }

        } catch (ClassNotFoundException e) {
            String errorMsg = "MySQL JDBC Driver not found: " + e.getMessage();
            System.err.println(errorMsg);
            e.printStackTrace();

            if (statusField != null) {
                StatusMessageHandler.showError(statusField, errorMsg);
            }
        } catch (SQLException e) {
            String errorMsg = "Database connection failed: " + e.getMessage();
            System.err.println(errorMsg);
            System.err.println("Connection URL: " + DB_URL);
            e.printStackTrace();

            if (statusField != null) {
                StatusMessageHandler.showError(statusField, errorMsg);
            }
        }
    }

    public static Connection getConnection() {
        try {

            if (connection == null || connection.isClosed()) {
                String reconnectMsg = "Connection closed. Reconnecting...";
                System.out.println(reconnectMsg);

                if (statusField != null) {
                    StatusMessageHandler.showWarning(statusField, reconnectMsg);
                }

                initializeConnection();
            }
        } catch (SQLException e) {
            String errorMsg = "Error checking connection status: " + e.getMessage();
            System.err.println(errorMsg);

            if (statusField != null) {
                StatusMessageHandler.showError(statusField, errorMsg);
            }

            initializeConnection();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                String closeMsg = "Database connection closed.";
                System.out.println(closeMsg);

                if (statusField != null) {
                    StatusMessageHandler.showInfo(statusField, closeMsg);
                }
            }
        } catch (SQLException e) {
            String errorMsg = "Error closing connection: " + e.getMessage();
            System.err.println(errorMsg);

            if (statusField != null) {
                StatusMessageHandler.showError(statusField, errorMsg);
            }
        }
    }

    public static String getConnectionInfo() {
        try {
            if (connection != null && !connection.isClosed()) {
                return "Connected to: " + DB_URL + " | Catalog: " + connection.getCatalog();
            }
        } catch (SQLException e) {

        }
        return "Not connected";
    }

    public static void showStatus(String message, StatusMessageHandler.MessageType type) {
        if (statusField != null) {
            StatusMessageHandler.showStatus(statusField, message, type);
        }
    }

    public static void showStatusSuccess(String message) {
        showStatus(message, StatusMessageHandler.MessageType.SUCCESS);
    }

    public static void showStatusError(String message) {
        showStatus(message, StatusMessageHandler.MessageType.ERROR);
    }

    public static void showStatusWarning(String message) {
        showStatus(message, StatusMessageHandler.MessageType.WARNING);
    }

    public static void showStatusInfo(String message) {
        showStatus(message, StatusMessageHandler.MessageType.INFO);
    }
}