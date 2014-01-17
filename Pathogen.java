public abstract class Pathogen {
	
	private double _infectivity, _resistivity, _lethality; 
	
	//infectivity - how quickly the disease will spread! Controls how fast the disease spreads both inside and between countries. 
	//resistivity - a sign of how bad the disease is if you catch it! It will slow down cure research and give you more DNA points. 
	//lethality - How easily the disease can kill someone! It can slow/stop cure research and give you more DNA points.
	
	private int _DNApoints; 
	// DNA points let you evolve. Get them automatically
	
	/*Pre-cond: 
	 * Post-cond: 
	 * transmit works based on infectivity and controls how fast the disease spreads inside countries*/
	public Pathogen(double infectivity, double resistivity, double lethality) {
		_infectivity = infectivity; 
		_resistivity = resistivity; 
		_lethality = lethality; 
	} 
	public  void transmit(Continent c) {
				
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * infect works based on infectivity and controls how fast the disease spreads between countries*/
	public void infect(Continent c) {
		if (Math.random() < _infectivity) {
			c.setInfected(c.getInfected*c.getInfected); 
		}
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * resist works based on resistivity and slows down the cure */
	public void resist() {
		if (Math.random() < _resistivity) {
			c.setFirewall(c.getFirewall - )
		}
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * DNApoints increase based on how many people are infected + when pathogen is transmitted to a new country  */
	 
	 	
	/*Pre-cond: 
	 * Post-cond: 
	 * kill works based on lethality and controls how fast the disease wipes out the population*/
	public void kill(Continent c) {
		if (Math.random() < _lethality) {
			c.setDead(c.getDead*c.getDead); 
		}
	}
	
	public void increaseDNApoints() {
		
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * DNA points help upgrade Transmission */
	public void upgradeTransmission() {
		
	} // upgrades infectivity
	
	/*Pre-cond: 
	 * Post-cond: 
	 * DNA points help upgrade symptoms */
	public void upgradeSymptoms() {
	
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * DNA points help upgrade abilities */
	public void upgradeAbilities() {
	
	}
	
} //ends class Pathogen
