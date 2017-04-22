
public class YSoldier extends YahtzeePEnemy{
	
	public YSoldier(){
		
		setHealth(35);
		setnS(4);
		setnD(1);
		setnT(1);
		set = new Settings(getnS(), getnD(), getnT()); 
		EnemyHand= new Hand(set);
		for (int i = 0; i < getnS(); i++){
			EnemyHand.addDie();
		}
	}

}
