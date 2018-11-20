package domain.supplier;

import java.util.Random;

/**
 * Created by hspark on 16/11/2018.
 */

public class RandomLadderLineSupplier implements LadderLineSupplier {
	private Random random = new Random();

	@Override
	public Boolean get() {
		return random.nextBoolean();
	}
}
