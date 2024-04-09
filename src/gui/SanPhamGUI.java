package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;

/**
 *
 * @author Minh
 */
public class SanPhamGUI extends JPanel{
    private JTable tbl;
    private BufferedImage i = null;
    private JLabel img;
    private String imgName = "null";
    private JTextField txtId,txtTenSP,txtSl,txtGia;
    private DefaultTableModel model;
    private int DEFALUT_WIDTH,DEFALUT_HEIGHT;
    private boolean EditOrAdd = true;
    private JTextField txtMaxPrice;
    private JTextField sortMaSP;
    private JTextField txtMinPrice;
    private JComboBox cmbLoai;
    private JComboBox cmbNCC;
    private JComboBox cmbSortLoai;
    private JComboBox cmbSortNCC;
    
    
    //        

    public SanPhamGUI(int width, int height)
    {
        DEFALUT_WIDTH = width;
        DEFALUT_HEIGHT = height;
        init();
     
    }
    public void init()
    {
        this.setLayout(null);
        this.setBackground(null);
        this.setBounds(new Rectangle(50, 0, this.DEFALUT_WIDTH, 1000));
        
        //FONT CHỮ
        Font font0 = new Font("Segoe UI",Font.PLAIN,13);
        Font font1 = new Font("Segoe UI",Font.BOLD,13);

        //PHẦN TRÊN
        JPanel ItemView = new JPanel(null);
        ItemView.setBounds(new Rectangle(0, 10, this.DEFALUT_WIDTH,250));
        
        img = new JLabel("Ảnh");
        img.setBorder(createLineBorder(Color.BLACK));
        img.setBounds(new Rectangle(10,0,200,230));
        
        JLabel lbId = new JLabel("Mã Sản Phẩm");
        lbId.setBounds(new Rectangle(250,0,200,30));
        lbId.setFont(font0);
        txtId = new JTextField("");
        txtId.setBounds(new Rectangle(350,0,220,30));
        txtId.setFont(font0);

        JLabel lbName = new JLabel("Tên Sản Phẩm");
        lbName.setBounds(new Rectangle(250,40,200,30));
        lbName.setFont(font0);
        txtTenSP = new JTextField("");
        txtTenSP.setBounds(new Rectangle(350,40,220,30));
        txtTenSP.setFont(font0);

        JLabel lbSl = new JLabel("Số lượng");
        lbSl.setBounds(new Rectangle(250,80,200,30));
        lbSl.setFont(font0);
        txtSl = new JTextField("");
        txtSl.setBounds(new Rectangle(350,80,220,30));
        txtSl.setFont(font0);

        JLabel lbGia = new JLabel("Đơn giá (VNĐ)");
        lbGia.setBounds(new Rectangle(250,120,200,30));
        lbGia.setFont(font0);
        txtGia = new JTextField("");
        txtGia.setBounds(new Rectangle(350,120,220,30));
        txtGia.setFont(font0);
        
        JLabel lbLoai = new JLabel("Loại");
        lbLoai.setBounds(new Rectangle(250,160,40,30));
        lbLoai.setFont(font0);
        String[] Loai ={"ACER","DELL","ASUS","MAC","HP"};
        cmbLoai = new JComboBox(Loai);
        cmbLoai.setBounds(new Rectangle(350,160,220,30));
        cmbLoai.setFont(font0);
        
        JLabel lbNCC = new JLabel("Mã NCC");
        lbNCC.setBounds(new Rectangle(250,200,50,30));
        lbNCC.setFont(font0);
        String[] NCC ={"NCC1","NCC2","NCC3","NCC4","NCC5"};
        cmbNCC = new JComboBox(NCC);
        cmbNCC.setBounds(new Rectangle(350,200,220,30));
        cmbNCC.setFont(font0);
        
        //CÁC NÚT THAO TÁC
        JButton btnAdd = new JButton("Thêm");
        btnAdd.setBounds(new Rectangle(610,0,90,30));
        btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JButton btnEdit = new JButton("Sửa");
        btnEdit.setBounds(new Rectangle(610,50,90,30));
        btnEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        JButton btnDelete = new JButton("Xóa");
        btnDelete.setBounds(new Rectangle(610,100,90,30));
        btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JButton btnConfirm= new JButton("Hoàn tất");
        btnConfirm.setVisible(false);
        btnConfirm.setBounds(new Rectangle(610,0,90,30));
        btnConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JButton btnBack = new JButton("Trở về");
        btnBack.setVisible(false);
        btnBack.setBounds(new Rectangle(610,50,90,30));
        btnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JButton btnFile = new JButton("File");
        btnFile.setVisible(false);
        btnFile.setBounds(new Rectangle(610,100,90,30));
        btnFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JButton btnXuatExcel = new JButton("Xuất Excel");
        btnXuatExcel.setBounds(new Rectangle(720,0,100,30));
        btnXuatExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JButton btnNhapExcel = new JButton("Nhập Excel");
        btnNhapExcel.setBounds(new Rectangle(720,50,100,30));
        btnNhapExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        //THÊM VÀO PHẦN TRÊN
        ItemView.add(img);
        ItemView.add(lbId);
        ItemView.add(txtId);
        ItemView.add(lbName);
        ItemView.add(txtTenSP);
        ItemView.add(lbSl);
        ItemView.add(txtSl);
        ItemView.add(lbGia);
        ItemView.add(txtGia);
        ItemView.add(lbLoai);
        ItemView.add(cmbLoai);
        ItemView.add(lbNCC);
        ItemView.add(cmbNCC);
        ItemView.add(btnAdd);
        ItemView.add(btnEdit);
        ItemView.add(btnDelete);
        ItemView.add(btnConfirm);
        ItemView.add(btnBack);
        ItemView.add(btnFile);
        ItemView.add(btnXuatExcel);
        ItemView.add(btnNhapExcel);

        // MouseClick btnADD
        btnAdd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                EditOrAdd = true;
                
                btnAdd.setVisible(false);
                btnEdit.setVisible(false);
                btnDelete.setVisible(false);
                
                btnConfirm.setVisible(true);
                btnBack.setVisible(true);
                btnFile.setVisible(true);
            }
        });
        
        // MouseClick btnDelete
        btnDelete.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {   
                int i = JOptionPane.showConfirmDialog(null, "Xác nhận xóa","Alert",JOptionPane.YES_NO_OPTION);
            }
        });
        
        // MouseClick btnEdit
        btnEdit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                if(txtId.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa !!!");
                    return;
                }
            }
        });
        
        // MouseClick btnFile
        btnFile.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)
            {
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG images", "jpg", "png");
                fc.setFileFilter(filter);
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                    try {
                        File file = fc.getSelectedFile(); //Lấy URL hình
                        i = ImageIO.read(file); // Lấy hình
                        imgName = txtId.getText().concat(".jpg"); //Tên hình
                        
                        // Thay đổi hình hiển thị
                        img.setText("");
                        img.setIcon(new ImageIcon(i.getScaledInstance(200, 230, Image.SCALE_DEFAULT)));
                        
                        revalidate();
                        repaint();
                    } catch (IOException ex) {
                    }
                }
            }
        });
        
        //MouseClick btnBack
        btnBack.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                
                btnAdd.setVisible(true);
                btnEdit.setVisible(true);
                btnDelete.setVisible(true);
                
                btnConfirm.setVisible(false);
                btnBack.setVisible(false);
                btnFile.setVisible(false);
                
                tbl.setEnabled(true);
            }
        });
        
        //MouseClick btnConfirm
        btnConfirm.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                int i;
                if(EditOrAdd) //Thêm Sản Phẩm
                {
                    i = JOptionPane.showConfirmDialog(null, "Xác nhận thêm sản phẩm","",JOptionPane.YES_NO_OPTION);
                }
                
            }
        });
        
        //MouseClick btnXuatExcel
        btnXuatExcel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                JOptionPane.showMessageDialog(null, "Xuat file excel thanh cong");            
            }
        });

        //PHẦN DƯỚI

        //THANH LỌC TÌM KIẾM
        JPanel sort = new JPanel(null);
        sort.setBackground(null);
        sort.setBounds(10,265,this.DEFALUT_WIDTH ,100);

        JLabel sortTitle = new JLabel("------------------------------------------------------------------------------- TÌM KIẾM -----------------------------------------------------------------",JLabel.CENTER); // Mỗi bên 74 dấu ( - )
        sortTitle.setFont(font1);
        sortTitle.setBounds(new Rectangle(0,0,this.DEFALUT_WIDTH,30));
        sort.add(sortTitle);

        JLabel lbSortMaSP = new JLabel("Mã SP :");
        lbSortMaSP.setFont(font0);
        lbSortMaSP.setBounds(0,40,50,30);
        sort.add(lbSortMaSP);
        sortMaSP = new JTextField();
        sortMaSP.setFont(font0);
        sortMaSP.setBounds(new Rectangle(50,42,100,30));
        sort.add(sortMaSP);
        
        JLabel lbSortMaLoai = new JLabel("Loại :");
        lbSortMaLoai.setFont(font0);
        lbSortMaLoai.setBounds(170,40,40,30);
        sort.add(lbSortMaLoai);
        cmbSortLoai = new JComboBox(Loai);
        cmbSortLoai.setFont(font0);
        cmbSortLoai.setBounds(new Rectangle(210,42,70,30));
        sort.add(cmbSortLoai);
        
        JLabel lbSortMaNCC = new JLabel("Mã NCC :");
        lbSortMaNCC.setFont(font0);
        lbSortMaNCC.setBounds(310,40,60,30);
        sort.add(lbSortMaNCC);
        cmbSortNCC = new JComboBox(NCC);
        cmbSortNCC.setFont(font0);
        cmbSortNCC.setBounds(new Rectangle(370,42,60,30));
        sort.add(cmbSortNCC);
        
        JLabel sortPrice = new JLabel("Giá (VNĐ) :");
        sortPrice.setFont(font0);
        sortPrice.setBounds(450,40,70,30);
        sort.add(sortPrice);
        txtMinPrice = new JTextField();
        txtMinPrice.setFont(font0);
        txtMinPrice.setBounds(new Rectangle(520,42,100,30));
        sort.add(txtMinPrice);
        JSeparator sepPrice = new JSeparator(JSeparator.HORIZONTAL);
        sepPrice.setBounds(630, 56, 10, 6);
        sort.add(sepPrice);
        txtMaxPrice = new JTextField();
        txtMaxPrice.setFont(font0);
        txtMaxPrice.setBounds(new Rectangle(650,42,100,30));
        sort.add(txtMaxPrice);

        JLabel btnSearch = new JLabel("search");
        btnSearch.setBounds(new Rectangle(760,21,63,63));
        btnSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSearch.addMouseListener(new MouseAdapter() {
           public void mouseClicked(MouseEvent e)
           {
               //search();
           }
        });
        sort.add(btnSearch);
         
        //TABLE
        Vector header = new Vector();
        header.add("Mã Sản Phẩm");
        header.add("Tên Sản Phẩm");
        header.add("Số lượng");
        header.add("Đơn Giá");
        header.add("Loại");
        header.add("Mã NCC");
        header.add("IMG"); 
        model = new DefaultTableModel(header,0)
        {
             public Class getColumnClass(int column)
             {
                 switch(column){
                     case 2:
                         return Integer.class;
                     case 3:
                         return Integer.class;
                     default:
                         return String.class;
                 }
             }
                        
        };
        
        tbl = new JTable(model);
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<TableModel>(model);
        tbl.setRowSorter(rowSorter);
        
        tbl.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(100);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(100);

        DefaultTableCellRenderer leftAlign = new DefaultTableCellRenderer();
        leftAlign.setHorizontalAlignment(JLabel.LEFT);
        tbl.getColumnModel().getColumn(2).setCellRenderer(leftAlign);
        tbl.getColumnModel().getColumn(3).setCellRenderer(leftAlign);
        
        // Custom table
        tbl.setFocusable(false);
        tbl.setIntercellSpacing(new Dimension(0,0));     
        tbl.getTableHeader().setFont(font1);
        tbl.setRowHeight(30);
        tbl.setShowVerticalLines(false);              
        tbl.getTableHeader().setOpaque(false);
        tbl.setFillsViewportHeight(true);
        tbl.getTableHeader().setBackground(Color.decode("#006994"));
        tbl.getTableHeader().setForeground(Color.WHITE);
        tbl.setSelectionBackground(new Color(52,152,219));          
        
        //THÊM TABLE VÀO SCROLLPANE
        JScrollPane scroll = new JScrollPane(tbl);
        scroll.setBounds(new Rectangle(10, 360, this.DEFALUT_WIDTH-10, 300));
        scroll.setBackground(null);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(5,100));
        
        add(scroll);
        add(ItemView);
        add(sort);
    }

   
}
