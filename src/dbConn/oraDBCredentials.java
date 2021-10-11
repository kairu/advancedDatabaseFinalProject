package dbConn;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author kevin
 */
public class oraDBCredentials {
    public static final String USER = "dummy"; //Database Username
    public static final String PASS = "dummy"; //Your Account Password
    public static final String DATABASE = "ORCLCDB.localdomain"; //Database Name
    public static final String SERVER_IP = "localhost"; //Your Database Server IP (run ipconfig in cmd)
    public static final String PORT = "1521";
    public static final String DB_URL = "jdbc:oracle:thin:@//" + SERVER_IP + ":" + PORT + "/" +DATABASE;    
    
    //Create a connection object
    public Connection conn = null;
    public Statement stmt = null;
}
