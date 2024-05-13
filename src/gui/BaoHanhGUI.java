package gui;
import bus.BaoHanhBUS;
import com.toedter.calendar.JDateChooser;
import dto.BaoHanhDTO;
import dto.CTHoaDonDTO;
import dto.HoaDonDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
public class BaoHanhGUI  extends JPanel {
    private int width, height;
    private Color colorBackground = Color.decode("#FFFFFF");
    private Color color1 = Color.decode("#006270");
    private Color color2 = Color.decode("#009394");
    private Color color3 = Color.decode("#00E0C7");
    private BaoHanhBUS baoHanhBUS = new BaoHanhBUS();
    
    private JPanel pnInfor, pnFilter, pnTable;
    private ArrayList<JLabel> arrLbInfor;
    
    private JTable table, tableCT;
    private TableRowSorter<TableModel> rowSorter;
    private DefaultTableModel model, modelCT;
    
    public BaoHanhGUI(int width, int height) {
        this.width = width;
        this.height = height;
        this.init();
    }
    
    public void init() {
        this.setSize(this.width, this.height);
        this.setBackground(this.colorBackground);
        
        this.pnFilter = this.createPnFilter();
        this.pnTable = this.createPnTable();
        
        this.setLayout(new BorderLayout());
        this.add(this.pnFilter, BorderLayout.NORTH);
        this.add(this.pnTable, BorderLayout.CENTER);

    }
    
    public JPanel createPnFilter() {
        JPanel pn_filter = new JPanel(new FlowLayout(1, 10, 20));
        
        Font font_filter = new Font("Segoe UI", Font.BOLD, 13);
        JLabel lb_tim_kiem = new JLabel("Tìm kiếm");
        lb_tim_kiem.setFont(font_filter);
        lb_tim_kiem.setForeground(color1);
        
        JPanel pn_tim_kiem = new JPanel(new FlowLayout(1, 0, 0));
        pn_tim_kiem.setPreferredSize(new Dimension(250, 30));
        JComboBox cb_tim_kiem = new JComboBox();
        cb_tim_kiem.setPreferredSize(new Dimension(140, 30));
        cb_tim_kiem.addItem("Mã hóa đơn");
        cb_tim_kiem.addItem("Mã khách");
        cb_tim_kiem.addItem("Mã nhân viên");
        cb_tim_kiem.setForeground(color1);
        cb_tim_kiem.setBackground(colorBackground);
        cb_tim_kiem.setFont(font_filter);
        
        JTextField tf_tim_kiem = new JTextField();
        tf_tim_kiem.setPreferredSize(new Dimension(100, 30));
        tf_tim_kiem.setFont(font_filter);
        tf_tim_kiem.setForeground(color1);
        
        tf_tim_kiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = tf_tim_kiem.getText();
                int choice = cb_tim_kiem.getSelectedIndex();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice)); 
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = tf_tim_kiem.getText();
                int choice = cb_tim_kiem.getSelectedIndex();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text + "", choice)); 
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
        
        pn_tim_kiem.add(cb_tim_kiem);
        pn_tim_kiem.add(tf_tim_kiem);
        
        // lọc theo ngày
        JLabel lb_ngay = new JLabel("Ngày", JLabel.CENTER);
        lb_ngay.setFont(font_filter);
        lb_ngay.setForeground(color1);
        
        JDateChooser date_from = new JDateChooser();
        JDateChooser date_to = new JDateChooser();
        
        date_from.setPreferredSize(new Dimension(150, 30));
        date_to.setPreferredSize(new Dimension(150, 30));
        
        JSeparator sep1 = new JSeparator(JSeparator.VERTICAL);
        sep1.setPreferredSize(new Dimension(10, 40));
        JSeparator sep2 = new JSeparator(JSeparator.HORIZONTAL);
        sep2.setPreferredSize(new Dimension(20, 10));
        
        JButton btn_loc = new JButton("Lọc");
        btn_loc.setPreferredSize(new Dimension(100, 30));
        btn_loc.setBackground(color2);
        btn_loc.setFont(font_filter);
        btn_loc.setForeground(this.colorBackground);
        
         btn_loc.addMouseListener(new MouseAdapter() { 
            @Override
            public void mouseClicked(MouseEvent e) {
                Date input1 = date_from.getDate();
                Date input2 = date_to.getDate();
                LocalDate date1 = input1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate date2 = input2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                
                reloadBH(baoHanhBUS.filter(date1, date2));
            }
        });
        
        pn_filter.add(lb_tim_kiem);
        pn_filter.add(pn_tim_kiem);
        pn_filter.add(sep1);
        pn_filter.add(lb_ngay);
        pn_filter.add(date_from);
        pn_filter.add(sep2);
        pn_filter.add(date_to);
        pn_filter.add(btn_loc);
        
        return pn_filter;
    }
    
    public JPanel createPnTable() {
        JPanel pn_table = new JPanel();
        pn_table.setPreferredSize(new Dimension(this.width, 300));
        
        String[] col = {
            "Mã khách hàng", "Tên sản phẩm", "Serial", "Ngày mua", "Ngày hết hạn"};
        this.model = new DefaultTableModel(col, 0);
        this.table = new JTable();
        rowSorter = new TableRowSorter<TableModel>(model);
        this.table.setModel(model);
        this.table.setRowSorter(rowSorter);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setPreferredSize(new Dimension(900, 550));
        
        
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(250);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        
        this.loadBH();
        
        pn_table.add(scroll);
        
//        table.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                int row = table.getSelectedRow();
//                if (table.getRowSorter() != null) {
//                    row = table.getRowSorter().convertRowIndexToModel(row);
//                }
//                
//                // set thông tin cho sản phẩm
//                arrLbInfor.get(0).setText("Mã khách hàng " + table.getModel().getValueAt(row, 0).toString());
//                arrLbInfor.get(1).setText("Tên sản phẩm" + table.getModel().getValueAt(row, 1).toString());
//                arrLbInfor.get(2).setText("Serial" + table.getModel().getValueAt(row, 2).toString());
//                arrLbInfor.get(3).setText("Ngày mua" + table.getModel().getValueAt(row, 3).toString());
//                arrLbInfor.get(4).setText("Ngày hết hạn" + table.getModel().getValueAt(row, 4).toString());
//
//                loadCTHD(table.getModel().getValueAt(row, 0).toString());
//            }
//        });
        
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
    
    public void loadBH() {
        if (baoHanhBUS.getBhList() == null) {
            baoHanhBUS.list();
        }
        ArrayList<BaoHanhDTO> bhList = baoHanhBUS.getBhList();
        model.setRowCount(0);
        reloadBH(bhList);
    }
    
    public void reloadBH(ArrayList<BaoHanhDTO> bhList) {
        model.setRowCount(0);
        for (BaoHanhDTO bh : bhList) {
            model.addRow(new Object[]{
                bh.getIdKhachHang(), bh.getTenSanPham(), bh.getSerial(), bh.getNgayMua(), bh.getNgayHetHan()
            });
        }
    } 
}
