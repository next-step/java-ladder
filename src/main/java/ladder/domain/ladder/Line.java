package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private final List<PointEnum> points;

	public Line(Integer countOfPerson) {
		List<PointEnum> points = new ArrayList<>();
		points.add(PointEnum.createRandomPoint());
		for (int i = 1; i < countOfPerson - 1; i++) {
			pointsAdd(points, i);
		}
		this.points = points;
	}

	private static void pointsAdd(final List<PointEnum> points, final int i) {
		if (points.get(i - 1).equals(PointEnum.TRUE)) {
			points.add(PointEnum.createPoint(false));
			return;
		}
		points.add(PointEnum.createRandomPoint());
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
		for (PointEnum point : points) {
			sb.append("|");
			appendPoint(point, sb);
		}
		sb.append("|");
		return sb.toString();
	}

	private static void appendPoint(final PointEnum point, final StringBuilder sb) {
		if (point.equals(PointEnum.TRUE)) {
			sb.append("-----");
			return;
		}
		sb.append("     ");
	}
}
