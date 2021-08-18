package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

	@Test
	@DisplayName("사다리 게임 참가자를 생성한다. 참가자는 (,)로구분한다.")
	public void createPlayer() {
		Players players = new Players("cross,apple,pla");

		assertThat(players).isEqualTo(new Players("cross,apple,pla"));
	}

	@Test
	@DisplayName("사다리 게임 참가자가 없을시 예외가 발생된다.")
	public void checkEmptyPlayers() {
		assertThrows(IllegalArgumentException.class, () ->
			new Players("")
		);
	}

	@Test
	@DisplayName("사다리 게임 참가자를 알수있다.")
	public void printPlayersName() {
		Players resultPlayers = new Players("cross,apple,pla");

		Player player1 = new Player(new Name("cross"));
		Player player2 = new Player(new Name("apple"));
		Player player3 = new Player(new Name("pla"));

		List<Player> players = Arrays.asList(player1, player2, player3);
		assertThat(resultPlayers.getPlayers()).isEqualTo(players);
	}

	@Test
	@DisplayName("사다리 게임 참가자의 인원을 알 수 있다.")
	public void findPlayerCount() {
		Players resultPlayers = new Players("cross,apple,pla");

		assertThat(resultPlayers.findPlayerCount()).isEqualTo(3);
	}

	@Test
	@DisplayName("사다리 게임 참가자의 순서를 알 수 있다.")
	public void findPlayerPosition() {
		Players resultPlayers = new Players("cross,apple,pla");

		assertThat(resultPlayers.findPlayerPosition(new Player(new Name("cross")))).isEqualTo(0);
		assertThat(resultPlayers.findPlayerPosition(new Player(new Name("apple")))).isEqualTo(1);
		assertThat(resultPlayers.findPlayerPosition(new Player(new Name("pla")))).isEqualTo(2);
	}

}