package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  @DisplayName("생성된 라인의 points 크기는 입력 count - 1 이어야 한다.")
  void createLine_pointsSize() {
    int count = 5;
    Line line = new Line(count);

    List<Boolean> points = line.points();
    assertThat(points).hasSize(count - 1);
  }

  @Test
  @DisplayName("라인은 연속된 true(가로선 겹침)를 허용하지 않는다.")
  void line_should_not_have_consecutive_true() {
    Line line = new Line(10);
    List<Boolean> points = line.points();

    boolean hasConsecutiveTrue = IntStream.range(1, points.size())
        .anyMatch(i -> points.get(i - 1) && points.get(i));

    assertThat(hasConsecutiveTrue).isFalse();
  }

  @Test
  @DisplayName("현재 위치에서 오른쪽 연결이 있으면 오른쪽으로 이동한다.")
  void moveRight() {
    Line line = new Line(Arrays.asList(true, false));

    int moved = line.move(0);  // index 0에서 오른쪽 true
    assertThat(moved).isEqualTo(1);
  }

  @Test
  @DisplayName("현재 위치에서 왼쪽 연결이 있으면 왼쪽으로 이동한다.")
  void moveLeft() {
    Line line = new Line(Arrays.asList(true, false));

    int moved = line.move(1);  // index 1에서 왼쪽 true
    assertThat(moved).isEqualTo(0);
  }

  @Test
  @DisplayName("양쪽 연결이 없으면 이동하지 않는다.")
  void stayStill() {
    Line line = new Line(Arrays.asList(false, false));

    assertThat(line.move(0)).isEqualTo(0);
    assertThat(line.move(1)).isEqualTo(1);
  }

}
