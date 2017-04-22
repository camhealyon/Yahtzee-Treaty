
public class Panzer extends YahtzeePEnemy{
	
	public Panzer(){
		
		setHealth(150);
		setnS(4);
		setnD(3);
		setnT(1);
		set = new Settings(getnS(), getnD(), getnT()); 
		EnemyHand= new Hand(set);
		for (int i = 0; i < getnS(); i++){
			EnemyHand.addDie();
		}
	}

}
