package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private final List<Boolean> points;

	public Line(Integer countOfPerson) {
		List<Boolean> points = new ArrayList<>();
		points.add(Math.random() > 0.5);
		for (int i = 1; i < countOfPerson - 1; i++) {
			pointsAdd(points, i);
		}
		this.points = points;
	}

	private static void pointsAdd(final List<Boolean> points, final int i) {
		if (points.get(i - 1)) {
			points.add(false);
			return;
		}
		points.add(Math.random() > 0.5);
	}

	public static Line createLine(Integer countOfPerson) {
		return new Line(countOfPerson);
	}

	public int size() {
		return points.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Boolean point : points) {
			sb.append("|");
			appendPoint(point, sb);
		}
		sb.append("|");
		return sb.toString();
	}

	private static void appendPoint(final Boolean point, final StringBuilder sb) {
		if (point) {
			sb.append("-----");
			return;
		}
		sb.append("     ");
	}
}
