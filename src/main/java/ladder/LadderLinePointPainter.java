package ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderLinePointPainter {

	private final DrawingPointStrategy drawingPointStrategy;

	public LadderLinePointPainter(DrawingPointStrategy drawingPointStrategy) {
		this.drawingPointStrategy = drawingPointStrategy;
	}

	public LadderLinePoints drawPoints(int count) {
		List<LadderLinePoint> points = new ArrayList<>();
		boolean isConnectedToPreceding = false;

		for (int i = 0; i < count; i++) {
			LadderLinePoint point = drawPoint((i == count - 1), isConnectedToPreceding);
			isConnectedToPreceding = point.isConnectedToNextPoint();
			points.add(point);
		}

		return LadderLinePoints.of(points);
	}

	private LadderLinePoint drawPoint(boolean isLastPoint, boolean isConnectedToPreceding) {
		if (isLastPoint || isConnectedToPreceding) {
			return LadderLinePoint.of(false);
		}

		return drawingPointStrategy.drawPoint();
	}
}
