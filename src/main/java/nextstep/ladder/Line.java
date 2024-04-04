package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
	private List<Point> points = new ArrayList<>();

	public Line(List<Point> points) {
		checkOverLabLine(points);
		this.points = points;
	}

	public Line(int countOfPerson) {
		this.points = new ArrayList<>(countOfPerson);

		points.add(new Point(() -> RandomLine.getRandomValue()));

		for (int i = 1; i < countOfPerson - 1; i++) {
			int index = i;
			points.add(new Point(() -> isBeforeDrawLine(index - 1)));
		}

		checkOverLabLine(points);
	}

	private boolean isBeforeDrawLine(int prevIndex) {
		return RandomLine.getRandomValue() && points.get(prevIndex).isPoint();
	}

	private void checkOverLabLine(List<Point> points) {
		boolean foundOverLab = IntStream.range(0, points.size() - 1)
				.anyMatch(i -> points.get(i).isPoint() && points.get(i + 1).isPoint());

		if (foundOverLab)
			throw new IllegalArgumentException("라인이 중복되면 안됩니다.");
	}

	public List<Point> getPoints() {
		return points;
	}

}