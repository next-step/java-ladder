package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class LadderLine {
	private final List<Point> points;

	private LadderLine(List<Point> points) {
		this.points = points;
	}

	public static LadderLine init(Players players) {
		List<Point> points = new ArrayList<>();
		Point point = Point.first();
		points.add(point);
		for (int i = 1; i < players.size() - 1; i++) {
			point = point.next();
			points.add(point);
		}
		point = point.last();
		points.add(point);
		return new LadderLine(points);
	}
	
	public static LadderLine initQ(Players players) {
		List<Point> points = new ArrayList<>();
		Point point = Point.first();
		points.add(point);
		for (int i = 1; i < players.size() - 1; i++) {
			points.add(point.next());
		}
		points.add(point.last());
		return new LadderLine(points);
	}

	public Position move(Position position) {
		return points.get(position.getPosition()).move(position);
	}

	public int size() {
		return points.size();
	}

	public Stream<Point> getStream() {
		return points.subList(0, points.size() - 1).stream();
	}
}
