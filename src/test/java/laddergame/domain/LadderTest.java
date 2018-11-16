package laddergame.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class LadderTest {

	@Test
	public void 사다리_문자열_생성() {
		Player player1 = new Player("pobi");
		Player player2 = new Player("honux");
		Player player3 = new Player("crong");
		Player player4 = new Player("jk");
		Result result1 = new Result("꽝");
		Result result2 = new Result("5000");
		Result result3 = new Result("꽝");
		Result result4 = new Result("3000");
		Line line1 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
		Line line2 = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line3 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
		Line line4 = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line5 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));

		Ladder ladder = new Ladder(
				new LadderGameInfo(
						asList(player1, player2, player3, player4),
						asList(result1, result2, result3, result4)
				),
				asList(line1, line2, line3, line4, line5)
		);

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
		Player player1 = new Player("pobi");
		Player player2 = new Player("honux");
		Player player3 = new Player("crong");
		Player player4 = new Player("jk");
		Result result1 = new Result("꽝");
		Result result2 = new Result("5000");
		Result result3 = new Result("꽝");
		Result result4 = new Result("3000");
		Line line1 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));
		Line line2 = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line3 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.FALSE));
		Line line4 = new Line(asList(Boolean.FALSE, Boolean.FALSE, Boolean.TRUE, Boolean.FALSE));
		Line line5 = new Line(asList(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE));

		Ladder ladder = new Ladder(
				new LadderGameInfo(
						asList(player1, player2, player3, player4),
						asList(result1, result2, result3, result4)
				),
				asList(line1, line2, line3, line4, line5)
		);

		SoftAssertions softAssertions = new SoftAssertions();
		softAssertions.assertThat(ladder.start("pobi")).isEqualTo("꽝");
		softAssertions.assertThat(ladder.start("honux")).isEqualTo("3000");
		softAssertions.assertThat(ladder.start("crong")).isEqualTo("꽝");
		softAssertions.assertThat(ladder.start("jk")).isEqualTo("5000");
		softAssertions.assertAll();
	}
}
