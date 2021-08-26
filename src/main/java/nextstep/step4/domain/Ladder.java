package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

	private final int players;
	private final List<Line> lines;

	public Ladder(int players, List<Line> lines) {
		this.players = players;
		this.lines = new ArrayList<>(lines);
	}

	public Result play() {
		Result result = new Result();
		for (int position = 0; position < players; position++) {
			result.put(position, destination(position));
		}
		return result;
	}

	private int destination(int startPosition) {
		int destination = startPosition;
		for (Line line : lines) {
			destination = line.move(destination);
		}
		return destination;
	}

}
