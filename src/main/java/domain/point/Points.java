package domain.point;

import domain.ladder.LadderLayer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hspark on 18/11/2018.
 */
public class Points {
	private Map<Point, Point> points;

	public Points(int pointCount) {
		this.points = IntStream.range(0, pointCount).mapToObj(Point::of)
			.collect(Collectors.toMap(Function.identity(), Function.identity()));
	}

	public List<Point> getPoints() {
		return Collections.unmodifiableList(new ArrayList<>(points.values()));
	}

	public Point findCurrentPointByStartPoint(Point point) {
		return points.get(point);
	}

	public void put(Point key, Point value) {
		points.put(key, value);
	}

	public void moveAll(LadderLayer ladderLayer) {
		for (Point point : points.keySet()) {
			move(point, ladderLayer);
		}
	}

	public void move(Point key, LadderLayer ladderLayer) {
		Point point = findCurrentPointByStartPoint(key);
		ladderLayer.getPassableLadderLine(point)
			.ifPresent(ladderLine -> put(key, ladderLine.getMovePosition(point)));
	}

	public int getWidth() {
		return points.size() - 1;
	}
}
