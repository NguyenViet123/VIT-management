/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythanhviendoi;

import dal.ConnectData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Viet_dz
 */
public class QuanLyThanhVienDoi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        Connection connection = ConnectData.getMyConnection();
        
        Statement stm = connection.createStatement();
        String sql = "select * from thanhvien";
        ResultSet rs = stm.executeQuery(sql);
        
        while(rs.next()){
            System.out.println(rs.getString(1));
        }
        
        
    }
    
}
