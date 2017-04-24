
public class Leader extends KamiYahtzeeEnemy{
	
	public Leader(){
		
		setHealth(250);
		setnS(6);
		setnD(7);
		setnT(1);
		set = new Settings(getnS(), getnD(), getnT()); 
		EnemyHand= new Hand(set);
		for (int i = 0; i < getnD(); i++){
			EnemyHand.addDie();
		}
	}

}
