package domain.supplier;

/**
 * Created by hspark on 16/11/2018.
 */

public class LowLevelLadderLineSupplier implements LevelLadderLineSupplier {
	private static final int LOW_LEVEL_VALUE = 50;

	@Override
	public int getStandardValue() {
		return LOW_LEVEL_VALUE;
	}
}
