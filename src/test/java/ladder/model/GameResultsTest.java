package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultsTest {

	@Test
	@DisplayName("결과값을 입력후 특정 플레이어를 입력하면 결과를 알수 있다.")
	public void findResultOfPerson() {
		GameResults gameResults = new GameResults(getGameResult());

		Player player1 = new Player(new Name("cross"));
		List<GameResult> testResult = new ArrayList<>();
		testResult.add(new GameResult(player1, 1));

		assertThat(gameResults.findResultOfPerson("cross")).isEqualTo(testResult);
		assertThat(gameResults.findResultOfPerson("cross")).extracting("position").containsExactly(1);
		assertThat(gameResults.findResultOfPerson("cross")).extracting("player").containsExactly(player1);
	}

	@Test
	@DisplayName("결과값을 입력후 all 을 입력하면 결과를 알수 있다.")
	public void findResultAll() {
		GameResults gameResults = new GameResults(getGameResult());

		Player player1 = new Player(new Name("cross"));
		Player player2 = new Player(new Name("pie"));
		Player player3 = new Player(new Name("kim"));

		assertThat(gameResults.findResultOfPerson("all")).isEqualTo(getGameResult());
		assertThat(gameResults.findResultOfPerson("all")).extracting("position").containsExactly(1, 2, 0);
		assertThat(gameResults.findResultOfPerson("all")).extracting("player")
			.containsExactly(player1, player2, player3);
	}

	@Test
	@DisplayName("결과값에 없는 플레이어를 입력하면 예외가 발생된다.")
	public void checkEmptyName() {
		GameResults gameResults = new GameResults(getGameResult());
		assertThrows(IllegalArgumentException.class, () ->
			gameResults.findResultOfPerson("test")
		);
	}

	private List<GameResult> getGameResult() {
		List<GameResult> gameResults = new ArrayList<>();
		gameResults.add(new GameResult(new Player(new Name("cross")), 1));
		gameResults.add(new GameResult(new Player(new Name("pie")), 2));
		gameResults.add(new GameResult(new Player(new Name("kim")), 0));
		return gameResults;
	}

}