package ladder.domain;

import ladder.strategy.FalseStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DirectionStrategyTest {

    @Test
    @DisplayName("RIGHT 이후에는 항상 LEFT 가 나오는지 테스트")
    void generate() {
        DirectionStrategy generator = new DirectionStrategy(FalseStrategy.getInstance());
        assertAll(
                () -> assertThat(generator.get(true))
                        .isEqualTo(Direction.DOWN),
                () -> assertThat(generator.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(generator.get())
                        .isEqualTo(Direction.LEFT),
                () -> assertThat(generator.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(generator.get(true))
                        .isEqualTo(Direction.LEFT)
        );
    }

    @Test
    @DisplayName("reset 을 하면 DOWN 으로 초기화 되는 테스트")
    void reset() {
        DirectionStrategy generator = new DirectionStrategy(FalseStrategy.getInstance());
        /**
         * FIXME: 익명 람다 함수를 바로 실행 시킬 수는 없나?
         * 가령 (() -> generator.generate())()
         * (() -> generator.generate()).get() 같은 표현은 불가능하나?
         */
        Supplier<Direction> generate = () -> generator.get();
        Supplier<Direction> resetAndGenerate = () -> {
            generator.reset();
            return generator.get();
        };
        assertAll(
                () -> assertThat(generate.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(resetAndGenerate.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(generator.get())
                        .isEqualTo(Direction.LEFT),
                () -> assertThat(resetAndGenerate.get())
                        .isEqualTo(Direction.RIGHT)
        );
    }
}
