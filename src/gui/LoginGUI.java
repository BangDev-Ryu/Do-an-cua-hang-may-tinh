package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class LoginGUI extends JFrame implements MouseListener {
    private JPanel pn_header;
    private JPanel pn_center;
    private JPanel pn_south;
    private JTextField tf_user;
    private JPasswordField tf_password;
    private JButton btn_login;
    private JLabel lb_error_noti;
    private JLabel lb_show;
    private JLabel lb_hide;
    
    public LoginGUI() {
        init();
    }
    
    public void init() {
        this.setUndecorated(true);
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.pn_header = pnHeader();
        this.pn_center = pnCenter();
        this.pn_south = pnSouth();
        
        this.setLayout(new BorderLayout());
        this.add(pn_header, BorderLayout.NORTH);
        this.add(pn_center, BorderLayout.CENTER);
        this.add(pn_south, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    public JPanel pnHeader() {
        JPanel hd = new JPanel();
        hd.setLayout(new BorderLayout());
        
        JLabel lb_exit = new JLabel("", JLabel.CENTER);
        lb_exit.setOpaque(true);
        lb_exit.setBackground(Color.decode("#FFFFFF"));
        lb_exit.setPreferredSize(new Dimension(30, 30));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/close-1.png"));
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        lb_exit.setIcon(icon);
        
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
                lb_exit.setBackground(Color.decode("#006270"));            
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lb_exit.setBackground(Color.decode("#FFFFFF"));
            }
        
        });
        
        hd.setPreferredSize(new Dimension(400, 30));
        hd.add(lb_exit, BorderLayout.EAST);
        
        return hd;
    }
    
    public JPanel pnCenter() {
        JPanel pn_ct = new JPanel();
        pn_ct.setPreferredSize(new Dimension(400, 370));
        pn_ct.setLayout(new BorderLayout());
        
        JPanel pn_login = new JPanel();
        pn_login.setPreferredSize(new Dimension(400, 200));
        pn_login.setLayout(new BorderLayout());
        
        // Label icon and text login
        JLabel lb_icon_login = new JLabel("", JLabel.CENTER);
        lb_icon_login.setPreferredSize(new Dimension(110, 110));
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/user-circle-1.png"));
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(110, 110, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        lb_icon_login.setIcon(icon);
        
        Font font_login = new Font("Bordeaux Roman Bold LET", Font.BOLD, 25);
        JLabel lb_text_login = new JLabel("LOGIN", JLabel.CENTER);
        lb_text_login.setPreferredSize(new Dimension(200, 30));
        lb_text_login.setForeground(Color.decode("#009394"));
        lb_text_login.setFont(font_login);
        
        pn_login.add(lb_icon_login, BorderLayout.CENTER);
        pn_login.add(lb_text_login, BorderLayout.SOUTH);
        
        // Textfield user and password
        JPanel pn_textfield = new JPanel();
        pn_textfield.setPreferredSize(new Dimension(400, 200));
        pn_textfield.setLayout(new FlowLayout(1, 40, 30));
        
        Dimension d_txtfield = new Dimension(250, 30);
        this.tf_user = new JTextField();
        this.tf_user.setPreferredSize(d_txtfield);
        this.tf_password = new JPasswordField();
        this.tf_password.setPreferredSize(d_txtfield);
        this.tf_user.setBorder(BorderFactory.createLineBorder(Color.decode("#00E0C7"), 2));
        this.tf_password.setBorder(BorderFactory.createLineBorder(Color.decode("#00E0C7"), 2));
       
        JPanel pn_username = new JPanel();
        pn_username.setLayout(new FlowLayout());
        pn_username.setPreferredSize(new Dimension(250, 50));
        JPanel pn_password = new JPanel();
        pn_password.setLayout(new FlowLayout());
        pn_password.setPreferredSize(new Dimension(250, 50));
        
        Font font_user_pass = new Font("Bordeaux Roman Bold LET", Font.CENTER_BASELINE, 13);
        JLabel lb_username = new JLabel("Username");
        lb_username.setPreferredSize(new Dimension(250, 10));
        lb_username.setForeground(Color.decode("#00E0C7"));
        lb_username.setFont(font_user_pass);
        
        JLabel lb_password = new JLabel("Password");
        lb_password.setPreferredSize(new Dimension(250, 10));
        lb_password.setForeground(Color.decode("#00E0C7"));
        lb_password.setFont(font_user_pass);
        
        // set icon show
        this.tf_password.setLayout(null);
        lb_show = new JLabel("", JLabel.CENTER);
        ImageIcon icon_show = new ImageIcon(getClass().getResource("/img/password-is-show.png"));
        Image img_show = icon_show.getImage();
        Image newimg_show = img_show.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon_show = new ImageIcon(newimg_show);
        lb_show.setIcon(icon_show);
        lb_show.setOpaque(true);
        lb_show.setBackground(Color.decode("#FFFFFF"));
        
        // set icon hide 
        lb_hide = new JLabel("", JLabel.CENTER);
        ImageIcon icon_hide = new ImageIcon(getClass().getResource("/img/password-is-hide.png"));
        Image img_hide = icon_hide.getImage();
        Image newimg_hide = img_hide.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        icon_hide = new ImageIcon(newimg_hide);
        lb_hide.setIcon(icon_hide);
        lb_hide.setOpaque(true);
        lb_hide.setBackground(Color.decode("#FFFFFF"));
              
        this.lb_show.setBounds(225, 5, 20, 20);
        this.lb_hide.setBounds(225, 5, 20, 20);
        this.lb_show.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        this.lb_hide.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

        
        this.lb_hide.addMouseListener(this);
        this.lb_show.addMouseListener(this);
        
        this.tf_password.add(this.lb_hide);
        this.tf_password.setEchoChar('*');
        
        pn_username.add(lb_username);
        pn_username.add(this.tf_user);
        pn_password.add(lb_password);
        pn_password.add(this.tf_password);
        
        pn_textfield.add(pn_username);
        pn_textfield.add(pn_password);
        
        pn_ct.add(pn_login, BorderLayout.CENTER);
        pn_ct.add(pn_textfield, BorderLayout.SOUTH);
        
        return pn_ct;
    }
    
    public JPanel pnSouth() {
        JPanel pn_footer = new JPanel();
        pn_footer.setPreferredSize(new Dimension(400, 100));
        pn_footer.setLayout(new FlowLayout(1));
        
        this.btn_login = new JButton("Login");
        this.btn_login.setPreferredSize(new Dimension(200, 30));
        this.btn_login.setBackground(Color.decode("#009394"));
        this.btn_login.setForeground(Color.decode("#FFFFFF"));
        
        this.lb_error_noti = new JLabel("", JLabel.CENTER);
        this.lb_error_noti.setPreferredSize(new Dimension(200, 30));
        
        pn_footer.add(this.btn_login);
        pn_footer.add(this.lb_error_noti);
        
        return pn_footer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel src = (JLabel) e.getSource();
        if (src.equals(this.lb_hide)) {
            this.tf_password.setEchoChar((char)0);
            this.tf_password.removeAll();
            this.tf_password.add(this.lb_show);
        }
        if (src.equals(this.lb_show)) {
            this.tf_password.setEchoChar('*');
            this.tf_password.removeAll();
            this.tf_password.add(this.lb_hide);
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
