public abstract class Pathogen {
	
	private double infectivity, resistivity, lethality; 
	
	//infectivity - how quickly the disease will spread! Controls how fast the disease spreads both inside and between countries. 
	//resistivity - a sign of how bad the disease is if you catch it! It will slow down cure research and give you more DNA points. 
	//lethality - How easily the disease can kill someone! It can slow/stop cure research and give you more DNA points.
	
	private int DNApoints; 
	// DNA points let you evolve. Get them automatically
	
	/*Pre-cond: 
	 * Post-cond: 
	 * transmit works based on infectivity and controls how fast the disease spreads inside countries*/
	public  boolean transmit() {
		return Math.random() < infectivity; //...not sure how to work this yet
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * infect works based on infectivity and controls how fast the disease spreads between countries*/
	public void infect() {
		
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * resist works based on resistivity and slows down the cure */
	public void resist() {
		
	}
	
	/*Pre-cond: 
	 * Post-cond: 
	 * DNApoints increase based on how many people are infected + when pathogen is transmitted to a new country  */
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
