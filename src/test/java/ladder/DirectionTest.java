package ladder;


import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class DirectionTest {

  @Test
  @DisplayName("Direction 생성 확인")
  public void init() {
    assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
  }

  @Test
  @DisplayName("각 Direction의 좌우가 true이면 안됨")
  public void init_invalid() {
    assertThatThrownBy(() -> {
      Direction.of(TRUE, TRUE);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("왼쪽 Direction이 TRUE이면 오른쪽 Direction은 FALSE여야함")
  public void next_random_true() {
    Direction next = Direction.first(TRUE).next();
    assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));

  }

  @Test
  @DisplayName("next 메서드 확인")
  public void next_random_false() {
    for (int i = 0; i < 100; i++) {
      Direction.first(FALSE).next();
    }
  }

  @Test
  @DisplayName("next 후 Direction 확인")
  public void next_true() {
    Direction next = Direction.of(TRUE, FALSE).next(TRUE);
    assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
  }

  @Test
  @DisplayName("next 후 Direction 확인")
  public void next_false() {
    Direction next = Direction.of(FALSE, TRUE).next(FALSE);
    assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
  }

  @Test
  @DisplayName("첫번째 Direction 확인")
  public void first() {
    Direction first = Direction.first(TRUE);
    assertThat(first.isLeft()).isEqualTo(FALSE);
  }

  @Test
  @DisplayName("마지막 Direction 확인")
  public void last() {
    Direction last = Direction.first(TRUE).last();
    assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
  }
}