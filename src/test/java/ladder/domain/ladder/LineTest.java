package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.ladder.Line;
import ladder.domain.strategy.NextPointGenerationStrategy;
import org.junit.jupiter.api.Test;

class LineTest {


  @Test
  void 랜덤한_boolean이_나오는_함수에서_항상_true가_나오더라도_연속하지_않은_사다리가_나오는것을_검증() {
    int numberOfParticipants = 10;
    NextPointGenerationStrategy generationStrategy = () -> true;

    Line line = Line.createLine(numberOfParticipants, generationStrategy);

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
    Line line = Line.createLine(3, () -> true);

    assertThat(line.isRightConnected(0)).isTrue();
  }

  @Test
  void 사다리_마지막_인덱스는_오른쪽이_연결되지_않음_검증() {
    Line line = Line.createLine(3, () -> true);

    assertThat(line.isRightConnected(2)).isFalse();
  }

  @Test
  void 왼쪽이_연결된_경우_boolean_true_검증() {
    Line line = Line.createLine(3, () -> true);

    assertThat(line.isLeftConnected(1)).isTrue();
  }

  @Test
  void 사다리_첫_인덱스는_왼쪽이_연결되지_않음_검증() {
    Line line = Line.createLine(3, () -> true);

    assertThat(line.isLeftConnected(0)).isFalse();
  }

}