package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
	private final List<Boolean> line = new ArrayList<>();

	public Line(int userCnt) {
		Random random = new Random();
		line.add(random.nextBoolean());
		IntStream.range(1, userCnt - 1)
				.forEach(i -> line.add(!line.get(i - 1) && random.nextBoolean()));
	}

	public List<Boolean> getLine() {
		return line;
	}
}
