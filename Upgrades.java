import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class Upgrades implements ActionListener{
	
	//JButton x = new JButton();

    public Upgrades(JButton a, JButton b, JButton c, 
    		JButton d, JButton e, JButton f, JButton g, JButton h, JButton i) {
    	
    	//Border subject = BorderFactory.createEmptyBorder();
    	/*Border lineBorder = 
    			BorderFactory.createTitledBorder
    			(subject, "Upgrades", 50, 50, 
    					new Font("Courier New",Font.ITALIC,12), Color.BLACK);
    	JPanel title = new JPanel();
    	title.setBorder(lineBorder);
    	*/
    	JPanel mainPanel = new JPanel();
    	
    	a.setText("Air");
    	a.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	b.setText("Water");
    	b.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	c.setText("Livestock");
    	c.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	d.setText("Insomnia");
    	d.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	e.setText("Paranoia");
    	e.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	f.setText("Paralysis");
    	f.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	g.setText("Coma");
    	g.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	h.setText("Genetic Reshuffle");
    	h.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	i.setText("Drug Resistance");
    	i.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
                //Execute when button is pressed
                System.out.println("You clicked the button");
            }
    	});
    	//mainPanel.add(title);
    	mainPanel.add(a);
    	mainPanel.add(b);
    	mainPanel.add(c);
    	mainPanel.add(d);
    	mainPanel.add(e);
    	mainPanel.add(f);
    	mainPanel.add(g);
    	mainPanel.add(h);
    	mainPanel.add(i);
    	mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 600, 100));  
    	
    	
        JFrame f1 = new JFrame("Upgrades");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        f1.setContentPane(mainPanel);
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
        buttoner(i);
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





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    }
