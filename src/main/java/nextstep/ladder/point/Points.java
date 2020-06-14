package nextstep.ladder.point;

import java.util.List;

public class Points {

	private final List<Point> points;

	private Points(List<Point> pointsList) {
		this.points = pointsList;
	}

	public static Points ofPoints(List<Point> pointsList) {
		validateLastPointNotConnected(pointsList);
		return new Points(pointsList);
	}

	private static void validateLastPointNotConnected(List<Point> pointList) {
		Point lastPoint = pointList.stream()
			.reduce((first, second) -> second)
			.orElseThrow(() -> new IllegalArgumentException("why last point is null?"));
		lastPoint.validateNotConnectedIfLastPoint();
	}

	public List<Point> getPoints() {
		return points;
	}
}
