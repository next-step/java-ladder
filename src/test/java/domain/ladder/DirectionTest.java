package domain.ladder;

import domain.point.Direction;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by hspark on 20/11/2018.
 */
public class DirectionTest {

	@Test
	public void test_첫번째방향_생성() {
		Direction direction = Direction.first(true);
		Assertions.assertThat(direction.isRight()).isTrue();
	}

	@Test
	public void test_두번째방향_생성() {
		Direction direction = Direction.first(true).next(false);
		Assertions.assertThat(direction.isLeft()).isTrue();
	}

	@Test
	public void test_마지막방향() {
		Direction direction = Direction.first(true).next(false).last();
		Assertions.assertThat(direction.isLeft()).isFalse();
		Assertions.assertThat(direction.isRight()).isFalse();
	}
}