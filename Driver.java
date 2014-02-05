
import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JPanel implements ActionListener{
	
	
	
	
	public Driver(){
		pathogenChoose();
	}
        
	// ===================== VARIABLES ====================================
        private static boolean winner, _submit; 
        private static String game = "continue";
        private static int up = 3, down = 3;

        final static JFrame mapper = new JFrame("Contagion");
	    static Continent NorthAmerica = new Continent(528700000, 0.9, "NA");   
	    static Continent SouthAmerica = new Continent(387500000, 0.2, "SA");
	    static Continent Europe = new Continent(739200000, 0.4, "EU"); 
	    static Continent Africa = new Continent(1033000000,0.1, "AF"); 
	    static Continent Asia = new Continent(2147482999,0.6, "ASIA"); 
	    static Continent Australia = new Continent(22680000,0.8, "AUS"); 
	    
	    
	    static Continent [] ContinentArray = {NorthAmerica, SouthAmerica, 
	    	Europe, Africa, Asia, Australia};
    
      // static Pathogen p = new Pathogen();
       
       protected static double _infectivity = 0;
	protected static double _resistivity = 0;
	protected static double _lethality = 0; 
   	
   	//infectivity - how quickly the disease will spread! Controls how fast the disease spreads both inside and between countries. 
   	//resistivity - a sign of how bad the disease is if you catch it! It will slow down cure research and give you more DNA points. 
   	//lethality - How easily the disease can kill someone! It can slow/stop cure research and give you more DNA points.
   	
   	private static int _DNApoints = 0; 
   	// DNA points let you evolve. Get them automatically.
   	protected static boolean airUp = false ;
	protected static boolean waterUp = false;
	protected static boolean liveStockUp = false;
	protected static boolean buttonPressed = false;
	
	static Driver man;
    
        // =====================================================================    
        
   	
   	
   	public void increaseDNApoints(int p) {
		_DNApoints += p;
	}
	
	/* transmit works based on infectivity and controls how fast the disease spreads inside countries*/
	public  void transmit(Continent c) {
		if (c.getInvaded() == false){
		c.setInvaded(true); //signifies when the pathogen first enters a continent
		c.setInfected(1);
		increaseDNApoints(10); //first time a pathogen enters a continent, player receives lotsa points
		}
	}
	
	/* infect works based on infectivity and controls how fast the disease spreads between countries*/
	public void infect(Continent c) {
		if (!c.getInvaded() || (c.getPopulation() <= c.getInfected())); //If the continent has not been invaded yet, don't infect anyone or if the entire continent has been infected, stop infecting
		else if (Math.random() * 1000 < _infectivity) { 
			int points = c.getOldInfected() + c.getInfected();
				increaseDNApoints(points);
				c.setOldInfected(c.setInfected(points)); //based on the fib code, infect peeps
		
		}
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * resist works based on resistivity and slows down the cure */
	public void resist(Continent c) {
		if (Math.random() * 46 < _resistivity) {
			if (c.getCure() >= 1) {
				c.setCure((c.getCure() - 1)); /* if the production of the cure has been started, pathogen
				 								* will start to resist */									
			}
		}
	}
	
	
	 	
	/* kill works based on lethality and controls how fast the disease wipes out the population*/
	public void kill(Continent c) {
		if (Math.random() * 46 < _lethality) {
			if (!c.getInvaded()) {
				return; // if the country hasn't been infected yet, don't kill anyone
			}
			else if (c.getDead() == 0) {
				c.setDead(1); // if no one in the country is dead yet, start by killing 1 person
				c.setOldInfected(c.getOldInfected() - 1);
				c.setInfected(c.getInfected() - 1);
			}
			
			else if (c.getPopulation() <= c.getDead()) {
				c.setDeadContinent(true); 
				c.setInvaded(true);
			}
			else {
				int points = c.getOldDead() + c.getDead(); 
				increaseDNApoints(points);
				c.setOldInfected(c.getOldInfected()  - points);
				c.setInfected(c.getInfected() - points);
			}
				if (c.getOldInfected() < 0) {
					c.setOldInfected(0);
				}
				if (c.getInfected() < 0) {
					c.setOldInfected(0);
					c.setInfected(0);
				}
			} // kill ppl based on the fib code
			
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
	public static void upgradeTransmissionAir() {
		if (_DNApoints > 12 && airUp == false) {
			
			_DNApoints -= 12; 
			_infectivity += 3; 
			}
			else{
				System.out.println("You already upgraded this");
			}
	} // upgrades infectivity
	
	public static void upgradeTransmissionWater() {
		if (_DNApoints < 10) {
			return; 
		}
		_DNApoints -= 10; 
		_infectivity += 2; 
	} // upgrades infectivity
	
	public static void upgradeTransmissionLivestock() {
		if (_DNApoints < 9) {
			return; 
		}
		_DNApoints -= 9; 
		_infectivity += 1; 
	} // upgrades infectivity
	
	/* DNA points help upgrade symptoms */
	public static void upgradeSymptomsInsomnia() {
		if (_DNApoints < 8) {
			return; 
		}
		_DNApoints -= 8; 
		_lethality += 1; 
	}
	
	/* DNA points help upgrade symptoms */
	public static void upgradeSymptomsParanoia() {
		if (_DNApoints < 9) {
			return; 
		}
		_DNApoints -= 9; 
		_lethality += 2; 
	}
	
	/* DNA points help upgrade symptoms */
	public static void upgradeSymptomsParalysis() {
		if (_DNApoints < 12) {
			return; 
		}
		_DNApoints -= 12; 
		_lethality += 3; 
	}
	
	/* DNA points help upgrade symptoms */
	public static void upgradeSymptomsComa() {
		if (_DNApoints < 12) {
			return; 
		}
		_DNApoints -= 12; 
		_lethality += 3; 
	}
	
	/*DNA points help fight the cure */
	public static void upgradeResistivityGenetic() {
		if (_DNApoints < 11) {
			return; 
		}
		_DNApoints -= 11; 
		_resistivity += 1; 
	}
	
	/*DNA points help fight the cure */
	public static void upgradeResistivityDrug() {
		if (_DNApoints < 12) {
			return; 
		}
		_DNApoints -= 12; 
		_resistivity += 2; 
	}
   	
        
        //game play 
	    public static void gamePlay() {
	    	
	    		
	                //System.out.println("ahhh");
	    			
	                for (Continent c: ContinentArray) {
	                        man.infect(c);        //infects population of invaded continents  
	                        //Thread.sleep(50);
	                        if (c.getInfected() > c.getPopulation()){
	                        	
	                        	c.setInfected(c.getPopulation());
	                        	
	                        }
	                        System.out.println(c.get_nickname() +  c.getInfected());
	                }
	                

	                man.transmit(ContinentArray[(int)(Math.random() * 6)] ); //transmits to a random continent
	                man.resist(NorthAmerica);  //resists cure (doesn't matter of which continent because cure is static)
	                /*
	                for (Continent c: ContinentArray) {
	                        pathogen.kill(c);  //kills population of infected continents
	                }
	                */
	                for (Continent c: ContinentArray) {
	                        if (c.getDeadContinent() == true ); // if the continent is dead, it cannot contribute to the cure 
	                        else {
	                                c.produceCure(); // every infected (& alive) country produces a cure 
	                }
	              
	                }
	                for (Continent c: ContinentArray) {
	                        c.Cure(); // cures every continent that needs it
	                        if (c.getInfected() < 0) {
	                        	c.setInfected(0);
	                        }
	                        if (c.getOldInfected() < 0) {
	                        	c.setOldInfected(0);
	                        }                      
	                }

	                for (Continent c: ContinentArray) {
	                        int counterDead = 0; //counter for the # of dead continents 
	                        if (c.getDeadContinent() == true) { // checks if continent is dead
	                                counterDead += 1; 
	                        }
	                        if (counterDead == 6) { // if all 6 continents are dead, the player is a winner 
	                                winner = true; 
	                                game = "stop";
	                                break;
	                        }
	                        int counterHealthy = 0; //counter for the # of healthy continents
	                        if (c.getInvaded() == false) { //checks if continent is healthy
	                                counterHealthy += 1; 
	                        }
	                        if (counterHealthy == 6) { // if all 6 continents are healthy, the player is a loser
	                                winner = false;
	                                game = "stop";
	                                break;
	                        }
	                }
	                System.out.println("U SEE ME!");

	             
	                
	    	}
	                
	    
	    
    	public static void Submitter() {
    		final JPanel stats = new JPanel(); 
            final JFrame f3 = new JFrame("STATS!");
            //gamePlay();
            if (game.equals("stop")) {
                if (winner) {
                    System.out.println("CONGRATS YOU WON!");
            }
                else {
                    System.out.println("Good luck next time buddy. You lost.");
                }
            }
            else {
          
            }

			JTextArea attributes = new JTextArea(" DNApoints: "
	        + man.getDNApoints()
	        + "\nInfectivity: "
	        + man.getInfectivity()
	        +"\nResistivity: "
	        + man.getResistivity()
	        +"\nLethality: "
	        + man.getLethality()); 
	        stats.add(attributes);
	        f3.setLocation(100, 300);
	        f3.setContentPane(stats);
	        f3.pack();
	        f3.setVisible(true);
    	}

                
            public static void Continental(){
        		final JPanel ConChooser = new JPanel(); //choose continent
                final JFrame f2 = new JFrame("Choose your Continent");
                JButton NA = new JButton("North America");
            NA.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    man.transmit(NorthAmerica);     
                    f2.dispose();   
                    gamePlay();
                    
            }
            });
                
                JButton SA = new JButton("South America");
                SA.addActionListener(new ActionListener() {
                  
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    man.transmit(SouthAmerica);
                    f2.dispose();  
                    gamePlay();
            }
            });
                
                JButton E = new JButton("Europe");
                E.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    man.transmit(Europe);
                    f2.dispose(); 
                    
						gamePlay();
					
					                  
            }
            });
                
                JButton AF = new JButton("Africa");
                AF.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    man.transmit(Africa);
                    f2.dispose();
                    
						gamePlay();
					
					                
            }
            });
                
                JButton AS = new JButton("Asia");
                AS.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    man.transmit(Asia);                    
                    f2.dispose();
                    gamePlay();         
            }
            });
                
                JButton AU = new JButton("Australia");
                AU.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    man.transmit(Australia);
                    f2.dispose();
                    gamePlay(); 
            }
            });
                
                ConChooser.add(NA);
                ConChooser.add(SA);
                ConChooser.add(E);
                ConChooser.add(AF);
                ConChooser.add(AS);
                ConChooser.add(AU);
                
                f2.setLocation(500, 500);
                f2.setContentPane(ConChooser);
                f2.pack();
                f2.setVisible(true);  
            }
            
        public static void pathogenChoose(){
        	final JFrame f1 = new JFrame("Choose Your Pathogen");
            JPanel chooser = new JPanel(); // choose pathogen
                
            //===================== BACTERIA ======================
            JButton Bacteria = new JButton("Bacteria");
            Bacteria.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {              
                //p = new Bacteria(); 
                Continental();     
                EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					GOOEY window = new GOOEY();
        					window.frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		}); 
                f1.dispose();
                            
            }
            });
                
            //===================== VIRUS ======================    
            JButton Virus = new JButton("Virus");
            Virus.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                  //  p = new Virus();                    
                    EventQueue.invokeLater(new Runnable() {
            			public void run() {
            				try {
            					GOOEY window = new GOOEY();
            					window.frame.setVisible(true);
            				} catch (Exception e) {
            					e.printStackTrace();
            				}
            			}
            		}); 
                    
                f1.dispose();
                
                Continental();     
            }
            });
                
            //===================== SENIORITIS ======================    
            JButton Senioritis = new JButton("Senioritis");
            Senioritis.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    //p = new Senioritis();
                    EventQueue.invokeLater(new Runnable() {
            			public void run() {
            				try {
            					GOOEY window = new GOOEY();
            					window.frame.setVisible(true);
            				} catch (Exception e) {
            					e.printStackTrace();
            				}
            			}
            		});
                f1.dispose();
                Continental(); 
            }
            });
                chooser.add(Bacteria);
                chooser.add(Virus);
                chooser.add(Senioritis);
                
                f1.setLocation(500, 500);
                f1.setContentPane(chooser);
                f1.pack();
                f1.setVisible(true);   
                                                
        }
        
          
                
        public static void main (String[] args) {
        	man = new Driver();
        	//man.Pathogen();
        	
            
        }
        @Override
        public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
        }
}