package nextstep.ladder.domain.line;

import java.util.Collections;
import java.util.List;

import nextstep.ladder.domain.player.Players;

public class Lines {

	private final List<Line> lines;

	private Lines(List<Line> lines) {
		this.lines = lines;
	}

	public static Lines ofLines(List<Line> lines) {
		return new Lines(lines);
	}

	public int size() {
		return lines.size();
	}

	public List<Line> getLines() {
		return Collections.unmodifiableList(lines);
	}

	public Players determinePlayersPositionResult(Players players) {
		this.lines.forEach(players::determinePlayersPositionResult);
		return players;
	}
}
