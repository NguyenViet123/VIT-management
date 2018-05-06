/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.MemberBLL;
import bll.ProgramBLL;
import entity.Member;
import entity.Program;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Viet_dz
 */
public class Manager extends javax.swing.JFrame {

    /**
     * Creates new form ManagerMembers
     */
    final static int ADD_PROGRAM = 1;
    final static int UPDATE_PROGRAM = 2;
    final static int DELETE_PROGRAM = 3;
    int programOption = 0;
    private ArrayList<Member> allMembers;
    private ArrayList<Program> allPrograms;
    private MemberBLL membll;
    private ProgramBLL probll;
    SearchMember sm;

    public Manager() {
        initComponents();
        btnDone.setVisible(false);
        btnCancel.setVisible(false);
        btnProgramDone.setVisible(false);
        btnProgramCancel.setVisible(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        membll = new MemberBLL();
        probll = new ProgramBLL();
        builMember();
        builProgram();

    }

    public void builProgram() {
        allPrograms = probll.getAllProgram();
        Vector cols = new Vector();
        cols.add("ID CHUONG TRINH");
        cols.add("TEN CHUONG TRINH");
        cols.add("THOI GIAN DIEN RA");
        cols.add("ID PHU TRACH");

        Vector data = new Vector();
        for (Program pro : allPrograms) {
            Vector row = new Vector();
            row.add(pro.getIdChuongTrinh());
            row.add(pro.getTenChuongTrinh());
            row.add(pro.getThoiGian());
            row.add(pro.getIdPhuTrach());
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, cols);
        tbProgram.setModel(model);
    }

    public void builMember() {
        allMembers = membll.getAllMember();
        Vector cols = new Vector();
        cols.add("ID THANH VIEN");
        cols.add("HO VA TEN");
        cols.add("SO DIEN THOAI");
        cols.add("PHUONG TIEN DI");

        Vector data = new Vector();
        for (Member m : allMembers) {
            Vector row = new Vector();
            row.add(m.getIdThanhVien());
            row.add(m.getHoVaTen());
            row.add(m.getSoDienThoai());
            row.add(m.getPhuongTienDi());
            data.add(row);
        }
        DefaultTableModel model = new DefaultTableModel(data, cols);
        tbMembers.setModel(model);

    }

    public void clearTextProgram() {
        tfProgramId.setText("");
        tfProgramName.setText("");
        tfProgramDate.setText("");
        tfProgramAddress.setText("");
        tfProgramIdManager.setText("");
        tfProgramMemberNumber.setText("");
    }

    public void clearTextMember() {
        tfIdMember.setText("");
        tfPass.setText("");
        tfName.setText("");
        tfContact.setText("");
        tfKey.setText("");
        tfSchool.setText("");
        tfDateOfBirth.setText("");
        tfAddress.setText("");
        tfOriginal.setText("");
        tfIsActive.setText("");
        tfPoint.setText("");
        tfGroup.setText("");
        tfVehicle.setText("");
    }

    public void searchProgram(String search) {
        Program pro = probll.searchProgram(search);
        Vector cols = new Vector();
        cols.add("ID CHUONG TRINH");
        cols.add("TEN CHUONG TRINH");
        cols.add("THOI GIAN DIEN RA");
        cols.add("ID PHU TRACH");

        Vector data = new Vector();
        Vector row = new Vector();
        row.add(pro.getIdChuongTrinh());
        row.add(pro.getTenChuongTrinh());
        row.add(pro.getThoiGian());
        row.add(pro.getIdPhuTrach());
        data.add(row);

        DefaultTableModel model = new DefaultTableModel(data, cols);
        tbProgram.setModel(model);
    }

    public void searchMember(String search) {
        Member m = membll.searchMember(search);
        Vector cols = new Vector();
        cols.add("ID THANH VIEN");
        cols.add("HO VA TEN");
        cols.add("SO DIEN THOAI");
        cols.add("PHUONG TIEN DI");

        Vector data = new Vector();
        Vector row = new Vector();
        row.add(m.getIdThanhVien());
        row.add(m.getHoVaTen());
        row.add(m.getSoDienThoai());
        row.add(m.getPhuongTienDi());
        data.add(row);

        DefaultTableModel model = new DefaultTableModel(data, cols);
        tbMembers.setModel(model);
    }

    public void addMember() {
        Member m = new Member();

        m.setIdThanhVien(tfIdMember.getText());
        m.setMatKhau(tfPass.getText());
        m.setNgaySinh(tfDateOfBirth.getText());
        m.setDangHoatDong(tfIsActive.getText());
        m.setDiaChi(tfAddress.getText());
        m.setDiem(Integer.parseInt(tfPoint.getText()));
        m.setHoVaTen(tfName.getText());
        m.setKhoa(tfKey.getText());
        m.setNhom(Integer.parseInt(tfGroup.getText()));
        m.setPhuongTienDi(tfVehicle.getText());
        m.setQueQuan(tfOriginal.getText());
        m.setSoDienThoai(tfContact.getText());
        m.setTruong(tfSchool.getText());

        membll.addMember(m);
    }

    public void addProgram() {
        Program pro = new Program();

        pro.setIdChuongTrinh(tfProgramId.getText());
        pro.setTenChuongTrinh(tfProgramName.getText());
        pro.setThoiGian(tfProgramDate.getText());
        pro.setDiaDiem(tfProgramAddress.getText());
        pro.setIdPhuTrach(tfProgramIdManager.getText());
        pro.setSoLuongTNV(Integer.parseInt(tfProgramMemberNumber.getText()));

        probll.addProgram(pro);
    }

    public void updateMember() {
        Member m = new Member();

        m.setIdThanhVien(tfIdMember.getText());
        m.setMatKhau(tfPass.getText());
        m.setNgaySinh(tfDateOfBirth.getText());
        m.setDangHoatDong(tfIsActive.getText());
        m.setDiaChi(tfAddress.getText());
        m.setDiem(Integer.parseInt(tfPoint.getText()));
        m.setHoVaTen(tfName.getText());
        m.setKhoa(tfKey.getText());
        m.setNhom(Integer.parseInt(tfGroup.getText()));
        m.setPhuongTienDi(tfVehicle.getText());
        m.setQueQuan(tfOriginal.getText());
        m.setSoDienThoai(tfContact.getText());
        m.setTruong(tfSchool.getText());

        membll.updateMember(m);
    }

    public void updateProgram() {
        Program pro = new Program();

        pro.setIdChuongTrinh(tfProgramId.getText());
        pro.setTenChuongTrinh(tfProgramName.getText());
        pro.setThoiGian(tfProgramDate.getText());
        pro.setDiaDiem(tfProgramAddress.getText());
        pro.setIdPhuTrach(tfProgramIdManager.getText());
        pro.setSoLuongTNV(Integer.parseInt(tfProgramMemberNumber.getText()));

        probll.updateProgram(pro);
    }

    public void deleteProgram(String id) {
        probll.deleteProgram(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tfIsActive = new javax.swing.JTextField();
        tfPoint = new javax.swing.JTextField();
        tfGroup = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMembers = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfIdMember = new javax.swing.JTextField();
        tfPass = new javax.swing.JTextField();
        tfContact = new javax.swing.JTextField();
        tfKey = new javax.swing.JTextField();
        tfSchool = new javax.swing.JTextField();
        tfDateOfBirth = new javax.swing.JTextField();
        tfOriginal = new javax.swing.JTextField();
        tfAddress = new javax.swing.JTextField();
        tfVehicle = new javax.swing.JTextField();
        btnAddMember = new javax.swing.JButton();
        btnEditMember = new javax.swing.JButton();
        btnDelMember = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        btnSearchMember = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfProgramId = new javax.swing.JTextField();
        tfProgramName = new javax.swing.JTextField();
        tfProgramDate = new javax.swing.JTextField();
        tfProgramAddress = new javax.swing.JTextField();
        tfProgramIdManager = new javax.swing.JTextField();
        tfProgramMemberNumber = new javax.swing.JTextField();
        btnProgramAdd = new javax.swing.JButton();
        btnProgramUpdate = new javax.swing.JButton();
        btnProgramDel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProgram = new javax.swing.JTable();
        btnProgramDone = new javax.swing.JButton();
        btnProgramCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("QUẢN LÝ ĐỘI SVTN VIỆN CNTT&TT");

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTabbedPane1.setForeground(new java.awt.Color(255, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tbMembers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbMembers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMembersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbMembers);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID THÀNH VIÊN");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("MẬT KHẨU");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("HỌ VÀ TÊN");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("KHÓA");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TRƯỜNG");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("NGÀY SINH");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("QUÊ QUÁN");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ĐỊA CHỈ HIỆN TẠI");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("PHƯƠNG TIỆN ĐI LẠI");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("ĐANG HOẠT ĐỘNG");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("ĐIỂM ");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("NHÓM");

        tfIdMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdMemberActionPerformed(evt);
            }
        });

