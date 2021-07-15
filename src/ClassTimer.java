
public class ClassTimer implements Runnable {

	public ClassTimer() {
	}

	@Override
	public void run() {
		while (5 > 0) {
			AnaClass.Time++;
			try {
				Thread.sleep(1000);
				Passenger Passenger2 = new Passenger();
				Passenger2 = (Passenger) AnaClass.Summoner.peek();
				Passenger2.getLine().getRotate()[Passenger2.getIn()].addPassenger((Passenger) AnaClass.Summoner.dequeue());				
				AnaClass.RandomPassenger();
				for (int i = 0; i < 15; i++) {
					Passenger Passenger3 = (Passenger) AnaClass.Summoner.peek();
					AnaClass.cn.getTextWindow().setCursorPosition(76 - i, 4);
					System.out.print(Passenger3.getLine().getRotate()[Passenger3.getIn()].getName());
					AnaClass.Summoner.enqueue(AnaClass.Summoner.dequeue());
				}
				AnaClass.cn.getTextWindow().setCursorPosition(68, 0);
				System.out.println(AnaClass.Time);	
				if(AnaClass.Time%2==0) {
				AnaClass.MoveAllBuses();	
				}
				AnaClass.ScreenUpdater();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
