
public class Ferry extends Thread {
	// extend thread

	
	private int where; //1 or 2
	private int state; //0>ready, 1>travelling, 2>getting, 3>leaving cars or 4>finished 
	private int capacity;
	public String name; //Ferry

	public int anaOut= 11;
	public int anaSq= 12;
	public int anaToEu= 13;
	public int euOut= 21;
	public int euSq= 22;
	public int euToAna= 23;
	
	
	
	//Cars array or queue
	
	//construct
	public Ferry(String name,int where){
		this.name=name;
		this.where = where;
		this.state = 0;
		setCapacity();
	}
	
	
	//getters setters
	public int getWhere() {
		return where;
	}	
	public int getstate() {
		return state;
	}
	public void setState (int state) {
		this.state = state;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity() {
		//set to default
		this.capacity = 20;
	}
	public void setWhere(int where) {
		this.where = where;
	}

	
	//get cars from square
	private void getCars(int j){
		// get a from square to ferry
		setState(2); //2 > getting cars
		int eski;
		int yeni;
		
		//Avrupaya gidecekleri al
		if(j == 1){
			eski = anaSq;
			yeni = anaToEu; 
		}
		
		//Anadoluya gidecekleri al
		else if (j==2){
			eski = euSq;
			yeni = euToAna;
		}
		else{
			System.out.println("Vapura araç alırken hata cıktı");
			eski = 0;
			yeni = 0;
		}
		
		
		//Arrayi gez
		for(int i = 0; i<26; i++){
			
			if((Main.arabalar[i].getWhere() == eski) && (Main.arabalar[i].getSize()<=getCapacity())){
				Main.arabalar[i].setWhere(yeni);
				capacity = capacity - Main.arabalar[i].getSize();
				Main.arabalar[i].sleep5();
			}
		}//End of for
		setState(1);//1 > Travelling
		if(j==1){setWhere(2);}
		else{setWhere(1);}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//leave cars to outside
	private void leaveCars(int j){
		// move cars to outside from ferry
		// get a from square to ferry
				setState(3); //3 > leave cars
				int eski;
				int yeni;
				int yeniPort;
				
				//andoluda dısarı birak
				if(j == 1){
					eski = euToAna;
					yeni = anaOut;
					yeniPort = 1 ;
				}
				
				//avrupada dişari birak
				else if (j==2){
					eski = anaToEu;
					yeni = euOut;
					yeniPort = 2;
				}
				else{
					System.out.println("Araç indirirken hata oldu");
					eski = 0;
					yeni = 0;
					yeniPort = 0;
				}
				
				
				//Arrayi gez
				for(int i = 0; i<26; i++){
					if(Main.arabalar[i].getWhere() == eski){
						Main.arabalar[i].setPort(yeniPort);
						Main.arabalar[i].setWhere(yeni);
						Main.arabalar[i].setCounter();
						Main.arabalar[i].setToll();
					}
				}//End of for
				setCapacity();
				setState(0);//0 > Ready
			}//End of Leave cars


	@Override
	public String toString() {
		// Switch case based on where variable
		return "<<<<<  VAPUR  >>>>" + "state: " + getstate() + " where: " + getWhere() + " capacity: " + getCapacity();
	}



	//Run method
	public void run(){
		
		//While not finished
		while(state!=4){
			//READY STATE
			if(state== 0){
				if(where==1){getCars(1);}//Anadolu yakasi
				else if(where==2){getCars(2);}//Avrupa Yakasi
				else{System.err.println("Fatal Error in ready state before getting cars");}
			}
			
			//Travelling finished
			else if(state== 1){
				if(where==1){leaveCars(1);}//Anadolu yakasi
				else if(where==2){leaveCars(2);}//Avrupa Yakasi
				else{System.err.println("Fatal Error in travelling state before leaving cars");}

			}
			else{
				System.out.println("Fatal Error in conditon of Ferry");
			}		
		}//EO while
	}//End of RUN
}
