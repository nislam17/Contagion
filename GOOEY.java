
import javax.swing.JFrame;

public class GOOEY extends Driver {
	private static final Map<Integer, String> REDS;
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
	JFrame frame;
	static Continent NorthAmerica = new Continent(528700000, 0.9, "NA");   
    static Continent SouthAmerica = new Continent(387500000, 0.2, "SA");
    static Continent Europe = new Continent(739200000, 0.4, "EU"); 
    static Continent Africa = new Continent(1033000000,0.1, "AF"); 
    static Continent Asia = new Continent(2147482999,0.6, "ASIA"); 
    static Continent Australia = new Continent(22680000,0.8, "AUS"); 
	static ImageIcon ic = new ImageIcon("mapfinale.jpg");
	final static Image infoBg = ic.getImage();

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
a.addActionListener(new ActionListener() {
	   		
            public void actionPerformed(ActionEvent e)
            {
            	gamePlay();
            	if (airUp == false){
                	upgradeTransmissionAir();
                	airUp = true;
                	buttonPressed = true;
                	gamePlay();
                	
                }

            
	   		}
    	});
		b.addActionListener(new ActionListener() {
   		 
            public void actionPerformed(ActionEvent e)
            {            	
            	if (waterUp == false){
            		upgradeTransmissionWater(); 
                	airUp = true;
                	buttonPressed = true;
                	gamePlay();
            	}
            }
    	});
		c.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {     
            	if (liveStockUp == false){
            		upgradeTransmissionLivestock(); 
                	airUp = true;   
                	buttonPressed = true;
                	gamePlay();
            	}
            }
    	});
		d.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (airUp == false){
            		upgradeSymptomsInsomnia();
                	airUp = true; 
                	buttonPressed = true;
                	gamePlay();
            	}	                
            }
    	});
		e.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (airUp == false){
            		upgradeSymptomsParanoia();
                	airUp = true;
                	buttonPressed = true;
                	gamePlay();
            	}	
            }
    	});
		f.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (airUp == false){
            		upgradeSymptomsParalysis();
                	airUp = true;
                	buttonPressed = true;
                	gamePlay();
            	}	
            }
    	});
		g.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (airUp == false){
            		upgradeSymptomsComa();
            		airUp = true; 
                	buttonPressed = true;
                	gamePlay();
            	}	
            }
    	});
		h.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (airUp == false){
            		upgradeResistivityGenetic();
                	airUp = true;   
                	buttonPressed = true;
                	gamePlay();
            	}	
            }
    	});
		i.addActionListener(new ActionListener() {
	   		 
            public void actionPerformed(ActionEvent e)
            {
            	if (airUp == false){
            		upgradeResistivityDrug();
                	airUp = true;  
                	buttonPressed = true;
                	gamePlay();
            	}	
            }
    	});
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
    
}