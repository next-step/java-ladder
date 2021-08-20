package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lines {

	private final List<Line> ladder;

	public Lines(List<Line> ladder) {
		this.ladder = Collections.unmodifiableList(ladder);
	}

	public List<Line> getLadder() {
		return ladder;
	}

	public int findResultPosition(int position) {
		for (Line line : ladder) {
			position = line.move(position);
		}
		return position;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Lines lines1 = (Lines)o;
		return Objects.equals(ladder, lines1.ladder);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ladder);
	}
}
