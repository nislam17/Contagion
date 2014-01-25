import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Driver extends JPanel implements ActionListener{
        
		static Pathogen pathogen;
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
                System.out.println("You clicked the button");
                GOOEY gui = new GOOEY();
                f1.dispose();
                        
            }
            });
                JButton Virus = new JButton("Virus");
                Virus.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen = new Virus();
                System.out.println("You clicked the button");
                GOOEY gui = new GOOEY();
                f1.dispose();
                        
            }
            });
                JButton Senioritis = new JButton("Senioritis");
                Senioritis.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen = new Senioritis();
                System.out.println("You clicked the button");
                GOOEY gui = new GOOEY();
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
       
        
                
        final Continent NorthAmerica = new Continent(528700000, 0.9, "NA"); 
        final Continent SouthAmerica = new Continent(387500000, 0.2, "SA");
        Continent Europe = new Continent(739200000, 0.4, "EU"); 
        Continent Africa = new Continent(1033000000,0.1, "AF"); 
        Continent Asia = new Continent(2147482999,0.6, "ASIA"); 
        Continent Australia = new Continent(22680000,0.8, "AUS"); 
        	final JFrame f2 = new JFrame("Choose Your Continent");   
            JPanel ConChooser = new JPanel(); //choose continent
                
            JButton NA = new JButton("North America");
            NA.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen.transmit(NorthAmerica);
                    System.out.println(NorthAmerica.getInvaded());
                    f2.dispose();      
            }
            });
                
                JButton SA = new JButton("South America");
                SA.addActionListener(new ActionListener() {
                  
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    pathogen.transmit(SouthAmerica);
                    f2.dispose();    
            }
            });
                
                JButton E = new JButton("Europe");
                E.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    System.out.println("successful!");
                    f2.dispose(); 
            }
            });
                
                JButton AF = new JButton("Africa");
                AF.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    System.out.println("successful!");
                    f2.dispose();
            }
            });
                
                JButton AS = new JButton("Asia");
                AS.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    System.out.println("successful!");
                    f2.dispose();
            }
            });
                
                JButton AU = new JButton("Australia");
                AU.addActionListener(new ActionListener() {
                    
            public void actionPerformed(ActionEvent cr)
            {
                //Execute when button is pressed
                    System.out.println("successful!");
                    f2.dispose();
            }
            });
                
                ConChooser.add(NA);
                ConChooser.add(SA);
                ConChooser.add(E);
                ConChooser.add(AF);
                ConChooser.add(AS);
                ConChooser.add(AU);
                
                
                f2.setLocation(500, 500);
        //f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        f2.setContentPane(ConChooser);
        f2.pack();
        f2.setVisible(true);
                
        
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                
        }
}
