package gui.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NavModel extends JPanel implements MouseListener {
    private int width, height;
    private JLabel icon, label;
    private Color color_normal, color_hover;
    private boolean active;
    private String nav_name, nav_icon, nav_icon_hover;
    
    public NavModel(String n, int w, int h, String icon, String icon_hover, Color normal, Color hover) {
        this.nav_name = n;
        this.width = w;
        this.height = h;
        this.nav_icon = icon;
        this.nav_icon_hover = icon_hover;
        this.color_normal = normal;
        this.color_hover = hover;
        this.init();
    }
    
    public void init() {
        this.addMouseListener(this);
        Font font = new Font("Segoe UI",Font.BOLD,13);
        this.setPreferredSize(new Dimension(this.width, this.height));
        this.setLayout(null);
        this.setBackground(this.color_normal);
        
        // khoi tao icon va label
        this.icon = new JLabel("", JLabel.CENTER);
        this.label = new JLabel(this.nav_name);
        
        // thiet ke label icon
        IconModel icon_model = new IconModel(20, 20, this.nav_icon);
        this.icon.setBounds(0, 0, 50, 50);
        this.icon.setIcon(icon_model.createIcon());
        
        // thiet ke label
        this.label.setBounds(60, 0, 150, 50);
        this.label.setFont(font);
        this.label.setForeground(Color.decode("#FFFFFF"));
        this.label.setBackground(this.color_normal);
        
        this.add(icon);
        this.add(label);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(this.color_hover);
        this.label.setForeground(color_normal);
        IconModel i = new IconModel(20, 20, this.nav_icon_hover);
        this.icon.setIcon(i.createIcon());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(this.color_normal);
        this.label.setForeground(color_hover);
        IconModel i = new IconModel(20, 20, this.nav_icon);
        this.icon.setIcon(i.createIcon());
    }
}
