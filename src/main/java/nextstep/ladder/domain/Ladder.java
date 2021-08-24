package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

	private final Players players;
	private final List<Line> lines;

	public Ladder(Players players, List<Line> lines) {
		this.players = players;
		this.lines = new ArrayList<>(lines);
	}

	public Map<Integer, Integer> play() {
		Map<Integer, Integer> result = new HashMap<>();
		for (int position = 0; position < players.size(); position++) {
			result.put(position, destination(position));
		}
		return result;
	}

	public List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}

	private int destination(int start) {
		int destination = start;
		for (Line line : lines) {
			destination = line.move(destination);
		}
		return destination;
	}
}
