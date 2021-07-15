
public class Luggage {
	private int ID;

	public Luggage(int iD) {
		ID = iD;
	}
	
	public Luggage() {
		ID=0;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void Display() {
		System.out.print(ID);
	}

}
