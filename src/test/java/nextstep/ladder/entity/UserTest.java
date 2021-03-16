package nextstep.ladder.entity;

import static nextstep.ladder.exception.UserExceptionMesssage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.exception.UserException;

public class UserTest {

	@DisplayName("user 5자 미만 성공")
	@ParameterizedTest
	@ValueSource(strings = {"1", "12", "123", "1234", "12345"})
	void User_test(String name) {
		assertThat(new User(name))
			.isInstanceOf(User.class);
	}


	@DisplayName("user 5자 초과 exception")
	@ParameterizedTest
	@ValueSource(strings = {"abcdef", "abcdefg", "abcdefhhh", "abcdefggg", "abcdefefe"})
	void User_test_exception(String name) {
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> new User(name))
			.withMessageMatching(NAME_SIZE_CHECK_FIVE.getMessage());
	}

	@DisplayName("users delimeter로 잘라서 넣기")
	@ParameterizedTest
	@ValueSource(strings = {"1,12,13", "1,2,3,4", "a,b,dd,e"})
	void Users_test(String name) {
		assertThat(new Users(name))
			.isInstanceOf(Users.class);
	}

	@DisplayName("users delimeter로 comma 아닌 경우 exception")
	@ParameterizedTest
	@ValueSource(strings = {"1212#13", "1@@23%4", "a@!dd@e"})
	void Users_test_exception(String name) {
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> new Users(name))
			.withMessageMatching(DELIMETER_WITHIN_COMMA.getMessage());
	}

}
