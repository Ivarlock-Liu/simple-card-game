import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Initial{
	private Scanner console = new Scanner(System.in);
	private List<PokerCard> cards = new ArrayList<PokerCard>();
	Player[] players = new Player[2];
	private void createCards(){
		String[] flushes = {"黑桃","梅花","方片","红桃"};
		String[] numbers = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		System.out.print("----------Start Creating Cards----------\nCreated: ");
		for(String flush:flushes){
			for(String number:numbers){
				cards.add(new PokerCard(flush,number));
				System.out.print(flush+number+" ");
			}
			System.out.println();
		}	
		System.out.println("Total number of cards: "+cards.size());
		System.out.println("----------Create Complete----------");
	}
	private void printCards(){
		System.out.println("----------Printing Cards----------");
		for(PokerCard pc:cards){
			System.out.print(pc.flush+pc.num+" ");
		}
		System.out.println("\n----------Print Complete----------");
	}
	private void shuffle(){
		System.out.println("----------Start Shuffle----------");
		Collections.shuffle(cards);		
		System.out.println("----------Shuffle Complete----------");
	}
	private void createPlays(){
		System.out.println("----------Start Creating Players----------");
		System.out.println("Please input first player's id and name:");
		System.out.print("input id: ");
		while(true){
			try{
				Integer id = console.nextInt();
				System.out.print("input name: ");
				String name = console.next();
				players[0] = new Player(id,name);
				break;
			}catch(Exception e){
				System.out.print("error input, please input an integer:");
				console = new Scanner(System.in);
				continue;
			}
		}
		System.out.println("----------First Player Created----------");
		System.out.println("please input second player's id and name:");
		System.out.print("input id: ");
		while(true){
			try{
				Integer id2 = console.nextInt();
				System.out.print("input name: ");
				String name2 = console.next();
				players[1] = new Player(id2,name2);
				break;
			}catch(Exception e){
				System.out.print("error input, please input an integer:");
				console = new Scanner(System.in);
				continue;
			}
		}
		System.out.println("----------Second Player Created----------");
		
	}
	private void dealCards(){
		System.out.println("----------Start Deal Cards----------");
		int flag = 0;
		while(flag<2){
			for(int i=0;i<2;i++){
				System.out.println("-----Player "+players[i].name+" deal;");
				players[i].handCards.add(cards.get(0));
				cards.remove(0);
				}flag++;
		}	
	}
	private void testPlayer(int i){
		for(PokerCard pc:players[i].handCards){
			System.out.print(pc.flush+pc.num+" ");
		}
		System.out.println();
	}	
	public int convertFlush(String s){
		if(s.equals("黑桃"))
			return 4;
		if(s.equals("红桃"))
			return 3;
		if(s.equals("梅花"))
			return 2;
		return 1;
	}
	public int convertNum(String s){
		if(s.equals("A"))
			return 14;
		if(s.equals("K"))
			return 13;
		if(s.equals("Q"))
			return 12;
		if(s.equals("J"))
			return 11;
		return Integer.parseInt(s);
	}

	private void judge(){
		System.out.println("----------Game Start----------");
		testPlayer(0);
		Collections.sort(players[0].handCards);
		//testPlayer(0);
		System.out.println(players[0].name+"较大的牌是："+players[0].handCards.get(0).flush+players[0].handCards.get(0).num);
		testPlayer(1);
		Collections.sort(players[1].handCards);
		//testPlayer(1);
		System.out.println(players[1].name+"较大的牌是："+players[1].handCards.get(0).flush+players[1].handCards.get(0).num);
		List<PokerCard> temp = new ArrayList<PokerCard>();
		temp.add(players[0].handCards.get(0));	
		temp.add(players[1].handCards.get(0));
		Collections.sort(temp);
		if(temp.get(0).equals(players[0].handCards.get(0)))
			System.out.println("-----Congratulations :"+players[0].name+" win!");
		else
			System.out.println("-----Congratulations :"+players[1].name+" win!");
	}
	public static void main(String[] args){
		Initial test = new Initial();
		test.createCards();
		//test.printCards();
		test.shuffle();
		test.printCards();
		test.createPlays();
		test.dealCards();
		//System.out.println(test.cards.get(0).flush+test.cards.get(0).num);
		test.judge();
	}
}
