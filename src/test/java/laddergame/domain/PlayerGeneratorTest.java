package laddergame.domain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PlayerGeneratorTest {

	@Test
	public void 콤마로_플레이어_생성() {
		final String player1 = "pobi";
		final String player2 = "honux";
		final String player3 = "crong";
		final String player4 = "jk";
		final String rawPlayers = String.join(",", player1, player2, player3, player4);

		assertThat(PlayerGenerator.generate(rawPlayers))
				.extracting("name").isEqualTo(asList(player1, player2, player3, player4));
	}
}