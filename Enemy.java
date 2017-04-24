
public class Enemy {
	Hand EnemyHand;
	private int health;
	private int nS;
	private int nD;
	private int nT;
	Settings set;

	
	int getnS(){
		return nS;
	}
	int getnD(){
		return nD;
	}
	int getnT(){
		return nT;
	}
	int getHealth(){
		return health;
	}
	void setnS(int a){
		nS = a;
	}
	void setnD(int a){
		nD = a;
	}
	void setnT(int a){
		nT = a;
	}
	void setHealth(int a){
		health = a;
	}
	
	int getTotalDice(){
		int count = 0;
		for (int i = 0; i < EnemyHand.hand.size(); i++){
			count += EnemyHand.hand.get(i).getSideup();
		}
		return count;
	}
	
	void rollAll(){
		for (int i = 0; i < EnemyHand.hand.size(); i++){
			EnemyHand.hand.get(i).roll();
		}
	}
}
