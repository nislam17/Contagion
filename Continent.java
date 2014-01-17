public class Continent {
	private int _population, _infected = 0, _dead = 0, _cure = 0; 
	private double _chances,
	
	
	public Continent(int p, double c) {
		_population = p; 
		_chances = c;
	}
	
	// ============= Accessor Methods ================
	public int getInfected(){
		return _infected;
	}
	
	public int getDead(){
		return _dead;
	}
	
	public double getcure(){
		return _cure;
	}
	
	// ============ Mutator Methods ==================
	public setInfected(int i){
		_infected += i;
	}
	
	public setDead(int d){
		_dead += d
	}
	
	public setcure(int f){
		_cure += f;
	}
	
	
	
	
	
}
