package gui;

import bus.CTHoaDonBUS;
import bus.HoaDonBUS;
import bus.SanPhamBUS;
import dto.CTHoaDonDTO;
import dto.SanPhamDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NhapHangGUI extends JPanel implements ActionListener {
    private int width, height;
    private Color colorBackground = Color.decode("#FFFFFF");
    private Color color1 = Color.decode("#006270");
    private Color color2 = Color.decode("#009394");
    private Color color3 = Color.decode("#00E0C7");
    private SanPhamBUS sanPhamBUS = new SanPhamBUS();
    private HoaDonBUS hoaDonBUS = new HoaDonBUS();
    private CTHoaDonBUS ctHoaDonBUS = new CTHoaDonBUS();

    private JPanel pnInfor, pnFilter, pnTable;
    private ArrayList<JPanel> arrPnInfor;
    private ArrayList<JLabel> arrLbInfor;
    private ArrayList<JTextField> arrTfInfor;
    private JButton btnTaoHoaDon, btnXoaSanPham, btnThemSanPham;
    private JLabel lbTongTien;
    private ArrayList<CTHoaDonDTO> arrCTHD = new ArrayList<>();
    
    private JTextField tfSoLuong;
    private JTable table, tableCT;
    private TableRowSorter<TableModel> rowSorter;
    private DefaultTableModel model, modelCT;
    
    public NhapHangGUI(int width, int height) {
        this.width = width;
        this.height = height;
        this.init();
    }
    
    public void init() {
        this.setSize(this.width, this.height);
        
        this.pnInfor = this.createPnInfor();
        this.pnFilter = this.createPnFilter();
        this.pnTable = this.createPnTable();
        
        this.setLayout(new BorderLayout());
        this.add(this.pnInfor, BorderLayout.NORTH);
        this.add(this.pnFilter, BorderLayout.CENTER);
        this.add(this.pnTable, BorderLayout.SOUTH);
    }
    
    public JPanel createPnInfor() {
        JPanel result = new JPanel(new FlowLayout(1, 0, 10));
        result.setPreferredSize(new Dimension(this.width, 300));
        
        // phần thông tin hóa đơn
        JPanel pn_infor = new JPanel(new FlowLayout(1, 5, 15));
        pn_infor.setPreferredSize(new Dimension(250, 250));
        pn_infor.setBorder(BorderFactory.createLineBorder(color1, 2));
        
        String[] thuoc_tinh = {"Mã phiếu nhập", "Nhà cung cấp", "Mã nhân viên", "Ngày"};
        int len = thuoc_tinh.length;
        this.arrPnInfor = new ArrayList<>();
        this.arrLbInfor = new ArrayList<>();
        this.arrTfInfor = new ArrayList<>();
        
        Dimension d_pn = new Dimension(240, 30);
        Dimension d_lb = new Dimension(100, 30);
        Dimension d_tf = new Dimension(130, 30);
        Color color_font = this.color1;
        Font font_infor = new Font("Segoe UI", Font.PLAIN, 13);
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
            pn_infor.add(this.arrPnInfor.get(i));
        }
        this.arrTfInfor.get(0).setEnabled(false);
        this.arrTfInfor.get(2).setEnabled(false);
        this.arrTfInfor.get(3).setEnabled(false);
        
        // phần bảng thông tin chi tiết hóa đơn
        JPanel pn_table = new JPanel(new FlowLayout(1));
        
        String[] col = {
            "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá"
        };
        modelCT = new DefaultTableModel(col, 0);
        tableCT = new JTable();
        tableCT.setModel(modelCT);
        tableCT.setRowSorter(rowSorter);
        JScrollPane scroll = new JScrollPane(tableCT);
        scroll.setPreferredSize(new Dimension(500, 250));
        
        tableCT.getColumnModel().getColumn(0).setPreferredWidth(30);
        tableCT.getColumnModel().getColumn(1).setPreferredWidth(70);
        tableCT.getColumnModel().getColumn(2).setPreferredWidth(10);
        tableCT.getColumnModel().getColumn(3).setPreferredWidth(40);
        
        pn_table.add(scroll);
        
        Font font_table = new Font("Segoe UI", Font.BOLD, 13);
        tableCT.getTableHeader().setBackground(color1);
        tableCT.getTableHeader().setFont(font_table);
        tableCT.getTableHeader().setForeground(this.colorBackground);
        tableCT.getTableHeader().setOpaque(false); 
        tableCT.getTableHeader().setBorder(BorderFactory.createLineBorder(this.color1));
        
        // căn giữa các chữ trong ô
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int i = 0; i < col.length; i++) {
            tableCT.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        tableCT.setFocusable(false);
        tableCT.setShowVerticalLines(false);
        tableCT.setIntercellSpacing(new Dimension(0, 0));
        tableCT.setFillsViewportHeight(true);
        tableCT.setSelectionBackground(color3);
        tableCT.setRowHeight(30);
        tableCT.setBorder(BorderFactory.createLineBorder(this.color1));
        
        // phần thông tin các nút
        JPanel pn_btn = new JPanel(new FlowLayout(1, 5, 5));
        pn_btn.setPreferredSize(new Dimension(150, 250));
        
        this.btnXoaSanPham = new JButton("Xóa sản phẩm");
        this.btnTaoHoaDon = new JButton("Tạo phiếu nhập");
        this.btnXoaSanPham.setPreferredSize(new Dimension(140, 30));
        this.btnTaoHoaDon.setPreferredSize(new Dimension(140, 30));
        this.btnXoaSanPham.setBackground(this.color2);
        this.btnTaoHoaDon.setBackground(this.color2);
        this.btnXoaSanPham.setForeground(this.colorBackground);
        this.btnTaoHoaDon.setForeground(this.colorBackground);
        Font font_btn = new Font("Segoe UI", Font.BOLD, 13);
        this.btnXoaSanPham.setFont(font_btn);
        this.btnTaoHoaDon.setFont(font_btn);
        
        this.btnXoaSanPham.addActionListener(this);
        this.btnTaoHoaDon.addActionListener(this);
        
        JPanel pn_tong_tien = new JPanel(new FlowLayout(1, 5, 10));
        pn_tong_tien.setPreferredSize(new Dimension(150, 170));
        pn_tong_tien.setBorder(BorderFactory.createLineBorder(this.color1, 2));
        JLabel lb_tong_tien = new JLabel("Tổng tiền", JLabel.CENTER);
        lb_tong_tien.setPreferredSize(new Dimension(150, 30));
        
        Font font_tong_tien_1 = new Font("Segoe UI", Font.BOLD, 17);
        lb_tong_tien.setFont(font_tong_tien_1);
        lb_tong_tien.setForeground(this.color1);
        
        Font font_tong_tien_2 = new Font("Segoe UI", Font.BOLD, 13);
        this.lbTongTien = new JLabel("0");
        this.lbTongTien.setForeground(this.color1);
        
        pn_tong_tien.add(lb_tong_tien);
        pn_tong_tien.add(lbTongTien);

        pn_btn.add(this.btnXoaSanPham);
        pn_btn.add(this.btnTaoHoaDon);
        pn_btn.add(pn_tong_tien);
        
        result.add(pn_infor);
        result.add(pn_table);
        result.add(pn_btn);
        
        return result;
    }
    
    public JPanel createPnFilter() {
        JPanel pn_filter = new JPanel(new FlowLayout(1, 20, 5));
        
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
        
        JSeparator sep = new JSeparator(JSeparator.VERTICAL);
        sep.setPreferredSize(new Dimension(10, 40));
        
        // phần thêm số lượng sản phẩm vào chi tiết phiếu nhập
        JLabel lb_so_luong = new JLabel("Số lượng", JLabel.CENTER);
        tfSoLuong = new JTextField("1");
        tfSoLuong.setPreferredSize(new Dimension(50, 30));
        
        Font font_filter = new Font("Segoe UI", Font.BOLD, 13);
        Color color_font = this.color1;
        
        lb_tim_kiem.setFont(font_filter);
        tf_tim_kiem.setFont(font_filter);
        lb_so_luong.setFont(font_filter);
        tfSoLuong.setFont(font_filter);
        
        lb_tim_kiem.setForeground(color1);
        tf_tim_kiem.setForeground(color1);  
        lb_so_luong.setForeground(color1);
        tfSoLuong.setForeground(color1);
                
        this.btnThemSanPham = new JButton("Thêm sản phẩm");
        Font font_btn = new Font("Segoe UI", Font.BOLD, 13);
        this.btnThemSanPham.setPreferredSize(new Dimension(170, 30));
        this.btnThemSanPham.setFont(font_btn);
        this.btnThemSanPham.setBackground(this.color2);
        this.btnThemSanPham.setForeground(this.colorBackground);

        this.btnThemSanPham.addActionListener(this);
        
        pn_filter.add(lb_tim_kiem);
        pn_filter.add(tf_tim_kiem);
        pn_filter.add(sep);
        pn_filter.add(lb_so_luong);
        pn_filter.add(tfSoLuong);
        pn_filter.add(this.btnThemSanPham);
        
        return pn_filter;
    }
    
    public JPanel createPnTable() {
        JPanel pn_table = new JPanel(new FlowLayout(1, 0, 0));
        pn_table.setPreferredSize(new Dimension(this.width, 320));
        
        String[] col = {
            "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Hãng"
        };
        this.model = new DefaultTableModel(col, 0);
        this.table = new JTable();
        rowSorter = new TableRowSorter<TableModel>(model);
        this.table.setModel(model);
        this.table.setRowSorter(rowSorter);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(900, 300));
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(20);
        table.getColumnModel().getColumn(3).setPreferredWidth(50);
        table.getColumnModel().getColumn(4).setPreferredWidth(50);
        
        this.loadSP();
        
        pn_table.add(scroll);
        
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
            if (sp.isEnable()) {
                model.addRow(new Object[]{
                    sp.getIdSanPham(), sp.getTenSanPham(), sp.getSoLuong(), sp.getGiaBan(), sp.getHang()
                });
            }
        }
    }
    
    public void reloadCTHD() {
        modelCT.setRowCount(0);
        for (CTHoaDonDTO cthd : arrCTHD) {
            modelCT.addRow(new Object[]{
                cthd.getIdSanPham(), cthd.getTenSanPham(), cthd.getSoLuong(), cthd.getDonGia()
            });
        } 
        tableCT.setModel(modelCT);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.btnThemSanPham)) {
            themSanPham();
        }
        else if (e.getSource().equals(this.btnXoaSanPham)) {
            xoaSanPham();
        }
    }
    
    public void themSanPham() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần thêm!");
        } 
        else {
            int sl_them = 0;
            try {
                sl_them = Integer.parseInt(this.tfSoLuong.getText()); 
            } catch(NumberFormatException E) {
                JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ!");
                return;
            }
            
            if (sl_them <= 0) {
                JOptionPane.showMessageDialog(null, "Số lượng nhập không hợp lệ!");
                return;
            }
            
            // kiểm tra sản phẩm có trong giỏ chưa
            String id_sp = table.getModel().getValueAt(row, 0).toString();
            String ten_sp = table.getModel().getValueAt(row, 1).toString();
            boolean sp_moi = true;
            for (CTHoaDonDTO cthd : arrCTHD) {
                if (cthd.getIdSanPham().equals(id_sp)) {
                    int sl_gio_hang = cthd.getSoLuong();
                    if (!sanPhamBUS.checkSoLuong(id_sp, sl_them + sl_gio_hang)) {
                        return;
                    }
                    cthd.setSoLuong(sl_gio_hang + sl_them);
                    sp_moi = false;
                    break;
                }
            }

            if (sp_moi) {
                if (!sanPhamBUS.checkSoLuong(id_sp, sl_them)) {
                    System.out.println("xxx");
                    return;
                }
                int gia = Integer.parseInt(table.getModel().getValueAt(row, 3).toString());
                arrCTHD.add(new CTHoaDonDTO(id_sp, id_sp, ten_sp, "AAA", sl_them, gia));
            }
            reloadCTHD();
            this.lbTongTien.setText(String.valueOf(tinhTongTien()));
        }
    }
    
    public void xoaSanPham() {
        int row = tableCT.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa!");
        } 
        else {
            arrCTHD.remove(row);
            modelCT.removeRow(row);
            this.lbTongTien.setText(String.valueOf(tinhTongTien()));
        }
    }
    
    public int tinhTongTien() {
        int sum = 0;
        for (CTHoaDonDTO cthd : arrCTHD) {
            sum += cthd.getDonGia() * cthd.getSoLuong();
        }
        return sum;
    }
}
