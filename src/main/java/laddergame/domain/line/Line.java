package laddergame.domain.line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.result.DisplayLine;

public class Line {

	private List<Point> points;

	private Line(List<Point> points) {
		this.points = points;
	}

	public static Line from(int playerCount) {
		List<Point> points = new ArrayList<>();
		// 시작점 생성
		points.add(Point.from(Direction.STRAIGHT));
		// 나머지 사다리선 생성
		while(points.size() < playerCount) {
			points.add(Point.nextOf(getLastPoint(points)));
		}
		return from(points);
	}

	public static Line from(List<Point> points) {
		return new Line(points);
	}

	private static Point getLastPoint(List<Point> points) {
		return points.get(points.size() - 1);
	}

	public int move(int startIndex) {
		Point point = points.get(startIndex);
		return point.move(startIndex);
	}

	public DisplayLine getDisplayLine() {
		List<String> displayCharacters= points.stream()
				.map(Point::getDisplayCharacter)
				.collect(Collectors.toList());
		return new DisplayLine(displayCharacters);
	}
}
