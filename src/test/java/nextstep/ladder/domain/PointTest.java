package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PointTest {
	@DisplayName("Point 생성을 검증한다.")
	@ParameterizedTest(name = "{index}. hasLeft : {0}, hasRight : {1}")
	@CsvSource({
		"true, false",
		"false, true",
		"false, false"
	})
	void create(boolean hasLeft, boolean hasRight) {
		// when
		Point point = Point.create(hasLeft, hasRight);

		// then
		assertAll(
			() -> assertThat(point.hasLeft()).isEqualTo(hasLeft),
			() -> assertThat(point.hasRight()).isEqualTo(hasRight)
		);
	}

	@DisplayName("left, right 두개 모두 존재할 경우 예외 발생")
	@Test
	void validate() {
		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Point.create(true, true));
	}

	@DisplayName("5에서 이동시에 반환값을 검증한다.")
	@ParameterizedTest(name = "{index}. hasLeft : {0}, hasRight : {1}, expected : {2}")
	@CsvSource({
		"true, false, 4",
		"false, true, 6",
		"false, false, 5"
	})
	void move(boolean hasLeft, boolean hasRight, int expected) {
		// given
		Point point = Point.create(hasLeft, hasRight);
		int index = 5;

		// when
		int movedIndex = point.move(index);

		// then
		assertThat(movedIndex).isEqualTo(expected);
	}
}
