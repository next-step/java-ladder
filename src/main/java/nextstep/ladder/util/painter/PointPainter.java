package nextstep.ladder.util.painter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.direction.Direction;
import nextstep.ladder.domain.point.Point;
import nextstep.ladder.domain.point.Points;

public class PointPainter {

	private final PaintingStrategy paintingStrategy;

	public PointPainter(PaintingStrategy paintingStrategy) {
		this.paintingStrategy = paintingStrategy;
	}

	public Points drawPoints(int count) {
		List<Point> points = new ArrayList<>();
		drawFirstPoint(points);
		drawBodyPoints(count, points);
		drawLastPoint(points);
		return Points.ofPoints(points);
	}

	private void drawFirstPoint(List<Point> points) {
		Point point = Point.ofPoint(Direction.first(paintingStrategy.isRight()));
		points.add(point);
	}

	private void drawBodyPoints(int count, List<Point> points) {
		IntStream.range(1, count - 1)
			.mapToObj(now -> points.get(now - 1))
			.forEach(point -> points.add(point.next(paintingStrategy.isRight())));
	}

	private void drawLastPoint(List<Point> points) {
		Point point = points.get(points.size() - 1);
		Direction lastTheBeforeDirection = point.getDirection();
		points.add(point.last(lastTheBeforeDirection));
	}
}
