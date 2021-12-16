package ladder.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomMovingStrategyTest {
    @DisplayName("Random의 seed(0) 고정시 출력 결과가 동일하다.")
    @Test
    void test() {
        MovingStrategy movingStrategy = new RandomMovingStrategy(0);
        assertThat(movingStrategy.canMove()).isTrue();
        assertThat(movingStrategy.canMove()).isTrue();
        assertThat(movingStrategy.canMove()).isFalse();
        assertThat(movingStrategy.canMove()).isTrue();
        assertThat(movingStrategy.canMove()).isTrue();
        assertThat(movingStrategy.canMove()).isFalse();
        assertThat(movingStrategy.canMove()).isTrue();
        assertThat(movingStrategy.canMove()).isFalse();
        assertThat(movingStrategy.canMove()).isTrue();
        assertThat(movingStrategy.canMove()).isTrue();
        assertThat(movingStrategy.canMove()).isFalse();
        assertThat(movingStrategy.canMove()).isFalse();
        assertThat(movingStrategy.canMove()).isFalse();
    }
}
