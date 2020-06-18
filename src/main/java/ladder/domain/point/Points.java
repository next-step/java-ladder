package ladder.domain.point;

import java.util.Collections;
import java.util.List;

public class Points {

	private final List<Point> points;

	private Points(List<Point> points) {
		this.points = points;
	}

	public static Points of(List<Point> points) {
		return new Points(points);
	}

	private void validateExistPosition(int position) {
		if (position >= points.size()) {
			throw new IllegalArgumentException("좌표 수보다 큰 위치는 존재하지 않습니다.");
		}
	}

	public int moveSideFrom(int position) {
		validateExistPosition(position);

		Point point = points.get(position);
		return point.pass();
	}

	public int size() {
		return points.size();
	}

	public List<Point> getContent() {
		return Collections.unmodifiableList(points);
	}
}
