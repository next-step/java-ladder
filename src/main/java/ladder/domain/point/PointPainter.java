package ladder.domain.point;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class PointPainter {

	private final DrawingPointStrategy drawingPointStrategy;

	public PointPainter(DrawingPointStrategy drawingPointStrategy) {
		this.drawingPointStrategy = drawingPointStrategy;
	}

	public Points drawPoints(int count) {
		AtomicBoolean isConnectedToPreceding = new AtomicBoolean(false);

		return IntStream.range(0, count)
				.mapToObj(index -> drawPoint(index == count - 1, isConnectedToPreceding.get()))
				.peek(point -> isConnectedToPreceding.set(point.isConnectedToNextPoint()))
				.collect(collectingAndThen(toList(), Points::of));
	}

	private Point drawPoint(boolean isLastPoint, boolean isConnectedToPreceding) {
		if (isLastPoint || isConnectedToPreceding) {
			return Point.of(false);
		}

		return drawingPointStrategy.drawPoint();
	}
}
