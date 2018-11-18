package laddergame.domain;

import static java.util.Arrays.asList;
import static laddergame.domain.Direction.LEFT;
import static laddergame.domain.Direction.RIGHT;
import static laddergame.domain.Direction.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LadderTest {

	@Test
	public void 플레이어의_결과_확인() {
		Ladder ladder = new Ladder(
				new LadderGameInfo(
						Players.fromComma("pobi,honux,crong,jk"),
						Results.fromComma("꽝,5000,꽝,3000")
				),
				Lines.from(asList(
						Line.from(asList(Point.from(RIGHT), Point.from(LEFT), Point.from(RIGHT), Point.from(LEFT))),
						Line.from(asList(Point.from(STRAIGHT), Point.from(RIGHT), Point.from(LEFT), Point.from(STRAIGHT))),
						Line.from(asList(Point.from(RIGHT), Point.from(LEFT), Point.from(STRAIGHT), Point.from(STRAIGHT))),
						Line.from(asList(Point.from(STRAIGHT), Point.from(RIGHT), Point.from(LEFT), Point.from(STRAIGHT))),
						Line.from(asList(Point.from(RIGHT), Point.from(LEFT), Point.from(RIGHT), Point.from(LEFT))))
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
