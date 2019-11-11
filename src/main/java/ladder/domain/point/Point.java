package ladder.domain.point;

import ladder.domain.Direction;
import ladder.domain.policy.PointConnectPolicy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class Point {

	final Map<Direction, Point> nextPoints = new HashMap<>();

	public void connectWithPointHorizontally(PointConnectPolicy policy, Point point) {
		if (canConnectHorizontally(policy, point)) {
			connectWithPoint(Direction.HORIZONTAL, point);
			point.connectWithPoint(Direction.HORIZONTAL_REVERSE, this);
		}
	}

	private boolean canConnectHorizontally(PointConnectPolicy policy, Point point) {
		return policy.shouldConnect() && hasNotHorizontalConnection() && point.hasNotHorizontalConnection();
	}

	private boolean hasNotHorizontalConnection() {
		return !nextPoints.containsKey(Direction.HORIZONTAL) && !nextPoints.containsKey(Direction.HORIZONTAL_REVERSE);
	}

	public boolean hasConnection(Direction direction) {
		return nextPoints.containsKey(direction);
	}

	public void connectWithPointVertically(Point point) {
		connectWithPoint(Direction.VERTICAL, point);
	}

	protected abstract void connectWithPoint(Direction direction, Point point);

	public abstract Optional<String> getName();

}
