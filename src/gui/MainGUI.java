package gui;

import gui.model.IconModel;
import gui.model.NavModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGUI extends JFrame implements MouseListener {
    private int width = 1200, height = 700;
    private JPanel header, nav, main;
    private ArrayList<String> navName = new ArrayList<>();
    private ArrayList<NavModel> navModel = new ArrayList<>(); 
    
    public MainGUI() {
        this.init();
    }
    
    public void init() {
        this.setSize(this.width, this.height);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        
        this.header = createHeader();
        this.nav = createNav();
        this.main = new JPanel(new BorderLayout());
        this.main.setBackground(Color.decode("#FFFFFF"));
        
        this.setLayout(new BorderLayout());
        this.add(this.header, BorderLayout.NORTH);
        this.add(this.nav, BorderLayout.WEST);
        this.add(this.main, BorderLayout.CENTER);
        
        this.setVisible(true);
    }
    
    // TAO HEADER   
    public JPanel createHeader() {
        JPanel pn_header = new JPanel();
        pn_header.setLayout(new BorderLayout());
        pn_header.setPreferredSize(new Dimension(this.width, 30));
        pn_header.setBackground(Color.decode("#006270"));

        JLabel lb_exit = new JLabel("", JLabel.CENTER);
        lb_exit.setOpaque(true);
        lb_exit.setBackground(Color.decode("#006270"));
        lb_exit.setPreferredSize(new Dimension(30, 30));
        
        IconModel icon_exit = new IconModel(10, 10, "close-white.png");
        lb_exit.setIcon(icon_exit.createIcon());
        
        lb_exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lb_exit.setBackground(Color.decode("#009394"));            
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lb_exit.setBackground(Color.decode("#006270"));
            }
        
        });
        
        pn_header.add(lb_exit, BorderLayout.EAST);
        
        return pn_header;
    } 
    
    // TAO THANH MENU NAVIGATION
    public JPanel createNav() {
        JPanel pn_nav = new JPanel();
        pn_nav.setLayout(new FlowLayout(1, 0, 0));
        pn_nav.setPreferredSize(new Dimension(200, this.height - 30));
        pn_nav.setBackground(Color.decode("#006270"));
//        pn_nav.setBorder(BorderFactory.createLineBorder(Color.decode("#00E0C7")));
        
        // add avatar
        JLabel lb_ava = new JLabel();
        lb_ava.setPreferredSize(new Dimension(200, 100));
        lb_ava.setOpaque(true);
        lb_ava.setBackground(Color.decode("#009394"));
        
        pn_nav.add(lb_ava);
        
        // add navigation menu
        this.navName.add("Bán hàng:cart-white.png:cart-1.png");
        this.navName.add("Nhập hàng:cart-white.png:cart-1.png");
        this.navName.add("Sản phẩm:laptop-white.png:laptop-1.png");
        this.navName.add("Nhân viên:employee-white.png:employee-1.png");
        this.navName.add("Khách hàng:people-white.png:people-1.png");
        this.navName.add("Nhà cung cấp:delivery-white.png:delivery-1.png");
        this.navName.add("Hóa đơn:task-white.png:task-1.png");
        this.navName.add("Phiếu nhập:task-white.png:task-1.png");        
        
        // tao nav item menu
        for (int i = 0; i < navName.size(); i++) {
            String[] parts = navName.get(i).split(":");
            navModel.add(new NavModel(parts[0], 200, 50, parts[1], parts[2], Color.decode("#006270"), Color.decode("#009394")));
            navModel.get(i).addMouseListener(this);
        }
        
        for (NavModel obj : navModel) {
            pn_nav.add(obj);
        }
        
        return pn_nav;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < navModel.size(); i++) {
            NavModel item = navModel.get(i);
            if (e.getSource() == item) {
                item.actived();
                changeMain(i);
            }
            else {
                item.noActived();
            }    
        }
    }
    
    public void changeMain(int i) {
        switch (i) {
            case 0: // ban hang
                break;
            case 1: // nhap hang
                break;
            case 2: // san pham 
                main.removeAll();
                main.add(new SanPhamGUI(1000, 670));
                main.repaint();
                main.validate();
                break;
            case 3: // nhan vien
                break;
            case 4: // khach hang
                break;
            case 5: // nha cung cap
                main.removeAll();
                main.add(new NhaCungCapGUI(1000, 670));
                main.repaint();
                main.validate();
                break;
            case 6: // hoa don
                break;
            case 7: // phieu nhap
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
