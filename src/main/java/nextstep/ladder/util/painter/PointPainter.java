package nextstep.ladder.util.painter;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
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
		AtomicBoolean isConnectedToPreceding = new AtomicBoolean(false);

		return IntStream.range(0, count)
			.mapToObj(index -> drawPoint(index == count - 1, isConnectedToPreceding.get()))
			.peek(point -> isConnectedToPreceding.set(point.isConnectedToNextPoint()))
			.collect(collectingAndThen(toList(), Points::ofPoints));
	}

	public Points drawPoints2(int count) {
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
		IntStream.range(1, count)
			.mapToObj(now -> points.get(now - 1))
			.forEach(point -> points.add(point.next(paintingStrategy.isRight())));
	}

	private void drawLastPoint(List<Point> points) {
		Point point = points.get(points.size() - 1);
		boolean isConnectedToBeforePoint = point.isConnectedToNextPoint();
		points.add(point.last(isConnectedToBeforePoint));
	}

	public Point drawPoint(boolean isLastPoint, boolean isConnectedToPreceding) {
		if (isLastPoint || isConnectedToPreceding) {
			return Point.ofPoint(false);
		}
		return paintingStrategy.drawPoint();
	}
}
