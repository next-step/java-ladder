package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

	private final List<Point> points;

	private Points(Boolean... points) {
		this(Arrays.stream(points).map(Point::of).collect(Collectors.toList()));
	}

	public Points(List<Point> points) {
		boolean match = IntStream.range(0, points.size() - 1)
			.anyMatch(i -> points.get(i).equals(Point.of(true)) && points.get(i + 1).equals(Point.of(true)));
		if (match) {
			throw new IllegalArgumentException("인접한 좌표를 모두 채울 수 없습니다.");
		}
		this.points = points;
	}

	public static Points of(Boolean... points) {
		return new Points(points);
	}

	public static List<Point> generate(Names names, PointGenerator pointGenerator) {
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < names.countOfPerson() - 1; i++) {
			Points.addPoint(points, pointGenerator.point());
		}
		return points;
	}

	private static void addPoint(List<Point> points, boolean point) {
		if (points.size() == 0) {
			points.add(Point.of(point));
			return;
		}
		if (points.get(points.size() - 1).equals(Point.of(true))) {
			points.add(Point.of(false));
			return;
		}
		points.add(Point.of(point));
	}

	public int nextIndex(int index) {
		if (index == 0) {
			return this.stopOrRight(index);
		}
		if (index < this.points.size()) {
			return this.stopOrRightOrLeft(index);
		}
		return this.stopOrLeft(index);
	}

	private int stopOrRight(int index) {
		if (this.points.get(index).equals(Point.of(true))) {
			return DirectionType.RIGHT.move(index);
		}
		return DirectionType.DOWN.move(index);
	}

	private int stopOrRightOrLeft(int index) {
		if (this.points.get(index - 1).equals(Point.of(true))) {
			return DirectionType.LEFT.move(index);
		}
		if (this.points.get(index).equals(Point.of(true))) {
			return DirectionType.RIGHT.move(index);
		}
		return DirectionType.DOWN.move(index);
	}

	private int stopOrLeft(int index) {
		if (this.points.get(index - 1).equals(Point.of(true))) {
			return DirectionType.LEFT.move(index);
		}
		return DirectionType.DOWN.move(index);
	}

	public List<Point> getPoints() {
		return this.points;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Points points1 = (Points)o;
		return Objects.equals(points, points1.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}
}
