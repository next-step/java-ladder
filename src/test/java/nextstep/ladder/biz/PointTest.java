package nextstep.ladder.biz;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  void create() {
    assertThat(Point.of(true)).isEqualTo(Point.of(true));
  }
}
