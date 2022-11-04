package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;

/**
 * Created by seungwoo.song on 2022-11-04
 */
public class LadderLine {

	private final List<Point> points;

	private LadderLine(List<Point> points) {
		this.points = points;
	}

	public static LadderLine of(int personCount, BooleanSupplier booleanSupplier) {
		List<Point> points = new ArrayList<>();

		Point point = Point.first(booleanSupplier.getAsBoolean());
		points.add(point);

		for (int i = 1; i < personCount; i++) {
			point = point.next(booleanSupplier);
			points.add(point);
		}

		points.add(point.last());
		return new LadderLine(points);
	}

	public int move(int index) {
		return Optional.ofNullable(points.get(index))
			.map(Point::move)
			.orElseThrow(() -> new IllegalArgumentException("잘못된 index 입니다"));
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
