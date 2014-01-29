
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Driver extends JPanel implements ActionListener{
        
	// ===================== VARIABLES ====================================
        private static boolean winner, _submit; 
        private static String game = "continue";
        private static int up = 3, down = 3;
        
        static JPanel drawingPanel;
        final static JFrame mapper = new JFrame("Contagion");
	    static Continent NorthAmerica = new Continent(528700000, 0.9, "NA");   
	    static Continent SouthAmerica = new Continent(387500000, 0.2, "SA");
	    static Continent Europe = new Continent(739200000, 0.4, "EU"); 
	    static Continent Africa = new Continent(1033000000,0.1, "AF"); 
	    static Continent Asia = new Continent(2147482999,0.6, "ASIA"); 
	    static Continent Australia = new Continent(22680000,0.8, "AUS"); 
	    
	    
	    static Continent [] ContinentArray = {NorthAmerica, SouthAmerica, 
	    	Europe, Africa, Asia, Australia};
    
        static Pathogen pathogen;
    
        // =====================================================================    
        
        
        //game play 
	    public static void gamePlay() throws InterruptedException {
	    	while (game == "continue"){
	    		
	                //System.out.println("ahhh");
	    			
	                for (Continent c: ContinentArray) {
	                        pathogen.infect(c);        //infects population of invaded continents  
	                        //Thread.sleep(50);
	                        if (c.getInfected() > c.getPopulation()){
	                        	
	                        	c.setInfected(c.getPopulation());
	                        	
	                        }
	                        System.out.println(c.get_nickname() +  c.getInfected());
	                }
	                pauser();
	                drawingPanel.repaint();
	                pathogen.transmit(ContinentArray[(int)(Math.random() * 6)] ); //transmits to a random continent
	                pathogen.resist(NorthAmerica);  //resists cure (doesn't matter of which continent because cure is static)
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
	                
	    }
	    
	    public static void pauser() throws InterruptedException{
	    	up = down;
            while (up > 0){
            	up -= 1;
            	down = up;
            	if (pathogen.buttonPressed == false){
            		up = 0;
            		Thread.sleep(4000);
            		JFrame jan = new JFrame();
            		JDialog upper;
            		upper = new JDialog(jan, "J");
            		//jan.setContentPane(upper);
            		//jan.setSize(200,200);
            		//jan.setVisible(true);
            		}
            	else if (pathogen.buttonPressed == true){
            		up = 0;
            		pathogen.buttonPressed = false;
            		break;}
            	else
            		break;

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
	        + pathogen.getDNApoints()
	        + "\nInfectivity: "
	        + pathogen.getInfectivity()
	        +"\nResistivity: "
	        + pathogen.getResistivity()
	        +"\nLethality: "
	        + pathogen.getLethality()); 
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
                    pathogen.transmit(NorthAmerica);     
                    f2.dispose();   
                    try {
						gamePlay();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    
            }
            });
                
                JButton SA = new JButton("South America");
                SA.addActionListener(new ActionListener() {
                  
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen.transmit(SouthAmerica);
                    f2.dispose();  
                    try {
						gamePlay();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            }
            });
                
                JButton E = new JButton("Europe");
                E.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    pathogen.transmit(Europe);
                    f2.dispose(); 
                    
						try {
							gamePlay();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					                  
            }
            });
                
                JButton AF = new JButton("Africa");
                AF.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    pathogen.transmit(Africa);
                    f2.dispose();
                    
						try {
							gamePlay();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					                
            }
            });
                
                JButton AS = new JButton("Asia");
                AS.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    pathogen.transmit(Asia);                    
                    f2.dispose();
                    try {
						gamePlay();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}         
            }
            });
                
                JButton AU = new JButton("Australia");
                AU.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                    pathogen.transmit(Australia);
                    f2.dispose();
                    try {
						gamePlay();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
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
            
           
          
                
        public static void main (String[] args) {

            final JFrame f1 = new JFrame("Choose Your Pathogen");
            JPanel chooser = new JPanel(); // choose pathogen
                
            //===================== BACTERIA ======================
            JButton Bacteria = new JButton("Bacteria");
            Bacteria.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {              
                pathogen = new Bacteria(); 
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
                    pathogen = new Virus();                    
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
                    pathogen = new Senioritis();
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
              // jpan.repaint();                                     
        }// end main 

        @Override
        public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
        }
}
