package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import nextstep.ladder.model.Player;

class PlayerTest {

	@Test
	void 사용자의_이름은_5자를_넘길수_없다() {
		assertThatIllegalArgumentException().isThrownBy(() -> new Player("abcdef"))
			.withMessage("사용자의 이름은 5자를 넘을 수 없습니다");
	}

}
