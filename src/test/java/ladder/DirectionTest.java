package ladder;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import ladder.domain.playing.Direction;

public class DirectionTest {
	@Test
	public void init() {
		assertThat(Direction.of(true, false), is(Direction.of(true, false)));
	}

	@Test(expected = IllegalStateException.class)
	public void init_invalid() {
		Direction.of(TRUE, TRUE);
	}

	@Test
	public void next_random_true() {
		Direction next = Direction.first(TRUE).next();
		assertThat(next, is(Direction.of(TRUE, FALSE)));
	}

	@Test
	public void next_true() {
		Direction next = Direction.of(TRUE, FALSE).next(TRUE);
		assertThat(next, is(Direction.of(FALSE, TRUE)));
	}

	@Test
	public void next_false() {
		Direction next = Direction.of(FALSE, TRUE).next(FALSE);
		assertThat(next, is(Direction.of(TRUE, FALSE)));
	}

	@Test
	public void first() {
		Direction first = Direction.first(TRUE);
		assertThat(first.isLeft(), is(FALSE));
	}

	@Test
	public void last() {
		Direction last = Direction.first(TRUE).last();
		assertThat(last, is(Direction.of(TRUE, FALSE)));
	}

}
