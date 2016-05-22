import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/*
 * @author abdullah oguk
			  
			  								 |`			  |
			 								 |	 		  |
			  _________			   __________|		M	  |___________			______________
			 |		  |			   |		 |		A	  |			  |			|			 |
			 |		  -->-Toll1->----		 |		R	  |			 --<-Toll3-<--			 |
		     |	  11  |			   |	12   |		M	  |	   22	  |			|	  21	 |
		     |		  -->-Toll2->----    	 |		A	  |			 --<-Toll4-<--			 |
		     |________|			   |_________|		R	  |___________|			|____________|
			  								 |		A	  |
			Anadolu Dış						 |			  |
			  								 |			  |
			  
			 
 
 */


public class Main {
	public static int state; //state num 1 > continue - 0 > finish 

	// tüm aracları tutan array vehicles
	public static Vehicle[] arabalar;
	//public static Toll[] giseler;

	public static Toll gise1;
	public static Toll gise2;
	public static Toll gise3;
	public static Toll gise4;

	public static Ferry vapur;
	
	public static Vehicle araba1;
	public static Vehicle araba2;
	public static Vehicle araba3;
	public static Vehicle araba4;
	public static Vehicle araba5;
	public static Vehicle araba6;
	public static Vehicle araba7;
	public static Vehicle araba8;
	public static Vehicle araba9;
	public static Vehicle araba10;
	
	
	public static Vehicle minibus1;
	public static Vehicle minibus2;
	public static Vehicle minibus3;
	public static Vehicle minibus4;
	public static Vehicle minibus5;
	public static Vehicle minibus6;
	public static Vehicle minibus7;
	public static Vehicle minibus8;
	
	public static Vehicle kamyon1;
	public static Vehicle kamyon2;
	public static Vehicle kamyon3;
	public static Vehicle kamyon4;
	public static Vehicle kamyon5;
	public static Vehicle kamyon6;
	public static Vehicle kamyon7;
	public static Vehicle kamyon8;
	
	
	

	
	
	public static void main(String[] args) {
		init();
		// run methods while
		while(state != 0){
		// Randomize array
		//shuffleArray();
		for (int i=0;i<arabalar.length;i++){
			System.out.println(arabalar[i]);}
		System.out.println(vapur);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// araclar arrayindeki tüm aracların counterlarını belli aralıklarla kontrol et
					int carCount =26;
					for (int i=0;i<arabalar.length;i++){
						if(arabalar[i].getCounter() == 0){
							carCount--;
						}
					}//end of for
					if (carCount==0){
						vapur.setState(4);
						state =0;
						for (int i=0;i<arabalar.length;i++){
							System.out.println(arabalar[i]);}
						System.out.println(vapur);
					}
		}//End of Run
		System.out.println("SUCCESSFULL FINISH");
	}
	
	public static int getrand(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void shuffleArray(){
		long seed = System.nanoTime();
		Collections.shuffle(Arrays.asList(arabalar), new Random(seed));
		
	}

	
	
	public static void init(){
		//4 tane toll objesi olustur
		gise1=new Toll("Gise1",1,1);
		gise2=new Toll("Gise2",1,2);
		gise3=new Toll("Gise3",2,3);
		gise4=new Toll("Gise4",2,4);
		//1 vapur
		vapur = new Ferry("VAPUR",getrand(1,2));
		
		//10 araba
		araba1 = new Vehicle("Araba1",1,getrand(1,2));
		araba2 = new Vehicle("Araba2",1,getrand(1,2));
		araba3 = new Vehicle("Araba3",1,getrand(1,2));
		araba4 = new Vehicle("Araba4",1,getrand(1,2));
		araba5 = new Vehicle("Araba5",1,getrand(1,2));
		araba6 = new Vehicle("Araba6",1,getrand(1,2));
		araba7 = new Vehicle("Araba7",1,getrand(1,2));
		araba8 = new Vehicle("Araba8",1,getrand(1,2));
		araba9 = new Vehicle("Araba9",1,getrand(1,2));
		araba10 = new Vehicle("Araba10",1,getrand(1,2));
		
		//8 minibus
		minibus1 = new Vehicle("MiniBus1",2,getrand(1,2));
		minibus2 = new Vehicle("MiniBus2",2,getrand(1,2));
		minibus3 = new Vehicle("MiniBus3",2,getrand(1,2));
		minibus4 = new Vehicle("MiniBus4",2,getrand(1,2));
		minibus5 = new Vehicle("MiniBus5",2,getrand(1,2));
		minibus6 = new Vehicle("MiniBus6",2,getrand(1,2));
		minibus7 = new Vehicle("MiniBus7",2,getrand(1,2));
		minibus8 = new Vehicle("MiniBus8",2,getrand(1,2));
		
		//8 kamyon 
		kamyon1 = new Vehicle("Kamyon1",3,getrand(1,2));
		kamyon2 = new Vehicle("Kamyon2",3,getrand(1,2));
		kamyon3 = new Vehicle("Kamyon3",3,getrand(1,2));
		kamyon4 = new Vehicle("Kamyon4",3,getrand(1,2));
		kamyon5 = new Vehicle("Kamyon5",3,getrand(1,2));
		kamyon6 = new Vehicle("Kamyon6",3,getrand(1,2));
		kamyon7 = new Vehicle("Kamyon7",3,getrand(1,2));
		kamyon8 = new Vehicle("Kamyon8",3,getrand(1,2));


		
		//tüm aracları araclar arrayine koy
		
		arabalar = new Vehicle[] {araba1,araba2,araba3,araba4,araba5,araba6,araba7,araba8,araba9,araba10,
				minibus1,minibus2,minibus3,minibus4,minibus5,minibus6,minibus7,minibus8,
				kamyon1,kamyon2,kamyon3,kamyon4,kamyon5,kamyon6,kamyon7,kamyon8};
		
		
		//shuffle array
		shuffleArray();
		state = 1;

		//vapur ve tolları calıstır
		vapur.start();
		
		
		//TODO: syncronize methodes
		

		// tüm aracları araclar arrayinden gezip > run metodlarını calıstır
		for (int i=0;i<arabalar.length;i++){
			arabalar[i].start();}
		
		
		
	}//end of init
}
