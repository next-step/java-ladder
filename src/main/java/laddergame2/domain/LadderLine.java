package laddergame2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import laddergame2.domain.generator.PointGenerator;

public class LadderLine {

	private List<Point> points;

	public LadderLine(List<Point> points) {
		this.points = points;
	}

	public static LadderLine init(int playerCount) {
		List<Point> points = new ArrayList<>();
		initFirst(points);
		initBody(playerCount, points);
		initLast(points);
		return new LadderLine(points);
	}

	private static void initFirst(List<Point> points) {
		Point first = Point.first(PointGenerator.getInstance().generate());
		points.add(first);
	}

	private static void initBody(int playerCount, List<Point> points) {
		for (int index = 1; index < playerCount - 1; index++) {
			Point before = points.get(index - 1);
			points.add(before.next());
		}
	}

	private static void initLast(List<Point> points) {
		Point before = points.get(points.size() - 1);
		points.add(before.last());
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
