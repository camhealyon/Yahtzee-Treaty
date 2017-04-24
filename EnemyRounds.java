
public class EnemyRounds {
	private Enemy enemy;
	
	public EnemyRounds(){
		enemy = new YSoldier();
	}
	
	public int getHealth(){
		return enemy.getHealth();
	}
	
	public int getTotalDice(){
		return enemy.getTotalDice();
	}
	
	public static void main(String[] args){
		EnemyRounds curr = new EnemyRounds();
		curr.getHealth();
	}
}
