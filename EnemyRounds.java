
public class EnemyRounds {
	private Enemy enemy;
	
	public EnemyRounds(int count){
		if(count == 1) {
			enemy = new YSoldier();
		} else if(count == 2) {
			enemy = new StrongYSoldier();
		} else if(count == 3) {
			enemy = new Panzer();
		} else if(count == 4) {
			enemy = new PartyLeader();
		} else if(count == 5) {
			enemy = new KSoldier();
		} else if(count == 6) {
			enemy = new StrongKSoldier();
		} else if(count == 7) {
			enemy = new Zero();
		} else {
			enemy = new Leader();
		}
	}
	
	public int getHealth(){
		return enemy.getHealth();
	}
	
	public int getTotalDice(){
		return enemy.getTotalDice();
	}
	
	public void updateEDamage(int damage){
		enemy.updateDamage(damage);
	}
	
	public void rollDice(){
		enemy.rollAll();
	}
	
}
