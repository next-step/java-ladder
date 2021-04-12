package ladder.domain;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {

  @Test
  @DisplayName("[Direction] 가로 라인이 겹치는 경우 예외 처리")
  void init_invalid() {
    assertThatThrownBy(() -> Direction.of(TRUE, TRUE))
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  @DisplayName("[Direction] 가로 라인이 겹치지 않도록, TRUE인 경우 그 다음은 FALSE")
  void next_random_true() {
    Direction next = Direction.first(TRUE).next(new RandomConnect());
    assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
  }

  @Test
  @DisplayName("[Direction] 오른쪽 정보가 그 다음 점의 왼쪽 정보 - FALSE, TRUE")
  void next_true() {
    Direction next = Direction.of(TRUE, FALSE).next(TRUE);
    assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
  }

  @Test
  @DisplayName("[Direction] 오른쪽 정보가 그 다음 점의 왼쪽 정보 - TRUE, FALSE")
  void next_false() {
    Direction next = Direction.of(FALSE, TRUE).next(FALSE);
    assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
  }

  @Test
  @DisplayName("[Direction] 첫번째 지점은 항상 왼편이 FALSE - FALSE, TRUE")
  void first() {
    Direction first = Direction.first(TRUE);
    assertThat(first.isLeft()).isEqualTo(FALSE);
    assertThat(first.isRight()).isEqualTo(TRUE);
  }

  @Test
  @DisplayName("[Direction] 마지막 지점의 오른편은 항상 FALSE - TRUE, FALSE")
  void last() {
    Direction last = Direction.first(FALSE).next(TRUE).last();
    assertThat(last.isRight()).isEqualTo(FALSE);
  }
}
