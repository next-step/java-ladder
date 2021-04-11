package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

  @Test
  @DisplayName("Point를 생성한다.")
  void create() {
    // given
    final boolean canCreate = true;

    // when
    final Point head = Point.head(canCreate);
    final Point body1 = Point.body(head, canCreate);
    final Point body2 = Point.body(body1, canCreate);
    final Point tail = Point.tail();

    // then
    assertAll(
        () -> assertThat(head).isEqualTo(Point.head(canCreate)),
        () -> assertThat(body1).isEqualTo(Point.body(head, canCreate)),
        () -> assertThat(body2).isEqualTo(Point.body(body1, canCreate)),
        () -> assertThat(body2).isNotEqualTo(Point.body(head, canCreate)),
        () -> assertThat(tail).isEqualTo(Point.tail())
    );
  }
}
