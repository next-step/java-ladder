package nextstep.ladder.point;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Points {

	private final List<Point> points;

	private Points(List<Point> pointsList) {
		this.points = pointsList;
	}

	public static Points ofPoints(List<Point> pointsList) {
		validateLastPointNotConnected(pointsList);
		validateNotConnectedContinuously(pointsList);
		return new Points(pointsList);
	}

	private static void validateLastPointNotConnected(List<Point> pointList) {
		Point lastPoint = pointList.stream()
			.reduce((first, second) -> second)
			.orElseThrow(() -> new IllegalArgumentException("why last point is null?"));
		lastPoint.validateNotConnectedIfLastPoint();
	}

	private static void validateNotConnectedContinuously(List<Point> pointList) {
		AtomicBoolean beforePoint = new AtomicBoolean(false);

		long check = pointList.stream()
			.filter(point -> point.isConnectedToNextPoint() == beforePoint.get())
			.peek(point -> beforePoint.set(point.isConnectedToNextPoint()))
			.count();

		if (check > 0) {
			throw new IllegalArgumentException("illegal input that tries to connect points continuously.");
		}
	}

	public List<Point> getPoints() {
		return points;
	}
}
