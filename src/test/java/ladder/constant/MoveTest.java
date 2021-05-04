package ladder.constant;

import ladder.constants.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class MoveTest {

  @Test
  @DisplayName("오른쪽은 +1, 왼쪽은 -1의 값을 반환한다.")
  void get() {
    // given
    int value = 1;

    // then
    assertAll(
            () -> assertThat(Move.RIGHT.forward(value)).isEqualTo(value + Move.RIGHT.getValue()),
            () -> assertThat(Move.LEFT.forward(value)).isEqualTo(value + Move.LEFT.getValue())
    );
  }
}