package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class Ladder implements Iterable<Line> {

	private final List<Line> ladder = new ArrayList<>();

	public Ladder (int length, int height) {
		IntStream.range(0, height).forEach(i -> ladder.add(new Line(length)));
	}

	@Override
	public Iterator<Line> iterator() {
		return ladder.iterator();
	}

	@Override
	public void forEach(Consumer<? super Line> action) {
		Iterable.super.forEach(action);
	}
}
