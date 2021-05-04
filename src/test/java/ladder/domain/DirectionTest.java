package ladder.domain;

import ladder.constants.Move;
import ladder.exception.InvalidDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class DirectionTest {

  @Test
  @DisplayName("방향 래퍼 클래스 생성. 단 오른쪽과 왼쪽이 존재하는 방향은 없다.")
  void create() {
    assertAll(
            () -> assertThat(Direction.create(true, false).getValue()).isEqualTo(Move.RIGHT),
            () -> assertThat(Direction.create(false, true).getValue()).isEqualTo(Move.LEFT),
            () -> assertThatExceptionOfType(InvalidDirectionException.class)
                    .isThrownBy(() -> Direction.create(true, true))
                    .withMessageMatching("오른쪽과 왼쪽을 동시에 갈 수 없습니다.")
    );
  }
}