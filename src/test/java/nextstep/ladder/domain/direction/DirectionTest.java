package nextstep.ladder.domain.direction;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {

	@DisplayName("첫 번째 좌표는 왼쪽으로 이동할 수 없고, 오른쪽이나 제자리로만 이동 가능하다.")
	@Test
	void 첫번째_좌표는_오른쪽이나_제자리로만_이동_가능하다() {
		Direction directionNotConnected = Direction.first(false);
		assertThat(directionNotConnected).isNotEqualTo(Direction.LEFT);

		Direction directionConnected = Direction.first(true);
		assertThat(directionConnected).isNotEqualTo(Direction.LEFT);
	}

	@DisplayName("마지막 좌표는 오른쪽으로 이동할 수 없고, 왼쪽이나 제자리로만 이동 가능하다.")
	@Test
	void 마지막_좌표는_왼쪽이나_제자리로만_이동_가능하다() {
		Direction directionNotConnected = Direction.last(Direction.of(false, false));
		assertThat(directionNotConnected).isNotEqualTo(Direction.RIGHT);

		Direction directionConnected = Direction.last(Direction.of(true, false));
		assertThat(directionConnected).isNotEqualTo(Direction.RIGHT);
	}

	@DisplayName("현재 포인트가 오른쪽으로 이동하는 경우, 다음 포인트는 왼쪽으로만 이동할 수 있다.")
	@Test
	void 오른쪽으로_이동하면_다음에는_왼쪽_이동만_가능하다() {
		Direction direction = Direction.of(false, true);
		Direction next = direction.next(true);
		assertThat(next).isEqualTo(Direction.LEFT);
	}

	@DisplayName("현재 포인트가 왼쪽으로 이동하는 경우, 다음 포인트는 오른쪽 방향 또는 제자리로만 이동할 수 있다.")
	@Test
	void 왼쪽으로_이동하면_다음에는_오른쪽_이동만_가능하다() {
		Direction direction = Direction.of(true, false);
		Direction next = direction.next(true);
		assertThat(next).isEqualTo(Direction.RIGHT);

		Direction directionStay = direction.next(false);
		assertThat(directionStay).isEqualTo(Direction.STAY);
	}
}
