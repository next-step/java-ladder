package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

	@ParameterizedTest
	@ValueSource(strings = "aboded, asdfgg")
	@DisplayName("입력된 사람의 이름은 5글자미만이어야 한다.")
	void userNameTest(String input) {
		assertThrows(IllegalArgumentException.class, () -> new User(input));
	}

}