package ladder.domain.ladder;

import ladder.domain.Participants;
import ladder.domain.line.FirstLine;
import ladder.domain.line.LastLine;
import ladder.domain.line.Line;
import ladder.domain.line.MiddleLine;
import ladder.domain.policy.PointConnectPolicy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

	private final List<Line> lines = new ArrayList<>();

	public Ladder(PointConnectPolicy policy, Participants participants, int lineHeight) {
		makeLinesHorizontally(policy, participants, lineHeight);
		makeConnectVertically();
	}

	private void makeLinesHorizontally(PointConnectPolicy policy, Participants participants, int lineHeight) {
		lines.add(new FirstLine(participants));
		for (int i = 0, end = lineHeight; i < end; i++) {
			lines.add(new MiddleLine(policy, participants));
		}
		lines.add(new LastLine(participants));
	}

	private void makeConnectVertically() {
		for (int i = 0, end = lines.size() - 1; i < end; i++) {
			getLine(i).connectLinesVertically(getNextLine(i));
		}
	}

	private Line getLine(int index) {
		return lines.get(index);
	}

	private Line getNextLine(int index) {
		return lines.get(index + 1);
	}

	public List<Line> getLines() {
		return lines;
	}

}
