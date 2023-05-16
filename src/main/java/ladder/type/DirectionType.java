package ladder.type;

import java.util.Arrays;

import ladder.domain.Point;

public enum DirectionType {
	RIGHT(Point.first(false).next(true)), LEFT(Point.first(true).next(false)), DOWN(Point.first(false).next(false));

	private final Point point;

	DirectionType(Point point) {
		this.point = point;
	}

	public static DirectionType of(Point point) {
		return Arrays.stream(values())
			.filter(e -> e.point.equals(point))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 방향타입 입니다."));
	}
}
