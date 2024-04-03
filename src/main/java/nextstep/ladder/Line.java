package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
	private List<Boolean> points = new ArrayList<>();

	public Line(List<Boolean> points) {
		checkOverLabLine(points);
		this.points = points;
	}

	public Line(int countOfPerson) {
		drawLine(() -> RandomLine.getRandomValue());

		for (int i = 1; i < countOfPerson - 1; i++) {
			int index = i;
			drawLine(() -> isBeforeDrawLine(index - 1));
		}

		checkOverLabLine(points);
	}

	public void drawLine(DrawStrategy drawStrategy) {
		if (drawStrategy.isDraw()) {
			points.add(true);
		}
		points.add(false);
	}

	private boolean isBeforeDrawLine(int prevIndex) {
		return RandomLine.getRandomValue() && points.get(prevIndex);
	}

	private void checkOverLabLine(List<Boolean> points) {
		boolean foundOverLab = IntStream.range(0, points.size() - 1)
				.anyMatch(i -> points.get(i) && points.get(i + 1));

		if (foundOverLab)
			throw new IllegalArgumentException("라인이 중복되면 안됩니다.");
	}

	public List<Boolean> getPoints() {
		return points;
	}

}