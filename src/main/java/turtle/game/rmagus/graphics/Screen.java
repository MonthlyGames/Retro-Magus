package turtle.game.rmagus.graphics;

import java.util.Random;

public class Screen {
	private int width, height;
	
	public final int MAP_SIZE = 64, MAP_SIZE_MASK = MAP_SIZE - 1;

	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	private Random random = new Random();

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < 64 * 64; i++) {
			tiles[i] = random.nextInt(0xCBBBBC);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yPix = y + yOffset;
			if (yPix < 0 || yPix >= height) continue;
			for (int x = 0; x < width; x++) {
				int xPix = x + xOffset;
				if (xPix < 0 || xPix >= height) continue;
				pixels[x + y * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
			}
		}
	}
}
