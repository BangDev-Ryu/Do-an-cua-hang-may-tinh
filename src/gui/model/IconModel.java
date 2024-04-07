package gui.model;

import java.awt.Image;
import javax.swing.ImageIcon;

public class IconModel {
    private int width, height;
    private String src_icon;
    
    public IconModel(int w, int h, String s) {
        this.width = w;
        this.height = h;
        this.src_icon = s;
    }
    
    public ImageIcon createIcon() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/" + this.src_icon));
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(this.width, this.height, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        
        return icon;
    }
}
