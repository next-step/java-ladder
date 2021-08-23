package ladderGame.step3.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderTest {

  @DisplayName("사다리 생성 최소 입력값 검증.")
  @Test
  void invalidLadder() {
    int height = 0;
    int playerCount = 1;

    assertThatThrownBy(() -> new Ladder(Ladder.of(height, playerCount)))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("사다리 객체 생성 테스트.")
  @Test
  void createLadder() {

    List<Point> points = new ArrayList<>();
    points.add(new Point(0, new Location(false, false)));

    List<Line> lines = new ArrayList<>();
    lines.add(new Line(points));

    assertThat(new Ladder(lines)).isEqualTo(new Ladder(lines));
  }

  @DisplayName("생성되는 사다리 높이값에 대한 검증.")
  @ParameterizedTest
  @CsvSource(value = {"1,2,1","5,4,5"})
  void createCount(int height, int players, int count) {
    List<Line> of = Ladder.of(height, players);

    assertThat(of.size()).isEqualTo(count);
  }
}