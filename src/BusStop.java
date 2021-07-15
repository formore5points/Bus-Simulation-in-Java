
public class BusStop {
	private String Name;
	private Passenger[] Passengers;
	private int X;
	private int Y;
	private int PassengerAdder;

	public BusStop(String name, int x, int y) {
		Name = name;
		X = x;
		Y = y;
		Passengers = new Passenger[50];
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Passenger[] getPassengers() {
		return Passengers;
	}

	public void setPassengers(Passenger[] passengers) {
		Passengers = passengers;
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
		Passengers[PassengerAdder] = p;
		PassengerAdder++;
	}

	public void deletePassenger(int PassengerID) {
		Passengers[PassengerID] = null;

	}

	public int NumberOfWaitingPassengers() {
		int Number = 0;
		for (int i = 0; i < Passengers.length; i++) {
			if (Passengers[i] == null)
				Number = Number;
			else
				Number++;
		}
		return Number;
	}

	public void Display() {
		int counter=0;
		AnaClass.cn.getTextWindow().setCursorPosition(60, 11);
		System.out.println("Bus Stop [" + Name + "] Passengers:");

		for (int i = 0; i < 50; i++) {
			if (Passengers[i] != null) {
				AnaClass.cn.getTextWindow().setCursorPosition(60, 12 + counter);
				Passengers[i].DisplayForBusStop();
				counter++;
			}
			
				
			

		}

	}

}
