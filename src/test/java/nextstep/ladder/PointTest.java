package nextstep.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import nextstep.ladder.domain.Point;

public class PointTest {
	@DisplayName("move시 point의 distance만큼 index가 변경된다.")
	@ParameterizedTest
	@MethodSource("pointAndExpected")
	void validate_move(Point point, int currentIndex, int expected) {
		assertThat(point.move(currentIndex)).isEqualTo(expected);
	}

	static Stream<Arguments> pointAndExpected() {
		return Stream.of(
			Arguments.arguments(Point.LEFT, 4, 3),
			Arguments.arguments(Point.RIGHT, 5, 6),
			Arguments.arguments(Point.HOLD, 3, 3)
		);
	}
}
