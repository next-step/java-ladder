package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {

	private final Players players;
	private final List<Line> lines;

	public Ladder(Players players, List<Line> lines) {
		this.players = players;
		this.lines = lines;
	}

	public List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}
}
