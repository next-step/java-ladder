package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

	public static final String NEW_LINE = System.lineSeparator();

	private List<Player> players;
	private List<Line> lines;

	public Ladder(List<Player> players, List<Line> lines) {
		this.players = players;
		this.lines = lines;
	}

	public String draw() {
		String player = getPlayerNames();
		String ladder = getLadder();
		return String.join(NEW_LINE, player, ladder);
	}

	private String getPlayerNames() {
		return players.stream()
				.map(player -> player.getFomattedName())
				.collect(Collectors.joining(" "));
	}

	private String getLadder() {
		List<String> ladder = new ArrayList<>();
		for (Line line : lines) {
			ladder.add(line.draw());
		}
		return String.join(NEW_LINE, ladder);
	}
}
