package step2.domain.ladder;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

import step2.util.Validator;

public class Point {

	private static final int THRESHOLD = 5;
	private static final Map<Direction, Point> CACHE = new EnumMap<Direction, Point>(
		Arrays.stream(Direction.values())
			.collect(Collectors.toMap(value -> value, Point::new))
	);

	private final Direction direction;

	private Point(Direction direction) {
		this.direction = direction;
	}

	public static Point from(Direction direction) {
		Validator.notNull(direction);
		return CACHE.get(direction);
	}

	public static Point firstPointFrom(IntSupplier supplier) {
		Validator.notNull(supplier);
		if (supplier.getAsInt() < THRESHOLD) {
			return CACHE.get(Direction.STRAIGHT);
		}
		return CACHE.get(Direction.RIGHT);
	}

	public static Point middlePointFrom(Point previousPoint, IntSupplier supplier) {
		Validator.notNull(previousPoint);
		Validator.notNull(supplier);

		if (previousPoint.equals(CACHE.get(Direction.RIGHT))) {
			return CACHE.get(Direction.LEFT);
		}

		if (supplier.getAsInt() < THRESHOLD) {
			return CACHE.get(Direction.STRAIGHT);
		}

		return CACHE.get(Direction.RIGHT);
	}

	public static Point lastPointFrom(Point previousPoint) {
		Validator.notNull(previousPoint);
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
