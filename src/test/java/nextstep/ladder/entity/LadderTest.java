package nextstep.ladder.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.exception.UserException;
import nextstep.ladder.exception.UserExceptionMesssage;

public class LadderTest {

	@ParameterizedTest
	@DisplayName("숫자가 음수인 경우 exception")
	@ValueSource(ints = {-1, -2, -3, -4})
	void ladder_Exception(int input) {
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> {
				new Ladder(new Users("1,2,3,4"), input);
			})
			.withMessageMatching(UserExceptionMesssage.NEGATIVE_NOT_AGRRESIVE.getMessage());
	}
}
