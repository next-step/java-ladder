package ladder.domain;

public class Point {
	private static final int FIRST_POINT = 0;
	private static final int LINE_DISTANCE= 1;

	private final int index;

	public Point(int index) {
		this.index = index;
	}

	public boolean isFirst() {
		return index == FIRST_POINT;
	}

	public boolean isLast(int lastPoint) {
		return index == lastPoint;
	}

	public Point isMove(Direction direction) {
		if (direction.isLeft()) {
			return new Point(index - LINE_DISTANCE);
		}
		if (direction.isRight()) {
			return new Point(index + LINE_DISTANCE);
		}
		return this;
	}

	public int getIndex() {
		return index;
	}

}
