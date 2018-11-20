package laddergame2.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderLinesTest {

	@Test
	public void 사다리_시작() {
		LadderLines ladderLines = new LadderLines(
				asList(
						new LadderLine(
								asList(
										Point.of(0, Direction.of(FALSE, TRUE)),
										Point.of(1, Direction.of(TRUE, FALSE)),
										Point.of(2, Direction.of(FALSE, FALSE))
								)
						),
						new LadderLine(
								asList(
										Point.of(0, Direction.of(FALSE, FALSE)),
										Point.of(1, Direction.of(FALSE, TRUE)),
										Point.of(2, Direction.of(TRUE, FALSE))
								)
						),
						new LadderLine(
								asList(
										Point.of(0, Direction.of(FALSE, TRUE)),
										Point.of(1, Direction.of(TRUE, FALSE)),
										Point.of(2, Direction.of(FALSE, FALSE))
								)
						)
				)
		);

		assertThat(ladderLines.start(0)).isEqualTo(2);
		assertThat(ladderLines.start(1)).isEqualTo(1);
		assertThat(ladderLines.start(2)).isEqualTo(0);
	}
}