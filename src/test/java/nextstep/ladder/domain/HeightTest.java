package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {
	@DisplayName("Height 객체 생성 검증")
	@ParameterizedTest(name = "{index}. input : {0}")
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void create(int input) {
		// when
		Height height = Height.create(input);

		// then
		assertThat(height).isNotNull();
	}

	@DisplayName("0 또는 음수일 경우 예외 발생")
	@ParameterizedTest(name = "{index}. input : {0}")
	@ValueSource(ints = {0, -1, -2, -3, -4, -5})
	void createWithNegativeNumber(int input) {
		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Height.create(input));
	}

	@DisplayName("Height 내부 값 검증")
	@ParameterizedTest(name = "{index}. input : {0}")
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void getValue(int input) {
		// given
		Height height = Height.create(input);

		// when
		int expected = height.getValue();

		// then
		assertThat(expected).isEqualTo(input);
	}
}
