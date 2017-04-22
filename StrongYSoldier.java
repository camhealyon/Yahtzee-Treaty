
public class StrongYSoldier extends YahtzeePEnemy{
	
	public StrongYSoldier(){
		
		setHealth(70);
		setnS(4);
		setnD(2);
		setnT(1);
		set = new Settings(getnS(), getnD(), getnT()); 
		EnemyHand= new Hand(set);
		for (int i = 0; i < getnS(); i++){
			EnemyHand.addDie();
		}
	}

}
