import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game {
	public enigma.console.Console cn = Enigma.getConsole("Big City");
	public TextMouseListener tmlis;
	public KeyListener klis;

	// ------ Standard variables for mouse and keyboard ------
	public int mousepr; // mouse pressed?
	public int mousex, mousey; // mouse text coords.
	public int keypr; // key pressed?
	public int rkey; // key (for press/release)
	public boolean isSuspended = false;
	// ----------------------------------------------------

	Game() throws Exception { // --- Contructor

		// ------ Standard code for mouse and keyboard ------ Do not change
		tmlis = new TextMouseListener() {
			public void mouseClicked(TextMouseEvent arg0) {
			}

			public void mousePressed(TextMouseEvent arg0) {
				if (mousepr == 0) {
					mousepr = 1;
					mousex = arg0.getX();
					mousey = arg0.getY();
				}
			}

			public void mouseReleased(TextMouseEvent arg0) {
			}
		};
		cn.getTextWindow().addTextMouseListener(tmlis);

		klis = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (keypr == 0) {
					keypr = 1;
					rkey = e.getKeyCode();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		cn.getTextWindow().addKeyListener(klis);
		// ----------------------------------------------------
		
		while (true) {
			int px = mousex, py = mousey;
			if (mousepr == 1) { // if mouse button pressed
				for (int i = 0; i < 20; i++) {
					AnaClass.cn.getTextWindow().setCursorPosition(60, 11 + i);
					System.out.println("                                  ");
				}
				//Duraklar
				if (px == 2 && py == 2)
					AnaClass.BusStops[0].Display();
				else if (px == 14 && py == 2)
					AnaClass.BusStops[1].Display();
				else if (px == 32 && py == 2)
					AnaClass.BusStops[2].Display();
				else if (px == 50 && py == 2)
					AnaClass.BusStops[3].Display();
				else if (px == 2 && py == 8)
					AnaClass.BusStops[4].Display();
				else if (px == 14 && py == 8)
					AnaClass.BusStops[5].Display();
				else if (px == 32 && py == 8)
					AnaClass.BusStops[6].Display();
				else if (px == 50 && py == 8)
					AnaClass.BusStops[7].Display();
				else if (px == 2 && py == 14)
					AnaClass.BusStops[8].Display();
				else if (px == 14 && py == 14)
					AnaClass.BusStops[9].Display();
				else if (px == 32 && py == 14)
					AnaClass.BusStops[10].Display();
				else if (px == 44 && py == 14)
					AnaClass.BusStops[11].Display();
				else if (px == 8 && py == 20)
					AnaClass.BusStops[12].Display();
				else if (px == 14 && py == 20)
					AnaClass.BusStops[13].Display();
				else if (px == 32 && py == 20)
					AnaClass.BusStops[14].Display();
				else if (px == 44 && py == 20)
					AnaClass.BusStops[15].Display();
				else if (px < 58 && py < 21) {//Otobüsler
					if (AnaClass.Ekran[py][px] == "A1") {
					if((AnaClass.Buses[0].getID()=="A1") && (AnaClass.Buses[0].getX()==px &&AnaClass.Buses[0].getY()==py) )
						AnaClass.Buses[0].Display();
					else if((AnaClass.Buses[6].getID()=="A1")&& (AnaClass.Buses[6].getX()==px &&AnaClass.Buses[6].getY()==py))
						AnaClass.Buses[6].Display();
						}
					else if (AnaClass.Ekran[py][px] == "B1"){
						if((AnaClass.Buses[1].getID()=="B1") && (AnaClass.Buses[1].getX()==px &&AnaClass.Buses[1].getY()==py) )
							AnaClass.Buses[1].Display();
						else if((AnaClass.Buses[7].getID()=="B1")&& (AnaClass.Buses[7].getX()==px &&AnaClass.Buses[7].getY()==py))
							AnaClass.Buses[7].Display();
							}
					else if (AnaClass.Ekran[py][px] == "C1"){
						if((AnaClass.Buses[2].getID()=="C1") && (AnaClass.Buses[2].getX()==px &&AnaClass.Buses[2].getY()==py) )
							AnaClass.Buses[2].Display();
						else if((AnaClass.Buses[8].getID()=="C1")&& (AnaClass.Buses[8].getX()==px &&AnaClass.Buses[8].getY()==py))
							AnaClass.Buses[8].Display();
							}
					else if (AnaClass.Ekran[py][px] == "D1"){
						if((AnaClass.Buses[3].getID()=="D1") && (AnaClass.Buses[3].getX()==px &&AnaClass.Buses[3].getY()==py) )
							AnaClass.Buses[3].Display();
						else if((AnaClass.Buses[9].getID()=="D1")&& (AnaClass.Buses[9].getX()==px &&AnaClass.Buses[9].getY()==py))
							AnaClass.Buses[9].Display();
							}
					else if (AnaClass.Ekran[py][px] == "L1"){
						if((AnaClass.Buses[4].getID()=="L1") && (AnaClass.Buses[4].getX()==px &&AnaClass.Buses[4].getY()==py) )
							AnaClass.Buses[4].Display();
						else if((AnaClass.Buses[10].getID()=="L1")&& (AnaClass.Buses[10].getX()==px &&AnaClass.Buses[10].getY()==py))
							AnaClass.Buses[10].Display();
							}
					else if (AnaClass.Ekran[py][px] == "M1"){
						if((AnaClass.Buses[5].getID()=="M1") && (AnaClass.Buses[5].getX()==px &&AnaClass.Buses[5].getY()==py) )
							AnaClass.Buses[5].Display();
						else if((AnaClass.Buses[11].getID()=="M1")&& (AnaClass.Buses[11].getX()==px &&AnaClass.Buses[11].getY()==py))
							AnaClass.Buses[11].Display();
							}
					else if (AnaClass.Ekran[py][px] == "A2") {
						if((AnaClass.Buses[0].getID()=="A2")&& (AnaClass.Buses[0].getX()==px &&AnaClass.Buses[0].getY()==py))
							AnaClass.Buses[0].Display();
						else if((AnaClass.Buses[6].getID()=="A2")&& (AnaClass.Buses[6].getX()==px &&AnaClass.Buses[6].getY()==py))
							AnaClass.Buses[6].Display();
						}
					else if (AnaClass.Ekran[py][px] == "B2"){
						if((AnaClass.Buses[1].getID()=="B2") && (AnaClass.Buses[1].getX()==px &&AnaClass.Buses[1].getY()==py) )
							AnaClass.Buses[1].Display();
						else if((AnaClass.Buses[7].getID()=="B2")&& (AnaClass.Buses[7].getX()==px &&AnaClass.Buses[7].getY()==py))
							AnaClass.Buses[7].Display();
							}
					else if (AnaClass.Ekran[py][px] == "C2"){
						if((AnaClass.Buses[2].getID()=="C2") && (AnaClass.Buses[2].getX()==px &&AnaClass.Buses[2].getY()==py) )
							AnaClass.Buses[2].Display();
						else if((AnaClass.Buses[8].getID()=="C2")&& (AnaClass.Buses[8].getX()==px &&AnaClass.Buses[8].getY()==py))
							AnaClass.Buses[8].Display();
							}
					else if (AnaClass.Ekran[py][px] == "D2"){
						if((AnaClass.Buses[3].getID()=="D2") && (AnaClass.Buses[3].getX()==px &&AnaClass.Buses[3].getY()==py) )
							AnaClass.Buses[3].Display();
						else if((AnaClass.Buses[9].getID()=="D2")&& (AnaClass.Buses[9].getX()==px &&AnaClass.Buses[9].getY()==py))
							AnaClass.Buses[9].Display();
							}
					else if (AnaClass.Ekran[py][px] == "L2"){
						if((AnaClass.Buses[4].getID()=="L2") && (AnaClass.Buses[4].getX()==px &&AnaClass.Buses[4].getY()==py) )
							AnaClass.Buses[4].Display();
						else if((AnaClass.Buses[10].getID()=="L2")&& (AnaClass.Buses[10].getX()==px &&AnaClass.Buses[10].getY()==py))
							AnaClass.Buses[10].Display();
							}
					else if (AnaClass.Ekran[py][px] == "M2"){
						if((AnaClass.Buses[5].getID()=="M2") && (AnaClass.Buses[5].getX()==px &&AnaClass.Buses[5].getY()==py) )
							AnaClass.Buses[5].Display();
						else if((AnaClass.Buses[11].getID()=="M2")&& (AnaClass.Buses[11].getX()==px &&AnaClass.Buses[11].getY()==py))
							AnaClass.Buses[11].Display();
							}
				}

				px = mousex;
				py = mousey;
				mousepr = 0; // last action
			}
			if (keypr == 1) { // if keyboard button pressed

				char rckey = (char) rkey;

				if (rckey == 'R') {
					AnaClass.cn.getTextWindow().setCursorPosition(72, 0);
					System.out.println("        ");
					AnaClass.Timer.resume();		
					isSuspended = false;
				}

				if (rkey == KeyEvent.VK_SPACE) {
					if (isSuspended) {
						AnaClass.Timer.resume();
						Thread.sleep(1000);
						AnaClass.Timer.suspend();
						

					} else {
						AnaClass.Timer.suspend();
						AnaClass.cn.getTextWindow().setCursorPosition(72, 0);
						System.out.println("(paused)");
						isSuspended = true;
					}

				}

				keypr = 0; // last action
			}
			Thread.sleep(20);
		}
	}

}
