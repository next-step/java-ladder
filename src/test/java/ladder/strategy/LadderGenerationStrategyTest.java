package ladder.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGenerationStrategyTest {

    @Test
    public void 사다리는_이어서_생성되지_않는다() {
        LadderGenerationStrategy strategy = new RandomStrategy();

        assertThat(strategy.next(true)).isFalse();
    }

}