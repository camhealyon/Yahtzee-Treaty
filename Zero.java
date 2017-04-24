
public class Zero extends KamiYahtzeeEnemy{
	
	public Zero(){
		
		setHealth(60);
		setnS(3);
		setnD(4);
		setnT(1);
		set = new Settings(getnS(), getnD(), getnT()); 
		EnemyHand= new Hand(set);
		for (int i = 0; i < getnD(); i++){
			EnemyHand.addDie();
		}
	}

}
