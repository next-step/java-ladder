package ladderGame.step3.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @DisplayName("사다리 생성 최소 입력값 검증.")
  @Test
  void invalidLadder() {
    int height = 0;
    int playerCount = 1;

    assertThatThrownBy(() -> new Ladder(Ladder.of(height,playerCount)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사다리 객체 생성 테스트.")
  @Test
  void createLadder() {

    List<Point> points = new ArrayList<>();
    points.add(new Point(0,new Location(false,false)));

    List<Line> lines = new ArrayList<>();
    lines.add(new Line(points));

    assertThat(new Ladder(lines)).isEqualTo(new Ladder(lines));
  }
}