package ladder.type;

import static ladder.type.PointType.FALSE_FALSE;
import static ladder.type.PointType.FALSE_TRUE;
import static ladder.type.PointType.TRUE_FALSE;

import java.util.Arrays;

import ladder.domain.Point;

public enum PointTypeTransition {
	FALSE_FALSE_POINT(FALSE_FALSE, new Point(false, false)),
	FALSE_TRUE_POINT(FALSE_TRUE, new Point(false, true)),
	TRUE_FALSE_POINT(TRUE_FALSE, new Point(true, false));

	private final PointType from;
	private final Point to;

	PointTypeTransition(PointType from, Point to) {
		this.from = from;
		this.to = to;
	}

	public static Point toPoint(PointType from) {
		return Arrays.stream(values())
			.filter(e -> e.from.equals(from))
			.findAny()
			.map(transition -> transition.to)
			.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 좌표입니다."));
	}
}
