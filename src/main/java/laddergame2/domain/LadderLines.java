package laddergame2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLines {

	private List<LadderLine> ladderLines;

	public LadderLines(List<LadderLine> ladderLines) {
		this.ladderLines = ladderLines;
	}

	public static LadderLines init(int ladderHeight, int playerCount) {
		List<LadderLine> ladderLines = new ArrayList<>();
		while (ladderLines.size() < ladderHeight) {
			ladderLines.add(LadderLine.init(playerCount));
		}
		return new LadderLines(ladderLines);
	}

	public int start(int position) {
		int resultPosition = position;
		for (LadderLine ladderLine : ladderLines) {
			resultPosition = ladderLine.move(resultPosition);
		}
		return resultPosition;
	}

	public List<LadderLine> getLadderLines() {
		return Collections.unmodifiableList(ladderLines);
	}

	@Override
	public String toString() {
		return "Ladder{" +
				"ladderLines=" + ladderLines +
				'}';
	}
}
