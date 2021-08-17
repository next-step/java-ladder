package ladder.service;

import java.util.List;

import ladder.model.Direction;

public class LadderMove {

	public static final int MOVE_POINT = 1;

	public static int move(int position, List<Boolean> points) {
		boolean left = points.get(position);
		boolean right = false;
		if (position < points.size() - MOVE_POINT) {
			right = points.get(position + MOVE_POINT);
		}
		return Direction.movePosition(left, right, position);
	}
}
