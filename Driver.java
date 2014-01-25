import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JPanel implements ActionListener{
	
	private static boolean winner; 
	private static String game = "continue";
        
	final static Continent NorthAmerica = new Continent(528700000, 0.9, "NA"); 
    final static Continent SouthAmerica = new Continent(387500000, 0.2, "SA");
    final static Continent Europe = new Continent(739200000, 0.4, "EU"); 
    final static Continent Africa = new Continent(1033000000,0.1, "AF"); 
    final static Continent Asia = new Continent(2147482999,0.6, "ASIA"); 
    final static Continent Australia = new Continent(22680000,0.8, "AUS"); 
    
    static Continent [] ContinentArray = {NorthAmerica, SouthAmerica, Europe, Africa, Asia, Australia};
    
	static Pathogen pathogen;
	
	//game play 
    public static void gamePlay() {
    
        while (game.equals("continue")) {
        	System.out.println("ahhh");
        	for (Continent c: ContinentArray) {
        		pathogen.infect(c);	//infects population of invaded continents
        	
        	}
        	pathogen.transmit(ContinentArray[(int)(Math.random() * 6)] ); //transmits to a random continent
        	pathogen.resist(NorthAmerica);  //resists cure (doesn't matter of which continent because cure is static)
        	for (Continent c: ContinentArray) {
        		pathogen.kill(c);  //kills population of infected continents
        	}
        	for (Continent c: ContinentArray) {
        		if (c.getDeadContinent() == true ); // if the continent is dead, it cannot contribute to the cure 
        		else {
        			c.produceCure(); // every infected (& alive) country produces a cure 
        		}
        		
        	}
        	for (Continent c: ContinentArray) {
        		c.Cure(); // cures every continent that needs it 
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
        if (winner) {
        	System.out.println("CONGRATS YOU WON!");
        }
        else {
        	System.out.println("Good luck next time buddy. You lost.");
        }
        
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
                    gamePlay();
            }
            });
                
                JButton SA = new JButton("South America");
                SA.addActionListener(new ActionListener() {
                  
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen.transmit(SouthAmerica);
                    f2.dispose();  
                    gamePlay();
            }
            });
                
                JButton E = new JButton("Europe");
                E.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
            	pathogen.transmit(Europe);
                    f2.dispose(); 
                    gamePlay();
            }
            });
                
                JButton AF = new JButton("Africa");
                AF.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
            	pathogen.transmit(Africa);
                    f2.dispose();
                    gamePlay();
            }
            });
                
                JButton AS = new JButton("Asia");
                AS.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
            	pathogen.transmit(Asia);
                    f2.dispose();
                    gamePlay();
            }
            });
                
                JButton AU = new JButton("Australia");
                AU.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
            	pathogen.transmit(Australia);
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
		
        public static void main (String[] args) {

        	final JFrame f1 = new JFrame("Choose Your Pathogen");

                
                JPanel chooser = new JPanel(); // choose pathogen
                //chooser.setSize(new Dimension(500,500));
                JButton Bacteria = new JButton("Bacteria");
                Bacteria.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen = new Bacteria(); 
                GOOEY gui = new GOOEY();
                f1.dispose();
                Continental();
                 
            }
            });
                JButton Virus = new JButton("Virus");
                Virus.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen = new Virus();

                GOOEY gui = new GOOEY();
                f1.dispose();
                Continental();     
            }
            });
                JButton Senioritis = new JButton("Senioritis");
                Senioritis.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen = new Senioritis();
                GOOEY gui = new GOOEY();
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
