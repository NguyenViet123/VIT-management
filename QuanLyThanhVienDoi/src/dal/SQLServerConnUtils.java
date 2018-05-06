/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Viet_dz
 */
public class SQLServerConnUtils {
    
    public static Connection getSQLServerConnection()throws
            SQLException, ClassNotFoundException {
        String hostName = "localhost";
        String database = "QLThanhVienDoi";
        String userName = "sa";
        String password = "sa";
        
        return getSQLServerConnection(hostName, database, userName, password);
                
    }

    private static Connection getSQLServerConnection(String hostName, 
            String database, String userName, String password)           
            throws ClassNotFoundException, SQLException {

         String connectionUrl = "jdbc:sqlserver://" + hostName + ";databaseName=" + database + ";";

        
        Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
        
        return conn;
    }

}
