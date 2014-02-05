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
	    
	    		
	                //System.out.println("ahhh");
	    			for (Continent c: ContinentArray){
	    				System.out.println(c.get_nickname() +  c.getInfected());
	    			}
	                for (Continent c: ContinentArray) {
	                        pathogen.infect(c);        //infects population of invaded continents  
	                        //Thread.sleep(50);
	                        if (c.getInfected() > c.getPopulation()){
	                        	
	                        	c.setInfected(c.getPopulation());
	                        	
	                        }
	                        
	                }
	                //pauser();

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
	    
	    public static void textbox() {
	    	JTextArea stats = new JTextArea();
	    	stats.add("Infectivity: " + pathogen.getInfectivity(), stats);
	    	stats.add("Resistvity: " + pathogen.getResistivity(), stats);
	    	stats.add("Lethality: " + pathogen.getLethality(), stats);
	    	
	    	JFrame text = new JFrame("stats");
	    	text.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    	text.setVisible(true);
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
            
            	private static final Map<Integer, String> REDS;
            		static {
            			REDS = new HashMap<Integer, String>();
            			REDS.put(0, "#FFFFFF");
            			REDS.put(5, "#FFFAFA");
            			REDS.put(10, "#F4C2C2");
            			REDS.put(15, "#FFC1CC");
            			REDS.put(20, "#FF6961");
            			REDS.put(25, "#FF5C5C");
            			REDS.put(30, "#FF1C00");
            			REDS.put(35, "#E00000");
            			REDS.put(40, "#E34234");
            			REDS.put(45, "#D10000");
            			REDS.put(50, "#D73B3E");
            			REDS.put(55, "#CE1620");
            			REDS.put(60, "#CC0000");
            			REDS.put(65, "#B22222");
            			REDS.put(70, "#B31B1B");
            			REDS.put(75, "#A40000");
            			REDS.put(80, "#800000");
            			REDS.put(85, "#701C1C");
            			REDS.put(90, "#3C1414");
            			REDS.put(95, "#321414");
            			REDS.put(100, "#000000");			
            		}
            	static JFrame frame;

            	static ImageIcon ic = new ImageIcon("mapfinale.jpg");
            	final static Image infoBg = ic.getImage();


            	/**
            	 * Initialize the contents of the frame.
            	 */
            	private static void initialize() {
            		
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
            		frame = new JFrame();
            		frame.setBounds(100, 100, 1600, 850);
            		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            		SpringLayout springLayout = new SpringLayout();
            		frame.getContentPane().setLayout(springLayout);
            		
            		JPanel panel = new JPanel(){
            			public void paintComponent(Graphics g){
            	    	super.paintComponent(g);
            	    	setOpaque(false);
            	    	g.drawImage(infoBg, 0, 0, this);               	                    
            	        Graphics2D g2d = (Graphics2D) g;                                 
            	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            	        //========== Drawing the Circle Outlines ===========
            	        g.drawOval(290,155,100,100);  //N.AM        
            	        g.drawOval(470,390,100,100); //S.AM
            	        g.drawOval(900,100,90,90); //EU	        g.drawOval(800,305,100,100);//AF
            	        g.drawOval(1100,180,100,100);//ASIA
            	        g.drawOval(1275,435,90,90); //AUS     
            	        //===================================================
            	        fillOvalNA(g);
            	        fillOvalSA(g);
            	        fillOvalEU(g);
            	        fillOvalAF(g);
            	        fillOvalASIA(g);
            	        fillOvalAUS(g);    
            	        }
            		};
            		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.SOUTH, panel, 772, SpringLayout.NORTH, frame.getContentPane());
            		frame.getContentPane().add(panel);
            		
            		JProgressBar progressBar = new JProgressBar();
            		springLayout.putConstraint(SpringLayout.NORTH, progressBar, 790, SpringLayout.NORTH, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.WEST, progressBar, 63, SpringLayout.WEST, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.SOUTH, progressBar, -10, SpringLayout.SOUTH, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.EAST, progressBar, 209, SpringLayout.WEST, frame.getContentPane());
            		frame.getContentPane().add(progressBar);
            		
            		JPanel panel_1 = new JPanel();
            		springLayout.putConstraint(SpringLayout.WEST, panel_1, 1275, SpringLayout.WEST, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.EAST, panel, -6, SpringLayout.WEST, panel_1);
            		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -589, SpringLayout.SOUTH, frame.getContentPane());
            		
            		panel_1.add(a);
            		panel_1.add(b);
            		panel_1.add(c);
            		frame.getContentPane().add(panel_1);
            		
            		JPanel panel_2 = new JPanel();
            		springLayout.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, frame.getContentPane());
            		panel_2.add(d);
            		panel_2.add(e);
            		panel_2.add(f);
            		panel_2.add(g);
            		frame.getContentPane().add(panel_2);
            		
            		JPanel panel_3 = new JPanel();
            		springLayout.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_3);
            		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -25, SpringLayout.NORTH, panel_3);
            		springLayout.putConstraint(SpringLayout.WEST, panel_3, 1275, SpringLayout.WEST, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.EAST, panel_3, -10, SpringLayout.EAST, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.NORTH, panel_3, 590, SpringLayout.NORTH, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.SOUTH, frame.getContentPane());
            		panel_3.add(h);
            		panel_3.add(i);


            		frame.getContentPane().add(panel_3);
            		
            		JLabel lblTransmissionUpgrades = new JLabel("Transmission Upgrades");
            		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, lblTransmissionUpgrades);
            		springLayout.putConstraint(SpringLayout.SOUTH, lblTransmissionUpgrades, -836, SpringLayout.SOUTH, frame.getContentPane());
            		springLayout.putConstraint(SpringLayout.EAST, lblTransmissionUpgrades, -95, SpringLayout.EAST, frame.getContentPane());
            		frame.getContentPane().add(lblTransmissionUpgrades);
            		
            		JLabel lblSymptomsUpgrades = new JLabel("Symptoms Upgrades");
            		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, lblSymptomsUpgrades);
            		springLayout.putConstraint(SpringLayout.NORTH, lblSymptomsUpgrades, 6, SpringLayout.SOUTH, panel_1);
            		springLayout.putConstraint(SpringLayout.WEST, lblSymptomsUpgrades, 0, SpringLayout.WEST, lblTransmissionUpgrades);
            		frame.getContentPane().add(lblSymptomsUpgrades);
            		
            		JLabel lblFightTheCure = new JLabel("Fight the Cure");
            		springLayout.putConstraint(SpringLayout.WEST, lblFightTheCure, 0, SpringLayout.WEST, lblTransmissionUpgrades);
            		springLayout.putConstraint(SpringLayout.SOUTH, lblFightTheCure, -6, SpringLayout.NORTH, panel_3);
            		frame.getContentPane().add(lblFightTheCure);
            		
            		
            	}
            	
            	
                
                static int round(int n){
                	return (Math.round(n/5)*5);
                }
                
                public static void setColor (Graphics g, Continent c){
                	//NorthAmerica.setInfected(NorthAmerica.getInfected());
                	int percent = (int) (c.getInfected()/ (c.getPopulation()/100)) ;
                	if (percent > 100){
                		percent = 100;
                	}
                	percent = round(percent);
                    String RGB = REDS.get(percent);
                    
                	g.setColor(Color.decode(RGB));
                	
                	//System.out.println(RGB);
                	//System.out.println(c.getInfected() * 100/c.getPopulation() );
                	
                	//System.out.println(percent);           	
                }
              //=============== COLOR THE CIRCLES ======================
                public static void fillOvalNA(Graphics g){            	
                	setColor(g, NorthAmerica);
                	g.fillOval(290, 155, 100, 100);            	
                }
                public static void fillOvalSA(Graphics g){
                	setColor(g, SouthAmerica);
                	g.fillOval(470,390,100,100);            	
                }
                public static void fillOvalEU(Graphics g){
                	setColor(g, Europe);
                	g.fillOval(900,100,90,90);           	
                }
                public static void fillOvalAF(Graphics g){
                	setColor(g, Africa);
                	g.fillOval(800,305,100,100);           	
                }    
                public static void fillOvalASIA(Graphics g){
                	setColor(g, Asia);
                	g.fillOval(1100,180,100,100);           	
                }
                public static void fillOvalAUS(Graphics g){
                	setColor(g, Australia);
                	g.fillOval(1275,435,90,90);          	
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
        					initialize();
        					frame.setVisible(true);
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
            					initialize();
            					frame.setVisible(true);
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
            					initialize();
            					frame.setVisible(true);
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
        }// end main 

        @Override
        public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
        }
        }
