package laddergame.domain;

import java.util.stream.Collectors;

public class Ladder {

	public static final String NEW_LINE = System.lineSeparator();

	private LadderGameInfo ladderGameInfo;
	private Lines lines;

	public Ladder(LadderGameInfo ladderGameInfo, Lines lines) {
		this.ladderGameInfo = ladderGameInfo;
		this.lines = lines;
	}

	public String draw() {
		String playerNames = ladderGameInfo.getFormattedPlayerNames();
		String ladderLine = this.lines.getDisplayLines();
		String results = ladderGameInfo.getFormattedResults();
		return String.join(NEW_LINE, playerNames, ladderLine, results);
	}

	public String end() {
		return ladderGameInfo.getPlayerNames().stream()
				.map(playerName -> String.format("%s : %s", playerName, start(playerName)))
				.collect(Collectors.joining(NEW_LINE));
	}

	public String start(String playerName) {
		int playerIndex = ladderGameInfo.findPlayerIndex2(playerName);
		return ladderGameInfo.findResult(lines.move(playerIndex));
	}
}
