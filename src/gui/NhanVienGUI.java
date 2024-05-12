package gui;

import bus.QuyenBUS;
import bus.UserBUS;
import dto.NhanVienDTO;
import dto.QuyenDTO;
import dto.UserDTO;
import gui.model.IconModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NhanVienGUI extends JPanel {
    private int width, height;
    private Color colorBackground = Color.decode("#FFFFFF");
    private Color color1 = Color.decode("#006270");
    private Color color2 = Color.decode("#009394");
    private Color color3 = Color.decode("#00E0C7");

    private JPanel pnInfor, pnFilter, pnTable;
    private ArrayList<JPanel> arrPnInfor;
    private ArrayList<JLabel> arrLbInfor;
    private ArrayList<JTextField> arrTfInfor;
    private JLabel lbImgNhanVien;
    private JComboBox cbGioiTinh, cbQuyen;
    private BufferedImage bufferImg = null;
        
    private JTable table;
    private TableRowSorter<TableModel> rowSorter;
    private DefaultTableModel model;
    private String imgNhanVien = "null";
    private UserBUS userBUS = new UserBUS();
    private QuyenBUS quyenBUS = new QuyenBUS();
    
    private boolean isEditing = false;
    
    public NhanVienGUI(int width, int height) {
        this.width = width;
        this.height = height;
        this.init();
    }
    
    public void init() {
        this.setSize(this.width, this.height);
        this.setBackground(this.colorBackground);
        
        this.pnInfor = this.createPnInfor();
        this.pnFilter = this.createPnFilter();
        this.pnTable = this.createPnTable();
        
        this.setLayout(new BorderLayout());
        this.add(this.pnInfor, BorderLayout.NORTH);
        this.add(this.pnFilter, BorderLayout.CENTER);
        this.add(this.pnTable, BorderLayout.SOUTH);
    }
    
    public JPanel createPnInfor() {
        JPanel result = new JPanel(new FlowLayout(1, 0, 25));
        result.setPreferredSize(new Dimension(this.width, 290));
        
        JPanel pn_infor = new JPanel(new BorderLayout());
        pn_infor.setPreferredSize(new Dimension(this.width - 100, 250));
        pn_infor.setBackground(this.color1);
        pn_infor.setBorder(BorderFactory.createLineBorder(color1, 2));
        
        // create panel avatar
        JPanel pn_avatar = new JPanel(new FlowLayout(1, 0, 25));
        pn_avatar.setPreferredSize(new Dimension(250, 250));
        
        this.lbImgNhanVien = new JLabel("Image", JLabel.CENTER);
        this.lbImgNhanVien.setPreferredSize(new Dimension(175, 200));
        this.lbImgNhanVien.setBorder(BorderFactory.createLineBorder(Color.black));
        
        pn_avatar.add(this.lbImgNhanVien);
        
        // create panel description
        JPanel pn_desc = new JPanel(new FlowLayout(1, 15, 10));

        String[] thuoc_tinh = {"Mã nhân viên", "Mật khẩu", "Tên nhân viên", "Số điện thoại"};
        int len = thuoc_tinh.length;
        this.arrPnInfor = new ArrayList<>();
        this.arrLbInfor = new ArrayList<>();
        this.arrTfInfor = new ArrayList<>();
        
        Dimension d_pn = new Dimension(400, 30);
        Dimension d_lb = new Dimension(130, 30);
        Dimension d_tf = new Dimension(220, 30);
        Color color_font = this.color1;
        Font font_infor = new Font("Segoe UI", Font.PLAIN, 15);
        for (int i = 0; i < len; i++) {
            this.arrPnInfor.add(new JPanel(new FlowLayout(0, 0, 0)));
            this.arrPnInfor.get(i).setPreferredSize(d_pn);
            
            this.arrLbInfor.add(new JLabel(thuoc_tinh[i]));
            this.arrLbInfor.get(i).setPreferredSize(d_lb);
            this.arrTfInfor.add(new JTextField());
            this.arrTfInfor.get(i).setPreferredSize(d_tf);

            this.arrLbInfor.get(i).setForeground(color_font);
            this.arrLbInfor.get(i).setFont(font_infor);
            this.arrTfInfor.get(i).setForeground(color_font);
            this.arrTfInfor.get(i).setFont(font_infor);
            
            this.arrPnInfor.get(i).add(this.arrLbInfor.get(i));
            this.arrPnInfor.get(i).add(this.arrTfInfor.get(i));
            pn_desc.add(this.arrPnInfor.get(i));
        }
        this.arrTfInfor.get(0).setEditable(false); // khóa luôn khả năng chỉnh sửa mã nhân viên
        
        JPanel pn_gioi_tinh = new JPanel(new FlowLayout(0, 0, 0));
        pn_gioi_tinh.setPreferredSize(d_pn);
        pn_gioi_tinh.setForeground(color_font);
        pn_gioi_tinh.setFont(font_infor);
        
        JLabel lb_gioitinh = new JLabel("Giới tính");
        lb_gioitinh.setPreferredSize(d_lb);
        lb_gioitinh.setForeground(color_font);
        lb_gioitinh.setFont(font_infor);
        
        String[] gt = {"Nam", "Nữ"};
        this.cbGioiTinh = new JComboBox(gt);
        this.cbGioiTinh.setPreferredSize(d_tf);
        this.cbGioiTinh.setForeground(color_font);
        this.cbGioiTinh.setFont(font_infor);
        
        pn_gioi_tinh.add(lb_gioitinh);
        pn_gioi_tinh.add(this.cbGioiTinh);
        
        JPanel pn_quyen = new JPanel(new FlowLayout(0, 0, 0));
        pn_quyen.setPreferredSize(d_pn);
        pn_quyen.setForeground(color_font);
        pn_quyen.setFont(font_infor);
        
        JLabel lb_quyen = new JLabel("Quyền");
        lb_quyen.setPreferredSize(d_lb);
        lb_quyen.setForeground(color_font);
        lb_quyen.setFont(font_infor);
        
        loadQuyen();
        
        Vector<QuyenDTO> quyen = new Vector<>();
        for (QuyenDTO q : quyenBUS.getQuyenList()) {
            quyen.add(q);
        }
        this.cbQuyen = new JComboBox(quyen);
        this.cbQuyen.setPreferredSize(d_tf);
        this.cbQuyen.setForeground(color_font);
        this.cbQuyen.setFont(font_infor);
        
        pn_quyen.add(lb_quyen);
        pn_quyen.add(this.cbQuyen);
        
        pn_desc.add(pn_gioi_tinh);
        pn_desc.add(pn_quyen);
        
        // create panel button
        JPanel pn_btn = new JPanel(new FlowLayout(1, 25, 10));
        pn_btn.setPreferredSize(new Dimension(200, 250));
        
        // các nút chức năng mặc định
        JButton btn_them = new JButton("Thêm");
        JButton btn_sua = new JButton("Sửa");
        JButton btn_xoa = new JButton("Xóa");
        JButton btn_nhap_excel = new JButton("Nhập Excel");
        JButton btn_xuat_excel = new JButton("Xuất Excel");
        
        // các nút chức năng phụ
        JButton btn_hoan_thanh = new JButton("Hoàn thành");
        JButton btn_tro_ve = new JButton("Trở về");
        JButton btn_chon_anh = new JButton("Chọn ảnh");
        
        // Thiết kế giao diện nút
        Dimension d_btn = new Dimension(150, 30);
        btn_them.setPreferredSize(d_btn);
        btn_sua.setPreferredSize(d_btn);
        btn_xoa.setPreferredSize(d_btn);
        btn_nhap_excel.setPreferredSize(d_btn);
        btn_xuat_excel.setPreferredSize(d_btn);
        
        btn_hoan_thanh.setPreferredSize(d_btn);
        btn_tro_ve.setPreferredSize(d_btn);
        btn_chon_anh.setPreferredSize(d_btn);
        btn_hoan_thanh.setVisible(false);
        btn_tro_ve.setVisible(false);
        btn_chon_anh.setVisible(false);
        
        Color color_button = this.color2;
        btn_them.setBackground(color_button);
        btn_sua.setBackground(color_button);
        btn_xoa.setBackground(color_button);
        btn_nhap_excel.setBackground(color_button);
        btn_xuat_excel.setBackground(color_button);

        btn_hoan_thanh.setBackground(color_button);
        btn_tro_ve.setBackground(color_button);
        btn_chon_anh.setBackground(color_button);
        
        Color color_font_btn = this.colorBackground;
        btn_them.setForeground(color_font_btn);
        btn_sua.setForeground(color_font_btn);
        btn_xoa.setForeground(color_font_btn);
        btn_nhap_excel.setForeground(color_font_btn);
        btn_xuat_excel.setForeground(color_font_btn);

        btn_hoan_thanh.setForeground(color_font_btn);
        btn_tro_ve.setForeground(color_font_btn);
        btn_chon_anh.setForeground(color_font_btn);
        
        Font font_btn = new Font("Segoe UI", Font.BOLD, 13);
        btn_them.setFont(font_btn);
        btn_sua.setFont(font_btn);
        btn_xoa.setFont(font_btn);
        btn_nhap_excel.setFont(font_btn);
        btn_xuat_excel.setFont(font_btn);

        btn_hoan_thanh.setFont(font_btn);
        btn_tro_ve.setFont(font_btn);
        btn_chon_anh.setFont(font_btn);
        
        // thêm các nút
        pn_btn.add(btn_them);
        pn_btn.add(btn_sua);
        pn_btn.add(btn_xoa);
        pn_btn.add(btn_nhap_excel);
        pn_btn.add(btn_xuat_excel);
        pn_btn.add(btn_hoan_thanh);
        pn_btn.add(btn_tro_ve);
        pn_btn.add(btn_chon_anh);
        
        // khi ấn nút thêm
        btn_them.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                blankInfor();
                isEditing = false;
                lockInfor(false);
                
                arrTfInfor.get(0).setText(userBUS.createNewId());
                
                btn_them.setVisible(false);
                btn_sua.setVisible(false);
                btn_xoa.setVisible(false);
                btn_nhap_excel.setVisible(false);
                btn_xuat_excel.setVisible(false);
                
                btn_hoan_thanh.setVisible(true);
                btn_tro_ve.setVisible(true);
                btn_chon_anh.setVisible(true);
                
                table.clearSelection();
                table.setEnabled(false);
            }
        });
        
        // khi ấn nút sửa
        btn_sua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (arrTfInfor.get(0).getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần sửa!");
                    return;
                }
                isEditing = true;
                
                lockInfor(false);
                
                btn_them.setVisible(false);
                btn_sua.setVisible(false);
                btn_xoa.setVisible(false);
                btn_nhap_excel.setVisible(false);
                btn_xuat_excel.setVisible(false);
                
                btn_hoan_thanh.setVisible(true);
                btn_tro_ve.setVisible(true);
                btn_chon_anh.setVisible(true);
                
                table.setEnabled(false);
            }
        });
        
        // khi ấn nút xóa
        btn_xoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (arrTfInfor.get(0).getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhân viên cần xóa!");
                    return;
                }
                
                int confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Alert", JOptionPane.YES_NO_OPTION);
                if (confirmed == 0) { // xác nhận xóa
                    userBUS.deleteUser(arrTfInfor.get(0).getText());
                    blankInfor();
                    table.clearSelection();
                    reloadUser(userBUS.getUserList());
                }
            }
        });
        
        // khi ấn nút hoàn thành
        btn_hoan_thanh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirmed;
                if (isEditing) { // đang trong chế độ sửa
                    confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận sửa nhân viên", "", JOptionPane.YES_NO_OPTION);
                    if (confirmed == 0) { // xác nhận sửa
                        String id = arrTfInfor.get(0).getText();
                        String pass = arrTfInfor.get(1).getText();
                        String ten = arrTfInfor.get(2).getText();
                        String gt = (String) cbGioiTinh.getItemAt(cbGioiTinh.getSelectedIndex());
                        String sdt = arrTfInfor.get(3).getText();
                        QuyenDTO quyenDTO = (QuyenDTO )cbQuyen.getSelectedItem();
                        String quyen = quyenDTO.getIdQuyen();
                        String newImg = imgNhanVien;
                        
                        UserDTO user = new UserDTO(id, pass, ten, gt, sdt, quyen, newImg, true);
                        userBUS.updateUser(user);
                        reloadUser(userBUS.getUserList());
                        
                        saveImg();
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "OK", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else { // đang trong chế độ thêm
                    confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận thêm nhân viên", "", JOptionPane.YES_NO_OPTION);
                    if (confirmed == 0) { // xác nhận thêm
                        String id = arrTfInfor.get(0).getText();
                        String pass = arrTfInfor.get(1).getText();
                        String ten = arrTfInfor.get(2).getText();
                        String gt = (String) cbGioiTinh.getItemAt(cbGioiTinh.getSelectedIndex());
                        String sdt = arrTfInfor.get(3).getText();
                        QuyenDTO quyenDTO = (QuyenDTO )cbQuyen.getSelectedItem();
                        String quyen = quyenDTO.getIdQuyen();
                        String newImg = imgNhanVien;
                        
                        UserDTO user = new UserDTO(id, pass, ten, gt, sdt, quyen, newImg, true);
                        userBUS.addUser(user);
                        reloadUser(userBUS.getUserList());
                        
                        blankInfor();
                    }
                }
            }
        });
        
        // khi ấn nút trở về
        btn_tro_ve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                blankInfor();
                
                // nếu đang trong chế độ sửa khi thoát ra chỉnh isEditing = false
                if (isEditing) isEditing = false;
                
                btn_them.setVisible(true);
                btn_sua.setVisible(true);
                btn_xoa.setVisible(true);
                btn_nhap_excel.setVisible(true);
                btn_xuat_excel.setVisible(true);
                
                btn_hoan_thanh.setVisible(false);
                btn_tro_ve.setVisible(false);
                btn_chon_anh.setVisible(false);
                
                table.setEnabled(true);
            }
        });
        
        // khi ấn nút chọn ảnh
        btn_chon_anh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & PNG images", "jpg", "png");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        File file = fc.getSelectedFile();
                        bufferImg = ImageIO.read(file);
                        // set tên ảnh là tên mã nhân viên
                        imgNhanVien = arrTfInfor.get(0).getText().concat(".png");      

                        lbImgNhanVien.setText("");
                        lbImgNhanVien.setIcon(new ImageIcon(bufferImg.getScaledInstance(200, 250, Image.SCALE_SMOOTH)));
                    } catch (IOException ex) {
                        Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        // add components
        pn_infor.add(pn_avatar, BorderLayout.WEST);
        pn_infor.add(pn_desc, BorderLayout.CENTER);
        pn_infor.add(pn_btn, BorderLayout.EAST);
        
        result.add(pn_infor);
        
        return result;
    }
    
    public JPanel createPnFilter() {
        JPanel pn_filter = new JPanel(new FlowLayout(1, 20, 20)); 
        
        // Thanh tìm kiếm theo tên hoặc id nhân viên
        JLabel lb_tim_kiem = new JLabel("Tìm kiếm", JLabel.CENTER);
        JTextField tf_tim_kiem = new JTextField();
        tf_tim_kiem.setPreferredSize(new Dimension(200, 30));
        tf_tim_kiem.getDocument().addDocumentListener(new DocumentListener() { 
            @Override
            public void insertUpdate(DocumentEvent e) {
                String txt = tf_tim_kiem.getText();
                if (txt.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else if (txt.trim().length() >= 2 && txt.trim().substring(0, 2).toUpperCase().equals("NV")) {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + txt, 0));                    
                } 
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^"+ txt +".*", 1));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String txt = tf_tim_kiem.getText();
                if (txt.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else if (txt.trim().length() >= 2 && txt.trim().substring(0, 2).toUpperCase().equals("NV")) {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^" + txt, 0));                    
                } 
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)^"+ txt +".*", 1));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               
            }
        });
        
        // Khu lọc theo một số thuộc tính giới tính
        JLabel lb_gioitinh = new JLabel("Giới tính", JLabel.CENTER);
        String[] gioitinh = {"Nam","Nữ"};    
        JComboBox cb_gioitinh = new JComboBox(gioitinh);
        cb_gioitinh.setPreferredSize(new Dimension(100, 30));
        
        // tạo thêm thuộc tính ngày sinh hoặc đổi sang tìm kiếm theo địa chỉ
        JLabel lb_ngaysinh = new JLabel("Ngày sinh", JLabel.CENTER);
        JTextField tf_ngaysinh = new JTextField();
        tf_ngaysinh.setPreferredSize(new Dimension(150, 30));
        
        JButton btn_loc = new JButton("Lọc");
        btn_loc.setPreferredSize(new Dimension(100, 30));
        
        btn_loc.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                String gioitinh = (String) cb_gioitinh.getItemAt(cb_gioitinh.getSelectedIndex());
