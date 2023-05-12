package ladder.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.strategy.NextPointGenerationStrategy;
import org.junit.jupiter.api.Test;

class LineTest {


  @Test
  void 랜덤한_boolean이_나오는_함수에서_항상_true가_나오더라도_연속하지_않은_사다리가_나오는것을_검증() {
    int numberOfParticipants = 10;
    NextPointGenerationStrategy generationStrategy = () -> true;

    Line line = new Line(numberOfParticipants, generationStrategy);

    List<Boolean> points = line.getPoints();
    boolean previousConnection = points.get(0);

    for (int i = 1; i < points.size(); i++) {
      boolean currentConnection = points.get(i);
      assertThat(previousConnection && currentConnection).isFalse();
      previousConnection = currentConnection;
    }
  }

}