package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.exception.InvalidNameLengthException;

class PlayerTest {

	@DisplayName("사다리 게임 참가자 이름을 포장하는 Player 객체를 생성한다.")
	@Test
	void create() {
		Player player = new Player("pobi");
		assertThat(player).isEqualTo(new Player("pobi"));
	}

	@DisplayName("사다리 게임에 참여하는 사람의 이름의 길이는 1글자 이상 5글자 이하여야 한다.")
	@ValueSource(strings = {"", "ladder"})
	@ParameterizedTest
	void invalidLength(String name) {
		assertThatThrownBy(() -> new Player(name))
			.isInstanceOf(InvalidNameLengthException.class);
	}

}
