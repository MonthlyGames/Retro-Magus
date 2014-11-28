package turtle.game.rmagus.controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	private boolean[] keys = new boolean[120];
	
	public boolean up, down, left, right;
	
	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
		if (up) {
			System.out.println("KEYS>> Up");
		} else if (down) {
			System.out.println("KEYS>> Down");
		} else if (left) {
			System.out.println("KEYS>> Left");
		} else if (right) {
			System.out.println("KEYS>> Right");
		} else {
			System.out.println("KEYS>> None");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
