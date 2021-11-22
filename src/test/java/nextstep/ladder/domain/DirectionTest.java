package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {
	@DisplayName("left, right 반환 검증")
	@ParameterizedTest(name = "{index}. left : {0}, right : {1}")
	@CsvSource({
		"true, false",
		"false, true",
		"false, false"
	})
	void create(boolean left, boolean right) {
		// when
		Direction direction = Direction.create(left, right);

		// then
		assertAll(
			() -> assertThat(direction.isLeft()).isEqualTo(left),
			() -> assertThat(direction.isRight()).isEqualTo(right)
		);
	}

	@DisplayName("left, right 두개 모두 true 일 경우 예외 발생")
	@Test
	void validate() {
		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Direction.create(true, true));
	}
}
