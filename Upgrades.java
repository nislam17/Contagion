import javax.swing.*;

import java.net.*;
 
public class Upgrades {
	
	

    public Upgrades(JButton a, JButton b, JButton c, 
    		JButton d, JButton e, JButton f, JButton g, JButton h) {
    	JPanel p = new JPanel();
    	
    	p.add(a);
    	p.add(b);
    	p.add(c);
    	p.add(d);
    	p.add(e);
    	p.add(f);
    	p.add(g);
    	p.add(h);
    	 p.setBorder(BorderFactory.createEmptyBorder(100, 100, 700, 100));  
    	
    	
        JFrame f1 = new JFrame("Upgrades");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        f1.setContentPane(p);
        f1.pack();
        f1.setVisible(true);
        buttoner(a);
        buttoner(b);
        buttoner(c);
        buttoner(d);
        buttoner(e);
        buttoner(f);
        buttoner(g);
        buttoner(h);
    }
    
    public void buttoner(JButton b){
    	ImageIcon red = new ImageIcon("red.png");
    	ImageIcon gray = new ImageIcon("gray.png");
    
        
        b.setIcon(red);
        b.setRolloverIcon(gray);
        
        
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setRolloverEnabled(true);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
    }
    

}
