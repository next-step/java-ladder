package nextstep.ladder.util.painter;

import static java.util.stream.Collectors.*;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

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

	public Point drawPoint(boolean isLastPoint, boolean isConnectedToPreceding) {
		if (isLastPoint || isConnectedToPreceding) {
			return Point.ofPoint(false);
		}
		return paintingStrategy.drawPoint();
	}
}
