/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Member;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Viet_dz
 */
public class MemberDAL extends ConnectData {

    private final String ADD_MEMBER = "{call addMember(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
    private final String DEL_MEMBER = "delMember @idThanhVien = ?";
    private final String GET_ALL_MEMBERS = "getAllMembers";
    private final String MANAGEMENT_LOGIN = "managementLogin @id = ?, @pass = ?";
    private final String SEARCH_MEMBER = "searchMember @idThanhVien = ?";
    private final String UPDATE_MEMBER = "{call updateMember(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

    CallableStatement call = null;
    PreparedStatement ps = null;

    public boolean addMember(Member mem) {

        try {
            getConnect();
            call = con.prepareCall(ADD_MEMBER);
            call.setString(1, mem.getIdThanhVien());
            call.setString(2, mem.getMatKhau());
            call.setString(3, mem.getHoVaTen());
            call.setString(4, mem.getSoDienThoai());
            call.setString(5, mem.getKhoa());
            call.setString(6, mem.getTruong());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String ngaySinh = null;
            try {
                Date date = formatter.parse(mem.getNgaySinh());
                formatter = new SimpleDateFormat("yyyy/MM/dd");
                ngaySinh = formatter.format(date);
                
            } catch (ParseException ex) {
                Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            call.setString(7, ngaySinh);
            call.setString(8, mem.getQueQuan());
            call.setString(9, mem.getDiaChi());
            call.setString(10, mem.getPhuongTienDi());
            call.setString(11, mem.getDangHoatDong());
            call.setInt(12, mem.getDiem());
            call.setInt(13, mem.getNhom());
            call.registerOutParameter(14, java.sql.Types.INTEGER);

            call.execute();
            if (call.getInt(14) == 0) {
                JOptionPane.showMessageDialog(null, "Them Du Lieu Khong Thanh Cong");
                con.close();
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Done!");
            }
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteMember(String id) {
        try {
            getConnect();
            call = con.prepareCall(DEL_MEMBER);
            call.setString(1, id);
            call.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> all = new ArrayList<>();
        try {
            getConnect();
            ps = con.prepareStatement(GET_ALL_MEMBERS);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Member mem = new Member();
                    mem.setIdThanhVien(rs.getString(1));
                    mem.setMatKhau(rs.getString(2));
                    mem.setHoVaTen(rs.getString(3));
                    mem.setSoDienThoai(rs.getString(4));
                    mem.setKhoa(rs.getString(5));
                    mem.setTruong(rs.getString(6));
                    mem.setNgaySinh(rs.getString(7));
                    mem.setQueQuan(rs.getString(8));
                    mem.setDiaChi(rs.getString(9));
                    mem.setPhuongTienDi(rs.getString(10));
                    mem.setDangHoatDong(rs.getString(11));
                    mem.setDiem(rs.getInt(12));
                    mem.setNhom(rs.getInt(13));
                    all.add(mem);
                }                
            }         
            con.close();            

        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }
    
    public boolean managementLogin(String id, String pass){
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(MANAGEMENT_LOGIN);
            ps.setString(1, id);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next()){
                con.close();
                return true;
            }else {
                con.close();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Member searchMember(String id){
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(SEARCH_MEMBER);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs != null){
                Member mem = new Member();
                while(rs.next()){
                    mem.setIdThanhVien(rs.getString(1));
                    mem.setMatKhau(rs.getString(2));
                    mem.setHoVaTen(rs.getString(3));
                    mem.setSoDienThoai(rs.getString(4));
                    mem.setKhoa(rs.getString(5));
                    mem.setTruong(rs.getString(6));
                    mem.setNgaySinh(rs.getString(7));
                    mem.setQueQuan(rs.getString(8));
                    mem.setDiaChi(rs.getString(9));
                    mem.setPhuongTienDi(rs.getString(10));
                    mem.setDangHoatDong(rs.getString(11));
                    mem.setDiem(rs.getInt(12));
                    mem.setNhom(rs.getInt(13));
                }
                return mem;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean updateMember(Member mem) {
        
        try {
            getConnect();
            call = con.prepareCall(UPDATE_MEMBER);
            call.setString(1, mem.getIdThanhVien());
            call.setString(2, mem.getMatKhau());
            call.setString(3, mem.getHoVaTen());
            call.setString(4, mem.getSoDienThoai());
            call.setString(5, mem.getKhoa());
            call.setString(6, mem.getTruong());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String ngaySinh = null;
            try {
                Date date = formatter.parse(mem.getNgaySinh());
                formatter = new SimpleDateFormat("yyyy/MM/dd");
                ngaySinh = formatter.format(date);
                
            } catch (ParseException ex) {
                Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            call.setString(7, ngaySinh);
            call.setString(8, mem.getQueQuan());
            call.setString(9, mem.getDiaChi());
            call.setString(10, mem.getPhuongTienDi());
            call.setString(11, mem.getDangHoatDong());
            call.setInt(12, mem.getDiem());
            call.setInt(13, mem.getNhom());
            call.registerOutParameter(14, java.sql.Types.INTEGER);

            call.execute();
            if (call.getInt(14) == 0) {
                JOptionPane.showMessageDialog(null, "Sua Du Lieu Khong Thanh Cong");
                con.close();
                return false;
            } else {
                JOptionPane.showMessageDialog(null, "Done!");
            }
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
