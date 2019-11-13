package ladder.domain.point;

import ladder.domain.Direction;

public class MiddlePoint extends Point {

	public void connectWithPoint(Direction direction, Point point) {
		nextPoints.put(direction, point);
	}

	@Override
	public String getName() {
		throw new IllegalStateException("중간 점은 이름을 가질 수 없습니다");
	}

}
