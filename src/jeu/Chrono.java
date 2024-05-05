package jeu;

public class Chrono implements Runnable{

    @Override
	public void run() {

		while(true){ 			
			Main.level1Scene.repaint();
			try {
                int PAUSE = 3;
                Thread.sleep(PAUSE);}
			catch (InterruptedException _) {}
		}
	}
}