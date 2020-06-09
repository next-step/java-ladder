package ladder;

import java.util.List;

public class LadderLinePoints {

	private final List<LadderLinePoint> points;

	private LadderLinePoints(List<LadderLinePoint> points) {
		this.points = points;
	}

	public static LadderLinePoints of(List<LadderLinePoint> points) {
		validate(points);
		return new LadderLinePoints(points);
	}

	private static void validate(List<LadderLinePoint> points) {
		validateNotLastIsConnected(points);
		validateNotContinuouslyConnected(points);
	}

	private static void validateNotLastIsConnected(List<LadderLinePoint> points) {
		if (points.get(points.size() - 1).isConnectedToNextPoint()) {
			throw new IllegalArgumentException("마지막 좌표는 다음 좌표와 연결될 수 없습니다.");
		}
	}

	private static void validateNotContinuouslyConnected(List<LadderLinePoint> points) {
		long maxConnectionCount = points.size() / 2;
		long connectionCount = points.stream()
				.filter(LadderLinePoint::isConnectedToNextPoint)
				.count();

		if (connectionCount > maxConnectionCount) {
			throw new IllegalArgumentException("좌표는 연속으로 연결될 수 없습니다.");
		}
	}

	public int size() {
		return points.size();
	}
}
