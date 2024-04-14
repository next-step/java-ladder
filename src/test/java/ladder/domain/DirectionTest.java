package ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
  @ParameterizedTest
  @MethodSource("provideMoveTestParameters")
  void 이동(Direction direction, Coordinates result) {
    assertThat(direction.move(Coordinates.of(1, 1))).isEqualTo(result);
  }

  private static Stream<Arguments> provideMoveTestParameters() {
    return Stream.of(
            Arguments.arguments(Direction.RIGHT, Coordinates.of(2, 2)),
            Arguments.arguments(Direction.LEFT, Coordinates.of(0, 2)),
            Arguments.arguments(Direction.STRAIGHT, Coordinates.of(1, 2))
    );
  }
}
