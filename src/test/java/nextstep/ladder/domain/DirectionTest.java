package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DirectionTest {
	@DisplayName("left, right 두개 모두 true 일 경우 예외 발생")
	@Test
	void validate() {
		// when then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Direction.create(true, true));
	}

	@DisplayName("Direction move 호출후 반환값 검증")
	@ParameterizedTest(name = "{index}. direction : {0}, expectedMove : {1}")
	@MethodSource("provideDirectionAndExpectedMove")
	void move(Direction direction, int expectedMove) {
		// given
		int index = 10;

		// when
		int move = direction.move(index);

		// then
		assertThat(move).isEqualTo(expectedMove);
	}

	private static Stream<Arguments> provideDirectionAndExpectedMove() {
		return Stream.of(
			arguments(Direction.LEFT, 9),
			arguments(Direction.HOLD, 10),
			arguments(Direction.RIGHT, 11)
		);
	}
}
