package ladder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.model.Height;
import ladder.model.Line;
import ladder.model.LineSketch;
import ladder.model.Lines;
import ladder.model.Players;
import ladder.model.Point;

public class LadderCreate {

	public static final int START_INCLUSIVE = 0;

	public static Lines createLadder(Players players, Height height) {
		return new Lines(IntStream.range(START_INCLUSIVE, height.getHeight())
			.mapToObj(i -> new Line(createLinePoints(players.findPlayerCount())))
			.collect(Collectors.toList()));
	}

	private static List<Point> createLinePoints(int playerCount) {
		List<Point> points = new ArrayList<>();
		Point point = Point.initCreate(LineSketch.drawLine());
		points.add(point);
		point = initBody(playerCount, points, point);
		points.add(point.initLast());
		return points;
	}

	private static Point initBody(int playerCount, List<Point> points, Point point) {
		for (int i = 1; i < playerCount - 1; i++) {
			point = point.next();
			points.add(point);
		}
		return point;
	}

}
