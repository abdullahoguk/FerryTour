
public class Toll {

	private int where; //1 or 2
	private int state; //0 or 4 
	private int toll; //1 2 3 4 
	public String name; //ana1 ana2 eu1 eu2 
	
	
	//construct
	public Toll(String name,int where,int toll){
		this.name=name;
		this.where = where;
		this.toll = toll; 
	}
	
	
	//getters setters
	public int getWhere() {
		return where;
	}

	
	public int getState() {
		return state;
	}

	public void setState (int state) {
		this.state = state;
	}


	public int getToll() {
		return toll;
	}
	
	
//get cars from outside
	public void request(Vehicle a){
		//get vehicle from outside to square
		int eski = a.getWhere();
		int yeni;
		
		if(eski==11){yeni=12;}
		else if(eski==21){yeni=22;}
		else{
			System.out.println("Toll da hata cıktı");
			yeni=0;}
		
			
		a.setWhere(yeni);
	}


	@Override
	public String toString() {
		return "NULL";
}
}
