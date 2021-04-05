package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.Player;
import ladder.domain.Players;

public class PlayerTest {

	@Test
	@DisplayName("정상적인 플레이어 생성")
	void generatePlayerTest() {
		Player player = new Player("pobi");
		assertThat(player).isEqualTo(new Player("pobi"));
	}

	@Test
	@DisplayName("비정상적인 플레이어 생성 : 5자 초과")
	void generatePlayerInvalidTest() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Player("pobi12");
		}).withMessage("Player Name은 최대 5자입니다.");
	}

	@Test
	@DisplayName("비정상적인 플레이어 생성 : 공백")
	void generatePlayerInvalid2Test() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			new Player(" ");
		}).withMessage("Player Name은 최소 1자 이상이어야 합니다.");
	}

	@Test
	@DisplayName("플레이어 목록 작성 테스트")
	void generatePlayersTest() {
		Players players = new Players("pobi,honux,crong,jk");
		assertThat(players.getPlayers()).containsExactly(new Player("pobi"), new Player("honux"), new Player("crong"),
			new Player("jk"));
	}

	@Test
	@DisplayName("플레이어 목록 작성 테스트2")
	void generatePlayers2Test() {
		Players players = new Players(new Player("pobi"), new Player("honux"), new Player("crong"),
			new Player("jk"));
		assertThat(players.getPlayers()).containsExactly(new Player("pobi"), new Player("honux"), new Player("crong"),
			new Player("jk"));
	}
}
