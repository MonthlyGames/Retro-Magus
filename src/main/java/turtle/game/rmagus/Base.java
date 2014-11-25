package turtle.game.rmagus;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Base extends Canvas implements Runnable {

	public static int HEIGHT = 480;
	public static int WIDTH = HEIGHT / 9 * 16;
	public static int SCALE = 3;
	
	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private JFrame frame;

	public static void main(String[] args) {
		Base game = new Base();
		game.frame.setResizable(true);
		game.frame.setTitle("Retro Magus | Alpha | v. 1.0");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();

	}

	
	public Base() {
		Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(size);

		frame = new JFrame();
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Game");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (running) {
		}
	}
}