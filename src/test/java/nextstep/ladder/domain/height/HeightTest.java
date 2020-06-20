package nextstep.ladder.domain.height;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class HeightTest {

	@DisplayName("5 초과의 값이 입력된 경우 높이 객체가 생성되지 않고 오류를 반환한다.")
	@CsvSource({"6", "7", "8", "9", "10"})
	@ParameterizedTest
	void 높이가_6을_초과하는_경우_오류를_반환한다(String heightValueString) {
		assertThatThrownBy(
			() -> Height.ofHeight(heightValueString))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("The minimum threshold of height is 1. check your input again.");
	}

	@DisplayName("1 이하의 값이 입력된 경우 높이 객체가 생성되지 않고 오류를 반환한다.")
	@CsvSource({"0", "-1", "-2", "-3", "-4"})
	@ParameterizedTest
	void 하나_이하의_높이를_가진_경우_오류를_반환한다(String heightValueString) {
		assertThatThrownBy(
			() -> Height.ofHeight(heightValueString))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("The minimum threshold of height is 1. check your input again.");
	}

	@DisplayName("null 또는 undefined인 경우 높이 객체가 생성되지 않고 오류를 반환한다.")
	@NullAndEmptySource
	@ParameterizedTest
	void NULL_또는_UNDEFINED인_경우_오류를_반환한다(String heightValueString) {
		assertThatThrownBy(
			() -> Height.ofHeight(heightValueString))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("The height input is null or undefined. What was wrong with you?");
	}
}
