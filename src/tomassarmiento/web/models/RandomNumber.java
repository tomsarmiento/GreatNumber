package tomassarmiento.web.models;

import java.util.Random;

public class RandomNumber {
	public int randomNumber(int min, int max) {
		Random random = new Random();
		int randomnumber = (random.nextInt(max-min))+min;
		return randomnumber;
	}
}
