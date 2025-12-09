/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sanodmendis.bxbyn.database;

import java.sql.*;

/**
 *
 * @author Sanod D. Mendis
 */
public class DBHelper {

    public static ResultSet executeQuery(String query, Object... params) throws SQLException {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            return pstmt.executeQuery();
        } catch (SQLException e) {
            String errorMsg = "Query execution failed: " + e.getMessage();
            System.err.println(errorMsg);
            DBConnection.showStatusError(errorMsg);
            throw e;
        }
    }

    public static int executeUpdate(String query, Object... params) throws SQLException {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            String errorMsg = "Update execution failed: " + e.getMessage();
            System.err.println(errorMsg);
            DBConnection.showStatusError(errorMsg);
            throw e;
        }
    }

    public static Object getSingleValue(String query, Object... params) throws SQLException {
        ResultSet rs = executeQuery(query, params);
        if (rs.next()) {
            return rs.getObject(1);
        }
        return null;
    }

    public static boolean exists(String query, Object... params) throws SQLException {
        ResultSet rs = executeQuery(query, params);
        return rs.next();
    }

    public static String getNextMovementNumber() throws SQLException {
        try {
            String query = "SELECT CONCAT('MOV', DATE_FORMAT(NOW(), '%Y%m%d'), LPAD(IFNULL(MAX(SUBSTRING(movement_number, 12)), 0) + 1, 4, '0')) "
                    + "FROM movement_headers WHERE movement_number LIKE CONCAT('MOV', DATE_FORMAT(NOW(), '%Y%m%d'), '%')";

            String nextNumber = (String) getSingleValue(query);
            return nextNumber != null ? nextNumber : "MOV" + java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.BASIC_ISO_DATE) + "0001";
        } catch (SQLException e) {
            String errorMsg = "Failed to generate movement number: " + e.getMessage();
            System.err.println(errorMsg);
            DBConnection.showStatusError(errorMsg);
            throw e;
        }
    }

    public static void startTransaction() throws SQLException {
        try {
            DBConnection.getConnection().setAutoCommit(false);
            DBConnection.showStatusInfo("Transaction started");
        } catch (SQLException e) {
            String errorMsg = "Failed to start transaction: " + e.getMessage();
            System.err.println(errorMsg);
            DBConnection.showStatusError(errorMsg);
            throw e;
        }
    }

    public static void commitTransaction() throws SQLException {
        try {
            DBConnection.getConnection().commit();
            DBConnection.getConnection().setAutoCommit(true);
            DBConnection.showStatusSuccess("Transaction committed successfully");
        } catch (SQLException e) {
            String errorMsg = "Failed to commit transaction: " + e.getMessage();
            System.err.println(errorMsg);
            DBConnection.showStatusError(errorMsg);
            throw e;
        }
    }

    public static void rollbackTransaction() throws SQLException {
        try {
            DBConnection.getConnection().rollback();
            DBConnection.getConnection().setAutoCommit(true);
            DBConnection.showStatusWarning("Transaction rolled back");
        } catch (SQLException e) {
            String errorMsg = "Failed to rollback transaction: " + e.getMessage();
            System.err.println(errorMsg);
            DBConnection.showStatusError(errorMsg);
            throw e;
        }
    }
}