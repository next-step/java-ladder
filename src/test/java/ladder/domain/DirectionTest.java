package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by seungwoo.song on 2022-11-01
 */
class DirectionTest {

	@Test
	void 왼쪽() {
		Direction direction = Direction.of(true, false);
		assertThat(direction).isEqualTo(Direction.LEFT);
	}

	@Test
	void 오른쪽() {
		Direction direction = Direction.of(false, true);
		assertThat(direction).isEqualTo(Direction.RIGHT);
	}

	@Test
	void 이동없음() {
		Direction direction = Direction.of(false, false);
		assertThat(direction).isEqualTo(Direction.NONE);
	}

	@Test
	void 다음_오른쪽() {
		Direction direction = Direction.of(false, false);
		assertThat(direction.next(true)).isEqualTo(Direction.RIGHT);
	}

	@Test
	void 다음_왼쪽() {
		Direction direction = Direction.of(false, true);
		assertThat(direction.next(false)).isEqualTo(Direction.LEFT);
	}

	@Test
	void 다음_이동없음() {
		Direction direction = Direction.of(false, false);
		assertThat(direction.next(false)).isEqualTo(Direction.NONE);
	}

	@Test
	void invalid() {
		assertThatIllegalArgumentException().isThrownBy(() -> Direction.of(true, true));
	}
}