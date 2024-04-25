package gui;

import bus.SanPhamBUS;
import dto.SanPhamDTO;
import gui.model.IconModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
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

public class SanPhamGUI extends JPanel {
    private int width, height;
    private Color colorBackground = Color.decode("#FFFFFF");
    private Color color1 = Color.decode("#006270");
    private Color color2 = Color.decode("#009394");
    private Color color3 = Color.decode("#00E0C7");

    private JPanel pnInfor, pnFilter, pnTable;
    private ArrayList<JPanel> arrPnInfor;
    private ArrayList<JLabel> arrLbInfor;
    private ArrayList<JTextField> arrTfInfor;
    private JLabel lbImgSanPham;
    private JComboBox cbBrand;
    private BufferedImage bufferImg = null;
        
    private JTable table;
    private TableRowSorter<TableModel> rowSorter;
    private DefaultTableModel model;
    private SanPhamBUS sanPhamBUS = new SanPhamBUS();
    private String imgSanPham = "null";
    
    private boolean isEditing = false; // true = đang trong chế độ sửa, false = đang trong chế độ thêm hoặc khác
    
    public SanPhamGUI(int width, int height) {
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
        result.setPreferredSize(new Dimension(this.width, 300));
        
        JPanel pn_infor = new JPanel(new BorderLayout());
        pn_infor.setPreferredSize(new Dimension(this.width - 100, 250));
        pn_infor.setBackground(this.color1);
        pn_infor.setBorder(BorderFactory.createLineBorder(color1, 2));
        
        // create panel avatar
        JPanel pn_avatar = new JPanel(new FlowLayout(1, 0, 25));
        pn_avatar.setPreferredSize(new Dimension(250, 250));
        
        this.lbImgSanPham = new JLabel("Image", JLabel.CENTER);
        this.lbImgSanPham.setPreferredSize(new Dimension(175, 200));
        this.lbImgSanPham.setBorder(BorderFactory.createLineBorder(Color.black));
        
        pn_avatar.add(this.lbImgSanPham);
        
        // create panel description
        JPanel pn_desc = new JPanel(new FlowLayout(1, 15, 15));

        String[] thuoc_tinh = {"Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá"};
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
        this.arrTfInfor.get(0).setEditable(false); // khóa luôn khả năng chỉnh sửa mã sản phẩm
        
        JPanel pn_brand = new JPanel(new FlowLayout(0, 0, 0));
        pn_brand.setPreferredSize(d_pn);
        pn_brand.setForeground(color_font);
        pn_brand.setFont(font_infor);
        
        JLabel lb_brand = new JLabel("Hãng");
        lb_brand.setPreferredSize(d_lb);
        lb_brand.setForeground(color_font);
        lb_brand.setFont(font_infor);
        
        String[] brand = {"Acer", "Asus", "Dell", "LG", "Mac", "MSI"};    
        this.cbBrand = new JComboBox(brand);
        this.cbBrand.setPreferredSize(d_tf);
        this.cbBrand.setForeground(color_font);
        this.cbBrand.setFont(font_infor);
        
        pn_brand.add(lb_brand);
        pn_brand.add(this.cbBrand);
        pn_desc.add(pn_brand);
        
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
                
                arrTfInfor.get(0).setText(sanPhamBUS.createNewId());
                
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
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa!");
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
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần xóa!");
                    return;
                }
                
