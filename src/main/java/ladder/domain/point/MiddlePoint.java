package ladder.domain.point;

import ladder.domain.Direction;

import java.util.Optional;

public class MiddlePoint extends Point {

	public void connectWithPoint(Direction direction, Point point) {
		nextPoints.put(direction, point);
	}

	@Override
	public Optional<String> getName() {
		return Optional.empty();
	}

}
