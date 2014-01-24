import javax.swing.*;

import java.net.*;
 
public class Upgrades {
 
    public Upgrades() throws MalformedURLException{
    
    	ImageIcon red = new ImageIcon("red.png");
    	ImageIcon gray = new ImageIcon("gray.png");
    
        JButton b = new JButton("Round");
        b.setIcon(red);
        b.setRolloverIcon(gray);
        
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setRolloverEnabled(true);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
 
    JFrame f = new JFrame("round button test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        //p.add(b0);
        p.add(b);
        f.setContentPane(p);
        f.pack();
        f.setVisible(true);
    }
    
    public static void main(String[] args) throws MalformedURLException{
    	Upgrades u = new Upgrades();
    }
}
