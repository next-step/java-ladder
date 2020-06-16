package study2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
	private List<Point> points;

	public Line(int PlayerNumbers, boolean anyValue) {
		this.points = makeLine(PlayerNumbers, anyValue);
	}

	private List<Point> makeLine(int playerNumbers, boolean anyValue) {
		points = new ArrayList<>();

		points.add(new Point(anyValue)); // 첫번째 값은 무조건 false

		IntStream.range(1, playerNumbers)
			.forEach(i -> points.add(randomPoint()));

		return points;
	}

	private Point randomPoint() {
		return new Point(new RandomGenerator());
	}

	public List<Point> getLine() {
		return points;
	}

}
