package ladder.constant;

import ladder.constants.Move;
import ladder.exception.InvalidDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class MoveTest {

  @Test
  @DisplayName("오른쪽은 +1, 왼쪽은 -1의 값을 반환한다.")
  void get() {
    // given
    int value = 1;

    // then
    assertAll(
            () -> assertThat(Move.STAY.forward(value)).isEqualTo(value + Move.STAY.getValue()),
            () -> assertThat(Move.RIGHT.forward(value)).isEqualTo(value + Move.RIGHT.getValue()),
            () -> assertThat(Move.LEFT.forward(value)).isEqualTo(value + Move.LEFT.getValue())
    );
  }

  @Test
  @DisplayName("오른쪽 왼쪽에 맞게 이넘 클래스를 반환한다.")
  void valueOf() {
    assertAll(
            () -> assertThat(Move.valueOf(false, false)).isEqualTo(Move.STAY),
            () -> assertThat(Move.valueOf(true, false)).isEqualTo(Move.RIGHT),
            () -> assertThat(Move.valueOf(false, true)).isEqualTo(Move.LEFT),
            () -> assertThatExceptionOfType(InvalidDirectionException.class)
                    .isThrownBy(() -> Move.valueOf(true, true))
                    .withMessageMatching("오른쪽과 왼쪽을 동시에 갈 수 없습니다.")
    );
  }
}