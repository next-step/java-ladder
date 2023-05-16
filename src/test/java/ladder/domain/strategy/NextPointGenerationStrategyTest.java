package ladder.domain.strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NextPointGenerationStrategyTest {

  @Test
  void 사다리는_연속적으로_생성되지_않는다() {
    NextPointGenerationStrategy strategy = new RandomPointGenerationStrategy();
    boolean previousConnection = true;
    boolean nextConnection = strategy.nextBoolean(previousConnection);
    assertThat(nextConnection).isFalse();
  }

}