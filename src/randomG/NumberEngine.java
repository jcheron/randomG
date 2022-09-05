package randomG;

import java.util.Random;

public class NumberEngine {

	private int value;

	public NumberEngine(int min, int max) {
		Random r = new Random();
		value = r.nextInt(max - min) + min;
	}

	public int compareTo(int number) {
		if (value > number) {
			return 1;
		} else if (value > number) {
			return -1;
		}
		return 0;
	}
}
