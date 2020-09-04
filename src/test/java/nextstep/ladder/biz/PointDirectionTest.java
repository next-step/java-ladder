package nextstep.ladder.biz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointDirectionTest {

  @Test
  public void first() {
    assertThat(PointDirection.first(true).move()).isEqualTo(1);
    assertThat(PointDirection.first(false).move()).isEqualTo(0);
  }

  @Test
  public void next_stay() {
    PointDirection second = PointDirection.first(false).next(false);
    assertThat(second.move()).isEqualTo(1);
  }

  @Test
  public void next_left() {
    PointDirection second = PointDirection.first(true).next(false);
    assertThat(second.move()).isEqualTo(0);
  }

  @Test
  public void next_right() {
    PointDirection second = PointDirection.first(false).next(true);
    assertThat(second.move()).isEqualTo(2);
  }

  @Test
  public void next() {
    PointDirection second = PointDirection.first(true).next();
    assertThat(second.move()).isEqualTo(0);
  }
}
