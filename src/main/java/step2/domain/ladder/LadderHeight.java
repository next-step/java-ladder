package step2.domain.ladder;

import step2.exception.LadderGameException;

import java.util.Objects;
import java.util.stream.IntStream;

public class LadderHeight {

	private static final int RANGE_START_INDEX = 0;
	private static final int MIN_HEIGHT = 1;
	private static final String PLEASE_INPUT_OVER_OR_EQUAL_MIN_HEIGHT = "사다리의 높이는 %d 이상으로 입력해 주세요.";

	private final int height;

	public LadderHeight(int height) {
		if(height < MIN_HEIGHT) {
			throw new LadderGameException(String.format(PLEASE_INPUT_OVER_OR_EQUAL_MIN_HEIGHT, MIN_HEIGHT));
		}
		this.height = height;
	}

	public IntStream getLadderRange() {
		return IntStream.range(RANGE_START_INDEX, height);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LadderHeight that = (LadderHeight) o;
		return height == that.height;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height);
	}
}
