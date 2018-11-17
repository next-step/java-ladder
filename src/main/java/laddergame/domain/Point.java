package laddergame.domain;

public class Point {

	private static final String HORIZON_CHARACTER = "-";
	private static final String EMPTY_CHARACTER = " ";

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

	public String getLineCharacters() {
		StringBuilder lineCharacters = new StringBuilder();
		String lineCharacter = (direction.equals(Direction.LEFT))? HORIZON_CHARACTER : EMPTY_CHARACTER;
		for (int count = 0; count < Player.MAX_NAME_LENGTH; count++) {
			lineCharacters.append(lineCharacter);
		}
		return lineCharacters.toString();
	}

	public int move(int index) {
		return direction.move(index);
	}
}
