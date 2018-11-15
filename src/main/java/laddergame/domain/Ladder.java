package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

	public static final String NEW_LINE = System.lineSeparator();

	private LadderGameInfo ladderGameInfo;
	private List<Line> lines;

	public Ladder(LadderGameInfo ladderGameInfo, List<Line> lines) {
		this.ladderGameInfo = ladderGameInfo;
		this.lines = lines;
	}

	public String draw() {
		String playerNames = ladderGameInfo.getPlayerNames();
		String ladder = getLadder();
		String results = ladderGameInfo.getResults();
		return String.join(NEW_LINE, playerNames, ladder, results);
	}

	private String getLadder() {
		List<String> ladder = new ArrayList<>();
		for (Line line : lines) {
			ladder.add(line.draw());
		}
		return String.join(NEW_LINE, ladder);
	}
}
