package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.exception.InvalidNameLengthException;

class PlayerNameTest {

	@DisplayName("사다리 게임 참가자 이름을 포장하는 PlayerName 객체를 생성한다.")
	@Test
	void create() {
		PlayerName playerName = new PlayerName("pobi");
		assertThat(playerName).isEqualTo(new PlayerName("pobi"));
	}

	@DisplayName("사다리 게임에 참여하는 사람의 이름의 길이는 1글자 이상 5글자 이하여야 한다.")
	@ValueSource(strings = {"", "ladder"})
	@ParameterizedTest
	void invalidLength(String name) {
		assertThatThrownBy(() -> new PlayerName(name))
			.isInstanceOf(InvalidNameLengthException.class);
	}

}
