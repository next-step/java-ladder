package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayersTest {

	private final Players players = Players.from("pobi,crong,honux,jk");

	@DisplayName("입력 받은 이름들로 Players 객체를 생성한다.")
	@Test
	void create() {
		assertThat(players).isEqualTo(Players.from("pobi,crong,honux,jk"));
	}

	@DisplayName("입력 받은 이름들은 콤마(,)를 기준으로 나눈다.")
	@Test
	void split() {
		assertThat(players.size()).isEqualTo(4);
	}

	@DisplayName("참가자들의 이름을 리스트로 반환한다.")
	@Test
	void names() {
		assertThat(players.names()).containsExactly("pobi", "crong", "honux", "jk");
	}


}
