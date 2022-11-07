package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
	private final static int FIRST_INDEX = 0;
	private final static int PREV_INDEX = 0;

	private final List<Line> lines;

	public Lines(final int countOfPlayer) {
		List<Line> result = new ArrayList<>();
		for (int i = 0; i < countOfPlayer - 1; i++) {
			result.add(Line.create(getPrevLine(result, i)));
		}
		this.lines = result;
	}

	private Line getPrevLine(final List<Line> result, final int index) {
		if (index == 0) {
			return null;
		}
		return result.get(index - PREV_INDEX);
	}

	public int size() {
		return lines.size();
	}

	@Override
	public String toString() {
		return lines.stream()
			.map(Line::toString)
			.collect(Collectors.joining());
	}
}
