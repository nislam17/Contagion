
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


import java.util.HashMap;
import java.util.Map;

import javax.swing.SpringLayout;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class GOOEY extends Driver {
	private static final Map<Integer, String> REDS;
	
   	
   	//infectivity - how quickly the disease will spread! Controls how fast the disease spreads both inside and between countries. 
   	//resistivity - a sign of how bad the disease is if you catch it! It will slow down cure research and give you more DNA points. 
   	//lethality - How easily the disease can kill someone! It can slow/stop cure research and give you more DNA points.
   	
   
   	// DNA points let you evolve. Get them automatically.
   	protected static boolean airUp = false, waterUp = false, liveStockUp = false, insomniaUp = false,
   			paranoiaUp = false, paralysisUp = false, comaUp = false, gUp = false, drUp = false;

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
	static JProgressBar progressBar_1 = new JProgressBar();
	static JProgressBar progressBar_2 = new JProgressBar();
	static JProgressBar progressBar_3 = new JProgressBar();
	static JProgressBar progressBar_4 = new JProgressBar();
	static JProgressBar progressBar = new JProgressBar();
	static JProgressBar progressBar_5 = new JProgressBar();
	
	public GOOEY() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
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
		frame = new JFrame("Contagion");
		frame.setBounds(100, 100, 1600, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar_4, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar_3, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		
		
		final JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){
	    	super.paintComponent(g);
	    	setOpaque(false);
	    	g.drawImage(infoBg, 0, 0, this);               	                    
	        Graphics2D g2d = (Graphics2D) g;                                 
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        //========== Drawing the Circle Outlines ===========
	        g.drawOval(230,165,100,100);  //N.AM        
	        g.drawOval(390,390,100,100); //S.AM
	        g.drawOval(700,100,90,90); //EU	        
	        g.drawOval(650,305,100,100);//AF
	        g.drawOval(900,180,100,100);//ASIA
	        g.drawOval(1050,435,90,90); //AUS     
	        //===================================================
	        fillOvalNA(g);
	        fillOvalSA(g);
	        fillOvalEU(g);
	        fillOvalAF(g);
	        fillOvalASIA(g);
	        fillOvalAUS(g);   
	       
	        progressorDNA();
	        progressorRe();
	        progressorIn();
	        progressorLe();
	        progressorf();
	        progressord();

	        }
		};
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, -315, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, progressBar_2, 18, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 772, SpringLayout.NORTH, frame.getContentPane());
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 32, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 6, SpringLayout.EAST, panel);
		
		panel_1.add(a);
		panel_1.add(b);
		panel_1.add(c);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel_2);
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 299, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, frame.getContentPane());
		panel_2.add(d);
		panel_2.add(e);
		panel_2.add(f);
		panel_2.add(g);
		frame.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_3);
		springLayout.putConstraint(SpringLayout.WEST, panel_3, 1275, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_3, -10, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, panel_3, 590, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.SOUTH, frame.getContentPane());
		panel_3.add(h);
		panel_3.add(i);


		frame.getContentPane().add(panel_3);
		
		JLabel lblTransmissionUpgrades = new JLabel("Transmission Upgrades");
		springLayout.putConstraint(SpringLayout.NORTH, lblTransmissionUpgrades, 0, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, lblTransmissionUpgrades, -8, SpringLayout.NORTH, panel_1);
		frame.getContentPane().add(lblTransmissionUpgrades);
		
		JLabel lblSymptomsUpgrades = new JLabel("Symptoms Upgrades");
		springLayout.putConstraint(SpringLayout.WEST, lblTransmissionUpgrades, 0, SpringLayout.WEST, lblSymptomsUpgrades);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, lblSymptomsUpgrades);
		springLayout.putConstraint(SpringLayout.SOUTH, lblSymptomsUpgrades, -6, SpringLayout.NORTH, panel_2);
		frame.getContentPane().add(lblSymptomsUpgrades);
		
		JLabel lblFightTheCure = new JLabel("Fight the Cure");
		springLayout.putConstraint(SpringLayout.WEST, lblSymptomsUpgrades, 0, SpringLayout.WEST, lblFightTheCure);
		springLayout.putConstraint(SpringLayout.WEST, lblFightTheCure, 110, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -5, SpringLayout.NORTH, lblFightTheCure);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFightTheCure, -6, SpringLayout.NORTH, panel_3);
		frame.getContentPane().add(lblFightTheCure);
		

		springLayout.putConstraint(SpringLayout.WEST, progressBar_1, 68, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar_1, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(progressBar_1);
		springLayout.putConstraint(SpringLayout.WEST, progressBar_2, 72, SpringLayout.EAST, progressBar_1);
		frame.getContentPane().add(progressBar_2);
		springLayout.putConstraint(SpringLayout.WEST, progressBar_3, 72, SpringLayout.EAST, progressBar_2);
		frame.getContentPane().add(progressBar_3);

		//springLayout.putConstraint(SpringLayout.WEST, progressBar_4, 53, SpringLayout.EAST, progressBar_3);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, progressBar_4, 0, SpringLayout.NORTH, progressBar_1);
		springLayout.putConstraint(SpringLayout.WEST, progressBar_4, 84, SpringLayout.EAST, progressBar_3);
		frame.getContentPane().add(progressBar_4);
		
		
		springLayout.putConstraint(SpringLayout.WEST, progressBar, 46, SpringLayout.EAST, progressBar_4);
		springLayout.putConstraint(SpringLayout.SOUTH, progressBar, 0, SpringLayout.SOUTH, panel_3);
		frame.getContentPane().add(progressBar);
		
		
		springLayout.putConstraint(SpringLayout.NORTH, progressBar_5, 0, SpringLayout.NORTH, progressBar_1);
		springLayout.putConstraint(SpringLayout.WEST, progressBar_5, 21, SpringLayout.EAST, progressBar);
		frame.getContentPane().add(progressBar_5);
		
		
		
		a.addActionListener(new ActionListener() {
	   		
            public void actionPerformed(ActionEvent e)
            {
            	
            	if (airUp == false){
                	upgradeTransmissionAir();
                	airUp = true;
                	counter += 1; 
                	frame.repaint();
                	int x = 15;
                	while (x > 0){
                		gamePlay();
                		x--;
                		
                		
                	}
                player();
                	
                }

	   		}
    	});
		b.addActionListener(new ActionListener() {
   		 
            public void actionPerformed(ActionEvent e)
            {            	
            	if (waterUp == false){
            		upgradeTransmissionWater(); 
                	waterUp = true;
                	counter += 1; 
                	frame.repaint();
                	int x = 15;
                	while (x > 0){
                		gamePlay();
                		x--;
                
                	}
            	}
            	 player();
            }
    	});
		c.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {     
            	if (liveStockUp == false){
            		upgradeTransmissionLivestock(); 
            		liveStockUp = true; 
            		counter += 1; 
            		frame.repaint();
                	int x = 14;
                	while (x > 0){
                		gamePlay();
                		x--;
                		
                	}
            	}
            	player();
            }
    	});
		d.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (insomniaUp == false){
            		upgradeSymptomsInsomnia();
            		insomniaUp = true; 
            		counter += 1; 
            		frame.repaint();
                	int x = 14;
                	while (x > 0){
                		gamePlay();
                		x--;
                		
                	}
            	}
            	player();
            }
    	});
		e.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (paranoiaUp == false){
            		upgradeSymptomsParanoia();
            		paranoiaUp = true;
            		counter += 1; 
            		frame.repaint();

                	int x = 13;
                	while (x > 0){
                		gamePlay();
                		x--;
                		
                	}
            	}
            	player();
            }
    	});
		f.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (paralysisUp == false){
            		upgradeSymptomsParalysis();
            		paralysisUp = true;
            		counter += 1; 
            		frame.repaint();
                	int x = 13;
                	while (x > 0){
                		gamePlay();
                		x--;
                		
                	}
            	}
            	
            	player();
            }
    	});
		g.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (comaUp == false){
            		upgradeSymptomsComa();
            		comaUp = true; 
            		counter += 1; 
            		frame.repaint();
                	//Submitter();
                	int x = 12;
                	while (x > 0){
                		gamePlay();
                		x--;
                		
                	}
            	}
            	player();
            }
    	});
		h.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (gUp == false){
            		upgradeResistivityGenetic();
                	gUp = true;  

                	counter += 1; 
                	frame.repaint();

                	int x = 12;

                	while (x > 0){
                		gamePlay();
                		x--;
                		
                	}
            	}
            	player();
            }
    	});
		i.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (drUp == false){
            		upgradeResistivityDrug();
                	drUp = true;  
                	counter += 1; 
                	frame.repaint();
                	//Submitter();
                	int x = 11;

                	while (x > 0){
                		gamePlay();
                		x--;
                		
                	}
                	//System.out.println(counter);
            	}
            	player();
            }
    	});
		
		
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
    	g.fillOval(230,165,100,100);            	
    }
    public static void fillOvalSA(Graphics g){
    	setColor(g, SouthAmerica);
    	g.fillOval(390,390,100,100);            	
    }
    public static void fillOvalEU(Graphics g){
    	setColor(g, Europe);
    	g.fillOval(700,100,90,90);           	
    }
    public static void fillOvalAF(Graphics g){
    	setColor(g, Africa);
    	g.fillOval(650,305,100,100);           	
    }    
    public static void fillOvalASIA(Graphics g){
    	setColor(g, Asia);
    	g.fillOval(900,180,100,100);           	
    }
    public static void fillOvalAUS(Graphics g){
    	setColor(g, Australia);
    	g.fillOval(1050,435,90,90);          	
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

	
	public static void progressorDNA(){
		
		progressBar_1.setValue(getDNApoints());
		progressBar_1.setIndeterminate(true);
		progressBar_1.setString("DNA Points: " + _DNApoints);
		progressBar_1.setStringPainted(true);
	
	}
	
	public static void progressorIn(){
		
		progressBar_2.setValue((int) _infectivity);
		progressBar_2.setIndeterminate(true);
		progressBar_2.setString("Infectivity: " + _infectivity);
		progressBar_2.setStringPainted(true);
	
	}
	
	public static void progressorRe(){
		
		progressBar_3.setValue((int) _resistivity);
		progressBar_3.setIndeterminate(true);
		progressBar_3.setString("Resistivity: " + _resistivity);
		progressBar_3.setStringPainted(true);
	
	}
	
	public static void progressorLe(){
		
		progressBar_4.setValue((int)_lethality);
		progressBar_4.setIndeterminate(true);
		progressBar_4.setString("Lethality: " + _lethality);
		progressBar_4.setStringPainted(true);
		
	
	}
	public static void progressorf(){
			
			//progressBar.setValue((int)_lethality);
			//progressBar.setIndeterminate(true);
		long vex = 0;
		for (Continent c: ContinentArray){
			vex += c.getInfected();
		}
			progressBar.setString("Total Infected: " + vex);
			progressBar.setStringPainted(true);
			
		
		}
	public static void progressord(){
		
		long rex = 0;
		for (Continent c: ContinentArray){
			rex += c.getDead();
		}
			progressBar_5.setString("Total Dead: " + rex);
			progressBar_5.setStringPainted(true);
		
	
	}

	public static void player(){
		if (counter == 9) {
			int x = 100, y=100, z=100, a=200;
         	while (x > 0) {
         		gamePlay();
         		x--;
         		frame.repaint();
         	}
         	while (y > 0) {
         		gamePlay();
         		y--;
         		frame.repaint();
         	}
         	while (z > 0) {
         		gamePlay();
         		z--;
         		frame.repaint();
         	}
         	frame.repaint();
         	while (a > 0) {
         		gamePlay();
         		a--;
         		frame.repaint();
         	}
         	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         	while (game.equals("continue")){
         		gamePlay();
         		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         		frame.repaint();
         	}
         }
	}
    
}
