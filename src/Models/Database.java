/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Quan's PC
 */
public class Database {
    public static Connection getConnection() throws SQLException{
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crs_db?useSSL=false", "root","");
        
            if(conn!=null)
                System.out.println("Connection established");
            else{
                System.out.println("No database found");
            } 
        return conn;
    }
}
