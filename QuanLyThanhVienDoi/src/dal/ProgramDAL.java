/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import entity.Member;
import entity.Program;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ProgramDAL extends ConnectData {

    private final String ADD_PROGRAM = "{call addProgram(?,?,?,?,?,?,?)}";
    private final String DEL_PROGRAM = "delProgram @idChuongTrinh = ?";
    private final String GET_ALL_PROGRAMS = "getAllPrograms";
    private final String SEARCH_PROGRAM = "searchProgram @idChuongTrinh = ?";
    private final String UPDATE_PROGRAM = "{call updateProgram(?,?,?,?,?,?,?)}";

    CallableStatement call = null;
    PreparedStatement ps = null;

    public boolean addProgram(Program pro) {

        try {
            getConnect();
            call = con.prepareCall(ADD_PROGRAM);
            call.setString(1, pro.getIdChuongTrinh());
            call.setString(2, pro.getTenChuongTrinh());

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String thoiGian = null;
            try {
                Date date = formatter.parse(pro.getThoiGian());
                formatter = new SimpleDateFormat("yyyy/MM/dd");
                thoiGian = formatter.format(date);

            } catch (ParseException ex) {
                Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
            }

            call.setString(3, thoiGian);
            call.setString(4, pro.getDiaDiem());
            call.setString(5, pro.getIdPhuTrach());
            call.setInt(6, pro.getSoLuongTNV());

            call.registerOutParameter(7, java.sql.Types.INTEGER);

            call.execute();
            if (call.getInt(7) == 0) {
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

    public boolean deleteProgram(String id) {
        try {
            getConnect();
            call = con.prepareCall(DEL_PROGRAM);
            call.setString(1, id);
            call.execute();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<Program> getAllPrograms() {
        ArrayList<Program> all = new ArrayList<>();
        try {
            getConnect();
            ps = con.prepareStatement(GET_ALL_PROGRAMS);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Program pro = new Program();
                    pro.setIdChuongTrinh(rs.getString(1));
                    pro.setTenChuongTrinh(rs.getString(2));
                    pro.setThoiGian(rs.getString(3));
                    pro.setDiaDiem(rs.getString(4));
                    pro.setIdPhuTrach(rs.getString(5));
                    pro.setSoLuongTNV(Integer.parseInt(rs.getString(6)));

                    all.add(pro);
                }
            }
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all;
    }

    public Program searchProgram(String id) {
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(SEARCH_PROGRAM);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                Program proc = new Program();
                while (rs.next()) {

                    proc.setIdChuongTrinh(rs.getString(1));
                    proc.setTenChuongTrinh(rs.getString(2));
                    proc.setThoiGian(rs.getString(3));
                    proc.setDiaDiem(rs.getString(4));
                    proc.setIdPhuTrach(rs.getString(5));
                    proc.setSoLuongTNV(Integer.parseInt(rs.getString(6)));
                }
                return proc;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateProgram(Program pro) {

        try {
            getConnect();
            call = con.prepareCall(UPDATE_PROGRAM);
            call.setString(1, pro.getIdChuongTrinh());
            call.setString(2, pro.getTenChuongTrinh());

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String thoiGian = null;
            try {
                Date date = formatter.parse(pro.getThoiGian());
                formatter = new SimpleDateFormat("yyyy/MM/dd");
                thoiGian = formatter.format(date);

            } catch (ParseException ex) {
                Logger.getLogger(MemberDAL.class.getName()).log(Level.SEVERE, null, ex);
            }

            call.setString(3, thoiGian);
            call.setString(4, pro.getDiaDiem());
            call.setString(5, pro.getIdPhuTrach());
            call.setInt(6, pro.getSoLuongTNV());
            call.registerOutParameter(7, java.sql.Types.INTEGER);
            
            call.execute();
            if (call.getInt(7) == 0) {
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
