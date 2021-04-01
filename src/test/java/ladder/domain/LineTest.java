package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

  @Test
  @DisplayName("[Line] 한 라인에 사람 수만큼 좌표 생성 되었는지 테스트")
  void createLineTest() {
    Line line = new Line(4);

    int size = line.points().size();

    assertThat(size).isEqualTo(4);
  }

  @Test
  @DisplayName("[Line] 라인의 좌표 값에 선이 없는 경우 테스트")
  void connectionPoint_false_Test() {
    Line line = new Line(1);
    Point point = line.connectPoint(() -> false);

    assertThat(point).isEqualTo(Point.DISCONNECT);
  }

  @Test
  @DisplayName("[Line] 라인의 좌표 값에 선이 있는 경우 테스트")
  void connectionPoint_true_Test() {
    Line line = new Line(1);
    Point point = line.connectPoint(() -> true);

    assertThat(point).isEqualTo(Point.CONNECT);
  }
}
