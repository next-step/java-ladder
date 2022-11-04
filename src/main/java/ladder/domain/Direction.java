package ladder.domain;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.function.BooleanSupplier;
import java.util.stream.Stream;

/**
 * Created by seungwoo.song on 2022-11-01
 */
public enum Direction {

	LEFT(true, false),
	RIGHT(false, true),
	NONE(false, false);

	private final boolean left;
	private final boolean right;

	Direction(boolean left, boolean right) {
		this.left = left;
		this.right = right;
	}

	public static Direction of(boolean left, boolean right) {
		if (left && right) {
			throw new IllegalArgumentException("left right 모두 true 일 수 없습니다");
		}

		return Stream.of(values())
			.filter(e -> e.left == left && e.right == right)
			.findAny()
			.get();
	}

	public static Direction first(boolean right) {
		return of(false, right);
	}

	public Direction last() {
		return of(right, false);
	}

	public Direction next(BooleanSupplier booleanSupplier) {
		if (right) {
			return Direction.LEFT;
		}

		return next(booleanSupplier.getAsBoolean());
	}

	private Direction next(boolean next) {
		return Direction.of(right, next);
	}

	public boolean isLeft() {
		return this == Direction.LEFT;
	}

	public boolean isRight() {
		return this == Direction.RIGHT;
	}
}
