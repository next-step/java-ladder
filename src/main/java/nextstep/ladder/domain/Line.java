package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
	private static final int MOVE_LEFT = -1;
	private static final int NO_MOVE = 0;
	private static final int MOVE_RIGHT = 1;

	private final List<Bridge> bridges = new ArrayList<>();

	public Line(final Generator generator, final int numberOfPeople) {
		while (bridges.size() < numberOfPeople - 1){
			final boolean now = generator.generate();
			addBridge(Bridge.from(now));

		}
	}

	public int move(final int column) {
		int leftMove = checkLeftBridge(column);
		int rightMove = checkRightBridge(column);
		return leftMove != NO_MOVE ? leftMove : rightMove;
	}

	private Integer checkRightBridge(int column) {
		final Bridge rightBridge = getBridgeAtIndex(column);
		if (rightBridge.isBridge()) {
			return MOVE_RIGHT;
		}
		return NO_MOVE;
	}

	private Integer checkLeftBridge(int column) {
		final Bridge leftBridge = getBridgeAtIndex(column - 1);
		if (leftBridge.isBridge()) {
			return MOVE_LEFT;
		}
		return NO_MOVE;
	}

	private void addBridge(final Bridge now) {
		if (bridges.isEmpty()) {
			bridges.add(now);
			return;
		}
		if (getBridgeAtIndex(bridges.size() - 1).isBridge()) {
			bridges.add(Bridge.from(false));
			return;
		}
		bridges.add(now);
	}

	public List<Bridge> getBridges() {
		return bridges;
	}

	private Bridge getBridgeAtIndex(final int index) {
		if (index >= 0 && index < bridges.size()) {
			return bridges.get(index);
		}
		return Bridge.NON_BRIDGE;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Line line = (Line)o;
		return Objects.equals(bridges, line.bridges);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bridges);
	}
}
