package laddergame.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PlayersTest {

	private Players players;

	@Before
	public void setUp() {
		players = Players.fromComma("pobi,crong");
	}

	@Test
	public void 콤마로_객체_생성() {
		assertThat(players)
				.extracting("players")
				.containsExactly(asList(new Player("pobi"), new Player("crong")));
	}

	@Test
	public void 플레이어명으로_위치_찾기() {
		final String playerName = "crong";
		assertThat(players.findPlayerIndex(playerName)).isEqualTo(1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void 플레이어명으로_위치_찾기_실패() {
		final String playerName = "cro";
		assertThat(players.findPlayerIndex(playerName)).isEqualTo(1);
	}

	@Test
	public void 위치로_플레이어_찾기() {
		final int playerIndex = 1;
		assertThat(players.findPlayer(playerIndex)).isEqualTo(new Player("crong"));
	}
}