//               reloadNV(nhanvienBUS.filter(gioitinh));
            }
        });
        
        //
        Font font_filter = new Font("Segoe UI", Font.BOLD, 13);
        
        lb_tim_kiem.setFont(font_filter);
        tf_tim_kiem.setFont(font_filter);
        lb_gioitinh.setFont(font_filter);
        cb_gioitinh.setFont(font_filter);
        lb_ngaysinh.setFont(font_filter);
        tf_ngaysinh.setFont(font_filter);
        
        lb_tim_kiem.setForeground(color1);
        tf_tim_kiem.setForeground(color1);
        lb_gioitinh.setForeground(color1);
        cb_gioitinh.setForeground(color1);
        lb_ngaysinh.setForeground(color1);
        tf_ngaysinh.setForeground(color1);
        
        btn_loc.setBackground(color2);
        btn_loc.setFont(font_filter);
        btn_loc.setForeground(this.colorBackground);
        
        pn_filter.add(lb_tim_kiem);
        pn_filter.add(tf_tim_kiem);
        pn_filter.add(lb_gioitinh);
        pn_filter.add(cb_gioitinh);
        pn_filter.add(lb_ngaysinh);
        pn_filter.add(tf_ngaysinh);
        pn_filter.add(btn_loc);
        
        return pn_filter;
    }
    
    public JPanel createPnTable() {
        JPanel pn_table = new JPanel(new FlowLayout(1, 0, 0));
        pn_table.setPreferredSize(new Dimension(this.width, 290));
        
        String[] col = {
            "Mã nhân viên", "Mật khẩu", "Tên nhân viên", "Giới tính", "SĐT", "Quyền", "IMG"
        };
        this.model = new DefaultTableModel(col, 0);
        this.table = new JTable();
        rowSorter = new TableRowSorter<TableModel>(model);
        this.table.setModel(model);
        this.table.setRowSorter(rowSorter);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(900, 250));
        
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(40);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(20);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setPreferredWidth(50);
        table.getColumnModel().getColumn(6).setPreferredWidth(50);
        
        this.loadUser();
        
        pn_table.add(scroll);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (table.getRowSorter() != null) {
                    row = table.getRowSorter().convertRowIndexToModel(row);
                }
                imgNhanVien = table.getModel().getValueAt(row, 6).toString();
                IconModel icon_nv = new IconModel(175, 200, "NhanVien/" + imgNhanVien);
                
                // set thông tin cho sản phẩm
                arrTfInfor.get(0).setText(table.getModel().getValueAt(row, 0).toString());
                arrTfInfor.get(1).setText(table.getModel().getValueAt(row, 1).toString());
                arrTfInfor.get(2).setText(table.getModel().getValueAt(row, 2).toString());
                arrTfInfor.get(3).setText(table.getModel().getValueAt(row, 4).toString());
                cbGioiTinh.setSelectedItem(table.getModel().getValueAt(row, 3).toString());
                cbQuyen.setSelectedItem(table.getModel().getValueAt(row, 5).toString());
                lbImgNhanVien.setText("");
                lbImgNhanVien.setIcon(icon_nv.createIcon());

               
                
                if (isEditing) {
                    lockInfor(false);
                }
                else lockInfor(true);
            }
        });
        
        // giao diện table
        Font font_table = new Font("Segoe UI", Font.BOLD, 13);
        table.getTableHeader().setBackground(color1);
        table.getTableHeader().setFont(font_table);
        table.getTableHeader().setForeground(this.colorBackground);
        table.getTableHeader().setOpaque(false); 
        table.getTableHeader().setBorder(BorderFactory.createLineBorder(this.color1));
        
        // căn giữa các chữ trong ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int i = 0; i < col.length; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        table.setFocusable(false);
        table.setShowVerticalLines(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setFillsViewportHeight(true);
        table.setSelectionBackground(color3);
        table.setRowHeight(30);
        table.setBorder(BorderFactory.createLineBorder(this.color1));
        
        return pn_table;
    }
    
    public void loadUser() {
        if (userBUS.getUserList()== null) {
            userBUS.list();
        }
        ArrayList<UserDTO> userList = userBUS.getUserList();
        model.setRowCount(0);
        reloadUser(userList);
    }
    
    public void reloadUser(ArrayList<UserDTO> userList) {
        model.setRowCount(0);
        for (UserDTO us : userList) {
            if (us.isEnable()) {
                model.addRow(new Object[]{
                    us.getIdUser(), us.getPassword(), us.getTenUser(), us.getGioiTinh(), us.getSdt(), us.getQuyen(), us.getImgUser()
                });
            }
        }
    }
    
    public void loadQuyen() {
        if (quyenBUS.getQuyenList() == null) {
            quyenBUS.list();
        }
    }
    
    public void saveImg() {
        try {
            if (bufferImg != null) {
                File save = new File("src/img/NhanVien/" + imgNhanVien);
                ImageIO.write(bufferImg, "png", save);
                bufferImg = null;
            }
        } catch (IOException ex) {
            Logger.getLogger(NhanVienGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // khóa khả năng thao tác với thông tin
    public void lockInfor(boolean lock) {
        arrTfInfor.get(1).setEditable(!lock);
        arrTfInfor.get(2).setEditable(!lock);
        arrTfInfor.get(3).setEditable(!lock);    
        cbGioiTinh.setEnabled(!lock);
        cbQuyen.setEnabled(!lock);
    }
    
    public void blankInfor() {
        arrTfInfor.get(0).setText("");
        arrTfInfor.get(1).setText("");
        arrTfInfor.get(2).setText("");
        arrTfInfor.get(3).setText("");
        lbImgNhanVien.setIcon(null);
        lbImgNhanVien.setText("Image");
        imgNhanVien = "null";
    }
    
}
