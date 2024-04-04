package gui;

import javax.swing.JFrame;

public class MainGUI extends JFrame {
    public MainGUI() {
        this.init();
    }
    
    public void init() {
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }
}
