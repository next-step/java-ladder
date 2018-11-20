package domain.point;

import domain.supplier.LadderLineSupplier;

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
			return point.add();
		}
		if (direction.isLeft()) {
			return point.sub();
		}
		return point;
	}

	public static LineVertex first(LadderLineSupplier supplier) {
		return new LineVertex(Point.ZERO, Direction.first(supplier.get()));
	}

	public LineVertex next(LadderLineSupplier supplier) {
		if (direction.isRight()) {
			return new LineVertex(point.add(), Direction.LEFT);
		}
		return new LineVertex(point.add(), direction.next(supplier.get()));
	}

	public LineVertex last() {
		if (direction.isRight()) {
			return new LineVertex(point.add(), Direction.LEFT);
		}
		return new LineVertex(point.add(), Direction.NONE);
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
