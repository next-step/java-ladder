package nextstep.ladder.entity;

import java.util.Arrays;
import java.util.function.Function;

public enum PositionMoveMatch {

	NOT_MOVE((root, rootIndex, position) -> !root.getRoot(), Position::new),
	MOVE_RIGHT((root, rootIndex, position) -> root.getRoot() && rootIndex.equals(position.getPosition()), Position::moveRight),
	MOVE_LEFT((root, rootIndex, position) -> root.getRoot() && rootIndex + 1 == position.getPosition(), Position::moveLeft),
	DEFAULT((root, rootIndex, position) -> true, Position::new);

	private final TriFunction<Root, Integer, Position, Boolean> condition;
	private final Function<Position, Position> resultFunc;

	PositionMoveMatch(TriFunction<Root, Integer, Position, Boolean> condition, Function<Position, Position> resultFunc) {
		this.condition = condition;
		this.resultFunc = resultFunc;
	}

	public static Position getMatchPosition(Root root, int rootIndex, Position position) {
		return Arrays.stream(values())
			.filter(match -> match.condition.apply(root, rootIndex, position))
			.findFirst()
			.orElse(DEFAULT)
			.resultFunc
			.apply(position);
	}
}
