
public class KSoldier extends KamiYahtzeeEnemy{
	
	public KSoldier(){
		
		setHealth(30);
		setnS(2);
		setnD(2);
		setnT(1);
		set = new Settings(getnS(), getnD(), getnT()); 
		EnemyHand= new Hand(set);
		for (int i = 0; i < getnD(); i++){
			EnemyHand.addDie();
		}
	}

}
