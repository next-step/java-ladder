package step2.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UsersTest {

	@ParameterizedTest
	@ValueSource(strings = {"abc,bcd,erw,qwe,ret"})
	void getUsersCnt(String usersString) {
		Users users = new Users(usersString);
		Assertions.assertThat(users.getUsersCnt()).isEqualTo(5);
	}
}