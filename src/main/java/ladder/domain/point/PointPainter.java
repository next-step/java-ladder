package ladder.domain.point;

import ladder.domain.direction.DirectionSelectStrategy;

import java.util.ArrayList;
import java.util.List;

public class PointPainter {

	private DirectionSelectStrategy directionSelectStrategy;

	public PointPainter(DirectionSelectStrategy directionSelectStrategy) {
		this.directionSelectStrategy = directionSelectStrategy;
	}

	public Points drawPoints(int count) {
		List<Point> points = new ArrayList<>();

		drawFirstPoint(points);
		drawBodyPoints(count, points);
		drawLastPoint(points);

		return Points.of(points);
	}

	private void drawFirstPoint(List<Point> points) {
		Point point = Point.first(directionSelectStrategy.isRight());
		points.add(point);
	}

	private void drawBodyPoints(int count, List<Point> points) {
		for (int i = 1; i < count - 1; i++) {
			Point point = points.get(i - 1);
			points.add(point.next(directionSelectStrategy.isRight()));
		}
	}

	private void drawLastPoint(List<Point> points) {
		Point point = points.get(points.size() - 1);
		points.add(point.last());
	}
}
