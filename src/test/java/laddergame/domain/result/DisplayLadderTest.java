package laddergame.domain.result;

import static java.util.Arrays.asList;
import static laddergame.domain.line.Direction.LEFT;
import static laddergame.domain.line.Direction.RIGHT;
import static laddergame.domain.line.Direction.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import laddergame.domain.LadderGameInfo;
import laddergame.domain.result.DisplayLadder;
import laddergame.domain.line.Line;
import laddergame.domain.line.Lines;
import laddergame.domain.line.Point;
import laddergame.domain.player.Players;
import laddergame.domain.result.Results;
import org.junit.Test;

public class DisplayLadderTest {

	@Test
	public void 사다리_문자열_생성() {
		DisplayLadder displayLadder = new DisplayLadder(
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

		assertThat(displayLadder.draw())
				.isEqualTo(" pobi honux crong    jk\n"
						+ "     |-----|     |-----|\n"
						+ "     |     |-----|     |\n"
						+ "     |-----|     |     |\n"
						+ "     |     |-----|     |\n"
						+ "     |-----|     |-----|\n"
						+ "    꽝  5000     꽝  3000");
	}

}