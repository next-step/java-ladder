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

  @Test
  @DisplayName("true일 때, 가로선이 그려지고, false면 그려지지 않는다.")
  void draw() {
    // given
    final boolean canCreate = true;

    // when
    final Point canDraw = Point.head(canCreate);
    final Point cannotDraw = Point.body(canDraw, canCreate);

    // then
    assertAll(
        () -> assertThat(canDraw.draw()).isEqualTo(Point.LINE),
        () -> assertThat(cannotDraw.draw()).isEqualTo(Point.NOT_LINE)
    );
  }
}
