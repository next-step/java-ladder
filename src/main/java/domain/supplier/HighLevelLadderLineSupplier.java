package domain.supplier;

/**
 * Created by hspark on 16/11/2018.
 */

public class HighLevelLadderLineSupplier implements LevelLadderLineSupplier {
	private static final int HIGH_LEVEL_VALUE = 90;

	@Override
	public int getStandardValue() {
		return HIGH_LEVEL_VALUE;
	}
}
