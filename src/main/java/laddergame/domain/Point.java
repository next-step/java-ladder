package laddergame.domain;

public class Point {

	private Direction direction;

	private Point(Direction direction) {
		this.direction = direction;
	}

	public static Point nextOf(Point beforePoint) {
		// 이미 이전에 선이 존재하는 경우
		if(beforePoint.direction.equals(Direction.LEFT)) {
			return from(Direction.STRAIGHT);
		}
		Point point = from(RightEdgeDirectionStrategy.getInstance());
		beforePoint.setOppositeDirectionOf(point);
		return point;
	}

	public static Point from(Direction direction) {
		return new Point(direction);
	}

	public static Point from(RandomDirectionStrategy randomDirectionStrategy) {
		return new Point(Direction.from(randomDirectionStrategy));
	}

	private void setOppositeDirectionOf(Point point) {
		this.direction = point.direction.getOppositeDirection();
	}

	public int move(int index) {
		return direction.move(index);
	}

	public String getDisplayCharacter() {
		return (direction.equals(Direction.LEFT))? DisplayLine.HORIZON_CHARACTER : DisplayLine.EMPTY_CHARACTER;
	}
}
