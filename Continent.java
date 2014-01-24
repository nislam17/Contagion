public class Continent {
	private int _population, _oldInfected = 0, _infected = 0, _dead = 0, _cure = 0; 
	private double _chances;
	private boolean _invaded = false;
	
	
	public Continent(int p, double c) {
		_population = p; 
		_chances = c;
	}
	
	// ============= Accessor Methods ================
	public int getInfected(){
		return _infected;
	}
	
	public int getOldInfected() {
		return _oldInfected;
	}
	
	public int getDead(){
		return _dead;
	}
	
	public double getCure(){
		return _cure;
	}
	
	public boolean getInvaded() {
		return _invaded; 
	}
	
	// ============ Mutator Methods ==================
	public void setOldInfected(int i) {
		_oldInfected += i; 
		
	}
	public int setInfected(int i){
		int oldInfected = _infected;
		_infected += i;
		return oldInfected;
	}
	
	public int setDead(int d){
		int oldDead = _dead;
		_dead += d;
		return oldDead; 
	}
	
	public int setCure(double f){
		int oldCure = _cure;
		_cure += f;
		return oldCure;
	}
	
	public void setInvaded(boolean invaded) {
		_invaded = invaded;
	}
	
	
}
