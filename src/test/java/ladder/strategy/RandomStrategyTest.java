package ladder.strategy;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;

class RandomStrategyTest {
    @Test
    public void 랜덤이_잘_동작하는_지_확인한다() throws Exception {
        MockRandom random = new MockRandom();
        RandomStrategy strategy = new RandomStrategy(random);

        assertFalse(strategy.first());
        assertFalse(strategy.next(false));
        assertFalse(strategy.next(true));

    }

    private class MockRandom extends Random {
        @Override
        public boolean nextBoolean() {
            return false;
        }
    }
}