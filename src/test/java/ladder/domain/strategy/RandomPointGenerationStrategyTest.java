package ladder.domain.strategy;

import static org.assertj.core.api.Assertions.*;

import java.util.Random;
import org.junit.jupiter.api.Test;

class RandomPointGenerationStrategyTest {

//  @Test
//  void 랜덤한_boolean에_따라_각_메서드_동작_검증() {
//    MockRandom random = new MockRandom();
//    NextPointGenerationStrategy strategy = new RandomPointGenerationStrategy(random);
//
//    assertThat(strategy.first()).isFalse();
//    assertThat(strategy.nextBoolean(false)).isFalse();
//    assertThat(strategy.nextBoolean(true)).isFalse();
//  }

  private class MockRandom extends Random {
    @Override
    public boolean nextBoolean() {
      return false;
    }
  }

}