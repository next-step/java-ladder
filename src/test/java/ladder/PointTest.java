package ladder;

import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

public class PointTest {

  @Test
  public void first() {
    assertThat(Point.first(TRUE).move(), is(1));
    assertThat(Point.first(FALSE).move(), is(0));
  }

  @Test
  public void next_stay() {
    Point second = Point.first(FALSE).next(FALSE);
    assertThat(second.move(), is(1));
  }

  @Test
  public void next_left() {
    Point second = Point.first(TRUE).next(FALSE);
    assertThat(second.move(), is(0));
  }

  @Test
  public void next_right() {
    Point second = Point.first(FALSE).next(TRUE);
    assertThat(second.move(), is(2));
  }

  @Test
  public void next() {
    Point second = Point.first(TRUE).next();
    assertThat(second.move(), is(0));
  }

}
