
public class Vehicle extends Thread {
	// extend thread

	private int size; //1>araba 2>minibus 3>kamyon
	private int where; //11 or 12 or 13 OR 21 or 22 or 23
	private int counter; //starts from 2 
	private int port; //1 or 2
	private int toll; //1 , 2 or 3, 4
	public String name; 
	
	
	//construct
	public Vehicle(String name,int size,int port){
		this.name= name;
		this.size = size;
		this.port = port;
		this.setToll();
		if(port==1){where = 11;}
		else{where = 21;}
		this.counter =2;
	}
	
	
	//getters setters
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWhere() {
		return where;
	}

	public void setWhere(int where) {
		this.where = where;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter() {
		counter--;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getToll() {
		return toll;
	}
	
	
	//will be runned by ferry after leaved from ferry
	public void setToll() {
		//get port and and generate random toll
		if(port == 1){this.toll = Main.getrand(1,2);}
		else if (port == 2){this.toll = Main.getrand(3,4);}
		else{System.out.println("Araca Port atanırken hata cıktı");}
	}
	
	
	
//ask toll where == 11 or 21
	private void askToll(){
		//if else toll objects
		switch(toll){
			case 1: Main.gise1.request(this);
			break;
			case 2: Main.gise2.request(this);
			break;
			case 3: Main.gise3.request(this);
			break;
			case 4: Main.gise4.request(this);
			break;
			default: System.out.println(this.name+ " giseye giriyor");
		}
		
	}
	
//wait ferry when where == 12 or 22
	private void waitMeydan(){
		//wait for ferry
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleep5(){
		//sleep five sec
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		//Car info
		return "< " + this.name + " > " + getCounter() + " moves left " + "where: " + getWhere();
	}


	@Override
	public void run() {
		//Run method of vehicle thread
		while(counter!=0){
			if(this.where == 11 | this.where == 21)
				askToll();
			else if(this.where == 12 | this.where == 22){waitMeydan();}
			else if(this.where == 13 | this.where == 23){try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}

			else{System.err.println("Aracın Run metodunda hata var");}
		}
		
		
		
	}
	
	
	
	
	
}
