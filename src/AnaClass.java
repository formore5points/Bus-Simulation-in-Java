import java.awt.Color;
import java.util.Random;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class AnaClass {
	public static enigma.console.Console cn = Enigma.getConsole("Big City", 130, 32, 19, 0);
	public static Thread Timer = new Thread(new ClassTimer());
	public static int PassengerID = 0;
	public static int Luggager = 0;
	public static int Time = 0;
	public static boolean Passengerer=true;
	public static boolean General=true;
	public static boolean Pass=true;
	public static Luggage LuggageTemp=new Luggage();
	public static Queue Summoner=new Queue(10000);
	public static BusStop[] BusStops = new BusStop[16];
	public static Line[] Lines = new Line[6];
	public static Bus[] Buses = new Bus[12];

	public static String[][] Ekran = new String[][] {
		{" ","1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7","8","9","0","1","2","3","4","5","6","7"},
		{"1","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#"},
		{"2","#","A"," "," "," "," "," "," ","#","#","#","#","#","B"," "," "," "," "," "," "," "," "," "," "," "," ","#","#","#","#","#","C"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","D","#","#","#","#","#","#","#"},
		{"3","#"," ","0","#","#","#","#","#","#","#","#","#","#"," ","0","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","0","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","0","#","#","#","#","#","#"},
		{"4","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#","#","#"},
		{"5","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#","#","#"},
		{"6","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#","#","#"},
		{"7","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#","#","#"},                                    
		{"8","#","E"," "," "," "," "," "," "," "," "," "," "," ","F"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","G","#","#","#","#","#"," "," "," "," "," "," "," "," "," "," "," "," ","H"," "," "," "," "," "," ","#"},
		{"9","#"," ","0","#","#","#","#","#","#","#","#","#","#"," ","0","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","0","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","0","#","#","#","#"," ","#"},
		{"0","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#"},
		{"1","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#"},
		{"2","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#",},
		{"3","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#"},
		{"4","#","I"," "," "," "," "," "," "," "," "," "," "," ","J"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","K"," "," "," "," "," "," "," "," "," "," "," ","L","#","#","#","#","#"," "," "," "," "," "," "," ","#"},
		{"5","#","#","0","#","#","#","#"," ","#","#","#","#","#"," ","0","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","0","#","#","#","#"," ","#","#","#","#","#"," ","0","#","#","#","#"," ","#","#","#","#","#"," ","#"},
		{"6","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#"},
		{"7","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#"},
		{"8","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#"},
		{"9","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#","#","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#","#","#","#","#"," ","#"},
		{"0","#"," "," "," "," "," "," ","M"," "," "," "," "," ","N"," "," "," "," "," "," ","#","#","#","#","#"," "," "," "," "," "," ","O"," "," "," "," "," "," "," "," "," "," "," ","P"," "," "," "," "," "," "," "," "," "," "," "," ","#"},
		{"1","#","#","#","#","#","#","#","#","0","#","#","#","#","#","0","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","#","0","#","#","#","#","#","#","#","#","#","#","#","0","#","#","#","#","#","#","#","#","#","#","#","#"},		
	};
	
	public static void Screen() {
		for (int i=0;i<22;i++) {
			for (int j = 0; j < 58; j++) 
                System.out.print(Ekran[i][j]);
			
			cn.getTextWindow().setCursorPosition(0, i+1);
		}
		Ekran[3][3]=Integer.toString(BusStops[0].NumberOfWaitingPassengers());Ekran[3][15]=Integer.toString(BusStops[1].NumberOfWaitingPassengers());Ekran[3][33]=Integer.toString(BusStops[2].NumberOfWaitingPassengers());
		Ekran[3][51]=Integer.toString(BusStops[3].NumberOfWaitingPassengers());Ekran[9][3]=Integer.toString(BusStops[4].NumberOfWaitingPassengers());Ekran[9][15]=Integer.toString(BusStops[5].NumberOfWaitingPassengers());
		Ekran[9][33]=Integer.toString(BusStops[6].NumberOfWaitingPassengers());Ekran[9][51]=Integer.toString(BusStops[7].NumberOfWaitingPassengers());Ekran[15][3]=Integer.toString(BusStops[8].NumberOfWaitingPassengers());
		Ekran[15][15]=Integer.toString(BusStops[9].NumberOfWaitingPassengers());Ekran[15][33]=Integer.toString(BusStops[10].NumberOfWaitingPassengers());Ekran[15][45]=Integer.toString(BusStops[11].NumberOfWaitingPassengers());
		Ekran[21][9]=Integer.toString(BusStops[12].NumberOfWaitingPassengers());Ekran[21][15]=Integer.toString(BusStops[13].NumberOfWaitingPassengers());Ekran[21][33]=Integer.toString(BusStops[14].NumberOfWaitingPassengers());
		Ekran[21][45]=Integer.toString(BusStops[15].NumberOfWaitingPassengers());
		cn.getTextWindow().setCursorPosition(62, 0);
		System.out.println("Time:   ");
		cn.getTextWindow().setCursorPosition(62, 2);
		System.out.println("New Passengers");
		cn.getTextWindow().setCursorPosition(62, 3);
		System.out.println("---------------");
		cn.getTextWindow().setCursorPosition(62, 5);
		System.out.println("---------------");
		cn.getTextWindow().setCursorPosition(60, 4);
		System.out.println(">");
		cn.getTextWindow().setCursorPosition(78, 4);
		System.out.println(">");
		cn.getTextWindow().setCursorPosition(60, 7);
		System.out.println("Waiting     :" + Waiting());
		cn.getTextWindow().setCursorPosition(60, 8);
		System.out.println("Travelling  :" + Travelling());
		cn.getTextWindow().setCursorPosition(60, 9);
		System.out.println("Bus fullness:" + (Travelling() * 100 / 96) + "%");

	}

	public static void MoveBus(Bus Bus,int Waiting) {
		String Name = Bus.getID();
		int x = Bus.getX();
		int y = Bus.getY();
	
		//1Kodlu Otobüsler
		if(Waiting==0) {
		if (Name.equals("A1")) {
			if (x == 2 && y < 14)
				Bus.printBusDown();
			else if (y == 14 && x < 44)
				Bus.printBusRight();
			else if(x==44 && y==14) 
				Bus.setID("A2");		
		}

		else if (Name.equals("B1")) {
			if (x == 14 && y < 8)
				Bus.printBusDown();
			else if (y == 8 && x > 2)
				Bus.printBusLeft();
			else if (x == 2 && y < 14)
				Bus.printBusDown();
			else if (y == 14 && x < 14)
				Bus.printBusRight();
			else if (x == 14 && y < 20)
				Bus.printBusDown();
			else if (y == 20 && x > 8)
				Bus.printBusLeft();
			else if(x==8 && y==20) 
				Bus.setID("B2");				
		}
		
		else if (Name.equals("C1")) {
			if (x == 32 && y < 14)
				Bus.printBusDown();
			else if (y == 14 && x > 14)
				Bus.printBusLeft();
			else if (x == 14 && y > 8)
				Bus.printBusUp();
			else if (y == 8 && x > 2)
				Bus.printBusLeft();
			else if (x == 2 && y > 2)
				Bus.printBusUp();
			else if(x==2 && y==2) 
				Bus.setID("C2");			
		}
		
		else if (Name.equals("D1")) {
			if (y== 2 && x > 32)
				Bus.printBusLeft();
			else if (x == 32 && y<14)
				Bus.printBusDown();
			else if (y == 14 && x > 14)
				Bus.printBusLeft();
			else if (x == 14 && y < 20)
				Bus.printBusDown();
			else if (y == 20 && x > 8)
				Bus.printBusLeft();		
			else if(x==8 && y==20) 
				Bus.setID("D2");					
		}
		//Burada durak sýralarý farklý çünkü kesiþim var.Kod karýþýyor.
		else if (Name.equals("L1")) {
			if (y == 2 && x< 50)
				Bus.printBusRight();
			else if (y == 20 && x>32)
				Bus.printBusLeft();
			else if (x == 32 && y > 2)													
				Bus.printBusUp();
			else if (x==44 && y < 20)
				Bus.printBusDown();
			else if (x == 50 && y < 8)
				Bus.printBusDown();		
			else if(x==50 && y==8) 
				Bus.setID("L2");							
		}
		
		else if (Name.equals("M1")) {
			if (y== 20 && x < 14)
				Bus.printBusRight();
			else if (x == 14 && y>8)
				Bus.printBusUp();
			else if (y == 8 && x < 32)
				Bus.printBusRight();
			else if (x == 32 && y < 20)
				Bus.printBusDown();
			else if (y == 20 && x < 44)
				Bus.printBusRight();		
			else if(x==44 && y==20) 
				Bus.setID("M2");								
			
		}//2Kodlu Otobüsler
		else if (Name.equals("A2")) {
			if (y== 14 && x > 2)
				Bus.printBusLeft();
			else if (x == 2 && y>2)
				Bus.printBusUp();
			else if(x==2 && y==2) 
				Bus.setID("A1");									
		}
		
		else if (Name.equals("B2")) {
			if (y== 20 && x < 14)
				Bus.printBusRight();
			else if (x == 14 && y>14)
				Bus.printBusUp();
			else if(y==14 && x>2) 
				Bus.printBusLeft();		
			else if(x==2 && y>8) 
				Bus.printBusUp();		
			else if(y==8 && x<14) 
				Bus.printBusRight();		
			else if(x==14 && y>2) 
				Bus.printBusUp();		
			else if(x==14 && y==2) 
				Bus.setID("B1");		
		}
		
		else if (Name.equals("C2")) {
			if (x== 2 && y <8)
				Bus.printBusDown();
			else if (y == 8 && x<14)
				Bus.printBusRight();
			else if(x==14 && y<14) 
				Bus.printBusDown();		
			else if(y==14 && x<32) 
				Bus.printBusRight();		
			else if(x==32 && y>2) 
				Bus.printBusUp();					
			else if(x==32 && y==2) 
				Bus.setID("C1");							
		}
		
		else if (Name.equals("D2")) {
			if (y== 20 && x < 14)
				Bus.printBusRight();
			else if (x == 14 && y>14)
				Bus.printBusUp();
			else if (y == 14 && x < 32)
				Bus.printBusRight();
			else if (x == 32 && y > 2)
				Bus.printBusUp();
			else if (y == 2 && x < 50)
				Bus.printBusRight();		
			else if(x==50 && y==2) 
				Bus.setID("D1");		
		}
		
		else if (Name.equals("L2")) {
			if (x == 50 && y> 2)
				Bus.printBusUp();
			else if (y == 2 && x>32)
				Bus.printBusLeft();
			else if (x == 32 && y < 20)													
				Bus.printBusDown();
			else if (y==20 && x < 44)
				Bus.printBusRight();
			else if (x == 44 && y > 14)
				Bus.printBusUp();		
			else if(x==44 && y==14) 
				Bus.setID("L1");								
		}
		
		else if (Name.equals("M2")) {
			if (y== 20 && x>32)
				Bus.printBusLeft();
			else if (x == 32 && y>8)
				Bus.printBusUp();
			else if (y == 8 && x > 14)
				Bus.printBusLeft();
			else if (x == 14 && y < 20)
				Bus.printBusDown();
			else if (y == 20 && x > 8)
				Bus.printBusLeft();			
			else if(x==8 && y==20) 
				Bus.setID("M1");							
		}
		
	}
		else if(Waiting!=0) {
		Bus.setWaitingTime(Bus.getWaitingTime()-1);		
		}
	}
	
	public static void ScreenUpdater() {
		//Duraklar
		cn.getTextWindow().setCursorPosition(2, 2);
		System.out.print("A");
		cn.getTextWindow().setCursorPosition(14, 2);
		System.out.print("B");
		cn.getTextWindow().setCursorPosition(32, 2);
		System.out.print("C");
		cn.getTextWindow().setCursorPosition(50, 2);
		System.out.print("D");
		cn.getTextWindow().setCursorPosition(2, 8);
		System.out.print("E");
		cn.getTextWindow().setCursorPosition(14, 8);
		System.out.print("F");
		cn.getTextWindow().setCursorPosition(32, 8);
		System.out.print("G");
		cn.getTextWindow().setCursorPosition(50, 8);
		System.out.print("H");
		cn.getTextWindow().setCursorPosition(2, 14);
		System.out.print("I");
		cn.getTextWindow().setCursorPosition(14, 14);
		System.out.print("J");
		cn.getTextWindow().setCursorPosition(32, 14);
		System.out.print("K");
		cn.getTextWindow().setCursorPosition(44, 14);
		System.out.print("L");
		cn.getTextWindow().setCursorPosition(8, 20);
		System.out.print("M");
		cn.getTextWindow().setCursorPosition(14, 20);
		System.out.print("N");
		cn.getTextWindow().setCursorPosition(32, 20);
		System.out.print("O");
		cn.getTextWindow().setCursorPosition(44, 20);
		System.out.print("P");
		//Duraklar
		Ekran[3][3]=Integer.toString(BusStops[0].NumberOfWaitingPassengers());Ekran[3][15]=Integer.toString(BusStops[1].NumberOfWaitingPassengers());Ekran[3][33]=Integer.toString(BusStops[2].NumberOfWaitingPassengers());
		Ekran[3][51]=Integer.toString(BusStops[3].NumberOfWaitingPassengers());Ekran[9][3]=Integer.toString(BusStops[4].NumberOfWaitingPassengers());Ekran[9][15]=Integer.toString(BusStops[5].NumberOfWaitingPassengers());
		Ekran[9][33]=Integer.toString(BusStops[6].NumberOfWaitingPassengers());Ekran[9][51]=Integer.toString(BusStops[7].NumberOfWaitingPassengers());Ekran[15][3]=Integer.toString(BusStops[8].NumberOfWaitingPassengers());
		Ekran[15][15]=Integer.toString(BusStops[9].NumberOfWaitingPassengers());Ekran[15][33]=Integer.toString(BusStops[10].NumberOfWaitingPassengers());Ekran[15][45]=Integer.toString(BusStops[11].NumberOfWaitingPassengers());
		Ekran[21][9]=Integer.toString(BusStops[12].NumberOfWaitingPassengers());Ekran[21][15]=Integer.toString(BusStops[13].NumberOfWaitingPassengers());Ekran[21][33]=Integer.toString(BusStops[14].NumberOfWaitingPassengers());
		Ekran[21][45]=Integer.toString(BusStops[15].NumberOfWaitingPassengers());
		//Bekleyenler
		cn.getTextWindow().setCursorPosition(3, 3);
		if(Integer.parseInt(Ekran[3][3])<10)
		System.out.print(Ekran[3][3]+"#");
		else
			System.out.print(Ekran[3][3]);
		
		cn.getTextWindow().setCursorPosition(15, 3);
		if(Integer.parseInt(Ekran[3][15])<10)
		System.out.print(Ekran[3][15]+"#");
		else
			System.out.print(Ekran[3][15]);
		
		cn.getTextWindow().setCursorPosition(33, 3);
		if(Integer.parseInt(Ekran[3][33])<10)
		System.out.print(Ekran[3][33]+"#");
		else
			System.out.print(Ekran[3][33]);
		
		cn.getTextWindow().setCursorPosition(51, 3);
		if(Integer.parseInt(Ekran[3][51])<10)
		System.out.print(Ekran[3][51]+"#");
		else
			System.out.print(Ekran[3][51]);
		
		cn.getTextWindow().setCursorPosition(3, 9);
		if(Integer.parseInt(Ekran[9][3])<10)
		System.out.print(Ekran[9][3]+"#");
		else
			System.out.print(Ekran[9][3]);
		
		cn.getTextWindow().setCursorPosition(15, 9);
		if(Integer.parseInt(Ekran[9][15])<10)
		System.out.print(Ekran[9][15]+"#");
		else
			System.out.print(Ekran[9][15]);
		
		cn.getTextWindow().setCursorPosition(33, 9);
		if(Integer.parseInt(Ekran[9][33])<10)
		System.out.print(Ekran[9][33]+"#");
		else
			System.out.print(Ekran[9][33]);
		
		cn.getTextWindow().setCursorPosition(51, 9);
		if(Integer.parseInt(Ekran[9][51])<10)
		System.out.print(Ekran[9][51]+"#");
		else
			System.out.print(Ekran[9][51]);
		
		cn.getTextWindow().setCursorPosition(3, 15);
		if(Integer.parseInt(Ekran[15][3])<10)
		System.out.print(Ekran[15][3]+"#");
		else
			System.out.print(Ekran[15][3]);
		
		cn.getTextWindow().setCursorPosition(15, 15);
		if(Integer.parseInt(Ekran[15][15])<10)
		System.out.print(Ekran[15][15]+"#");
		else
			System.out.print(Ekran[15][15]);
		
		cn.getTextWindow().setCursorPosition(33, 15);
		if(Integer.parseInt(Ekran[15][33])<10)
		System.out.print(Ekran[15][33]+"#");
		else
			System.out.print(Ekran[15][33]);
		
		cn.getTextWindow().setCursorPosition(45, 15);
		if(Integer.parseInt(Ekran[15][45])<10)
		System.out.print(Ekran[15][45]+"#");
		else
			System.out.print(Ekran[15][45]);
		
		cn.getTextWindow().setCursorPosition(9, 21);
		if(Integer.parseInt(Ekran[21][9])<10)
		System.out.print(Ekran[21][9]+"#");
		else
			System.out.print(Ekran[21][9]);
		
		cn.getTextWindow().setCursorPosition(15, 21);
		if(Integer.parseInt(Ekran[21][15])<10)
		System.out.print(Ekran[21][15]+"#");
		else
			System.out.print(Ekran[21][15]);
		
		cn.getTextWindow().setCursorPosition(33, 21);
		if(Integer.parseInt(Ekran[21][33])<10)
		System.out.print(Ekran[21][33]+"#");
		else
			System.out.print(Ekran[21][33]);
		
		cn.getTextWindow().setCursorPosition(45, 21);
		if(Integer.parseInt(Ekran[21][45])<10)
		System.out.print(Ekran[21][45]+"#");
		else
			System.out.print(Ekran[21][45]);
		//Statistics
		cn.getTextWindow().setCursorPosition(73, 7);
		System.out.println(Waiting()+" ");
		cn.getTextWindow().setCursorPosition(73, 8);
		System.out.println(Travelling()+" ");
		cn.getTextWindow().setCursorPosition(73, 9);
		System.out.println("       ");
		cn.getTextWindow().setCursorPosition(73, 9);
		System.out.println((Travelling() * 100 / 96)+"%");
	
	}

	public static int Waiting() {
		int Waiting = 0;
		for (int i = 0; i < BusStops.length; i++) {
			Waiting = Waiting + BusStops[i].NumberOfWaitingPassengers();
		}
		return Waiting;
	}

	public static int Travelling() {
		int Travelling = 0;
		for (int i = 0; i < 12; i++) {
			Travelling = Travelling + Buses[i].NumberOfPassengersInTheBus();
		}
		return Travelling;

	}

	public static void First15Passenger() {
		for (int i=0;i<15;i++) {			
		RandomPassenger();
		}
	}
	
	public static void RandomPassenger() {
		Random rnd = new Random();
		int Line = rnd.nextInt(6);
		int InStation = rnd.nextInt(AnaClass.Lines[Line].getRotate().length);
		int OutStation = rnd.nextInt(AnaClass.Lines[Line].getRotate().length);
		while(InStation==OutStation) {
			 OutStation = rnd.nextInt(AnaClass.Lines[Line].getRotate().length);
		}	
		int Luggage = rnd.nextInt(3);
		Passenger Passenger = new Passenger(AnaClass.PassengerID, AnaClass.Lines[Line], InStation, OutStation, Luggage);
		AnaClass.Summoner.enqueue(Passenger);
		PassengerID++;
	}
	
	public static int WaitCalculator(Bus Bus,BusStop[] BusStop) {
		/*cn.getTextWindow().setCursorPosition(80, 25);
		System.out.println(Bus.getX()+" "+Bus.getY());
		cn.getTextWindow().setCursorPosition(80, 26);
		System.out.println(Bus.getLine().getRotate()[Bus.getLine().getRotate().length-1].getX()+" "+Bus.getLine().getRotate()[Bus.getLine().getRotate().length-1].getY());
		if(Bus.getX()==Bus.getLine().getRotate()[Bus.getLine().getRotate().length-1].getX()&&Bus.getY()==Bus.getLine().getRotate()[Bus.getLine().getRotate().length-1].getY()) {
			System.out.println("GÝRDÝ");
		}*/
		String Name = Bus.getID();
		Stack Temp=new Stack(8);			
		int Busx = Bus.getX();
		int Busy = Bus.getY();		
		int WaitingTime=0;
		Passenger Geçici=new Passenger();
		for (int d=0;d<BusStop.length;d++) {
			int Durakx=BusStop[d].getX();
			int Duraky=BusStop[d].getY();
		if(Bus.getWaitingTime()==0) {
		if((Busx==Durakx && Busy==Duraky) )	{			
		for (int i=0;i<8;i++) {
			if(Bus.getPassengers()[i]!=null) {		
						if((Bus.getPassengers()[i].getLine().getRotate()[Bus.getPassengers()[i].getOut()].getX() == Durakx) && (Bus.getPassengers()[i].getLine().getRotate()[Bus.getPassengers()[i].getOut()].getY() == Duraky)) {      
                            Geçici=Bus.getPassengers()[i];
                            Bus.deletePassenger(i);
                        	int PassengerLuggageSize=Geçici.getOriginalLuggages().length;		
                        	while (!Bus.getOriginalLuggages().isEmpty()) {
                        		Pass=true;                      		
							for (int j=0;j<PassengerLuggageSize;j++) {
								if(!Bus.getOriginalLuggages().isEmpty()) {
								LuggageTemp=(Luggage) Bus.getOriginalLuggages().peek();		
								}						
                                      if(LuggageTemp==Geçici.getOriginalLuggages()[j]) {
                                    	  Bus.getOriginalLuggages().pop();
                                    	  Pass=false;
                                    	  WaitingTime++;                                           	  
                                }                                     
							}	
							
							
							if(Pass) {
								Temp.push(Bus.getOriginalLuggages().pop());						
								WaitingTime++;  
							}													
                 }
                        	while(!Temp.isEmpty()) {
                        		Bus.getOriginalLuggages().push(Temp.pop());       
                        		WaitingTime++;  
                        	}                       	               	
		}									
	}		
}
		
		
		
		
	for (int t=0;t<50;t++) {
		
		if(BusStop[d].getPassengers()[t]!=null) {
			
			if(BusStop[d].getPassengers()[t].getIn()<BusStop[d].getPassengers()[t].getOut()) {
				
				if(Name.contains("1")) {		
					
					if(BusStop[d].getPassengers()[t].getLine()==Bus.getLine()) {
						
						if((Bus.NumberOfPassengersInTheBus()!=8) && BusStop[d].getPassengers()[t].getOriginalLuggages().length+Bus.getOriginalLuggages().size()<=8) {
							WaitingTime=WaitingTime+BusStop[d].getPassengers()[t].getOriginalLuggages().length;
							Bus.addPassenger(BusStop[d].getPassengers()[t]);
							BusStop[d].deletePassenger(t);							
							}												
						}
					}
				}
			else if(BusStop[d].getPassengers()[t].getIn()>BusStop[d].getPassengers()[t].getOut()) {
				if(Name.contains("2")) {
					if(BusStop[d].getPassengers()[t].getLine()==Bus.getLine()) {
						if((Bus.NumberOfPassengersInTheBus()!=8) && BusStop[d].getPassengers()[t].getOriginalLuggages().length+Bus.getOriginalLuggages().size()<=8) {
							WaitingTime=WaitingTime+BusStop[d].getPassengers()[t].getOriginalLuggages().length;
							Bus.addPassenger(BusStop[d].getPassengers()[t]);
							BusStop[d].deletePassenger(t);							
							}
						}
					}			
				}
			}
		}
	}
		Bus.setWaitingTime(WaitingTime);
}	
		else {
			WaitingTime=Bus.getWaitingTime();
		       }
}
		return WaitingTime;
	}
	
	public static void MoveAllBuses() {
		for(int i=0;i<Buses.length;i++)
			MoveBus(Buses[i],WaitCalculator(Buses[i],BusStops));	
	}			
	
	public static void main(String[] args) throws Exception {
		
		TextAttributes ScreenOrganizer=new TextAttributes(Color.PINK,Color.BLACK);
		cn.setTextAttributes(ScreenOrganizer);
		
		BusStops[0] = new BusStop("A", 2, 2);
		BusStops[1] = new BusStop("B", 14, 2);
		BusStops[2] = new BusStop("C", 32, 2);
		BusStops[3] = new BusStop("D", 50, 2);
		BusStops[4] = new BusStop("E", 2, 8);
		BusStops[5] = new BusStop("F", 14, 8);
		BusStops[6] = new BusStop("G", 32, 8);
		BusStops[7] = new BusStop("H", 50, 8);
		BusStops[8] = new BusStop("I", 2, 14);
		BusStops[9] = new BusStop("J", 14, 14);
		BusStops[10] = new BusStop("K", 32, 14);
		BusStops[11] = new BusStop("L", 44, 14);
		BusStops[12] = new BusStop("M", 8, 20);
		BusStops[13] = new BusStop("N", 14, 20);
		BusStops[14] = new BusStop("O", 32, 20);
		BusStops[15] = new BusStop("P", 44, 20);

		Lines[0] = new Line("A", 6);
		Lines[1] = new Line("B", 7);
		Lines[2] = new Line("C", 7);
		Lines[3] = new Line("D", 7);
		Lines[4] = new Line("L", 8);
		Lines[5] = new Line("M", 8);

		Lines[0].SetLine6(BusStops[0], BusStops[4], BusStops[8], BusStops[9], BusStops[10], BusStops[11]);
		Lines[1].SetLine7(BusStops[1], BusStops[5], BusStops[4], BusStops[8], BusStops[9], BusStops[13], BusStops[12]);
		Lines[2].SetLine7(BusStops[2], BusStops[6], BusStops[10], BusStops[9], BusStops[5], BusStops[4], BusStops[0]);
		Lines[3].SetLine7(BusStops[3], BusStops[2], BusStops[6], BusStops[10], BusStops[9], BusStops[13], BusStops[12]);
		Lines[4].SetLine8(BusStops[11], BusStops[15], BusStops[14], BusStops[10], BusStops[6], BusStops[2], BusStops[3],BusStops[7]);
		Lines[5].SetLine8(BusStops[12], BusStops[13], BusStops[9], BusStops[5], BusStops[6], BusStops[10], BusStops[14],BusStops[15]);

		Buses[0] = new Bus("A1", Lines[0], 2, 2);
		Buses[1] = new Bus("B1", Lines[1], 14, 2);
		Buses[2] = new Bus("C1", Lines[2], 32, 2);
		Buses[3] = new Bus("D1", Lines[3], 50, 2);
		Buses[4] = new Bus("L1", Lines[4], 44, 14);
		Buses[5] = new Bus("M1", Lines[5], 8, 20);
		Buses[6] = new Bus("A2", Lines[0], 44, 14);
		Buses[7] = new Bus("B2", Lines[1], 8, 20);
		Buses[8] = new Bus("C2", Lines[2], 2, 2);
		Buses[9] = new Bus("D2", Lines[3], 8, 20);
		Buses[10] = new Bus("L2", Lines[4], 50, 8);
		Buses[11]= new Bus("M2", Lines[5], 44, 20);		
		
		First15Passenger();	
		Screen(); 
		Timer.start();	
	    Game newGame = new Game();	
		
	}
}
