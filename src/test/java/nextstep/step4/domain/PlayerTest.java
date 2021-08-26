package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.step4.exception.InvalidNameLengthException;

class PlayerTest {

	@DisplayName("이름으로 참가자인 Player 객체를 생성한다.")
	@Test
	void create() {
		Player crong = new Player("crong");
		assertThat(crong).isEqualTo(new Player("crong"));
	}

	@DisplayName("참가자의 이름의 길이가 1 이상 5 이하가 아니면, InvalidNameLengthException 예외가 발생한다.")
	@ValueSource(strings = {"", "nextstep"})
	@ParameterizedTest
	void invalid(String name) {
		assertThatThrownBy(() -> new Player(name))
			.isInstanceOf(InvalidNameLengthException.class);
	}

}
