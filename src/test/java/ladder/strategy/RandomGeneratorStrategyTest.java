package ladder.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorStrategyTest {
    @DisplayName("Random의 seed(0) 고정시 출력 결과가 동일하다.")
    @Test
    void test() {
        GeneratorStrategy movingStrategy = new RandomGeneratorStrategy(0);
        assertThat(movingStrategy.generatePoint(false)).isTrue();
        assertThat(movingStrategy.generatePoint(false)).isTrue();
        assertThat(movingStrategy.generatePoint(false)).isFalse();
        assertThat(movingStrategy.generatePoint(false)).isTrue();
        assertThat(movingStrategy.generatePoint(false)).isTrue();
        assertThat(movingStrategy.generatePoint(false)).isFalse();
        assertThat(movingStrategy.generatePoint(false)).isTrue();
        assertThat(movingStrategy.generatePoint(false)).isFalse();
    }
}
