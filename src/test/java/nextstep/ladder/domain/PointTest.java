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
    final Point head = Point.head();
    final Point body1 = Point.body(head, canCreate);
    final Point body2 = Point.body(body1, canCreate);
    final Point tail = Point.tail(canCreate);

    // then
    assertAll(
        () -> assertThat(head).isEqualTo(Point.head()),
        () -> assertThat(body1).isEqualTo(Point.body(head, canCreate)),
        () -> assertThat(body2).isEqualTo(Point.body(body1, canCreate)),
        () -> assertThat(body2).isNotEqualTo(Point.body(head, canCreate)),
        () -> assertThat(tail).isEqualTo(Point.tail(canCreate))
    );
  }

  @Test
  @DisplayName("true일 때, 가로선이 그려지고, false면 그려지지 않는다.")
  void draw() {
    // given
    final boolean canCreate = true;

    // when
    final Point cannotDraw = Point.head();
    final Point canDraw = Point.body(cannotDraw, canCreate);

    // then
    assertAll(
        () -> assertThat(canDraw.draw()).isEqualTo(Point.LINE),
        () -> assertThat(cannotDraw.draw()).isEqualTo(Point.NOT_LINE)
    );
  }
}
