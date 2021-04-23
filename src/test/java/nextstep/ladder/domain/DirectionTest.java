package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DirectionTest {

  @Test
  @DisplayName("방향에 따라 다음 인덱스를 반환한다.")
  void move() {
    // given
    final int index = 1;
    final Direction none = Direction.NONE;
    final Direction left = Direction.LEFT;
    final Direction right = Direction.RIGHT;

    // when
    // then
    assertAll(
        () -> assertThat(none.move(index)).isEqualTo(index),
        () -> assertThat(left.move(index)).isEqualTo(index - 1),
        () -> assertThat(right.move(index)).isEqualTo(index + 1)
    );
  }

  @ParameterizedTest
  @CsvSource({"true,RIGHT", "false,NONE"})
  @DisplayName("true면 RIGHT를, false면 NONE을 반환한다.")
  void valueOf(boolean isRight, Direction direction) {
    assertThat(Direction.valueOf(isRight)).isEqualTo(direction);
  }
}
