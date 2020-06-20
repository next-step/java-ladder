package study2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
	private List<Boolean> points;

	public Line(int PlayerNumbers, boolean anyValue) {
		this.points = createPoints(PlayerNumbers, anyValue);
	}

	private List<Boolean> createPoints(int playerNumbers, boolean anyValue) {
		points = new ArrayList<>();

		points.add(anyValue); // 첫번째 값은 무조건 false

		IntStream.range(1, playerNumbers)
		.forEach(i -> points.add(randomPoint(points.get(i - 1))));

		return points;
	}

	private Boolean randomPoint(Boolean point) {
		if (point) {
			return false;
		}
		return new RandomGenerator().getRandom();
	}

	public List<Boolean> getLine() {
		return Collections.unmodifiableList(points);
	}
}
