package ladder.domain;

import ladder.constants.Move;
import ladder.exception.InvalidDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class DirectionTest {

  @Test
  @DisplayName("방향 래퍼 클래스 생성. 단 오른쪽과 왼쪽이 존재하는 방향은 없다.")
  void create() {
    assertAll(
            () -> assertThat(Direction.create(true, false)).isEqualTo(new Direction(Move.RIGHT)),
            () -> assertThat(Direction.create(false, true)).isEqualTo(new Direction(Move.LEFT)),
            () -> assertThatExceptionOfType(InvalidDirectionException.class)
                    .isThrownBy(() -> Direction.create(true, true))
                    .withMessageMatching("오른쪽과 왼쪽을 동시에 갈 수 없습니다.")
    );
  }

  @ParameterizedTest
  @MethodSource("forwardArguments")
  @DisplayName("방향에 맞게 전진한다.")
  void forward(boolean right, boolean left, Move move) {
    // given
    int position = 0;

    // when
    Direction actual = Direction.create(right, left);

    // then
    assertThat(actual.forward(position)).isEqualTo(move.forward(position));
  }

  static Stream<Arguments> forwardArguments() {
    return Stream.of(
            Arguments.of(true, false, Move.RIGHT),
            Arguments.of(false, true, Move.LEFT),
            Arguments.of(false, false, Move.STAY)

    );
  }
}