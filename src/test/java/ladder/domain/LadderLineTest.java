package ladder.domain;

import ladder.strategy.GeneratorStrategy;
import ladder.strategy.RandomGeneratorStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    private static final GeneratorStrategy generatorStrategy = new RandomGeneratorStrategy();

    @Test
    public void init_생성() {
        assertThat(LadderLine.init(5, generatorStrategy)).isInstanceOf(LadderLine.class);
    }

    @Test
    public void move_이동() {
        LadderLine line = LadderLine.init(2, () -> true);
        assertThat(line.move(0)).isEqualTo(1);
    }
}
