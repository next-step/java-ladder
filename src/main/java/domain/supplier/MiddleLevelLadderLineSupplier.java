package domain.supplier;

/**
 * Created by hspark on 16/11/2018.
 */

public class MiddleLevelLadderLineSupplier implements LevelLadderLineSupplier {
	private static final int MIDDLE_LEVEL_VALUE = 70;

	@Override
	public int getStandardValue() {
		return MIDDLE_LEVEL_VALUE;
	}
}
