package ladder.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
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
	@DisplayName("사다리 게임 참가자의 순서를 알 수 있다.")
	public void findPlayerPosition() {
		Players players = new Players("cross,apple,pla");

		assertThat(players.findPlayerPosition(new Player(new Name("cross")))).isEqualTo(1);
		assertThat(players.findPlayerPosition(new Player(new Name("apple")))).isEqualTo(2);
		assertThat(players.findPlayerPosition(new Player(new Name("pla")))).isEqualTo(3);
	}

	@Test
	@DisplayName("사다리 게임 참가자를 나열한다.")
	public void printPlayersName() {
		Players players = new Players("cross,apple,pla");

		assertThat(players.printPlayersName()).isEqualTo(" cross apple   pla");
	}

}