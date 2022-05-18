package step2.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Line {

	private static final int NUMBER_OF_FIRST_AND_LAST = 2;

	private final List<Point> points = new ArrayList<>();

	public Line(int numberOfPlayer, BooleanSupplier supplier) {
		Validator.notNull(supplier, ErrorTarget.SUPPLIER);
		Validator.min(NUMBER_OF_FIRST_AND_LAST, numberOfPlayer,
			String.format("첫 라인과 마지막 라인을 그리기위한 플레이어의 최소 수는 %d 입니다. 입력 : %d", NUMBER_OF_FIRST_AND_LAST, numberOfPlayer));

		points.add(Point.firstPointFrom(supplier));
		for (int i = 0; i < numberOfPlayer - NUMBER_OF_FIRST_AND_LAST; i++) {
			points.add(Point.middlePointFrom(getLatestInsertedPoint(), supplier));
		}
		points.add(Point.lastPointFrom(getLatestInsertedPoint()));
	}

	public Line(List<Direction> directions) {
		Validator.notNull(directions, ErrorTarget.DIRECTION_LIST);

		List<Point> values = directions.stream()
			.map(Point::from)
			.collect(Collectors.toList());

		this.points.addAll(values);
	}

	private Point getLatestInsertedPoint() {
		if (this.points.isEmpty()) {
			throw new IllegalStateException("가로 라인이 비어있습니다.");
		}
		return this.points.get(this.points.size() - 1);
	}

	public List<Point> getPoints() {
		return points;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Line line = (Line)o;
		return Objects.equals(points, line.points);
	}

	@Override
	public int hashCode() {
		return Objects.hash(points);
	}
}
