package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.strategy.RandomPointGenerationStrategy;
import org.junit.jupiter.api.Test;

class LineTest {


  @Test
  void 하나의_row에_true가_연속해서_나오지_않음_검증() {
    Line line = Line.createLine(10, new RandomPointGenerationStrategy());

    List<Boolean> points = line.getPoints();
    boolean previousConnection = points.get(0);

    for (int i = 1; i < points.size(); i++) {
      boolean currentConnection = points.get(i);
      assertThat(previousConnection && currentConnection).isFalse();
      previousConnection = currentConnection;
    }
  }

  @Test
  void 오른쪽이_연결된_경우_boolean_true_검증() {
    Line line = new Line(true, false, true);

    assertThat(line.isRightConnected(0)).isTrue();
  }

  @Test
  void 사다리_마지막_인덱스는_오른쪽이_연결되지_않음_검증() {
    Line line = new Line(true, false, true);

    assertThat(line.isRightConnected(3)).isFalse();
  }

  @Test
  void 왼쪽이_연결된_경우_boolean_true_검증() {
    Line line = new Line(true, false, true);

    assertThat(line.isLeftConnected(1)).isTrue();
  }

  @Test
  void 사다리_첫_인덱스는_왼쪽이_연결되지_않음_검증() {
    Line line = new Line(true, false, true);

    assertThat(line.isLeftConnected(0)).isFalse();
  }

}