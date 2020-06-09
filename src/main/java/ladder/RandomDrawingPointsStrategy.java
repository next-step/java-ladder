package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDrawingPointsStrategy implements DrawingPointsStrategy {

	private final Random random = new Random();

	@Override
	public LadderLinePoints draw(int count) {
		List<LadderLinePoint> points = new ArrayList<>();
		boolean isConnectedToPreceding = false;

		for (int i = 0; i < count; i++) {
			LadderLinePoint point = drawPoint(i == count - 1, isConnectedToPreceding);
			points.add(point);
			isConnectedToPreceding = point.isConnectedToNextPoint();
		}

		return LadderLinePoints.of(points);
	}

	private LadderLinePoint drawPoint(boolean isLastPoint, boolean isConnectedToPreceding) {
		if (isLastPoint || isConnectedToPreceding) {
			return LadderLinePoint.of(false);
		}

		return LadderLinePoint.of(random.nextBoolean());
	}
}
