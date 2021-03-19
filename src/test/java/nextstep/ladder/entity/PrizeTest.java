package nextstep.ladder.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import nextstep.ladder.exception.UserException;
import nextstep.ladder.exception.UserExceptionMesssage;

public class PrizeTest {

	@ParameterizedTest
	@DisplayName("Prize 성공 케이스")
	@ValueSource(strings = {"1000", "20000", "꽝"})
	void Prize_success(String input){
		assertThat(new Prize(input))
			.isInstanceOf(Prize.class);
	}

	@ParameterizedTest
	@DisplayName("Prize 실패 케이스")
	@ValueSource(strings = {"1000a", "20000ee", "꽝!"})
	void Prize_fail(String input){
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> new Prize(input))
			.withMessageMatching(UserExceptionMesssage.NOT_NUMERIC_OR_FALSY.getMessage());
	}

	@ParameterizedTest
	@DisplayName("PrizeResult test")
	@ValueSource(strings = {"1000,1000,꽝", "20000,2000,3000", "꽝,꽝,꽝"})
	void Prize_result_success(String input){

		assertThat(new PrizeResult(input, 3))
			.isInstanceOf(PrizeResult.class);
	}

	@ParameterizedTest
	@DisplayName("PrizeResult exception")
	@ValueSource(strings = {"1000!1000!꽝", "20000!2000!3000", "꽝!꽝!꽝"})
	void Prize_result_fail(String input){
		assertThatExceptionOfType(UserException.class)
			.isThrownBy(() -> new PrizeResult(input, 3))
			.withMessageMatching(UserExceptionMesssage.NOT_NUMERIC_OR_FALSY.getMessage());
	}

}
