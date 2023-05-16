package ladder.type;

import java.util.Arrays;

public enum PointType {
	FALSE_FALSE(false, false),
	FALSE_TRUE(false, true),
	TRUE_FALSE(true, false);

	private final boolean left;
	private final boolean current;

	PointType(boolean left, boolean current) {
		this.left = left;
		this.current = current;
	}

	public static PointType of(boolean left, boolean current) {
		return Arrays.stream(values())
			.filter(e -> e.left == left && e.current == current)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 좌표타입 입니다."));
	}
}
