package ladder.util;

import ladder.domain.Direction;
import ladder.domain.Point;

import java.util.HashMap;
import java.util.Map;

public class PointUtils {

	private PointUtils() {

	}

	public static Map<Direction, Point> createNextPoints(Direction direction, Point point) {
		Map<Direction, Point> nextPoints = new HashMap<>();
		nextPoints.put(direction, point);
		return nextPoints;
	}

}
