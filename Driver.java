import javax.swing.*;

import java.awt.*;

public class Driver {

	public static void main (String[] args) {
		Continent NorthAmerica = new Continent(528700000, 0.9); 
		Continent SouthAmerica = new Continent(387500000, 0.2);
		Continent Europe = new Continent(739200000, 0.4); 
		Continent Africa = new Continent(1033000000,0.1); 
		Continent Asia = new Continent(2147482999,0.6); 
		Continent Australia = new Continent(22680000,0.8); 
		
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
}