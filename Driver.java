
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JPanel implements ActionListener{
	
	public static void main (String[] args) {
		
		
		JPanel chooser = new JPanel();
		//chooser.setSize(new Dimension(500,500));
		JButton Bacteria = new JButton("Bacteria");
		Bacteria.addActionListener(new ActionListener() {
   		 
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
            	Bacteria bac = new Bacteria();
                System.out.println("You clicked the button");
                GOOEY gui = new GOOEY();
        		
            }
    	});
		JButton Virus = new JButton("Virus");
		Virus.addActionListener(new ActionListener() {
   		 
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
            	Virus virus = new Virus();
                System.out.println("You clicked the button");
                GOOEY gui = new GOOEY();
        		JButton b = new JButton();
        		JButton c = new JButton();
        		JButton d = new JButton();
        		JButton e = new JButton();
        		JButton f = new JButton();
        		JButton g = new JButton();
        		JButton h = new JButton();
        		JButton i = new JButton();
        		JButton j = new JButton();
        		Upgrades u = new Upgrades(b,c,d,e,f,g,h,i, j);
            }
    	});
		JButton Senioritis = new JButton("Senioritis");
		Senioritis.addActionListener(new ActionListener() {
   		 
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
            	Senioritis senior = new Senioritis();
                System.out.println("You clicked the button");
                GOOEY gui = new GOOEY();
        	
            }
    	});
		chooser.add(Bacteria);
		chooser.add(Virus);
		chooser.add(Senioritis);
		JFrame f1 = new JFrame("Choose Your Pathogen");
		f1.setLocation(500, 500);
        //f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        f1.setContentPane(chooser);
        f1.pack();
        f1.setVisible(true);
		
		Continent NorthAmerica = new Continent(528700000, 0.9); 
		Continent SouthAmerica = new Continent(387500000, 0.2);
		Continent Europe = new Continent(739200000, 0.4); 
		Continent Africa = new Continent(1033000000,0.1); 
		Continent Asia = new Continent(2147482999,0.6); 
		Continent Australia = new Continent(22680000,0.8); 
		
	
	}

	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
