package ladderGame.step3.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @DisplayName("입력 카운트 최소값 검증.")
  @Test
  void invalidCount() {
    assertThatThrownBy(()->Line.createLine(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("Line 객체 생성 테스트.")
  @Test
  void createLine() {
    List<Point> points = new ArrayList<>();
    points.add(new Point(0,new Location(false,false)));

    assertThat(new Line(points)).isEqualTo(new Line(points));
  }
}