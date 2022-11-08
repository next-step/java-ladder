package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * Created by seungwoo.song on 2022-11-01
 */
class PointTest {

	@Test
	void 생성_최초() {
		assertThat(Point.first(true)).isEqualTo(Point.of(0, Direction.RIGHT));
	}
	
	@Test
	void 생성_다음() {
		Point point = Point.first(true)
			.next(false)
			.next(true);

		assertThat(point).isEqualTo(Point.of(2, Direction.RIGHT));
	}

	@Test
	void 생성_마지막() {
		Point point = Point.first(true).last();
		assertThat(point).isEqualTo(Point.of(1, Direction.LEFT));
	}

	@Test
	void 이동_오른쪽() {
		int index = Point.of(5, Direction.LEFT).move();
		assertThat(index).isEqualTo(4);
	}

	@Test
	void 이동_왼쪽() {
		int index = Point.of(5, Direction.RIGHT).move();
		assertThat(index).isEqualTo(6);
	}

	@Test
	void 이동_없음() {
		int index = Point.of(5, Direction.NONE).move();
		assertThat(index).isEqualTo(5);
	}

	@Test
	void invalid() {
		assertThatIllegalArgumentException().isThrownBy(() -> Point.of(-1, Direction.LEFT));
	}
}