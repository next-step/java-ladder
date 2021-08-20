package ladder.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

	@Test
	@DisplayName("게임 결과를 생성한다.")
	public void createGameResult() {
		GameResult gameResult = new GameResult(new Player(new Name("aaa")), 2);

		assertThat(gameResult.getPosition()).isEqualTo(2);
		assertThat(gameResult.getPlayer()).isEqualTo(new Player(new Name("aaa")));
	}

}