package ladder.domain;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by seungwoo.song on 2022-11-04
 */
public class LadderLine extends AbstractList<Point> {
	private final List<Point> points;

	private LadderLine(List<Point> points) {
		this.points = points;
	}

	public static LadderLine of(int personCount, BooleanSupplier booleanSupplier) {
		List<Point> points = new ArrayList<>();

		Point point = Point.first(booleanSupplier.getAsBoolean());
		points.add(point);

		int maxCount = personCount - 1;
		for (int i = 1; i <= maxCount; i++) {
			point = getNextPoint(booleanSupplier, point, isLast(maxCount, i));
			points.add(point);
		}

		return new LadderLine(points);
	}

	private static boolean isLast(int maxCount, int i) {
		return i == maxCount;
	}

	private static Point getNextPoint(BooleanSupplier booleanSupplier, Point point, boolean isLast) {
		if (isLast) {
			return point.last();
		}

		return point.next(booleanSupplier);
	}

	public int move(int index) {
		return Optional.ofNullable(points.get(index))
			.map(Point::move)
			.orElseThrow(() -> new IllegalArgumentException("잘못된 index 입니다"));
	}

	@Override
	public Point get(int index) {
		return points.get(index);
	}

	@Override
	public int size() {
		return points.size();
	}

	//===================================================================

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LadderLine that = (LadderLine)o;
		return Objects.equals(points, that.points);
	}

	@Override public int hashCode() {
		return Objects.hash(points);
	}

	@Override public String toString() {
		return "LadderLine{" +
			"points=" + points +
			'}';
	}
}
