package nextstep.ladder.domain.height;

import java.util.Objects;

public class Height {

	private final static int MINIMUM_HEIGHT_THRESHOLD = 1;
	private final static int MAXIMUM_HEIGHT_THRESHOLD = 5;
	private final int heightValue;

	//constructor logic
	private Height(final int heightValue) {
		this.heightValue = heightValue;
	}

	public static Height ofHeight(final String heightValueString) {
		validateValueStringIsNotEmpty(heightValueString);
		int heightValue = convertValueStringToInt(heightValueString);
		validateHeightValueInRange(heightValue);
		return new Height(heightValue);
	}

	//validation logic
	private static void validateHeightValueInRange(final int heightValue) {
		if (heightValue < MINIMUM_HEIGHT_THRESHOLD || heightValue > MAXIMUM_HEIGHT_THRESHOLD) {
			throw new IllegalArgumentException("The minimum threshold of height is 1. check your input again.");
		}
	}

	private static void validateValueStringIsNotEmpty(final String heightValueString) {
		if (Objects.isNull(heightValueString) || heightValueString.trim().isEmpty()) {
			throw new IllegalArgumentException("The height input is null or undefined. What was wrong with you?");
		}
	}

	//converter logic
	private static int convertValueStringToInt(String heightValueString) {
		return Integer.parseInt(heightValueString);
	}

	//getter
	public int getHeightValue() {
		return heightValue;
	}
}
