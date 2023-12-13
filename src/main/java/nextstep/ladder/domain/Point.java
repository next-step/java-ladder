package nextstep.ladder.domain;

import java.util.Random;

public enum Point {
	LEFT(true, false),
	RIGHT(false, true),
	DOWN(false, false)
	;

	private static final Random random = new Random();

	private final boolean left;
	private final boolean right;

	Point(boolean left, boolean right) {
		this.left = left;
		this.right = right;
	}
	public boolean isLeft() {
		return this == Point.LEFT;
	}

	public boolean isRight() {
		return this == Point.RIGHT;
	}

	public static Point random() {
		// 오른쪽, 아래만 랜덤 생성한다. 왼쪽은 오른쪽에 대응해 수동적으로 생성되기 때문.
		Point[] points = {Point.RIGHT, Point.DOWN};
		return points[random.nextInt(points.length)];
	}
}
