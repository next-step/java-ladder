package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
	Random random = new Random();

	@Override
	public List<Boolean> points(int countOfPerson) {
		List<Boolean> points = new ArrayList<>();
		boolean previousLine = false;

		for (int i = 0; i < countOfPerson; i++) {
			previousLine = addPoints(points, previousLine, countOfPerson, i);
		}

		return points;
	}

	private boolean addPoints(List<Boolean> points, boolean previousLine, int countOfPerson, int i) {
		boolean line = random.nextBoolean();
		if (line && !previousLine && i != (countOfPerson - 1)) {
			points.add(true);
			return true;
		}
		points.add(false);
		return false;
	}

}
