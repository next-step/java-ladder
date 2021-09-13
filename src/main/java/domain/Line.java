package domain;

import utils.PointStatusRandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

	private static final Boolean EXIST_STATUS = true;
	private static final Boolean NOT_EXIST_STATUS = false;
	private static final Integer INIT_NUMBER = 1;

	private List<Point> points = new ArrayList<>();

	public Line(int countOfPerson, PointStatusRandomGenerator generator) {
		for (int number = INIT_NUMBER; number < countOfPerson; ++number) {
			points.add(new Point(generator.randomStatus()));
		}
	}

	public Integer size() {
		return points.size();
	}

	public boolean verify(Integer index) {
		return points.get(index).status() == EXIST_STATUS;
	}
}
