package ladder.domain.ladder;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LadderArgument {
	private static final int LADDER_MIN_HEIGHT = 0;

	private final Names names;
	private final int height;

	public static LadderArgument of(Names names, int height) {
		validateHeight(height);

		return new LadderArgument(names, height);
	}

	private static void validateHeight(int height) {
		if (height <= LADDER_MIN_HEIGHT) {
			throw new IllegalArgumentException(String.format("사다리의 높이는 %d 보다 큰 숫자로 입력해주세요.", LADDER_MIN_HEIGHT));
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return names.getSize();
	}

}
