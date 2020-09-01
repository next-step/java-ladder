package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import ladder.domain.playing.Direction;

public class DirectionTest {

	@ParameterizedTest
	@MethodSource("directionMovingProvider")
	public void directionMovingTest(Direction direction, int currentPosition, int expect) {
		assertThat(direction.move(currentPosition)).isEqualTo(expect);
	}

	private static Stream<Arguments> directionMovingProvider() {
		return Stream.of(
				Arguments.arguments(Direction.RIGHT, 1, 2),
				Arguments.arguments(Direction.LEFT, 10, 9),
				Arguments.arguments(Direction.NONE, 7, 7)
						);
	}
}
