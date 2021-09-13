package domain;

import utils.PointStatusRandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

	private static final Boolean EXIST_STATUS = true;
	private static final Integer INIT_NUMBER = 1;
	private static final Integer MINUS_INDEX = 2;

	private List<Point> points = new ArrayList<>();

	public Line(int countOfPerson, PointStatusRandomGenerator generator) {
		for (int number = INIT_NUMBER; number < countOfPerson; ++number) {
			points.add(generatePoint(number, generator));
		}
	}

	private Point generatePoint(int index, PointStatusRandomGenerator generator) {
		if (index == INIT_NUMBER) {
			return new Point(generator.randomStatus());
		}
		return new Point(generator.randomStatus(points.get(index - MINUS_INDEX)));
	}

	public Integer size() {
		return points.size();
	}

	public boolean verify(Integer index) {
		return points.get(index).status() == EXIST_STATUS;
	}
}
