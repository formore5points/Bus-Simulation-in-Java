import java.util.Arrays;

public class Passenger {
	private int ID;
	private Line Line;
	private int In;
	private int Out;
	private Luggage[] Luggage;
	private int LuggageAdder;
	private int[] LuggageIDs;

	public Passenger(int iD, Line line, int in, int out, int Luggageadder) {
		ID = iD;
		Line = line;
		In = in;
		Out = out;
		LuggageIDs = new int[Luggageadder];
		LuggageAdder = Luggageadder;
		Luggage = new Luggage[Luggageadder];

		for (int i = 0; i < LuggageAdder; i++) {
			Luggage[i] = new Luggage(AnaClass.Luggager);
			AnaClass.Luggager++;
		}

	}

	public Passenger() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Line getLine() {
		return Line;
	}

	public void setLine(Line line) {
		Line = line;
	}

	public int getIn() {
		return In;
	}

	public void setIn(int in) {
		In = in;
	}

	public int getOut() {
		return Out;
	}

	public void setOut(int out) {
		Out = out;
	}

	public Luggage[] getOriginalLuggages() {
		return Luggage;
	}
	
	public String getLuggage() {
		for (int i = 0; i < LuggageAdder; i++) {
			LuggageIDs[i] = Luggage[i].getID();
		}
		return Arrays.toString(LuggageIDs);
	}

	public void setLuggage(Luggage[] luggage) {
		Luggage = luggage;
	}

	public void DisplayForBusStop() {
		System.out.print(ID + ":" + "   Line" + Line.getName() + " " +Line.getRotate()[In].getName() + "-" +Line.getRotate()[Out].getName() + "   ( L :");
		if (Luggage.length == 0) {
			System.out.println("-)");

		} else if (Luggage.length == 1) {
			Luggage[0].Display();
			System.out.println(")");
		} else if (Luggage.length == 2) {
			Luggage[0].Display();
			System.out.print(",");
			Luggage[1].Display();
			System.out.println(")");

		}
	}

	public void DisplayForBus() {
		System.out.print(ID + ":    " + Line.getRotate()[In].getName() + "-" + Line.getRotate()[Out].getName()  + "   (L:");
		if (Luggage.length == 0) {
			System.out.println("-)");

		} else if (Luggage.length == 1) {
			Luggage[0].Display();
			System.out.println(")");
		} else if (Luggage.length == 2) {
			Luggage[0].Display();
			System.out.print(",");
			Luggage[1].Display();
			System.out.println(")");

		}
	}

}
