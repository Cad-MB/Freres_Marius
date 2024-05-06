package mechanics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Keys implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if (Main.level1Scene.player.isAlive()) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (Main.level1Scene.getxPos() == -1) {
					Main.level1Scene.setxPos(0);
					Main.level1Scene.setxBR1(-50);
					Main.level1Scene.setxBR2(750);
				}
				Main.level1Scene.player.setWalk(true);
				Main.level1Scene.player.setToRight(true);
				Main.level1Scene.setDx(1);
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (Main.level1Scene.getxPos() == 4431) {
					Main.level1Scene.setxPos(4430);
					Main.level1Scene.setxBR1(-50);
					Main.level1Scene.setxBR2(750);
				}
				Main.level1Scene.player.setWalk(true);
				Main.level1Scene.player.setToRight(false);
				Main.level1Scene.setDx(-1);
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {Main.level1Scene.player.setJump(true);}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.level1Scene.player.setWalk(false);
		Main.level1Scene.setDx(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}