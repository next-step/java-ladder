package laddergame.domain.line;

import laddergame.domain.point.Point;

import java.util.LinkedList;

public class TestFixture {

	public static Line fromPoints(LinkedList<Point> points) {
		return new Line(points);
	}
}
