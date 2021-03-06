
public class Continent {
	private long _oldInfected = 0, _infected = 0, _oldDead = 0, _dead = 0; 
	private static double _cure = 0;
	private double _chances;
	private long _population; 
	private boolean _invaded = false, _deadContinent = false;
	private String _abbreviation;
	// _oldInfected and _infected are the numbers of how many people have been infected 
	// _oldDead and _dead are the numbers of how many people have died 
	// (the old vars are there because we plug them into a fib formula) 
	/* _cure is basically the last hope of humanity. Once it reaches a 100, it starts disinfecting people 
	 * It's static because every instance (continent) contributes to it at some point*/
	/* _chances are difference for every continent. It's basically a measure of the continent's ability to 
	 * contribute to the cure. It's higher for more developed continents
	*/
	//_population is population... 
	//_invaded indicates if the anyone in the continent has been infected yet 
	//_deadContinent indicates if there is any living soul left in the continent (infected or not) 
	
	public Continent(long p, double c, String nickname) {
		_population = p; 
		_chances = c;
		_abbreviation = nickname;
	}
	
	// ============= Accessor Methods ================
	public long getInfected(){
		return _infected;
	}
	
	public long getOldInfected() {
		return _oldInfected;
	}
	
	public long getDead(){
		return _dead;
	}
	
	public long getOldDead() {
		return _oldDead;
	}
	
	public double getCure(){
		return _cure;
	}
	
	public boolean getInvaded() {
		return _invaded; 
	}
	
	public long getPopulation() {
		return _population;
	}
	
	public boolean getDeadContinent() {
		//System.out.println(getInfected());
		return _deadContinent; 
	}
	
	public String get_nickname(){
		return _abbreviation;
	}
	// ============ Mutator Methods ==================
	public long setOldInfected(long l) {
		long veryOldInfected = _oldInfected;
		_oldInfected = l; 
		return veryOldInfected;
		
	}
	public long setInfected(long l){
		long oldInfected = _infected;
		_infected += l;
		return oldInfected;
	}
	
	public void setOldDead (long d) {
		_oldDead = d;
	}
	public long setDead(long d){
		long oldDead = _dead;
		_dead += d;
		return oldDead; 
	}
	
	public int setCure(double f){
		int oldCure = (int) _cure;
		_cure += f;
		return oldCure;
	}
	
	public void setInvaded(boolean invaded) {
		_invaded = invaded;
	}
	
	public void setDeadContinent(boolean deadC) {
		_deadContinent = deadC;
	}
	//=====================ACTIONS====================================
	public void produceCure() {
		if (_infected == 0);
		else if ((_population/((long)_infected)) <= 2 && _cure <= 100) {
			_cure += _chances; /* Once half of a continent has been infected, it starts to panic and contribute
			to the cure  
			*/
		}
	}
	
	public void Cure() {
		if (!_invaded || _deadContinent); // if the continent is healthy, no cure is needed or if the continent is dead, no one can be cured 
		else if (_infected == 0) {
			setInvaded(false);
		}
		
		else {
		setInfected(setOldInfected(_oldInfected - _infected)); /*the cure starts to bring people back from
		*the disease (not the dead though, because that'd be creepy) */
			
		}
		if (_oldInfected < 0) {
			_oldInfected = 0;
			
		if (_infected < 0) {
			_oldInfected = 0;
			_infected = 0; // a negative number of people can't be cured
			}
		}
	}



}
