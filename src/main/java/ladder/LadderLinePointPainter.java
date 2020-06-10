package ladder;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderLinePointPainter {

	private final DrawingPointStrategy drawingPointStrategy;

	public LadderLinePointPainter(DrawingPointStrategy drawingPointStrategy) {
		this.drawingPointStrategy = drawingPointStrategy;
	}

	public LadderLinePoints drawPoints(int count) {
		AtomicBoolean isConnectedToPreceding = new AtomicBoolean(false);

		return IntStream.range(0, count)
				.mapToObj(index -> drawPoint(index == count - 1, isConnectedToPreceding.get()))
				.peek(point -> isConnectedToPreceding.set(point.isConnectedToNextPoint()))
				.collect(collectingAndThen(toList(), LadderLinePoints::of));
	}

	private LadderLinePoint drawPoint(boolean isLastPoint, boolean isConnectedToPreceding) {
		if (isLastPoint || isConnectedToPreceding) {
			return LadderLinePoint.of(false);
		}

		return drawingPointStrategy.drawPoint();
	}
}
