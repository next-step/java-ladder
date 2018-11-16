package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

	public static final String NEW_LINE = System.lineSeparator();

	private LadderGameInfo ladderGameInfo;
	private List<Line> lines;

	public Ladder(LadderGameInfo ladderGameInfo, List<Line> lines) {
		this.ladderGameInfo = ladderGameInfo;
		this.lines = lines;
	}

	public String draw() {
		String playerNames = ladderGameInfo.getFormattedPlayerNames();
		String ladder = getLadder();
		String results = ladderGameInfo.getFormattedResults();
		return String.join(NEW_LINE, playerNames, ladder, results);
	}

	private String getLadder() {
		return lines.stream()
				.map(Line::draw)
				.collect(Collectors.joining(NEW_LINE));
	}

	public String end() {
		return ladderGameInfo.getPlayerNames().stream()
				.map(playerName -> String.format("%s : %s", playerName, start(playerName)))
				.collect(Collectors.joining(NEW_LINE));
	}

	public String start(String playerName) {
		int currentIndex = ladderGameInfo.findPlayerIndex(playerName);
		for (Line line : lines) {
			currentIndex = line.move(currentIndex);
		}
		return ladderGameInfo.findResult(currentIndex);
	}
}
