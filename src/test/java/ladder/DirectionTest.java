package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import ladder.domain.playing.Direction;

public class DirectionTest {

	@Test
	public void directionMovingTest() {
		Direction right = Direction.RIGHT;
		assertThat(right.move(1)).isEqualTo(2);

		Direction left = Direction.LEFT;
		assertThat(left.move(10)).isEqualTo(9);

		Direction straight = Direction.STRAIGHT;
		assertThat(straight.move(7)).isEqualTo(7);
	}
}
