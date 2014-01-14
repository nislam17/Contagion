
public abstract class Pathogen {
	double infectivity; 
	double severity; 
	double lethality; 
	
	public abstract void transmit();
	public abstract void infect(); 
	public abstract void resist(); 
	public abstract void upgrade(); 
}
