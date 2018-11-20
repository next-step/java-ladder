package laddergame.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import laddergame.domain.player.Players;
import laddergame.domain.result.Printable;
import laddergame.domain.result.Results;
import laddergame2.domain.Direction;
import laddergame2.domain.LadderLine;
import laddergame2.domain.LadderLines;
import laddergame2.domain.Point;
import org.junit.Test;

public class LadderTest {

	@Test
	public void 플레이어의_결과_확인() {
		final List<Point> twoLine = asList(
				Point.of(0, Direction.of(FALSE, TRUE)), Point.of(1, Direction.of(TRUE, FALSE)),
				Point.of(2, Direction.of(FALSE, TRUE)), Point.of(3, Direction.of(TRUE, FALSE)));
		final List<Point> centerOneLine = asList(
				Point.of(0, Direction.of(FALSE, FALSE)), Point.of(1, Direction.of(FALSE, TRUE)),
				Point.of(2, Direction.of(TRUE, FALSE)), Point.of(3, Direction.of(FALSE, FALSE)));
		final List<Point> leftOneLine = asList(
				Point.of(0, Direction.of(FALSE, TRUE)), Point.of(1, Direction.of(TRUE, FALSE)),
				Point.of(2, Direction.of(FALSE, FALSE)), Point.of(3, Direction.of(FALSE, FALSE)));
		Ladder ladder = new Ladder(
				new LadderGameInfo(
						Players.fromComma("pobi,honux,crong,jk"),
						Results.fromComma("꽝,5000,꽝,3000")
				),

				new LadderLines(
						asList(
							new LadderLine(twoLine),
							new LadderLine(centerOneLine),
							new LadderLine(leftOneLine),
							new LadderLine(centerOneLine),
							new LadderLine(twoLine)
					)
				)
		);
		assertResult(ladder.start("pobi"), "꽝");
		assertResult(ladder.start("honux"), "3000");
		assertResult(ladder.start("honux"), "3000");
		assertResult(ladder.start("crong"), "꽝");
		assertResult(ladder.start("jk"), "5000");
	}

	private void assertResult(Printable ladderResult, String expected) {
		assertThat(ladderResult.print()).isEqualTo(expected);
	}
}
