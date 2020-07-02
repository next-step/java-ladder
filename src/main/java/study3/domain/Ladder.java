package study3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

	private List<LadderLine> lines;

	public Ladder(Players players, Height height) {
		this.lines = createLadder(players, height);
	}

	private List<LadderLine> createLadder(Players players, Height height) {
		int playerNumbers = players.getPlayersCount();

		return IntStream.rangeClosed(1, height.getHeight())
				.mapToObj(i -> new LadderLine(playerNumbers, false))
				.collect(Collectors.toList());
	}

	public List<LadderLine> getLadder() {
		return Collections.unmodifiableList(lines);
	}

}
