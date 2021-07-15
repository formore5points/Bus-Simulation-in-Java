
public class Bus {
	private String ID;
	private Passenger[] Passengers;
	private Line Line;
	private Stack Luggages;
	private int X;
	private int Y;
	private int WaitingTime;

	public Bus(String iD, Line line, int x, int y) {
		ID = iD;
		X = x;
		Y = y;
		Line=line;
		Passengers = new Passenger[8];
		Luggages = new Stack(8);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public int getWaitingTime() {
		return WaitingTime;
	}

	public void setWaitingTime(int Waitingtime) {
		WaitingTime = Waitingtime;
	}

	public Passenger[] getPassengers() {
		return Passengers;
	}

	public void setPassengers(Passenger[] passengers) {
		Passengers = passengers;
	}

	public Line getLine() {
		return Line;
	}

	public void setLine(Line line) {
		Line = line;
	}

	public void getLuggages() {
		int a = Luggages.size();
		Stack temp = new Stack(8);
		for (int i = 0; i < a; i++) {
			Luggage L=new Luggage();
			L=(Luggage) Luggages.peek();
			System.out.println(L.getID());
			temp.push(Luggages.pop());

		}
		for (int i = 0; i < a; i++) {
			Luggages.push(temp.pop());

		}
	}

	public void setLuggages(Stack luggages) {
		Luggages = luggages;
	}
	
	public Stack getOriginalLuggages() {
		return Luggages;
	}
 
	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public void addPassenger(Passenger p) {
		Passengers[WhereIsEmpty()] = p;
		for (int i=0;i<p.getOriginalLuggages().length;i++) {
			Luggages.push(p.getOriginalLuggages()[i]);
		}
	}

	public void deletePassenger(int ID) {
		Passengers[ID] = null;
	}

	public int NumberOfPassengersInTheBus() {
		int Number = 0;
		for (int i = 0; i < Passengers.length; i++) {
			if (Passengers[i] == null)
				Number = Number;
			else
				Number++;
		}
		return Number;
	}
	
	public int WhereIsEmpty() {
		int Returner=0;
		for (int i = 0; i < Passengers.length; i++) {
			if (Passengers[i] == null) {
				Returner=i;
				break;
			}
		}
		
		
		return Returner;
	}

	public void printBusDown() {
		AnaClass.cn.getTextWindow().setCursorPosition(X, Y);
		System.out.print(" ");
		AnaClass.Ekran[Y][X] = " ";
		Y++;
		AnaClass.cn.getTextWindow().setCursorPosition(X, Y);
		System.out.println(NumberOfPassengersInTheBus());
		AnaClass.Ekran[Y][X] = ID;
	}

	public void printBusUp() {
		AnaClass.cn.getTextWindow().setCursorPosition(X, Y);
		System.out.print(" ");
		AnaClass.Ekran[Y][X] = " ";
		Y--;
		AnaClass.cn.getTextWindow().setCursorPosition(X, Y);
		System.out.println(NumberOfPassengersInTheBus());
		AnaClass.Ekran[Y][X] = ID;
	}

	public void printBusLeft() {
		AnaClass.cn.getTextWindow().setCursorPosition(X, Y);
		System.out.print(" ");
		AnaClass.Ekran[Y][X] = " ";
		X--;
		AnaClass.cn.getTextWindow().setCursorPosition(X, Y);
		System.out.println(NumberOfPassengersInTheBus());
		AnaClass.Ekran[Y][X] = ID;
	}

	public void printBusRight() {
		AnaClass.cn.getTextWindow().setCursorPosition(X, Y);
		System.out.print(" ");
		AnaClass.Ekran[Y][X] = " ";
		X++;
		AnaClass.cn.getTextWindow().setCursorPosition(X, Y);
		System.out.println(NumberOfPassengersInTheBus());
		AnaClass.Ekran[Y][X] = ID;
	}

	public void Display() {
		int counter=0;
		AnaClass.cn.getTextWindow().setCursorPosition(60, 11);
		System.out.println("Bus  [" + ID + "] Passengers:");
		for (int i = 0; i < 8; i++) {
			if (Passengers[i] != null) {
				AnaClass.cn.getTextWindow().setCursorPosition(60, 12 + counter);
				Passengers[i].DisplayForBus();
				counter++;
			}
				
				
		}		
		for(int i=0;i<8;i++) {
			AnaClass.cn.getTextWindow().setCursorPosition(88, 14+i);
			System.out.print("|");
			AnaClass.cn.getTextWindow().setCursorPosition(92, 14+i);
			System.out.print("|");
		}
		AnaClass.cn.getTextWindow().setCursorPosition(68, 21);
		System.out.println("Bus  [" + ID + "] Luggage:");
		AnaClass.cn.getTextWindow().setCursorPosition(88, 22);
		System.out.println("-----");
		
		int a = Luggages.size();
		Stack temp = new Stack(8);
		for (int i = 0; i < a; i++) {
			Luggage L=new Luggage();			
			L=(Luggage) Luggages.peek();
			if(L.getID()<100) {
				AnaClass.cn.getTextWindow().setCursorPosition(90, (22-a)+i);
				System.out.println(L.getID());
			}
			else if(L.getID()>99) {
				AnaClass.cn.getTextWindow().setCursorPosition(89, (22-a)+i);
				System.out.println(L.getID());
			}
			
			temp.push(Luggages.pop());

		}
		for (int i = 0; i < a; i++) {
			Luggages.push(temp.pop());

		}

	}
}
