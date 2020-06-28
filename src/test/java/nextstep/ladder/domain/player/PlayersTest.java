package nextstep.ladder.domain.player;

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
		int playerSize = 3;
		List<Player> players = Arrays.asList(Player.ofNameAndPositionAndSize("pobi", 0, playerSize),
			Player.ofNameAndPositionAndSize("Brian", 1, playerSize),
			Player.ofNameAndPositionAndSize("Brian", 2, playerSize)
		);
		assertThatThrownBy(
			() -> Players.ofPlayers(players)
		).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("참여하는 플레이어의 수보다 플레이어의 인덱스가 더 높으면 오류를 반환한다.")
	@Test
	void 플레이어의_위치가_전체_플레이어의_인덱스를_넘어가면_오류를_반환한다() {
		int playersSize = 3;
		assertThatThrownBy(
			() -> Player.ofNameAndPositionAndSize("pobi", 5, playersSize)
		).isInstanceOf(IllegalArgumentException.class);
	}
}
