package nextstep.ladder.domain;

import nextstep.ladder.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

	private List<Point> points;

	public static Line from(List<Boolean> points) {
		return new Line(points.stream()
				.map(p -> new Point(p))
				.collect(Collectors.toList()));
	}

	public Line(List<Point> points) {
		checkOverLabLine(points);
		this.points = points;
	}

	public Line(int countOfPerson) {
		this.points = new ArrayList<>(countOfPerson);
		Point beforePoint = new Point(RandomLine::getRandomValue);
		points.add(beforePoint);

		boolean isBeforePoint = beforePoint.isActive();

		for (int i = 1; i < countOfPerson - 1; i++) {
			boolean finalIsBeforePoint = isBeforePoint;
			Point currentPoint = new Point(() -> isBeforeDrawLine(finalIsBeforePoint));
			points.add(currentPoint);
			isBeforePoint = currentPoint.isActive();
		}
		checkOverLabLine(points);
	}

	private boolean isBeforeDrawLine(boolean isBeforePoint) {
		return !isBeforePoint && RandomLine.getRandomValue();
	}

	private Point findPoint(int index, List<Point> points) {
		return points.get(index);
	}

	private void checkOverLabLine(List<Point> points) {
		if (isFoundOverLab(points))
			throw new IllegalArgumentException("라인이 중복되면 안됩니다.");
	}

	private boolean isFoundOverLab(List<Point> points) {
		return IntStream.range(0, points.size() - 1)
				.anyMatch(index -> isSamePosition(index, points));
	}

	private boolean isSamePosition(int index, List<Point> points) {
		return findPoint(index, points).isActive() && findPoint(index + 1, points).isActive();
	}

	public List<Boolean> pointToBoolean() {
		return points.stream()
				.map(Point::isActive)
				.collect(Collectors.toList());
	}

	public boolean leftIsMovable(Position currentPosition) {
		int leftPosition = currentPosition.getPosition() - 1;
		return leftPosition >= 0 && points.get(leftPosition).isActive();
	}

	public boolean rightIsMovable(Position currentPosition) {
		int rightPosition = currentPosition.getPosition();
		return rightPosition < points.size() && points.get(rightPosition).isActive();
	}

	public Position move(Position position) {
		if (rightIsMovable(position)) {
			return position.rightMove();
		}
		if (leftIsMovable(position)) {
			return position.leftMove();
		}
		return position;
	}

}
