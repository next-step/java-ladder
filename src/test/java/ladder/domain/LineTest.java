package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
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

  @Test
  @DisplayName("[Line] 오른쪽으로 이동 테스트")
  void move_right_test() {
    /*
    *   user1   user2
    *       |-----|
    *   user1은 오른쪽으로 이동
    * */
    Line line = new Line(2, () -> true);

    assertThat(line.move(0)).isEqualTo(1);
  }

  @Test
  @DisplayName("[Line] 왼쪽으로 이동 테스트")
  void move_left_test() {
    /*
     *   user1   user2
     *       |-----|
     *   user2은 왼쪽으로 이동
     * */
    Line line = new Line(2, () -> true);

    assertThat(line.move(1)).isEqualTo(-1);
  }

  @Test
  @DisplayName("[Line] 연결되지 않은 경우 테스트")
  void move_stay_test() {
    Line line = new Line(2, () -> false);

    assertThat(line.move(0)).isEqualTo(0);
  }
}
