package gui;

import bus.CTPhieuNhapBUS;
import bus.PhieuNhapBUS;
import dto.CTPhieuNhapDTO;
import dto.PhieuNhapDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PhieuNhapGUI extends JPanel {

    private int width, height;
    private Color colorBackground = Color.decode("#FFFFFF");
    private Color color1 = Color.decode("#006270");
    private Color color2 = Color.decode("#009394");
    private Color color3 = Color.decode("#00E0C7");
    private PhieuNhapBUS phieuNhapBUS = new PhieuNhapBUS();
    private CTPhieuNhapBUS ctPhieuNhapBUS = new CTPhieuNhapBUS();
    
    private JPanel pnInfor, pnFilter, pnTable;
    private ArrayList<JLabel> arrLbInfor;
    
    private JTable table, tableCT;
    private TableRowSorter<TableModel> rowSorter;
    private DefaultTableModel model, modelCT;
    
    public PhieuNhapGUI(int width, int height) {
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
        
        // phần thông tin hóa đơn
        JPanel pn_infor = new JPanel(new FlowLayout(1, 5, 10));
        pn_infor.setPreferredSize(new Dimension(300, 250));
        pn_infor.setBorder(BorderFactory.createLineBorder(color1, 2));
        
        String[] thuoc_tinh = {
            "Mã phiếu nhập: ", "Mã nhà cung cấp: ", "Mã nhân viên: ", "Ngày nhập: ", "Tổng tiền: "
        };
        int len = thuoc_tinh.length;
        this.arrLbInfor = new ArrayList<>();
        
        Dimension d_tf = new Dimension(290, 30);
        Color color_font = this.color1;
        Font font_infor = new Font("Segoe UI", Font.PLAIN, 13);
        for (int i = 0; i < len; i++) {
            this.arrLbInfor.add(new JLabel(thuoc_tinh[i]));
            this.arrLbInfor.get(i).setPreferredSize(d_tf);
            this.arrLbInfor.get(i).setForeground(color_font);
            this.arrLbInfor.get(i).setFont(font_infor);
            pn_infor.add(this.arrLbInfor.get(i));
        }
        
        
        // phần thông tin chi tiết hóa đơn
        JPanel pn_table = new JPanel(new FlowLayout());
        
        String[] col = {
            "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá"
        };
        modelCT = new DefaultTableModel(col, 0);
        tableCT = new JTable();
        tableCT.setModel(modelCT);
        JScrollPane scroll = new JScrollPane(tableCT);
        scroll.setPreferredSize(new Dimension(600, 250));
        
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
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
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
        
        result.add(pn_infor);
        result.add(pn_table);
        
        return result;
    }
    
    public JPanel createPnFilter() {
        JPanel pn_filter = new JPanel();
        pn_filter.setBorder(BorderFactory.createLineBorder(Color.black));
        
        
        
        return pn_filter;
    }
    
    public JPanel createPnTable() {
        JPanel pn_table = new JPanel();
        pn_table.setPreferredSize(new Dimension(this.width, 300));
        
        String[] col = {
            "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Tổng tiền"
        };
        this.model = new DefaultTableModel(col, 0);
        this.table = new JTable();
        rowSorter = new TableRowSorter<TableModel>(model);
        this.table.setModel(model);
        this.table.setRowSorter(rowSorter);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(900, 250));
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(250);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        
        this.loadPN();
        
        pn_table.add(scroll);
        
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (table.getRowSorter() != null) {
                    row = table.getRowSorter().convertRowIndexToModel(row);
                }
                
                // set thông tin cho sản phẩm
                arrLbInfor.get(0).setText("Mã phiếu nhập: " + table.getModel().getValueAt(row, 0).toString());
                arrLbInfor.get(1).setText("Mã nhà cung cấp: " + table.getModel().getValueAt(row, 1).toString());
                arrLbInfor.get(2).setText("Mã nhân viên: " + table.getModel().getValueAt(row, 2).toString());
                arrLbInfor.get(3).setText("Ngày nhập: " + table.getModel().getValueAt(row, 3).toString());
                arrLbInfor.get(4).setText("Tổng tiền: " + table.getModel().getValueAt(row, 4).toString());

                loadCTPN(table.getModel().getValueAt(row, 0).toString());
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
    
    public void loadPN() {
        if (phieuNhapBUS.getPnList() == null) {
            phieuNhapBUS.list();
        }
        ArrayList<PhieuNhapDTO> pnList = phieuNhapBUS.getPnList();
        model.setRowCount(0);
        reloadPN(pnList);
    }
    
    public void reloadPN(ArrayList<PhieuNhapDTO> pnList) {
        model.setRowCount(0);
        for (PhieuNhapDTO pn : pnList) {
            model.addRow(new Object[]{
                pn.getIdPhieuNHap(), pn.getIdNHaCungCap(), pn.getIdUser(), pn.getNgayNhap(), pn.getTongTien()
            });
        }
    } 
    
    public void loadCTPN(String id) {
        if (ctPhieuNhapBUS.getCtpnList() == null) {
            ctPhieuNhapBUS.list();
        }
        ArrayList<CTPhieuNhapDTO> ctpnList = ctPhieuNhapBUS.listId(id);
        modelCT.setRowCount(0);
        reloadCTPN(ctpnList);
    }
    
    public void reloadCTPN(ArrayList<CTPhieuNhapDTO> ctpnList) {
        modelCT.setRowCount(0);
        for (CTPhieuNhapDTO ctpn : ctpnList) {
            modelCT.addRow(new Object[]{
                ctpn.getIdSanPham(), ctpn.getIdSanPham(), ctpn.getSoLuong(), ctpn.getDonGia()
            });
        }
    }
}