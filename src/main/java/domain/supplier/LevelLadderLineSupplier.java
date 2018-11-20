package domain.supplier;

import java.util.Random;

/**
 * Created by hspark on 20/11/2018.
 */

public interface LevelLadderLineSupplier extends LadderLineSupplier {
	Random random = new Random();
	int MAX_VALUE = 100;

	int getStandardValue();

	@Override
	default Boolean get() {
		boolean isDrawn = random.nextInt(MAX_VALUE) < getStandardValue();
		if (isDrawn) {
			return true;
		}
		return false;
	}
}
