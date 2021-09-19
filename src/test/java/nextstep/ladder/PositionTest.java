package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.domain.Position;

public class PositionTest {

	@Test
	@DisplayName("위치가 이동될 수 있음")
	void move() {
		Position willMoveRight = new Position(0);
		assertThat(willMoveRight.move(1)).isEqualTo(new Position(1));

		Position willMoveLeft = new Position(1);
		assertThat(willMoveLeft.move(-1)).isEqualTo(new Position(0));

		assertThatThrownBy(() -> {
			new Position(-1);
		}).isExactlyInstanceOf(IllegalArgumentException.class);
	}
}
