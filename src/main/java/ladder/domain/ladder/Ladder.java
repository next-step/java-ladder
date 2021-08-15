package ladder.domain.ladder;

import ladder.domain.line.Line;
import ladder.domain.line.Lines;
import ladder.domain.player.Player;
import ladder.domain.player.Players;

import java.util.List;

public class Ladder {

	private final Players players;
	private final Lines lines;

	private Ladder(Players players, Lines lines) {
		this.players = players;
		this.lines = lines;
	}

	public static Ladder of(String playersName, int height) {
		Players players = Players.of(playersName);
		return new Ladder(players, Lines.of(height, players.size()));
	}

	public List<Player> getPlayers() {
		return players.getPlayers();
	}

	public List<Line> getLines() {
		return lines.getLines();
	}

}
