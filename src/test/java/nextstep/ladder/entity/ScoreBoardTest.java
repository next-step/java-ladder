package nextstep.ladder.entity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import nextstep.ladder.utils.StringUtils;

public class ScoreBoardTest {
	@Test
	void ScoreBoard_test() {
		// given
		Users users = new Users("j,y,b");
		PrizeResult prizeResult = new PrizeResult("1000,10000,꽝", users.getUsers().size());

		// when
		ScoreBoard board = new ScoreBoard(users, prizeResult);

		// then
		assertAll(
			() -> {
				assertThat(board.getPrizeResultStr("j").getName())
					.isEqualTo("1000");
			},
			() -> {
				assertThat(board.getPrizeResultStr("y").getName())
					.isEqualTo("10000");
			},
			() -> {
				assertThat(board.getPrizeResultStr("b").getName())
					.isEqualTo("꽝");
			},
			() -> {
				String all = StringUtils.joining("j : 1000\n", "y : 10000\n", "b : 꽝");
				assertThat(board.getAllResult())
					.isEqualTo(all);
			}
		);
	}
}
