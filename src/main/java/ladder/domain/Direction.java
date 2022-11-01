package ladder.domain;

import java.util.stream.Stream;

/**
 * Created by seungwoo.song on 2022-11-01
 */
public enum Direction {

	LEFT(true, false),
	RIGHT(false, true),
	NONE(false, false);

	private final boolean before;
	private final boolean current;

	Direction(boolean before, boolean current) {
		this.before = before;
		this.current = current;
	}

	public static Direction of(boolean before, boolean current) {
		if (before && current) {
			throw new IllegalArgumentException("left right 모두 true 일 수 없습니다");
		}

		return Stream.of(values())
			.filter(e -> e.before == before && e.current == current)
			.findAny()
			.get();
	}

	public Direction next(boolean next) {
		return Direction.of(current, next);
	}
}
