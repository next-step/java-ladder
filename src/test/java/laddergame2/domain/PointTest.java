package laddergame2.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PointTest {

	@Test
	public void 시작_점_생성() {
		final Boolean right = TRUE;
		Point point = Point.first(right);

		assertThat(point).isEqualTo(Point.of(0, Direction.first(right)));
	}

	@Test
	public void 다음_점_생성() {
		Point point = Point.of(0, Direction.first(TRUE));

		assertThat(point.next()).isEqualTo(Point.of(1, Direction.of(TRUE, FALSE)));
	}

	@Test
	public void 마지막_점_생성() {
		final Boolean right = TRUE;
		Point point = Point.first(right);

		assertThat(point.last()).isEqualTo(Point.of(1, Direction.of(right, FALSE)));
	}

	@Test
	public void 왼쪽_이동() {
		Point point = Point.of(1, Direction.of(TRUE, FALSE));

		assertThat(point.move()).isEqualTo(0);
	}

	@Test
	public void 오른쪽_이동() {
		Point point = Point.of(1, Direction.of(FALSE, TRUE));

		assertThat(point.move()).isEqualTo(2);
	}

	@Test
	public void 직진() {
		Point point = Point.of(1, Direction.of(FALSE, FALSE));

		assertThat(point.move()).isEqualTo(1);
	}
}