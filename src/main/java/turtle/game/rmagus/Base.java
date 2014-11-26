package turtle.game.rmagus;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import turtle.game.rmagus.graphics.Screen;

public class Base extends Canvas implements Runnable {

	public static int HEIGHT = 720;
	public static int WIDTH = HEIGHT / 9 * 16;
	public static int SCALE = 3;
	public int actHeight = getHeight() / 3;
	public int actWidth = getWidth() / 3;

	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private JFrame frame;
	private Screen screen;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

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

		screen = new Screen(WIDTH, HEIGHT);

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
			tick();
			render();
		}
	}

	public void render() {
		// TODO Auto-generated method stub

	}

	public void tick() {
		// TODO Auto-generated method stub
		BufferStrategy bs = getBufferStrategy(); // 5 14:10
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.render();
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}
}