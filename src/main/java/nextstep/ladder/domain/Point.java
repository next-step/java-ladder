package nextstep.ladder.domain;

import java.util.Random;

public enum Point {
	LEFT(-1),
	HOLD(0),
	RIGHT(1),
	;

	private static final Random random = new Random();

	private final int distance;

	Point(int index) {
		this.distance = index;
	}

	public int value() {
		return distance;
	}

	public boolean isLeft() {
		return this == Point.LEFT;
	}

	public boolean isRight() {
		return this == Point.RIGHT;
	}

	public int move(int currentIndex) {
		return currentIndex + distance;
	}

	public static Point random() {
		// 오른쪽, 아래만 랜덤 생성한다. 왼쪽은 오른쪽에 대응해 수동적으로 생성되기 때문.
		Point[] points = {Point.RIGHT, Point.HOLD};
		return points[random.nextInt(points.length)];
	}
}
