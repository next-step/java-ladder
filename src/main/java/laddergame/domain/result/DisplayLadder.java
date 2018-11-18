package laddergame.domain.result;

import laddergame.domain.LadderGameInfo;
import laddergame.domain.line.Lines;

public class DisplayLadder {

	public static final String NEW_LINE = System.lineSeparator();

	private LadderGameInfo ladderGameInfo;
	private Lines lines;

	public DisplayLadder(LadderGameInfo ladderGameInfo, Lines lines) {
		this.ladderGameInfo = ladderGameInfo;
		this.lines = lines;
	}

	public String draw() {
		String playerNames = ladderGameInfo.getFormattedPlayerNames();
		String ladderLine = lines.getDisplayLines();
		String results = ladderGameInfo.getFormattedResults();
		return String.join(NEW_LINE, playerNames, ladderLine, results);
	}
}
