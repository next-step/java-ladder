package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.exception.NameLengthException;

class NameTest {
	@DisplayName(value = "Name 생성")
	@ValueSource(strings = {"ju", "hong", "beom"})
	@ParameterizedTest
	void createName(String value) {
		Name name = new Name(value);
		String result = name.toString();

		assertThat(result).isEqualTo(value);
	}

	@DisplayName(value = "이름이 1글자 미만이거나 5글자 초과면 예외를 던짐")
	@ValueSource(strings = {"", "123456"})
	@ParameterizedTest
	void checkMinLength(String value) {
		assertThatThrownBy(() -> new Name(value))
			.isInstanceOf(NameLengthException.class);
	}
}