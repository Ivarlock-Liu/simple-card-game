public class PokerCard implements Comparable<PokerCard>{
	String flush;
	String num;
	public PokerCard(){

	}
	public PokerCard(String flush,String num){
		this.flush =  flush;
		this.num = num;
	}
	public Integer convertFlush(String s){
		if(s.equals("黑桃"))
			return 4;
		if(s.equals("红桃"))
			return 3;
		if(s.equals("梅花"))
			return 2;
		return 1;
	}
	public Integer convertNum(String s){
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
	public int compareTo(PokerCard o){
		if(convertNum(this.num)==convertNum(o.num)){
			return convertFlush(o.flush).compareTo(convertFlush(this.flush));
		}
		else
			return convertNum(o.num).compareTo(convertNum(this.num));
	}


}
