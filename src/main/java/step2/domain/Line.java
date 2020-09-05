package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
	private static final Random RANDOM = new Random();
	private static final String BLANK = "     |";
	private static final String LINE = "-----|";

	private final List<Boolean> points = new ArrayList<>();

	public Line(int countOfPerson) {
		for (int i = 0; i < countOfPerson; i++) {
			points.add(createPoint());
		}
	}

	private boolean createPoint() {
		if (points.size() != 0 && points.get(points.size()-1)) {
			return false;
		}
		return RANDOM.nextBoolean();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Boolean point : points) {
			if (point) {
				sb.append(LINE);
			} else {
				sb.append(BLANK);
			}
		}
		return sb.toString();
	}
}
