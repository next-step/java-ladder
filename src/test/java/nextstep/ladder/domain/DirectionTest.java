package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class DirectionTest {
  @Test
  void create() {
    assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
  }

  @Test
  void create_invalid() {
    assertThatThrownBy(() -> Direction.of(true, true))
        .isInstanceOf(IllegalStateException.class);
  }

  @Test
  void first_true_next_false() {
    Direction next = Direction.first(true).next();
    assertThat(next).isEqualTo(Direction.of(true, false));
  }

  @Test
  void next_true() {
    Direction next = Direction.of(true, false).next(true);
    assertThat(next).isEqualTo(Direction.of(false, true));
  }

  @Test
  void next_false() {
    Direction next = Direction.of(false, true).next(false);
    assertThat(next).isEqualTo(Direction.of(true, false));
  }

  @Test
  void first() {
    Direction first = Direction.first(true);
    assertThat(first).isEqualTo(Direction.of(false, true));
  }

  @Test
  void last() {
    Direction last = Direction.first(true).last();
    assertThat(last).isEqualTo(Direction.of(true, false));
  }
}
