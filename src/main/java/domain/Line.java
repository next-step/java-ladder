package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

	private static final Boolean EXIST_STATUS = true;
	private static final Boolean NOT_EXIST_STATUS = false;
	private static final Integer INIT_NUMBER = 1;

	private List<Boolean> points = new ArrayList<>();

	public Line(int countOfPerson) {
		for (int number = INIT_NUMBER; number < countOfPerson; ++number) {
			points.add(EXIST_STATUS);
		}
	}

	public Integer size() {
		return points.size();
	}

	public boolean verify(Integer index) {
		return points.get(index) == EXIST_STATUS;
	}
}
