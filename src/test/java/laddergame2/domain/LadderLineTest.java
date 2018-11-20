package laddergame2.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderLineTest {

	@Test
	public void 왼쪽_이동() {
		LadderLine ladderLine = new LadderLine(
				asList(
						Point.of(0, Direction.of(FALSE, TRUE)),
						Point.of(1, Direction.of(TRUE, FALSE)),
						Point.of(2, Direction.of(FALSE, FALSE))
				));

		assertThat(ladderLine.move(1)).isEqualTo(0);
	}

	@Test
	public void 오른쪽_이동() {
		LadderLine ladderLine = new LadderLine(
				asList(
						Point.of(0, Direction.of(FALSE, FALSE)),
						Point.of(1, Direction.of(FALSE, TRUE)),
						Point.of(2, Direction.of(TRUE, FALSE))
				));

		assertThat(ladderLine.move(1)).isEqualTo(2);
	}

	@Test
	public void 직진() {
		LadderLine ladderLine = new LadderLine(
				asList(
						Point.of(0, Direction.of(FALSE, FALSE)),
						Point.of(1, Direction.of(FALSE, FALSE)),
						Point.of(2, Direction.of(FALSE, FALSE))
				));

		assertThat(ladderLine.move(1)).isEqualTo(1);
	}
}
