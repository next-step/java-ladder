package nextstep.ladder.entity;

import java.util.Arrays;
import java.util.function.Function;

public enum PositionMoveMatch {

	NOT_MOVE((root, rootIndex, position) -> !root.getRoot(), Position::new),
	MOVE_RIGHT((root, rootIndex, position) -> root.getRoot() && rootIndex.equals(position), (position) -> new Position(position + 1)),
	MOVE_LEFT((root, rootIndex, position) -> root.getRoot() && rootIndex + 1 == position, (position) -> new Position(position - 1)),
	DEFAULT((root, rootIndex, position) -> true, Position::new);

	private final TriFunction<Root, Integer, Integer, Boolean> condition;
	private final Function<Integer, Position> resultFunc;

	PositionMoveMatch(TriFunction<Root, Integer, Integer, Boolean> condition, Function<Integer, Position> resultFunc) {
		this.condition = condition;
		this.resultFunc = resultFunc;
	}

	public static Position getMatchPosition(Root root, int rootIndex, int position) {
		return Arrays.stream(values())
			.filter(match -> match.condition.apply(root, rootIndex, position))
			.findFirst()
			.orElse(DEFAULT)
			.resultFunc
			.apply(position);
	}
}
