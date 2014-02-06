import javax.swing.*;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JPanel implements ActionListener{
	
	public static void drive(){
		pathogenChoose();
	}
        
	// ===================== VARIABLES ====================================
        private static boolean winner;
        protected static String game = "continue";
        protected static int counter = 0; 

       
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
		protected static int _DNApoints = 0; 
   	
	   	//infectivity - how quickly the disease will spread! Controls how fast the disease spreads both inside and between countries. 
	   	//resistivity - a sign of how bad the disease is if you catch it! It will slow down cure research and give you more DNA points. 
	   	//lethality - How easily the disease can kill someone! It can slow/stop cure research and give you more DNA points.
		// DNA points let you evolve. Get them automatically.
	
        // =====================================================================    

	   	public static void increaseDNApoints(int p) {
			_DNApoints += p;
		}
		
		/* transmit works based on infectivity and controls how fast the disease spreads inside countries*/
		public static  void transmit(Continent c) {
			if (c.getInvaded() == false){
			c.setInvaded(true); //signifies when the pathogen first enters a continent
			c.setInfected(1);
			increaseDNApoints(1); //first time a pathogen enters a continent, player receives lotsa points
			}
		}
		
		/* infect works based on infectivity and controls how fast the disease spreads between countries*/
		public static void infect(Continent c) {
			if (!c.getInvaded() || (c.getPopulation() <= c.getInfected())); //If the continent has not been invaded yet, don't infect anyone or if the entire continent has been infected, stop infecting
			else if (Math.random() * 300 < _infectivity) { 
				long points = c.getOldInfected() + c.getInfected();
					increaseDNApoints((int)(Math.random() * 15) + 1);
					c.setOldInfected(c.setInfected(points)); //based on the fib code, infect peeps
			
			}
		}
		
		/*Pre-cond: 
		 * Post-cond: 
		 * resist works based on resistivity and slows down the cure */
		public static void resist(Continent c) {
			if (Math.random() * 46 < _resistivity) {
				if (c.getCure() >= 1) {
					c.setCure((c.getCure() - 1)); /* if the production of the cure has been started, pathogen
					 								* will start to resist */									
				}
			}
		}
		
		
		 	
		/* kill works based on lethality and controls how fast the disease wipes out the population*/
		public static void kill(Continent c) {
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
					long points = c.getOldDead() + c.getDead(); 
					increaseDNApoints((int)(Math.random() * 5) + 1);
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
		public static int getDNApoints() {
			return _DNApoints;
		}
		
		public static double getInfectivity() {
			return _infectivity;
		}
		
		public static double getResistivity() {
			return _resistivity; 
			
		}
		
		public static double getLethality() {
			return _lethality;
		}
		
	
        //game play 
	    public static void gamePlay() {
				
	            for (Continent c: ContinentArray) {
	                    Driver.infect(c);        //infects population of invaded continents  
	                    //Thread.sleep(50);
	                    if (c.getInfected() > c.getPopulation()){
	                    	
	                    	c.setInfected(c.getPopulation());
	                    	
	                    }
	                    System.out.println(c.get_nickname() +  c.getInfected());
	            }

	            Driver.transmit(ContinentArray[(int)(Math.random() * 6)] ); //transmits to a random continent
	            Driver.resist(NorthAmerica);  //resists cure (doesn't matter of which continent because cure is static)
	            
	            for (Continent c: ContinentArray) {
	                    Driver.kill(c);  //kills population of infected continents
	            }
	            
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
		        + Driver.getDNApoints()
		        + "\nInfectivity: "
		        + Driver.getInfectivity()
		        +"\nResistivity: "
		        + Driver.getResistivity()
		        +"\nLethality: "
		        + Driver.getLethality()); 
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
                    Driver.transmit(NorthAmerica);     
                    f2.dispose();   
                    gamePlay();
                    
            }
            });
                
                JButton SA = new JButton("South America");
                SA.addActionListener(new ActionListener() {
                  
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    Driver.transmit(SouthAmerica);
                    f2.dispose();  
                    gamePlay();
            }
            });
                
                JButton E = new JButton("Europe");
                E.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    Driver.transmit(Europe);
                    f2.dispose(); 
                    
						gamePlay();
					
					                  
            }
            });
                
                JButton AF = new JButton("Africa");
                AF.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    Driver.transmit(Africa);
                    f2.dispose();
                    
						gamePlay();
					
					                
            }
            });
                
                JButton AS = new JButton("Asia");
                AS.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    Driver.transmit(Asia);                    
                    f2.dispose();
                    gamePlay();         
            }
            });
                
                JButton AU = new JButton("Australia");
                AU.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    Driver.transmit(Australia);
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
	            	//Execute when button is pressed
	            	_infectivity = 15; 
	        		_resistivity = 1; 
	        		_lethality = 1;     
	                EventQueue.invokeLater(new Runnable() {
	        			public void run() {
	        				try {
	        					GOOEY window = new GOOEY();
	        					window.frame.setVisible(true);
	        					Continental();
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
	            	_infectivity = 10; 
	        		_resistivity = 1; 
	        		_lethality = 5;                    
                    EventQueue.invokeLater(new Runnable() {
            			public void run() {
            				try {
            					GOOEY window = new GOOEY();
            					window.frame.setVisible(true);
            					Continental();
            				} catch (Exception e) {
            					e.printStackTrace();
            				}
            			}
            		}); 
                    
                    f1.dispose();
	                    
	            }
	            });
	                
	            //===================== SENIORITIS ======================    
	            JButton Senioritis = new JButton("Senioritis");
	            Senioritis.addActionListener(new ActionListener() {
	                    
	            public void actionPerformed(ActionEvent cr)
	            {
                	//Execute when button is pressed
	            	_infectivity = 50; 
	        		_resistivity = 20; 
	        		_lethality = 20; 
                    EventQueue.invokeLater(new Runnable() {
            			public void run() {
            				try {
            					GOOEY window = new GOOEY();
            					window.frame.setVisible(true);
            					Continental();
            				} catch (Exception e) {
            					e.printStackTrace();
            				}
            			}
            		});
                    f1.dispose();
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
	        	drive();
	        	
	        	
	
	        }
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	                // TODO Auto-generated method stub
	        }
}
