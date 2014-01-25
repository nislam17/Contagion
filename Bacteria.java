import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Bacteria extends Pathogen {
	
	public Bacteria () {
		
		_infectivity = 15; 
		_resistivity = 1; 
		_lethality = 1; 
		
		JButton a = new JButton();
		JButton b = new JButton();
		JButton c = new JButton();
		JButton d = new JButton();
		JButton e = new JButton();
		JButton f = new JButton();
		JButton g = new JButton();
		JButton h = new JButton();
		JButton i = new JButton();
		Upgrades u = new Upgrades(a,b,c,d,e,f,g,h,i);
		
		a.addActionListener(new ActionListener() {
   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_infectivity);
            	upgradeTransmission();
            	System.out.println(_infectivity);
                System.out.println("You clicked the button");
                

            }
    	});
	} 
}