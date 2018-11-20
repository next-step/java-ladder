package laddergame2.domain;

import java.util.Collections;
import java.util.List;
import laddergame2.domain.generator.PointGenerator;

public class LadderLine {

	private List<Point> points;

	public LadderLine(List<Point> points) {
		this.points = points;
	}

	public static LadderLine init(PointGenerator pointGenerator) {
		return new LadderLine(pointGenerator.generate());
	}

	public int move(int position) {
		return points.get(position).move();
	}

	public List<Point> getPoints() {
		return Collections.unmodifiableList(points);
	}

	@Override
	public String toString() {
		return "LadderLine{" +
				"points=" + points +
				'}';
	}
}
