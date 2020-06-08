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
		if (isContinuouslyConnected(points)) {
			throw new IllegalArgumentException("좌표는 연속으로 연결될 수 없습니다.");
		}
	}

	private static boolean isContinuouslyConnected(List<LadderLinePoint> points) {
		long maxConnectionCount = points.size() / 2;
		long connectionCount = points.stream()
				.filter(LadderLinePoint::isConnectedToNextPoint)
				.count();

		return connectionCount > maxConnectionCount;
	}

	public int size() {
		return points.size();
	}
}
