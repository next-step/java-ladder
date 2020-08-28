package nextstep.ladder.biz;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

  @Test
  void create() {
    assertThat(Point.of(true)).isEqualTo(Point.of(true));
  }

  @Test
  void moveChessmen() {
    Point point = Point.of(true, 0);

    expectedMove(point, Chessmen.location(1), Chessmen.location(0));
    expectedMove(point, Chessmen.location(1), Chessmen.location(0));
  }

  void expectedMove(Point point, Chessmen chessmen, Chessmen expect) {
    point.move(chessmen);
    assertThat(chessmen).isEqualTo(expect);
  }
}
