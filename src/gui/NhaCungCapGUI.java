package gui;

import bus.NhaCungCapBUS;
import dto.NhaCungCapDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NhaCungCapGUI extends JPanel {
    
    private int width, height;
    private Color colorBackground = Color.decode("#FFFFFF");
    private Color color1 = Color.decode("#006270");
    private Color color2 = Color.decode("#009394");
    private Color color3 = Color.decode("#00E0C7");

    private JPanel pnInfor, pnFilter, pnTable;
    private ArrayList<JPanel> arrPnInfor;
    private ArrayList<JLabel> arrLbInfor;
    private ArrayList<JTextField> arrTfInfor;

    private JTable table;
    private TableRowSorter<TableModel> rowSorter;
    private DefaultTableModel model;
    private NhaCungCapBUS nhaCungCapBUS = new NhaCungCapBUS();
    
    private boolean isEditing = false; // true = đang trong chế độ sửa, false = đang trong chế độ thêm hoặc khác    
    
    public NhaCungCapGUI(int width, int height) {
        this.width = width;
        this.height = height;
        this.init();
    }
    
    public void init() {
        this.setSize(this.width, this.height);
        this.setBackground(this.colorBackground);
        
        this.pnInfor = this.createPnInfor();
        this.pnTable = this.createPnTable();
        
        this.setLayout(new BorderLayout());
        this.add(this.pnInfor, BorderLayout.NORTH);
        this.add(this.pnTable, BorderLayout.SOUTH);
    }
    
    public JPanel createPnInfor() {
        JPanel result = new JPanel(new FlowLayout(1, 0, 25));
        result.setPreferredSize(new Dimension(this.width, 300));
        
        JPanel pn_infor = new JPanel(new BorderLayout());
        pn_infor.setPreferredSize(new Dimension(this.width - 100, 230));
        pn_infor.setBackground(this.color1);
        pn_infor.setBorder(BorderFactory.createLineBorder(color1, 2));

        
        // create panel description
        JPanel pn_desc = new JPanel(new FlowLayout(1, 20, 20));

        String[] thuoc_tinh = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại"};
        int len = thuoc_tinh.length;
        this.arrPnInfor = new ArrayList<>();
        this.arrLbInfor = new ArrayList<>();
        this.arrTfInfor = new ArrayList<>();
        
        Dimension d_pn = new Dimension(530, 30);
        Dimension d_lb = new Dimension(130, 30);
        Dimension d_tf = new Dimension(400, 30);
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
        
        // create panel button
        JPanel pn_btn = new JPanel(new FlowLayout(1, 70, 10));
        pn_btn.setPreferredSize(new Dimension(250, 250));
        
        // các nút chức năng mặc định
        JButton btn_them = new JButton("Thêm");
        JButton btn_sua = new JButton("Sửa");
        JButton btn_xoa = new JButton("Xóa");
        JButton btn_nhap_excel = new JButton("Nhập Excel");
        JButton btn_xuat_excel = new JButton("Xuất Excel");
        
        // các nút chức năng phụ
        JButton btn_hoan_thanh = new JButton("Hoàn thành");
        JButton btn_tro_ve = new JButton("Trở về");
        
        // Thiết kế giao diện nút
        Dimension d_btn = new Dimension(150, 30);
        btn_them.setPreferredSize(d_btn);
        btn_sua.setPreferredSize(d_btn);
        btn_xoa.setPreferredSize(d_btn);
        btn_nhap_excel.setPreferredSize(d_btn);
        btn_xuat_excel.setPreferredSize(d_btn);
        
        btn_hoan_thanh.setPreferredSize(d_btn);
        btn_tro_ve.setPreferredSize(d_btn);
        btn_hoan_thanh.setVisible(false);
        btn_tro_ve.setVisible(false);
        
        Color color_button = this.color2;
        btn_them.setBackground(color_button);
        btn_sua.setBackground(color_button);
        btn_xoa.setBackground(color_button);
        btn_nhap_excel.setBackground(color_button);
        btn_xuat_excel.setBackground(color_button);

        btn_hoan_thanh.setBackground(color_button);
        btn_tro_ve.setBackground(color_button);
        
        Color color_font_btn = this.colorBackground;
        btn_them.setForeground(color_font_btn);
        btn_sua.setForeground(color_font_btn);
        btn_xoa.setForeground(color_font_btn);
        btn_nhap_excel.setForeground(color_font_btn);
        btn_xuat_excel.setForeground(color_font_btn);

        btn_hoan_thanh.setForeground(color_font_btn);
        btn_tro_ve.setForeground(color_font_btn);
        
        Font font_btn = new Font("Segoe UI", Font.BOLD, 13);
        btn_them.setFont(font_btn);
        btn_sua.setFont(font_btn);
        btn_xoa.setFont(font_btn);
        btn_nhap_excel.setFont(font_btn);
        btn_xuat_excel.setFont(font_btn);

        btn_hoan_thanh.setFont(font_btn);
        btn_tro_ve.setFont(font_btn);
        
        // thêm các nút
        pn_btn.add(btn_them);
        pn_btn.add(btn_sua);
        pn_btn.add(btn_xoa);
        pn_btn.add(btn_nhap_excel);
        pn_btn.add(btn_xuat_excel);
        pn_btn.add(btn_hoan_thanh);
        pn_btn.add(btn_tro_ve);
        
        // khi ấn nút thêm
       btn_them.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                blankInfor();
                isEditing = false;
                lockInfor(false);
                
                arrTfInfor.get(0).setText(nhaCungCapBUS.createNewId());
                
                btn_them.setVisible(false);
                btn_sua.setVisible(false);
                btn_xoa.setVisible(false);
                btn_nhap_excel.setVisible(false);
                btn_xuat_excel.setVisible(false);
                
                btn_hoan_thanh.setVisible(true);
                btn_tro_ve.setVisible(true);
                
                table.clearSelection();
                table.setEnabled(false);
            }
        });
        
        // khi ấn nút sửa
        btn_sua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (arrTfInfor.get(0).getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần sửa!");
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
                
                table.setEnabled(false);
            }
        });
        
        // khi ấn nút xóa
        btn_xoa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (arrTfInfor.get(0).getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần xóa!");
                    return;
                }
                
                int confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "Alert", JOptionPane.YES_NO_OPTION);
                if (confirmed == 0) { // xác nhận xóa
                    nhaCungCapBUS.deleteNhaCungCap(arrTfInfor.get(0).getText());
                    blankInfor();
                    table.clearSelection();
                    reloadNCC(nhaCungCapBUS.getNccList());
                }
            }
        });
        
        // khi ấn nút hoàn thành
        btn_hoan_thanh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int confirmed;
                if (isEditing) { // đang trong chế độ sửa
                    confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận sửa nhà cung cấp", "", JOptionPane.YES_NO_OPTION);
                    if (confirmed == 0) { // xác nhận sửa
                        String idNCC = arrTfInfor.get(0).getText();
                        String tenNCC = arrTfInfor.get(1).getText();
                        String diachi = arrTfInfor.get(2).getText();
                        String sdt =arrTfInfor.get(3).getText();
                        
                        NhaCungCapDTO ncc = new NhaCungCapDTO(idNCC, tenNCC, diachi, sdt);
                        nhaCungCapBUS.updateNhaCungCap(ncc);
                        reloadNCC(nhaCungCapBUS.getNccList());
                        
                        
                        JOptionPane.showMessageDialog(null, "Sửa thành công", "OK", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                else { // đang trong chế độ thêm
                    confirmed = JOptionPane.showConfirmDialog(null, "Xác nhận thêm nhà cung cấp", "", JOptionPane.YES_NO_OPTION);
                    if (confirmed == 0) { // xác nhận thêm
                        String idNCC = arrTfInfor.get(0).getText();
                        String tenNCC = arrTfInfor.get(1).getText();
                        String diachi = arrTfInfor.get(2).getText();
                        String sdt = arrTfInfor.get(3).getText();
                        
                        if (nhaCungCapBUS.isExisted(idNCC)) {
                            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp đă tồn tại!");
                            return;
                        }
                        
                        NhaCungCapDTO ncc = new NhaCungCapDTO(idNCC, tenNCC, diachi, sdt);
                        nhaCungCapBUS.addNhaCungCap(ncc);
                        
                        reloadNCC(nhaCungCapBUS.getNccList());
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
                
                table.setEnabled(true);
            }
        });
            
        // add components
        pn_infor.add(pn_desc, BorderLayout.CENTER);
        pn_infor.add(pn_btn, BorderLayout.EAST);
        
        result.add(pn_infor);
        
        return result;
    }

   
    
    
    public JPanel createPnTable() {
        JPanel pn_table = new JPanel(new FlowLayout(1, 0, 0));
        pn_table.setPreferredSize(new Dimension(this.width, 370));
        
        String[] col = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại"};

        this.model = new DefaultTableModel(col, 0);
        this.table = new JTable();
        rowSorter = new TableRowSorter<TableModel>(model);
        this.table.setModel(model);
        this.table.setRowSorter(rowSorter);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(900, 330));
        
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(170);
        table.getColumnModel().getColumn(3).setPreferredWidth(15);
       
        
        this.loadNCC();
        
        pn_table.add(scroll);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (table.getRowSorter() != null) {
                    row = table.getRowSorter().convertRowIndexToModel(row);
                }               
                // set thông tin cho sản phẩm
                arrTfInfor.get(0).setText(table.getModel().getValueAt(row, 0).toString());
                arrTfInfor.get(1).setText(table.getModel().getValueAt(row, 1).toString());
                arrTfInfor.get(2).setText(table.getModel().getValueAt(row, 2).toString());
                arrTfInfor.get(3).setText(table.getModel().getValueAt(row, 3).toString());              
                
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
    
    public void loadNCC() {
        if (nhaCungCapBUS.getNccList() == null) {
           nhaCungCapBUS.list();
        }
        ArrayList<NhaCungCapDTO> nccList = nhaCungCapBUS.getNccList();
        model.setRowCount(0);
        reloadNCC(nccList);
    }
    
    public void reloadNCC(ArrayList<NhaCungCapDTO> nccList) {
        model.setRowCount(0);
        for (NhaCungCapDTO ncc : nccList) {
            model.addRow(new Object[]{
                ncc.getIdNhaCungCap(), ncc.getTenNhaCungCap(), ncc.getDiachi(), ncc.getSdt()
            });
        }
    }
    
    // khóa khả năng thao tác với thông tin
    public void lockInfor(boolean lock) {
    //    arrTfInfor.get(0).setEditable(!lock);
        arrTfInfor.get(1).setEditable(!lock);
        arrTfInfor.get(2).setEditable(!lock);
        arrTfInfor.get(3).setEditable(!lock);    

    }
    
    public void blankInfor() {
        arrTfInfor.get(0).setText("");
        arrTfInfor.get(1).setText("");
        arrTfInfor.get(2).setText("");
        arrTfInfor.get(3).setText("");
    }
}