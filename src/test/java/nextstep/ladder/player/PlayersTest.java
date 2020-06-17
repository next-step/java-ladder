package nextstep.ladder.player;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayersTest {

	@DisplayName("참여하는 플레이어가 1명 미만이면 오류를 반환한다.")
	@Test
	void 참여하는_플레이어가_1명_미만이면_오류를_반환한다() {
		assertThatThrownBy(
			() -> Players.ofPlayers(Collections.emptyList())
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("참여하는 플레이어의 이름이 중복되면 오류를 반환한다.")
	@Test
	void 참여하는_플레이어의_이름이_중복되면_오류를_반환한다() {
		List<Player> players = Arrays.asList(Player.ofPlayer("pobi"), Player.ofPlayer("Brian"),
			Player.ofPlayer("Brian"));
		assertThatThrownBy(
			() -> Players.ofPlayers(players)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
