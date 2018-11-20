package laddergame2.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DirectionTest {

	@Test(expected = IllegalStateException.class)
	public void 양쪽_방향_모두_선을_가질수없다() {
		Direction.of(TRUE, TRUE);
	}

	@Test
	public void 시작방향_생성() {
		boolean right = TRUE;
		assertThat(Direction.first(right)).isEqualTo(Direction.of(FALSE, right));
	}

	@Test
	public void 다음_방향_생성() {
		Direction before = Direction.of(TRUE, FALSE);

		assertThat(before.next(TRUE)).isEqualTo(Direction.of(FALSE, TRUE));
	}

	@Test
	public void 마지막방향_생성() {
		Direction before = Direction.of(FALSE, TRUE);

		assertThat(before.last()).isEqualTo(Direction.of(TRUE, FALSE));
	}

	@Test
	public void 이전에_선이_존재할때_랜덤_방향_생성() {
		Direction before = Direction.of(FALSE, TRUE);

		assertThat(before.next()).isEqualTo(Direction.of(TRUE, FALSE));
	}

	@Test
	public void 이전에_선이_존재하지않을때_랜덤_방향_생성() {
		Direction before = Direction.of(TRUE, FALSE);

		for (int count = 0; count < 100; count++) {
			assertThat(before.next()).isIn(Direction.of(FALSE, TRUE), Direction.of(FALSE, FALSE));
		}
	}
}