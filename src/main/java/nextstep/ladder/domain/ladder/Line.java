package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Line implements Iterable<Boolean> {

	private static Random RANDOM = new Random();
	private List<Boolean> points = new ArrayList<>();

	public Line (int length) {
		IntStream.range(0, length - 1).forEach(i -> {
			Boolean point = RANDOM.nextBoolean();
			if (isAvailablePoint(i)) {
				points.add(point);
				return;
			}
			points.add(false);
		});
	}

	public StringBuilder getLine() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("|");
		for (Boolean point : points) {
			if (point)
				stringBuilder.append("------");
			else
				stringBuilder.append("      ");
			stringBuilder.append("|");
		}
		return stringBuilder;
	}

	private Boolean isAvailablePoint(int index) {
		return points.isEmpty() || !points.get(index - 1);
	}

	@Override
	public Iterator<Boolean> iterator() {
		return points.iterator();
	}

	@Override
	public void forEach(Consumer<? super Boolean> action) {
		Iterable.super.forEach(action);
	}
}