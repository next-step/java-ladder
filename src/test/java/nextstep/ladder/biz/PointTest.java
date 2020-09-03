package nextstep.ladder.biz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

  @Test
  void isEqual() {
    assertThat(Point.of(true)).isEqualTo(Point.of(true));
  }


}
