/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Viet_dz
 */
public class ConnectData {
    Connection con = null;
    public void getConnect(){
        try {
            con = SQLServerConnUtils.getSQLServerConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    //Test
    public static void main(String[] args) {
        System.out.println("Get connection...");
        
        ConnectData conn = new ConnectData();
        conn.getConnect();
        
        System.out.println("Get connection " + conn);
        System.out.println("Done");
    }
}
