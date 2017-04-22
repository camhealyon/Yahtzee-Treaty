
public class StrongKSoldier extends KamiYahtzeeEnemy{
	
	public StrongKSoldier(){
		
		setHealth(60);
		setnS(2);
		setnD(3);
		setnT(1);
		set = new Settings(getnS(), getnD(), getnT());
		EnemyHand= new Hand(set);
		for (int i = 0; i < getnS(); i++){
			EnemyHand.addDie();
		}
	}

}
