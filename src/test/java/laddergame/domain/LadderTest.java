package laddergame.domain;

import static java.util.Arrays.asList;
import static laddergame.domain.Direction.LEFT;
import static laddergame.domain.Direction.RIGHT;
import static laddergame.domain.Direction.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

public class LadderTest {

	private Ladder ladder;

	@Before
	public void setUp() {
		Player player1 = new Player("pobi");
		Player player2 = new Player("honux");
		Player player3 = new Player("crong");
		Player player4 = new Player("jk");
		Result result1 = new Result("꽝");
		Result result2 = new Result("5000");
		Result result3 = new Result("꽝");
		Result result4 = new Result("3000");
		Line line1 = Line.from(
				asList(Point.from(RIGHT), Point.from(LEFT), Point.from(RIGHT), Point.from(LEFT)));
		Line line2 = Line.from(
				asList(Point.from(STRAIGHT), Point.from(RIGHT), Point.from(LEFT), Point.from(STRAIGHT)));
		Line line3 = Line.from(
				asList(Point.from(RIGHT), Point.from(LEFT), Point.from(STRAIGHT), Point.from(STRAIGHT)));
		Line line4 = Line.from(
				asList(Point.from(STRAIGHT), Point.from(RIGHT), Point.from(LEFT), Point.from(STRAIGHT)));
		Line line5 = Line.from(
				asList(Point.from(RIGHT), Point.from(LEFT), Point.from(RIGHT), Point.from(LEFT)));

		ladder = new Ladder(
				new LadderGameInfo(
						asList(player1, player2, player3, player4),
						asList(result1, result2, result3, result4)
				),
				Lines.from(asList(line1, line2, line3, line4, line5))
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
		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(ladder.start("pobi")).isEqualTo("꽝");
		softAssertions.assertThat(ladder.start("honux")).isEqualTo("3000");
		softAssertions.assertThat(ladder.start("crong")).isEqualTo("꽝");
		softAssertions.assertThat(ladder.start("jk")).isEqualTo("5000");
		softAssertions.assertAll();
	}
}
