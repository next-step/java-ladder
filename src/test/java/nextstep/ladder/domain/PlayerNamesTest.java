package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerNamesTest {

	@DisplayName("입력 받은 사다리 게임 참가자들의 이름으로 PlayerNames 객체를 생성한다.")
	@Test
	void create() {
		PlayerNames playerNames = new PlayerNames("pobi,honux,crong,jk");
		assertThat(playerNames).isEqualTo(new PlayerNames("pobi,honux,crong,jk"));
	}

	@DisplayName("입력 받은 사다리 게임 참가자들의 이름은 쉼표(,)를 기준으로 구분한다.")
	@Test
	void splitByComma() {
		PlayerNames playerNames = new PlayerNames("pobi,honux,crong,jk");
		assertThat(playerNames.size()).isEqualTo(4);
	}

}