                int confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Alert", JOptionPane.YES_NO_OPTION);
                if (confirmed == 0) { // xác nhận xóa
                    sanPhamBUS.deleteSanPham(arrTfInfor.get(0).getText());
                    blankInfor();
                    table.clearSelection();
                    reloadSP(sanPhamBUS.getSpList());
                }
            }
        });
        
        // khi ấn nút hoàn thành
        btn_hoan_thanh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirmed;
                if (isEditing) { // đang trong chế độ sửa
                    confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận sửa sản phẩm", "", JOptionPane.YES_NO_OPTION);
                    if (confirmed == 0) { // xác nhận sửa
                        String idSP = arrTfInfor.get(0).getText();
                        String tenSP = arrTfInfor.get(1).getText();
                        int soLuong = Integer.parseInt(arrTfInfor.get(2).getText());
                        int gia = Integer.parseInt(arrTfInfor.get(3).getText());
                        String hang = (String) cbBrand.getItemAt(cbBrand.getSelectedIndex());
                        String newImg = imgSanPham;
                        
                        SanPhamDTO sp = new SanPhamDTO(idSP, tenSP, soLuong, gia, hang, newImg);
                        sanPhamBUS.updateSanPham(sp);
                        reloadSP(sanPhamBUS.getSpList());
                        
                        saveImg();
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "OK", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else { // đang trong chế độ thêm
                    confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm", "", JOptionPane.YES_NO_OPTION);
                    if (confirmed == 0) { // xác nhận thêm
                        String idSP = arrTfInfor.get(0).getText();
                        String tenSP = arrTfInfor.get(1).getText();
                        int soLuong = Integer.parseInt(arrTfInfor.get(2).getText());
                        int gia = Integer.parseInt(arrTfInfor.get(3).getText());
                        String hang = (String) cbBrand.getItemAt(cbBrand.getSelectedIndex());
                        String newImg = imgSanPham;
                        
                        if (sanPhamBUS.isExisted(idSP)) {
                            JOptionPane.showMessageDialog(null, "Mã sản phẩm đă tồn tại!");
                            return;
                        }
                        
                        SanPhamDTO sp = new SanPhamDTO(idSP, tenSP, soLuong, gia, hang, newImg);
                        sanPhamBUS.addSanPham(sp);
                        
                        reloadSP(sanPhamBUS.getSpList());
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
                        // set tên ảnh là tên mã sản phẩm
                        imgSanPham = arrTfInfor.get(0).getText().concat(".png");      

                        IconModel new_img = new IconModel(200, 250, "SanPham/" + imgSanPham);
                        lbImgSanPham.setText("");
                        lbImgSanPham.setIcon(new_img.createIcon());
                    } catch (IOException ex) {
                        Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
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
//        pn_filter.setBorder(BorderFactory.createLineBorder(color1, 3));
        
        // Thanh tìm kiếm theo tên hoặc id sản phẩm
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
                else if (txt.trim().length() >= 2 && txt.trim().substring(0, 2).toUpperCase().equals("SP")) {
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
                else if (txt.trim().length() >= 2 && txt.trim().substring(0, 2).toUpperCase().equals("SP")) {
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
        
        // Khu lọc theo một số thuộc tính (hãng, giá)
        JLabel lb_hang = new JLabel("Hãng", JLabel.CENTER);
        String[] brand = {"", "Acer", "Asus", "Dell", "LG", "Mac", "MSI"};    
        JComboBox cb_hang = new JComboBox(brand);
        cb_hang.setPreferredSize(new Dimension(100, 30));
        
        JLabel lb_gia = new JLabel("Giá", JLabel.CENTER);
        JTextField tf_min_price = new JTextField();
        tf_min_price.setPreferredSize(new Dimension(100, 30));
        
        JSeparator sep = new JSeparator(JSeparator.HORIZONTAL);
        sep.setPreferredSize(new Dimension(20, 10));
        
        JTextField tf_max_price = new JTextField();
        tf_max_price.setPreferredSize(new Dimension(100, 30));
        
        JButton btn_loc = new JButton("Lọc");
        btn_loc.setPreferredSize(new Dimension(100, 30));
        
        btn_loc.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                String hang = (String) cb_hang.getItemAt(cb_hang.getSelectedIndex());
                int min_price;
                if (tf_min_price.getText().equals("")) {
                    min_price = 0;
                }
                else {
                    min_price = Integer.parseInt(tf_min_price.getText());
                }
                
                int max_price;
                if (tf_max_price.getText().equals("")) {
                    max_price = Integer.MAX_VALUE;
                }
                else {
                    max_price = Integer.parseInt(tf_max_price.getText());
                }
                

                reloadSP(sanPhamBUS.filter(hang, min_price, max_price));
            }
        });
        
        // giao diện filter
        Font font_filter = new Font("Segoe UI", Font.BOLD, 13);
        Color color_font = this.color1;
        
        lb_tim_kiem.setFont(font_filter);
        tf_tim_kiem.setFont(font_filter);
        lb_hang.setFont(font_filter);
        cb_hang.setFont(font_filter);
        lb_gia.setFont(font_filter);
        tf_min_price.setFont(font_filter);
        tf_max_price.setFont(font_filter);
        
        lb_tim_kiem.setForeground(color1);
        tf_tim_kiem.setForeground(color1);
        lb_hang.setForeground(color1);
        cb_hang.setForeground(color1);
        lb_gia.setForeground(color1);
        tf_min_price.setForeground(color1);
        tf_max_price.setForeground(color1);
        
        btn_loc.setBackground(color2);
        btn_loc.setFont(font_filter);
        btn_loc.setForeground(this.colorBackground);
        
        pn_filter.add(lb_tim_kiem);
        pn_filter.add(tf_tim_kiem);
        pn_filter.add(lb_hang);
        pn_filter.add(cb_hang);
        pn_filter.add(lb_gia);
        pn_filter.add(tf_min_price);
        pn_filter.add(sep);
        pn_filter.add(tf_max_price);
        pn_filter.add(btn_loc);
        
        return pn_filter;
    }
    
    public JPanel createPnTable() {
        JPanel pn_table = new JPanel(new FlowLayout(1, 0, 0));
        pn_table.setPreferredSize(new Dimension(this.width, 300));
        
        String[] col = {
            "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Hãng", "IMG"
        };
        this.model = new DefaultTableModel(col, 0);
        this.table = new JTable();
        rowSorter = new TableRowSorter<TableModel>(model);
        this.table.setModel(model);
        this.table.setRowSorter(rowSorter);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(900, 250));
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(40);
        table.getColumnModel().getColumn(5).setPreferredWidth(20);
        
        this.loadSP();
        
        pn_table.add(scroll);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (table.getRowSorter() != null) {
                    row = table.getRowSorter().convertRowIndexToModel(row);
                }
                imgSanPham = table.getModel().getValueAt(row, 5).toString();
                IconModel icon_sp = new IconModel(175, 200, "SanPham/" + imgSanPham);
                
                // set thông tin cho sản phẩm
                arrTfInfor.get(0).setText(table.getModel().getValueAt(row, 0).toString());
                arrTfInfor.get(1).setText(table.getModel().getValueAt(row, 1).toString());
                arrTfInfor.get(2).setText(table.getModel().getValueAt(row, 2).toString());
                arrTfInfor.get(3).setText(table.getModel().getValueAt(row, 3).toString());
                cbBrand.setSelectedItem(table.getModel().getValueAt(row, 4).toString());
                lbImgSanPham.setText("");
                lbImgSanPham.setIcon(icon_sp.createIcon());
                
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
    
    public void loadSP() {
        if (sanPhamBUS.getSpList() == null) {
            sanPhamBUS.list();
        }
        ArrayList<SanPhamDTO> spList = sanPhamBUS.getSpList();
        model.setRowCount(0);
        reloadSP(spList);
    }
    
    public void reloadSP(ArrayList<SanPhamDTO> spList) {
        model.setRowCount(0);
        for (SanPhamDTO sp : spList) {
            model.addRow(new Object[]{
                sp.getIdSanPham(), sp.getTenSanPham(), sp.getSoLuong(), sp.getGiaBan(), sp.getHang(), sp.getImgSanPham()
            });
        }
    }
    
    public void saveImg() {
        try {
            if (bufferImg != null) {
                File save = new File("src/img/SanPham/" + imgSanPham);
                ImageIO.write(bufferImg, "png", save);
                bufferImg = null;
            }
        } catch (IOException ex) {
            Logger.getLogger(SanPhamGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    // khóa khả năng thao tác với thông tin
    public void lockInfor(boolean lock) {
        arrTfInfor.get(1).setEditable(!lock);
        arrTfInfor.get(2).setEditable(!lock);
        arrTfInfor.get(3).setEditable(!lock);    
        cbBrand.setEnabled(!lock);
    }
    
    public void blankInfor() {
        arrTfInfor.get(0).setText("");
        arrTfInfor.get(1).setText("");
        arrTfInfor.get(2).setText("");
        arrTfInfor.get(3).setText("");
        lbImgSanPham.setIcon(null);
        lbImgSanPham.setText("Image");
        imgSanPham = "null";
    }
}