package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import nextstep.ladder.domain.movestrategy.PointStrategy;

public class Line {

	private List<Boolean> points = new ArrayList<>();

	public Line (int length, PointStrategy pointStrategy) {
		IntStream.range(0, length - 1)
			.forEach(index -> addPoint(index, pointStrategy));
	}

	public List<Boolean> getPoints() {
		return this.points;
	}

	public Boolean hasRightLine(int index) {
		return index != points.size() && !points.get(index);
	}

	public Boolean hasLeftLine(int index) {
		return index != 0 && !points.get(index - 1);
	}

	public Boolean hasEitherLine(int index){
		return hasRightLine(index) || hasLeftLine(index);}

	private void addPoint(int index, PointStrategy pointStrategy) {
		points.add(pointStrategy.isAddible(index, this));
	}
}