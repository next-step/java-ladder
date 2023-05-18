package ladder.domain.strategy;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomPointGenerationStrategyTest {

  @Test
  void 랜덤한_boolean에_따라_각_메서드_동작_검증() {
    NextPointGenerationStrategy strategy = (prev) -> false;

    assertThat(strategy.nextBoolean(false)).isFalse();
    assertThat(strategy.nextBoolean(true)).isFalse();
  }


}