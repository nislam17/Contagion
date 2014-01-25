
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
public class Upgrades extends JPanel implements ActionListener{
	
    public Upgrades(JButton a, JButton b, JButton c, 
    		JButton d, JButton e, JButton f, JButton g, JButton h, JButton i) {
    	super(new GridLayout(100,100));

    	// ================ SETTING ACTION LISTENERS ===============
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
        //===========================================================       
    	//JPanel mainPanel = new JPanel();
    	//mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 300, 100)); 
    	JTabbedPane tabbedPane = new JTabbedPane();
    	

    	JComponent panel1 = makeTextPanel("Panel #1");
    	tabbedPane.addTab("Transmission", null, panel1,
    	                  "Does nothing");
    	//tabbedPane.setTabPlacement(JTabbedPane.CENTER);
    	tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
    	panel1.setPreferredSize(new Dimension(410, 100));
    	panel1.add(a);
    	panel1.add(b);
    	panel1.add(c);
    	
    	
    	JComponent panel2 = makeTextPanel("Panel #2");
    	tabbedPane.addTab("Symptoms", null, panel2,
    	                  "Does twice as much nothing");
    	tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
    	panel2.setPreferredSize(new Dimension(410, 100));
    	panel2.add(d);
    	panel2.add(e);
    	panel2.add(g);
    	panel2.add(h);

    	JComponent panel3 = makeTextPanel("Panel #3");
    	tabbedPane.addTab("Fight the Cure", null, panel3,
    	                  "Still does nothing");
    	tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
    	panel3.add(h);
    	panel3.add(i);
    	
    	
    	add(tabbedPane);
    	
    	/*
    	mainPanel.add(a);
    	mainPanel.add(b);
    	mainPanel.add(c);
    	mainPanel.add(d);
    	mainPanel.add(e);
    	mainPanel.add(f);
    	mainPanel.add(g);
    	mainPanel.add(h);
    	mainPanel.add(i);
    	*/
    	
        JFrame f1 = new JFrame("Upgrades");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
        f1.setContentPane(tabbedPane);
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
	 protected JComponent makeTextPanel(String text) {
	        JPanel panel = new JPanel(false);
	        JLabel filler = new JLabel(text);
	        filler.setHorizontalAlignment(JLabel.CENTER);
	        panel.setLayout(new GridLayout(1, 1));
	        panel.add(filler);
	        return panel;
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}


