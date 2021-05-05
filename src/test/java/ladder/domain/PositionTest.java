package ladder.domain;

import ladder.constants.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PositionTest {

  @Test
  @DisplayName("위치는 각 상태에 따라 맞게 이동한 값을 반환한다.")
  void newInstance() {
    // given
    int value = 0;

    // when
    Position position = new Position(value);

    // that
    assertAll(
            () -> assertThat(position.right()).isEqualTo(new Position(Move.RIGHT.forward(value))),
            () -> assertThat(position.left()).isEqualTo(new Position(Move.LEFT.forward(value)))
    );
  }

  @ParameterizedTest
  @MethodSource("nextArguments")
  @DisplayName("방향에 맞게 다음 위치 값을 반환한다.")
  void next(Direction direction) {
    // given
    int value = 0;

    // when
    Position actual = new Position(value).next(direction);

    // then
    assertThat(actual).isEqualTo(new Position(direction.forward(value)));
  }

  static Stream<Arguments> nextArguments() {
    return Stream.of(
            Arguments.of(Direction.create(true, false)),
            Arguments.of(Direction.create(false, true)),
            Arguments.of(Direction.create(false, false))
    );
  }
}