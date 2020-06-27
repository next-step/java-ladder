package study3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

	private List<Line> lines;

	public Ladder(Players players, Height height) {
		this.lines = createLadder(players, height);
	}

	private List<Line> createLadder(Players players, Height height) {
		int playerNumbers = players.getPlayersCount();

		return IntStream.rangeClosed(1, height.getHeight())
				.mapToObj(i -> new Line(playerNumbers, false))
				.collect(Collectors.toList());
	}

	public List<Line> getLadder() {
		return Collections.unmodifiableList(lines);
	}

}
