public abstract class Pathogen {
	double infectivity; 
	double resistivity; 
	double lethality; 
	
	public abstract void transmit();
	public abstract void infect(); 
	public abstract void resist(); 
	public abstract void upgradeInfectivity();
	public abstract void upgradeResistivity(); 
	public abstract void upgradeLethality();
}
