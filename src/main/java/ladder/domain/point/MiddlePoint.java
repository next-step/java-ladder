package ladder.domain.point;

import ladder.domain.Direction;

import java.util.Optional;

public class MiddlePoint extends Point {

	public void connectWithPoint(Direction direction, Point point) {
		nextPoints.put(direction, point);
	}

	@Override
	public Optional<String> getName() {
		throw new IllegalStateException("중간 점은 이름이 없습니다");
	}

}
