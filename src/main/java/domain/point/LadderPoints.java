package domain.point;

import domain.ladder.LadderLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by hspark on 18/11/2018.
 */
public class LadderPoints {
	private Map<Point, Point> points;

	public LadderPoints(int pointCount) {
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

	public void moveAll(LadderLine ladderLine) {
		for (Point point : points.keySet()) {
			move(point, ladderLine);
		}
	}

	public void move(Point key, LadderLine ladderLine) {
		Point currentPoint = findCurrentPointByStartPoint(key);
		Point movePoint = ladderLine.move(currentPoint);
		put(key, movePoint);
	}

	public int getWidth() {
		return points.size() - 1;
	}

	public int getSizeOfGamer() {
		return points.size();
	}
}
