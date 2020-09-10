package ladder.domain.ladder;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import ladder.domain.line.LadderLine;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ladder {
	private final List<LadderLine> lines;

	public static Ladder of(List<LadderLine> lines) {
		return new Ladder(lines);
	}

	public LadderLine getLine(int index) {
		return lines.get(index);
	}

	public int getHeight() {
		return lines.size();
	}

	public int play(int indexOfUser) {
		for (int i = 0; i < lines.size(); i++) {
			indexOfUser = lines.get(i).move(indexOfUser);
		}
		return indexOfUser;
	}
}
