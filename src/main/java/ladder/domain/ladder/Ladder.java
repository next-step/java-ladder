package ladder.domain.ladder;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import ladder.domain.line.Line;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ladder {
	private final List<Line> lines;

	public static Ladder of(List<Line> lines) {
		return new Ladder(lines);
	}

	public Line getLine(int index) {
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
