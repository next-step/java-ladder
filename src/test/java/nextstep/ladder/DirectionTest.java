package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Position;

public class DirectionTest {
	@Test
	@DisplayName("왼쪽 이동")
	void left() {
		Position position = new Position(5);
		Position newPosition = Direction.LEFT.apply(position);
		assertThat(newPosition).isEqualTo(new Position(4));
	}

	@Test
	@DisplayName("오른쪽 이동")
	void right() {
		Position position = new Position(5);
		Position newPosition = Direction.RIGHT.apply(position);
		assertThat(newPosition).isEqualTo(new Position(6));
	}

	@Test
	@DisplayName("멈춤")
	void stop() {
		Position position = new Position(5);
		Position newPosition = Direction.NOTHING.apply(position);
		assertThat(newPosition).isEqualTo(new Position(5));
	}
}
