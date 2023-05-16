package ladder.type;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public enum MoveType {

	LEFT(DirectionType.LEFT, i -> i - 1),
	RIGHT(DirectionType.RIGHT, i -> i + 1),
	DOWN(DirectionType.DOWN, i -> i);

	private final DirectionType directionType;
	private final UnaryOperator<Integer> unaryOperator;

	MoveType(DirectionType directionType, UnaryOperator<Integer> unaryOperator) {
		this.directionType = directionType;
		this.unaryOperator = unaryOperator;
	}

	public static MoveType of(DirectionType directionType) {
		return Arrays.stream(values())
			.filter(e -> e.directionType == directionType)
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("유효하지 않은 이동타입 입니다."));
	}

	public int move(int index) {
		return unaryOperator.apply(index);
	}
}
