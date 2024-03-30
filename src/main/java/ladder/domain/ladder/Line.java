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
		if (PointEnum.isTrue(points.get(i - 1))) {
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

	public List<PointEnum> getPoints() {
		return points;
	}
}
