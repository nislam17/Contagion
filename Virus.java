import javax.swing.JButton;

import test.Pathogen;
import test.Upgrades;

public class Virus extends Pathogen {
	
	public Virus () {
		
		_infectivity = 10; 
		_resistivity = 1; 
		_lethality = 5; 
		
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
	
}
