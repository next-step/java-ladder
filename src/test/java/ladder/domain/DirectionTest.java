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
	void 처음_오른쪽() {
		Direction direction = Direction.first(true);
		assertThat(direction).isEqualTo(Direction.RIGHT);
	}

	@Test
	void 처음_이동없음() {
		Direction direction = Direction.first(false);
		assertThat(direction).isEqualTo(Direction.NONE);
	}

	@Test
	void 다음_오른쪽() {
		Direction direction = Direction.first(false).next(() -> true);
		assertThat(direction).isEqualTo(Direction.RIGHT);
	}

	@Test
	void 다음_왼쪽() {
		Direction direction = Direction.first(true).next(() -> false);
		assertThat(direction).isEqualTo(Direction.LEFT);
	}

	@Test
	void 다음_왼쪽2() {
		Direction direction = Direction.first(true).next(() -> true);
		assertThat(direction).isEqualTo(Direction.LEFT);
	}

	@Test
	void 다음_이동없음() {
		Direction direction = Direction.of(false, false).next(() -> false);
		assertThat(direction).isEqualTo(Direction.NONE);
	}

	@Test
	void 마지막() {
		Direction direction = Direction.first(true).last();
		assertThat(direction).isEqualTo(Direction.LEFT);
	}

	@Test
	void 판단_왼쪽() {
		assertThat(Direction.LEFT.isLeft()).isTrue();
	}

	@Test
	void 판단_오른쪽() {
		assertThat(Direction.RIGHT.isRight()).isTrue();
	}

	@Test
	void invalid() {
		assertThatIllegalArgumentException().isThrownBy(() -> Direction.of(true, true));
	}
}