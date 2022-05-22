package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MoveDirectionTest {

  @Test
  void left() {
    assertThat(MoveDirection.LEFT.apply(10)).isEqualTo(9);
  }

  @Test
  void right() {
    assertThat(MoveDirection.RIGHT.apply(10)).isEqualTo(11);
  }

  @Test
  void straight() {
    assertThat(MoveDirection.STRAIGHT.apply(10)).isEqualTo(10);
  }
}
