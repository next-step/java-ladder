package ladder.domain.point;

import ladder.domain.Direction;

public class FirstPoint extends Point {

	private final String name;

	public FirstPoint(String name) {
		this.name = name;
	}

	@Override
	protected void connectWithPoint(Direction direction, Point point) {
		if (direction.equals(Direction.HORIZONTAL)) {
			throw new IllegalStateException("첫 번재 점들은 가로로 연결될 수 없습니다");
		}
		nextPoints.put(Direction.VERTICAL, point);
	}

	@Override
	public String getName() {
		return name;
	}

}
