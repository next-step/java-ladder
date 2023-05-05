package ladder.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Points {

	private final List<Boolean> points;

	public Points(List<Boolean> points) {
		IntStream.range(0, points.size() - 1)
			.filter(i -> points.get(i) && points.get(i+1))
			.findFirst()
			.ifPresent(i -> {
				throw new IllegalArgumentException("인접한 좌표를 모두 채울 수 없습니다.");
			});
		this.points = points;
	}

	public void add(boolean point) {
		this.points.add(point);
	}

	public List<Boolean> getPoints() {
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
