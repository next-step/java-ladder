package step4.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step4.domain.PointCreator.createPoint;

public class Line {
	private final List<Boolean> points;

	public Line(List<Boolean> points) {
		this.points = points;
	}

	public static Line init(int countOfPerson) {
		List<Boolean> points = new ArrayList<>();
		for (int i = 0; i < countOfPerson; i++) {
			points.add(createPoint(points));
		}
		return new Line(points);
	}

	public List<Boolean> getPoints() {
		return Collections.unmodifiableList(this.points);
	}

	public boolean isPoint(int index) {
		return points.get(index);
	}
}
