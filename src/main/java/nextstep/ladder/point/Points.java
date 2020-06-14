package nextstep.ladder.point;

import java.util.List;

public class Points {

	private final List<Point> points;

	private Points(List<Point> pointsList) {
		this.points = pointsList;
	}

	public static Points ofPoints(List<Point> pointsList) {
		return new Points(pointsList);
	}

	public List<Point> getPoints() {
		return points;
	}
}
