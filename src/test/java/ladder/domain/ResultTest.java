package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ResultTest {

	@DisplayName("유효한 값으로 실행결과 생성 시, 객체를 반환한다.")
	@ValueSource(strings = {"꽝", "5000", "3000"})
	@ParameterizedTest
	void test1(String input) {
		Result result = new Result(input);
		assertThat(result).isEqualTo(new Result(input));
	}

	@DisplayName("유효하지 않은 값으로 실행결과 생성 시, 객체를 반환한다.")
	@ValueSource(strings = {"꿍", "5000원", "abcde"})
	@ParameterizedTest
	void test2(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Result(input));
	}
}
