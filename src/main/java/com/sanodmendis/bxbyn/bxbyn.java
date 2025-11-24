/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.sanodmendis.bxbyn;

import javax.swing.UIManager;

/**
 *
 * @author Sanod D. Mendis
 */
public class bxbyn {

    public static void main(String[] args) {
        try {
            //UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
            // UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");
        } catch (Exception e) {
            e.printStackTrace();
        }
                
        formLogin login = new formLogin();
        login.setVisible(true);
    }
}
