package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-25
 */
class LadderGameTest {

	@Test
	void 생성() {
		Ladder ladder = new Ladder(List.of(new LadderRow(2, () -> true)));

		Person person = new Person("a", 0);

		LadderGameResults results = LadderGameResults.of(List.of("꽝", "1000"));

		LadderGame game = new LadderGame();
		LadderGameResult result = game.start(ladder, results, person);

		assertThat(result.getValue()).isEqualTo("1000");
	}
}