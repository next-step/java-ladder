package laddergame.domain.result;

import java.util.List;
import java.util.stream.Collectors;
import laddergame.domain.LadderGameInfo;
import laddergame.domain.player.Player;
import laddergame2.domain.LadderLine;
import laddergame2.domain.LadderLines;
import laddergame2.domain.Point;

public class DisplayLadder {

	public static final String NEW_LINE = System.lineSeparator();
	public static final String VERTICAL_CHARACTER = "|";
	public static final String HORIZON_CHARACTER = "-";
	public static final String EMPTY_CHARACTER = " ";

	private LadderGameInfo ladderGameInfo;
	private LadderLines ladderLines;

	public DisplayLadder(LadderGameInfo ladderGameInfo, LadderLines ladderLines) {
		this.ladderGameInfo = ladderGameInfo;
		this.ladderLines = ladderLines;
	}

	public String draw() {
		String playerNames = ladderGameInfo.getFormattedPlayerNames();
		String ladderLine = drawLadder(ladderLines.getLadderLines());
		String results = ladderGameInfo.getFormattedResults();
		return String.join(NEW_LINE, playerNames, ladderLine, results);
	}

	private String drawLadder(List<LadderLine> ladderLines) {
		return ladderLines.stream()
				.map(ladderLine -> drawLadderLine(ladderLine))
				.collect(Collectors.joining(NEW_LINE));
	}

	private String drawLadderLine(LadderLine ladderLine) {
		StringBuilder line = new StringBuilder();
		for (Point point : ladderLine.getPoints()) {
			String lineCharacter = point.isLeft()? HORIZON_CHARACTER : EMPTY_CHARACTER;
			line.append(drawPoint(lineCharacter)).append(VERTICAL_CHARACTER);
		}
		return line.toString();
	}

	private String drawPoint(String displayCharacter) {
		StringBuilder lineCharacters = new StringBuilder();
		for (int count = 0; count < Player.MAX_NAME_LENGTH; count++) {
			lineCharacters.append(displayCharacter);
		}
		return lineCharacters.toString();
	}
}
