package nextstep.ladder.biz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {
  @Test
  public void init() {
    assertThat(Direction.of(true, false))
            .isEqualTo(Direction.of(true, false));
  }

  @Test
  public void init_invalid() {
    assertThatThrownBy(() -> Direction.of(true, true))
    .isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void next_random_true() {
    Direction next = Direction.first(true).next();
    assertThat(next).isEqualTo(Direction.of(true, false));
  }

  @Test
  public void next_random_false() {
    for (int i = 0; i < 100; i++) {
      Direction.first(false).next();
    }
  }

  @Test
  public void next_true() {
    Direction next = Direction.of(true, false).next(true);
    assertThat(next).isEqualTo(Direction.of(false, true));
  }

  @Test
  public void next_false() {
    Direction next = Direction.of(false, true).next(false);
    assertThat(next).isEqualTo(Direction.of(true, false));
  }

  @Test
  public void isLeftOfFirst() {
    Direction first = Direction.first(true);
    assertThat(first.isLeft()).isEqualTo(false);
  }

  @Test
  public void isRightOfFirst() {
    Direction first = Direction.first(true);
    assertThat(first.isRight()).isEqualTo(true);
  }

  @Test
  public void last() {
    Direction last = Direction.first(true).last();
    assertThat(last).isEqualTo(Direction.of(true, false));
  }
}
