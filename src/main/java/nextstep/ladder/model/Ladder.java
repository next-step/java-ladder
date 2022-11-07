package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
	private final List<Lines> lines;

	public Ladder(final int numberOfFloors, final int numberOfPlayers) {
		List<Lines> result = new ArrayList<>();
		for (int i = 0; i < numberOfFloors; i++) {
			result.add(new Lines(numberOfPlayers));
		}
		this.lines = result;
	}

	public int numberOfFloors() {
		return lines.size();
	}

	public List<Lines> getLines() {
		return lines;
	}
}
