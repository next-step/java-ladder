package ladder.domain.line;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

import ladder.domain.util.RandomUtils;

@ToString
public class Line {
	private final List<Boolean> points;
	private int currentIndex = -1;

	private Line(int width) {
		this.points = makePoints(width);
	}

	public static Line of(int countOfPerson) {
		return new Line(countOfPerson);
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

	private List<Boolean> makePoints(int countOfPerson) {
		List<Boolean> result = initPoints(countOfPerson);

		for (int i = 1; i < countOfPerson - 1; i++) {
			boolean point = makePoint(result.get(i - 1));
			result.add(point);
		}
		addTrueIfItsAllFalse(result);
		return result;
	}

	private List<Boolean> initPoints(int count) {
		List<Boolean> points = new ArrayList<>(count);
		points.add(0, Boolean.FALSE);

		return points;
	}

	private boolean makePoint(Boolean previousPoint) {
		return previousPoint.equals(Boolean.FALSE) ? RandomUtils.booleanValue() : Boolean.FALSE;
	}

	private void addTrueIfItsAllFalse(List<Boolean> points) {
		boolean allFalse = points.stream()
								 .allMatch(point -> !point);
		if (allFalse) {
			int index = RandomUtils.intValue(points.size());
			points.set(index, Boolean.TRUE);
		}
	}


}
