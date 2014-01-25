package test;

import javax.swing.JButton;

public class Senioritis extends Pathogen {
	
	public Senioritis () {
		
		_infectivity = 50; 
		_resistivity = 20; 
		_lethality = 20; 
		
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
