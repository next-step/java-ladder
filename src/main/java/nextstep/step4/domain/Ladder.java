package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

	private final Players players;
	private final List<Line> lines;

	public Ladder(Players players, List<Line> lines) {
		this.players = players;
		this.lines = new ArrayList<>(lines);
	}

	public Result play() {
		Result result = new Result();
		for (int position = 0; position < players.size(); position++) {
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
