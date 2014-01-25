
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class Pathogen{
	
	
	
	protected double _infectivity, _resistivity, _lethality; 
	
	//infectivity - how quickly the disease will spread! Controls how fast the disease spreads both inside and between countries. 
	//resistivity - a sign of how bad the disease is if you catch it! It will slow down cure research and give you more DNA points. 
	//lethality - How easily the disease can kill someone! It can slow/stop cure research and give you more DNA points.
	
	private int _DNApoints; 
	// DNA points let you evolve. Get them automatically.
	
	public Pathogen(){
		_infectivity = 0; 
		_resistivity = 0; 
		_lethality = 0;
		
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
		b.addActionListener(new ActionListener() {
   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_infectivity);
            	upgradeTransmission();
            	System.out.println(_infectivity);
                System.out.println("You clicked the button");
                
                
            }
    	});
		c.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_infectivity);
            	upgradeTransmission();
            	System.out.println(_infectivity);
                System.out.println("You clicked the button");
                
                
            }
    	});
		d.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeSymptoms();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		e.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeSymptoms();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		f.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeSymptoms();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		g.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeSymptoms();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		h.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_resistivity);
            	upgradeResistivity();
            	System.out.println(_resistivity);
                System.out.println("You clicked the button");
                
                
            }
    	});
		i.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_resistivity);
            	upgradeResistivity();
            	System.out.println(_resistivity);
                System.out.println("You clicked the button");
                
                
            }
    	});
		
	}
	
	//===========================ACTIONS================================
	
	public void increaseDNApoints(int p) {
		_DNApoints += p;
	}
	
	/* transmit works based on infectivity and controls how fast the disease spreads inside countries*/
	public  void transmit(Continent c) {
		c.setInvaded(true); //signifies when the pathogen first enters a continent
		increaseDNApoints(10); //first time a pathogen enters a continent, player receives lotsa points
	}
	
	/* infect works based on infectivity and controls how fast the disease spreads between countries*/
	public void infect(Continent c) {
		if (Math.random() < _infectivity) { 
			if (! c.getInvaded()) { //If it's the first time the continent is being invaded, infect 1 person
				increaseDNApoints(c.setInfected(1));
				
			}
			
			else if (c.getPopulation() == c.getInfected()) {
				return; // if the entire continent has been infected, stop infecting
			}
			else {
				int points = c.getOldInfected() + c.getInfected();
				increaseDNApoints(points);
				c.setOldInfected(c.setInfected(points)); //based on the fib code, infect peeps
			}
			
			
		}
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * resist works based on resistivity and slows down the cure */
	public void resist(Continent c) {
		if (Math.random() < _resistivity) {
			if (c.getCure() >= 1) {
				c.setCure((c.getCure() - 1)); /* if the production of the cure has been started, pathogen
				 								* will start to resist */
												
			}
		}
	}
	
	
	 	
	/* kill works based on lethality and controls how fast the disease wipes out the population*/
	public void kill(Continent c) {
		if (Math.random() < _lethality) {
			if (!c.getInvaded()) {
				return; // if the country hasn't been infected yet, don't kill anyone
			}
			if (c.getDead() == 0) {
				c.setDead(1); // if no one in the country is dead yet, start by killing 1 person
			}
			
			else if (c.getPopulation() == c.getDead()) {
				c.setDeadContinent(true); 
				return; // if everyone has been wiped out, don't do anything
			}
			else {
				int points = c.getOldDead() + c.getDead(); 
				increaseDNApoints(points);
				c.setOldDead(c.setDead(points));
			} // kill ppl based on the fib code
		}
	}
	
	
	//=====================UPGRADES====================== ummm gonna need help with this part 
	/*DNA points help upgrade Transmission */
	public void upgradeTransmission() {
		_DNApoints -= 9; 
		_infectivity += 1; 
	} // upgrades infectivity
	
	/* DNA points help upgrade symptoms */
	public void upgradeSymptoms() {
		_DNApoints -= 9; 
		_lethality += 1; 
	}
	
	/*DNA points help fight the cure */
	public void upgradeResistivity() {
		_DNApoints -= 11; 
		_resistivity += .5; 
	}
	
} //ends class Pathogen
