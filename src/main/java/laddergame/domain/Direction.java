package laddergame.domain;

import java.util.Arrays;

public enum Direction {
	LEFT(-1),
	STRAIGHT(0),
	RIGHT(1);

	private int index;

	Direction(int index) {
		this.index = index;
	}

	public static Direction from(RandomDirectionStrategy randomDirectionStrategy) {
		int randomDirectionIndex = randomDirectionStrategy.random();
		return from(randomDirectionIndex);
	}

	public static Direction from(int index) {
		return Arrays.stream(Direction.values())
				.filter(direction -> direction.isSameIndex(index))
				.findFirst()
				.orElse(STRAIGHT);
	}

	private boolean isSameIndex(int index) {
		return this.index == index;
	}

	/**
	 * 1 -> -1
	 * -1 -> 1
	 * 0 -> 0
	 * @return
	 */
	public Direction getOppositeDirection() {
		return from(index * -2 + index);
	}

//	public static Direction from(Direction direction) {
//		if(direction == STRAIGHT) {
//		}
//	}

	public int move(int index) {
		return index + this.index;
	}
}
