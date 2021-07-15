
public class Line {
	private String Name;
	private BusStop[] Rotate;
	private Bus[] Buses;
	private int Rotater;
	private int RotateAdder;

	public Line(String name, int Rotateadder) {
		Name = name;
		RotateAdder = Rotateadder;
		Rotate = new BusStop[RotateAdder];
		Buses = new Bus[2];
		Rotater = 0;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public BusStop[] getRotate() {
		return Rotate;
	}

	public void setRotate(BusStop[] rotate) {
		Rotate = rotate;
	}

	public Bus[] getBuses() {
		return Buses;
	}

	public void setBuses(Bus[] buses) {
		Buses = buses;
	}

	public void SetLine6(BusStop a, BusStop b, BusStop c, BusStop d, BusStop e, BusStop f) {
		Rotate[0] = a;
		Rotate[1] = b;
		Rotate[2] = c;
		Rotate[3] = d;
		Rotate[4] = e;
		Rotate[5] = f;

	}

	public void SetLine7(BusStop a, BusStop b, BusStop c, BusStop d, BusStop e, BusStop f, BusStop g) {
		Rotate[0] = a;
		Rotate[1] = b;
		Rotate[2] = c;
		Rotate[3] = d;
		Rotate[4] = e;
		Rotate[5] = f;
		Rotate[6] = g;

	}

	public void SetLine8(BusStop a, BusStop b, BusStop c, BusStop d, BusStop e, BusStop f, BusStop g, BusStop h) {
		Rotate[0] = a;
		Rotate[1] = b;
		Rotate[2] = c;
		Rotate[3] = d;
		Rotate[4] = e;
		Rotate[5] = f;
		Rotate[6] = g;
		Rotate[7] = h;

	}

	public int getFirstStationX() {
		return Rotate[0].getX();
	}

	public int getFirstStationY() {
		return Rotate[0].getY();
	}

	public void addBus1(Bus b) {
		Buses[0] = b;
	}

	public void addBus2(Bus b) {
		Buses[1] = b;
	}

	public void addBusStop(BusStop bs) {
		Rotate[Rotater] = bs;
		Rotater++;
	}

}
