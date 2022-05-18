package step2.domain.ladder;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Point {

	private static final Map<Direction, Point> CACHE = new EnumMap<Direction, Point>(
		Arrays.stream(Direction.values())
			.collect(Collectors.toMap(value -> value, Point::new))
	);

	private final Direction direction;

	private Point(Direction direction) {
		this.direction = direction;
	}

	public static Point from(Direction direction) {
		Validator.notNull(direction, ErrorTarget.DIRECTION);
		return CACHE.get(direction);
	}

	public static Point firstPointFrom(BooleanSupplier supplier) {
		Validator.notNull(supplier, ErrorTarget.SUPPLIER);
		if (supplier.getAsBoolean()) {
			return CACHE.get(Direction.STRAIGHT);
		}
		return CACHE.get(Direction.RIGHT);
	}

	public static Point middlePointFrom(Point previousPoint, BooleanSupplier supplier) {
		Validator.notNull(previousPoint, ErrorTarget.PREVIOUS_POINT);
		Validator.notNull(supplier, ErrorTarget.SUPPLIER);

		if (previousPoint.equals(CACHE.get(Direction.RIGHT))) {
			return CACHE.get(Direction.LEFT);
		}

		if (supplier.getAsBoolean()) {
			return CACHE.get(Direction.STRAIGHT);
		}

		return CACHE.get(Direction.RIGHT);
	}

	public static Point lastPointFrom(Point previousPoint) {
		Validator.notNull(previousPoint, ErrorTarget.PREVIOUS_POINT);
		if (previousPoint.equals(CACHE.get(Direction.RIGHT))) {
			return CACHE.get(Direction.LEFT);
		}
		return CACHE.get(Direction.STRAIGHT);
	}

	@Override
	public String toString() {
		return this.direction.toString();
	}
}
