package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.exception.MinimumPlayersException;

class PlayersTest {
	@DisplayName(value = "게임 참가자를 생성")
	@Test
	void createPlayers() {
		String inputNames = "1,2,3,4,5";
		int expect = 5;

		Players players = new Players(inputNames);
		int playersCount = players.count();

		assertThat(playersCount).isEqualTo(5);
	}

	@DisplayName(value = "게임 참가자가 2인 미만이면 예외를 던짐")
	@Test
	void checkMinimumPlayers() {
		assertThatThrownBy(() -> new Players("1"))
			.isInstanceOf(MinimumPlayersException.class);
	}
}