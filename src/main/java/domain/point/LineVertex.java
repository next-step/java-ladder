package domain.point;

import domain.LadderLineSupplier;

/**
 * Created by hspark on 16/11/2018.
 */

public class LineVertex {
	private Point point;
	private Direction direction;

	public LineVertex(Point point, Direction direction) {
		this.point = point;
		this.direction = direction;
	}

	public Point move() {
		if (direction.isRight()) {
			return point.add(1);
		}
		if (direction.isLeft()) {
			return point.sub(1);
		}
		return point;
	}

	public static LineVertex first(LadderLineSupplier supplier) {
		return new LineVertex(Point.ZERO, Direction.first(supplier.get()));
	}

	public LineVertex next(LadderLineSupplier supplier) {
		if (direction.isRight()) {
			return new LineVertex(point.add(1), Direction.LEFT);
		}
		return new LineVertex(point.add(1), direction.next(supplier.get()));
	}

	public LineVertex last() {
		if (direction.isRight()) {
			return new LineVertex(point.add(1), Direction.LEFT);
		}
		return new LineVertex(point.add(1), Direction.NONE);
	}

	public Point getPoint() {
		return point;
	}

	public Direction getDirection() {
		return direction;
	}

	public boolean isRightDirection() {
		return getDirection().isRight();
	}

}
