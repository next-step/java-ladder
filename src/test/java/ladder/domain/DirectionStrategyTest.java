package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DirectionStrategyTest {

    private static final DirectionStrategy strategy = new DirectionStrategy() {
        @Override
        Direction get() {
            return get(false);
        }
    };

    @Test
    @DisplayName("RIGHT 이후에는 항상 LEFT 가 나오는지 테스트")
    void generate() {
        assertAll(
                () -> assertThat(strategy.get(true))
                        .isEqualTo(Direction.DOWN),
                () -> assertThat(strategy.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(strategy.get())
                        .isEqualTo(Direction.LEFT),
                () -> assertThat(strategy.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(strategy.get(true))
                        .isEqualTo(Direction.LEFT)
        );
    }

    @Test
    @DisplayName("reset 을 하면 DOWN 으로 초기화 되는 테스트")
    void reset() {
        strategy.reset();
        Supplier<Direction> generate = () -> strategy.get();
        Supplier<Direction> resetAndGenerate = () -> {
            strategy.reset();
            return strategy.get();
        };
        assertAll(
                () -> assertThat(generate.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(resetAndGenerate.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(strategy.get())
                        .isEqualTo(Direction.LEFT),
                () -> assertThat(resetAndGenerate.get())
                        .isEqualTo(Direction.RIGHT)
        );
    }
}
