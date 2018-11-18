package laddergame.domain;

import static java.util.Arrays.asList;
import static laddergame.domain.Direction.LEFT;
import static laddergame.domain.Direction.RIGHT;
import static laddergame.domain.Direction.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class LadderTest {

	private Ladder ladder;

	@Before
	public void setUp() {
		ladder = new Ladder(
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
	}

	@Test
	public void 사다리_문자열_생성() {
		assertThat(ladder.draw())
				.isEqualTo(" pobi honux crong    jk\n"
						 + "     |-----|     |-----|\n"
						 + "     |     |-----|     |\n"
				         + "     |-----|     |     |\n"
				         + "     |     |-----|     |\n"
				         + "     |-----|     |-----|\n"
						 + "    꽝  5000     꽝  3000");
	}

	@Test
	public void 플레이어의_결과_확인() {
		assertResult(ladder.start("pobi"), "꽝");
		assertResult(ladder.start("honux"), "3000");
		assertResult(ladder.start("honux"), "3000");
		assertResult(ladder.start("crong"), "꽝");
		assertResult(ladder.start("jk"), "5000");
	}

	private void assertResult(LadderResult ladderResult, String expected) {
		assertThat(ladderResult.getResult()).isEqualTo(expected);
	}
}
