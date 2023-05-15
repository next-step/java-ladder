package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ladder.strategy.PointGenerator;

public class Crosses {

	private final List<Cross> crosses;

	public static Crosses of(Boolean... points) {
		List<Cross> crosses = new ArrayList<>();

		Point point = Point.first(points[0]);
		crosses.add(new Cross(0, point));
		for (int i = 1; i < points.length; i++) {
			point = point.next(points[i]);
			crosses.add(new Cross(i, point));
		}
		crosses.add(new Cross(points.length, point.last()));

		return new Crosses(crosses);
	}

	public static Crosses of(Names names, PointGenerator pointGenerator) {
		List<Cross> crosses = new ArrayList<>();

		Point point = Point.first(pointGenerator.point());
		crosses.add(new Cross(0, point));
		for (int i = 1; i < names.countOfPerson() - 1; i++) {
			point = point.next(point.nextPoint(pointGenerator));
			crosses.add(new Cross(i, point));
		}
		crosses.add(new Cross(names.countOfPerson() - 1, point.last()));

		return new Crosses(crosses);
	}

	private Crosses(List<Cross> crosses) {
		this.crosses = crosses;
	}

	public int move(int index) {
		return this.crosses.get(index).move();
	}

	public List<Cross> getCrosses() {
		return this.crosses;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Crosses crosses1 = (Crosses)o;
		return Objects.equals(crosses, crosses1.crosses);
	}

	@Override
	public int hashCode() {
		return Objects.hash(crosses);
	}
}
