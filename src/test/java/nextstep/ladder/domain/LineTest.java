package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  @DisplayName("오른쪽 이동")
  void moveRight() {
    Line line = new Line(List.of(
        Position.of(0, Point.of(false, true)),
        Position.of(1, Point.of(true, false)),
        Position.of(2, Point.of(false, false))
    ));
    assertThat(line.move(0)).isEqualTo(1);
  }

  @Test
  @DisplayName("왼쪽 이동")
  void moveLeft() {
    Line line = new Line(List.of(
        Position.of(0, Point.of(false, true)),
        Position.of(1, Point.of(true, false)),
        Position.of(2, Point.of(false, false))
    ));
    assertThat(line.move(1)).isEqualTo(0);
  }


}