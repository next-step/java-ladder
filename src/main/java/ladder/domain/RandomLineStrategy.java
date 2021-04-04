package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineStrategy implements LineStrategy {
	Random random = new Random();

	@Override
	public List<Boolean> points(int countOfPerson) {
		List<Boolean> points = new ArrayList<>();
		final boolean[] previousLine = {false};
		IntStream.range(0, countOfPerson).forEach((n) -> {
			Boolean line = random.nextBoolean();
			if (!line) {
				points.add(false);
				previousLine[0] = false;
			}
			if (line && !previousLine[0]) {
				points.add(true);
				previousLine[0] = true;
			}
			if (line && previousLine[0]) {
				previousLine[0] = false;
			}
		});
		return points;
	}

}
