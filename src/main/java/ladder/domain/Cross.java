package ladder.domain;

public class Cross {
	private final int position;
	private final Point point;

	public Cross(int position, Point point) {
		this.position = position;
		this.point = point;
	}

	public boolean current() {
		return point.current();
	}

	public int move() {
		if (point.move() == Direction.RIGHT) {
			return position + 1;
		}
		if (point.move() == Direction.LEFT) {
			return position - 1;
		}
		return position;
	}
}
