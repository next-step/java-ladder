package ladder.domain.point;

import ladder.domain.Direction;
import ladder.domain.policy.PointConnectPolicy;

import java.util.HashMap;
import java.util.Map;

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
		return !hasForwardHorizontalPoint() && !hasReverseHorizontalPoint();
	}

	public boolean hasConnection(Direction direction) {
		return nextPoints.containsKey(direction);
	}

	public void connectWithPointVertically(Point point) {
		connectWithPoint(Direction.VERTICAL, point);
	}

	protected abstract void connectWithPoint(Direction direction, Point point);

	public abstract String getName();

	public String getResultFrom(Direction direction) {
		// 수평으로 왔으면 무조건 수직으로 내려간다
		if (direction.isHorizontal()) {
			return getResultFromNextVerticalPoint();
		}

		// 수직으로 왔는데 수평한 연결점이 있으면 수평으로 간다
		if (hasHorizontalConnection()) {
			return getResultFromNextHorizontalPoint();
		}

		// 수직으로 왔지만 수평한 연결점이 없으므로 수직으로 간다
		return getResultFromNextVerticalPoint();
	}

	private String getResultFromNextVerticalPoint() {
		return getNextVerticalPoint().getResultFrom(Direction.VERTICAL);
	}

	private boolean hasHorizontalConnection() {
		return hasForwardHorizontalPoint() || hasReverseHorizontalPoint();
	}

	private String getResultFromNextHorizontalPoint() {
		return getNextHorizontalPoint().getResultFrom(Direction.HORIZONTAL);
	}

	private Point getNextVerticalPoint() {
		return nextPoints.get(Direction.VERTICAL);
	}

	private Point getNextHorizontalPoint() {
		if (hasForwardHorizontalPoint()) {
			return nextPoints.get(Direction.HORIZONTAL);
		}
		return nextPoints.get(Direction.HORIZONTAL_REVERSE);
	}

	private boolean hasForwardHorizontalPoint() {
		return nextPoints.containsKey(Direction.HORIZONTAL);
	}

	private boolean hasReverseHorizontalPoint() {
		return nextPoints.containsKey(Direction.HORIZONTAL_REVERSE);
	}

}
