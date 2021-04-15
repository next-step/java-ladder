package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineStrategy implements LineStrategy {
	Random random = new Random();

	@Override
	public List<Cross> crosses(int countOfPerson) {
		List<Cross> crosses = new ArrayList<>();

		boolean previousPoint = random.nextBoolean();
		Point point = Point.first(previousPoint);
		crosses.add(new Cross(0, point));

		for (int i = 1; i < countOfPerson - 1; i++) {
			boolean randomPoint = calculatePoint(previousPoint);
			point = point.next(randomPoint);
			crosses.add(new Cross(i, point));
			previousPoint = randomPoint;
		}
		crosses.add(new Cross(countOfPerson - 1, point.last()));

		return crosses;
	}

	private boolean calculatePoint(boolean previousPoint) {
		boolean line = random.nextBoolean();
		return line && !previousPoint;
	}

}
