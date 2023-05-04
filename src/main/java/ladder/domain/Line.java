package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {

	private static final Random random = new Random();

	private final List<Boolean> points;
	private boolean beforePoint;

	public Line(int countOfPerson) {
		this.points = new ArrayList<>();
		this.beforePoint = false;
		IntStream.range(0, countOfPerson - 1).forEach(i -> this.addPoint(Line.random.nextBoolean()));
	}

	// TC를 수월하게 작성하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Line(List<Boolean> points, boolean beforePoint) {
		this.points = points;
		this.beforePoint = beforePoint;
	}

	public void addPoint(boolean randomBoolean) {
		if (this.beforePoint) {
			this.addFalse();
			return;
		}
		this.addRandomBoolean(randomBoolean);
	}

	private void addFalse() {
		this.beforePoint = false;
		this.points.add(false);
	}

	private void addRandomBoolean(Boolean randomBoolean) {
		this.beforePoint = randomBoolean;
		this.points.add(randomBoolean);
	}

	public List<Boolean> getPoints() {
		return this.points;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Line line = (Line)o;
		return beforePoint == line.beforePoint && Objects.equals(points, line.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points, beforePoint);
	}
}
