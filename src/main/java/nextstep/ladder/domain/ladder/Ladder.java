package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.linestrategy.LineGenerator;

public class Ladder {

	private List<Line> ladder = new ArrayList<>();

	public Ladder(List<Line> ladder) {
		this.ladder = ladder;
	}

	public Ladder(int length, int height, LineGenerator lineGenerator) {
		IntStream.range(0, height)
			.forEach(count -> ladder.add(new Line(length, lineGenerator)));
	}

	public List<Line> getLadder() {
		return ladder;
	}

	public int getEnd(int start) {
		for (Line line : ladder) {
			start = line.getNextPoint(start);
		}
		return start;
	}
}
