
public class PartyLeader extends YahtzeePEnemy{
	
	public PartyLeader(){
		
		setHealth(300);
		setnS(7);
		setnD(6);
		setnT(1);
		set = new Settings(getnS(), getnD(), getnT()); 
		EnemyHand= new Hand(set);
		for (int i = 0; i < getnS(); i++){
			EnemyHand.addDie();
		}
	}
}
