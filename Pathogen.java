import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pathogen{

	protected double _infectivity = 0, _resistivity = 0, _lethality = 0; 
	
	//infectivity - how quickly the disease will spread! Controls how fast the disease spreads both inside and between countries. 
	//resistivity - a sign of how bad the disease is if you catch it! It will slow down cure research and give you more DNA points. 
	//lethality - How easily the disease can kill someone! It can slow/stop cure research and give you more DNA points.
	
	private int _DNApoints = 0; 
	// DNA points let you evolve. Get them automatically.
	private boolean airUp = false;
	public Pathogen(){
		_infectivity = 0; 
		_resistivity = 0; 
		_lethality = 0;
		
		JButton a = new JButton(); //air
		JButton b = new JButton(); //water
		JButton c = new JButton(); //livestock
		JButton d = new JButton(); //insomnia
		JButton e = new JButton(); //paranoia
		JButton f = new JButton(); //paralysis
		JButton g = new JButton(); //coma 
		JButton h = new JButton(); //genetic reshuffle
		JButton i = new JButton(); //drug resistance
		Upgrades u = new Upgrades(a,b,c,d,e,f,g,h,i);
		Driver driver = new Driver();
		
		a.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	
            	upgradeTransmissionAir();
            	airUp = true;
            	Driver.Submitter();

            }
    	});
		b.addActionListener(new ActionListener() {
   		 
            public void actionPerformed(ActionEvent e)
            {
            	
            	upgradeTransmissionWater();
            
                
                
            }
    	});
		c.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            
            	upgradeTransmissionLivestock();
            
                
            }
    	});
		d.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeSymptomsInsomnia();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		e.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeSymptomsParanoia();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		f.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeSymptomsParalysis();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		g.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeSymptomsComa();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		h.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_lethality);
            	upgradeResistivityGenetic();
            	System.out.println(_lethality);
                System.out.println("You clicked the button");
                
                
            }
    	});
		i.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	System.out.println(_resistivity);
            	upgradeResistivityDrug();
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
		if (c.getInvaded()); //If the continent has not been invaded yet, don't infect anyone
		else if (c.getPopulation() == c.getInfected()); // if the entire continent has been infected, stop infecting
		else if (Math.random() < _infectivity) { 
			
				int points = c.getOldInfected() + c.getInfected();
				increaseDNApoints(points);
				c.setOldInfected(c.setInfected(points)); //based on the fib code, infect peeps
			
			
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
	
	//====================Accessor methods========================
	public int getDNApoints() {
		return _DNApoints;
	}
	
	public double getInfectivity() {
		return _infectivity;
	}
	
	public double getResistivity() {
		return _resistivity; 
		
	}
	
	public double getLethality() {
		return _lethality;
	}
	
	//=====================UPGRADES====================== 
	/*DNA points help upgrade Transmission */
	public void upgradeTransmissionAir() {
		if (_DNApoints > 12 && airUp == false) {
			
			_DNApoints -= 12; 
			_infectivity += 3; 
			}
			else
				System.out.println("You already upgraded this");
	} // upgrades infectivity
	
	public void upgradeTransmissionWater() {
		if (_DNApoints < 10) {
			return; 
		}
		_DNApoints -= 10; 
		_infectivity += 2; 
	} // upgrades infectivity
	
	public void upgradeTransmissionLivestock() {
		if (_DNApoints < 9) {
			return; 
		}
		_DNApoints -= 9; 
		_infectivity += 1; 
	} // upgrades infectivity
	
	/* DNA points help upgrade symptoms */
	public void upgradeSymptomsInsomnia() {
		if (_DNApoints < 8) {
			return; 
		}
		_DNApoints -= 8; 
		_lethality += 1; 
	}
	
	/* DNA points help upgrade symptoms */
	public void upgradeSymptomsParanoia() {
		if (_DNApoints < 9) {
			return; 
		}
		_DNApoints -= 9; 
		_lethality += 2; 
	}
	
	/* DNA points help upgrade symptoms */
	public void upgradeSymptomsParalysis() {
		if (_DNApoints < 12) {
			return; 
		}
		_DNApoints -= 12; 
		_lethality += 3; 
	}
	
	/* DNA points help upgrade symptoms */
	public void upgradeSymptomsComa() {
		if (_DNApoints < 12) {
			return; 
		}
		_DNApoints -= 12; 
		_lethality += 3; 
	}
	
	/*DNA points help fight the cure */
	public void upgradeResistivityGenetic() {
		if (_DNApoints < 11) {
			return; 
		}
		_DNApoints -= 11; 
		_resistivity += 1; 
	}
	
	/*DNA points help fight the cure */
	public void upgradeResistivityDrug() {
		if (_DNApoints < 12) {
			return; 
		}
		_DNApoints -= 12; 
		_resistivity += 2; 
	}
} //ends class Pathogen
