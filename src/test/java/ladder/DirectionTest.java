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
  @DisplayName("각 포인트의 좌우가 true이면 안됨")
  public void init_invalid() {
    assertThatThrownBy(() -> {
      Direction.of(TRUE, TRUE);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("첫번째 포인트가 TRUE이면 다음 포인트는 FALSE여야함")
  public void next_random_true() {
    Direction next = Direction.first(TRUE).next();
    assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));

  }

  @Test
  public void next_random_false() {
    for (int i = 0; i < 100; i++) {
      Direction.first(FALSE).next();
    }
  }

  @Test
  public void next_true() {
    Direction next = Direction.of(TRUE, FALSE).next(TRUE);
    assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
  }

  @Test
  public void next_false() {
    Direction next = Direction.of(FALSE, TRUE).next(FALSE);
    assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
  }

  @Test
  public void first() {
    Direction first = Direction.first(TRUE);
    assertThat(first.isLeft()).isEqualTo(FALSE);
  }

  @Test
  public void last() {
    Direction last = Direction.first(TRUE).last();
    assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
  }
}