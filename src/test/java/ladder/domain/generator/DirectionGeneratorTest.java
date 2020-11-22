package ladder.domain.generator;

import ladder.domain.model.Direction;
import ladder.strategy.FalseStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DirectionGeneratorTest {

    @Test
    @DisplayName("RIGHT 이후에는 항상 LEFT 가 나오는지 테스트")
    void generate() {
        DirectionGenerator generator = new DirectionGenerator(FalseStrategy.getInstance());
        assertAll(
                () -> assertThat(generator.generate(true))
                        .isEqualTo(Direction.DOWN),
                () -> assertThat(generator.generate())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(generator.generate())
                        .isEqualTo(Direction.LEFT),
                () -> assertThat(generator.generate())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(generator.generate(true))
                        .isEqualTo(Direction.LEFT)
        );
    }

    @Test
    @DisplayName("reset 을 하면 DOWN 으로 초기화 되는 테스트")
    void reset() {
        DirectionGenerator generator = new DirectionGenerator(FalseStrategy.getInstance());
        /**
         * FIXME: 익명 람다 함수를 바로 실행 시킬 수는 없나?
         * 가령 (() -> generator.generate())()
         * (() -> generator.generate()).get() 같은 표현은 불가능하나?
         */
        Supplier<Direction> generate = () -> generator.generate();
        Supplier<Direction> resetAndGenerate = () -> {
            generator.reset();
            return generator.generate();
        };
        assertAll(
                () -> assertThat(generate.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(resetAndGenerate.get())
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(generator.generate())
                        .isEqualTo(Direction.LEFT),
                () -> assertThat(resetAndGenerate.get())
                        .isEqualTo(Direction.RIGHT)
        );
    }
}
