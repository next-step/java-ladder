package nextstep.step4.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class PointTest {

	@DisplayName("첫 번째 지점을 생성한다.")
	@ValueSource(booleans = {true, false})
	@ParameterizedTest
	void first(boolean isRight) {
		Point first = Point.first(isRight);
		assertThat(first).isEqualTo(new Point(0, Direction.first(isRight)));
	}

	@DisplayName("중간 지점을 생성한다.")
	@CsvSource(value = {"true,false", "false,false", "false,true"})
	@ParameterizedTest(name = "이전 지점이 오른쪽? : {0}, 다음 지점이 오른쪽? : {1}")
	void next(boolean isFirstRight, boolean isNextRight) {
		Point next = Point.first(isFirstRight).next(isNextRight);
		assertThat(next).isEqualTo(new Point(1, Direction.of(isFirstRight, isNextRight)));
	}

	@DisplayName("마지막 지점을 생성한다.")
	@CsvSource(value = {"false,true,true", "false,false,false", "true,false,false"})
	@ParameterizedTest(name = "이전 지점의 방향이 (왼쪽 : {0} / 오른쪽 : {1}) 이면, 마지막 지점이 왼쪽? : {1}")
	void last(boolean isPreviousLeft, boolean isPreviousRight, boolean isLastLeft) {
		Point previous = new Point(1, Direction.of(isPreviousLeft, isPreviousRight));
		Point last = previous.last();
		Assertions.assertThat(last).isEqualTo(new Point(2, Direction.of(isLastLeft, false)));
	}

	@DisplayName("지점에서 이동 시, 방향에 따라 index 값이 변경된다.")
	@MethodSource("moveArguments")
	@ParameterizedTest
	void move(int start, Direction direction, int result) {
		Point point = new Point(start, direction);
		assertThat(point.move()).isEqualTo(result);
	}

	private static Stream<Arguments> moveArguments() {
		return Stream.of(
			Arguments.of(1, Direction.of(true, false), 0),
			Arguments.of(1, Direction.of(false, false), 1),
			Arguments.of(1, Direction.of(false, true), 2)
		);
	}


}
