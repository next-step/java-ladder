package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomDrawStrategyTest {

    static class StaticTrueRandom extends Random {
        @Override
        public int nextInt(int bound) {
            return 2;
        }
    }

    static class StaticFalseRandom extends Random {
        @Override
        public int nextInt(int bound) {
            return 0;
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("라인 그리기")
    void drawLineTest(int input) {
        DrawStrategy drawStrategy = new RandomDrawStrategy(new StaticTrueRandom());
        boolean result = drawStrategy.draw(input, false);

        assertThat(result)
                .isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("라인 그리지 않음")
    void notDrawLineTest(int input) {
        DrawStrategy drawStrategy = new RandomDrawStrategy(new StaticFalseRandom());
        boolean result = drawStrategy.draw(input, false);

        assertThat(result)
                .isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("직전 라인이 그려졌을 때 라인 그리지 않음")
    void previousTrueNextFalseTest(int input) {
        DrawStrategy drawStrategy = new RandomDrawStrategy();
        boolean result = drawStrategy.draw(input, true);

        assertThat(result)
                .isFalse();
    }

}
