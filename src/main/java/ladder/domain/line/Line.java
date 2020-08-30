package ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.playing.Direction;
import ladder.domain.util.RandomUtils;

public class Line {
	private final List<Boolean> points;
	private int currentIndex = -1;

	private Line(List<Boolean> points) {
		this.points = points;
	}

	public static Line of(int countOfPerson) {
		return new Line(makePoints(countOfPerson));
	}

	public static Line of(List<Boolean> points) {
		return new Line(points);
	}

	public int getWidth() {
		return this.points.size() + 1;
	}

	public boolean hasNext() {
		return points.size() > currentIndex + 1;
	}

	public boolean next() {
		return points.get(++currentIndex);
	}

	public Direction getDirectionFrom(int width) {
		if (width != points.size() && points.get(width)) {
			return Direction.RIGHT;
		}
		if (width > 0 && points.get(width - 1)) {
			return Direction.LEFT;
		}
		return Direction.STRAIGHT;
	}


	private static List<Boolean> makePoints(int countOfPerson) {
		List<Boolean> result = initPoints(countOfPerson);

		for (int i = 1; i < countOfPerson - 1; i++) {
			boolean point = makePoint(result.get(i - 1));
			result.add(point);
		}
		addTrueIfItsAllFalse(result);
		return result;
	}

	private static List<Boolean> initPoints(int count) {
		List<Boolean> points = new ArrayList<>(count);
		points.add(0, RandomUtils.booleanValue());

		return points;
	}

	private static boolean makePoint(Boolean previousPoint) {
		return previousPoint.equals(Boolean.FALSE) ? RandomUtils.booleanValue() : Boolean.FALSE;
	}

	private static void addTrueIfItsAllFalse(List<Boolean> points) {
		boolean allFalse = points.stream()
								 .noneMatch(point -> point);
		if (allFalse) {
			int index = RandomUtils.intValue(points.size());
			points.set(index, Boolean.TRUE);
		}
	}


}
