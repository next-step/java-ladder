package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {
	@ParameterizedTest
	@ValueSource(strings = {"abod", "bred"})
	@DisplayName("입력된 사람의 이름은 5글자 미만이어야 한다.")
	void userNameTest(String input) {
		assertDoesNotThrow(() -> new User(input));
	}

	@ParameterizedTest
	@ValueSource(strings = {"aboded", "asdfgg"})
	@DisplayName("입력된 사람의 이름이 다섯 글자 이상이면 에러를 내뱉는다.")
	void userNameExceptionTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> new User(input));
	}

}