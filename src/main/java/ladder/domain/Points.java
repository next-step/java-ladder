package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Points {

	private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

	private final List<Point> points;

	public Points(Boolean... points) {
		this(Arrays.stream(points).map(Point::of).collect(Collectors.toList()));
	}

	public Points(List<Point> points) {
		IntStream.range(0, points.size() - 1)
			.filter(i -> points.get(i).equals(Point.of(true)) && points.get(i + 1).equals(Point.of(true)))
			.findFirst()
			.ifPresent(i -> {
				throw new IllegalArgumentException("인접한 좌표를 모두 채울 수 없습니다.");
			});
		this.points = points;
	}

	public static List<Point> generate(Names names) {
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < names.countOfPerson() - 1; i++) {
			Points.addPoint(points, RANDOM.nextBoolean());
		}
		return points;
	}

	private static void addPoint(List<Point> points, boolean randomBoolean) {
		if (points.size() == 0) {
			points.add(Point.of(randomBoolean));
			return;
		}
		if (points.get(points.size() - 1).equals(Point.of(true))) {
			points.add(Point.of(false));
			return;
		}
		points.add(Point.of(randomBoolean));
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
