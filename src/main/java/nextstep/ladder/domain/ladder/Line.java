package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.linestrategy.LineGenerator;

public class Line {

	private List<Boolean> points = new ArrayList<>();

	public Line (int length, LineGenerator lineGenerator) {
		IntStream.range(0, length - 1)
			.forEach(index -> addPoint(index, lineGenerator));
	}

	public List<Boolean> getPoints() {
		return points;
	}

	public int getNextPoint(int index) {
		if (hasLeftLine(index)) {
			return index - 1;
		}

		if (hasRightLine(index)) {
			return index + 1;
		}

		return index;
	}

	public Boolean hasRightLine(int index) {
		return index != points.size() && points.get(index);
	}

	public Boolean hasLeftLine(int index) {
		return index != 0 && points.get(index - 1);
	}

	public Boolean hasLine(int index) {
		return hasLeftLine(index) || hasRightLine(index);
	}

	private void addPoint(int index, LineGenerator lineGenerator) {
		points.add(lineGenerator.generatePoint(index, this));
	}
}