        btnAddMember.setBackground(new java.awt.Color(255, 255, 255));
        btnAddMember.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAddMember.setText("Thêm");
        btnAddMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMemberActionPerformed(evt);
            }
        });

        btnEditMember.setBackground(new java.awt.Color(255, 255, 255));
        btnEditMember.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEditMember.setText("Sửa");
        btnEditMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditMemberActionPerformed(evt);
            }
        });

        btnDelMember.setBackground(new java.awt.Color(255, 255, 255));
        btnDelMember.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelMember.setText("Xóa");
        btnDelMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelMemberActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("SỐ ĐIỆN THOẠI");

        btnSearchMember.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchMember.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSearchMember.setText("Tìm kiếm");
        btnSearchMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMemberActionPerformed(evt);
            }
        });

        btnDone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDone.setText("Hoàn tất");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Hủy");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfIdMember)
                                        .addComponent(tfPass)
                                        .addComponent(tfDateOfBirth)
                                        .addComponent(tfSchool, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfName)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfKey, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfAddress)
                            .addComponent(tfVehicle)
                            .addComponent(tfIsActive)
                            .addComponent(tfPoint)
                            .addComponent(tfGroup)
                            .addComponent(tfOriginal, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfContact, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnAddMember)
                .addGap(63, 63, 63)
                .addComponent(btnEditMember, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelMember)
                .addGap(47, 47, 47)
                .addComponent(btnCancel)
                .addGap(58, 58, 58)
                .addComponent(btnSearchMember, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfIdMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(tfContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfSchool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tfOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfIsActive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tfPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tfGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddMember)
                    .addComponent(btnEditMember)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelMember)
                        .addComponent(btnSearchMember)
                        .addComponent(btnDone)
                        .addComponent(btnCancel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("THÔNG TIN THÀNH VIÊN", jPanel1);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("ID CHƯƠNG TRÌNH");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("TÊN CHƯƠNG TRÌNH");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("THỜI GIAN");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("ĐỊA ĐIỂM");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("ID PHỤ TRÁCH");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("SỐ LƯỢNG THÀNH VIÊN");

        tfProgramId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProgramIdActionPerformed(evt);
            }
        });

        tfProgramAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProgramAddressActionPerformed(evt);
            }
        });

        tfProgramMemberNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfProgramMemberNumberActionPerformed(evt);
            }
        });

        btnProgramAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnProgramAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProgramAdd.setText("Thêm");
        btnProgramAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramAddActionPerformed(evt);
            }
        });

        btnProgramUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnProgramUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProgramUpdate.setText("Sửa");
        btnProgramUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramUpdateActionPerformed(evt);
            }
        });

        btnProgramDel.setBackground(new java.awt.Color(255, 255, 255));
        btnProgramDel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProgramDel.setText("Xóa");
        btnProgramDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramDelActionPerformed(evt);
            }
        });

        tbProgram.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbProgram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProgramMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProgram);

        btnProgramDone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProgramDone.setText("Hoàn tất");
        btnProgramDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramDoneActionPerformed(evt);
            }
        });

        btnProgramCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnProgramCancel.setText("Hủy");
        btnProgramCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfProgramId)
                            .addComponent(tfProgramName)
                            .addComponent(tfProgramDate)
                            .addComponent(tfProgramAddress)
                            .addComponent(tfProgramIdManager)
                            .addComponent(tfProgramMemberNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(btnProgramAdd)
                        .addGap(49, 49, 49)
                        .addComponent(btnProgramUpdate)
                        .addGap(58, 58, 58)
                        .addComponent(btnProgramDel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btnProgramDone)
                        .addGap(33, 33, 33)
                        .addComponent(btnProgramCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(tfProgramId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tfProgramName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(tfProgramDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tfProgramAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(tfProgramIdManager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(tfProgramMemberNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProgramAdd)
                            .addComponent(btnProgramUpdate)
                            .addComponent(btnProgramDel))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnProgramDone)
                            .addComponent(btnProgramCancel)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("THÔNG TIN CHƯƠNG TRÌNH", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(347, 347, 347)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfProgramMemberNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProgramMemberNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProgramMemberNumberActionPerformed

    private void tfProgramAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProgramAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProgramAddressActionPerformed

    private void tfIdMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdMemberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdMemberActionPerformed

    private void btnAddMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMemberActionPerformed
        // TODO add your handling code here:
        btnDone.setVisible(true);
        btnCancel.setVisible(true);
        btnDelMember.setVisible(false);
        btnEditMember.setVisible(false);
        btnSearchMember.setVisible(false);

        btnAddMember.setEnabled(false);
        clearTextMember();
    }//GEN-LAST:event_btnAddMemberActionPerformed

    private void btnSearchMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMemberActionPerformed
        // TODO add your handling code here:
        sm = new SearchMember(this);
        btnCancel.setVisible(true);

        btnAddMember.setVisible(false);
        btnEditMember.setVisible(false);
        btnDelMember.setVisible(false);
        btnSearchMember.setVisible(false);
    }//GEN-LAST:event_btnSearchMemberActionPerformed

    private void tbMembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMembersMouseClicked
        // TODO add your handling code here:
        if (tbMembers.getSelectedRow() > -1) {
            int row = tbMembers.getSelectedRow();
            String idSeleced = tbMembers.getModel().getValueAt(row, 0).toString();
            allMembers = membll.getAllMember();
            Member mem = null;
            for (Member m : allMembers) {
                if (m.getIdThanhVien().equals(idSeleced)) {
                    mem = m;
                }
            }
//            Member mem = allMembers.get();
            tfIdMember.setText(mem.getIdThanhVien());
            tfPass.setText(mem.getMatKhau());
            tfName.setText(mem.getHoVaTen());
            tfContact.setText(mem.getSoDienThoai());
            tfKey.setText(mem.getKhoa());
            tfSchool.setText(mem.getTruong());
            tfDateOfBirth.setText(mem.getNgaySinh());
            tfAddress.setText(mem.getDiaChi());
            tfOriginal.setText(mem.getQueQuan());
            tfIsActive.setText(mem.getDangHoatDong());
            tfPoint.setText("" + mem.getDiem());
            tfGroup.setText("" + mem.getNhom());
            tfVehicle.setText(mem.getPhuongTienDi());

        }
    }//GEN-LAST:event_tbMembersMouseClicked

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        // TODO add your handling code here:

        if (tfAddress.getText().isEmpty() || tfContact.getText().isEmpty()
                || tfDateOfBirth.getText().isEmpty() || tfGroup.getText().isEmpty()
                || tfIdMember.getText().isEmpty() || tfIsActive.getText().isEmpty()
                || tfKey.getText().isEmpty() || tfName.getText().isEmpty()
                || tfOriginal.getText().isEmpty() || tfPass.getText().isEmpty()
                || tfPoint.getText().isEmpty() || tfSchool.getText().isEmpty()
                || tfVehicle.getText().isEmpty()) {

        } else {

            if (btnAddMember.isVisible()) {
                addMember();
            } else if (btnEditMember.isVisible()) {
                updateMember();
            }

            btnDone.setVisible(false);
            btnCancel.setVisible(false);

            btnDelMember.setVisible(true);
            btnEditMember.setVisible(true);
            btnSearchMember.setVisible(true);
            btnAddMember.setVisible(true);

            btnAddMember.setEnabled(true);
            btnEditMember.setEnabled(true);
            btnDelMember.setEnabled(true);
            btnSearchMember.setEnabled(true);

            builMember();
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnEditMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditMemberActionPerformed
        // TODO add your handling code here:
        btnDone.setVisible(true);
        btnCancel.setVisible(true);
        btnDelMember.setVisible(false);
        btnAddMember.setVisible(false);
        btnSearchMember.setVisible(false);

        btnEditMember.setEnabled(false);
        clearTextMember();

    }//GEN-LAST:event_btnEditMemberActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        btnAddMember.setVisible(true);
        btnEditMember.setVisible(true);
        btnDelMember.setVisible(true);
        btnSearchMember.setVisible(true);

        btnDone.setVisible(false);
        btnCancel.setVisible(false);

        btnAddMember.setEnabled(true);
        btnEditMember.setEnabled(true);
        btnDelMember.setEnabled(true);
        btnSearchMember.setEnabled(true);
        clearTextMember();
        builMember();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDelMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelMemberActionPerformed
        // TODO add your handling code here:
        if (!tfIdMember.getText().isEmpty()) {
            int option = JOptionPane.showConfirmDialog(null, "Ban muon xoa: " + tfIdMember.getText(), " ", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                membll.deleteMember(tfIdMember.getText());
                builMember();
            }
        }

    }//GEN-LAST:event_btnDelMemberActionPerformed

    private void tfProgramIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfProgramIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfProgramIdActionPerformed

    private void tbProgramMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProgramMouseClicked
        // TODO add your handling code here:
        if (tbProgram.getSelectedRow() > -1) {
            int row = tbProgram.getSelectedRow();
            String idSeleced = tbProgram.getModel().getValueAt(row, 0).toString();
            allPrograms = probll.getAllProgram();
            Program pro = null;
            for (Program m : allPrograms) {
                if (m.getIdChuongTrinh().equals(idSeleced)) {
                    pro = m;
                }
            }
            tfProgramId.setText(pro.getIdChuongTrinh());
            tfProgramName.setText(pro.getTenChuongTrinh());
            tfProgramDate.setText(pro.getThoiGian());
            tfProgramAddress.setText(pro.getDiaDiem());
            tfProgramIdManager.setText(pro.getIdPhuTrach());
            tfProgramMemberNumber.setText("" + pro.getSoLuongTNV());

        }
    }//GEN-LAST:event_tbProgramMouseClicked

    private void btnProgramAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramAddActionPerformed
        // TODO add your handling code here:
        clearTextProgram();
        btnProgramAdd.setEnabled(false);
        btnProgramDel.setEnabled(false);
        btnProgramUpdate.setEnabled(false);
        btnProgramDone.setVisible(true);
        btnProgramCancel.setVisible(true);
        programOption = ADD_PROGRAM;
    }//GEN-LAST:event_btnProgramAddActionPerformed

    private void btnProgramDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramDoneActionPerformed
        // TODO add your handling code here:
        if (tfProgramId.getText().isEmpty()
                || tfProgramName.getText().isEmpty()
                || tfProgramDate.getText().isEmpty()
                || tfProgramAddress.getText().isEmpty()
                || tfProgramIdManager.getText().isEmpty()
                || tfProgramMemberNumber.getText().isEmpty()) {

        } else {
            if (programOption == ADD_PROGRAM) {
                addProgram();
            } else if (programOption == UPDATE_PROGRAM) {
                updateProgram();
            }
            clearTextProgram();
            builProgram();
            btnProgramAdd.setEnabled(true);
            btnProgramDel.setEnabled(true);
            btnProgramUpdate.setEnabled(true);
            btnProgramDone.setVisible(false);
            btnProgramCancel.setVisible(false);
        }

    }//GEN-LAST:event_btnProgramDoneActionPerformed

    private void btnProgramDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramDelActionPerformed
        // TODO add your handling code here:

        if (!tfProgramId.getText().isEmpty()) {
            int op = JOptionPane.showConfirmDialog(null, "Ban muon xoa: " + tfProgramId.getText(), "", JOptionPane.YES_NO_OPTION);
            if (op == JOptionPane.YES_OPTION) {
                deleteProgram(tfProgramId.getText());
                clearTextProgram();
                builProgram();
            }
        }
    }//GEN-LAST:event_btnProgramDelActionPerformed

    private void btnProgramUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramUpdateActionPerformed
        // TODO add your handling code here:
        clearTextProgram();
        btnProgramAdd.setEnabled(false);
        btnProgramDel.setEnabled(false);
        btnProgramUpdate.setEnabled(false);
        btnProgramDone.setVisible(true);
        btnProgramCancel.setVisible(true);
        programOption = UPDATE_PROGRAM;
    }//GEN-LAST:event_btnProgramUpdateActionPerformed

    private void btnProgramCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramCancelActionPerformed
        // TODO add your handling code here:
        clearTextProgram();
        builProgram();
        btnProgramAdd.setEnabled(true);
        btnProgramDel.setEnabled(true);
        btnProgramUpdate.setEnabled(true);
        btnProgramDone.setVisible(false);
        btnProgramCancel.setVisible(false);
    }//GEN-LAST:event_btnProgramCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMember;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelMember;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnEditMember;
    private javax.swing.JButton btnProgramAdd;
    private javax.swing.JButton btnProgramCancel;
    private javax.swing.JButton btnProgramDel;
    private javax.swing.JButton btnProgramDone;
    private javax.swing.JButton btnProgramUpdate;
    private javax.swing.JButton btnSearchMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbMembers;
    private javax.swing.JTable tbProgram;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfContact;
    private javax.swing.JTextField tfDateOfBirth;
    private javax.swing.JTextField tfGroup;
    private javax.swing.JTextField tfIdMember;
    private javax.swing.JTextField tfIsActive;
    private javax.swing.JTextField tfKey;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfOriginal;
    private javax.swing.JTextField tfPass;
    private javax.swing.JTextField tfPoint;
    private javax.swing.JTextField tfProgramAddress;
    private javax.swing.JTextField tfProgramDate;
    private javax.swing.JTextField tfProgramId;
    private javax.swing.JTextField tfProgramIdManager;
    private javax.swing.JTextField tfProgramMemberNumber;
    private javax.swing.JTextField tfProgramName;
    private javax.swing.JTextField tfSchool;
    private javax.swing.JTextField tfVehicle;
    // End of variables declaration//GEN-END:variables
}
