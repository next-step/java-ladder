package ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ResultTest {

	@DisplayName("결과값에 빈값이 오면 안된다.")
	@ParameterizedTest
	@NullAndEmptySource
	void notEmptyValues(String value) {
		// given & when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Result.createResult(value);
				}).withMessageMatching("결과 값은 null이나 빈 문자열이 될 수 없습니다.");
	}

	@DisplayName("결과값은 꽝 또는 숫자가 와야한다.")
	@Test
	void isBangOrNumber() {
		// given & when & then
		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy(() -> {
					Result.createResult("잘못된 값");
				}).withMessageMatching("결과값은 꽝 또는 숫자가 와야합니다.");
	}
}
