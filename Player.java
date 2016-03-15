import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
public class Player{
	int id;
	String name;
	List<PokerCard> handCards;
	public Player(){

	}
	public Player(int id,String name){
		this.id = id;
		this.name = name;
		handCards = new ArrayList<PokerCard>();
	}
}
