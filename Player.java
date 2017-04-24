public class Player {
	Hand playerHand;
	int pHealth = 100;
	int dNumber = 5;
	int dSides = 6;
	int dTurns = 3;
	
	public Player(){
		for (int i = 0; i < getdNumber(); i++){
			playerHand.addDie();
		}
	}
	
	int getpHealth(){
		return pHealth;
	}
	
	int getdNumber(){
		return dNumber;
	}
	
	int getdSides(){
		return dSides;
	}
	
	int getdTurns(){
		return dTurns;
	
	}
	
	void setHealth(int pHealth){
		this.pHealth = pHealth;
	}
	
	void setdNumber(int dNumber){
		this.dNumber = dNumber;
	}
	
	void setdSides(int dSides){
		this.dSides = dSides;
	}
	
	void setdTurns(int dTurns){
		this.dTurns = dTurns;
	}
	
	void updateDamage(int damage){
		this.pHealth = (this.pHealth - damage);
	}
}

